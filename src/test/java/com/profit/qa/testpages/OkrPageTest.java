package com.profit.qa.testpages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.testng.annotations.Test;

import com.profit.qa.basetest.LoginTestBase;
import com.profit.qa.pages.OkrPage;
import com.profit.qa.pages.Page;

public class OkrPageTest extends LoginTestBase {
	Page page = new Page(driver, wait); 
	
	
	@Test
	public void Navigate_To_OKR() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		page.getInstance(OkrPage.class).navigateToOKrPage();
	}
	
	
	
	@Test(dependsOnMethods = { "Navigate_To_OKR" })
	public void Check_Add_OKR() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException, InterruptedException
	{		
		page.getInstance(OkrPage.class).Add_Okr();
	}
	
	
	
	
	
	@Test(dependsOnMethods = { "Navigate_To_OKR" })
	public void Check_edit_OKR() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException, InterruptedException
	{		
		page.getInstance(OkrPage.class).Edit_Okr();
	}
	
	
	
	
	@Test(dependsOnMethods = { "Navigate_To_OKR" })
	public void Check_Delete_OKR() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException, InterruptedException
	{		
		page.getInstance(OkrPage.class).Delete_Okr();
	}


}
