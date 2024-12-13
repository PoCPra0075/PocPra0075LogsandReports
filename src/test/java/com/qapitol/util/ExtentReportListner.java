package com.qapitol.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListner implements ITestListener{

	ExtentReports extentReport;
	ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<ExtentTest>();
	
	
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentSparkReporter extentSpark = new ExtentSparkReporter("report.html");
		extentSpark.config().setReportName("QAPitol");
		extentSpark.config().setDocumentTitle("Demo-QA");
		extentReport = new ExtentReports();
		extentReport.attachReporter(extentSpark);		
		ITestListener.super.onTestStart(result);

		ExtentTest extentTest = extentReport.createTest(result.getMethod().getMethodName());
		threadLocal.set(extentTest);

		
	}
	

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		threadLocal.get().pass("TestPassed");
		ITestListener.super.onTestSuccess(result);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		Utility.takeScreenShot();
		threadLocal.get().fail("TestFailed");
		
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		threadLocal.get().skip("TestSkipped");

		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
//		threadLocal.get().fail("Failed");
		System.out.println("Entered in onTestFailedButWithinSuccessPercentage");

		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Entered in onTestFailedWithTimeout");

		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Entered in Start");
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentReport.flush();
		ITestListener.super.onFinish(context);
	}
	

}
