package starter.stepdefinitions.kastleDirectStepDefs.KDHomeStepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.annotations.Steps;
import net.thucydides.core.webdriver.DevToolsWebDriverFacade;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.remote.RemoteWebDriver;
import starter.Pages.kastleDirectPages.KDHomePage.KDHomePage;

@Slf4j
public class KDHomeStepDef {
    @Steps
    KDHomePage kastlesDirectHomePage;
    private RemoteWebDriver remoteWebDriver;

    @Before
    public void beforeScenario(Scenario scenario) {
        String scenarioName = scenario.getName();

        String buildName = System.getProperty("LT_BUILD_NAME", System.getenv("LT_BUILD_NAME"));

        // Get the current WebDriver instance
        remoteWebDriver = (RemoteWebDriver) ((DevToolsWebDriverFacade) ThucydidesWebDriverSupport.getDriver()).getProxiedDriver();
       
        // Update session name on LambdaTest
        remoteWebDriver.executeScript("lambda-name=" + scenarioName);
        // updating the build name
        remoteWebDriver.executeScript("lambda-build=" + buildName);
    }

    @Given("user open {string} application")
    public void userOpenApplication(String appname) {
        kastlesDirectHomePage.openApplication(appname);
    }

}
