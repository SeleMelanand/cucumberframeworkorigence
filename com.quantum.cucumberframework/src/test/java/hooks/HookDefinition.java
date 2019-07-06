package hooks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.quantum.cucumberframework.wrappermethods.semethods;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HookDefinition extends semethods{


	@Before
	public void login() {
		//System.out.println("Executed before main test case");
		launchchrome();
		
	}
	@After
	public void logout() {

		System.out.println("Executed after main test case");

	}

}
