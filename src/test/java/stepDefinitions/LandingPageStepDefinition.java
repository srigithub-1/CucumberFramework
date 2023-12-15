package stepDefinitions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
public WebDriver driver;
public String landingPageProductName, ItemNameReadFromExcelCell, QuantityReadFromExcelCell;
public String offerPageProductName;
TestContextSetup testContextSetup;
LandingPage landingPage;

//Spring framework, EJB, 
//SRP
//
public LandingPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup=testContextSetup;
	this.landingPage =testContextSetup.pageObjectManager.getLandingPage();
}
	@Given("User is on GreenCart Landing page")
public void user_is_on_green_cart_landing_page() {
		
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
}

	@When("^user searched from sheet (.+) with rowNumber (.+) and extracted actual name of product$")
	public void user_searched_from_sheet_with_rowNumber_and_extracted_actual_name_of_product(String sheetName, int rowNum ) throws InterruptedException, InvalidFormatException, IOException {
		
		//Get the name from the input excel from each row
		ItemNameReadFromExcelCell = testContextSetup.genericUtils.ReadDatafromInputExcel(rowNum);
		
		
		//Send the value of the item read into the search bar		
		landingPage.searchItem(ItemNameReadFromExcelCell);
		
		//Fetch the product name shown after search	
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();	
			
}

	@When("Added items {string} of the selected product to cart")
	public void Added_items_of_the_selected_product_to_cart(String quantity)
	{
		//Get the quantity of the item to add from the input excel from each row		
		landingPage.incrementQuantity(quantity);
		landingPage.addToCart();
		
	}
	


	
}
