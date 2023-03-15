package com.profit.qa.testpages;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.profit.qa.StaticDatas.PageLoadingStaticData;
import com.profit.qa.basetest.LoginTestBase;
import com.profit.qa.pages.PageMenus;

public class PageMenusTest extends LoginTestBase {

	@Test(priority =1 )
	public void doLogin() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException
	{
		page.getInstance(PageMenus.class).doLogin();
	}

     @Test(priority =2 ,dependsOnMethods = { "doLogin"})
	 public void enableHomeMenu() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	 {
		 String title =page.getInstance(PageMenus.class).enableHomeMenu();
		 Assert.assertEquals(title , PageLoadingStaticData.homeMainTitle );

	 }


	@Test( priority =3, dependsOnMethods = { "doLogin" , "enableHomeMenu" } )
	public void checkAlignmentPage() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkAlignmentPage();
	  Assert.assertEquals(title , PageLoadingStaticData.alignments );
	}





	@Test(priority =4 ,alwaysRun = true , dependsOnMethods = { "doLogin", "enableHomeMenu" })
	public void checkActionCenterPage() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkActionCenterPage();
	  Assert.assertEquals(title , PageLoadingStaticData.actionCenter );
	}





	@Test(priority =5 ,  alwaysRun = true , dependsOnMethods = { "doLogin" , "enableHomeMenu" })
	public void checkAlignmentAndDependencies() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkAlignmentAndDependenciesPage();
	  Assert.assertEquals(title , PageLoadingStaticData.alignmentsAndDependencies );
	}





	@Test(priority =6 ,  alwaysRun = true , dependsOnMethods = { "doLogin", "enableHomeMenu" })
	public void checkMeetingPage() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkMeetingsPage();
	  Assert.assertEquals(title , PageLoadingStaticData.meetings );
	}





	@Test(priority =7 ,  alwaysRun = true , dependsOnMethods = { "doLogin" , "enableHomeMenu" })
	public void checkNotesPage() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkNotesPage();
	  Assert.assertEquals(title , PageLoadingStaticData.notes );
	}





	@Test(priority =8 ,  alwaysRun = true , dependsOnMethods = { "doLogin", "enableHomeMenu" })
	public void checkcompanyDashboard() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkCompanyDashboardPage();
	  Assert.assertEquals(title , PageLoadingStaticData.companyDashboard );
	}





	@Test(priority =9 ,  alwaysRun = true , dependsOnMethods = { "doLogin" , "enableHomeMenu" })
	public void checkDepartmentHierarchy() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkDepartmentHierarchyPage();
	  Assert.assertEquals(title , PageLoadingStaticData.departmentHierarchy );
	}





	@Test(priority =10 ,  alwaysRun = true , dependsOnMethods = { "doLogin", "enableHomeMenu" } )
	public void checkNewsFeed() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkNewsFeedPage();
	  Assert.assertEquals(title , PageLoadingStaticData.newsFeed );
	}





	@Test(priority =11 ,  alwaysRun = true , dependsOnMethods = { "doLogin" , "enableHomeMenu" })
	public void checkOrganizationHierarchy() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkOrganizationHierarchyPage();
	  Assert.assertEquals(title , PageLoadingStaticData.organizationHierarchy );
	}

	/*
	 *
	 * ************************************ Page load test cases for OKR Page ******************************************
	 *
	 */


	@Test(priority =12 ,  alwaysRun = true , dependsOnMethods = { "doLogin" } )
	public void checkOkrMenuEnabled() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).enableOkrMenu();
	  Assert.assertEquals(title , PageLoadingStaticData.okrMenuTitle );
	}

	@Test(priority =13 ,  alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkAllMyOkrs() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkAllMyOkrsPage();
	  Assert.assertEquals(title , PageLoadingStaticData.allMyOkrs );
	}




	@Test(priority =14  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkMyIndivitualOkr() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkMyIndivitualOkrPage();
	  Assert.assertEquals(title , PageLoadingStaticData.myIndividualOkrs );
	}




	@Test(priority =15  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkOrgsOkr() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkOrgsOkrPage();
	  Assert.assertEquals(title , PageLoadingStaticData.oKRs );
	}




	@Test(priority =16  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkMyOrgsOkr() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkMyOrgsOkrPage();
	  Assert.assertEquals(title , PageLoadingStaticData.myOrgsOKkrs );
	}




	@Test(priority =17  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkWatchedOkr() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkWatchedOkrPage();
	  Assert.assertEquals(title , PageLoadingStaticData.watchedOkrs );
	}



	@Test(priority =18  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkSharedOkr() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkSharedOkrPage();
	  Assert.assertEquals(title , PageLoadingStaticData.sharedOkrs );
	}




	@Test(priority =19  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkKpisAll() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkKpisAllPage();
	  Assert.assertEquals(title , PageLoadingStaticData.okrsByKPIsAll );
	}



	@Test(priority =20  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkKpisWatched() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkKpisWatchedPage();
	  Assert.assertEquals(title , PageLoadingStaticData.okrsByKPIsWatched );
	}





	@Test(priority =21  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkObjectivesbyTags() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkObjectivesbyTagsPage();
		Assert.assertEquals(title , PageLoadingStaticData.objectivesbyTags );
	}





	@Test(priority =22  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkKeyResultsByTags() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkKeyResultsByTagsPage();
		Assert.assertEquals(title , PageLoadingStaticData.keyResultsByTags );
	}




	@Test(priority =23  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkAllEmployeeOkr() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkAllEmployeeOkrPage();
	  Assert.assertEquals(title , PageLoadingStaticData.allEmployeesOkrs );
	}




	@Test(priority =24  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkAllDepartmentOkr() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkAllDepartmentOkrPage();
	  Assert.assertEquals(title , PageLoadingStaticData.allDepartmentsOkrs );
	}





	@Test(priority =25  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkManagersOkrs() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkManagersOkrsPage();
	  Assert.assertEquals(title , PageLoadingStaticData.managersOkrs );
	}




	@Test(priority =26  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkOkrsAuthoring() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkOkrsAuthoringPage();
	  Assert.assertEquals(title , PageLoadingStaticData.okrsAuthoring );
	}




	@Test(priority =27  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkOkrsProgress() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkOkrsProgressPage();
	  Assert.assertEquals(title , PageLoadingStaticData.okrsProgress );
	}



	@Test(priority =28  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkkrsProgress() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkkrsProgressPage();
	  Assert.assertEquals(title , PageLoadingStaticData.krsProgress );
	}




	@Test(priority =29  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkkrsWithoutTasks() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkkrsWithoutTasksPage();
	  Assert.assertEquals(title , PageLoadingStaticData.krsWithoutTasks );
	}




	@Test(priority =30  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkOkrsFulfillment() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkOkrsFulfillmentPage();
	  Assert.assertEquals(title , PageLoadingStaticData.okrsFulfillment );
	}




	@Test(priority =31  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkPendingCheckinAsOfToday() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
	  String title =page.getInstance(PageMenus.class).checkPendingCheckinAsOfTodayPage();
	  Assert.assertEquals(title , PageLoadingStaticData.asOfToday );
	}





	@Test(priority =32  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkMyOrgPendingCheckInsAsOfToday() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkMyOrgPendingCheckInsAsOfTodayPage();
		Assert.assertEquals(title , PageLoadingStaticData.myOrgAsOfToday );
	}





	@Test(priority =33  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkUsersLoginHistory() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkUsersLoginHistoryPage();
		Assert.assertEquals(title , PageLoadingStaticData.usersLoginHistory );
	}



	@Test(priority =34  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkOkrMenuEnabled" } , groups= {"OKR"})
	public void checkOkrCheckInsReportPage() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkOkrCheckInsReportPage();
		Assert.assertEquals(title , PageLoadingStaticData.oKRCheckinsReport );
	}



	/*
	 *
	 * ************************************* Task Page Test case's **************************************
	 *
	 */




	@Test(priority =35  , alwaysRun = true , dependsOnMethods = { "doLogin"  } )
	public void checkTaskMenuEnabled() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).enableTaskMenu();
		Assert.assertEquals(title , PageLoadingStaticData.taskMainTitle );
	}





	@Test(priority =36  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkTaskMenuEnabled"} )
	public void checkWorkspaces() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkWorkspacesPage();
		Assert.assertEquals(title , PageLoadingStaticData.workspaces );
	}





	@Test(priority =37  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkTaskMenuEnabled"} )
	public void checkMyTask() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkMyTaskPage();
		Assert.assertEquals(title , PageLoadingStaticData.myTasks );
	}


	@Test(priority =38  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkTaskMenuEnabled"} )
	public void checkMyTaskForOthers() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkMyTaskForOthersPage();
		Assert.assertEquals(title , PageLoadingStaticData.myTasksForOthers );
	}





	@Test(priority =39  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkTaskMenuEnabled"} )
	public void checkMyOrgsTask() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkMyOrgsTaskPage();
		Assert.assertEquals(title , PageLoadingStaticData.myOrgsTasks );
	}





	@Test(priority =40  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkTaskMenuEnabled"} )
	public void checkallEmployeeTasks() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkallEmployeeTasksPage();
		Assert.assertEquals(title , PageLoadingStaticData.allEmployeeTasks );
	}





	/*
	 *
	 * ************************************* CFRs Page Test case's **************************************
	 *
	 */


	@Test(priority =41  , alwaysRun = true , dependsOnMethods = { "doLogin"  } )
	public void checkCfrsMenuEnabled() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).enableCfrMenu();
		Assert.assertEquals(title , PageLoadingStaticData.cfrsMainTitle );
	}



	@Test(priority =42  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkCfrsMenuEnabled"  } )
	public void checkCfrsMeetings() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkCfrsMeetingsPage();
		Assert.assertEquals(title , PageLoadingStaticData.cfrsMeetings );
	}






	@Test(priority =43  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkCfrsMenuEnabled" } )
	public void checkCfrsLeaderBoard() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkCfrsLeaderBoardPage();
		Assert.assertEquals(title , PageLoadingStaticData.leaderBoard );
	}





	@Test(priority =44  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkCfrsMenuEnabled" } )
	public void checkMyAwardsReceived() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkMyAwardsReceivedPage();
		Assert.assertEquals(title , PageLoadingStaticData.myAwardsReceived );
	}





	@Test(priority =45  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkCfrsMenuEnabled" } )
	public void MyAwardsGiven() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkMyAwardsGivenPage();
		Assert.assertEquals(title , PageLoadingStaticData.myAwardsGiven );
	}






	@Test(priority =46  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkCfrsMenuEnabled" } )
	public void checkMyOrgsAwardsReceived() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkMyOrgAwardsReceivedPage();
		Assert.assertEquals(title , PageLoadingStaticData.myOrganizationReceived );
	}





	@Test(priority =47  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkCfrsMenuEnabled" } )
	public void checkMyOrgAwardsGiven() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkMyOrgAwardsGivenPage();
		Assert.assertEquals(title , PageLoadingStaticData.myOrganizationGiven );
	}








	/*
	 * *********************************  Setting Page Loading Test case's  ********************************************
	 */



	@Test(priority =48  , alwaysRun = true  )
	public void checkSettingMenuEnabled() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).enableSettingMenu();
		Assert.assertEquals(title , PageLoadingStaticData.settingMainTitle );
	}






	@Test(priority =49  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkbusinessInformation() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkBusinessInformationPage();
		Assert.assertEquals(title , PageLoadingStaticData.businessInformation );
	}





	@Test(priority =50  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkActionCenterSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkActionCenterPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.actionCenter );
	}





	@Test(priority =51  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkGradesSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkGradesPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.grades );
	}





	@Test(priority =52  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkHashtaggedConversationSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkHashtaggedConversationsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.hashtaggedConversations );
	}





	@Test(priority =53  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkModulesSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkModulesPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.modules );
	}





	@Test(priority =54  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkDocumentsPageSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkDocumentsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.documents );
	}





	@Test(priority =55  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkSystemEmailsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkSystemEmailsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.systemEmails );
	}




	/*
	 * ************************************* Setting  strategies Test Case's ***********************************************
	 */





	@Test(priority =56  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkDirectivesSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkDirectivesPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.directives );
	}





	@Test(priority =57  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkFocusAreaSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkFocusAreaPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.focusAreas );
	}





	@Test(priority =58  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkInitiativesSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkInitiativesPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.initiatives );
	}





	@Test(priority =59  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkMeasurementsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkMeasurementsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.measurements );
	}





	@Test(priority =60  , alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkPrioritiesSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkPrioritiesPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.strategyPriorities );
	}





	@Test(priority =61, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkReportsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkReportsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.reports );
	}




	 /*
	  * ************************************* Setting  OKR Test case's  ***********************************************
	  */





	@Test(priority =62, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkAlignmentsDependenciesSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkAlignmentsDependenciesPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.alignmentsAndDependencies );
	}




	@Test(priority =63, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkBaselineSequenceSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkBaselineSequencePageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.baselineSequence );
	}





	@Test(priority =64, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkControlsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkControlsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.controls );
	}





	@Test(priority =65, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkFrequenciesSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkFrequenciesPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.frequencies );
	}





	@Test(priority =66, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkDashboardAndFiltersSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkDashboardAndFiltersPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.dashboardAndFilters );
	}





	@Test(priority =67, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkKeyResultTypesSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkKeyResultTypesPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.keyResultTypes );
	}





	/*
	 * *********************************** Setting page OKRS test Case's ************************************************
	 */




	@Test(priority =68, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkKpisCategoriesSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkKpisCategoriesPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.kpisCategories );
	}




	@Test(priority =69, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkKpisByCategorySetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkKpisByCategoryPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.kpisByCategory );
	}




	@Test(priority =70, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkKpiBoardsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkKpiBoardsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.kpiBoards );
	}





	@Test(priority =71, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkOkrsMasterLayoutSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkOkrsMasterLayoutPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.masterLayoutObjectives );
	}




	@Test(priority =72, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkOkrsKeyResultsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkOkrsKeyResultsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.masterLayoutKeyResults );
	}





	@Test(priority =73, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkOkrsMilestoneSequenceSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkOkrsMilestoneSequencePageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.milestoneSequence );
	}





	@Test(priority =74, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkOKRAuthoringSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkOKRAuthoringPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.OkrAuthoring );
	}





	@Test(priority =75, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkOKRLevelsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkOKRLevelsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.OkrLevels );
	}





	@Test(priority =76, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkOKRListViewSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkOKRListViewPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.OkrListView );
	}




	@Test(priority =77, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkOKRRankingSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkOKRRankingPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.OkrRanking );
	}





	@Test(priority =78, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkOkrsPeriodsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkOkrsPeriodsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.periods );
	}




	@Test(priority =79, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkReflectResetSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkReflectResetPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.reflectReset );
	}





	@Test(priority =80, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkOkrsReviewsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkOkrsReviewsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.OkrsReviews );
	}






	@Test(priority =81, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkOkrsStatusesSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkOkrsStatusesPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.okrStatuses );
	}





	@Test(priority =82, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkOkrsTagsVerifySetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkOkrsTagsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.tags );
	}





	@Test(priority =83, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkOkrsTemplatesSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkOkrsTemplatesPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.templates );
	}






	@Test(priority =84, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkOkrsVisibilitySetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkOkrsVisibilityPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.visibility );
	}






	/*
	 * ****************************** Task Managements Test case's  ************************************************
	 */





	@Test(priority =85, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkTaskPrioritySetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkTaskPriorityPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.priorities );
	}





	@Test(priority =86, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkTaskSecuritySetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkTaskSecurityPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.taskSecurity );
	}





	@Test(priority =87, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkTaskStatusesSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkTaskStatusesPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.taskStatuses );
	}





	@Test(priority =88, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkTaskMasterLayoutSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkTaskMasterLayoutPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.taskmasterLayoutTasks );
	}






	/*
	 *************************************** Meeting Setting page functions ********************************************
	 */

	@Test(priority =89, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkMeetingsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkMeetingsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.meetings );
	}






	@Test(priority =90, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkSecuritySetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkSecurityPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.security );
	}




	 /*
	  * ************************************** CFR's Pulse Survey Setting functions **********************************************
	  */




	@Test(priority =91, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkCfrPulseSurveySetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkCfrPulseSurveyPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.pulseSurveys );
	}




	/*
	  * **************************************  User Management Setting functions **********************************************
	  */




	@Test(priority =92, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkActiveUserSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkActiveUserPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.activeUsers );
	}





	@Test(priority =93, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkDepartmentsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkDepartmentsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.Departments );
	}





	@Test(priority =94, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkJobTitlesSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkJobTitlesPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.jobTitles );
	}





	@Test(priority =95, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkNumberGenerationSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkNumberGenerationPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.numberGeneration );
	}





	@Test(priority =96, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkTerminatedUsersSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkTerminatedUsersPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.terminatedUsers );
	}





	@Test(priority =97, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkUserRolesSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkUserRolesPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.userRoles );
	}




	/*
	 ****************************************** Security Setting Test Case's  *********************************************
	 */


	@Test(priority =98, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkAPIAccessSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkAPIAccessPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.apiAccess );
	}




	@Test(priority =99, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkUserAccessSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkUserAccessPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.userAccess );
	}

	/*
	  ***************** Normal Setting have to move this to the top of the page Test Cases  **************************************
	  */





	@Test(priority =100, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkTvAndDevicesSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkTvAndDevicesPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.registeredTVDevices );
	}




	@Test(priority =101, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkLocalizationSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkLocalizationPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.localization );
	}




	@Test(priority =102, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkTeamsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkTeamsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.teams );
	}





	/*
	  *  ****************************************** Integeration Page Test Case's *********************************************
	  */



	@Test(priority =103, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkConnectorsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkConnectorsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.integrations );
	}





	@Test(priority =104, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkDomainsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkDomainsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.authorizedDomains );
	}





	@Test(priority =105, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkGoogleWorkspaceSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkGoogleWorkspacePageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.googleUsersInGSuite );
	}




	@Test(priority =87, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkSamlSSOSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkSamlSSOPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.sAMLSSO );
	}





	@Test(priority =87, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkUserLevelConnectorsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkUserLevelConnectorsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.userLevelConnectors );
	}




	 /*
	  *  ****************************************** Trigger Page Test Case's *********************************************
	  */





	@Test(priority =87, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkObjectivesSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkObjectivesPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.triggersOKR );
	}





	@Test(priority =87, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkTriggerKeyResultsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkTriggerKeyResultsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.triggersKR );
	}





	@Test(priority =87, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkCheckInsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkCheckInsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.triggersCheckins );
	}





	 /*
	  *  ****************************************** Newsfeed Page Test Case's *********************************************
	  */






	@Test(priority =87, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkCannedMessagesSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkCannedMessagesPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.newsFeedCannedMessages );
	}





	@Test(priority =87, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkNewsFeedEventsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkNewsFeedEventsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.events );
	}




	@Test(priority =87, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkPredefinedFiltersSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkPredefinedFiltersPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.predefinedFilters );
	}





	 /*
	  ***************** Normal Setting have to move this to the top of the page **************************************
	  */





	@Test(priority =87, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkBillingSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkBillingPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.billing );
	}




	@Test(priority =87, alwaysRun = true , dependsOnMethods = { "doLogin" , "checkSettingMenuEnabled" } )
	public void checkDeleteAccountSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkDeleteAccountPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.deleteFirmConfirmation );
	}






	/*
	 *  ****************************************** Preference Page Test case's *********************************************
	 */




	@Test(priority =87, alwaysRun = true , dependsOnMethods = { "doLogin"  } )
	public void enablePreferenceMenu() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).enablePreferenceMenu();
		Assert.assertEquals(title , PageLoadingStaticData.preferenceMainTitle );
	}




	@Test(priority =87, alwaysRun = true , dependsOnMethods = { "doLogin" , "enablePreferenceMenu" } )
	public void checkPreferenceGeneralSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkPreferenceGeneralPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.general );
	}




	@Test(priority =87, alwaysRun = true , dependsOnMethods = { "doLogin" , "enablePreferenceMenu" } )
	public void checkPreferenceAppearanceSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkPreferenceAppearancePageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.appearance );
	}




	@Test(priority =87, alwaysRun = true , dependsOnMethods = { "doLogin" , "enablePreferenceMenu" } )
	public void checkPreferenceActionCenterSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkPreferenceActionCenterPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.actionCenterSetting );
	}




	@Test(priority =87, alwaysRun = true , dependsOnMethods = { "doLogin" , "enablePreferenceMenu" } )
	public void checkPreferencePasswordSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkPreferencePasswordPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.changePassword );
	}




	@Test(priority =87, alwaysRun = true , dependsOnMethods = { "doLogin" , "enablePreferenceMenu" } )
	public void checkPreferenceCannedMessagesSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkPreferenceCannedMessagesPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.cfrCannedMessages );
	}




	@Test(priority =87, alwaysRun = true , dependsOnMethods = { "doLogin" , "enablePreferenceMenu" } )
	public void checkPreferenceEventsSetting() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InterruptedException, IOException
	{
		String title =page.getInstance(PageMenus.class).checkPreferenceEventsPageSetting();
		Assert.assertEquals(title , PageLoadingStaticData.eventsSetting );
	}





}

