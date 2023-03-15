package com.profit.qa.testpages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


import org.testng.annotations.Test;

import com.profit.qa.basetest.LoginTestBase;
import com.profit.qa.pages.CFR_Points;
import com.profit.qa.pages.LoginPage;
import com.profit.qa.pages.Page;


public class CFRpointsTest extends LoginTestBase {

	Page page = new Page(driver, wait) ;
	@Test(priority = 1)
	public void Navigate_to_CFR_Recognition_Home() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
		page.getInstance(LoginPage.class).successfullLogin();
		page.getInstance(CFR_Points.class).CFR_Recognition_Home();
	}
	
	@Test(priority = 2,dependsOnMethods = {"Navigate_to_CFR_Recognition_Home"})
	public void CFR_Recognition_Add_Receiptent_And_Add_Points() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
		
		page.getInstance(CFR_Points.class).Add_Receiptent_and_Points();
	}
	@Test(priority = 3,dependsOnMethods = {"CFR_Recognition_Add_Receiptent_And_Add_Points"})
	public void Switch_User() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException {
		page.getInstance(CFR_Points.class).Switch_user();
		page.getInstance(CFR_Points.class).CFR_Recognition_Home();
		
	}
	@Test(priority = 4,dependsOnMethods = {"Switch_User"})
	public void Validation_For_CFR_Recognition_points() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException {
		
		page.getInstance(CFR_Points.class).add_Rewards();
	}
	@Test(priority = 5,dependsOnMethods = {"Validation_For_CFR_Recognition_points"})
	public void Validation_For_Points_Rewarded_to_user() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException {
		page.getInstance(CFR_Points.class).Validation_for_Rewards_added();
	}
	
	
	
	

}