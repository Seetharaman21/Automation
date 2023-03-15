package com.profit.qa.pages;




import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.profit.qa.Base.Base;

public class CFR_Page_Meetings extends Base {
    
	
	
	
	public CFR_Page_Meetings(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		
	}
	/*
	 * **************** Xpaths ****************************************************
	 */
	By selectbusiness = By.xpath("//tbody/tr[1]/td[3]/button[1]");
	By clickSetting = By.xpath("//*[@name='lft-setting']//*[name()='svg']");
	By clickMeeting = By.xpath("//a[@baseurl='/app/ng/profit.jsp#/pr/settings/meetings']");
	By clickMeetingFrame = By.xpath("//apptivo-settings-meeting//div[2]//div/div/div/div/div");
	By toogleButtonEnableMeeting = By.xpath("//div[@class='col-sm-12 form-row']//span[@class='slider round']");
	By click_CFR =  By.xpath("(//ng-svg-icon[contains(@class,'d-flex')])[5]");
    
	By click_conversation_Meeting = By.xpath("//html/body//main/div/apptivo-meeting/div/div/div/div/h4/div/div/a/ng-svg-icon");
	By click1to1Meeting = By.xpath("(//div[@class='ml-2 d-inline-block dropdown open show']/descendant::ul[@id='dropdown-basic']/child::li/a[@role='button'])[1]");
	
	By add_Meeting_Title = By.xpath("//div[2]//input[@placeholder='Add title']");
	
	By Meeting_With = By.xpath("//input[@id='droplist']");
	By add_participant = By.xpath("//div[@class='drop-downList pb-0']/div/ul/li[1]");
	
	By pick_date = By.xpath("//apptivo-schedule-meeting/div[1]/div[5]/div/div[1]/input");
	By select_date_Of_Meeting = By.xpath("//span[normalize-space()='28']");
	
	By Duration_Dropdown = By.xpath("//apptivo-schedule-meeting/div[1]/div[5]/div/div[2]/ng-select/div/span");
	By Meeting_From_Duration = By.xpath("//ng-dropdown-panel/div/div[2]/div[41]/div");
	
	By Check_availability = By.xpath("//apptivo-schedule-meeting/div[1]/div[6]/div/button");
	By Click_Ok = By.xpath("/html/body/modal-container[2]/div/div/div/div[3]/button");
	
	By down_toggleBtn = By.xpath("//apptivo-schedule-meeting/div[1]/div[8]/div/button");
	By Dropdown = By.xpath("//apptivo-schedule-meeting/div[1]/div[8]/div/div/div[1]/a");
	
	By add_description = By.xpath("//p[@id='tinyEle']");
	
	By add_attachment = By.xpath("//apptivo-schedule-meeting/div[2]/div/apptivo-document-tab/div/div/a/span");
	By add_link = By.xpath("//apptivo-schedule-meeting/div[2]/div/apptivo-document-tab/div/div/div/apptivo-add-link/a/span");
	By add_Name = By.xpath("/html/body/modal-container[2]/div/div/div/div[2]/div/div[1]/input");
	By add_Url = By.xpath("/html/body/modal-container[2]/div/div/div/div[2]/div/div[2]/input");
	By click_add = By.xpath("/html/body/modal-container[2]/div/div/div/div[3]/button");
	
	By sechdule = By.xpath("//button[normalize-space()='Schedule']");
	
	By clickHomebutton = By.xpath("//a[@aria-label=\'Home\']/ng-svg-icon[@class='d-flex']");
    By selectMeeting = By.xpath("//body//apptivo-profit-left-menu//div//div/li/div/ul/li[4]/a[@baseurl=\"/app/ng/profit.jsp#/pr/profit_home/meetings\"]");
	
    By click_scheduled_Meet = By.xpath("//button[normalize-space()='Schedule']");
    By click_view_meeting = By.xpath("//a[contains(text(),'View meeting →')]");
    
    static String meetingTitle = null;
    
    public void Select_Business() throws InterruptedException {
		click(selectbusiness);
		Thread.sleep(5000);
	}
    
    
	public void enable_meeting_icon_in_settings_page() throws InterruptedException
	{
		click(clickSetting);
		click(clickMeeting);
		click(clickMeetingFrame);
		click(toogleButtonEnableMeeting);
		
	}
		
	public void CFR_icon() 
	{
		click(click_CFR);
	    
	} 
	public void Conversation_Meeting() throws InterruptedException{
		click(click_conversation_Meeting); 
	}
	public void Add_Meeting() throws InterruptedException
	{  
		 By click_Meeting_icon_frame = By.xpath("//div[@class='w-100 tptitle']");
		   click(click_Meeting_icon_frame);	
	   By add_meeting = By.xpath("//apptivo-meeting/descendant::a[@tooltip='Schedule Meeting']");
	   click(add_meeting);
	  
	    
	}   
	public void OnetoOne_Meeting() throws InterruptedException
	{  
		
	   click(click1to1Meeting);
	  
	    
	}
	
	public String getMeetingTitle() {
		return meetingTitle;
	}
	
	
	public void Meeting_Title() throws InterruptedException
	{   
		 meetingTitle = "Automation_Meeting_" + System.currentTimeMillis();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		sendkeys(add_Meeting_Title, meetingTitle);
		Thread.sleep(1000);
		
	   
	}   
	public void add_Participants() throws InterruptedException 
	{   
	    click(Meeting_With);
	    
	    click(add_participant);
	}	
	public void Meeting_duration() {
		click(pick_date);
		click(Duration_Dropdown);
		click(Meeting_From_Duration);
	}
	public void Meeting_descrption() throws InterruptedException{
		
		click(Check_availability);
		click(Click_Ok);
		click(down_toggleBtn);
		click(Dropdown);
		Thread.sleep(1000);
		sendkeys(add_description, "method for 1:1 meeting" );
	}	
	public void add_attachments() {
		click(add_attachment);
	    click(add_link);
		sendkeys(add_Name, "Automate");
		sendkeys(add_Url, "https://meet.google.com/");
		click(click_add);
	}
	public void Schedule_Meeting() throws InterruptedException {
        
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		click(sechdule);
		driver.navigate().refresh();
		
	}	
	public void validation_of_one_to_one_Meeting() throws InterruptedException {
		click(clickHomebutton);
	    click(selectMeeting);
	    click(click_scheduled_Meet);
	    click(click_view_meeting);
	    Thread.sleep(3000);
	}
	
	public void clickMeeting() throws InterruptedException {
		List<WebElement> meet = driver.findElements(By.xpath("//tbody/tr[@class='fc-list-event  fc-event fc-event-start fc-event-end fc-event-today fc-event-future']/descendant::td/a"));
		for (int i = 1; i <=meet.size(); i++) {
		String Meeting = driver.findElement(By.xpath("(//tbody/tr[@class='fc-list-event  fc-event fc-event-start fc-event-end fc-event-today fc-event-future']/descendant::td/a)["+i+"]")).getText();	
		if (meetingTitle.equalsIgnoreCase(Meeting)) {
			driver.findElement(By.xpath("(//tbody/tr[@class='fc-list-event  fc-event fc-event-start fc-event-end fc-event-today fc-event-future']/descendant::td/a)["+i+"]")).click();
		}
		}
		
		
	}
		
	
	
		
	
    
	
	
	    
		
	
	
	
	
	
	
	
}
