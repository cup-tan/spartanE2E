package spartan.basepage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import spartan.utilities.Driver;

public class SpartanHomePage {

   public SpartanHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//i[@class='fas fa-users']")
    private WebElement webDataButton;

    public WebElement getWebDataButton() {
        return webDataButton;
    }
}
