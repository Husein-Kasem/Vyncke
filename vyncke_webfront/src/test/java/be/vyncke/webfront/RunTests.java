package be.vyncke.webfront;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/be.vyncke.webfront",
        format={"pretty", "html:target/cucumber"},
        tags={"~@skip"})
public class RunTests {
}
