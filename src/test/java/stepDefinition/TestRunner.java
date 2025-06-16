package stepDefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/feature_files", monochrome = true,
        glue = "stepDefinition",
        plugin = {"pretty",
                   "html:target/cucumber-reports.html",
                     "json:target/cucumber.json",
                        "junit:target/cucumber.xml"
        }, tags="@TesttorunNext5567" // or "@regressionTest"

)
public class TestRunner {
}
