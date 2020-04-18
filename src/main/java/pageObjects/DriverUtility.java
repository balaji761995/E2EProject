package pageObjects;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.FileUtils;


public class DriverUtility {
	
	public static WebDriver driver;
	
	public static Properties prop;
	public static FileInputStream fis;
	public static Logger logger = LogManager.getLogger(DriverUtility.class.getName());
	
	public static WebDriver initializeBrowser() throws IOException
	{
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);

		//String browser = prop.getProperty("browser");
		//String browser = System.getProperty("browser");
		String browser = "chrome";
		if(browser.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			if(browser.contains("headless"))
			{
				option.addArguments("headless");
			}
			driver = new ChromeDriver(option);
			logger.info("Chrome driver successfully initialized");
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public String failureScreenShot(WebDriver driver,String testName) throws IOException
    {
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File sourceFile = ts.getScreenshotAs(OutputType.FILE);
    	String dest = System.getProperty("user.dir")+"//reports//"+testName+".png";
    	File destFile = new File(dest);
    	FileUtils.copyFile(sourceFile, destFile);
    	return dest;
    }
	
}

