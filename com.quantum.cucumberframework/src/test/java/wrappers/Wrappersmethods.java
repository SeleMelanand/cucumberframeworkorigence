package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Wrappersmethods {

	public static RemoteWebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static String status;
	
	protected static ExtentTest test;
	protected static ExtentHtmlReporter html;
	protected static ExtentReports extent;
	
	public static String filepath;
	public static String testcasename;


	public void launchchrome() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void loadconfigdata() throws Exception {
		prop = new Properties();
		fis = new FileInputStream(".//config-files/object.properties");
		prop.load(fis);
	}

	public void logout() {
		try {
			driver.findElementByXPath(prop.getProperty("logout.xpath")).click();
		} catch (Exception e) {
			System.out.println("Application not looged in");
		}
	}

	/*public void reporter(String description) throws WebDriverException, IOException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy/ss");
		Date date = new Date();
		String currentdate = dateFormat.format(date);
		String dateformat = currentdate.replace("/", "");
		filepath = dateformat + ".jpeg";

		FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),
				new File("./reports/images/" + dateformat + ".jpg"));

		test.addScreenCapture("./../reports/" + filepath);

		if (status.equalsIgnoreCase("pass")) {
			test.log(LogStatus.PASS, "Testcase passed successfully");
		} else {
			test.log(LogStatus.FAIL, description + "Testcase Failed!!!!!");

		}

	}*/

	public String datenumbergeneration() {

		DateFormat df = new SimpleDateFormat("MMddyyyyHHmm");
		Date d = new Date();
		String rannumber = df.format(d);
		return rannumber;

	}
	
	/*public static void htmlreportgen() {
		html = new ExtentHtmlReporter("./reports/smoketestresult102019.html");
		html.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(html);
	}*/

	/*public static void htmltestgen() {
		test = extent.createTest(testcasename);
		test.assignAuthor("Anand");
		test.assignCategory("sanity");
	}*/

}