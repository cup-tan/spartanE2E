package spartan.basepage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import spartan.utilities.Driver;

import javax.sound.midi.MidiDevice;

public class AddSpartanPage {
    public AddSpartanPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "genderSelect")
    private WebElement genderInput;

    @FindBy(id = "phone")
    private  WebElement phoneInput;

    @FindBy(id = "submit_btn")
    private WebElement submitButton;



    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getGenderInput() {
        return genderInput;
    }

    public WebElement getPhoneInput() {
        return phoneInput;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }
}
