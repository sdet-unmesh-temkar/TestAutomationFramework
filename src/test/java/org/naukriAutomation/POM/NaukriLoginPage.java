package java.org.naukriAutomation.POM;

import naukriUpdate.utils.ChromeDriverManager;
import naukriUpdate.utils.ElementInteractions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaukriLoginPage {

    @FindBy(id = "login_Layer") private WebElement loginButton;

    @FindBy(xpath = "//input[@placeholder=\"Enter your active Email ID / Username\"]") private WebElement username;

    @FindBy(xpath = "//input[@placeholder=\"Enter your password\"]") private WebElement password;

    @FindBy(xpath = "//button[text()=\"Login\"]") private WebElement signIn;

    private final ChromeDriverManager chromeDriverManager = new ChromeDriverManager();

    public NaukriLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickLoginBtn() {
        ElementInteractions.highlightElement(chromeDriverManager.getDriver(), loginButton);
        loginButton.click();
    }

    public void enterUserName(String userName){
        ElementInteractions.highlightElement(chromeDriverManager.getDriver(), username);
        username.sendKeys(userName);
    }

    public void enterPassWord(String passWord){
        ElementInteractions.highlightElement(chromeDriverManager.getDriver(), password);
        password.sendKeys(passWord);
    }

    public void clickOnSignIn(){
        ElementInteractions.highlightElement(chromeDriverManager.getDriver(), signIn);
        signIn.click();
    }
}
