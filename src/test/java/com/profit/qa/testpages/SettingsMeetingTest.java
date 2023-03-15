package com.profit.qa.testpages;





import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.testng.annotations.Test;

import com.profit.qa.StaticDatas.StaticData;
import com.profit.qa.basetest.LoginTestBase;
import com.profit.qa.pages.Page;
import com.profit.qa.pages.SettingsMeetings;


public class SettingsMeetingTest extends LoginTestBase{
	Page page = new Page(driver, wait) ;
@Test
public void Login() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
			page.getInstance(SettingsMeetings.class).Login();
			
		}	
@Test(dependsOnMethods ={"Login"})
public void Navigate_to_setting_page() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
		page.getInstance(SettingsMeetings.class).Navigate_to_setting_page();
		
	}	
@Test(dependsOnMethods ={"Navigate_to_setting_page"})
public void Enable_meeting_toggle() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).enable_Meeting_toggle();
	
}
@Test(dependsOnMethods ={"Enable_meeting_toggle"})
public void Add_Topic() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).add_topic();
	
}
@Test(dependsOnMethods ={"Add_Topic"})
public void Edit_added_topic() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).edit_topic();
}
@Test(dependsOnMethods ={"Edit_added_topic"})
public void Delete_Added_Topic() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).delete_created_topic();
	
}
@Test(dependsOnMethods ={"Delete_Added_Topic"})
public void Disable_default_topic() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).disable_default_toggle();
	
}
@Test(dependsOnMethods ={"Disable_default_topic"})
public void Edit_default_topic_1() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).edit_Default_topic(StaticData.Topic1,1);
	
}
@Test(dependsOnMethods ={"Edit_default_topic_1"})
public void Edit_default_topic_2() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).edit_Default_topic(StaticData.Topic2,2);
	
}
@Test(dependsOnMethods ={"Edit_default_topic_2"})
public void Edit_default_topic_3() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).edit_Default_topic(StaticData.Topic3,3);
	
}@Test(dependsOnMethods ={"Edit_default_topic_3"})
public void Delete_default_Topic1() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).Delete_Default_topic(StaticData.Topic1);
	
}
@Test(dependsOnMethods ={"Delete_default_Topic1"})
public void Delete_default_Topic2() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).Delete_Default_topic(StaticData.Topic2);
	
}
@Test(dependsOnMethods ={"Delete_default_Topic2"})
public void Delete_default_Topic3() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).Delete_Default_topic(StaticData.Topic3);
	
}

@Test(dependsOnMethods = {"Delete_default_Topic3"})
public void Validate_deleted_default_topic() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).Validation_for_Topic_in_Meeting();
	
}
@Test(dependsOnMethods = {"Validate_deleted_default_topic"})
public void Add_new_topic_check_reflection_in_Meeting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).add_topic();
	
}
@Test(dependsOnMethods = {"Enable_meeting_toggle","Validate_deleted_default_topic"})
public void Enable_Meeting_toggle_in_setting_check_relfection_in_CFRs_Converstation_Meeting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).Navigate_to_CFR_Conversation_Meeting();
	
}
@Test(dependsOnMethods = {"Enable_meeting_toggle","Enable_Meeting_toggle_in_setting_check_relfection_in_CFRs_Converstation_Meeting"})
public void Enable_Meeting_toggle_reflection_from_general_home_meeting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).Navigate_to_General_Module_Home_Meeting(StaticData.Meetings);
	
}	
@Test(dependsOnMethods = {"Enable_Meeting_toggle_reflection_from_general_home_meeting"})
public void Meeting_Attendee_empty_Tab_validation() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).Meeting_Attendie_empty_tab_validation(StaticData.one_to_oneMeeting);
	
}
@Test(dependsOnMethods = {"Meeting_Attendee_empty_Tab_validation"})
public void Create_1_to_1_Meet_check_it_properly_created() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).Create_1_to_1_Meet_and_check_it_scheduled_properly();
	
}	
@Test(dependsOnMethods = {"Create_1_to_1_Meet_check_it_properly_created"})
public void Created_meet_properly_check_or_not_by_switching_user () throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).Create_1_to_1_meet_check_on_respective_person_in_Home_Meeting("Albert Delrio");
	
}	
@Test(dependsOnMethods = {"Created_meet_properly_check_or_not_by_switching_user"})
public void Check_reject_1_to_1_meet () throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).Check_reject_meeting_functionality_is_working_fine_or_not_with_1_to_1_Meeting();
	
}	
@Test(dependsOnMethods = {"Check_reject_1_to_1_meet"})
public void Check_reject_functionality_working_1_to_1_meet () throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException {
	page.getInstance(SettingsMeetings.class).Rejection_functionality("Albert Delrio");
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
