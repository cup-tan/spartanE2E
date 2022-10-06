package crm24.basePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import spartan.utilities.Driver;

public class TaskPage {

    public TaskPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='ACTION[0][ARGUMENTS][data][TITLE]']")
    private WebElement thingToDoBox;

    @FindBy(css = "[id='tasks-task-priority-cb']")
    private WebElement highPriorityCheckBox;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    private WebElement iframe;

    @FindBy(xpath = "//span[@id='bx-b-uploadfile-task-form-lifefeed_task_form']")
    private WebElement uploadFiles;

    @FindBy(xpath = "//a[@class='js-id-tdp-mem-sel-is-open-form task-form-field-when-filled task-form-field-link add']")
    private WebElement addMorePerson;

    @FindBy(xpath = "//a[@id='destEmailTab_1597921300']")
    private WebElement emailUsers;

    @FindBy(xpath = "//input[@id='name-selector-1347974222']")
    private WebElement responsiblePersonBox;

    @FindBy(xpath = "//input[@id='//input[@id='invite_email_user_name']']")
    private WebElement nameBoxForMail;

    @FindBy(xpath = "//input[@id='invite_email_user_last_name']")
    private WebElement lastNameBoxForMail;

    @FindBy(xpath = "//span[@id='invite_email_user_button']")
    private WebElement okButton;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    private WebElement sendButton;

    public WebElement getSendButton() {
        return sendButton;
    }

    public WebElement getOkButton() {
        return okButton;
    }

    public WebElement getNameBoxForMail() {
        return nameBoxForMail;
    }

    public WebElement getLastNameBoxForMail() {
        return lastNameBoxForMail;
    }

    public WebElement getThingToDoBox() {
        return thingToDoBox;
    }

    public WebElement getHighPriorityCheckBox() {
        return highPriorityCheckBox;
    }

    public WebElement getIframe() {
        return iframe;
    }

    public WebElement getUploadFiles() {
        return uploadFiles;
    }

    public WebElement getAddMorePerson() {
        return addMorePerson;
    }

    public WebElement getEmailUsers() {
        return emailUsers;
    }

    public WebElement getResponsiblePersonBox() {
        return responsiblePersonBox;
    }
}
