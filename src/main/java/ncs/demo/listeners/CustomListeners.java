package ncs.demo.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import ncs.demo.base.Page;
import ncs.demo.utilities.Utilities;

public class CustomListeners extends Page implements ITestListener{
	public void onTestFailure(ITestResult arg0) {
		System.setProperty("org.uncommons.reportng.escape-output","false");
		try {
			Utilities.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, arg0.getName().toUpperCase()+" Failed with exception : "+arg0.getThrowable());
		test.log(LogStatus.INFO, test.addScreenCapture(Utilities.screenshotName));
		
		Reporter.log("click to see screenshot");
		Reporter.log("<a target=\"_blank\" href="+ Utilities.screenshotName +">Screenshot</a>" );
		rep.endTest(test);
		rep.flush();
	
	}
	
	
	public void onTestStart(ITestResult arg0)
	{
		test = rep.startTest(arg0.getName().toUpperCase());
		
	}
	
	public void onTestSuccess(ITestResult arg0) {


		test.log(LogStatus.PASS, arg0.getName().toUpperCase()+" PASS");
		rep.endTest(test);
		rep.flush();
		
	}
}
