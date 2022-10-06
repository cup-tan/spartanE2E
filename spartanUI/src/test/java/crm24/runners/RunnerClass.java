package crm24.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"},
        features ="src/test/resources/features",
        glue = "src/test/java/crm24/stepDefinitions",
        tags = "@smoke",
       // publish = true,
        dryRun = false
)

public class RunnerClass {

}