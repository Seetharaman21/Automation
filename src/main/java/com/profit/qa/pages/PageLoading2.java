package com.profit.qa.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.profit.qa.Base.Base;

public class PageLoading2 extends Base {

	public PageLoading2(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	Page page;
	public static By homeMenu = By.xpath("//body//apptivo-profit-left-menu//div[@class=\"twomain\"]//ul/li/a");
	public static By allMenu = By.xpath("//body//a");

	/*
	 ******************* Get all the menu links ************************
	 */

	public static List<String> getSideMenuUrl() throws Exception {
		List<WebElement> links = handleStaleElement(homeMenu);
		List<String> urls = new ArrayList<>();

		for (WebElement link : links) {
			try {
				String url = link.getAttribute("href");
		

				if (url != null && !url.isEmpty() && url.contains("/app/ng/profit.jsp")) {
					urls.add(url);
				}

			} catch (StaleElementReferenceException e) {
				driver.navigate().refresh();
			}
		}
		System.out.println(urls);
		return urls;
	}

	/*
	 * Below method will click all the menu on the website and fetch the url
	 * according to the page
	 */

	public static List<String> checkAllPage(List<String> menuLink) throws Exception {
		List<String> urls = new ArrayList<>();

		for (String eachelement : menuLink) {

			driver.get(eachelement);

			List<WebElement> links = handleStaleElement(allMenu);
			for (WebElement link : links) {
				try {
					String url = link.getAttribute("href");
				    

					if (url != null && !url.isEmpty() && url.contains("/app/ng/profit.jsp") && !urls.contains(url)) {
						System.out.println(url);

						urls.add(url);
					}

				} catch (StaleElementReferenceException e) {

					driver.navigate().refresh();
					System.out.println("Fetching Url......................");
				}
			}
		}
		System.out.println(urls.size());
		System.out.println(urls);
		return urls;
	}

	public static void fetchallurl(List<String> urls) throws Exception {

		for (String extacted : urls) {
			driver.get(extacted);
			SeparateURLTitle(extacted);
			List<String> status = new ArrayList<>();
			if (!(Base.getStatus(driver, extacted) == 200)) {
				System.out.println();
				System.out.println(" Page Failed :" + extacted);
				System.out.println();

			} else {
				System.out.println();
				// System.out.println(extacted + " ..........Launched");
				saveAllValue(SeparateURLTitle(extacted), Base.getStatus(driver, extacted));
			}
			System.out.println();
		}


	}

	public static String  SeparateURLTitle(String extacted)
	{
		
		String[] urlBody ;
		urlBody=extacted.split("#");
		System.out.println(urlBody[urlBody.length - 1]);
		return urlBody[urlBody.length - 1];
			
		/*
		 * for (String url : urlBody) { String[] parts = url.split("/"); String text =
		 * parts[parts.length - 1]; System.out.println(text); }
		 */
		
	}	
	
	
	public static void saveAllValue(String url , int status)
	{
		Map<String, Integer> map = new HashMap<>();
		map.put("url", status);
		System.out.println(map.get(0));

	}
	
	
	
	
	
	public static void saveAllValueObject(String url , int status)
	{
		Map<String, Integer> map = new HashMap<>();
		map.put("url", status);
		System.out.println(map.get(0));
	}
	
	
	
	public static void checkPageLoading() {
		try {
			fetchallurl(checkAllPage(getSideMenuUrl()));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
