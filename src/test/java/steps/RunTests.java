package steps;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

// to see it more visible
@RunWith(Cucumber.class)
@CucumberOptions (features = {"src/test/resources"}, glue = {"steps"}, plugin = {"pretty"})

public class RunTests {
}
