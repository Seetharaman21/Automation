package com.profit.qa.testpages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.testng.annotations.Test;

import com.profit.qa.Base.Base;
import com.profit.qa.Settings.Pages.UserManagementSetting;
import com.profit.qa.basetest.LoginTestBase;
import com.profit.qa.pages.ClientData;
import com.profit.qa.pages.LoginPage;
import com.profit.qa.pages.Page;

public class ClientDataTest extends LoginTestBase   {
	
	Base base = new Base(driver, wait); 
	PageMenusTest pageMenu = new PageMenusTest();
	Page page = new Page(driver, wait); 
	
	
	
	
	@Test(priority=1)
	public void checkClientSetup() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{   page.getInstance(LoginPage.class).doLogin();
		page.getInstance(ClientData.class).clientSetup();

	}
	
	
}
