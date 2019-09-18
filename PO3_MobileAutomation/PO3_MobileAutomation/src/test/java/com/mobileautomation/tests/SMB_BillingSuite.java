package com.mobileautomation.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.webautomation.testdata.factory.MenuFactory;
import com.webautomation.testdata.menu.Menu;
import com.webautomation.testdata.menu.module1AppMenu;

import Base.BaseSteps_android;

public class SMB_BillingSuite extends BaseSteps_android {

	/**
	 * Constructor
	 */

	String winHandleBefore = null;

	boolean elementIsClickable = false;

	private String userStoryDescription;
	private String successMsgDesc = "";
	private String failMsgDesc = "";

	
	@Test
	public void smb_VerifyDueAmount() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.SMB_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : VerifyDueAmount is same in Landing and Billing Screen", true);
		successMsgDesc = "";
		failMsgDesc = "";

	

			try {
				userStoryDescription = "Billing -  VerifyDueAmount is same in Landind and Billing";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "Billing -  VerifyDueAmount is same in Landind and Billing");

				weConnect_BillingPage.getDueAmount();
				
				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
				vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
			}
			Reporter.log(testMethodName + " ==> " + "Test case passed", true);
		}
	
	@Test
	public void smb_SchedulePayment() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.SMB_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : SchedulePayment", true);
		successMsgDesc = "";
		failMsgDesc = "";

	

			try {
				userStoryDescription = "Billing -  SchedulePayment";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "Billing -  SchedulePayment");

				weConnect_BillingPage.schedulePayment();
				
				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
				vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
			}
			Reporter.log(testMethodName + " ==> " + "Test case passed", true);
		}
	
	@Test
	public void smb_MakePayment() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.SMB_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : Billing-MakePayment", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {
			userStoryDescription = "Billing-MakePayment";
			vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "Billing-MakePayment");
			
			weConnect_BillingPage.makePaymentAmount("212213234");
			

			successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
			vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
		}
		Reporter.log(testMethodName + " ==> " + "Test case passed", true);
	}
	
	@Test
	public void smb_EnrollAutoPay() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.SMB_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : ManageAutoPay - Enroll AutoPay", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {
			userStoryDescription = "ManageAutoPay - Enroll AutoPay";
			vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "ManageAutoPay - Enroll AutoPay");

			weConnect_BillingPage.enrollAutoPay();

			successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
			vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
		}
		Reporter.log(testMethodName + " ==> " + "Test case passed", true);
	}
	
	@Test
	public void smb_DeenrollAutoPay() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.SMB_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : ManageAutoPay - De-Enroll AutoPay", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {
			userStoryDescription = "ManageAutoPay - De-Enroll AutoPay";
			vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "ManageAutoPay - De-Enroll AutoPay");

			weConnect_BillingPage.deenrollAutoPay();

			successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
			vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
		}
		Reporter.log(testMethodName + " ==> " + "Test case passed", true);
	}
	
	@Test
	public void smb_AddElectronicCheck() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.SMB_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : AddElectronicCheck", true);
		successMsgDesc = "";
		failMsgDesc = "";

			
			
			try {
				userStoryDescription = "ManagePaymentMethods - Add Electonic Check Functionality";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "ManagePaymentMethods - AddElectonicCheck Functionality");

				weConnect_BillingPage.addAnddeleteElectonicCheck("212213234");
				

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
				vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
			}
			Reporter.log(testMethodName + " ==> " + "Test case passed", true);
		}
	
	@Test
	public void smb_AddCredit_DebitCard() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.SMB_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : AddCredit_DebitCard", true);
		successMsgDesc = "";
		failMsgDesc = "";

		
			try {
				userStoryDescription = "ManagePaymentMethods - Add Credit/Debit Card";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "ManagePaymentMethods - Add Credit/Debit Card");
		
				weConnect_BillingPage.addDebit_CreditCard("4828572866336019");
				
				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			}catch (Throwable e) {
				e.printStackTrace();
				Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
				vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
			}
			Reporter.log(testMethodName + " ==> " + "Test case passed", true);
		}
	
	
	@Test
	public void smb_Notification() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.SMB_User);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : NotificationSettings", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {
			userStoryDescription = "NotificationSettings";
			vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "NotificationSettings");

			weConnect_Landingscreen.smb_Notifications("smbtesting@ws.com");
			
			successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
			vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
		}
		Reporter.log(testMethodName + " ==> " + "Test case passed", true);
	}
	
	
}
