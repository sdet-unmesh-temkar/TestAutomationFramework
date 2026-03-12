package org.naukriAutomation.tests;

import org.naukriAutomation.Listener.TestListener;
import org.naukriAutomation.POM.NaukriHomePage;
import org.naukriAutomation.POM.NaukriLoginPage;
import org.naukriAutomation.webdrivermanager.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;

@Listeners(TestListener.class)
public class NaukriAppUpdateAutomationTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private NaukriLoginPage loginPage;
    private NaukriHomePage homePage;

    public void openApp() {
        driver.get("https://www.naukri.com/");
    }

    public void login(String userName, String passWord) {
        loginPage.clickLoginBtn();
        loginPage.enterUserName(userName);
        loginPage.enterPassWord(passWord);
        loginPage.clickOnSignIn();
    }

    public void viewProfile() {
        homePage.clickViewProfileButton();
        wait.until(ExpectedConditions.titleIs("Profile | Mynaukri"));
    }

    public void editResumeHeadline() {
        WebElement editResumeHeadline = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"Resume headline\"]/following-sibling::span")));
        editResumeHeadline.click();

        WebElement resumeHeadlineTxt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resumeHeadlineTxt")));
        String resumeHeadlineText = resumeHeadlineTxt.getAttribute("value");
        assert resumeHeadlineText != null;
        char lastChar = resumeHeadlineText.charAt(resumeHeadlineText.length() - 1);

        if (lastChar == '.') {
            resumeHeadlineText = resumeHeadlineText.substring(0, resumeHeadlineText.length() - 1);
            resumeHeadlineTxt.clear();
            resumeHeadlineTxt.sendKeys(resumeHeadlineText);
        } else {
            resumeHeadlineText = resumeHeadlineText.concat(".");
            resumeHeadlineTxt.clear();
            resumeHeadlineTxt.sendKeys(resumeHeadlineText);
        }

        wait.until(ExpectedConditions.attributeToBe(resumeHeadlineTxt, "value", resumeHeadlineText));
        Assert.assertEquals(resumeHeadlineText, resumeHeadlineTxt.getAttribute("value"));
    }

    public void saveProfile() {
        WebElement saveBtn = driver.findElement(By.xpath("//button[text()=\"Save\"]"));
        saveBtn.click();
        WebElement profileUpdateMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=\"Profile updated successfully\" and @class=\"success-text\"]")));
        //capture screenshot for profile updated successfully:
        try {
            //create screenshot dir under target:
            File screenshotDir = new File("target/screenshots");
            if (!screenshotDir.exists()) {
                screenshotDir.mkdir();
            }
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(src, new File("target" + File.separator + "screenshots" + File.separator + "profileUpdate.jpg"));
        } catch (Exception e) {
            System.out.println(e);
        }
        Assert.assertEquals(profileUpdateMsg.getText(), "Profile updated successfully");
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("chrome"))
            DriverFactory.initDriver("chrome");
        if (browser.equalsIgnoreCase("edge"))
            DriverFactory.initDriver("edge");
        if (browser.equalsIgnoreCase("firefox"))
            DriverFactory.initDriver("firefox");

        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        loginPage = new NaukriLoginPage(driver);
        homePage = new NaukriHomePage(driver);
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        return new Object[][]{
                {"unmeshtemkar@zohomail.in", "1995@umaaa"}
        };
    }

    @Test(dataProvider = "loginData")
    public void updateResumeHeadline(String username, String password) {
        openApp();
        login(username, password);
        viewProfile();
        editResumeHeadline();
        saveProfile();
    }

    @AfterMethod
    public void quitApp() {
        DriverFactory.quitDriver();
    }
}