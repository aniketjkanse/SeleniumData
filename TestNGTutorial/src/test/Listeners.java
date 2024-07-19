package test;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
	
	public void onTestStart(ITestResult result)
	{
		
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test is Failed : "+result.getName());
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test is successfully Passed");
	}

}
