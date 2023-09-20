package PagObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonUtils;
import Utilities.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountdropmenu;
	
	@FindBy(linkText="Login")
	private WebElement LoginOption;
	
	@FindBy(linkText="Register")
	private WebElement RegisterOption;
	
	@FindBy(name="search")
	private WebElement searchBox;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchIcon;
	
	public void clickMyAccountdropMenu()
	{
		elementUtils.clickOnElement(myAccountdropmenu, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
	
	public LoginPage clickOnLoginOption()
	{
		elementUtils.clickOnElement(LoginOption, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
		return new LoginPage(driver);
	}
	
	public RegisterPage clickonRegisterOption()
	{
		elementUtils.clickOnElement(RegisterOption, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
		return new RegisterPage(driver);
	}

	public void enterProductNameIntoSearchbox(String productName)
	{
		elementUtils.typeTextIntoElement(searchBox, productName, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
		
	}
	
	public SearchResultPage clickOnSearch()
	{
		elementUtils.clickOnElement(searchIcon, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
		return new SearchResultPage(driver);
	}
}
