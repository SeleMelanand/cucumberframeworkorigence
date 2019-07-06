package hooks;

import java.io.IOException;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import wrappers.Wrappersmethods;

public class HooksDefinition extends Wrappersmethods {

	@Before
	public void chromebrowserlaunch() throws Exception {
		loadconfigdata();
		launchchrome();
		System.out.println("Before method executed successfuly");

	}

	@After
	public void applicationlogout() {
		//screenshot needs to be taken
		
		logout();
		System.out.println("After method executed successfuly");
	}
	

}
