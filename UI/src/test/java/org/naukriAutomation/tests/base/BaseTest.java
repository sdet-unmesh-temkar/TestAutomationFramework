package org.naukriAutomation.tests.base;

import org.naukriAutomation.webdrivermanager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        // Initialize driver based on parameter
        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();

        // Common setup
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
