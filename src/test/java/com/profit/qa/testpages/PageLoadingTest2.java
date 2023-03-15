package com.profit.qa.testpages;

import org.testng.annotations.Test;

import com.profit.qa.basetest.LoginTestBase;
import com.profit.qa.pages.LoginPage;
import com.profit.qa.pages.Page;
import com.profit.qa.pages.PageLoading;
import com.profit.qa.pages.PageLoading2;

public class PageLoadingTest2 extends LoginTestBase{

	Page page = new Page(driver, wait);


	@Test()
	public void Entire_Page_Loading() throws Exception
	{
		page.getInstance(LoginPage.class).successfullLogin();
		PageLoading2.checkPageLoading();
	}





}
