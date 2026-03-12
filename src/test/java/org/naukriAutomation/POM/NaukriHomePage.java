package java.org.naukriAutomation.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaukriHomePage {

    @FindBy(xpath = "//div[@class=\"view-profile-wrapper\"]/a")
    private WebElement viewProfileBtn;

    public NaukriHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickViewProfileButton() {
        viewProfileBtn.click();
    }
}