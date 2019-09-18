package com.mobileautomation.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.webautomation.testdata.factory.MenuFactory;
import com.webautomation.testdata.menu.Menu;
import com.webautomation.testdata.menu.module1AppMenu;

import Base.BaseSteps_android;

public class WE_OfficeSuiteUC extends BaseSteps_android {

	/**
	 * Constructor
	 */

	String winHandleBefore = null;

	boolean elementIsClickable = false;

	private String userStoryDescription;
	private String successMsgDesc = "";
	private String failMsgDesc = "";

	

	@Test
	public void weConnect_ContactAddFavorite() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.BVN_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : AddFavorite", true);
		successMsgDesc = "";
		failMsgDesc = "";

	

		try {
			userStoryDescription = "OfficeSuiteUC -  AddFavorite";
			vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "OfficeSuiteUC -  AddFavorite");

			weConnect_OfficeSuite.addFavorite_Contact();

			successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
			vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
		}
		Reporter.log(testMethodName + " ==> " + "Test case passed", true);
	}
	
	@Test
	public void weConnect_GroupsAddFavorite() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.BVN_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : AddGroups as Favorite", true);
		successMsgDesc = "";
		failMsgDesc = "";

	

		try {
			userStoryDescription = "OfficeSuiteUC -  AddGroups as Favorite";
			vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "OfficeSuiteUC -  AddGroups as Favorite");

			weConnect_OfficeSuite.addFavorite_Groups();

			successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
			vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
		}
		Reporter.log(testMethodName + " ==> " + "Test case passed", true);
	}
	
	@Test
	public void weConnect_TabsFunctionality() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.BVN_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story :OfficeSuiteUC - Voicemail_Calls Functionality", true);
		successMsgDesc = "";
		failMsgDesc = "";

	

		try {
			userStoryDescription = "OfficeSuiteUC -  OfficeSuiteUC - Voicemail_Calls Functionality";
			vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "OfficeSuiteUC - Voicemail_Calls Functionality");

			weConnect_OfficeSuite.voicemailFunctionality();
			weConnect_OfficeSuite.callsFunctionality();
			weConnect_OfficeSuite.chatFunctionality("Testing-PleaseIgnore");
			
			

			successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
			vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
		}
		Reporter.log(testMethodName + " ==> " + "Test case passed", true);
	}
	
	
	@Test
	public void weConnect_SearchCoworkers() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.BVN_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : OfficeSuite - SearchCoworkers", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {
			userStoryDescription = "OfficeSuite - SearchCoworkers";
			vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "OfficeSuite - SearchCoworkers");

			
			weConnect_OfficeSuite.searchCoworkers();

			successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
			vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
		}
		Reporter.log(testMethodName + " ==> " + "Test case passed", true);
	}
	
	@Test
	public void weConnect_getMenuList() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.BVN_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : LandingScreenMenus and OtherScreenUI Check", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {
			userStoryDescription = "LandingScreenMenus and OtherScreenUI Check";
			vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, " LandingScreenMenus and OtherScreenUI Check");

			weConnect_Landingscreen.getLandingScreenMenus();
			weConnect_Landingscreen.getHamburgerMenus();
			weConnect_OfficeSuite.uiCheck();
			
			
		
			successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
			vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
		}
		Reporter.log(testMethodName + " ==> " + "Test case passed", true);
	}
	
	
	
	@Test
	public void weConnect_CreateandDeleteGroup() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.BVN_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : CreateNewGroup", true);
		successMsgDesc = "";
		failMsgDesc = "";
		String groupName = "automation";
		String editedGroupName = "automationedit";

	

		try {
			userStoryDescription = "OfficeSuiteUC -  CreateNewGroup";
			vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "OfficeSuiteUC -  CreateNewGroup");
				
			weConnect_OfficeSuite.createGroup(groupName,editedGroupName);
			
			
			successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
			vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
		}
		Reporter.log(testMethodName + " ==> " + "Test case passed", true);
	}
	
	@Test
	public void weConnect_Orders() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.BVN_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : AddFavorite", true);
		successMsgDesc = "";
		failMsgDesc = "";

			try {
				userStoryDescription = "OrdersUI - View all orders";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "OrdersUI - View all orders");
			
				weConnect_OrdersPage.getOrderDetails();
				
				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
				vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
			}
			Reporter.log(testMethodName + " ==> " + "Test case passed", true);
		}
	
}
