package com.profit.qa.ExtentReportListener;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.profit.qa.Utills.RetryAnalyzer;
import com.profit.qa.Utills.SendReport;
import com.profit.qa.pages.Page;

public class ExtentReporter  implements ITestListener,IAnnotationTransformer   {


	static ExtentReports report;
		   ExtentTest test;
		   int flag=1;
		 //  ITestNGMethod method = Reporter.getCurrentTestResult().getMethod();


	@Override
	public void onTestStart(ITestResult result) {
		//before each test case
		test = report.createTest(result.getMethod().getMethodName());
		ExtentFactory.getInstance().setExtent(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(flag);
		System.out.println("Running test method: " + result.getMethod().getMethodName());
		System.out.println();

		ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test Case: "+result.getMethod().getMethodName()+ " is Passed.");
		ExtentFactory.getInstance().getExtent().log(Status.PASS, "Test Case: "+result.getInstanceName()+ " is Passed.");
		ExtentFactory.getInstance().getExtent().log(Status.PASS, "150 URL has been Passed.");

		ExtentFactory.getInstance().removeExtentObject();
		

		flag++;
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Running test method: " + result.getMethod().getMethodName());
		ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Test Case: "+result.getMethod().getMethodName()+ " is Failed.");
		ExtentFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());

		//add screenshot for failed test.

		
		
		File src = ((TakesScreenshot) Page.driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat format = new SimpleDateFormat(" dd_MM_yyyy HH:mm");
		Date date = new Date();
		String actualDate = format.format(date);

		String screenshotPath = System.getProperty("user.dir") + "/Reports/Screenshots/" +actualDate + ".jpeg";
		File dest = new File(screenshotPath);

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(screenshotPath,
					"Test case failure screenshot");
			ExtentFactory.getInstance().removeExtentObject();

		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 
		/*
		 * String fileName = System.getProperty("user.dir")+ File.separator +
		 * result.getMethod().getMethodName(); File f= ((TakesScreenshot)
		 * Page.driver).getScreenshotAs(OutputType.FILE);
		 * 
		 * try { FileUtils.copyFile(f, new File(fileName +".png")); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */





	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Test Case: "+result.getMethod().getMethodName()+ " is skipped.");
		ExtentFactory.getInstance().removeExtentObject();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ExtentFactory.getInstance().getExtent().log(Status.INFO, "Test Case: "+result.getMethod().getMethodName()+ " is Test Failed But Within SuccessPercentage.");
		ExtentFactory.getInstance().removeExtentObject();

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ExtentFactory.getInstance().getExtent().log(Status.INFO, "Test Case: "+result.getMethod().getMethodName()+ " is Time Out.");
		ExtentFactory.getInstance().removeExtentObject();
	}

	@Override
	public void onStart(ITestContext context) {
		try { report = ExtentReportNG.setupExtentReport(); } catch (Exception e) { e.printStackTrace();}
	}

	@Override
	public void onFinish(ITestContext context) {
		//close extent
		report.flush();
		try {
			SendReport.sentEmail();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod,
			Class<?> occurringClazz) {
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}




}
