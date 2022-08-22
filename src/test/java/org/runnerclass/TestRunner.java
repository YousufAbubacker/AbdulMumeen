package org.runnerclass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\moham\\eclipse-workspace\\Cucumber10.00Am\\src\\test\\resources\\FeatureFiles", glue = "org.stepdefinition", dryRun = false)
public class TestRunner {

}
