package com.profit.qa.testpages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


import org.testng.annotations.Test;

import com.profit.qa.basetest.LoginTestBase;
import com.profit.qa.pages.CFR_Page_Meetings;
import com.profit.qa.pages.LoginPage;
import com.profit.qa.pages.Page;


public class CFRpageTest_Meeting extends LoginTestBase{

	Page page = new Page(driver, wait) ;
	
	
	@Test
	public void Enable_meeting_toggle ()throws IOException, InterruptedException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		
		page.getInstance(LoginPage.class).successfullLogin();
		
		
	} 
	@Test(dependsOnMethods = "Enable_meeting_toggle")
	public void CFR_Add_Meeting ()throws IOException, InterruptedException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException	
	{   page.getInstance(CFR_Page_Meetings.class).enable_meeting_icon_in_settings_page();
		page.getInstance(CFR_Page_Meetings.class).CFR_icon();
		page.getInstance(CFR_Page_Meetings.class).Conversation_Meeting();
		page.getInstance(CFR_Page_Meetings.class).Add_Meeting();
		page.getInstance(CFR_Page_Meetings.class).OnetoOne_Meeting();
		page.getInstance(CFR_Page_Meetings.class).Meeting_Title();
		page.getInstance(CFR_Page_Meetings.class).add_Participants();
		page.getInstance(CFR_Page_Meetings.class).Meeting_duration();
		page.getInstance(CFR_Page_Meetings.class).Meeting_descrption();
		page.getInstance(CFR_Page_Meetings.class).Schedule_Meeting();
	}
	@Test(dependsOnMethods ="CFR_Add_Meeting")
	public void Validtation_for_Meeting ()throws IOException, InterruptedException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException	
	{ 
		page.getInstance(CFR_Page_Meetings.class).validation_of_one_to_one_Meeting();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
