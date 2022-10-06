package crm24.stepDefinitions;//    hook before = @BeforeMethod in TestNG
//    hook after = @AfterMethod in TestNG
//    it's not a good idea to mix implicit and explicit waits. It can lead to unexpectedly long waits.
//    usually, we just use explicit and fluent waits.

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import spartan.utilities.Driver;
import java.util.concurrent.TimeUnit;

public class Hooks {

@Before
public void setup(Scenario scenario) {
        System.out.println("::: Starting Automation:::");
       // Driver.getDriver().get(ConfigurationReader.getProperty("crm.url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


}

@After
public void tearDown(Scenario scenario) {
        //close browser, close DB connection, close tunnel,capture screenshot of the error, etc..
        //this is a hook after
        //runs automatically after every test
        if (scenario.isFailed()) {
        byte[] data = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(data, "image/png", scenario.getName());
        }

        Driver.closeDriver();
        System.out.println(":::(^_^) End of test execution (*_*):::");

        }
}