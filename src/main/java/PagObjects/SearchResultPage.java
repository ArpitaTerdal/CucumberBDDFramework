package PagObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonUtils;
import Utilities.ElementUtils;

public class SearchResultPage {

WebDriver driver;
private ElementUtils elementUtils;
	
	public SearchResultPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement HpProductloc;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement noProductWarningMsg;
	
	public boolean verifyproductdisplayed()
	{
		return elementUtils.isElementDisplayed(HpProductloc, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
	
	public String verifyNoProductWarningMsg()
	{
		return elementUtils.getText(noProductWarningMsg, CommonUtils.EXPLICIT_BASIC_WAIT_TIME);
	}
}
