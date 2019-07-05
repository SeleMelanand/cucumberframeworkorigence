package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(	
		features ="src/test/java/features/loginOrigence.feature", //path of the feature file 
		glue= {"stepDefinition","hooks"}, //path of the stepdefinition file 
		monochrome=true,//to display the console putput in a proper readable format 
		dryRun=false,// by default iSt will be false.  set as true : without execution, it will check mapping is proper between stepdefiniton and feature file
					//strict=true //execute the testcase but it will fail the test method as Implement me 
		tags = {"@Datadriventest","~@smoketest", "~@Negativetest"}// ~ symbol is used mainy not to run the test scenarios which are marked in that name
		)

public class TestRunner {
	

}
