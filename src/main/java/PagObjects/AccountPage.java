package PagObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonUtils;
import Utilities.ElementUtils;

public class AccountPage {
	
WebDriver driver;
private ElementUtils elementUtils;
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement editAccountinfo;
	
	public boolean verifyIsEditAccountInfoStatus()
	{
		return elementUtils.isElementDisplayed(editAccountinfo, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}

}
