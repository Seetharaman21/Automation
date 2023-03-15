package com.profit.qa.ExtentReportListener;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {

private ExtentFactory() {

	}

	private static ExtentFactory instance  = new ExtentFactory();

	public static ExtentFactory getInstance() {
		return instance;
	}


	ThreadLocal<ExtentTest> extent = new ThreadLocal<>();

	public ExtentTest getExtent() {
		return extent.get();
	}

	public void setExtent(ExtentTest extentTestObject) {
		extent.set(extentTestObject);
	}

	public void removeExtentObject() {
		extent.remove();
	}

}
