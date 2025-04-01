package starter.Pages.kastleDirectPages.KDHomePage;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.DefaultConfig;
import utilities.EnvironmentPropertiesUtils;


import java.sql.SQLException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@Slf4j
public class KDHomePage extends PageObject {
    private static final Logger log = LoggerFactory.getLogger(KDHomePage.class);

    @FindBy(className = "userInfo")
    WebElementFacade userInfo;

    @Step
    public void openApplication(String appName) {
        String baseUrl = EnvironmentPropertiesUtils.getPropertyOrDefault("baseUrl", null);
        Map<String, String> appPaths = new HashMap<>();
        appPaths.put("kastlesDirect", DefaultConfig.ApplicationPaths.kastlesDirect);


        String appPath = appPaths.get(appName);
        log.info("App Path: " + appPath);
        if (appPath == null) {
            throw new IllegalArgumentException("Invalid application name: " + appName);
        }

        String fullUrl = baseUrl + "/" + appPath;
        openUrl(fullUrl);
        log.info(appName + " application opened at URL: " + fullUrl);
        getDriver().manage().window().maximize();
    }



}
