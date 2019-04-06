package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import naveenautomationLabs.assessment1.BaseClass;
import naveenautomationLabs.assessment1.TestData;
import naveenautomationLabs.assessment1.WrapperMethods;

public class ZooplaPropertySearchPage extends WrapperMethods {

	
	@FindBy(id="search-input-location")
    WebElement serchInputLocation;
	
	@FindBy(id="search-submit")
    WebElement searchSubmitButton;

    public ZooplaPropertySearchPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
    
    public ZooplaPropertySearchPage enterLocation() {
    	
    	if (sendKeys(serchInputLocation, TestData.SEARCHLOCATION)) {
    		System.out.println("Successfully entered the search Location - "+ TestData.SEARCHLOCATION);
		}else {
			System.out.println("Not able to enter the search location - test case Failed"+ TestData.SEARCHLOCATION);
		}
    return this;
    	
    }
	
 public ZooplaPropertySearchResultsPage clickOnSearch() {
    	
    	if(click(searchSubmitButton)) {
    		System.out.println("Successfully clicked on the Search button");
    	}else {
    		System.out.println("Failed to click on the search button ");
    	}
    return new ZooplaPropertySearchResultsPage(driver);
    	
    }
    
    
    
}
