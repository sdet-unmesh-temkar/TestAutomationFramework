package org.naukriAutomation.tests.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.naukriAutomation.webdrivermanager.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Hooks {

    @Before
    public void setUp() {
        // Initialize driver based on parameter
        String browser = System.getProperty("browser", "chrome"); // Default to Chrome if no parameter is provided
        DriverFactory.initDriver(browser);
        WebDriver driver = DriverFactory.getDriver();

        // Common setup
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
