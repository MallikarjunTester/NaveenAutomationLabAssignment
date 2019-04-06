package naveenautomationLabs.assessment1;

import org.testng.Assert;

public class Utilities {

	
	public static boolean assertValues(String actual, String expected) {
		try {
			Assert.assertEquals(actual, expected);
			return true;
		}catch(Exception e) {
			return false;
			
		}
		
	}

}
