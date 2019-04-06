package pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import naveenautomationLabs.assessment1.BaseClass;
import naveenautomationLabs.assessment1.WrapperMethods;

public class ZooplaPropertySearchResultsPage extends WrapperMethods {


	
	@FindBy(xpath="//div[@class='agent_logo']/following-sibling::a")
    List<WebElement> listOfPrices;

    public ZooplaPropertySearchResultsPage(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }

    public ZooplaPropertySearchResultsPage getTheListOfPropertyPricesInDescendinOrder() {

    	List<WebElement> listOfPropertyPrices = listOfPrices ; 
    	List<String> descendingOrderList = new ArrayList<String>();
    															
    	TreeSet<Integer> treeSet = new TreeSet<Integer>();

    	for(WebElement price:listOfPropertyPrices) {

    		String priceLinkText = price.getText();
    		String onlyNum = extractOnyNumberFromString(priceLinkText);
    		int intPriceValue = Integer.parseInt(onlyNum);
    		treeSet.add(intPriceValue);
    		//System.out.println("Link Text is : " + priceLinkText);

    	}

    	// Create an Iterator over the TreeSet 
    	Iterator<Integer> iterator = treeSet.iterator(); 

    	// Loop over the TreeSet values 
    	// and print the values 
    	// System.out.print("TreeSet: "); 

    	//System.out.println("Property values in Ascending order Order is :");
    	//System.out.println("==========================================");

    	Integer intValue = null;
    	while (iterator.hasNext()) {
    		intValue = iterator.next();
    		//System.out.println(iterator.next());

    		for(int counter=0;counter<listOfPropertyPrices.size();counter++) {
    			if( listOfPropertyPrices.get(counter).getText().replaceAll(",", "").contains(intValue.toString())){

    				//System.out.println(listOfPropertyPrices.get(counter).getText()); This is Ascending order
    				descendingOrderList.add(listOfPropertyPrices.get(counter).getText());
    				listOfPropertyPrices.remove(counter);
    				break;

    			}                   
    		} 
    	}
    	
    	System.out.println("=============DESCENDING ORDER - PRICE VALUE AS EXPECTED START HERE ===========");
    	for(int counter=descendingOrderList.size()-1;counter>=0;counter--) {
    		
    		System.out.println(descendingOrderList.get(counter));
    	}
    	
    	System.out.println("=============DESCENDING ORDER - PRICE VALUE AS EXPECTED ENd HERE ===========");
    	System.out.println();
    	System.out.println();
    	return this;

    }

    public ZooplaRequiredProperyDetailsPage clickOnFifthProperty() {
    	
    	System.out.println("About to click on the 5th Propety link");
    	
    	if (click(listOfPrices.get(4))) {
			
    		System.out.println("Successfully clicked on 5th Price link");
		}else {
			System.out.println("Failed to click on the 5th Price link");
		}
    	System.out.println();
    	System.out.println();
    	
    	return new ZooplaRequiredProperyDetailsPage(driver);
    	
    }

}
