package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import PagObjects.HomePage;
import PagObjects.SearchResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Search {

	WebDriver driver;
	private HomePage hp;
	private SearchResultPage resultPage;
	private DriverFactory driverFactory;
	
	@Given("User opens the application")
	public void user_opens_the_application() {
		driverFactory=new DriverFactory();
	   driver=driverFactory.getDriver();
		
	}

	@When("User enters valid product {string} into search field")
	public void user_enters_valid_product_into_search_field(String productname) {
	    
		 hp=new HomePage(driver);
		hp.enterProductNameIntoSearchbox(productname);
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
		//hp=new HomePage(driver);
		resultPage=hp.clickOnSearch();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
	   
		
		Assert.assertTrue(resultPage.verifyproductdisplayed());
	}

	@When("User enters invalid product {string} into search field")
	public void user_enters_invalid_product_into_search_field(String productname) {
		hp=new HomePage(driver);
		hp.enterProductNameIntoSearchbox(productname);
		
	}

	@Then("User should get No product warning message")
	public void user_should_get_no_product_warning_message() {
	   
		Assert.assertEquals("There is no product that matches the search criteria.",resultPage.verifyNoProductWarningMsg());
	}


}
