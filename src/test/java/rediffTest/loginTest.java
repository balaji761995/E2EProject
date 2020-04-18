package rediffTest;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageObjects.DriverUtility;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;


public class loginTest extends DriverUtility {
	
	public WebDriver driver;
	
	private static final Logger logger = LogManager.getLogger(DriverUtility.class.getName());
	
 	
	@Test
	public void loginPageTest() throws IOException
	{
		driver = initializeBrowser();
		driver.get("http://www.rediff.com/");
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.signInButton().click();
		logger.info("Login link clicked successfully");
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.enterUserName().sendKeys(prop.getProperty("username"));
		loginPage.enterPassword().sendKeys(prop.getProperty("password"));
		logger.info("User Name and Password entered successfully");
		loginPage.signInButton().click();
		//failureScreenShot(driver,"test1");
		logger.info("Login button clicked");
		//Assert.assertEquals(loginPage.loginErrorMsg().getText(),"Temporary error occured[#5001], please try again.");
}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		logger.info("Browser closed");
		driver = null;
	}

}

