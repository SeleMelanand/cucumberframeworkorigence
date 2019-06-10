package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features ="src/test/java/features/login.feature", //path of the feature file 
		glue= {"stepDefinition" }, //path of the stepdefinition file 
		monochrome=true,//to display the console putput in a proper readable format 
		dryRun=true// before execution starts, it will check mapping is proper between stepdefiniton and feature file
		//strict=true //execute the testcase but it will fail the test method as Implement me 
		)

public class TestRunner {
	

}
