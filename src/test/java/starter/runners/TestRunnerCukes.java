package starter.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"starter.stepdefinitions", "starter.hooks"},
        tags = "@Test",
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "rerun:target/cucumber-reports/failedRerun.txt"
        })

public class TestRunnerCukes {

}