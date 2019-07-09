package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import wrappers.Reporterwrapper;

public class HooksDefinition extends Reporterwrapper {

	@Before
	public void chromebrowserlaunch() throws Exception {
		loadconfigdata();
		launchchrome();
		htmlreportgenerator();
		author = "Anand. S";
		category = "End to end flow";
		System.out.println("Before method executed successfuly");

	}

	@After
	public void applicationlogout() {
		logout();
		reportclose();

	}
	

}
