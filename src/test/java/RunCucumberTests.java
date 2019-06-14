


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = false, features = "src/test/resources/features" ,
        plugin = {"json:target/cucumber.json"})

public class RunCucumberTests {
}
