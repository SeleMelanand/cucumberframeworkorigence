package stepDefinition;

<<<<<<< HEAD
import java.util.List;
import java.util.concurrent.TimeUnit;
=======
import java.io.IOException;
>>>>>>> branch 'master' of https://github.com/SeleMelanand/cucumberframeworkorigence.git

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.quantum.cucumberframework.wrappermethods.semethods;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import wrappers.Wrappersmethods;

<<<<<<< HEAD
public class loginStepDefiniton extends semethods{
=======
public class loginStepDefiniton extends Wrappersmethods {
>>>>>>> branch 'master' of https://github.com/SeleMelanand/cucumberframeworkorigence.git
	
	/*public loginStepDefiniton() throws IOException {
		prop.load(fis);
		
	}*/

	@Given("Open the browser using the URL")
	public void OpenthebrowserusingtheURL() {
<<<<<<< HEAD
		
		driver.get("https://quantumwebdev4.dev.apps.pcf.nonprod.cudirect.com");
=======
		driver.get(prop.getProperty("application.url"));
>>>>>>> branch 'master' of https://github.com/SeleMelanand/cucumberframeworkorigence.git
	}

	@When("title of login page is Login to Application")
	public void titleofloginpageisLogintoApplication() {
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
	public void Verfiyloginname(String loginuser) throws InterruptedException {
			Thread.sleep(5000);
			driver.findElement(By.xpath(prop.getProperty("welcomeori.xpath"))).click();
			
			String validationmessage = driver.findElement(By.xpath(prop.getProperty("username.xpath")))
					.getText();
			try {
				Assert.assertEquals(validationmessage, loginuser);
				System.out.println("Both the names are same");
			} catch (Exception e) {
				System.out.println("Both the username are different");
			}
		
	}
<<<<<<< HEAD
	
	

	
=======

>>>>>>> branch 'master' of https://github.com/SeleMelanand/cucumberframeworkorigence.git
	@Then("Verify validation message (.*)")
	public void validationmessage(String message) {
		String validationmessage = driver
				.findElement(By.xpath("//div[@id='ctl00_cphContent_pnlSignOn']//table//table//tr[9]//span")).getText();
		Assert.assertEquals(validationmessage, message);
	}

}
