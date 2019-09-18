package com.mobileautomation.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.webautomation.testdata.factory.MenuFactory;
import com.webautomation.testdata.menu.Menu;
import com.webautomation.testdata.menu.module1AppMenu;

import Base.BaseSteps_android;

public class SMB_ProfileSettingsSuite extends BaseSteps_android {

	/**
	 * Constructor
	 */

	String winHandleBefore = null;

	boolean elementIsClickable = false;

	private String userStoryDescription;
	private String successMsgDesc = "";
	private String failMsgDesc = "";

	

	
	@Test
	public void smb_SetStartPage() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.SMB_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : SetStartPage", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {
			userStoryDescription = "OfficeSuiteUC -  SetStartPage";
			vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "Profile -  SetStartPage");

			weConnect_ProfileSettingsPage.setStartPage("OfficeSuteUC");

			successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
			vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
		}
		Reporter.log(testMethodName + " ==> " + "Test case passed", true);
	}
	
	@Test
	public void smb_SetShortcutToContact() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.Automation);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : OfficeSuiteSettings - Shortcut to Contact book", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {
			userStoryDescription = "OfficeSuiteSettings - Shortcut to Contact book";
			vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "OfficeSuiteSettings - Shortcut to Contact book");

			weConnect_ProfileSettingsPage.setShortcutToContactBook(weConnect_ProfileSettingsPage.coworkersTab,"Coworkers");

			successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
			vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
		}
		Reporter.log(testMethodName + " ==> " + "Test case passed", true);
	}
	
	@Test
	public void smb_ProfileSettings() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.Automation);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : OfficeSuiteSettings - SetPresenceStatus and CustomStatus", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {
			userStoryDescription = "OfficeSuiteSettings - SetPresenceStatus and CustomStatus";
			vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "OfficeSuiteSettings - SetPresenceStatus and CustomStatus");

			weConnect_ProfileSettingsPage.changePresenceStatus(weConnect_ProfileSettingsPage.availableStatus, "Available");
			weConnect_ProfileSettingsPage.setNewCustomStatus("Automation");
			
			successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
			vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
		}
		Reporter.log(testMethodName + " ==> " + "Test case passed", true);
	}
	
}
