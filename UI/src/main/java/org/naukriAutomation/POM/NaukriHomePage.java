package org.naukriAutomation.POM;

import org.naukriAutomation.webdrivermanager.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NaukriHomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class=\"view-profile-wrapper\"]/a")
    private WebElement viewProfileBtn;

    public NaukriHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickViewProfileButton() {
        wait.until(ExpectedConditions.visibilityOf(viewProfileBtn));
        viewProfileBtn.click();
    }
}