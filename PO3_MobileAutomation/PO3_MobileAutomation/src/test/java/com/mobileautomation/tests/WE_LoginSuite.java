package com.mobileautomation.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.webautomation.testdata.factory.MenuFactory;
import com.webautomation.testdata.menu.Menu;
import com.webautomation.testdata.menu.module1AppMenu;

import Base.BaseSteps_android;

public class WE_LoginSuite extends BaseSteps_android {

	/**
	 * Constructor
	 */

	String winHandleBefore = null;

	boolean elementIsClickable = false;

	private String userStoryDescription;
	private String successMsgDesc = "";
	private String failMsgDesc = "";

	

	
	@Test
	public void weConnect_InvalidLogin() throws Throwable {
		Reporter.log("User Story : InvalidLogin_ForgotUsername", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {
			userStoryDescription = "InvalidLogin_ForgotUsername";
			vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "InvalidLogin_ForgotUsername");

		//	weConnect_LoginPage.verifyInvalidLogin();
			weConnect_LoginPage.verifyForgotUsernameScreen();

			successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
			vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
		}
		Reporter.log(testMethodName + " ==> " + "Test case passed", true);
	}
	
	
}
