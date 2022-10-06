package crm24.basePage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import spartan.utilities.Driver;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

 @FindBy(xpath = "//span[text()='Task']")
    private WebElement taskModule;

    public WebElement getTaskModule() {
        return taskModule;
    }
}
