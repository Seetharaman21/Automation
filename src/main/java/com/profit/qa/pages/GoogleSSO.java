package com.profit.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.profit.qa.Base.Base;

public class GoogleSSO extends Base {

	public GoogleSSO(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	/*
	 *  Google signup login
	 */
	By clickGoogleLogin = By.xpath("//a[@href=\"/app/resellerOAuth2?oa2s=google&appCode=profit&providerCode=Google\"]");
	By googleEmail = By.xpath("//input[@id='identifierId'  or @name=\"identifier\"]");
	By nextBtn = By.xpath("//span[contains(text(),'Next')]");
	By password = By.xpath("//input[@type=\"password\"]");// and @name=\"password\"
	By passwordNextBtn = By.xpath("//div[@id=\"passwordNext\" ]").xpath("//span[contains(text(),'Next')]");




	/*
	 * ************************* Google Login Page Actions ***************************************
	 */


	public void doGoogleLogin()
	{
		click(clickGoogleLogin);
		inputClick(googleEmail);
		sendkeys(googleEmail, "appasazlan09@gmail.com");
		click(nextBtn);
		inputClick(password);
		sendkeys(password, "I am an ias officer9$");
		click(passwordNextBtn);
	}

}
