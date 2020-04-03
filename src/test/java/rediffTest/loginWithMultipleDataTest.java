package rediffTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.DriverUtility;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;

public class loginWithMultipleDataTest extends DriverUtility {
	
	public static WebDriver driver;
	
	
	@Test(dataProvider="userData")
	public static void loginPageTest(String user, String pass) throws IOException
	{
		driver = initializeBrowser();
		driver.get("http://www.rediff.com/");
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.signInButton().click();
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		loginPage.enterUserName().sendKeys(user);
		loginPage.enterPassword().sendKeys(pass);
		loginPage.signInButton().click();
		//Assert.assertEquals(loginPage.loginErrorMsg().getText(), "Temporary error occured[#5001], please try again.");		
		
	}
	
	@DataProvider
	public Object[][] userData()
	{
		Object[][] data = new Object[2][2];
		data[0][0] = "user1";
		data[0][1] = "pass1";
		data[1][0] = "user2";
		data[1][1] = "pass2";
		
		return data;
		
		
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		logger.info("Browser closed");
		driver = null;
	}

}
