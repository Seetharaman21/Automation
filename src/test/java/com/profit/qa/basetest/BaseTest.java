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
import com.profit.qa.Base.Base;
import com.profit.qa.pages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public WebDriverWait wait;	
	Properties prop;
	public Page page;
	public Base base ;	
    public static String configPath="src/main/java/com/profit/qa/Properties/config.properties"; 

	
	
	
    @BeforeClass
    public void beforeClass() throws IOException
	{
		prop=Base.getPropertyAccess(configPath);
		setUpDriver(prop.getProperty("browser"));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		page = new Page(this.driver, this.wait);

	}
	
	
	
	
	public WebDriver setUpDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		return driver;
	}


}
