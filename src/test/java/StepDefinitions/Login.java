package StepDefinitions;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Factory.DriverFactory;
import PagObjects.AccountPage;
import PagObjects.HomePage;
import PagObjects.LoginPage;
import Utilities.CommonUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Login {
	
	WebDriver driver;
	private LoginPage lp;
	private AccountPage accountpage;
	private DriverFactory driverFactory;
	
	@Given("User navigates to login Page")
	public void User_navigates_to_login_Page()
	{
		driverFactory=new DriverFactory();
		driver=driverFactory.getDriver();
		HomePage hp=new HomePage(driver);
		hp.clickMyAccountdropMenu();
		lp=hp.clickOnLoginOption();
	}
	
	@When("User enters invalid username")
	public void user_enters_invalid_username() {
       
    //lp=new LoginPage(driver);
     lp.enterEmailAddress(CommonUtils.emailWithTimeStamp());
	}

	@And("User enters invalid password {string}")
	public void user_enters_invalid_password(String password) {

		lp.enterPassword(password);
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		accountpage=lp.clickLogin();

	}

	@Then("User should get proper warning message")
	public void user_should_get_proper_warning_message() {

    Assert.assertTrue(lp.verifyLoginWarningmsg().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("^User enters valid username (.+)$")
	public void user_enters_valid_username(String username) {

		 lp=new LoginPage(driver);
	       lp.enterEmailAddress(username);
	}

	@And("^User enters valid password (.+)$")
	public void user_enters_valid_password(String password) {
	    
		 lp.enterPassword(password);
	}

	@Then("User should login successfully.")
	public void Then_User_should_login_successfully()
	{
		
		Assert.assertTrue(accountpage.verifyIsEditAccountInfoStatus());
		
	}

	
}
