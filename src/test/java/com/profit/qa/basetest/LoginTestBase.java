package com.profit.qa.basetest;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.profit.qa.Base.Base;
import com.profit.qa.pages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestBase {

	public WebDriver driver;
	public WebDriverWait wait;
	public Page page;
	public Base base ;

	Properties prop;

	// setup() Will run before every test case
	@BeforeClass
	public void setup() throws IOException, InterruptedException {
		base = new Base(driver, wait);
		prop=Base.getPropertyAccess("src/main/java/com/profit/qa/Properties/config.properties");

		if (prop.getProperty("browser").contains("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			if(prop.getProperty("browser_mode").contains("headless"))
			{   
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("--headless");
				
				driver = new ChromeDriver(options);
							} else {
								ChromeOptions options = new ChromeOptions();
								options.addArguments("--remote-allow-origins=*");
								options.addArguments("--disable notifications");
								DesiredCapabilities cp = new DesiredCapabilities();
								cp.setCapability(ChromeOptions.CAPABILITY, options);
								options.merge(cp);
								driver = new ChromeDriver(options);
							}



			    
		} else if (prop.getProperty("browser").contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.get(prop.getProperty("loginUrl"));

		//Thread.sleep(4000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();


		page = new Page(this.driver, this.wait);
	}
	
	
	/*
	 * @BeforeSuite public void pageResponseTime() { getInitialResposneLoad(); }
	 */




	/*
	 *  teardown() method will run after every test case done
	 */
	@AfterClass
	public void teardown() {
		driver.quit();
	}


	
	public void getHeadlessChromeInstance()
	{
		
	}
	
	public void getHeadlessFirefoxInstance()
	{
		
	}

	public void getChromeInstance()
	{
		
	}
	
	
	public void getFirefoxInstance()
	{
		
	}
	
	/*
	 * @Test public void getInitialResposneLoad() {
	 * Base.checkPageLoadingSpeed(prop.getProperty("loginUrl")); }
	 */

}
