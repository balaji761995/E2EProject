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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.FileUtils;


public class DriverUtility {
	
	public static WebDriver driver;
	
	public static Properties prop;
	public static FileInputStream fis;
	public static Logger logger = LogManager.getLogger(DriverUtility.class.getName());
	
	public static WebDriver initializeBrowser() throws IOException
	{
		fis = new FileInputStream("C:\\Users\\balaj\\cucumber.project\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);

		//String browser = prop.getProperty("browser");
		String browser = System.getProperty("browser");
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\balaj\\Work\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("Chrome driver successfully initialized");
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		}
		else if(browser.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\balaj\\Work\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void takeScreenshots(String result) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\balaj\\Work\\"+result+"screenshot.png"));
	}
	
	
}

