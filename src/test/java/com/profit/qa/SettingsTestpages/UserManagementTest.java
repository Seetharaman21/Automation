package com.profit.qa.SettingsTestpages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.profit.qa.Base.Base;
import com.profit.qa.Settings.Pages.UserManagementSetting;
import com.profit.qa.StaticDatas.PageLoadingStaticData;
import com.profit.qa.StaticDatas.SettingPageStaticData;
import com.profit.qa.basetest.LoginTestBase;
import com.profit.qa.pages.LoginPage;
import com.profit.qa.pages.Page;
import com.profit.qa.testpages.PageMenusTest;

public class UserManagementTest extends LoginTestBase {
	Base base = new Base(driver, wait); 
	PageMenusTest pageMenu = new PageMenusTest();
	Page page = new Page(driver, wait); 
	String featureReferencePropertyFilePath= "src/main/java/com/profit/qa/Properties/futureReference.properties";

	/*
	 * ********************* Form Mandatory detail Validation ***********************************
	 * 
	 * <class name="com.profit.qa.Settings.Pages.UserManagementTest">
	 * <methods> 
	 * <include name="Navigate_To_Active_User_Page"/>
	 * <include name="Validate_Last_Name_Empty_Tab_Warning"/>
	 * <include name="Validate_Email_Empty_Tab_Warning"/> 
	 * <include name="Validate_Invalid_Email_Warning"/> 
	 * </methods> 
	 * </class>
	 * 
	 */
	
	
	@Test(priority=1)
	public void Navigate_To_Active_User_Page() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{   
		page.getInstance(LoginPage.class).successfullLogin(); 
		page.getInstance(UserManagementSetting.class).navigate_To_Active_User();

	}
	
	@Test()
	public void Login_Alone() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{   
		page.getInstance(LoginPage.class).successfullLogin(); 

	}
	
	
	
	
	@Test(priority=2 , dependsOnMethods = { "Navigate_To_Active_User_Page" })
	public void Validate_Last_Name_Empty_Tab_Warning() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException
	
	{
	   String title=page.getInstance(UserManagementSetting.class).validate_Last_Name_Empty_Validation();
	   Assert.assertEquals(title, SettingPageStaticData.secondNameEmptyTabValidation);
	}
	
	


	
	@Test(priority=3 , dependsOnMethods = { "Navigate_To_Active_User_Page" })
	public void Validate_Email_Empty_Tab_Warning() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException
	
	{
	   String title=page.getInstance(UserManagementSetting.class).validate_Email_Empty_Validation();
	   Assert.assertEquals(title, SettingPageStaticData.emailEmptyTabValidation);
	}
	
	
	
	
	@Test(priority=4 , dependsOnMethods = { "Navigate_To_Active_User_Page" })
	public void Validate_Invalid_Email_Warning() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException
	
	{
	   String title=page.getInstance(UserManagementSetting.class).validate_Invalid_Email_Validation();
	   Assert.assertEquals(title, SettingPageStaticData.invalidEmailEmptyTabValidation);
	}
	
	
	
	
	/*
	 * ********************* Create user's with all user privilege  ***********************************
	 * <class name="com.profit.qa.Settings.Pages.UserManagementTest">
	 * <methods> 
	 *  name="create_Profit_Manager"/>
	 *  name="create_Read_only_user"/>
	 *  name="create_Profit_User"/> 
	 *  name="create_Super_User"/> 
	 *  name="create_Task_User"/> 
	 * </methods> 
	 * </class>
	 */
	
	
	
	
	
	@Test(priority=5 , dependsOnMethods = { "Navigate_To_Active_User_Page" })
	public void create_Profit_Manager() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	
	{
	 boolean status= page.getInstance(UserManagementSetting.class).Create_Profit_Manager();
	 Assert.assertEquals(true, status);
	}
	
	
	
	
	@Test(priority=6 , dependsOnMethods = { "Navigate_To_Active_User_Page" })
	public void create_Read_only_user() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	
	{
		 boolean status=page.getInstance(UserManagementSetting.class).Create_Read_Only_User();
		 Assert.assertEquals(true, status);
	}
	
	
	
	
	@Test(priority=7 , dependsOnMethods = { "Navigate_To_Active_User_Page" })
	public void create_Profit_User() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	
	{
		 boolean status=page.getInstance(UserManagementSetting.class).Create_Profit_User();
		 Assert.assertEquals(true, status);
	}
	
	
	
	
	@Test(priority=8 , dependsOnMethods = { "Navigate_To_Active_User_Page" })
	public void create_Super_User() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	
	{
		 boolean status=page.getInstance(UserManagementSetting.class).Create_Super_User();
		 Assert.assertEquals(true, status);
	}
	
	
	
	
	@Test(priority=9 , dependsOnMethods = { "Navigate_To_Active_User_Page" })
	public void create_Task_User() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	
	{
		boolean status= page.getInstance(UserManagementSetting.class).Create_Task_User();
	   Assert.assertEquals(true, status);
	}
	
	
	

	
	@Test(priority=11 , dependsOnMethods = { "Navigate_To_Active_User_Page" })
	public void Check_Task_User_Access() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	
	{
	 page.getInstance(UserManagementSetting.class).navigate_To_Active_User();
	 String currentUserEmail= page.getInstance(UserManagementSetting.class).Check_Task_User_Access();
	 Assert.assertEquals(currentUserEmail, 
	 base.getValueFromProperty(featureReferencePropertyFilePath , "taskUserEmail"));
	}
	
	
	
	
	@Test(priority=12 , dependsOnMethods = { "Navigate_To_Active_User_Page" })
	public void Check_Profit_User_Access() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	
	{
	 page.getInstance(UserManagementSetting.class).navigate_To_Active_User();
	 String currentUserEmail= page.getInstance(UserManagementSetting.class).Check_Profit_User_Access();	 
	 Assert.assertEquals(currentUserEmail, 
	 base.getValueFromProperty(featureReferencePropertyFilePath , "profirUserEmail"));
	}
	
	
	
	
	@Test(priority=13 , dependsOnMethods = { "Navigate_To_Active_User_Page" })
	public void Check_Super_User_Access() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	
	{
		
	 page.getInstance(UserManagementSetting.class).navigate_To_Active_User();
	 String currentUserEmail= page.getInstance(UserManagementSetting.class).Check_Super_User_Access();
	 Assert.assertEquals(currentUserEmail, 
	 base.getValueFromProperty(featureReferencePropertyFilePath , "superUserEmail"));
	}

	
	
	
	
	@Test(priority=14 , dependsOnMethods = { "Navigate_To_Active_User_Page" })
	public void Check_Read_Only_User_Access() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	
	{
	 page.getInstance(UserManagementSetting.class).navigate_To_Active_User();
	 String currentUserEmail= page.getInstance(UserManagementSetting.class).Check_Read_Only_User_Access();
	 Assert.assertEquals(currentUserEmail, 
	 base.getValueFromProperty(featureReferencePropertyFilePath , "readOnlyUserEmail"));
	}

	
	
	
	
	@Test(priority=15 , dependsOnMethods = { "Navigate_To_Active_User_Page" })
	public void Check_Profit_Manager_User_Access() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	
	{
	 page.getInstance(UserManagementSetting.class).navigate_To_Active_User();
	 String currentUserEmail= page.getInstance(UserManagementSetting.class).Check_Profit_Manager_User_Access();	 
	 Assert.assertEquals(currentUserEmail, 
	 base.getValueFromProperty(featureReferencePropertyFilePath , "profitManagerEmail"));
	}
	
	
	
	@Test(priority = 16, dependsOnMethods = { "Navigate_To_Active_User_Page" })
	public void Check_Super_User_Control()
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, InterruptedException, IOException

	{
		String title=page.getInstance(UserManagementSetting.class).Check_Super_User_Control();
		System.out.println(title);
		Assert.assertEquals(title , PageLoadingStaticData.settingMainTitle );
	}
	
	
	
	
	
	
	@Test(priority = 16, dependsOnMethods = { "Navigate_To_Active_User_Page" })
	public void Check_Profit_User_Control()throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,NoSuchMethodException, SecurityException, InterruptedException, IOException

	{
		page.getInstance(UserManagementSetting.class).Check_Profit_User_Control();
	
	}
	
	
	
	
	
	
	@Test(priority = 17, dependsOnMethods = { "Login_Alone" })
	public void Profit_User_Has_Access_To_Create_Objective_And_Key_Result()
			throws Exception

	{
		page.getInstance(UserManagementSetting.class).Profit_User_Has_Access_To_Create_Objective_And_Key_Result();
	}
	
	
	
	
	
	
	
	@Test(priority = 17, dependsOnMethods = { "Login_Alone" })
	public void Profit_User_Has_Access_To_Update_Objective_And_Key_Result()
			throws Exception

	{
		page.getInstance(UserManagementSetting.class).Profit_User_Has_Access_To_Update_Objective_And_Key_Result();
	}
	
	
	
	
	
	
	
	@Test(priority = 17, dependsOnMethods = { "Login_Alone" })
	public void Profit_User_Has_Access_To_Delete_Objective_And_Key_Result()
			throws Exception

	{
		page.getInstance(UserManagementSetting.class).Profit_User_Has_Access_To_Delete_Objective_And_Key_Result();
	}
	
	
	
	
	
	@Test(priority = 17, dependsOnMethods = { "Login_Alone" })
	public void Profit_User_URL_Restrcition()throws Exception

	{
		int size =	page.getInstance(UserManagementSetting.class).Profit_User_URL_Restrcition();
		Assert.assertEquals(size , 0 );
	}

	
	
	
	

}
