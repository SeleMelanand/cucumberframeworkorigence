package wrappers;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Wrappersmethods {
	
	public static RemoteWebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;

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
}