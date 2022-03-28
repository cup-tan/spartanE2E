package spartan.testbase.spartanUIPage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spartan.basepage.AddSpartanPage;
import spartan.basepage.SpartanDataPage;
import spartan.basepage.SpartanHomePage;
import spartan.basepage.SpartanUIPage;
import spartan.utilities.ConfigurationReader;
import spartan.utilities.Driver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class SpartanAddDataTest {

    AddSpartanPage addSpartan = new AddSpartanPage();
    SpartanDataPage spartanData = new SpartanDataPage();
    SpartanHomePage homePage = new SpartanHomePage();
    SpartanUIPage spartanUIPage = new SpartanUIPage();
    WebDriver driver = Driver.getDriver();

    @BeforeMethod
    public void setUp(){
        driver.get(ConfigurationReader.getProperty("spartanURL"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void addNewData(){
        // home page
        homePage.getWebDataButton().click();
        // Web data page to add Spartan
        spartanUIPage.getAddSpartanButton().click();
        addSpartan.getNameInput().sendKeys("Spartacus");

        Select dropdownGender = new Select(driver.findElement(By.id("genderSelect")));
        dropdownGender.selectByValue("Male");

        addSpartan.getPhoneInput().sendKeys("2345678484");
        addSpartan.getSubmitButton().click();

        String actualResult =  spartanData.getSuccessMessage().getText();
        String expectedResult ="Successfully Added new Data!";

        Assert.assertEquals(actualResult,expectedResult,"invalid Spartan data");
        Driver.closeDriver();
    }

   @Test
    public void verifyNewSpartanData() {
        homePage.getWebDataButton().click();
      // home page
       List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='myTable']//td[2]"));
       for (WebElement eachName : allNames){
           System.out.println("Name: " + eachName.getText());
       }
       Driver.closeDriver();
    }

//    @AfterMethod
//    public void tearDown(){
//        Driver.closeDriver();
//    }
}
