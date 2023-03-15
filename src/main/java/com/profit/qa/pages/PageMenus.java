package com.profit.qa.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.profit.qa.Base.Base;
import com.profit.qa.StaticDatas.PageLoadingStaticData;

public class PageMenus extends Base {

	public PageMenus() {
		super(driver, wait);
	}

	LoginPage page;
	Properties prop;

	/*
	 ************************************* Get Config property access ***********************
	 */




/*/
 *  ****************************************** Home Page elements *********************************************
 */
 By menuBtn= By.xpath("//a[@aria-label='Home']//*[@class='d-flex']//*[name()='svg']");
 By alignment = By.xpath("//a[@aria-label='Home']//*[@class='d-flex']//*[name()='svg']");
 By alignmentVerify = By.xpath("//div//h4[contains(text(),'Alignments')]");


 By actionCenter = By.xpath("//a[normalize-space()='Action Center']");
 By actionCenterVerify = By.xpath("//apptivo-action-center//div//h4[contains(text(),'Action Center')]" );


 By alignmentAndDependencies = By.xpath("//a[contains(text(),'Alignments and Dependencies')]");
 By alignmentAndDependenciesVerify = By.xpath("//apptivo-Assigned-dependency//div//h4[contains(text(),'Alignments and Dependencies')]" );


 By meetings = By.xpath("//body//apptivo-profit-left-menu//a[@baseurl='/app/ng/profit.jsp#/pr/profit_home/meetings']");
 By meetingsVerify = By.xpath("//body//apptivo-meeting//h4[contains(text(),' Meetings ')]" );


 By notes = By.xpath("//body//apptivo-profit-left-menu//a[@baseurl='/app/ng/profit.jsp#/pr/profit_home/notes_list']");
 By notesVerify = By.xpath("//body//apptivo-notes-list//h4[contains(text(),'Notes')]" );


 By companyDashboard = By.xpath("//body//apptivo-profit-left-menu//a[@baseurl='/app/ng/profit.jsp#/pr/profit_home/company_dashboard']");
 By companyDashboardVerify = By.xpath("//body//apptivo-okrs-dashboard//h4[contains(text(),' Company Dashboard ')]" );


 By departmentHierarchy= By.xpath("//body//apptivo-profit-left-menu//a[@baseurl='/app/ng/profit.jsp#/pr/profit_home/department_hierarchy']");
 By departmentHierarchyVerify = By.xpath("//body//apptivo-department-hierarchy//h4[contains(text(),' Department Hierarchy ')]" );


 By newsFeed = By.xpath("//body//apptivo-profit-left-menu//a[@baseurl='/app/ng/profit.jsp#/pr/profit_home/news_feed']");
 By newsFeedVerify = By.xpath("//body//apptivo-newsfeed//h4[contains(text(),' News Feed ')]" );


/*
 * By kpiBoards = By.xpath(""); By kpiBoardsVerify = By.xpath("" );
 */


 By organizationHierarchy= By.xpath("//body//apptivo-profit-left-menu//a[@baseurl='/app/ng/profit.jsp#/pr/profit_home/organization_hierarchy/my_org']");
 By organizationHierarchyVerify = By.xpath("//body//apptivo-hierarchy-chart//h4[contains(text(),' Organization Hierarchy ')]" );



 /*/
  *  ****************************************** OKRs Page elements *********************************************
  */

  By allMyOkr = By.xpath("//body//apptivo-profit-left-menu//a[@baseurl='/app/ng/profit.jsp#/pr/okrs/all-my-okrs']");
  By allMyOkrVerify = By.xpath("//body//apptivo-okr-list//h4[contains(text(),'All My OKRs')]");


  By myIndividualOkr = By.xpath("//body//apptivo-profit-left-menu//a[@baseurl='/app/ng/profit.jsp#/pr/okrs/my-okrs']");
  By myIndividualOkrVerify = By.xpath("//div[normalize-space()='My Individual OKRs']");





 /*/
  *  ****************************************** All Page Functions *********************************************
  */



  /*/
   *  ****************************************** Home Page Functions *********************************************
   */

public void doLogin() throws InterruptedException
{
	By emailId = By.id("login_email");
	By password = By.name("password");
	By loginBtn = By.id("login_btn");

	inputClick(emailId);
	sendkeys(emailId , "aabdul@profit.co") ;
	inputClick(password);
	sendkeys(password , "Appas@123") ;
	click(loginBtn);
	Thread.sleep(3000);
	//click(alignment);

}




public String enableHomeMenu()
{
	 By homeMenu = By.xpath("//*[@baseurl=\"/app/ng/profit.jsp#/pr/profit_home/alignments\"]/ng-svg-icon[@class=\"d-flex\"]");
	 By homeTitle= By.xpath("//em[@title='Home']");

	click(homeMenu);
	return doGetText(homeTitle);

}




 public String checkAlignmentPage() throws InterruptedException, IOException{
	    click(alignment);
	    return doGetText(alignmentVerify) ;
 }






 public String checkActionCenterPage(){
	 click(actionCenter);
	return doGetText(actionCenterVerify) ;
 }






 public String checkAlignmentAndDependenciesPage()
 {
	click(alignmentAndDependencies);
	return doGetText(alignmentAndDependenciesVerify) ;
 }





 public String checkMeetingsPage()
 {
	click(meetings);
	return doGetText(meetingsVerify) ;
 }





 public String checkNotesPage()
 {
	click(notes);
	return doGetText(notesVerify) ;
 }




 public String checkCompanyDashboardPage()
 {
	click(companyDashboard);
	return doGetText(companyDashboardVerify) ;
 }




 public String checkDepartmentHierarchyPage()
 {
	click(departmentHierarchy);
	return doGetText(departmentHierarchyVerify) ;
 }




 public String checkNewsFeedPage()
 {
	click(newsFeed);
	return doGetText(newsFeedVerify) ;
 }




 public String checkOrganizationHierarchyPage()
 {
	click(organizationHierarchy);
	return doGetText(organizationHierarchyVerify) ;
 }


 /*/
  *  ****************************************** Okr Page Functions *********************************************
  */


 public String enableOkrMenu()
 {
	 By okrTitle= By.xpath("//em[@title='OKRs']");
	 By okrMenu = By.xpath("//body//apptivo-profit-left-menu//a[@baseurl='/app/ng/profit.jsp#/pr/okrs/all-my-okrs']");
	 click(okrMenu);
	 return doGetText(okrTitle);
     }

 public String checkAllMyOkrsPage() throws InterruptedException
 {
	System.out.println(driver.getCurrentUrl());
	/*
	 * By okrMenu = By.xpath("//a[normalize-space()='All My OKRs']");
	 * click(okrMenu);
	 */
	return doGetText(allMyOkrVerify) ;
 }





 public String checkMyIndivitualOkrPage() throws InterruptedException
 {
	click(myIndividualOkr);
	return doGetText(myIndividualOkrVerify) ;
 }




 public String checkOrgsOkrPage() throws IOException{



		By orgsOkr = By.xpath("//body//apptivo-profit-left-menu//a[@baseurl='/app/ng/profit.jsp#/pr/okrs/corporate-okrs']");
		By orgsOkrVerify = By.cssSelector("h4[class='d-flex align-items-center justify-content-start'] div");


		PageLoadingStaticData oKRs = new PageLoadingStaticData();
	    prop= Base.getPropertyAccess("src/main/java/com/profit/qa/Properties/config.properties");
		PageLoadingStaticData.oKRs=prop.getProperty("orgName")+" OKRs";


	    click(orgsOkr);
	    return doGetText(orgsOkrVerify) ;
 }


 public String checkMyOrgsOkrPage() throws InterruptedException
 {
	By myOrgsOkr = By.xpath("//li[@id='menu-OKRs-6']//a[@role='button']");
	By myOrgsOkrVerify = By.linkText("My Org's OKRs");
	click(myOrgsOkr);
	return doGetText(myOrgsOkrVerify) ;
 }


 public String checkWatchedOkrPage() throws InterruptedException
 {
	By watchedOkr = By.cssSelector("li[id='menu-OKRs-7'] a[role='button']");
	By watchedOkrVerify = By.xpath("//h4[@class='float-left']");
	click(watchedOkr);
	return doGetText(watchedOkrVerify) ;
 }



 public String checkSharedOkrPage() throws InterruptedException
 {
	By SharedOkr = By.cssSelector("li[id='menu-OKRs-8'] a[role='button']");
	By SharedOkrVerify = By.xpath("//h4[@class='float-left']");
	click(SharedOkr);
	return doGetText(SharedOkrVerify) ;
 }



 public String checkKpisAllPage() throws InterruptedException
 {
	By openKpisDropdown = By.xpath("//a[normalize-space()='OKRs By KPIs']");
	By KpisAll = By.xpath("//a[normalize-space()='All']");
	By KpisAllVerify = By.xpath("//div[contains(text(),'OKRs By KPIs: All')]");
	click(openKpisDropdown);
	click(KpisAll);
	click(openKpisDropdown);
	return doGetText(KpisAllVerify) ;
 }




 public String checkKpisWatchedPage() throws InterruptedException
 {
	By openKpisDropdown = By.xpath("//a[normalize-space()='OKRs By KPIs']");
	By KpisWatched = By.xpath("//a[normalize-space()='Watched']");
	By KpisWatchedVerify = By.xpath("//div[contains(text(),'OKRs By KPIs: Watched')]");
	click(openKpisDropdown);
	click(KpisWatched);
	click(openKpisDropdown);
	return doGetText(KpisWatchedVerify) ;
 }




 public String checkObjectivesbyTagsPage() throws InterruptedException
 {
	By openOKRDirectory = By.xpath("//a[normalize-space()='OKR Directory']");
	By objectivesbyTags = By.xpath("//a[normalize-space()='Objectives by Tags']");
	By objectivesbyTagsVerify = By.xpath("//div[contains(text(),'Objectives by Tags')]");
	click(openOKRDirectory);
	click(objectivesbyTags);
	click(openOKRDirectory);
	return doGetText(objectivesbyTagsVerify) ;
 }




 public String checkKeyResultsByTagsPage() throws InterruptedException
 {
	By openOKRDirectory = By.xpath("//a[normalize-space()='OKR Directory']");
	By keyResultsByTags = By.xpath("//a[normalize-space()='Key Results by Tags']");
	By keyResultsByTagsVerify = By.xpath("//div[@class='heading d-flex justify-content-between align-items-center']");
	click(openOKRDirectory);
	click(keyResultsByTags);
	click(openOKRDirectory);
	return doGetText(keyResultsByTagsVerify) ;
 }


 public String checkAllEmployeeOkrPage() throws InterruptedException
 {
	By AllEmployeeOkr = By.cssSelector("li[id='menu-OKRs-11'] a[role='button']");
	By AllEmployeeOkrVerify = By.xpath("//h4[@class='float-left']");
	click(AllEmployeeOkr);
	return doGetText(AllEmployeeOkrVerify) ;
 }




 public String checkAllDepartmentOkrPage() throws InterruptedException
 {
	By allDepartmentOkr = By.xpath("//a[contains(text(),\"All Departments' OKRs\")]");
	By allDepartmentOkrVerify = By.xpath("//h4[@class='d-flex align-items-center']");
	click(allDepartmentOkr);
	return doGetText(allDepartmentOkrVerify) ;
 }




 public String checkManagersOkrsPage() throws InterruptedException
 {
	By managersOkrs = By.xpath("//a[contains(text(),\"Manager's OKRs\")]");
	By managersOkrsVerify = By.xpath("//h4[@class='float-left']");
	click(managersOkrs);
	return doGetText(managersOkrsVerify) ;
 }




 public String checkOkrsAuthoringPage() throws InterruptedException
 {
	By openProgramStatus = By.xpath("//a[normalize-space()='OKRs Program Status']");
	By okrsAuthoring = By.xpath("//a[normalize-space()='OKRs Authoring']");
	By okrsAuthoringVerify = By.xpath("//h4[normalize-space()='OKRs Authoring']");
	click(openProgramStatus);
	click(okrsAuthoring);
	click(openProgramStatus);
	return doGetText(okrsAuthoringVerify) ;
 }




 public String checkOkrsProgressPage() throws InterruptedException
 {
	By openProgramStatus = By.xpath("//a[normalize-space()='OKRs Program Status']");
	By okrsProgress = By.xpath("//a[normalize-space()='OKRs Progress']");
	By okrsProgressVerify = By.xpath("//h4[normalize-space()='OKRs Progress']");
	click(openProgramStatus);
	click(okrsProgress);
	click(openProgramStatus);
	return doGetText(okrsProgressVerify) ;
 }




 public String checkkrsProgressPage() throws InterruptedException
 {
	By openProgramStatus = By.xpath("//a[normalize-space()='OKRs Program Status']");
	By krsProgress = By.xpath("//a[normalize-space()='KRs Progress']");
	By krsProgressVerify = By.xpath("//h4[normalize-space()='KRs Progress']");
	click(openProgramStatus);
	click(krsProgress);
	click(openProgramStatus);
	return doGetText(krsProgressVerify) ;
 }




 public String checkkrsWithoutTasksPage() throws InterruptedException
 {
	By openProgramStatus = By.xpath("//a[normalize-space()='OKRs Program Status']");
	By krsWithoutTasks = By.xpath("//a[normalize-space()='KRs Without Tasks']");
	By krsWithoutTasksVerify = By.xpath("//h4[normalize-space()='KRs Without Tasks']");
	click(openProgramStatus);
	click(krsWithoutTasks);
	click(openProgramStatus);
	return doGetText(krsWithoutTasksVerify) ;
 }




 public String checkOkrsFulfillmentPage() throws InterruptedException
 {
	By openProgramStatus = By.xpath("//a[normalize-space()='OKRs Program Status']");
	By okrsFulfillment = By.xpath("//a[normalize-space()='OKRs Fulfillment']");
	By okrsFulfillmentVerify = By.xpath("//h4[normalize-space()='OKRs Fulfillment']");
	click(openProgramStatus);
	click(okrsFulfillment);
	click(openProgramStatus);
	return doGetText(okrsFulfillmentVerify) ;
 }





 public String checkPendingCheckinAsOfTodayPage() throws InterruptedException
 {
	By openProgramStatus = By.xpath("//a[normalize-space()='OKRs Program Status']");
	By pendingCheckinAsOfToday = By.xpath("//a[normalize-space()='Pending Check-ins']");
	By pendingCheckinAsOfTodayVerify = By.xpath("//h4[normalize-space()='Pending Check-ins: As of Today']");
	click(openProgramStatus);
	click(pendingCheckinAsOfToday);
	click(openProgramStatus);
	return doGetText(pendingCheckinAsOfTodayVerify) ;
 }




 public String checkMyOrgPendingCheckInsAsOfTodayPage() throws InterruptedException
 {
	By openProgramStatus = By.xpath("//a[normalize-space()='OKRs Program Status']");
	By myOrgPendingCheckInsAsOfToday = By.xpath("//a[normalize-space()='My Org Pending Check-ins']");
	By myOrgPendingCheckInsAsOfTodayVerify = By.xpath("//h3[normalize-space()='My Org Pending Check-ins: As of Today']");
	click(openProgramStatus);
	click(myOrgPendingCheckInsAsOfToday);
	click(openProgramStatus);
	return doGetText(myOrgPendingCheckInsAsOfTodayVerify) ;
 }





 public String checkUsersLoginHistoryPage() throws InterruptedException
 {
	 By openProgramStatus = By.xpath("//a[normalize-space()='OKRs Program Status']");
	 By usersLoginHistory = By.xpath("//a[normalize-space()='Users Login History']");
	 By usersLoginHistoryVerify = By.xpath("//h4[@class='float-left mt-2']");
	 click(openProgramStatus);
	 click(usersLoginHistory);
	 click(openProgramStatus);
	 return doGetText(usersLoginHistoryVerify) ;
 }





 public String checkOkrCheckInsReportPage() throws InterruptedException
 {
	 By openProgramStatus = By.xpath("//a[normalize-space()='OKRs Program Status']");
	 By okrCheckInsReport = By.xpath("//a[normalize-space()='OKR Check-ins Report']");
	 By okrCheckInsReportVerify = By.xpath("//h4[normalize-space()='OKR Check-ins Report']");
	 click(openProgramStatus);
	 click(okrCheckInsReport);
	 click(openProgramStatus);
	 return doGetText(okrCheckInsReportVerify) ;
 }







 /*/
  *  ****************************************** Task Page Functions *********************************************
  */

 public String enableTaskMenu()
 {
	 By taskTitle= By.xpath("//em[@title='Tasks']");
	 By taskMenu = By.xpath("//body//apptivo-profit-left-menu//a[@href=\"/app/ng/profit.jsp#/pr/tasks/workspace?wId=my_space&bId=my_tasks\"]");
	 click(taskMenu);
	 return doGetText(taskTitle);
     }




 public String checkWorkspacesPage()
 {
	 By checkWorkspaces= By.xpath("//a[@class='curpdr']");
	 By workspacesVerify = By.xpath("//h3[@class='float-left mb-0 d-flex justify-content-start align-items-center']");
	 By myWorkspace = By.xpath("//span[normalize-space()='My Workspaces']");
	 By privateWorkspace = By.xpath("//span[normalize-space()='Private Workspaces']");
	 By publicWorkspace = By.xpath("//span[normalize-space()='Public Workspaces']");
	 By hiddenWorkspace = By.xpath("//span[normalize-space()='Hidden Workspaces']");

	 click(checkWorkspaces);
	 click(myWorkspace);
	 click(privateWorkspace);
	 click(publicWorkspace);
	 click(hiddenWorkspace);

	 return doGetText(workspacesVerify);
     }





 public String checkMyTaskPage()
 {
	 By myTask= By.xpath("//a[normalize-space()='My Tasks']");
	 By myTaskVerify = By.xpath("//div[@class='mytasks']");
	 click(myTask);
	 return doGetText(myTaskVerify);
     }




 public String checkMyTaskForOthersPage()
 {
	 By myTaskForOthers= By.xpath("//a[normalize-space()='My Tasks for Others']");
	 By myTaskForOthersVerify = By.xpath("//div[@class='mytasks']");
	 click(myTaskForOthers);
	 return doGetText(myTaskForOthersVerify);
 }





 public String checkMyOrgsTaskPage()
 {
	 By myOrgsTask= By.xpath("//a[@href='/app/ng/profit.jsp#/pr/tasks/workspace?wId=my_space&bId=my_orgs_tasks']");
	 By myOrgsTaskVerify = By.xpath("//div[@class='mytasks']");
	 click(myOrgsTask);
	 return doGetText(myOrgsTaskVerify);
 }





 public String checkallEmployeeTasksPage()
 {
	 By allEmployeeTasks= By.xpath("//a[normalize-space()='All Employee Tasks']");
	 By allEmployeeTasksVerify = By.xpath("//div[@class='mytasks']");
	 click(allEmployeeTasks);
	 return doGetText(allEmployeeTasksVerify);
 }





 /*/
  *  ****************************************** CFRs Page Functions *********************************************
  */
 public String enableCfrMenu()
 {
	 By cfrTitle= By.xpath("//em[@title='CFRs']");
	 By cfrMenu = By.xpath("//body//apptivo-profit-left-menu//a[@baseurl=\"/app/ng/profit.jsp#/pr/cfrs/meetings\"]");
	 click(cfrMenu);
	 return doGetText(cfrTitle);
     }




 public String checkCfrsMeetingsPage() throws InterruptedException
 {
	 By cfrsMeetingsVerify = By.xpath("//h4[@class='d-flex align-items-center font-weight-normal']");
	 return doGetText(cfrsMeetingsVerify);
 }





 public String checkCfrsLeaderBoardPage() throws InterruptedException
 { 	 By openRecognition = By.xpath("//a[normalize-space()='Recognition']");
	 By cfrsLeaderBoard = By.xpath("//a[contains(text(),'Leaderboard')]");
	 By cfrsLeaderBoardVerify = By.cssSelector("div[class='d-flex align-item-center font-weoght-normal'] h4");
	 click(openRecognition);
	 click(cfrsLeaderBoard);
	 click(openRecognition);
	 return doGetText(cfrsLeaderBoardVerify);
 }





 public String checkMyAwardsReceivedPage() throws InterruptedException
 {
	 By openRecognition = By.xpath("//a[normalize-space()='Recognition']");
	 By openMyAwards = By.xpath("//a[normalize-space()='My Awards']");
	 By myAwardsReceived = By.xpath("//a[normalize-space()='Received']");
	 By cfrsAwardReceivedVerify = By.xpath("//h4[normalize-space()='My Awards: Received']");
	 click(openRecognition);
	 click(openMyAwards);
	 click(myAwardsReceived);
	 click(openMyAwards);
	 click(openRecognition);
	 return doGetText(cfrsAwardReceivedVerify);
 }





 public String checkMyAwardsGivenPage() throws InterruptedException
 {
	 By openRecognition = By.xpath("//a[normalize-space()='Recognition']");
	 By openMyAwards = By.xpath("//a[normalize-space()='My Awards']");
	 By myAwardsGiven = By.xpath("//a[normalize-space()='Given']");
	 By cfrsAwardGivenVerify = By.xpath("//h4[normalize-space()='My Awards: Given']");
	 click(openRecognition);
	 click(openMyAwards);
	 click(myAwardsGiven);
	 click(openMyAwards);
	 click(openRecognition);
	 return doGetText(cfrsAwardGivenVerify);
 }




 public String checkMyOrgAwardsReceivedPage() throws InterruptedException
 {
	 By openRecognition = By.xpath("//a[normalize-space()='Recognition']");
	 By openMyOrg = By.xpath("//a[normalize-space()='My Organization']");
	 By myOrgAwardsReceived = By.xpath("//a[normalize-space()='Awards Received']");
	 By myOrgAwardsRecievedVerify = By.xpath("//h4[normalize-space()='My Organization: Received']");

	 click(openRecognition);
	 click(openMyOrg);
	 click(myOrgAwardsReceived);
	 click(openMyOrg);
	 click(openRecognition);

	 return doGetText(myOrgAwardsRecievedVerify);
 }







 public String checkMyOrgAwardsGivenPage() throws InterruptedException
 {
	 By openRecognition = By.xpath("//a[normalize-space()='Recognition']");
	 By openMyOrg = By.xpath("//a[normalize-space()='My Organization']");
	 By myOrgAwardsGiven = By.xpath("//a[normalize-space()='Awards Given']");
	 By myOrgAwardsGivenVerify = By.xpath("//h4[normalize-space()='My Organization: Given']");

	 click(openRecognition);
	 click(openMyOrg);
	 click(myOrgAwardsGiven);
	 click(openMyOrg);
	 click(openRecognition);

	 return doGetText(myOrgAwardsGivenVerify);
 }







 /*/
  *  ****************************************** Settings Page Functions *********************************************
  */
 public String enableSettingMenu()
 {
	 By settingMenu = By.xpath("//*[@name='lft-setting']//*[name()='svg']");
	 By settingTitle= By.xpath("//em[@title='Settings']");

	 click(settingMenu);
	 return doGetText(settingTitle);
     }





 public String checkBusinessInformationPage()
 {
	 By settingMenu = By.xpath("//*[@name='lft-setting']//*[name()='svg']");
	 By businessInformationVerify= By.xpath("//h4[@class='float-left mt-2']");

	 click(settingMenu);
	 return doGetText(businessInformationVerify);
     }






 public String checkActionCenterPageSetting()
 {
	 By openGeneral = By.xpath("//span[@title='General']");
	 By actionCenter = By.xpath("//a[normalize-space()='Action Center']");
	 By actionCenterVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openGeneral);
	 click(actionCenter);
	 click(openGeneral);
	 return doGetText(actionCenterVerify);
 }





 public String checkGradesPageSetting()
 {
	 By openGeneral = By.xpath("//span[@title='General']");
	 By grades = By.xpath("//a[normalize-space()='Grades']");
	 By gradesVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openGeneral);
	 click(grades);
	 click(openGeneral);
	 return doGetText(gradesVerify);
 }






 public String checkHashtaggedConversationsPageSetting()
 {
	 By openGeneral = By.xpath("//span[@title='General']");
	 By hashtaggedConversation = By.xpath("//a[normalize-space()='Hashtagged Conversations']");
	 By hashtaggedConversationVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openGeneral);
	 click(hashtaggedConversation);
	 click(openGeneral);
	 return doGetText(hashtaggedConversationVerify);
 }






 public String checkModulesPageSetting()
 {
	 By openGeneral = By.xpath("//span[@title='General']");
	 By modules = By.xpath("//a[normalize-space()='Modules']");
	 By modulesVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openGeneral);
	 click(modules);
	 click(openGeneral);
	 return doGetText(modulesVerify);
 }






 public String checkDocumentsPageSetting()
 {
	 By openGeneral = By.xpath("//span[@title='General']");
	 By documents = By.xpath("//a[normalize-space()='Documents']");
	 By documentsVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openGeneral);
	 click(documents);
	 click(openGeneral);
	 return doGetText(documentsVerify);
 }






 public String checkSystemEmailsPageSetting()
 {
	 By openGeneral = By.xpath("//span[@title='General']");
	 By systemEmails = By.xpath("//a[normalize-space()='System Emails']");
	 By systemEmailsVerify= By.xpath("//h4[normalize-space()='System Emails']");

	 click(openGeneral);
	 click(systemEmails);
	 click(openGeneral);
	 return doGetText(systemEmailsVerify);
 }





 /*
  * ************************************* Setting  strategies functions ***********************************************
  */



 public String checkDirectivesPageSetting()
 {
	 By openStrategy = By.xpath("//span[@title='Strategy']");
	 By directives = By.xpath("//a[normalize-space()='Directives']");
	 By directivesVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openStrategy);
	 click(directives);
	 click(openStrategy);
	 return doGetText(directivesVerify);
 }




 public String checkFocusAreaPageSetting()
 {
	 By openStrategy = By.xpath("//span[@title='Strategy']");
	 By focusArea = By.xpath("//a[normalize-space()='Focus Areas']");
	 By focusAreaVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openStrategy);
	 click(focusArea);
	 click(openStrategy);
	 return doGetText(focusAreaVerify);
 }




 public String checkInitiativesPageSetting()
 {
	 By openStrategy = By.xpath("//span[@title='Strategy']");
	 By initiatives = By.xpath("//a[normalize-space()='Initiatives']");
	 By initiativesVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openStrategy);
	 click(initiatives);
	 click(openStrategy);
	 return doGetText(initiativesVerify);
 }




 public String checkMeasurementsPageSetting()
 {
	 By openStrategy = By.xpath("//span[@title='Strategy']");
	 By measurements = By.xpath("//a[normalize-space()='Measurements']");
	 By measurementsVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openStrategy);
	 click(measurements);
	 click(openStrategy);
	 return doGetText(measurementsVerify);
 }




 public String checkPrioritiesPageSetting()
 {
	 By openStrategy = By.xpath("//span[@title='Strategy']");
	 By priorities = By.xpath("//body//apptivo-profit-left-menu//div//ul//li//*[contains(@baseurl, '/app/ng/profit.jsp#/pr/settings/strategy')][contains(text(), 'Priorities')]");
	 By prioritiesVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openStrategy);
	 click(priorities);
	 click(openStrategy);
	 return doGetText(prioritiesVerify);
 }




 public String checkReportsPageSetting()
 {
	 By openStrategy = By.xpath("//span[@title='Strategy']");
	 By reports = By.xpath("//a[normalize-space()='Reports']");
	 By reportsVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openStrategy);
	 click(reports);
	 click(openStrategy);
	 return doGetText(reportsVerify);
 }





 /*
  * ************************************* Setting  OKR functions ***********************************************
  */

 public String checkAlignmentsDependenciesPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By alignmentsDependencies = By.xpath("//a[normalize-space()='Alignments & Dependencies']");
	 By alignmentsDependenciesVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(alignmentsDependencies);
	 click(openOKR);
	 return doGetText(alignmentsDependenciesVerify);
 }





 public String checkBaselineSequencePageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By baselineSequence = By.xpath("//a[normalize-space()='Baseline Sequence']");
	 By baselineSequencesVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(baselineSequence);
	 click(openOKR);
	 return doGetText(baselineSequencesVerify);
 }




 public String checkControlsPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By controls = By.xpath("//a[normalize-space()='Controls']");
	 By controlsVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(controls);
	 click(openOKR);
	 return doGetText(controlsVerify);
 }




 public String checkFrequenciesPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By frequencies = By.xpath("//a[normalize-space()='Frequencies']");
	 By frequenciesVerify= By.xpath("//body//h4[contains(text(),'Frequencies')]");

	 click(openOKR);
	 click(frequencies);
	 click(openOKR);
	 return doGetText(frequenciesVerify);
 }




 public String checkDashboardAndFiltersPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By dashboardAndFilters = By.xpath("//a[normalize-space()='Dashboard & Filters']");
	 By dashboardAndFiltersVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(dashboardAndFilters);
	 click(openOKR);
	 return doGetText(dashboardAndFiltersVerify);
 }



 public String checkKeyResultTypesPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By keyResultTypes = By.xpath("//a[normalize-space()='Key Result Types']");
	 By keyResultTypesVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(keyResultTypes);
	 click(openOKR);
	 return doGetText(keyResultTypesVerify);
 }





 /*
  * ****************************************** OKRS Setting Page Functions ************************************
  */


 public String checkKpisCategoriesPageSetting() throws InterruptedException
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openOKRS = By.xpath("//a[normalize-space()='KPIs']");
	 By categories = By.xpath("//a[normalize-space()='Categories']");
	 By categoriesVerify= By.xpath("//h4[@class='h5 float-left mt-1']");

	 click(openOKR);
	 click(openOKRS);
	 click(categories);
	 click(openOKRS);
	 click(openOKR);
	 return doGetText(categoriesVerify);
 }







 public String checkKpisByCategoryPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openOKRS = By.xpath("//a[normalize-space()='KPIs']");
	 By KpisByCategory = By.xpath("//a[normalize-space()='KPIs by Category']");
	 By KpisByCategoryVerify= By.xpath("//h4[@class='h5 float-left']");

	 click(openOKR);
	 click(openOKRS);
	 click(KpisByCategory);
	 click(openOKRS);
	 click(openOKR);



	 return doGetText(KpisByCategoryVerify);
 }





 public String checkKpiBoardsPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openOKRS = By.xpath("//a[normalize-space()='KPIs']");
	 By kpiBoards = By.xpath("//a[normalize-space()='KPI Boards']");
	 By kpiBoardsVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(openOKRS);
	 click(kpiBoards);
	 click(openOKRS);
	 click(openOKR);
	 return doGetText(kpiBoardsVerify);
 }



 /*
  * **************************************** Setting's OKR's Master layout functions ***********************************
  */


 public String checkOkrsMasterLayoutPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openMasterLayout = By.xpath("//a[@class='nav-link subMenu'][normalize-space()='Master Layout']");
	 By objectives = By.xpath("//body//apptivo-profit-left-menu//ul/li//*[starts-with(@baseurl, '/app/ng/profit.jsp#/pr/settings/performance/okrs')] [contains(text(), 'Objectives ')]");
	 By objectiveVerify= By.xpath("//span[@class='ml-2 mt-1 float-left']");

	 click(openOKR);
	 click(openMasterLayout);
	 click(objectives);
	 click(openMasterLayout);
	 click(openOKR);
	 return doGetText(objectiveVerify);
 }




 public String checkOkrsKeyResultsPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openMasterLayout = By.xpath("//a[@class='nav-link subMenu'][normalize-space()='Master Layout']");
	 By keyResults = By.xpath("//body//apptivo-profit-left-menu//ul/li//*[starts-with(@baseurl, '/app/ng/profit.jsp#/pr/settings/performance/okrs')] [contains(text(), 'Key Results ')]");
	 By keyResultsVerify= By.xpath("//span[@class='ml-2 mt-1 float-left']");

	 click(openOKR);
	 click(openMasterLayout);
	 click(keyResults);
	 click(openMasterLayout);
	 click(openOKR);
	 return doGetText(keyResultsVerify);
 }




 /*
  *  ****************** Normal Okr Menu need to move this to the top of the page *************************************
  */

 public String checkOkrsMilestoneSequencePageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By milestoneSequence = By.xpath("//a[normalize-space()='Milestone Sequence']");
	 By milestoneSequenceVerify= By.xpath("//h4[contains(text(),'Milestone Sequence')]");

	 click(openOKR);
	 click(milestoneSequence);
	 click(openOKR);
	 return doGetText(milestoneSequenceVerify);
 }





 public String checkOKRAuthoringPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By okrAuthoring = By.xpath("//a[normalize-space()='OKR Authoring']");
	 By okrAuthoringVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(okrAuthoring);
	 click(openOKR);
	 return doGetText(okrAuthoringVerify);
 }





 public String checkOKRLevelsPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By okrlevels = By.xpath("//a[normalize-space()='OKR Levels']");
	 By okrlevelsVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(okrlevels);
	 click(openOKR);
	 return doGetText(okrlevelsVerify);
 }





 public String checkOKRListViewPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By okrListView = By.xpath("//a[normalize-space()='OKR List View']");
	 By okrListViewVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(okrListView);
	 click(openOKR);
	 return doGetText(okrListViewVerify);
 }





 public String checkOKRRankingPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By okrRanking = By.xpath("//a[normalize-space()='OKR Ranking']");
	 By okrRankingVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(okrRanking);
	 click(openOKR);
	 return doGetText(okrRankingVerify);
 }





 public String checkOkrsPeriodsPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By periods = By.xpath("//a[normalize-space()='Periods']");
	 By periodsVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(periods);
	 click(openOKR);
	 return doGetText(periodsVerify);
 }





 public String checkReflectResetPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By reflectReset = By.xpath("//a[normalize-space()='Reflect/Reset']");
	 By reflectResetVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(reflectReset);
	 click(openOKR);
	 return doGetText(reflectResetVerify);
 }





 public String checkOkrsReviewsPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By reviews = By.xpath("//a[normalize-space()='Reviews']");
	 By reviewsVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(reviews);
	 click(openOKR);
	 return doGetText(reviewsVerify);
 }






 public String checkOkrsStatusesPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By statuses = By.xpath("//a[@baseurl='/app/ng/profit.jsp#/pr/settings/okrs/statuses']");
	 By statusesVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(statuses);
	 click(openOKR);
	 return doGetText(statusesVerify);
 }





 public String checkOkrsTagsPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By tags = By.xpath("//a[normalize-space()='Tags']");
	 By tagsVerify= By.xpath("//h4[@class='float-left']");

	 click(openOKR);
	 click(tags);
	 click(openOKR);
	 return doGetText(tagsVerify);
 }





 public String checkOkrsTemplatesPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By templates = By.xpath("//a[normalize-space()='Templates']");
	 By templatesVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(templates);
	 click(openOKR);
	 return doGetText(templatesVerify);
 }






 public String checkOkrsVisibilityPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By visibility = By.xpath("//a[normalize-space()='Visibility']");
	 By visibilityVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(visibility);
	 click(openOKR);
	 return doGetText(visibilityVerify);
 }



 /*
  * ****************************** Task Managements Setting Functions ************************************************
  */




 public String checkTaskPriorityPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openTask = By.xpath("//span[@title='Tasks']");
	 By priority = By.xpath("//a[@baseurl='/app/ng/profit.jsp#/pr/settings/tasks/priorities']");
	 By priorityVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(openTask);
	 click(priority);
	 click(openTask);
	 click(openOKR);
	 return doGetText(priorityVerify);
 }





 public String checkTaskSecurityPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openTask = By.xpath("//span[@title='Tasks']");
	 By security = By.xpath("//a[@baseurl='/app/ng/profit.jsp#/pr/settings/tasks/security']");
	 By securityVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(openTask);
	 click(security);
	 click(openTask);
	 click(openOKR);
	 return doGetText(securityVerify);
 }





 public String checkTaskStatusesPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openTask = By.xpath("//span[@title='Tasks']");
	 By statuses = By.xpath("//a[@baseurl='/app/ng/profit.jsp#/pr/settings/tasks/statuses']");
	 By statusesVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(openTask);
	 click(statuses);
	 click(openTask);
	 click(openOKR);
	 return doGetText(statusesVerify);
 }





 public String checkTaskMasterLayoutPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openTask = By.xpath("//span[@title='Tasks']");
	 By masterLayout = By.xpath("//a[@class='nav-link'][normalize-space()='Master Layout']");
	 By masterLayoutVerify= By.xpath("//span[@class='ml-2 mt-1 float-left']");

	 click(openOKR);
	 click(openTask);
	 click(masterLayout);
	 click(openTask);
	 click(openOKR);
	 return doGetText(masterLayoutVerify);
 }


 /*
  * *************************************** Meeting Setting page functions ********************************************
  */



 public String checkMeetingsPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By meetings = By.xpath("//span[@title='Meetings']");
	 By meetingsVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(meetings);
	 click(openOKR);
	 return doGetText(meetingsVerify);
 }


 /*
  * ************************************** Note's Security Setting functions **********************************************
  */




 public String checkSecurityPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openNotes = By.xpath("//span[@title='Notes']");
	 By security = By.xpath("//a[@baseurl='/app/ng/profit.jsp#/pr/settings/notes/security']");
	 By securityVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(openNotes);
	 click(security);
	 click(openNotes);
	 click(openOKR);
	 return doGetText(securityVerify);
 }





 /*
  * ************************************** CFR's Pulse Survey Setting functions **********************************************
  */




 public String checkCfrPulseSurveyPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openCFR = By.xpath("//span[@title='CFR']");
	 By pulseSurveys = By.xpath("//a[normalize-space()='Pulse Surveys']");
	 By pulseSurveysVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(openCFR);
	 click(pulseSurveys);
	 click(openCFR);
	 click(openOKR);
	 return doGetText(pulseSurveysVerify);
 }





 /*
  * ************************************** User Management Setting functions **********************************************
  */




 public String checkActiveUserPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openUserManagement = By.xpath("//span[@title='User Management']");
	 By activeUser = By.xpath("//a[normalize-space()='Active Users']");
	 By activeUserVerify= By.xpath("//h4[@class='float-left mt-2']");

	 click(openOKR);
	 click(openUserManagement);
	 click(activeUser);
	 click(openUserManagement);
	 click(openOKR);
	 return doGetText(activeUserVerify);
 }





 public String checkDepartmentsPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openUserManagement = By.xpath("//span[@title='User Management']");
	 By departments = By.xpath("//a[normalize-space()='Departments']");
	 By departmentsVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(openUserManagement);
	 click(departments);
	 click(openUserManagement);
	 click(openOKR);
	 return doGetText(departmentsVerify);
 }





 public String checkJobTitlesPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openUserManagement = By.xpath("//span[@title='User Management']");
	 By jobTitles = By.xpath("//a[normalize-space()='Job Titles']");
	 By jobTitlesVerify= By.xpath("//h4[contains(text(),'Job Titles')]");

	 click(openOKR);
	 click(openUserManagement);
	 click(jobTitles);
	 click(openUserManagement);
	 click(openOKR);
	 return doGetText(jobTitlesVerify);
 }





 public String checkNumberGenerationPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openUserManagement = By.xpath("//span[@title='User Management']");
	 By numberGeneration = By.xpath("//a[contains(text(),'Number Generation')]");
	 By numberGenerationVerify= By.xpath("//h4[contains(text(),'Number Generation')]");

	 click(openOKR);
	 click(openUserManagement);
	 click(numberGeneration);
	 click(openUserManagement);
	 click(openOKR);
	 return doGetText(numberGenerationVerify);
 }





 public String checkTerminatedUsersPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openUserManagement = By.xpath("//span[@title='User Management']");
	 By terminatedUsers = By.xpath("//a[normalize-space()='Terminated Users']");
	 By terminatedUsersVerify= By.xpath("//h4[contains(text(),'Terminated Users')]");

	 click(openOKR);
	 click(openUserManagement);
	 click(terminatedUsers);
	 click(openUserManagement);
	 click(openOKR);
	 return doGetText(terminatedUsersVerify);
 }





 public String checkUserRolesPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openUserManagement = By.xpath("//span[@title='User Management']");
	 By userRoles = By.xpath("//a[normalize-space()='User Roles']");
	 By userRolesVerify= By.xpath("//h3[normalize-space()='User Roles']");

	 click(openOKR);
	 click(openUserManagement);
	 click(userRoles);
	 click(openUserManagement);
	 click(openOKR);
	 return doGetText(userRolesVerify);
 }





 /*
  *  ****************************************** Security Setting Functions *********************************************
  */

 public String checkAPIAccessPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openSecurity = By.xpath("//span[@title='Security']");
	 By apiAccess = By.xpath("//a[normalize-space()='API Access']");
	 By apiAccessVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(openSecurity);
	 click(apiAccess);
	 click(openSecurity);
	 click(openOKR);
	 return doGetText(apiAccessVerify);
 }




 public String checkUserAccessPageSetting()
 {
	 By openOKR = By.xpath("//span[@title='OKRs']");
	 By openSecurity = By.xpath("//span[@title='Security']");
	 By userAccess = By.xpath("//a[normalize-space()='User Access']");
	 By userAccessVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openOKR);
	 click(openSecurity);
	 click(userAccess);
	 click(openSecurity);
	 click(openOKR);
	 return doGetText(userAccessVerify);
 }




 /*
  ***************** Normal Setting have to move this to the top of the page **************************************
  */




 public String checkTvAndDevicesPageSetting()
 {

	 By tvAndDevices = By.xpath("//span[@title='TV & Devices']");
	 By tvAndDevicesVerify= By.xpath("//h5[@class='font-weight-bold m-0 d-flex align-items-center']");

	 click(tvAndDevices);
	 return doGetText(tvAndDevicesVerify);
 }





 public String checkLocalizationPageSetting()
 {

	 By localization = By.xpath("//span[@title='Localization']");
	 By localizationVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(localization);
	 return doGetText(localizationVerify);
 }





 public String checkTeamsPageSetting()
 {

	 By teams = By.xpath("//span[@title='Teams']");
	 By teamsVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(teams);
	 return doGetText(teamsVerify);
 }





 /*
  *  ****************************************** Integeration Page Functions *********************************************
  */

 public String checkConnectorsPageSetting()
 {
	 By openintegeration= By.xpath("//span[@title='Integrations']");
	 By connectors = By.xpath("//a[normalize-space()='Connectors']");
	 By connectorsVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openintegeration);
	 click(connectors);
	 click(openintegeration);
	 return doGetText(connectorsVerify);
 }




 public String checkDomainsPageSetting()
 {
	 By openintegeration= By.xpath("//span[@title='Integrations']");
	 By domains = By.xpath("//a[normalize-space()='Domains']");
	 By domainsVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openintegeration);
	 click(domains);
	 click(openintegeration);
	 return doGetText(domainsVerify);
 }




 public String checkGoogleWorkspacePageSetting() throws InterruptedException
 {
	 By openintegeration= By.xpath("//span[@title='Integrations']");
	 By openGoogleWorkspace = By.xpath("//a[normalize-space()='Google Workspace']");
	 By openGoogleUsers = By.xpath("//body//apptivo-profit-left-menu//div/ul/li//*[contains(text(), 'Google Users')]");
	 By clickAll = By.xpath("//a[contains(text(),'ALL')]");
	 By googleWorkspaceVerify= By.xpath("//h4[@class='float-left mt-2']");

	 click(openintegeration);
	 Thread.sleep(1000);

	click(openGoogleWorkspace);
	 Thread.sleep(1000);

	 click(openGoogleUsers);
	 Thread.sleep(1000);
	 click(clickAll);
	 click(openGoogleUsers);
	 click(openGoogleWorkspace);
	 click(openintegeration);
	 return doGetText(googleWorkspaceVerify);
 }




 public String checkSamlSSOPageSetting()
 {
	 By openintegeration= By.xpath("//span[@title='Integrations']");
	 By samlSSO = By.xpath("//a[normalize-space()='SAML SSO']");
	 By samlSSOVerify= By.xpath("SAML SSO");

	 click(openintegeration);
	 click(samlSSO);
	 click(openintegeration);

	 return doGetText(samlSSOVerify);
 }




 public String checkUserLevelConnectorsPageSetting()
 {
	 By openintegeration= By.xpath("//span[@title='Integrations']");
	 By userLevelConnectors = By.xpath("//a[normalize-space()='User Level Connectors']");
	 By userLevelConnectorsVerify= By.xpath("SAML SSO");

	 click(openintegeration);
	 click(userLevelConnectors);
	 click(openintegeration);

	 return doGetText(userLevelConnectorsVerify);
 }









 /*
  *  ****************************************** Trigger Page Functions *********************************************
  */





 public String checkObjectivesPageSetting()
 {
	 By openTrigger = By.xpath("//span[@title='Triggers']");
	 By Objectives = By.xpath("//li[@class='nav-item active']//a[@role='button'][normalize-space()='Objectives']");
	 By ObjectivesVerify= By.xpath("//h3[@class='font-weight-normal']");

	 click(openTrigger);
	 click(Objectives);
	 click(openTrigger);
	 return doGetText(ObjectivesVerify);
 }




 public String checkTriggerKeyResultsPageSetting()
 {
	 By openTrigger = By.xpath("//span[@title='Triggers']");
	 By keyResults = By.xpath("//li[@class='nav-item active']//a[@role='button'][normalize-space()='Key Results']");
	 By keyResultsVerify= By.xpath("//h3[@class='font-weight-normal']");

	 click(openTrigger);
	 click(keyResults);
	 click(openTrigger);
	 return doGetText(keyResultsVerify);
 }




 public String checkCheckInsPageSetting()
 {
	 By openTrigger = By.xpath("//span[@title='Triggers']");
	 By checkIns = By.xpath("//a[normalize-space()='Check-ins']");
	 By checkInsVerify= By.xpath("//h3[@class='font-weight-normal']");

	 click(openTrigger);
	 click(checkIns);
	 click(openTrigger);
	 return doGetText(checkInsVerify);
 }








 /*
  *  ****************************************** Newsfeed Page Functions *********************************************
  */





 public String checkCannedMessagesPageSetting()
 {
	 By openNewsFeed = By.xpath("//span[@title='News Feed']");
	 By cannedMessages = By.xpath("//a[normalize-space()='Canned Messages']");
	 By cannedMessagesVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openNewsFeed);
	 click(cannedMessages);
	 click(openNewsFeed);

	 return doGetText(cannedMessagesVerify);
 }




 public String checkNewsFeedEventsPageSetting()
 {
	 By openNewsFeed = By.xpath("//span[@title='News Feed']");
	 By events = By.xpath("//a[normalize-space()='Events']");
	 By eventsVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openNewsFeed);
	 click(events);
	 click(openNewsFeed);

	 return doGetText(eventsVerify);
 }




 public String checkPredefinedFiltersPageSetting()
 {
	 By openNewsFeed = By.xpath("//span[@title='News Feed']");
	 By predefinedFilters = By.xpath("//a[normalize-space()='Predefined Filters']");
	 By predefinedFiltersVerify= By.xpath("News Feed: Predefined Filters");

	 click(openNewsFeed);
	 click(predefinedFilters);
	 click(openNewsFeed);

	 return doGetText(predefinedFiltersVerify);
 }





 /*
  ***************** Normal Setting have to move this to the top of the page **************************************
  */

 public String checkBillingPageSetting()
 {

	 By billing = By.xpath("//span[@title='Billing']");
	 By billingVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(billing);
	 return doGetText(billingVerify);
 }



 public String checkDeleteAccountPageSetting()
 {
	 By deleteAccount = By.xpath("//span[@title='Delete Account']");
	 By deleteAccountVerify= By.xpath("//h5[@class='modal-title pull-left']");


	 click(deleteAccount);
	 return doGetText(deleteAccountVerify);
 }




 /*
  *  ****************************************** Preference Page Functions *********************************************
  */



 public String enablePreferenceMenu()
 {
	 By preferenceTitle= By.xpath("//em[@title='Preferences']");
	 By preferenceMenu = By.xpath("//body//apptivo-profit-left-menu//a[@baseurl=\"/app/ng/profit.jsp#/pr/preferences/general\"]");
	 click(preferenceMenu);
	 return doGetText(preferenceTitle);
     }




 public String checkPreferenceGeneralPageSetting()
 {
	 By general = By.xpath("//span[@title='General']");
	 By generalVerify= By.xpath("//h4[@class='mt-1 float-left']");

	 click(general);
	 return doGetText(generalVerify);
 }





 public String checkPreferenceAppearancePageSetting()
 {
	 By appearance = By.xpath("//span[@title='Appearance']");
	 By appearanceVerify= By.xpath("//h4[normalize-space()='Appearance']");

	 click(appearance);
	 return doGetText(appearanceVerify);
 }




 public String checkPreferenceActionCenterPageSetting()
 {
	 By actionCenter = By.xpath("//span[@title='Action Center']");
	 By actionCenterVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(actionCenter);
	 return doGetText(actionCenterVerify);
 }




 public String checkPreferencePasswordPageSetting()
 {
	 By password = By.xpath("//span[@title='Password']");
	 By passwordVerify= By.xpath("//h4[@class='mt-1 float-left']");

	 click(password);
	 return doGetText(passwordVerify);
 }




 public String checkPreferenceCannedMessagesPageSetting()
 {
	 By openPreferenceCfr = By.xpath("//span[@title='CFR']");
	 By cannedMessages = By.xpath("//a[normalize-space()='Canned Messages']");
	 By cannedMessagesVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openPreferenceCfr);
	 click(cannedMessages);
	 click(openPreferenceCfr);

	 return doGetText(cannedMessagesVerify);
 }




 public String checkPreferenceEventsPageSetting()
 {
	 By openPreferenceCfr = By.xpath("//span[@title='CFR']");
	 By events = By.xpath("//a[normalize-space()='Events']");
	 By eventsVerify= By.xpath("//h4[@class='float-left mt-1']");

	 click(openPreferenceCfr);
	 click(events);
	 click(openPreferenceCfr);

	 return doGetText(eventsVerify);
 }









}
