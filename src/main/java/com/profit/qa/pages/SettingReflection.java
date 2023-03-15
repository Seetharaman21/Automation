package com.profit.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import com.profit.qa.Base.Base;

public class SettingReflection extends Base  {

	public SettingReflection(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	/*
	 * ***************** Task Management Reflections **************************
	 */
	

	public void enableHomeMenu()
	{
		By homeMenu = By.xpath("//a[@aria-label='Home']//*[@class='d-flex']//*[name()='svg']");
		click(homeMenu);

	}
	
	 public void enableSettingMenu()
	 {
		 By settingMenu = By.xpath("//*[@name='lft-setting']//*[name()='svg']");
		 click(settingMenu);
	     }
	 
	 
	 public void enableModulePageSetting()
	 {
		 By openGeneral = By.xpath("//span[@title='General']");
		 By modules = By.xpath("//a[normalize-space()='Modules']");

		 click(openGeneral);
		 click(modules);
		 click(openGeneral);
	 }
	
	public void Validate_OKR_Management_Menu_Hide()
	{
		By enableOKR = By.xpath("//li[2]/div/label/span");
		By enableTask =By.xpath("//li[3]/div/label");
		By enableCFR =By.xpath("//li[4]/div/label");
		By EnablePerformance =By.xpath("//li[5]/div/label");

		By OKRMenuPath=By.xpath("//a[@aria-label='OKRs']//*[@class='d-flex']//*[name()='svg']");
		enableHomeMenu();
		enableSettingMenu();
		enableModulePageSetting();
		WebElement toggleButton = driver.findElement(enableOKR);
		
	    click(enableOKR);
		
		System.out.println(toggleButton.isSelected());
		
		  
		
	
	  Screen s = new Screen(); 
	  String pathYourSystem =
	  System.getProperty("user.dir") + "/Sikuli/Image Files/toogle_disabled.png";
	  s.exists(pathYourSystem);
	  
	  System.out.println(s.exists(pathYourSystem));
	 
		                                     
			
		}
	
	
	
	
	
	
	public boolean Validate_OKR_Management_Links_enabled()
	{
		return false;
		
	}
	
	
	public boolean Validate_OKR_Management_Links_disabled()
	{
		return false;
		
	}
	
		
	
	
	public void checkisdisplayed()
	{
		By enableOKR = By.xpath("//body//apptivo-settings-general-modules//div/ul/li/div/label");
		By OKRMenuPath=By.xpath("//a[@aria-label='OKRs']//*[@class='d-flex']//*[name()='svg']");
		enableHomeMenu();
		enableSettingMenu();
		enableModulePageSetting();
		
		List<WebElement> path= driver.findElements(enableOKR);
		
		for(WebElement toogle : path)
		{
			String url = toogle.getText();

			System.out.println(url);
		}
		
		System.out.println(hasAttribute(enableOKR, "checked"));
		
	}

}
