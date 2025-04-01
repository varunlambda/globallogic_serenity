package utilities;

public class DefaultConfig {
    public static class ApplicationPaths {
        public final static String kastlesDirect = EnvironmentPropertiesUtils.getPropertyOrDefault("kastlesDirect", "KastleDirect");

    }
}
