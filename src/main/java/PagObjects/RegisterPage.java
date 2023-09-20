package PagObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonUtils;
import Utilities.ElementUtils;

public class RegisterPage {

WebDriver driver;
private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNamefield;
	
	@FindBy(id="input-lastname")
	private WebElement lastNamefield;
	
	@FindBy(id="input-email")
	private WebElement emailfield;
	
	@FindBy(id="input-telephone")
	private WebElement telephonefield;
	
	@FindBy(id="input-password")
	private WebElement passwordfield;
	
	@FindBy(id="input-confirm")
	private WebElement confirmpasswordfield;
	
	@FindBy(name="agree")
	private WebElement privacycheckBox;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement newSettlerYesOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailWarningMsg;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarningMsg;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarningMsg;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarningMsg;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarningMsg;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarningMsg;
	
	public void enterFirstName(String firstname)
	{
		elementUtils.typeTextIntoElement(firstNamefield, firstname, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
	
	
	public void enterLastName(String lastname)
	{
		elementUtils.typeTextIntoElement(lastNamefield, lastname, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
	
	public void enterEmailAddress(String email)
	{
		elementUtils.typeTextIntoElement(emailfield, email, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
	
	public void enterTelephoneNumber(String telephoneNo)
	{
		elementUtils.typeTextIntoElement(telephonefield, telephoneNo, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
	
	public void enterPassword(String password)
	{
		elementUtils.typeTextIntoElement(passwordfield, password, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
	
	public void enterConfirmPassword(String password)
	{
		elementUtils.typeTextIntoElement(confirmpasswordfield, password, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
	
	public void clickPrivacyPolicy()
	{
		elementUtils.clickOnElement(privacycheckBox, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
	
	public AccountSuccessPage clickonContinue()
	{
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
		return new AccountSuccessPage(driver);
	}
	
	public void clickonNewSettlerYesOption()
	{
		elementUtils.clickOnElement(newSettlerYesOption, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
	
	public String getDuplicateEmailWarningMsg()
	{
		return elementUtils.getText(duplicateEmailWarningMsg, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
	
	public String getFirstNameWarningMsg()
	{
		return elementUtils.getText(firstNameWarningMsg, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
	
	public String getLastNameWarningMsg()
	{
		return elementUtils.getText(lastNameWarningMsg, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
	
	public String getEmailWarningMsg()
	{
		return elementUtils.getText(emailWarningMsg, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
	
	public String getTelephoneWarningMsg()
	{
		return elementUtils.getText(telephoneWarningMsg, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
	
	public String getPasswordWarningMsg()
	{
		return elementUtils.getText(passwordWarningMsg, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
}
