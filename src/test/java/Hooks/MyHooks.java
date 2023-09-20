package Hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import Utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {
    
	WebDriver driver;
	private DriverFactory driverFactory;
	@Before
	public void setUp()
	{
		ConfigReader configReader=new ConfigReader();
		 Properties prop=configReader.initializeProperties();
		 driverFactory=new DriverFactory();
	   driver=driverFactory.initializeBrowser(prop.getProperty("browser"));
	   driver.get(prop.getProperty("url"));
	   
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		String scenarioName=scenario.getName().replace(" ", "_");
		if(scenario.isFailed())
		{
			byte[] srcscreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcscreenshot,"image/png",scenarioName);
		}
		driver.quit();
	}
}
