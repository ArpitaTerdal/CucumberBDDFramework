package Utilities;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	public ElementUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickOnElement(WebElement element,long durationInSeconds)
	{
		WebElement ele= waitForElement(element,durationInSeconds);
		ele.click();
	}

	public void typeTextIntoElement(WebElement element,String Text,long durationInSeconds)
	{
		WebElement ele= waitForElement(element,durationInSeconds);
		ele.click();
		ele.clear();
		ele.sendKeys(Text);
	}
	
	public WebElement waitForElement(WebElement element,long durationInSeconds)
	{
		WebElement ele=null;
		try
		{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
		ele= wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		return ele;
	}
	
	public void selectOptionFromDropdown(WebElement element,String dropDownOption,long durationInSeconds)
	{
		WebElement ele=waitForElement(element,durationInSeconds);
		Select select=new Select(ele);
		select.selectByVisibleText(dropDownOption);
	}
	
	public Alert waitForAlert(long durationInSeconds)
	{
		Alert alert=null;
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
			alert=wait.until(ExpectedConditions.alertIsPresent());
			
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		return alert;
	}
	
	public void acceptAlert(long durationInSeconds)
	{
		Alert alert=waitForAlert(durationInSeconds);
		alert.accept();
	}

	public void dismissAlert(long durationInSeconds)
	{
		Alert alert=waitForAlert(durationInSeconds);
		alert.dismiss();
	}
	
	public void mouseHoverAndClick(WebElement element,long durationInSeconds)
	{
		
		WebElement ele=waitForVisibilityOfElement(element,durationInSeconds);
		
		Actions actions=new Actions(driver);
		actions.moveToElement(ele).click().build().perform();
		
	}
	
	public WebElement waitForVisibilityOfElement(WebElement element,long durationInSeconds)
	{
		WebElement ele=null;
		try
		{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		 ele=wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
		return ele;
	}
	
	public void javaScriptClick(WebElement element,long durationInSeconds)
	{
		WebElement ele=waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ele);
		
	}
	
	public void javaScriptYype(WebElement element,String text,long durationInSeconds)
	{
		WebElement ele=waitForVisibilityOfElement(element,durationInSeconds);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value='"+text+"'", ele);
	}
	
	public String getText(WebElement element,long durationInSeconds)
	{
		WebElement ele=waitForElement(element,durationInSeconds);
		return ele.getText();
	}
	
	public boolean isElementDisplayed(WebElement element,long durationInSeconds)
	{
		try
		{
		WebElement ele=waitForVisibilityOfElement(element,durationInSeconds);
		return ele.isDisplayed();
		}catch(Throwable e)
		{
			return false;
		}
	}
}