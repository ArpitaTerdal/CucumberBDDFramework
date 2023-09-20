package StepDefinitions;

import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import PagObjects.AccountSuccessPage;
import PagObjects.HomePage;
import PagObjects.RegisterPage;
import Utilities.CommonUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Register {

	public WebDriver driver;
	private RegisterPage register;
	private AccountSuccessPage accounsuccess;
	private DriverFactory driverFactory;
	
	@Given("User navigates to Create Account page")
	public void user_navigates_to_create_account_page() {
		driverFactory=new DriverFactory();
		driver=driverFactory.getDriver();
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccountdropMenu();
		register=hp.clickonRegisterOption();
	
	}

	@When("User enters below fields")
	public void user_enters_below_fields(DataTable dataTable) {
		
		Map<String,String> dataMap=dataTable.asMap(String.class,String.class);
		
		register.enterFirstName(dataMap.get("firstName"));
		register.enterLastName(dataMap.get("lastName"));
		register.enterEmailAddress(CommonUtils.emailWithTimeStamp());
		register.enterTelephoneNumber(dataMap.get("telephone"));
		register.enterPassword(dataMap.get("password"));
		register.enterConfirmPassword(dataMap.get("password"));
	}
	
	@When("User enters below fields with duplicate email")
	public void user_enters_below_fields_with_duplicate_email(DataTable dataTable) {
		
		Map<String,String> dataMap=dataTable.asMap(String.class,String.class);
		register.enterFirstName(dataMap.get("firstName"));
		register.enterLastName(dataMap.get("lastName"));
		register.enterEmailAddress(dataMap.get("email"));
		register.enterTelephoneNumber(dataMap.get("telephone"));
		register.enterPassword(dataMap.get("password"));
		register.enterConfirmPassword(dataMap.get("password"));
	}

	@And("User clicks privacy policy checkbox")
	public void user_clicks_privacy_policy_checkbox() {
	   
		register.clickPrivacyPolicy();
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
	   
		accounsuccess=register.clickonContinue();
	}

	@Then("User account should created successfully")
	public void user_account_should_created_successfully() {
		
		Assert.assertEquals("Your Account Has Been Created!",accounsuccess.getAccountsuccessMsg());
	}

	@When("User selects yes for newsettler")
	public void user_selects_yes_for_newsettler() {
	    
		register.clickonNewSettlerYesOption();
	}

	@Then("User should get duplicate email warning message")
	public void user_should_get_duplicate_email_warning_message() {
	   
		Assert.assertTrue(register.getDuplicateEmailWarningMsg().contains("Warning: E-Mail Address is already registered!"));
	}

	@Then("User should get warning message for every mandatory fields")
	public void user_should_get_warning_message_for_every_mandatory_fields() {
	   
		Assert.assertTrue(register.getDuplicateEmailWarningMsg().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!",register.getFirstNameWarningMsg());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", register.getLastNameWarningMsg());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", register.getEmailWarningMsg());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", register.getTelephoneWarningMsg());
		Assert.assertEquals("Password must be between 4 and 20 characters!", register.getPasswordWarningMsg()); 
		
	}	

}
