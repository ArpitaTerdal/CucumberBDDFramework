package PagObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonUtils;
import Utilities.ElementUtils;

public class LoginPage {

WebDriver driver;
private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(id="input-email")
	private WebElement userNameField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement loginwarningmsg;
	
	public void enterEmailAddress(String emailid)
	{
		elementUtils.typeTextIntoElement(userNameField, emailid, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
	
	public void enterPassword(String password)
	{
		elementUtils.typeTextIntoElement(passwordField, password, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
	
	public AccountPage clickLogin()
	{
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
		return new AccountPage(driver);
	}
	
	public String verifyLoginWarningmsg()
	{
		return elementUtils.getText(loginwarningmsg, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
}
