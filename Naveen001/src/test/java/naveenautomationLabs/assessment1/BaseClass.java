package naveenautomationLabs.assessment1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public WebDriver driver;
	
	@BeforeSuite
	public void setDriverPath() {
		
	//Set Property :
	System.out.println("Set Property - Chrome Driver path");
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				
		
	}
	
	@BeforeTest
	public void doThisBeforEveryTest() {
		
		
	}
	
	@BeforeMethod
	public void doThisBeforeEveryTestMethod() {
		
		//launch Browser :
		System.out.println("About To Launch The Browser : ");
		driver = new ChromeDriver();
		System.out.println("Browser Is Launched Successfully ");
		
		//Enter URL "
		try {
			System.out.println("About to Launch the URL : "+ TestData.URL );
			//Launch the URL :
			driver.get(TestData.URL);
			//Maximize:
			driver.manage().window().maximize();
			//Implicit wait :
			driver.manage().timeouts().implicitlyWait(TestData.IMPLICIT_WAIT_IN_SEC, TimeUnit.SECONDS);
			
		}catch(Exception e) {
			System.out.println("Not able to enter the URL : " + TestData.URL );
			System.out.println("While Enter the URL " + e.getMessage());
		}
		
		
		
	}
	
	@AfterMethod
	public void doThisAferMethod() {
		System.out.println("Close the driver Session ");
		driver.quit();
		System.out.println("End Test Case");
	}
}
