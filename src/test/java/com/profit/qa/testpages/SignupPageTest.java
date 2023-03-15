package com.profit.qa.testpages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.profit.qa.Base.Base;
import com.profit.qa.StaticDatas.StaticData;
import com.profit.qa.basetest.SignupTestBase;
import com.profit.qa.pages.SignupPage;

public class SignupPageTest extends SignupTestBase  {


	Base base = new Base(driver, wait) ;
	Faker fake = new Faker();
	Properties prop;
	String configPropPath="src/main/java/com/profit/qa/properties/config.properties";



	@Test()
	public void validateSignupPageLoad() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
	SecurityException
	{
	  String title = page.getInstance(SignupPage.class).signupPageLoad();
	  System.out.println(title);
	  Assert.assertEquals(title, StaticData.signupFormLoadCheck);

	}





	@Test(dependsOnMethods = { "validateSignupPageLoad" })
	public void validateSignupFirstNameEmptyValidation() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
	NoSuchMethodException, SecurityException
	{
		String title = page.getInstance(SignupPage.class).checkfirstNameEmptyvalidation();
		Assert.assertEquals(title, StaticData.signupFirstNameemptyWarning);
	}





	@Test( dependsOnMethods = { "validateSignupFirstNameEmptyValidation" } )
	public void validateSignupSecondNameEmptyValidation() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
	NoSuchMethodException, SecurityException
	{
		String title = page.getInstance(SignupPage.class).checkSecondNameEmptyvalidation();
		Assert.assertEquals(title, StaticData.signupLastNameemptyWarning);
	}





	@Test( dependsOnMethods = { "validateSignupSecondNameEmptyValidation" })
	public void validateSignupEmailEmptyValidation() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
	NoSuchMethodException, SecurityException
	{
		String title = page.getInstance(SignupPage.class).checkEmailEmptyvalidation();
		Assert.assertEquals(title, StaticData.signupEmailemptyWarning);
	}





	@Test(dependsOnMethods = { "validateSignupEmailEmptyValidation" } )
	public void validateSignupInvalidEmailValidation() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
	NoSuchMethodException, SecurityException
	{
		String title = page.getInstance(SignupPage.class).checkInvalidEmailvalidation(fake.name().firstName(), fake.name().lastName(),
				fake.name().firstName() +fake.name().lastName() );
		Assert.assertEquals(title, StaticData.signupInvalidEmailWarning);
	}





	@Test( dependsOnMethods = { "validateSignupInvalidEmailValidation" } )
	public void SignupBasicForm() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException,
	IOException, InterruptedException
	{
		String firstName = fake.name().firstName();
		String lastName = fake.name().lastName();
		String email = firstName + lastName + "@berijam.com";



		/*
		 * ***************************** Below details will be saved on properties files for feature reference *********************************
		 */
		Base.saveOnProperties(configPropPath , "firstName", firstName );
		Base.saveOnProperties(configPropPath , "lastName", lastName);
		Base.saveOnProperties(configPropPath , "email", email);

		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		page.getInstance(SignupPage.class).doSignupBasic(firstName, lastName, email);



	}



		/*
		 * ******************************* Sign up Password page test case's *******************
		 */





	@Test(dependsOnMethods = { "SignupBasicForm" } )
	public void passwordPageLoadChek() throws Exception
	{
		String title = page.getInstance(SignupPage.class).checkPasswordPageLoad();
		Assert.assertEquals(title, StaticData.passwordPageLoadCheck);
	}




	@Test( dependsOnMethods = { "passwordPageLoadChek" } )
	public void firstPasswordEmptyTabValidation() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
	NoSuchMethodException, SecurityException, InterruptedException
	{
		String title = page.getInstance(SignupPage.class).checkEmptyPasswordValidation();
		Assert.assertEquals(title, StaticData.firstPasswordEmptyTabValidation);
	}




	@Test( dependsOnMethods = { "firstPasswordEmptyTabValidation" } )
	public void secondPasswordEmptyTabValidation() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
	NoSuchMethodException, SecurityException, InterruptedException
	{
		String title = page.getInstance(SignupPage.class).CheckConfirmPasswordEmptyValidation();
		Assert.assertEquals(title, StaticData.secondPasswordEmptyTabValidation);
	}




//	@Test( groups= {"Password Page"} , priority = 10)
//	public void lowPasswordValidation() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
//	NoSuchMethodException, SecurityException
//	{
//		String title = page.getInstance(SignupPage.class).checkPasswordPageLoad();
//		Assert.assertEquals(title, StaticData.signupInvalidEmailWarning);
//	}




	@Test( enabled = false  )
	public void PasswordMismatchValidation() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
	NoSuchMethodException, SecurityException, InterruptedException
	{
		String title = page.getInstance(SignupPage.class).checkPasswordMismatchValidation(fake.name().firstName().toUpperCase()+"@123", fake.name().lastName()+"@123");
		Assert.assertEquals(title, StaticData.PasswordMismatchValidation);
	}





	@Test( dependsOnMethods = { "secondPasswordEmptyTabValidation" } )
	public void doSignupPasswordForm() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException,
	IOException, InterruptedException
	{
		//prop = Base.getPropertyAccess("src/main/java/com/profit/qa/properties/config.properties");
	//	String password = prop.getProperty("firstName").toUpperCase()+prop.getProperty("lastName")+"@123" ;
		//Base.saveOnProperties("src/main/java/com/profit/qa/properties/config.properties" , "password", password);
		page.getInstance(SignupPage.class).doSignupPassword("Appas@123");
	}





	@Test( dependsOnMethods = { "doSignupPasswordForm" } )
	public void BusinessNameEmptyTabValidation() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
	NoSuchMethodException, SecurityException
	{
		String title = page.getInstance(SignupPage.class).checkBusinessNameEmptyValidation();
		Assert.assertEquals(title, StaticData.businessForm);
	}





	@Test(dependsOnMethods = { "BusinessNameEmptyTabValidation" }  )
	public void SignupBusinessForm() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException,
	IOException, InterruptedException
	{
		String businessName = fake.name().firstName().concat(" LTD");
		Base.saveOnProperties(configPropPath , "orgName", businessName);
		page.getInstance(SignupPage.class).doSignupBusiness(businessName , fake.phoneNumber().cellPhone());
		Thread.sleep(10000);

	}
}
