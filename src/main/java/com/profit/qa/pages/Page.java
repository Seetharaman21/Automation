package com.profit.qa.pages;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.profit.qa.Base.Base;



public class Page {
	public static WebDriver driver;
	public static WebDriverWait wait;

	public Page(WebDriver driver, WebDriverWait wait) {
		Page.driver = driver;
		Page.wait = wait;
	}

	public <TPage extends Base> TPage getInstance(Class<TPage> pageClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException  {

			return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(Page.driver, Page.wait);

		}

	}
	




