package spartan.basepage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import spartan.utilities.Driver;

public class SpartanDataPage {
    public SpartanDataPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='alert alert-success']")
    private WebElement successMessage;

    @FindBy(linkText = "Back to the List")
    private WebElement backToTheListLink;

    @FindBy(linkText = "Back to Home")
    private WebElement backToHomeLink;

    public WebElement getSuccessMessage() {
        return successMessage;
    }

    public WebElement getBackToTheListLink() {
        return backToTheListLink;
    }

    public WebElement getBackToHomeLink() {
        return backToHomeLink;
    }
}
