package com.profit.qa.pages;




import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.profit.qa.Base.Base;
import com.profit.qa.StaticDatas.StaticData;

import dev.failsafe.function.CheckedRunnable;

public class SettingsMeetings extends Base {
    
    
	 
	public SettingsMeetings(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	Page page = new Page(driver, wait);
	static String topicName = null ;
	public void Login() throws InterruptedException, IOException {
		
	if (isUserLoggedIn()) {
		doLogin();
	} else {
		System.out.println("User Already Logged In ");
	}}
	public void Navigate_to_setting_page() throws InterruptedException, IOException {
		
		By click_Setting = By.xpath("//*[@name='lft-setting']//*[name()='svg']");
		click(click_Setting);
		By click_Meeting_In_Setting = By.xpath("//a[@baseurl='/app/ng/profit.jsp#/pr/settings/meetings']");
		click(click_Meeting_In_Setting);
	}
	public void enable_Meeting_toggle() throws InterruptedException, IOException {
		
		By click_MeetingFrame = By.xpath("//apptivo-settings-meeting//div[2]//div/div/div/div/div");
		click(click_MeetingFrame);
		By toggle_span =By.xpath("(//div/label/span[@class=\"slider round\"])[1]");
		By Toogle_input = By.xpath("(//div/label/input)[1]");
		enableToggle(toggle_span, Toogle_input);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1));
		
		
	}
	
	public void add_topic() throws InterruptedException   {
		By add_Topic = By.xpath("//*[@name='pt-circle-add']//*[name()='svg']");
		By mention_topic = By.xpath("//input[@name=\"meetingPoints\"]");
		By save_topic = By.xpath("//ng-svg-icon[@name='pt-save']/parent::button[@type='submit']");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		click(add_Topic);
	    topicName = "Automation_"+System.currentTimeMillis();
	    sendkeys(mention_topic,topicName);
	    click(save_topic);
	    Thread.sleep(500);
	    String topic_title = driver.findElement(By.xpath("//td[normalize-space()='"+topicName+"']")).getText();
	    
	    System.out.println("Added Topic Title is: "+topic_title); 
	    
	   }
	
	
	
	
	
	public void validate_Default_Topic() throws InterruptedException {
		
		List<WebElement> topic = driver.findElements(By.xpath("//div[@class='d-flex my-2 justify-content-start']/div/child::ul/li"));
		for (int i = 1; i <=topic.size(); i++) {
			String TopicTitle = driver.findElement(By.xpath("(//div[@class='d-flex my-2 justify-content-start']/div/child::ul/li)["+i+"]")).getText();
	        if (topicName.equalsIgnoreCase(TopicTitle)) {
	   
	        	System.out.println("Validated added Topic is :"+TopicTitle);
			}
		}}
	
	
	static String editedTopic =null;
	public  void edit_topic() throws InterruptedException  {
		
		List<WebElement> allTopicName = driver.findElements(By.xpath("//table[@class='table border table-hover']//tr"));	
		for(int i = 1; i <=allTopicName.size(); i++ ) {
			String DefaultTopicName = driver.findElement(By.xpath("//table[@class='table border table-hover']//tr[" +i+ "]//td[1]")).getText();
			if(topicName.equalsIgnoreCase(DefaultTopicName)) {
				driver.findElement(By.xpath("//table[@class='table border table-hover']//tr["+i+"]//td[3]/button[@type='button']")).click();
			}
		}
		     
			  WebElement checkBox = driver.findElement(By.xpath("//tbody/descendant::td/child::input[@type='text']")); 
			  checkBox.clear();
			  editedTopic = "Automation_"+System.currentTimeMillis();
			  checkBox.sendKeys(editedTopic);
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			  By save = By.xpath("//ng-svg-icon[@name='pt-save']/parent::button[@type='button']")	;	 
			  click(save);
			  Thread.sleep(500);
			  String title = driver.findElement(By.xpath("//td[normalize-space()='"+editedTopic+"']")).getText();
			  System.out.println("Edited Topic Title is: "+title);
			 
		}
      public void delete_created_topic() throws InterruptedException, IOException {
         
		
		List<WebElement> allTopicName = driver.findElements(By.xpath("//table[@class='table border table-hover']//tr"));	
		for(int i = 1; i <=allTopicName.size(); i++ ) {
			String DefaultTopicName = driver.findElement(By.xpath("//table[@class='table border table-hover']//tr[" +i+ "]//td[1]")).getText();
			
			if(editedTopic.equalsIgnoreCase(DefaultTopicName)) {
				System.out.println("Deleted topic is :"+editedTopic);
				WebElement Topic =driver.findElement(By.xpath("//table[@class='table border table-hover']//tr["+i+"]/td[3]/button[@role='button']"));
				Topic.click();
				By delete =  By.xpath("//apptivo-alert/descendant::button[contains(text(),'Yes')]");
				click(delete);
				}
			}
		
		
		}
      public void disable_default_toggle() throws InterruptedException {
    	    
    		 By spanToggle1 = By.xpath("(//tbody/descendant::span[@class='slider round'])[1]");
    		 By InputToggle1 = By.xpath("(//tbody/descendant::input)[1]");
    		 wait.until(ExpectedConditions.presenceOfElementLocated(spanToggle1));
    		 disableToggle(spanToggle1, InputToggle1);
             By spanToggle2 = By.xpath("//tbody/descendant::span[@class='slider round'][2]");
    		 By InputToggle2 = By.xpath("//tbody/descendant::input[2]");
    		 wait.until(ExpectedConditions.presenceOfElementLocated(spanToggle2));
    		 disableToggle(spanToggle2, InputToggle2);
    		 By spanToggle3 = By.xpath("//tbody/descendant::span[@class='slider round'][3]");
    		 By InputToggle3 = By.xpath("//tbody/descendant::input[3]");
    		 handleStaleElement(spanToggle3);
    		 wait.until(ExpectedConditions.visibilityOfElementLocated(spanToggle3));
    		 disableToggle(spanToggle3, InputToggle3);
     }
     
      static String editedDefaultTopic1 =null;
     public  void edit_Default_topic(String TopicName1,int index) throws InterruptedException  {
    		Thread.sleep(1000);
    	    List<WebElement> allTopicName = driver.findElements(By.xpath("//table[@class='table border table-hover']//tr"));	
    		wait.until(ExpectedConditions.visibilityOfAllElements(allTopicName));
    		for(int i = 1; i <=allTopicName.size(); i++ ) {
 			String DefaultTopicName1 = driver.findElement(By.xpath("//table[@class='table border table-hover']//tr[" +i+ "]//td[1]")).getText();
 			if(TopicName1.equalsIgnoreCase(DefaultTopicName1)) {
 				WebElement Topic =driver.findElement(By.xpath("//table[@class='table border table-hover']//tr["+i+"]//td[3]/button[@type='button']"));
 				System.out.println("Selected Topic to Edit is :"+Topic.getText());
 				Topic.click();
 				WebElement inputBox = driver.findElement(By.xpath("//input[@id='tp']"));
 				wait.until(ExpectedConditions.visibilityOf(inputBox));
 	 			 inputBox.clear();
 	 			editedDefaultTopic1 = "Automation_"+System.currentTimeMillis();
 	 			if(index==1) {
 	 			StaticData.Topic1= editedDefaultTopic1;
 	 			}else if(index==2) {
 	 		    StaticData.Topic2= editedDefaultTopic1;	
 	 			}else if(index==3) {
 	 			StaticData.Topic3= editedDefaultTopic1;	
 	 			}
 	 			WebElement inputBox2 = driver.findElement(By.xpath("//tbody/tr/td/input[@type='text']"));
	 			inputBox2.sendKeys(editedDefaultTopic1);
 	 			WebElement save = driver.findElement(By.xpath("//tbody/descendant::td/button/child::ng-svg-icon[@name='pt-save']"));
 			      save.click();
 			      System.out.println("Edited Topic is :"+editedDefaultTopic1);
 			break;}
 			  }
 	  		}
     
     public  void Delete_Default_topic(String Topic) throws InterruptedException  {
    	 Thread.sleep(500);
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table border table-hover']//tr")));
  		 List<WebElement> allTopicName = driver.findElements(By.xpath("//table[@class='table border table-hover']//tr"));	
  		 for(int i = 1; i <=allTopicName.size(); i++ ) {
  			String DefaultTopicName = driver.findElement(By.xpath("//table[@class='table border table-hover']//tr[" +i+ "]//td[1]")).getText();
  			
  			if(Topic.equalsIgnoreCase(DefaultTopicName)) {
  				System.out.println("Deleted Topic is :"+DefaultTopicName);
  				try{
  					WebElement Topic1 =driver.findElement(By.xpath("//table[@class='table border table-hover']//tr["+i+"]//td[3]/button[@role='button']"));
  				    Topic1.click();
  				    By delete =  By.xpath("//apptivo-alert/descendant::button[contains(text(),'Yes')]");
				    click(delete);
  				}catch (StaleElementReferenceException e) {
  					WebElement Topic1 =driver.findElement(By.xpath("//table[@class='table border table-hover']//tr["+i+"]//td[3]/button[@role='button']"));
  				    Topic1.click();
  				    By delete =  By.xpath("//apptivo-alert/descendant::button[contains(text(),'Yes')]");
  				    click(delete);
				}
  				
				
  				break;
  				}}
  		    
  		}
     
     public void Validation_for_Topic_in_Meeting() throws InterruptedException {
   	  
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td/div")));
		    String Topic_Title = driver.findElement(By.xpath("//tbody/tr/td/div")).getText();
  	        System.out.println("validation of the Topic Deleted is :"+Topic_Title);
  	 
 }
     public void Navigate_to_CFR_Conversation_Meeting() throws InterruptedException 
 	{   
 		By click_CFR =  By.xpath("//a[@aria-label='CFRs']/child::ng-svg-icon");
 		wait.until(ExpectedConditions.presenceOfElementLocated(click_CFR));
 	    click(click_CFR);
 		By click_conversation_Meeting = By.xpath("//li[@menuname='CONVERSATIONS']/descendant::a[contains(text(),'Meetings')]");
 		wait.until(ExpectedConditions.presenceOfElementLocated(click_conversation_Meeting));
 		click(click_conversation_Meeting);
 		String Title = driver.findElement(By.xpath("//apptivo-meeting/descendant::h4[contains(text(),'Meetings')]")).getText();
 		System.out.println("Title of the page is :"+Title);
 		
 	}
 	public void Navigate_to_General_Module_Home_Meeting(String Meetings) throws InterruptedException, IOException {
 		Thread.sleep(500);
 		Navigate_to_setting_page();
 		By General = By.xpath("//a[@class='nav-link nvhrd pt-set-general d-flex subMenu']");
		By Module_icon = By.xpath("//a[contains(text(),'Modules')]");
		By click_Module_frame = By.xpath("//div[@class='card-body']");
    	click(General);
    	click(Module_icon);
    	click(click_Module_frame);
    	for(int i=1 ;i<=1; i++) {
    		String Icon_name = driver.findElement(By.xpath("//ul[@class='list-group list-group-flush']/li["+i+"]/div/h6/descendant::span")).getText();
    		System.out.println("icon clicked is : "+Icon_name);
    		if (Icon_name.equalsIgnoreCase(Icon_name)) {
				driver.findElement(By.xpath("//ul[@class='list-group list-group-flush']/li["+i+"]/div/descendant::a")).click();
			}
    	}
    	List<WebElement> list_icon = driver.findElements(By.xpath("//tbody/tr/td/descendant::h5"));
		for (int i=1 ; i <=list_icon.size(); i++ ) {
			String value = driver.findElement(By.xpath("(//tbody/tr/td/descendant::h5)["+i+"]")).getText();
			if (Meetings.equalsIgnoreCase(value)) {
				System.out.println("Validated : "+value);
				break;
			}
		}
		By click_Done = By.xpath("//div[@class='modal-content']/descendant::button[contains(text(),'Done')]");
		click(click_Done);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1));
		}
 	
	 public void Navigate_to_home_Meeting() throws InterruptedException{
	   		By click_Home = By.xpath("//*[@baseurl=\"/app/ng/profit.jsp#/pr/profit_home/alignments\"]/ng-svg-icon[@class=\"d-flex\"]");
	   		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
	   		click(click_Home);	
	   		By click_Meeting_In_Home = By.xpath("(//a[contains(text(),'Meetings')])[1]");
	   		wait.until(ExpectedConditions.elementToBeClickable(click_Meeting_In_Home));
	   		click(click_Meeting_In_Home);
	   		By MeetingTitle = By.xpath("//apptivo-meeting/descendant::h4[contains(text(),'Meetings')]");
	   		String Title = driver.findElement(MeetingTitle).getText();
	   		System.out.println("Title of the page is : "+Title);
	   		
	   	    
	   	}
    public void Meeting_Attendie_empty_tab_validation (String Meeting_type) throws InterruptedException{  
   	 By click_Meeting_frame = By.xpath("//div[@class='w-100 tptitle']");
   	 By add_meeting = By.xpath("//apptivo-meeting/descendant::a[@tooltip='Schedule Meeting']");
   	 By sechdule = By.xpath("//button[normalize-space()='Schedule']");
   	 By one_to_one_Meet = By.xpath("//ul[@role='menu']/li/a[contains(text(),'"+ Meeting_type +"')]");
   	 By ok_button = By.xpath("//apptivo-alert/descendant::button[contains(text(),'OK')]");
   	    Navigate_to_home_Meeting();
   	    wait.until(ExpectedConditions.visibilityOfElementLocated(click_Meeting_frame));
        click(click_Meeting_frame);	
        click(add_meeting);
        click(one_to_one_Meet);
        click(sechdule);	
       try {
       Alert alert = driver.switchTo().alert();
   	System.out.println(alert.getText());
   	alert.accept();
       }catch (NoAlertPresentException e) {
   		String popup_msg = driver.findElement(By.xpath("//apptivo-alert/descendant::td[@id='message_text_new']")).getText();
   	    System.out.println("Validation of empty tab is: "+popup_msg);
       }
       click(ok_button);
    }
    public void Meeting_Title_empty_Tab_Validation() throws InterruptedException{  
   	 
   	 By sechdule = By.xpath("//button[normalize-space()='Schedule']");
   	 By add_participant = By.xpath("//div[@class='drop-downList pb-0']/div/ul/li[1]");
   	 By Meeting_With = By.xpath("//input[@id='droplist']");
   	 
   	    
        click(Meeting_With);
        Thread.sleep(1000);
        click(add_participant);
        By Meeting_Title_input_box = By.xpath("//div[2]//input[@placeholder='Add title']");
        clear(Meeting_Title_input_box);
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        sendkeys(sechdule, " ");
        sendkeys(sechdule,Keys.BACK_SPACE);
        click(sechdule);	
        
       try {
       Alert alert = driver.switchTo().alert();
   	   System.out.println(alert.getText());
   	   alert.accept();
       }catch (NoAlertPresentException e) {
   		String popup_msg = driver.findElement(By.xpath("//apptivo-alert/descendant::td[contains(text(),'Please enter meeting title')]")).getText();
   	    System.out.println("Validation of alert is: "+popup_msg);
       }
   	
   }
    static String meetingTitle = null;
    public void Create_1_to_1_Meet_and_check_it_scheduled_properly() throws InterruptedException{  
   	    
    	 By add_Meeting_Title = By.xpath("//div[2]//input[@placeholder='Add title']");
      	 By sechdule = By.xpath("//button[normalize-space()='Schedule']");
      	 By add_participant = By.xpath("//div[@class='drop-downList pb-0']/div/ul/li[1]");
      	 By Meeting_With = By.xpath("//input[@id='droplist']");
      	 wait.until(ExpectedConditions.visibilityOfElementLocated(add_Meeting_Title));
   	  
      	    meetingTitle = "Automation_Meeting_" + System.currentTimeMillis();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		   sendkeys(add_Meeting_Title, meetingTitle);
		   wait.until(ExpectedConditions.elementToBeClickable(Meeting_With));
           click(Meeting_With);
           wait.until(ExpectedConditions.elementToBeClickable(add_participant));
           click(add_participant);
           click(sechdule);	
           driver.navigate().refresh();
           List<WebElement> meet = driver.findElements(By.xpath("//tbody/tr[@class='fc-list-event  fc-event fc-event-start fc-event-end fc-event-today fc-event-future']/descendant::td/a"));
  			for (int i = 1; i <=meet.size(); i++) {
  			String Meeting = driver.findElement(By.xpath("(//tbody/tr[@class='fc-list-event  fc-event fc-event-start fc-event-end fc-event-today fc-event-future']/descendant::td/a)["+i+"]")).getText();	
  			if (meetingTitle.equalsIgnoreCase(Meeting)) {
  				driver.findElement(By.xpath("(//tbody/tr[@class='fc-list-event  fc-event fc-event-start fc-event-end fc-event-today fc-event-future']/descendant::td/a)["+i+"]")).click();
  			    System.out.println("Properly created Meeting is :"+Meeting);
  			}}
			
           
    }
    public void Create_1_to_1_meet_check_on_respective_person_in_Home_Meeting(String user) throws InterruptedException {
	
    	By click_current_user = By.xpath("//a[@id='userSettings']");
		By switch_user = By.xpath("//a[contains(text(),' Switch User ')]");
		click(click_current_user);
		click(switch_user);
		WebElement user_switch =driver.findElement(By.xpath("//a[@role='button']/descendant::h5[contains(text(),'"+user+"')]"));
	    if (user.equalsIgnoreCase(user_switch.getText())) {
			user_switch.click();
			System.out.println("Selected user is :"+user_switch.getText());
			}
	    Thread.sleep(3000);
		Navigate_to_home_Meeting();
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tbody/tr[@class='fc-list-event  fc-event fc-event-start fc-event-end fc-event-today fc-event-future']/descendant::td/a")));
         List<WebElement> meet = driver.findElements(By.xpath("//tbody/tr[@class='fc-list-event  fc-event fc-event-start fc-event-end fc-event-today fc-event-future']/descendant::td/a"));
			for (int i = 1; i <=meet.size(); i++) {
			String Meeting = driver.findElement(By.xpath("(//tbody/tr[@class='fc-list-event  fc-event fc-event-start fc-event-end fc-event-today fc-event-future']/descendant::td/a)["+i+"]")).getText();	
			if (meetingTitle.equalsIgnoreCase(Meeting)) {
				driver.findElement(By.xpath("(//tbody/tr[@class='fc-list-event  fc-event fc-event-start fc-event-end fc-event-today fc-event-future']/descendant::td/a)["+i+"]")).click();
			    System.out.println("Created Meeting in Home Meeting is :"+Meeting);
		
	}}}
			
    public void Check_reject_meeting_functionality_is_working_fine_or_not_with_1_to_1_Meeting () throws InterruptedException {
    	
    	By Action_center = By.xpath("//ul[@class='nav nav-small flex-column']/child::li[@menuname='ACTION_CENTER']");
    	click(Action_center);
    	By Actions = By.xpath("//div[@class='btn-group mb-3']/li/span[contains(text(),'Actions')]");
    	click(Actions);
    	
    	List <WebElement> Reject_button = driver.findElements(By.xpath("//div/div/descendant::button/span[contains(text(),'Reject')]"));
    	for (int i = 1; i <Reject_button.size(); i++) {
        String Meeting_title = driver.findElement(By.xpath("//div//a[contains(text(),'"+meetingTitle+"')]")).getText();
        if (meetingTitle.equalsIgnoreCase(Meeting_title)) {
			WebElement reject = driver.findElement(By.xpath("(//div/div/descendant::button/span[contains(text(),'Reject')])["+i+"]"));
		    wait.until(ExpectedConditions.visibilityOfAllElements(reject));
			reject.click();
			break;
        }}
        By click_current_user = By.xpath("//a[@id='userSettings']");
		By switch_back = By.xpath("//a[contains(text(),'Switch Back')]");
		
		click(click_current_user);
		wait.until(ExpectedConditions.visibilityOfElementLocated(switch_back));
		click(switch_back);
        By click_Home = By.xpath("//*[@baseurl=\"/app/ng/profit.jsp#/pr/profit_home/alignments\"]/ng-svg-icon[@class=\"d-flex\"]");
   		Thread.sleep(1500);
   		click(click_Home);
   		click(Action_center);
   		By Notification = By.xpath("//li/span[contains(text(),'Notifications')]");
   		click(Notification);
        Thread.sleep(1000);
   		String Notification_of_current_user = driver.findElement(By.xpath("//a[contains(text(),'"+meetingTitle+"')]")).getText();
			if (meetingTitle.equalsIgnoreCase(Notification_of_current_user)) {
				String Notification_comment = driver.findElement(By.xpath("//div[@class='feed w-100 pr-3']/div/descendant::p[2]")).getText();
				System.out.println("Validated rejected meeting is :" +Notification_comment);
				
			}
    	
		}
    public void Rejection_functionality(String user) throws InterruptedException {
    	
    	By click_Meeting_In_Home = By.xpath("(//a[contains(text(),'Meetings')])[1]");
    	Thread.sleep(1000);
   		click(click_Meeting_In_Home);
   		
	    List<WebElement> meet = driver.findElements(By.xpath("//tbody/tr[@class='fc-list-event  fc-event fc-event-start fc-event-end fc-event-today fc-event-future']/descendant::td/a"));
		for (int i = 1; i <=meet.size(); i++) {
		String Meeting = driver.findElement(By.xpath("(//tbody/tr[@class='fc-list-event  fc-event fc-event-start fc-event-end fc-event-today fc-event-future']/descendant::td/a)["+i+"]")).getText();	
		if (meetingTitle.equalsIgnoreCase(Meeting)) {
			driver.findElement(By.xpath("(//tbody/tr[@class='fc-list-event  fc-event fc-event-start fc-event-end fc-event-today fc-event-future']/descendant::td/a)["+i+"]")).click();
		    System.out.println("Selected Meet is :"+Meeting);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li/div/descendant::span[contains(text(),'Rejected')]")));
		    String reject = driver.findElement(By.xpath("//ul/li/div/descendant::span[contains(text(),'Rejected')]")).getText();
			System.out.println( user+" : This user " +reject+ " the Meeting");}}
		
		 
				
			
		}
		
		
    	
    	
		
	





}  	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
