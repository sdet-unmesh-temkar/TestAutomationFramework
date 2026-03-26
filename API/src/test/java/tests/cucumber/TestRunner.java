package tests.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@scenarioParallel",
        glue = {"tests.cucumber"},
        plugin = {"pretty", "html:target/cucumber-html-report.html", "json:target/cucumber.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    //for running cucumber scenarios in parallel, add below snippet and then in maven surefire plugin config section update configuration
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}