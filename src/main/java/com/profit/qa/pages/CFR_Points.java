package com.profit.qa.pages;

import java.lang.reflect.InvocationTargetException;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.profit.qa.Base.Base;

public class CFR_Points extends Base {
	
	public static Page page = new Page(driver, wait);

	public CFR_Points(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		
	}
	/*
	 * **************** Xpaths ****************************************************
	 */ 
	
	
	By Recoginito  = By.xpath("//*[@id=\"menu-CFRs-1\"]/a[@role=\"button\"]");
	By Recoginito_Home  = By.xpath("//*[@id=\"subMenu-Home-1\"]/a[@baseurl=\"/app/ng/profit.jsp#/pr/cfrs/home\"]");
	
	By add_Recipitent  = By.xpath("//*[@id=\"feedContentScroll\"]/div/div[1]/div/div/div[2]/a[1][text()='@ Recipient']");
	
	
	By Recipitent_frame = By.xpath("(//*[@id=\"tinyEle\"])[1]");
	By Recipitent_Dropdown = By.xpath("/html/body/ul[@class=\"rte-autocomplete dropdown-menu mention_top\"]");
	By Reciptitent = By.xpath("/html/body/ul/li[2][@data-emailid=\"munees112@gmail.com\"]");
	By post = By.xpath("//*[@id=\"feedContentScroll\"]/div/div[2]/div/div/div[4]/button[text()='Post']");
	
	By add_Points = By.xpath("//*[@id=\"feedContentScroll\"]/div/div[1]/div/div/div[2]/a[2]");
	By points_frame = By.xpath("(//*[@id=\"tinyEle\"])[1]");
	By points = By.xpath("/html/body/ul/li[@data-points=\"0\"]");
	
	By click_user_1 = By.xpath("//*[@id=\"userSettings\"]/div[text()='Appas Azlan']");
	By Switch_user = By.xpath("//*[@id=\"hdrmnu\"]/li[7]/div/a[1][@role=\"button\"]");
	
	By Search_field = By.xpath("//modal-container/div/div/div/div[2]/div/div[2]/input[@type=\"text\"]");
	By Select_user = By.xpath("//div/div/div/div[2]/div/ul[2]/a/div/div/p[text()='munees112@gmail.com']");
	
	
	By Click_Add_Points = By.xpath("(//apptivo-feedback/section/div[1]/div/div/a[2])[1]");
	By point  =  By.xpath("//div[contains(@id,'cfr_recognition_attr_')]");
	By click_given_point = By.xpath("//li[contains(@data-id,'0')]");
	By click_Reward_to_User = By.xpath("//li[contains(@data-objectrefname,'Appas Azlan')]");
	By Give_button = By.xpath("//button[contains(@class,'btn btn-primary bnt-xs px-2 py-1')]");
	
	By click_user_2 = By.xpath("//div[contains(text(),'Vivien waran')]");
	By Switch_back_btn = By.xpath("//ng-svg-icon[@name=\"pt-switch-back\"]");
	By Rewarded = By.xpath("(//span[contains(text(), 'Rewarded ')])[1]");
	
	
	
	public void CFR_Recognition_Home() throws InterruptedException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        page.getInstance(CFR_Page_Meetings.class).CFR_icon();
		click(Recoginito);
		click(Recoginito_Home);
		
		
	}
	public void Add_Receiptent_and_Points() throws InterruptedException {
	    click(add_Points);
	    Thread.sleep(1000);
	    sendkeys(points_frame,"0");
		click(points);
	    sendkeys(points_frame, "@v");
        click(Reciptitent);
	    click(post);
	    driver.navigate().refresh();
	 }
	public void Switch_user() throws InterruptedException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		
		click(click_user_1);
		click(Switch_user);
		sendkeys(Search_field, " Vivien waran ");
		click(Select_user);
		Thread.sleep(2000);
	}
	public void add_Rewards() throws InterruptedException {
		click(Click_Add_Points);
		Thread.sleep(1000);
		sendkeys(point, "5");
		click(click_given_point);
		sendkeys(point, "@");
		click(click_Reward_to_User);
		click(Give_button);
		driver.navigate().refresh();
}
	public void Validation_for_Rewards_added() throws InterruptedException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		click(click_user_2);
		click(Switch_back_btn);
		String text = driver.findElement(Rewarded).getText();
		System.out.println("you have been:"+text);
	}
	
	
	
	
	
	
	
	
	
	
	
}
