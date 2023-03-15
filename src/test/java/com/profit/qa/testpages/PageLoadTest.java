package com.profit.qa.testpages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.profit.qa.pages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadTest   {

	static WebDriver driver;
	Page page;
	WebDriverWait wait;

	/*
	 *  ========================================================================
	 *  function will read the data from excel
	 *  ========================================================================
	 *  Excel sheet should only have page name and Xpath of the page
	 *  first column should be page name
	 *  Second column should be xpath of the page
	 *  Only should use the xpath
	 *  ========================================================================
	 *
	 */


	@BeforeSuite
	public  void init() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException
	{

		By emailId = By.id("login_email");
		By password = By.name("password");
		By loginBtn = By.id("login_btn");


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://stag-app.profitokr.net/app/login.jsp");
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(emailId).click();
		driver.findElement(emailId).sendKeys("aabdul@profit.co");
		driver.findElement(password).sendKeys("Appas@123");
       driver.findElement(loginBtn).click();
       Thread.sleep(5000);
	}


	@AfterSuite
	public void quit()
	{
		driver.quit();
	}

	@DataProvider(name = "data-provider")
	//public Object[][] readExcel(String filePath, String fileName, String sheetName)throws IOException
	public Object[][] readExcel()throws IOException
	{

		String filePath = System.getProperty(("user.dir"))+"/src/test/java/com/profit/qa/testpages";
		String fileName = "profitsimple.xlsx";
		String sheetName = "sheet1";

		File file = new File(filePath + "/" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook pageURL = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) { pageURL = new XSSFWorkbook(inputStream);  }
		else if (fileExtensionName.equals(".xls")) { pageURL = new HSSFWorkbook(inputStream);}


		Sheet loadURLSheet = pageURL.getSheet(sheetName);
		XSSFRow row = (XSSFRow) loadURLSheet.getRow(0);

		int RowNum = loadURLSheet.getPhysicalNumberOfRows();
    	int ColNum= row.getLastCellNum();


        int rowCount = loadURLSheet.getLastRowNum();

        System.out.println("the no of rows are : " + rowCount);


    	Object Data[][]= new Object[RowNum-1][ColNum];

		for (int i = 0; i < RowNum - 1; i++)
		{
			XSSFRow row1 = (XSSFRow) loadURLSheet.getRow(i + 1);
			for (int j = 0; j < ColNum; j++)
			{
				if (row1 == null)
					Data[i][j] = "";
				else
				{
					XSSFCell cell = row1.getCell(j);
					if (cell == null)
						Data[i][j] = "";
					else
					{
						String value = cell.toString();
						Data[i][j] = value;
					}
				}
			}
		}
		return Data;
	}

	/*
	 *
	 * *****************************************************************************************************************************************************************
	 *
	 */

	@Test(dataProvider="data-provider") //It get values from ReadVariant function method
	public void AddVariants(String pagename, String xpath) throws Exception
	{
		checkPageElement(pagename, xpath);
	}


	/*
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 */


	@SuppressWarnings({"deprecation", "static-access"})
	@Test(enabled = false)
	public void TestPageLoadTime()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>()
		{
			@Override
			public Boolean apply(WebDriver input) { return ((JavascriptExecutor) driver).executeScript("return document.readtstate").equals("complete");}
		}; wait.until(pageLoadCondition);
	}


	@Test(enabled = false)
	public void checkPageLoadingTime()
	{
		long startTime = System.currentTimeMillis();
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>()
				{
			        @Override
					public Boolean apply(WebDriver input) { return ((JavascriptExecutor)driver).executeScript("returndocument.readtstate").equals("complete");}
				}; wait.until(pageLoadCondition);
		long endTime= System.currentTimeMillis();
		long pageLoadTime= endTime-startTime;
		System.out.println(pageLoadTime + "millisecond");
		System.out.println("=========================================================================================");


	}

	public static void checkPageElement(String pagename, String xpath ) throws InterruptedException
	{

		WebElement element = driver.findElement(By.xpath(xpath));
		element.click();
		driver.getCurrentUrl();
		if (element.isDisplayed()) {
		  System.out.println(pagename +"Page loaded successfully");
		} else {
		  System.out.println(pagename +"Page did not load successfully");
		}
	}

	}

