package com.profit.qa.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public static WebDriver driver; 
	
	
	
	public static WebDriver getHeadlessChromeInstance()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		return driver = new ChromeDriver(options);
	}
	
	public static WebDriver getHeadlessFirefoxInstance()
	{
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		return driver = new FirefoxDriver(options);

	}

	public static WebDriver getChromeInstance()
	{
		WebDriverManager.chromedriver().setup();
		return driver = new FirefoxDriver();
	}
	
	
	public static WebDriver getFirefoxInstance()
	{
		WebDriverManager.firefoxdriver().setup();
		return driver = new FirefoxDriver();
	}
	
	
	public static WebDriver getChromiumInstance()
	{
		WebDriverManager.chromiumdriver().setup();
		return driver = new ChromeDriver();
	}
	
	public static WebDriver getHeadlessChromiumInstance()
	{
		WebDriverManager.chromiumdriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		return driver = new ChromeDriver(options);
	}
	
	public static WebDriver getEdgeInstance()
	{
		WebDriverManager.edgedriver().setup();
		return driver = new EdgeDriver();
		

	}
	
	
	
	
	
	public WebDriver getHeadlessEdgeInstance()
	{
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.setHeadless(true);
		return driver = new EdgeDriver(options);
	}
	
	
	
	public WebDriver getChromeVersionInstance(String version)
	{
		WebDriverManager.chromedriver().browserVersion(version).setup();
        return driver = new ChromeDriver(); 
	}
	
	
	
	public WebDriver getFirefoxVersionInstance(String version)
	{
		WebDriverManager.firefoxdriver().browserVersion(version).setup();
		return driver = new FirefoxDriver(); 
	}


}
