package com.profit.qa.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;
import com.profit.qa.Base.Base;

public class OkrPage extends Base {
	Faker faker = new Faker(); 
	String futureReferenceConfigPath="src/main/java/com/profit/qa/Properties/futureReference.properties";
	Properties prop; 


	public OkrPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	By allMyOkr = By.xpath("//body//apptivo-profit-left-menu//a[@baseurl='/app/ng/profit.jsp#/pr/okrs/all-my-okrs']");
	By okrAddBtn = By.xpath("//apptivo-okr-list//div/a[@role=\"button\" and @aria-label=\"Create OKR\"]");
	By okrQuickCreate = By.xpath("//apptivo-okr-list//div//ul[@id=\"dropdown-basic\"]//a[contains(text(), \" Quick Create \")]"); 
	By okrStepByStepGuide = By.xpath("//apptivo-okr-list//div//ul[@id=\"dropdown-basic\"]//a[contains(text(), \" Step By Step Guide \")]");
	By typeOkrName = By.id("objective");
	By saveOkr = By.linkText("Save");
	By hoverAndEditOkr = By.xpath("//apptivo-okr-list//apptivo-card//div[@class=\"okrrow\"]//a/ng-svg-icon[@name=\"okr-pen-edit\"]");
	By editObjectiveName = By.xpath("//apptivo-objective-form-create/div//textarea[@id=\"objectiveName\"]"); 
	By clickUpdateBtnOnEditOkrPage = By.xpath("//div[@role=\"document\"]//button[contains(text(),\"Update\")]");
	By hoverAndClickOKREditPageMoreBtn = By.xpath("//apptivo-okr-list//apptivo-card//div[@class=\"okrrow\"]//div//a[@id=\"button-basic\"]//ng-svg-icon");
    By clickDeleteBtnOnEditOKRPage = By.xpath("//apptivo-okr-list//apptivo-card//div[@class=\"okrrow\"]//div//ul//button[contains(text(),\"Delete\")]");
    By deleteOKRConfirmationPopup= By.xpath("//button[contains(text(),'Yes')]"); 
	
    
    
    
    public void navigateToOKrPage() throws InterruptedException, IOException
	{
		if (isUserLoggedIn() == true) {
			doLogin();
		} else {
			System.out.println("enterd Navigate ");
			click(allMyOkr);
		}
	}

	
	
	String OKRName = faker.name().firstName() +faker.name().fullName() + faker.backToTheFuture().quote();

	public void Add_Okr() throws IOException, InterruptedException
	{		
		navigateToOKrPage(); 
		saveOnProperties(futureReferenceConfigPath, "newOKRName", OKRName);
		click(okrAddBtn);
		click(okrQuickCreate); 
		clear(typeOkrName);
		sendkeys(typeOkrName, OKRName);
		click(saveOkr);		

	}




	public void Edit_Okr() throws IOException, InterruptedException
	{
		hoverAndClick(Generate_Xpath_For_To_Find_Okr(futureReferenceConfigPath, "newOKRName"), hoverAndEditOkr);
		clear(editObjectiveName);
		saveOnProperties(futureReferenceConfigPath, "newOKRName", OKRName);
		sendkeys(editObjectiveName, OKRName);
		click(clickUpdateBtnOnEditOkrPage); 
	}
	
	
	
	
	
	public void Delete_Okr() throws IOException, InterruptedException
	{
		hoverAndClick(Generate_Xpath_For_To_Find_Okr(futureReferenceConfigPath, "newOKRName"), hoverAndClickOKREditPageMoreBtn);
		click(hoverAndClickOKREditPageMoreBtn); 
		click(clickDeleteBtnOnEditOKRPage);
		click(deleteOKRConfirmationPopup); 
	}

	
	
	
	
	
	
	
	public By Generate_Xpath_For_To_Find_Okr(String path , String pathName) throws IOException
	{
		prop = getPropertyAccess(path);
		prop.getProperty(pathName);
		By locator = null;
		By elementPath = By.xpath("//apptivo-okr-list//apptivo-card//div[@class=\"okrrow\"]//a/span[contains(text(),\""
				+ prop.getProperty(pathName) + "\")]");
		locator = elementPath;
		return locator;
	}
	
}
