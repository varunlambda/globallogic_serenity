import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
features = {"/Users/varunkumarb/Downloads/autotest-web/src/test/resources/features/Login/LogintoApplication.feature"},
plugin = {"json:/Users/varunkumarb/Downloads/autotest-web/target/cucumber-parallel/1.json"},
monochrome = false,
glue = {"starter.hooks", "starter.stepdefinitions"})
public class Parallel01IT {
}