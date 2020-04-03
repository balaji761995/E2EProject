package rediffTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageObjects.DriverUtility;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;

public class RediffNavbarTest extends DriverUtility {
	
	public static WebDriver driver;
	public static Logger logger = LogManager.getLogger(DriverUtility.class.getName());
	
	
	@Test
	public static void loginPageTest() throws IOException
	{
		driver = initializeBrowser();
		driver.get("http://www.rediff.com/");
		HomePageObjects homePage = new HomePageObjects(driver);
 		Assert.assertFalse(homePage.validateNavbarElements("coronavirus").isDisplayed());
 		logger.info("Navbar is verified successfully");
 		driver.close();
			
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		logger.info("Browser closed");
		driver = null;
	}

}


