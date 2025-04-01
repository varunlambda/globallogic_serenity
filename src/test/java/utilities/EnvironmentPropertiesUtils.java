package utilities;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class EnvironmentPropertiesUtils {

    private static final ConcurrentHashMap<String, String> properties = new ConcurrentHashMap<>();

    static {
        try {
            loadProperties();
        } catch (IOException e) {
            throw new ExceptionInInitializerError("Failed to load properties: " + e.getMessage());
        }
    }

    private static void loadProperties() throws IOException {
        String environment = System.getProperty("environment", "aks-int");
        Path customPath = Paths.get(System.getProperty("user.dir"), "src/test/resources/configuration", "serenity-" + environment + ".properties");
        try (FileInputStream inputStream = new FileInputStream(customPath.toFile())) {
            Properties tempProperties = new Properties();
            tempProperties.load(inputStream);
            tempProperties.forEach((key, value) -> properties.put((String) key, (String) value));
        }
    }

    /** Get property with Azure Variable Group override
    * Check Azure DevOps (environment variables)
    * Check system properties (e.g., passed via -Dkey=value)
    * Check properties file loaded by EnvironmentUtils
    * Fallback to the default value **/
    @SneakyThrows
    public static String getPropertyOrDefault(String key, String defaultValue) {
        return System.getenv(key) != null && !System.getenv(key).isEmpty() ? System.getenv(key) :
                System.getProperty(key) != null && !System.getProperty(key).isEmpty() ? System.getProperty(key) :
                        properties.get(key) != null && !properties.get(key).isEmpty() ? properties.get(key) :
                                defaultValue;
    }
}