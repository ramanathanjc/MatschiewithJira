package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "./src/test/java/features/",glue = {"stepdefinition","hooks"},monochrome = true,publish=true)
public class runTest extends AbstractTestNGCucumberTests{

}