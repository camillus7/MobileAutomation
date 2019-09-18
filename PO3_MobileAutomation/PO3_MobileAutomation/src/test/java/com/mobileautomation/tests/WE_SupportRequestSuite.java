package com.mobileautomation.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.webautomation.testdata.factory.MenuFactory;
import com.webautomation.testdata.menu.Menu;
import com.webautomation.testdata.menu.module1AppMenu;

import Base.BaseSteps_android;

public class WE_SupportRequestSuite extends BaseSteps_android {

	/**
	 * Constructor
	 */

	String winHandleBefore = null;

	boolean elementIsClickable = false;

	private String userStoryDescription;
	private String successMsgDesc = "";
	private String failMsgDesc = "";

	@Test
	public void weConnect_CreateSupportRequest() throws Throwable {

		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.BVN_User2);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : Create-New SupportRequest", true);
		successMsgDesc = "";
		failMsgDesc = "";

		

			try {
				userStoryDescription = "Create-New SupportRequest";
	
				weConnect_SupportRequestPage.navigatetoCreateNewSupportRequest(userStoryDescription);
				
			//	weConnect_SupportRequestPage.updateSupportRequest();
				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
				vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
			}
			Reporter.log(testMethodName + " ==> " + "Test case passed", true);
		
	}

	
	
}
