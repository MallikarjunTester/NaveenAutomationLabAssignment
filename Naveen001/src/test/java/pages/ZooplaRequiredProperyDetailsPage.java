package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import naveenautomationLabs.assessment1.BaseClass;
import naveenautomationLabs.assessment1.WrapperMethods;

public class ZooplaRequiredProperyDetailsPage extends WrapperMethods {
			
	@FindBy(xpath="(//a[@class='ui-agent__details'])[1]/div[@class='ui-agent__logo']/img")
    WebElement agentLogo;
	
	@FindBy(xpath="(//a[contains(@href,'tel:')])[1]")
    WebElement agentTelePhone;
	
	@FindBy(xpath="(//h4[@class='ui-agent__name'])[1]")
    WebElement agentName;

    public ZooplaRequiredProperyDetailsPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }


    public ZooplaRequiredProperyDetailsPage getTheAgentLogoImageURL() {

    	System.out.println("About to get the Agent Logo link");
    	System.out.println("================================");

    	String imgURL = getAttributeValue(agentLogo, "src");

    	System.out.println("Agent Logo is in the location url :"+ imgURL);
    	System.out.println();
    	System.out.println();

    	return this;

    }

    public ZooplaRequiredProperyDetailsPage getAgentTelePhoneNum() {

    	System.out.println("About to get the Agent TelePhone Num");
    	System.out.println("================================");

    	String telephoneNumber = getAttributeValue(agentTelePhone, "href");

    	System.out.println("Agent TelePhone Number is :"+ telephoneNumber);
    	System.out.println();
    	System.out.println();

    	return this;

    }

    public ZooplaRequiredProperyDetailsPage getAgent_Name() {

    	System.out.println("About to get the Agent name");
    	System.out.println("================================");

    	String strAgentName = getText(agentName);

    	System.out.println("Agent name is :"+ strAgentName);
    	System.out.println();
    	System.out.println();

    	return this;


    }

    public String getAgentName() {

    	System.out.println("About to get the Agent name");

    	return  getText(agentName);

    }

    public ZooplaRequiredAgentPage clickOnAgentName() {

    	if(click(agentName)) {
    		System.out.println("Successfully clicked on the Agent Name");
    	}else {

    		System.out.println("Failed to click on the Agent Name");
    	}
    	System.out.println();
    	System.out.println();
    	return new ZooplaRequiredAgentPage(driver);
    }


}
