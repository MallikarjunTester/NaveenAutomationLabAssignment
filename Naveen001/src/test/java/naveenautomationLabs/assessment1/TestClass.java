package naveenautomationLabs.assessment1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class TestClass {

	public static void main(String[] args) {

		//Set Property :
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.zoopla.co.uk");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("search-input-location")).sendKeys("London");
		driver.findElement(By.id("search-submit")).click();
		
		List<WebElement> listOfLinks = driver.findElements(By.xpath("//div[@class='agent_logo']/following-sibling::a"));
		
		for(WebElement link:listOfLinks) {
			
			String linkText = link.getText();
			
			System.out.println("Link Text is : " + linkText);
			
			
		}
		
		listOfLinks.get(4).click();
		
		String imgURL = driver.findElement(By.xpath("(//a[@class='ui-agent__details'])[1]/div[@class='ui-agent__logo']/img")).
		getAttribute("src");
		System.out.println("img URL : "+ imgURL);
		
		String agentName = driver.findElement(By.xpath("(//h4[@class='ui-agent__name'])[1]")).getText();
		System.out.println("Agent Name : "+ agentName);
		
		String phHref = driver.findElement(By.xpath("(//a[contains(@href,'tel:')])[1]")).getAttribute("href");
		System.out.println("Href is "+ phHref);
		
		driver.findElement(By.xpath("(//h4[@class='ui-agent__name'])[1]")).click();
		String expected = driver.findElement(By.xpath("//h1[@class='bottom-half']/b[1]")).getText();
	
		Assert.assertEquals(expected, agentName);
		
		System.out.println("Sucess - convert it as testng frame work");
		
		driver.quit();
	
	}

}
