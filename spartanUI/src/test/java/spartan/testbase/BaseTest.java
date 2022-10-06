package spartan.testbase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import spartan.utilities.ConfigurationReader;
import spartan.utilities.Driver;

public class BaseTest  {
    WebDriver driver = Driver.getDriver();
    @BeforeClass
    public void setUp() {
        driver.get(ConfigurationReader.getProperty("spartan.base_url"));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}
