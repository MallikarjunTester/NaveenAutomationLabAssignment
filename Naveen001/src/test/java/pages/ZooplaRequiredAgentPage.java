package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import naveenautomationLabs.assessment1.BaseClass;
import naveenautomationLabs.assessment1.WrapperMethods;

public class ZooplaRequiredAgentPage extends WrapperMethods{
	
	@FindBy(xpath="//h1[@class='bottom-half']/b[1]")
    WebElement agentName_InDetails;
	
	 public ZooplaRequiredAgentPage(WebDriver driver){

	        this.driver = driver;

	        //This initElements method will create all WebElements

	        PageFactory.initElements(driver, this);

	    }
	 
	 public String getAgentNameInRequiredPage() {
		 
		return  getText(agentName_InDetails);
		 
	 }
}
