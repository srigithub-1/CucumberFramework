package stepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

public String offerPageProductName, ItemNameReadFromExcelCell;
TestContextSetup testContextSetup;
PageObjectManager pageObjectManager;
//Single responsibilty Principle
//loosly coupled
//Factory Design Pattern
public OfferPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup=testContextSetup;
}

@Then("^user searched for (.+) shortname from row (.+) in offers page$")
public void user_searched_for_same_shortname_in_offers_page(String shortName, int rowNum) throws InterruptedException, InvalidFormatException, IOException {
    //offer pafe->enter_>grab text

	//Get the name from the input excel from each row
	ItemNameReadFromExcelCell = testContextSetup.genericUtils.ReadDatafromInputExcel(rowNum);			
			
	//Switch control to the offers page
	switchToOffersPage();
	
	//Create object of OffersPage
	OffersPage offersPage  =testContextSetup.pageObjectManager.OffersPage();
	
	//Search in offers page with name extracted from excel
	offersPage.searchItem(ItemNameReadFromExcelCell);
	
	//Fetch the product name shown in offers page and store in String variable "offerPageProductName"
	offerPageProductName = offersPage.getProductName();	
		
}

public void switchToOffersPage()
{
	//if switched to offer page-> skip below part
	LandingPage landingPage  =testContextSetup.pageObjectManager.getLandingPage();
	landingPage.selectTopDealsPage();
	testContextSetup.genericUtils.SwitchWindowToChild();
	
	//explicit wait, parse string
	
	
}
@Then("validate product name in offers page matches with Landing Page")
public void validate_product_name_in_Offers_page()
{
	Assert.assertEquals(ItemNameReadFromExcelCell, ItemNameReadFromExcelCell);
}

	
}
