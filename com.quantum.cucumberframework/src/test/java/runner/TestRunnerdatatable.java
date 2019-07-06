package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/test/java/features/loginOrigence.feature"}, //path of the feature file 
		glue= {"stepDefinition","hooks"}, //path of the stepdefinition file 
		monochrome=true,//to display the console putput in a proper readable format 
		dryRun=false, // by default it will be false.  set as true : without execution, it will check mapping is proper between stepdefiniton and feature file
		//strict=true //execute the testcase but it will fail the test method as Implement me 
		tags = {"@Sanity"}// run only the sanity testcases
		)

public class TestRunnerdatatable {
	

}





/* Nmae of the class file ------>TestRunner.Java



package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = {"src/test/java/features/loginOrigence.feature"}, //path of the feature file 
		glue= {"stepDefinition" }, //path of the stepdefinition file 
		monochrome=true,//to display the console putput in a proper readable format 
		dryRun=false// by default it will be false.  set as true : without execution, it will check mapping is proper between stepdefiniton and feature file
		//strict=true //execute the testcase but it will fail the test method as Implement me 
		)

public class TestRunner {
	

}*/

