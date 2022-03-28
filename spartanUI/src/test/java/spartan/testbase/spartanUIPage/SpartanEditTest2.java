package spartan.testbase.spartanUIPage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spartan.basepage.SpartanHomePage;
import spartan.basepage.SpartanUIPage;
import spartan.utilities.ConfigurationReader;
import spartan.utilities.Driver;


public class SpartanEditTest2 {
    SpartanHomePage homePage = new SpartanHomePage();
    SpartanUIPage spartanUIPage = new SpartanUIPage();
   WebDriver driver = Driver.getDriver();
    @BeforeMethod
    public void setUp(){
        driver.get(ConfigurationReader.getProperty("spartanURL"));
        driver.manage().window().maximize();
      //  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void addSpartanTest() throws InterruptedException {

        Thread.sleep(1000);
     homePage.getWebDataButton().click();

        driver.close();

    }
//    @AfterMethod
//    public void  tearDown(){
//            Driver.closeDriver();
//        }

    }



