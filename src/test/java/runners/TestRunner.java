package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith (Cucumber.class)
@CucumberOptions(

        features = "src/main/resources/features",
        glue = "stepdefinitions",
        plugin = { "pretty", "html:target/cucumber-reports/project-report" },
        monochrome = true,
        tags = "@Regression"

)
public class TestRunner {
}
