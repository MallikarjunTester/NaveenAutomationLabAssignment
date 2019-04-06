package testscripts;

import org.testng.annotations.Test;

import naveenautomationLabs.assessment1.BaseClass;
import naveenautomationLabs.assessment1.Utilities;
import pages.ZooplaPropertySearchPage;
import pages.ZooplaRequiredProperyDetailsPage;

public class NaveenAutomationLabsAssessment1 extends BaseClass {

	@Test
	public void Assessment_TC() {

		System.out.println("=====================NAVEEEN AUTOMATION LABS ASIGNMENT"
				+ " 5TH APRIL,2019 ===========================");
		
		ZooplaRequiredProperyDetailsPage agentDetailPage = 
		new ZooplaPropertySearchPage(driver).
		enterLocation().
		clickOnSearch().
		getTheListOfPropertyPricesInDescendinOrder().
		clickOnFifthProperty().
		getTheAgentLogoImageURL().
		getAgentTelePhoneNum().
		getAgent_Name();

		String actualAgentName =agentDetailPage.getAgentName();
		String expectedAgentName = agentDetailPage.clickOnAgentName().
		getAgentNameInRequiredPage();

		//Assert the Values :
		Utilities.assertValues(actualAgentName, expectedAgentName);
		System.out.println("Actual :"+ actualAgentName + " & Expected :"+expectedAgentName);
		System.out.println("ASSERTION SUCCESS ON RETAILER NAME");
		
		System.out.println("==================== THANK YOU NAVEEN ===========================");
		System.out.println("=====================End ===========================");

	}

}
