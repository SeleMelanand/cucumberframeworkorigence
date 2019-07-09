package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import wrappers.Reporterwrapper;
import wrappers.Wrappersmethods;

public class loginStepDefiniton extends Reporterwrapper {
	
	@Given("Open the browser using the URL")
	public void OpenthebrowserusingtheURL() {

		driver.get("https://quantumwebdev4.dev.apps.pcf.nonprod.cudirect.com");
		driver.get(prop.getProperty("application.url"));
	}

	@When("title of login page is Login to Application")
	public void titleofloginpageisLogintoApplication() throws IOException {
		String titlename = driver.getTitle();
		System.out.println("title name is : " + titlename);
		Assert.assertEquals(titlename, "Login to Application");	
	}

	@And("Enter uname (.*)")
	public void Enterusername(String uname) {
		driver.findElement(By.id(prop.getProperty("username.id"))).sendKeys(uname);

	}

	@And("Enter password (.*)")
	public void Enterpassword(String passcode) {
		driver.findElement(By.id(prop.getProperty("password.id"))).sendKeys(passcode);
	}

	@And("Click login")
	public void clicklogin() {
		driver.findElement(By.id(prop.getProperty("login.id"))).click();

	}

	@Then("Verify loginname (.*)")
	public void Verfiyloginname(String loginuser) throws InterruptedException, IOException {
		status = "pass";
		testcasename = "loginfunctionalityverification";
		Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("welcomeori.xpath"))).click();

		/*System.out.println(status);
		System.out.println(testcasename);
		System.out.println(category);
		System.out.println(author);*/
		
		String validationmessage = driver.findElement(By.xpath(prop.getProperty("username.xpath"))).getText();
		try {
			Assert.assertEquals(validationmessage, loginuser);
			System.out.println("Both the names are same");
			
			teststep();
		} catch (Exception e) {
			System.out.println("Both the username are different");

			status = "fail";
			teststep();

		}

	}

	@Then("Verify validation message (.*)")
	public void validationmessage(String message) {
		String validationmessage = driver
				.findElement(By.xpath("//div[@id='ctl00_cphContent_pnlSignOn']//table//table//tr[9]//span")).getText();
		Assert.assertEquals(validationmessage, message);
	}

}
