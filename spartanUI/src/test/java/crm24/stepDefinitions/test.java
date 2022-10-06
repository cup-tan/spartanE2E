package crm24.stepDefinitions;

import crm24.basePage.HomePage;
import crm24.basePage.LoginPage;
import crm24.basePage.TaskPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import spartan.utilities.ConfigurationReader;
import spartan.utilities.Driver;

public class test {
    WebDriver driver = Driver.getDriver();
LoginPage loginPage = new LoginPage();
HomePage homePage = new HomePage();
TaskPage taskPage = new TaskPage();

    @Given("go to crm login page")
    public void go_to_crm_login_page() {
        driver.get(ConfigurationReader.getProperty("crm.url"));
        loginPage.getUsernameBox().sendKeys(ConfigurationReader.getProperty("crm.username"));
        loginPage.getPasswordBox().sendKeys(ConfigurationReader.getProperty("crm.password"));
        loginPage.getLogInButton().click();
    }
    @When("should be clickable task module on homePage")
    public void should_be_clickable_task_module_on_home_page() {
        homePage.getTaskModule().click();

        Assert.assertTrue( taskPage.getThingToDoBox().isDisplayed());
    }

    @When("should be written in thing to do")
    public void should_be_written_in_thing_to_do() {
      taskPage.getThingToDoBox().sendKeys("Important message");

    }
    @When("click high priority checkBox")
    public void click_high_priority_check_box() {
        taskPage.getHighPriorityCheckBox().click();
        Assert.assertTrue(taskPage.getHighPriorityCheckBox().isSelected());
    }
    @When("click addMore and add {string}")
    public void click_add_more_and_add(String string) {
     taskPage.getAddMorePerson().click();
     taskPage.getEmailUsers().click();
      taskPage.getResponsiblePersonBox().sendKeys(string);
      taskPage.getNameBoxForMail().sendKeys("asl");
      taskPage.getLastNameBoxForMail().sendKeys("bas");
     taskPage.getOkButton().click();
    }


    @Given("click send Button")
    public void click_send_button() {
     taskPage.getSendButton().click();

    }
    @Then("verify new task if it is displayed on home page")
    public void verify_new_task_if_it_is_displayed_on_home_page() {

    }
}
