package crm24.basePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import spartan.utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

 @FindBy(xpath = "//input[@name='USER_LOGIN']")
 private WebElement usernameBox;

 @FindBy(name = "//input[@name='USER_PASSWORD']")
   private WebElement passwordBox;

 @FindBy(xpath = "//input[@class='login-btn']")
    private WebElement logInButton;

    public WebElement getUsernameBox() {
        return usernameBox;
    }

    public WebElement getPasswordBox() {
        return passwordBox;
    }

    public WebElement getLogInButton() {
        return logInButton;
    }
}
