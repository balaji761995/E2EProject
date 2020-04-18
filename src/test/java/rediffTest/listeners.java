package rediffTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import pageObjects.DriverUtility;

public class listeners extends DriverUtility  implements ITestListener {
		
	 	DriverUtility b = new DriverUtility();	
	 	public static ExtentReports extent = ExtentReporterNG.extentReport();
	 	public static ExtentTest test;
	 	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	 
	 	  public void onTestStart(ITestResult result) {					
		        // TODO Auto-generated method stub				
		    	 test = extent.createTest(result.getMethod().getMethodName());
		    	 extentTest.set(test);
		    }	
	    public void onFinish(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
	        extent.flush();	
	    }		

	    public void onStart(ITestResult result) {					
	        // TODO Auto-generated method stub				
	      
	    }		

	    		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    		
	    public void onTestFailure(ITestResult result) {					
	        // TODO Auto-generated method stub
	    	WebDriver driver = null;
	    	Object obj = result.getInstance();
	    	Class cls = result.getTestClass().getRealClass();
	    	try {
				driver = (WebDriver) cls.getDeclaredField("driver").get(obj);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
			}
	    	extentTest.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED", ExtentColor.RED));
	    	extentTest.get().fail(result.getThrowable());
	    	try {
				extentTest.get().addScreenCaptureFromPath(failureScreenShot(driver, result.getName()), result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        		
	    }		

	    		
	    public void onTestSkipped(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    		
	  	

	    		
	    public void onTestSuccess(ITestResult result) {					
	        // TODO Auto-generated method stub				
	    	extentTest.get().log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED", ExtentColor.GREEN));
	       	
	    }		

}
