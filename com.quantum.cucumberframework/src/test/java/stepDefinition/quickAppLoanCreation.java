package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class quickAppLoanCreation {
	WebDriver driver;

	@Given("login as loanofficer")
	public void loginasloanofficer() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://quantumwebdev4.dev.apps.pcf.nonprod.cudirect.com");
		String titlename = driver.getTitle();
		System.out.println("title name is : " + titlename);
		Assert.assertEquals(titlename, "Login to Application");
		driver.findElement(By.id("ctl00_cphContent_UserName")).sendKeys("NYB\\MichaelFarris");
		driver.findElement(By.id("ctl00_cphContent_Password")).sendKeys("DelForMayor18!");
		driver.findElement(By.id("ctl00_cphContent_LoginButton")).click();

	}

	@When("confirm loan officer is loged in")
	public void confirmloanofficeruser() {
		String validationmessage = driver.findElement(By.xpath("//div[@id='NewHeader1']//tr/td[4]//td[3]//tr[1]/td"))
				.getText();
		Assert.assertEquals(validationmessage, "Michael Farris");

	}
	
	@And("Navigate to Quickapp page")
	public void gotoquickapppage() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("img_SalesmenuId"))).perform();
		action.moveToElement(driver.findElement(By.id("eOrigination_QuickApp"))).perform();	
		action.moveToElement(driver.findElement(By.id("QuickApp_QuickApp_Page"))).click().build().perform();
	}
	
	@And("Enter all necessary details and save")
	public void enteringloandetails() {
		driver.findElement(By.id("PrimaryBorrower_BorrowerFirstName_QQ_BorrowerFirstName_QQ")).sendKeys("Andy");
		driver.findElement(By.id("PrimaryBorrower_BorrowerLastName_QQ_BorrowerLastName_QQ")).sendKeys("America");		
		driver.findElement(By.id("PrimaryBorrower_SSNNo_SSNNo_New")).sendKeys("999603333");
		
		WebElement estficoscore = driver.findElement(By.id("PrimaryBorrower_EstimatedFICOScore_EstimatedFICOScore"));
		Select estficoscoredd = new Select(estficoscore);
		estficoscoredd.selectByVisibleText("Very Good: 750 - 799");
		
		driver.findElement(By.xpath("(//input[@id='PrimaryBorrower_FirstTimeHomeBuyer_FirstTimeHomeBuyer'])[2]/..")).click();
				
		WebElement propstate = driver.findElement(By.id("Property_PropertyState"));
		Select propstatedd = new Select(propstate);
		propstatedd.selectByVisibleText("CA");
				
		WebElement propcounty = driver.findElement(By.id("Property_PropertyCounty"));
		Select propcountydd = new Select(propcounty);
		propcountydd.selectByVisibleText("Contra Costa");
		
		WebElement proptype = driver.findElement(By.id("Property_PropertyType_PropertyType"));
		Select proptypedd = new Select(proptype);
		proptypedd.selectByVisibleText("SFR Attached");
		
		WebElement occutype = driver.findElement(By.id("Property_PropertyOccupancyType_PropertyOccupancyType"));
		Select occutypedd = new Select(occutype);
		occutypedd.selectByVisibleText("Primary Residence");
		
		WebElement loanpurpose = driver.findElement(By.id("Loan_LoanPurpose_LoanPurpose"));
		Select loanpurposedd = new Select(loanpurpose);
		loanpurposedd.selectByVisibleText("Purchase");
		
		driver.findElement(By.id("Property_EstimatedValue_EstimatedValue")).clear();		
		driver.findElement(By.id("Property_EstimatedValue_EstimatedValue")).sendKeys("700000");		

		driver.findElement(By.id("Loan_LoanAmount_LoanAmount")).clear();		
		driver.findElement(By.id("Loan_LoanAmount_LoanAmount")).sendKeys("500000",Keys.TAB);
		driver.findElement(By.xpath("(//input[@id='Loan_ExistingLoan_ExistingLoan'])[2]")).click();	
		
		driver.findElement(By.id("fwkSave")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='FilesummaryLoanNumber']/a"))));
		System.out.println("navigated to filesumamry page");
		
		

	}
	
	@Then("print generated loannumber")
	public void printloannumber() {
		
		String loannumbertext = driver.findElement(By.xpath("//div[@id='div1003Header']//td[1]")).getText();
		String loannum = loannumbertext.substring(27,47);
		System.out.println("Generated loan number is : "+ loannum);
		
	}
}
