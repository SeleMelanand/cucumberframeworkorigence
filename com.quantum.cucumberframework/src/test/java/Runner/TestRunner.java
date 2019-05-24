package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features ="src/test/java/features/quickappcreation.feature", //path of the feature file 
		glue= {"stepDefinition"} //path of the stepdefinition file 
		) 


public class TestRunner {
	

}
