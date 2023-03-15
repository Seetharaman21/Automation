package com.profit.qa.testpages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.profit.qa.pages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Excel {

	static WebDriver driver;
	Page page;
	static WebDriverWait wait;

	@BeforeSuite
	public void init() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException {

		By emailId = By.id("login_email");
		By password = By.name("password");
		By loginBtn = By.id("login_btn");

		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		
		
	/*
	 * ChromeOptions options = new ChromeOptions();
	 * options.addArguments("--headless"); driver = new ChromeDriver(options);
	 */
		
		driver.get("https://app.profit.co/app/ng/profit.jsp");
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(emailId).click();
		driver.findElement(emailId).sendKeys("natasha.gupta@smartkargo.com");
		driver.findElement(password).sendKeys("Profit@2022");
		driver.findElement(loginBtn).click();
		Thread.sleep(5000);
	}

	@AfterSuite
	public void quit() {
		driver.quit();
	}

	@DataProvider(name = "data-provider")
	public Object[][] readExcel() throws IOException {

		String filePath = System.getProperty(("user.dir")) + "/src/test/java/com/profit/qa/testpages";
		String fileName = "CheckClientData.xlsx";
		String sheetName = "sheet1";

		File file = new File(filePath + "/" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook pageURL = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			pageURL = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			pageURL = new HSSFWorkbook(inputStream);
		}

		Sheet loadURLSheet = pageURL.getSheet(sheetName);
		XSSFRow row = (XSSFRow) loadURLSheet.getRow(0);

		int RowNum = loadURLSheet.getPhysicalNumberOfRows();
		int ColNum = row.getLastCellNum();

		int rowCount = loadURLSheet.getLastRowNum();

		System.out.println("the no of rows are : " + rowCount);
		System.out.println("the no of rows are : " + ColNum);

		Object Data[][] = new Object[RowNum - 1][ColNum];

		for (int i = 0; i < RowNum - 1; i++) {
			XSSFRow row1 = (XSSFRow) loadURLSheet.getRow(i + 1);
			for (int j = 0; j < ColNum; j++) {
				if (row1 == null)
					Data[i][j] = "";
				else {
					XSSFCell cell = row1.getCell(j);
					if (cell == null)
						Data[i][j] = "";
					else {
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
	 * *****************************************************************************
	 * *****************************************************************************
	 * *******
	 *
	 */

	@Test(dataProvider = "data-provider") // It get values from ReadVariant function method
	public void AddVariants(String EmployeeName, String EmployeeNumber, String ManagerName, String OKR1, String OKR2,
			String OKR3, String OKR4, String OKR5, String OKR6, String OKR7, String OKR8, String OKR9, String OKR10,
			String OKR11, String OKR12, String OKR13, String OKR14, String OKR15, String OKR16, String OKR17,
			String OKR18, String OKR19, String OKR20, String OKR21, String OKR22, String OKR23, String OKR24,
			String OKR25, String OKR26, String KR1, String KR2, String KR3, String KR4, String KR5, String KR6,
			String KR7, String KR8, String KR9, String KR10, String KR11, String KR12, String KR13, String KR14,
			String KR15, String KR16, String KR17, String KR18, String KR19, String KR20, String KR21, String KR22,
			String KR23, String KR24, String KR25, String KR26, String KR27, String KR28, String KR29, String OverAll)
			throws Exception {
		try {

			System.out.println(" Employee Name      : -----------> " + EmployeeName);
			System.out.println(" Employee Number    : -----------> " + EmployeeNumber);
			System.out.println(" Expected OKR Value : -----------> " +OverAll);
			// System.out.println(Integer.parseInt(OKR1));

			try {
				openOKRMenu();

			} catch (Exception e) {
				openOKRMenu();

			}

			try {
				openUserMenu();

			} catch (Exception e) {
				openUserMenu();

			}

			try {
				openSwitchUser();

			} catch (Exception e) {
				openSwitchUser();

			}

			try {
				SwitchUser(EmployeeName);

			} catch (NoSuchElementException e) {
				SwitchUser(EmployeeName);
				System.out.println("__________________________ USER NOT FOUND_________________________________");


			}

			try {
				clickOKRMenu();

			} catch (Exception e) {
				clickOKRMenu();

			}

			try {
				clickAssignOKR();

			} catch (Exception e) {
				clickAssignOKR();

			}

			try {
				openShowOKR();

			} catch (Exception e) {
				openShowOKR();

			}

			try {
				clickOKROnFilter();

			} catch (Exception e) {
				clickOKROnFilter();

			}

			try {
				openPeriod();

			} catch (Exception e) {
				openPeriod();

			}

			try {
				clearPeriod();

			} catch (Exception e) {
				clearPeriod();

			}

			try {
				choosePeriod();

			} catch (Exception e) {
				choosePeriod();

			}

			try {
				deselectFilter();

			} catch (Exception e) {
				deselectFilter();

			}

			try {
				getOverallOKR();

			} catch (Exception e) {
				getOverallOKR();

			}

			try {
				openUserMenu();

			} catch (Exception e) {

			}

			try {
				SwitchBackToAdmin();

			} catch (Exception e) {
				SwitchBackToAdmin();

			}

		} catch (StaleElementReferenceException e) {
			driver.navigate().refresh();
		} catch (Exception e) {
			//System.out.println(e);
		}

	}
	
	
	
	
	public void openOKRMenu()
	{
		  By okrMenu = By.xpath(
		  "//body//apptivo-profit-left-menu//a[@baseurl='/app/ng/profit.jsp#/pr/okrs/all-my-okrs']"
		  ); click(okrMenu);
	}  
	
	
	 public void openUserMenu()
	  {
	  By openUserMenu =
	  By.xpath("//apptivo-app-header//li/a[@id=\"userSettings\"]");
	  click(openUserMenu);
     }
	
	  public void openSwitchUser()
	  {
	  
	  By openSwitchUser = By.
	  xpath("//apptivo-app-header//ul//div/a[@role=\"button\" and contains(text(),'Switch User')]"
	  ); click(openSwitchUser);
	  }
	
	  public void SwitchUser(String EmployeeName) throws InterruptedException, IOException
	  {
	  Thread.sleep(1000); 
	  try {
	  nameXpathGenerator(EmployeeName).click();
	  }catch(NoSuchElementException e)
	  {
		  driver.navigate().refresh();
		  nameXpathGenerator(EmployeeName).click();
	  }
	  Thread.sleep(3000); 
	  }
	
	
	
	  public void clickOKRMenu() throws InterruptedException
	  {
	  driver.navigate().refresh();
	  By okrMenu = By.xpath(
			  "//body//apptivo-profit-left-menu//a[@baseurl='/app/ng/profit.jsp#/pr/okrs/all-my-okrs']");
	  click(okrMenu);
	  Thread.sleep(2000); 
	  }

	  public void clickAssignOKR() throws InterruptedException
	  {
	  By AssignedOKR = By.xpath(
	  "//body//apptivo-profit-left-menu//a[@baseurl=\"/app/ng/profit.jsp#/pr/okrs/assigned-okrs\"]"
	  ); 
	  click(AssignedOKR);
	  Thread.sleep(2000); 
	  }
	  
	  public void openShowOKR() throws InterruptedException
	  {
	   By openShowOKR = By.xpath("//div[@class='dropdown float-left ml-2']//button[@id='dropdownMenuButton']");
       click(openShowOKR);
		  Thread.sleep(2000); 
	  }
	
	
	  public void clickOKROnFilter() throws InterruptedException
		   {
		   By clickOKR = By.xpath("//a[@title='Show OKRs']"); 
		   click(clickOKR);
		  Thread.sleep(2000); 
		   }

	  
		   public void openPeriod() throws InterruptedException
		   {
	 By clickPeriod = By.xpath("//a[@class='btn btn-outline-secondary btn-sm float-left dropdown-toggle']"); 
	  click(clickPeriod);
	  Thread.sleep(2000); 
		   }
		   
		   public void clearPeriod() throws InterruptedException
		   {
	  
	  By clearPeriod = By.xpath("//a[contains(text(),'Clear')]"); 
	  click(clearPeriod);
	  Thread.sleep(2000); 
		   }
	  
		   public void choosePeriod() throws InterruptedException
		   {
	 By choosePeriod = By.xpath("//label[@for='customCheck0_quart_0'] ");
	  click(choosePeriod);
	  Thread.sleep(2000); 
	  
		   }
		   
		   public void deselectFilter() throws InterruptedException
		   {
			 By deselect = By.xpath("//label[@for='customCheck3_quart_0']");
	 		  WebElement checkbox =  driver.findElement(deselect); 		
	 		  checkbox.click();
	 		 
			  Thread.sleep(2000); 
		   }
	
	
		     public void getOverallOKR()
		      {
		    	  By getOKRValue =By.xpath("//apptivo-objectview//div[@id=\"OKR_LEVEL_HEADER\"]//span"); 
		  		  
		  		  
		  		  try {
		              System.out.println(" Actual OKR Value   : -----------> "+findElement(getOKRValue).getText());
		              System.out.println("___________________________________________________________");


		  		  }catch (NoSuchElementException e)
		  		  {
		  			System.out.println(" Actual OKR Value   : -----------> "+"0");
		            System.out.println("___________________________________________________________");

		  		  }
		      }
	  		 
		  	
		     public void SwitchBackToAdmin() throws InterruptedException
		     {

		     	   By swithcBackToAdminUser = By.xpath("//apptivo-app-header//ul//div/a[@role=\"button\" and contains(text(),'Switch Back')]");
		     	   click(swithcBackToAdminUser);
		     	   
		     		  Thread.sleep(2000); 
		     }
	
	
	/*
	 *  ********************* Get KR values ****************************************
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static WebElement isElementAvailable(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static WebElement isElementVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOf(findElement(locator)));

	}

	/*
	 * public void elementSafe(By locator) {
	 * if(wait.until(ExpectedConditions.presenceOfElementLocated(locator))==true) {
	 * 
	 * } }
	 */

	public void click(By locator) {

		isElementAvailable(locator);
		isElementVisible(locator);
		findElement(locator).click();

	}

	public static WebElement findElement(By locator) {
		try {
			return driver.findElement(locator);
		} catch (StaleElementReferenceException e) {
			driver.navigate().refresh();
			return driver.findElement(locator);
		}
	}

	public WebElement nameXpathGenerator(String username) throws IOException {

		WebElement locator = null;
		By elementPath = By.xpath("//div[@role=\"document\"]//ul/a/div//h5[contains(text(),'" + username + "')]");
		locator = driver.findElement(elementPath);
		return locator;

	}

	public int totalOKRValue(By getOKRValue) {
		int total = 0;
		List<WebElement> path =driver.findElements(getOKRValue);
		for (WebElement singlePath : path) {
			
			System.out.println("Single path tex---- :" +singlePath.getText());
			String s = singlePath.getText();
			total = total + Integer.parseInt(s);
			return total;
		}

		return 0;

	}

	public String doGetText(By locator) {
		try {
			return findElement(locator).getText();
		} catch (StaleElementReferenceException e) {
			System.out.println("Note-----------------: StaleElementReferenceException got triggered ");
			return findElement(locator).getText();
		}
	}

	By hamburgMenu = By.xpath("//apptivo-profit-left-menu//div[@class=\"hamburgmenu\"]/a/ng-svg-icon");

	public void openHamburgMenu() {
		if (getWebElementAttribute(hamburgMenu, "name", "pt-task-hmbgr") == true) {
			System.out.println(" Hamburg Menu in Open State ");
		} else {
			click(hamburgMenu);
		}
	}

	public boolean getWebElementAttribute(By locator, String Attribute, String attributeValue) {
		return findElement(locator).getAttribute(Attribute).contains(attributeValue);

	}
}
