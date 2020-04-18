package rediffTest;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
 
public class ExtentReporterNG{
    public static ExtentReports extent;
    public static ExtentHtmlReporter configExtent;
    WebDriver driver;
    public static ExtentReports extentReport()
	{
		String reportPath = System.getProperty("user.dir")+"//reports//TestReport.html";
		configExtent = new ExtentHtmlReporter(reportPath);
		configExtent.config().setDocumentTitle("Ecommerce Test Report");
		configExtent.config().setReportName("Ecommerce Cucuumber Test Report");
		configExtent.config().setTheme(Theme.DARK);
		configExtent.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		extent = new ExtentReports();
		extent.attachReporter(configExtent);
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("browser", System.getProperty("browser"));
		return extent;
		
	}
    
}