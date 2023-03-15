package com.profit.qa.testpages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.profit.qa.Base.Base;
import com.profit.qa.StaticDatas.StaticData;
import com.profit.qa.basetest.LoginTestBase;
import com.profit.qa.pages.LoginPage;

public class LoginPageTest extends LoginTestBase {
	
	private LoginPage loginPage = new LoginPage(driver, wait);

	public LoginPageTest() throws IOException, InterruptedException
	{
		super();
	}

	Properties prop = new Properties();
	StaticData staticdata;
	Base base;


	@Test
	public void verifyloginpagetitle() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
	String title = page.getInstance(LoginPage.class).getloginpagetitle();
	Assert.assertEquals(title , StaticData.loginText );
	Base.getBrowserEntries();
	loginPage.checkInvalidEmail(title, title);
	}




	@Test( dependsOnMethods = { "verifyloginpagetitle" } )
	public void checkInvalidPassowrdWarning() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException
	{
		LoginPage lp = new LoginPage(driver, wait); 
	String title = lp.checkInvalidPassowrd("wedstagar1611@berijam.com", "yeigfygfld");
	Assert.assertEquals(title , StaticData.wrongPasswordWarning );
	
	}




	@Test( dependsOnMethods = { "checkInvalidPassowrdWarning" } )
	public void checkInvalidEmailWarning() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
	String title = page.getInstance(LoginPage.class).checkInvalidEmail("appas@gggg", "1231");
	Assert.assertEquals(title , StaticData.wrongEmailWarning );
	}




	@Test( dependsOnMethods = { "checkInvalidEmailWarning" } )
	public void checkMultipleAttemptWarning() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException
	{
	String title = page.getInstance(LoginPage.class).checkMultipleAttempt("appasfortest@gmail.com", "Appas@12345678");
	Assert.assertEquals(title , StaticData.afterAccountLocked );
	}




	@Test(  ) //dependsOnMethods = { "checkMultipleAttemptWarning" }
	public void checkSuccessloginText() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	prop=Base.getPropertyAccess("src/main/java/com/profit/qa/Properties/config.properties");
	String title = page.getInstance(LoginPage.class).successfullLogin();
	Assert.assertEquals(title , StaticData.successLogin );
	}
	


}

