package com.profit.qa.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.profit.qa.Base.Base;

public class LoginPage extends Base {

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	Properties prop = new Properties();
    String configPath ="src/main/java/com/profit/qa/Properties/config.properties";

	// Login Page Locator's

	By loginPageTitle = By.xpath("/html/body/div[1]/div/div/div/div[2]/form/div[1]/div/div[1]/h1");
	By emailId = By.id("login_email");
	By password = By.name("password");
	By loginBtn = By.id("login_btn");
	By forgotPasswordBtn = By.name("password");
	By wrongPasswordError = By.id("log_error");
	By wrongEmailError = By.id("log_error");
	By multipleattemptWarning = By.id("att_err_msg");
	By successLogin = By.xpath("/html/body/app-root/div/div/div/main/div/apptivo-okr-list/div/div/div[1]/div/div[1]/h4");
   
	// Login Page Actions's

	public String getloginpagetitle()
	{
		return driver.getTitle();

	}






	public String checkInvalidPassowrd(String email , String pass) throws InterruptedException {
		By password = By.name("password");
		inputClick(emailId);
		sendkeys(emailId , email) ;
		inputClick(password);
		sendkeys(password , pass) ;
		click(loginBtn);
		Thread.sleep(4000);
        return doGetText(wrongPasswordError);
	}






	public String checkInvalidEmail(String email , String pass) {
		inputClick(emailId);
		sendkeys(emailId , email) ;
		inputClick(password);
		sendkeys(password , pass) ;
        return doGetText(wrongEmailError);
	}






	public String checkMultipleAttempt(String email , String pass) throws InterruptedException {
		for(int i=0 ; i<=2 ; i++)
		{
			inputClick(emailId);
			sendkeys(emailId , email) ;
			inputClick(password);
			sendkeys(password , pass) ;
			Thread.sleep(1000);
			click(loginBtn);
			clear(emailId);
			clear(password);
			Thread.sleep(4000);
		} return doGetText(multipleattemptWarning);
	}






	public String successfullLogin() throws InterruptedException, IOException {
		inputClick(emailId);
		sendkeys(emailId, getValueFromProperty(configPath, "loginEmail"));
		inputClick(password);
		sendkeys(password, getValueFromProperty(configPath, "loginPassword"));
		click(loginBtn);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(hamburgMenu));
		openHamburgMenu(); 
        return driver.getTitle();
	}
	
	
	

	
	/*
	 *  ******************************************* Login Page Support Method's ***********************
	 */
	
	By hamburgMenu = By.xpath("//apptivo-profit-left-menu//div[@class=\"hamburgmenu\"]/a/ng-svg-icon");

	public void openHamburgMenu()
	{
		if(getWebElementAttribute(hamburgMenu, "name", "pt-task-hmbgr")==true)
		{
        System.out.println(" Hamburg Menu in Open State ");		}
		else
		{
			click(hamburgMenu); 
		}
	}

}
