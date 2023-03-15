package com.profit.qa.Settings.Pages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;
import com.profit.qa.Base.Base;
import com.profit.qa.pages.OkrPage;
import com.profit.qa.pages.Page;
import com.profit.qa.pages.PageMenus;


public class UserManagementSetting extends Base {
	
	public static Page page = new Page(driver, wait);

	public UserManagementSetting(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	Faker faker = new Faker(); 
	Properties prop; 
	String popup_message;
	String futureReferenceConfigPath="src/main/java/com/profit/qa/Properties/futureReference.properties";

	
	/*
	 * **************** Common Xpaths ****************************************************
	 */
	
    By clickCreateBtn = By.xpath("//button[contains(text(),'Create')]"); 
    By lastName = By.xpath("//apptivo-input//form//input[@placeholder=\"Last Name\"]");
    By MessageText = By.xpath("//td[@id='message_text_new']"); 
    By email = By.xpath("//apptivo-input//form//input[@placeholder=\"Email\"]");
    By open_Dropdown = By.xpath("//apptivo-input//form//button"); 
	By dropdown = By.xpath("//a[contains(text(),'Miss.')]");
    By firstName = By.xpath("//apptivo-input//form//input[@placeholder=\"First Name\"]"); 
    By profileAccessInformation = By.xpath("//div[@class='card-footer cfooter2']//button[@type='button'][normalize-space()='Next'] "); 
    By openRoleDropdown = By.xpath("//profit-multi-select-options//div/a");
    By chooseProfitManager = By.xpath("//profit-multi-select-options//div[contains(text(),'Profit Manager')]"); 
    By chooseReadOnly = By.xpath("//profit-multi-select-options//div[contains(text(),'Profit Read Only')]"); 
    By chooseProfitUser = By.xpath("//profit-multi-select-options//div[contains(text(),'Profit User')]"); 
    By chooseSuperUser = By.xpath("//profit-multi-select-options//div[contains(text(),'Super User')]"); 
    By chooseTaskUser = By.xpath("//profit-multi-select-options//div[contains(text(),'Task User')]"); 
	By click_User_Add_Button = By.xpath("//*[@name='pt-circle-add']//*[name()='svg']");
	By popupOkayBtn = By.xpath("//button[contains(text(),'OK')]"); 
	By popupExitBtn = By.xpath("//apptivo-alert//button[@class=\"close pull-right\"]"); 
	By closeAddUserForm = By.xpath("//modal-container//div/button[@class=\"close\"]"); 


	public static By openUserMenu = By.xpath("//apptivo-app-header//li/a[@id=\"userSettings\"]"); 
	By openSwitchUser = By.xpath("//apptivo-app-header//ul//div/a[@role=\"button\" and contains(text(),'Switch User')]"); 
	
	By findEmail = By.xpath("//div[@role=\"document\"]//ul/a/div//p[contains(text(),'111@gmail.com')]");
	
	By getDetailsFromActiveUserPage = By.xpath("//apptivo-bydirectoryview//table/tbody/tr/td/div");
	

/*
 * **************************** Method will navigate to test page where all the below test method going to execute *************
 */


	public  void navigate_To_Active_User() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException
	{
	
		page.getInstance(PageMenus.class).enableHomeMenu();
		page.getInstance(PageMenus.class).enableSettingMenu();
		page.getInstance(PageMenus.class).checkActiveUserPageSetting();
	}
	
	
	
	


	/*
	 * ********************* Form Mandatory detail Validation ***********************************
	 * 
	 * <methods> 
	 *  name="validate_Last_Name_Empty_Validation"/>
	 *  name="validate_Email_Empty_Validation"/>
	 *  name="validate_Invalid_Email_Validation"/> 
	 *  name="validate_Invalid_Email_Validation"/> 
	 * </methods> 
	 *
	 */
 

	public  String validate_Last_Name_Empty_Validation() throws InterruptedException 
	{
		click(click_User_Add_Button);
		click(clickCreateBtn); 
		popup_message = doGetText(MessageText);
		click(popupExitBtn);
		click(closeAddUserForm);
		return popup_message ;
	}
	
	
	
	
	public  String validate_Email_Empty_Validation() throws InterruptedException
	{
		click(click_User_Add_Button);
		sendkeys(lastName,faker.name().lastName());
		click(clickCreateBtn); 
		popup_message = doGetText(MessageText);
		click(popupExitBtn);
		click(closeAddUserForm);
		return popup_message;
	}
	
	
	
	
	public  String validate_Invalid_Email_Validation() throws InterruptedException
	{
		click(click_User_Add_Button);
		sendkeys(lastName,faker.name().lastName());
		sendkeys(email,faker.name().lastName());
		click(clickCreateBtn); 
		popup_message = doGetText(MessageText);
		click(popupExitBtn);
		click(closeAddUserForm);
		return popup_message;		
	}
	
	

	
	/*
	 * ********************* Create user's with all user privilege  ***********************************
	 * 
	 * <methods> 
	 *  name="create_Profit_Manager"/>
	 *  name="create_Read_only_user"/>
	 *  name="create_Profit_User"/> 
	 *  name="create_Super_User"/> 
	 *  name="create_Task_User"/> 
	 * </methods> 
	 * 
	 */
	
	
	public boolean Create_Profit_Manager() throws InterruptedException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException 
	{
		String Email=faker.internet().emailAddress();
		saveOnProperties(futureReferenceConfigPath, "profitManagerEmail", Email);
		int before = validateCreateUser();
		
		System.out.println(before);
        click(click_User_Add_Button);
		click(open_Dropdown);
		click(dropdown);
		sendkeys(firstName, faker.name().firstName());
		sendkeys(lastName, faker.name().lastName());
		sendkeys(email, Email);
		click(profileAccessInformation);
		click(openRoleDropdown);
		click(chooseProfitManager);
		click(clickCreateBtn);
		Thread.sleep(4000);
		int after = validateCreateUser();
		System.out.println(after);

		return CompareTwoIntValue(before,after);

	}
	
	
	
	
	public boolean Create_Read_Only_User() throws InterruptedException, IOException 
	{
		String Email=faker.internet().emailAddress();
		saveOnProperties(futureReferenceConfigPath, "readOnlyUserEmail", Email);
		
		int before = validateCreateUser();
        click(click_User_Add_Button);
		click(open_Dropdown);
		click(dropdown);
		sendkeys(firstName, faker.name().firstName());
		sendkeys(lastName, faker.name().lastName());
		sendkeys(email, Email);
		click(profileAccessInformation);
		click(openRoleDropdown);
		click(chooseReadOnly);
		click(clickCreateBtn);
		Thread.sleep(4000);
		int after = validateCreateUser();
		return CompareTwoIntValue(before,after);

	}
	
	
	
	
	public boolean Create_Profit_User() throws InterruptedException, IOException 
	{
		String Email=faker.internet().emailAddress();
		saveOnProperties(futureReferenceConfigPath, "profitUserEmail", Email);
		
		int before = validateCreateUser();
        click(click_User_Add_Button);
		click(open_Dropdown);
		click(dropdown);
		sendkeys(firstName, faker.name().firstName());
		sendkeys(lastName,faker.name().lastName());
		sendkeys(email,Email);
		click(profileAccessInformation);
		click(openRoleDropdown);
		click(chooseProfitUser);
		click(clickCreateBtn);
		Thread.sleep(4000);
		int after = validateCreateUser();
		return CompareTwoIntValue(before,after);
	
		}
	
	
	
	
	public boolean Create_Super_User() throws InterruptedException, IOException 
	{
		String Email=faker.internet().emailAddress();
		saveOnProperties(futureReferenceConfigPath, "superUserEmail", Email);
		
		int before = validateCreateUser();
        click(click_User_Add_Button);
		click(open_Dropdown);
		click(dropdown);
		sendkeys(lastName,faker.name().lastName());
		sendkeys(email,Email);
		click(profileAccessInformation);
		click(openRoleDropdown);
		click(chooseSuperUser);
		click(clickCreateBtn);
		Thread.sleep(4000);
		int after = validateCreateUser();
		return CompareTwoIntValue(before,after);

	}
	
	
	
	
	public boolean Create_Task_User() throws InterruptedException, IOException 
	{
		String Email = faker.internet().emailAddress();
		saveOnProperties(futureReferenceConfigPath, "taskUserEmail", Email);

		int before = validateCreateUser();
		click(click_User_Add_Button);
		click(open_Dropdown);
		click(dropdown);
		sendkeys(lastName, faker.name().lastName());
		sendkeys(email, Email);
		click(profileAccessInformation);
		click(openRoleDropdown);
		click(chooseTaskUser);
		click(clickCreateBtn);
		Thread.sleep(4000);
		int after = validateCreateUser();
		return CompareTwoIntValue(before, after);

	}
	
	
	
	/*
	 * *********************  Create user's with all user privilege  **********************************
	 */
	
	
	// Validate switch functionality is working fine or not with Task User 
	
	String userEmail =null;
	By swithcBackToAdminUser = By.xpath("//li/div/a[@role='button']");

	
	public String Check_Task_User_Access() throws InterruptedException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		
		Create_Task_User();
		driver.get(getCurrentPageUrl());
		click(openUserMenu);
		click(openSwitchUser);
		click(emailXpathGenerator(futureReferenceConfigPath, "taskUserEmail", "switch"));
		Thread.sleep(4000);
		wait.until(ExpectedConditions.presenceOfElementLocated(openUserMenu));
		click(openUserMenu);
		userEmail=doGetText(emailXpathGenerator(futureReferenceConfigPath, "taskUserEmail", "user_email"));
		click(swithcBackToAdminUser);
		return userEmail;

	}
	
	
	
	
	// Validate switch functionality is working fine or not with Super User 
	
		public String Check_Super_User_Access() throws InterruptedException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
		{

			Create_Super_User();
			driver.get(getCurrentPageUrl());
			click(openUserMenu);
			click(openSwitchUser);
			click(emailXpathGenerator(futureReferenceConfigPath, "superUserEmail", "switch"));
			Thread.sleep(4000);
			wait.until(ExpectedConditions.presenceOfElementLocated(openUserMenu));
			click(openUserMenu);
			userEmail= doGetText(emailXpathGenerator(futureReferenceConfigPath, "superUserEmail", "user_email"));
			click(swithcBackToAdminUser);
			return userEmail;

		}
		
		
		
		
		// Validate switch functionality is working fine or not with Profit User 
		
			public String Check_Profit_User_Access() throws InterruptedException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
			{

				Create_Profit_User();
				driver.get(getCurrentPageUrl());
				click(openUserMenu);
				click(openSwitchUser);
				click(emailXpathGenerator(futureReferenceConfigPath, "profitUserEmail", "switch"));
				Thread.sleep(4000);
				wait.until(ExpectedConditions.presenceOfElementLocated(openUserMenu));
				click(openUserMenu);
				userEmail = doGetText(emailXpathGenerator(futureReferenceConfigPath, "profitUserEmail", "user_email"));
				click(swithcBackToAdminUser);
				return userEmail;

			}
			
			
			// Validate switch functionality is working fine or not with Read Only User 
			
			public String Check_Read_Only_User_Access() throws InterruptedException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
			{
				  Create_Read_Only_User(); 
				  driver.get(getCurrentPageUrl()); 
				  click(openUserMenu); 
				  click(openSwitchUser); 
			      click(emailXpathGenerator(futureReferenceConfigPath, "readOnlyUserEmail" , "switch")); 
		          Thread.sleep(4000); 
			      wait.until(ExpectedConditions.presenceOfElementLocated(openUserMenu)); 
			      click(openUserMenu); 
			      userEmail= doGetText(emailXpathGenerator(futureReferenceConfigPath, "readOnlyUserEmail", "user_email")); 
			      click(swithcBackToAdminUser);
				  return userEmail;
			}
			
			
			
			
			
			// Validate switch functionality is working fine or not with Profit Manager User 
			
			public String Check_Profit_Manager_User_Access() throws InterruptedException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
			{
				Create_Profit_Manager();
				driver.get(getCurrentPageUrl());
				click(openUserMenu);
				click(openSwitchUser);
				click(emailXpathGenerator(futureReferenceConfigPath, "profitManagerEmail", "switch"));
				Thread.sleep(4000);
				wait.until(ExpectedConditions.presenceOfElementLocated(openUserMenu));
				click(openUserMenu);
				userEmail= doGetText(emailXpathGenerator(futureReferenceConfigPath, "profitManagerEmail", "user_email"));
				click(swithcBackToAdminUser);
				return userEmail;
			}
	
	
	
	
			public void checkTasKUserURLAccess() throws IOException, InterruptedException 
			{
				click(openUserMenu);
			    click(openSwitchUser);
				if(driver.findElement(emailXpathGenerator(futureReferenceConfigPath, "taskUserEmail", "switch")).isDisplayed())
				{
					click(emailXpathGenerator(futureReferenceConfigPath, "taskUserEmail", "switch"));
				}else
				{
				Create_Task_User();
				driver.get(getCurrentPageUrl());
				click(openUserMenu);
				click(openSwitchUser);
				click(emailXpathGenerator(futureReferenceConfigPath, "taskUserEmail", "switch"));
				Thread.sleep(4000);
				
				}
			}
			
			
			public String Check_Super_User_Control() throws InterruptedException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
			{
				Check_Super_User_Access();
				Thread.sleep(5000);
				return page.getInstance(PageMenus.class).enableSettingMenu(); 
			}
			
			
			
			public void Check_Profit_User_Control() throws IOException, InterruptedException 
			{
				click(openUserMenu);
			    click(openSwitchUser);
				if(driver.findElement(emailXpathGenerator(futureReferenceConfigPath, "profitUserEmail", "switch")).isDisplayed())
				{
					click(emailXpathGenerator(futureReferenceConfigPath, "profitUserEmail", "switch"));
				}else
				{
				Create_Profit_User();
				driver.get(getCurrentPageUrl());
				click(openUserMenu);
				click(openSwitchUser);
				click(emailXpathGenerator(futureReferenceConfigPath, "profitUserEmail", "switch"));
				Thread.sleep(2000);
				}
			}
			
			
			
			
			
			public void Check_Read_Only_User_Control() throws IOException, InterruptedException 
			{
				click(openUserMenu);
			    click(openSwitchUser);
				if(driver.findElement(emailXpathGenerator(futureReferenceConfigPath, "readOnlyUserEmail", "switch")).isDisplayed())
				{
					click(emailXpathGenerator(futureReferenceConfigPath, "readOnlyUserEmail", "switch"));
				}else
				{
				Create_Read_Only_User();
				driver.get(getCurrentPageUrl());
				click(openUserMenu);
				click(openSwitchUser);
				click(emailXpathGenerator(futureReferenceConfigPath, "readOnlyUserEmail", "switch"));
				Thread.sleep(2000);
				}
			}
			
			
			
			
			public void Profit_User_Control() 
			{
				
			}
			
			
			
			
			public void Check_Task_User_Control() 
			{
				
			}
	
	
	
	
	
	
	
	
	
	
	
	
	
			
			
	
	
	
	
	
	
	
	// Profit user validations 
			
	public void  Profit_User_Has_Access_To_Create_Objective_And_Key_Result() throws Exception 
	{
	
		Check_Profit_User_Control(); 
		page.getInstance(OkrPage.class).Add_Okr();
	}
	
	
	
	
	
	
	
	public void Profit_User_Has_Access_To_Update_Objective_And_Key_Result() throws IOException, InterruptedException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException 
	{
		Check_Profit_User_Control(); 
		page.getInstance(OkrPage.class).Edit_Okr();
	}
	
	
	
	
	public void Profit_User_Has_Access_To_Delete_Objective_And_Key_Result() throws IOException, InterruptedException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException 
	{
		Check_Profit_User_Control(); 
		page.getInstance(OkrPage.class).Delete_Okr();
	}
	
	
	public int Profit_User_URL_Restrcition() throws Exception 
	{
		By homeMenu = By.xpath("//body//apptivo-profit-left-menu//div[@class=\"twomain\"]//ul/li/a");
		By allMenu = By.xpath("//body//a");
		return Separate_URL_Based_On_URL_Path(checkAllPage(getSideMenuUrl(homeMenu), allMenu),URLPath.SETTINGS.toString() );

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int validateCreateUser()
	{
		int user = 0;
		try {
			List<WebElement> tableElements = driver.findElements(getDetailsFromActiveUserPage);
			/*
			 * Have to make it more dynamic for iteration value " 8 "
			 */
			for (int j = 0; j < tableElements.size(); j = j + 8) {
				if (tableElements.size() == 1 && tableElements.get(j).getText().contains("No users found.")) {
					validateCreateUser();
				} else {
					user = user + Integer.parseInt(tableElements.get(j).getText());
				}
			}

		} catch (StaleElementReferenceException e) {
			System.out.println("StaleElementReferenceException Exception got triggered");
			driver.get(getCurrentPageUrl());
			validateCreateUser();
		}
		return user;
	}
	

	public void checkPageLoadingDone(String PageName)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		if (jse.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println(PageName + " :------------> Done");

		}
	}
	
	
	public boolean CompareTwoIntValue(int one , int two)
	{
		if (one != two) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/*
	 * @param path -> property file path
	 * @param pathname -> name of the node which you want to get from the property file 
	 * @param from -> 
	 *  # use "switch" if you want to generate xpath to find email from the switch user list 
	 *  # use "user_email" if you want to validate the current login user's xpath
	 */
	public By emailXpathGenerator(String path , String pathName , String from) throws IOException
	{
		prop = getPropertyAccess(path);
		prop.getProperty(pathName);
		By locator = null; 
		if(from.contains("switch"))
		{
		By elementPath= By.xpath("//div[@role=\"document\"]//ul/a/div//p[contains(text(),'"+prop.getProperty(pathName)+"')]");
		locator= elementPath;
		}
		else if(from.contains("user_email"))
		{
			By elementPath= By.xpath("//p[contains(text(),'"+prop.getProperty(pathName)+"')]"); 

			locator= elementPath;

		}
		return locator;
		
	}
	
	/*
	 * @param allURL -> will get list of url
	 * @param settings -> Particular URL body for to identify the URL Section
	 */
	
	public int Separate_URL_Based_On_URL_Path(List<String> allURL , String settings)
	{

		List<String> validURLs = new ArrayList<>();
		List<String> invalidURLs = new ArrayList<>();
		for (String url : allURL) {
			System.out.println("entered inside for loop ");
			if (url.contains(settings)) {
				invalidURLs.add(url);
				System.out.println("invalid URL " +invalidURLs.size());

			} else {
				System.out.println("******************************");
				System.out.println(url);
				validURLs.add(url);
				System.out.println("valid URL " +validURLs);

			}
		}
		System.out.println("invalid URL " +invalidURLs.size());
		return invalidURLs.size();
	}
	
	
	/*
	 * ***************** enum values for to URL Path name ****************************************
	 */
	
	
	public enum URLPath 
	{
		HOME("profit_home"), OKR("okrs"), TASK("tasks"), CFR("cfrs"), SETTINGS("settings"), PREFERENCE("preferences");
		private final String name;
		URLPath(String name) 
		{
			this.name = name;  
		}
		public String getName() 
		{ 
			return this.name; 
		}
	}

}
