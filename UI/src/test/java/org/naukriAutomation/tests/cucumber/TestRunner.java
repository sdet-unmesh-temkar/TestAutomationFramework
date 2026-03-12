package org.naukriAutomation.tests.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/test/resources/features",
        tags = "@updateNaukriProfile",
        glue = {"org.naukriAutomation.tests.cucumber"},
        plugin = {
                "pretty",
                "html:target/cucumber-html-report.html",
                "json:target/cucumber.json"
        },
        dryRun = true,
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public void setupBeforeClass() {
        System.out.println("Setting up before class...");
    }

    @AfterClass
    public void setupAfterClass() {
        System.out.println("Setting up after class...");
    }
}
