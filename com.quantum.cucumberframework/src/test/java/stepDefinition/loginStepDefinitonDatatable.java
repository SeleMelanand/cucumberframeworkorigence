package stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginStepDefinitonDatatable {
	WebDriver driver; 
	
	
	@Given("launching the url")
	public void OpenthebrowserusingtheURL() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://quantumwebdev4.dev.apps.pcf.nonprod.cudirect.com");
	}
	
	@When("title login page")
	public void titleofloginpageisLogintoApplication() {
		String titlename = driver.getTitle();
		System.out.println("title name is : "+ titlename);
		Assert.assertEquals(titlename, "Login to Application");
		
	}
	
	@And ("Enter unameandpassword") 
	public void Enterunameandpassword(DataTable usercreentials ) {
		List<List<String>> data = usercreentials.raw();
		driver.findElement(By.id("ctl00_cphContent_UserName")).sendKeys(data.get(0).get(0));
		driver.findElement(By.id("ctl00_cphContent_Password")).sendKeys(data.get(0).get(1));

	}

	@And("Click submit")
	public void clicklogin() {
		driver.findElement(By.id("ctl00_cphContent_LoginButton")).click();;
	}
	

}
