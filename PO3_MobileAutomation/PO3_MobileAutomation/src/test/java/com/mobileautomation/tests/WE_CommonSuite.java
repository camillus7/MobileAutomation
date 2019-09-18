package com.mobileautomation.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.webautomation.testdata.factory.MenuFactory;
import com.webautomation.testdata.menu.Menu;
import com.webautomation.testdata.menu.module1AppMenu;

import Base.BaseSteps_android;

public class WE_CommonSuite extends BaseSteps_android {

	/**
	 * Constructor
	 */

	String winHandleBefore = null;

	boolean elementIsClickable = false;

	private String userStoryDescription;
	private String successMsgDesc = "";
	private String failMsgDesc = "";

	@Test
	public void weConnect_GenericFunctionality() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.BVN_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : Generic TestCases", true);
		successMsgDesc = "";
		failMsgDesc = "";

	

		try {
			userStoryDescription = "OfficeSuiteUC -  Generic TestCases";
			vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "Generic TestCases");

			weConnect_Landingscreen.getAppVersion();
			weConnect_Landingscreen.appFeedBack();
			
			successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
			vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
		}
		Reporter.log(testMethodName + " ==> " + "Test case passed", true);
	}
	
	@Test
	public void weConnect_NetworkStatus() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.BVN_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : NetworkStatus", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {
			userStoryDescription = "NetworkStatus";
			vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "NetworkStatus");

			weConnect_Landingscreen.networkStatus();
			
			successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
			vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
		}
		Reporter.log(testMethodName + " ==> " + "Test case passed", true);
	}
	
	@Test
	public void we_Notification() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.BVN_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : NotificationSubscription", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {
			userStoryDescription = "NotificationSubscription";
			vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "NotificationSubscription");

			weConnect_Landingscreen.notifications("We","Last");
			
			successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
			vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
		}
		Reporter.log(testMethodName + " ==> " + "Test case passed", true);
	}
	
	@Test
	public void we_CompanyContacts() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.BVN_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : NotificationSubscription", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {
			userStoryDescription = "CompanyContacts";
			vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "CompanyContacts");

			weConnect_Landingscreen.companyContacts("We","Last");
			
			successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
			vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
		}
		Reporter.log(testMethodName + " ==> " + "Test case passed", true);
	}
	
	
}
