package naveenautomationLabs.assessment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WrapperMethods extends BaseClass {

	public boolean launchUrl(String url) {

		try {
			System.out.println("About to Launch the URL : "+ url );
			//Launch the URL :
			driver.get(url);
			return true;
		}catch(Exception e) {
			System.out.println("Not able to enter the URL : " +url );
			System.out.println("While Enter the URL " + e.getMessage());
			return false;
		}



	}
	
	public boolean click(WebElement element) {

		//System.out.println("About to click the element "+ element);
		try {
			element.click();
			return true;
		}catch(Exception e) {

			System.out.println("Failed to click on elment "+ element);
			System.out.println("Failed to click on element "+ e.getMessage());
			return false;

		}

	}
	
	public boolean sendKeys(WebElement element,String value) {
		try {
			element.sendKeys(value);
			return true;
		}catch (Exception e) {

			return false;
		}
	}

	public String getText(WebElement element) {
		
		 return element.getText();
		
	}
	
	public String getAttributeValue(WebElement element,String key) {
		
		return element.getAttribute(key);
	}

	public String extractOnyNumberFromString(String str) {
		
		  return  str.replaceAll("[^0-9]", "");
	}
}
