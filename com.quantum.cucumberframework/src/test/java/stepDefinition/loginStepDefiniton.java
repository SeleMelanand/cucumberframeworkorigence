package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginStepDefiniton {
	WebDriver driver; 
	
	
	@Given("Open the browser using the URL")
	public void OpenthebrowserusingtheURL() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://quantumwebdev4.dev.apps.pcf.nonprod.cudirect.com");
	}
	
	@When("title of login page is Login to Application")
	public void titleofloginpageisLogintoApplication() {
		String titlename = driver.getTitle();
		System.out.println("title name is : "+ titlename);
		Assert.assertEquals(titlename, "Login to Application");
		
	}
	
	@And("Enter \"(.*)\"")
	public void Enterusername(String uname) {
		driver.findElement(By.id("ctl00_cphContent_UserName")).sendKeys(uname);
	}
	
	@And("Click login")
	public void clicklogin() {
		driver.findElement(By.id("ctl00_cphContent_LoginButton")).click();;
	}
	
	@Then("Verify loginname")
	public void Verfiyloginname() {
		String validationmessage = driver.findElement(By.xpath("//div[@id='NewHeader1']//tr/td[4]//td[3]//tr[1]/td")).getText();
		Assert.assertEquals(validationmessage, "Michael Farris");
	}
	
	@Then("Verify validation message \"(.*)\"")
	public void validationmessage(String message) {
		String validationmessage = driver.findElement(By.xpath("//div[@id='ctl00_cphContent_pnlSignOn']//table//table//tr[9]//span")).getText();
		Assert.assertEquals(validationmessage, message);
	}

}
