package com.profit.qa.testpages;

import org.testng.annotations.Test;

import com.profit.qa.basetest.LoginTestBase;
import com.profit.qa.pages.LoginPage;
import com.profit.qa.pages.Page;
import com.profit.qa.pages.PageLoading;

public class PageLoadingTest extends LoginTestBase{

	Page page = new Page(driver, wait);



	@Test()
	public void Entire_Page_Loading() throws Exception
	{
		page.getInstance(LoginPage.class).successfullLogin();
		PageLoading.checkPageLoading();
	}





}
