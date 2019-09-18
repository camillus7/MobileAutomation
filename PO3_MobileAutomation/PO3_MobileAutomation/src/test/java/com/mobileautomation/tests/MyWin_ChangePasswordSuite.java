package com.mobileautomation.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mobile.MyWin.pageobject.MyWinMobile_ChangePasswordPage;
import com.mobile.MyWin.pageobject.MyWinMobile_LoginPage;
import com.mobile.MyWin.pageobject.MyWinMobile_MorePage;
import com.webautomation.testdata.factory.MenuFactory;
import com.webautomation.testdata.menu.Menu;
import com.webautomation.testdata.menu.module1AppMenu;

import Base.BaseSteps_android;
import Base.testCaseNames;

public class MyWin_ChangePasswordSuite extends BaseSteps_android {

	/**
	 * Constructor
	 */

	String winHandleBefore = null;

	boolean elementIsClickable = false;

	private String userStoryDescription;
	private String successMsgDesc = "";
	private String failMsgDesc = "";

	@Test
	public void myWin_ChangePassword_InValid() throws Throwable {
		
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerMobileTestCases);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);

		Reporter.log("User Story : More-Settings - ChangePassword", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {

			try {
				userStoryDescription = "More-Settings - ChangePassword UI";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "More-Settings - ChangePassword UI");

				myWinMobile_ChangePasswordPage.changePasswordUI();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = vc.getWebDriverUtils().logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}

			try {
				userStoryDescription = "More-Settings - ChangePassword Mismatch";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription,
						"More-Settings - ChangePassword Mismatch");

				myWinMobile_ChangePasswordPage.passwordMismatch("ahil", "Google@99", "test", "test1");

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = vc.getWebDriverUtils().logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}

			try {
				userStoryDescription = "More-Settings - ChangePassword Blank";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription,
						"More-Settings - ChangePassword With Empty Fields");

				myWinMobile_ChangePasswordPage.changePasswordInvalid("test");

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
	public void myWin_ChangePassword_Valid() throws Throwable {
		
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerMobileTestCases);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);

		Reporter.log("User Story : More-Settings - ChangePassword", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {

			try {
				userStoryDescription = "More-Settings - ChangePassword Valid";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "More-Settings - ChangePassword Valid");

				myWinMobile_ChangePasswordPage.changePasswordvalid("Ahil", "Google@99", "Google@999", "Google@999");

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
