package com.profit.qa.ExtentReportListener;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

private DriverFactory() {

	}

	private static DriverFactory instance  = new DriverFactory();

	public static DriverFactory getInstance() {
		return instance;
	}


	//factory design pattern --> define separate factory methods for creating objects and create objects by calling that methods
	ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public WebDriver getDriver() {
		return driver.get();
	}

	public void setDriver(WebDriver driverParm) {
		driver.set(driverParm);
	}


	public void closeBrowser() {
		driver.get().quit();
		driver.remove();
	}

}
