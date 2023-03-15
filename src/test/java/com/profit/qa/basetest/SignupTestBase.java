package com.profit.qa.basetest;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.profit.qa.Base.Base;
import com.profit.qa.pages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignupTestBase extends BrowserFactory {

	public WebDriver driver;
	public WebDriverWait wait;
	public Page page;
	public Base base ;

	Properties prop;

	// setup() Will run before every test case
	@BeforeClass
	@Parameters("BaseURL")
	public void setup() throws IOException, InterruptedException {
		base = new Base(driver, wait);
		prop=Base.getPropertyAccess("src/main/java/com/profit/qa/Properties/config.properties");
        if (prop.getProperty("browser").contains("chrome"))
        { WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); }
        else if (prop.getProperty("browser").contains("firefox"))
        { WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver(); }

		driver.get(prop.getProperty("SignupUrl"));
		Thread.sleep(4000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		page = new Page(this.driver, this.wait);
	}

	/*
	 *  teardown() method will run after every test case done
	 */
	/*
	 * @AfterClass public void teardown() { driver.quit(); }
	 */
	
	
	
	public void setup1() throws IOException
	{
		base = new Base(driver, wait);

		prop = Base.getPropertyAccess("src/main/java/com/profit/qa/Properties/config.properties");

		BrowserFactory BF = new BrowserFactory();

		switch (prop.getProperty("SignupUrl")) {
		case "chrome":

			WebDriverManager.chromedriver().setup();

			if (prop.getProperty("Version") == null && prop.getProperty("headless") == null) 
			{
				driver = getChromeInstance();
			} 
			else if (prop.getProperty("Version") != null && prop.getProperty("headless") != null) 
			{
				getChromeVersionInstance(prop.getProperty("Version"));
				driver = getHeadlessChromeInstance();
			} 
			else if (prop.getProperty("Version") == null && prop.getProperty("headless") != null) 
			{
				driver = getHeadlessChromeInstance();
			} 
			else if (prop.getProperty("Version") != null && prop.getProperty("headless") == null) 
			{
				getChromeVersionInstance(prop.getProperty("Version"));
			}
			break;

		case "firefox":
			
			break;
		case "edge":
			
			break;
		default:
			throw new IllegalArgumentException("Invalid browser specified: " );
		}
	}


}
