package aniketkanselearning.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import aniketkanselearning.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReporterObject();
	ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>(); //to assign the unique thread while running parallel tests
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test); //unique thread id (ErrorValidationTest)-->test
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.PASS, "Test Passed");
		extenttest.get().log(Status.PASS, "Test Passed"); //using get just bcoz unique thread
	}
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//test.fail(result.getThrowable());
		extenttest.get().fail(result.getThrowable());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String ScreenshotPath = null;
		try {
			 ScreenshotPath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  //test.addScreenCaptureFromPath(ScreenshotPath, result.getMethod().getMethodName());
		extenttest.get().addScreenCaptureFromPath(ScreenshotPath, result.getMethod().getMethodName());
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
	

}
