package com.profit.qa.testpages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.testng.annotations.Test;

import com.profit.qa.basetest.LoginTestBase;
import com.profit.qa.pages.LoginPage;
import com.profit.qa.pages.Page;
import com.profit.qa.pages.SettingReflection;

public class SettingReflectionTest extends LoginTestBase{

	
Page page = new Page(driver, wait) ;
	
	@Test
	public void Validate_OKR_Management_Menu_Hide() throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException 
	{   
		page.getInstance(LoginPage.class).successfullLogin();
		
		
	 page.getInstance(SettingReflection.class).Validate_OKR_Management_Menu_Hide();
		//Assert.assertEquals(false, value);
	}
	
	
	
	
	@Test
	public void checktoggle() throws InstantiationException, IllegalAccessException,
	IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException 
	{   
	page.getInstance(LoginPage.class).successfullLogin();
	
	page.getInstance(SettingReflection.class).checkisdisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
