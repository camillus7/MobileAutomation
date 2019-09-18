package com.mobileautomation.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mobile.MyWin.pageobject.MyWinMobile_LoginPage;
import com.mobile.MyWin.pageobject.MyWinMobile_MorePage;
import com.webautomation.testdata.factory.MenuFactory;
import com.webautomation.testdata.menu.Menu;
import com.webautomation.testdata.menu.module1AppMenu;

import Base.BaseSteps_android;
import Base.testCaseNames;

public class MyWin_LoginSuite extends BaseSteps_android {

	/**
	 * Constructor
	 */

	String winHandleBefore = null;

	boolean elementIsClickable = false;

	private String userStoryDescription;
	private String successMsgDesc = "";
	private String failMsgDesc = "";

	@Test
	public void myWin_LoginScreenVerifications() throws Throwable {
	
	//	Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerOffers);
	//	myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story :LoginScreen-InvalidLogin_ForgotPassword_ForgotUsername TestCases", true);
		successMsgDesc = "";
		failMsgDesc = "";
		

		try {

			try {
				userStoryDescription = "Login - InvalidLogin-ForgotPassword-ForgotUsername";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "Login - InvalidLogin-ForgotPassword-ForgotUsername");

			//	myWinMobile_LoginPage.verifyInvalidLogin();
				myWinMobile_LoginPage.verifyForgotPasswordScreen();
				myWinMobile_LoginPage.verifyForgotUsernameScreen();
				myWinMobile_LoginPage.registrationScreenUI();
				myWinMobile_LoginPage.registrationValid();
				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = vc.getWebDriverUtils().logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}

			
		} catch (Throwable e) {
			vc.getWebDriverUtils().displayExecutionResults(successMsgDesc, failMsgDesc);
		}
		vc.getWebDriverUtils().displayExecutionResults(successMsgDesc, failMsgDesc);
	}
	
	@Test
	public void myWin_Appversion() throws Throwable {
	
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerOffers);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story :Verify App version TestCases", true);
		successMsgDesc = "";
		failMsgDesc = "";
		

		try {

			try {
				userStoryDescription = "App Version";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "App Version");
				
				MyWinMobile_MorePage.versionNavigation();
				
				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = vc.getWebDriverUtils().logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}

			
		} catch (Throwable e) {
			vc.getWebDriverUtils().displayExecutionResults(successMsgDesc, failMsgDesc);
		}
		vc.getWebDriverUtils().displayExecutionResults(successMsgDesc, failMsgDesc);
	}
	
	
	
	

}
