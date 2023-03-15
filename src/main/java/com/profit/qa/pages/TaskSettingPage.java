package com.profit.qa.pages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.profit.qa.Base.Base;

public class TaskSettingPage extends Base{

	Page page ;
	Properties prop;

	public TaskSettingPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	By settingLink = By.xpath("/html/body/app-root/div/div/div/apptivo-profit-left-menu/nav/div[2]/ul[2]/li[1]/a/ng-svg-icon/svg/path");
	By taskMenu = By.xpath("/html/body/app-root/div/div/div/apptivo-profit-left-menu/nav/div[3]/ul/div/li[5]/a");
	By Priorities = By.xpath("/html/body/app-root/div/div/div/apptivo-profit-left-menu/nav/div[3]/ul/div/li[5]/div/ul/li[1]/a");

    public void addpriority() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
    {
    page.getInstance(LoginPage.class).successfullLogin();
    click(settingLink);
    click(taskMenu);
    click(Priorities);


    }

}
