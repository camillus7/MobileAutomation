package com.mobileautomation.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.webautomation.testdata.factory.MenuFactory;
import com.webautomation.testdata.menu.Menu;
import com.webautomation.testdata.menu.module1AppMenu;

import Base.BaseSteps_android;

public class MyWin_PaymentsSuite extends BaseSteps_android {

	/**
	 * Constructor
	 */

	String winHandleBefore = null;

	boolean elementIsClickable = false;

	private String userStoryDescription;
	private String successMsgDesc = "";
	private String failMsgDesc = "";
	
	@Test
	public void myWin_VerifyDueAmount() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerOffers);
		myWinMobile_LoginPage.navigateTo_MywinHome2(menu);
		Reporter.log("User Story : VerifyDueAmount is same in Landing and Billing Screen", true);
		successMsgDesc = "";
		failMsgDesc = "";

	

			try {
				userStoryDescription = "Billing -  VerifyDueAmount is same in Landing and Billing Screen";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "Billing -  VerifyDueAmount is same in Landing and Billing Screen");

				myWinMobile_LandingPage.getDueAmount();
				
				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
				vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
			}
			Reporter.log(testMethodName + " ==> " + "Test case passed", true);
		}
		
	@Test
	public void myWin_SchedulePayment() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerOffers);
		myWinMobile_LoginPage.navigateTo_MywinHome2(menu);
		Reporter.log("User Story : SchedulePayment", true);
		successMsgDesc = "";
		failMsgDesc = "";

	

			try {
				userStoryDescription = "Billing -  SchedulePayment";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "Billing -  SchedulePayment");

				myWinMobile_BillingPage.schedulePayment();
				
				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
				vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
			}
			Reporter.log(testMethodName + " ==> " + "Test case passed", true);
		}
		

	@Test
	public void myWin_MakePayment() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerOffers);
		myWinMobile_LoginPage.navigateTo_MywinHome2(menu);
		Reporter.log("User Story : Billing-Payments Test Cases", true);
		successMsgDesc = "";
		failMsgDesc = "";

	

			try {
				userStoryDescription = "Billing - View Dueamount and Make Payment";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "Billing - View Dueamount and make Payment");


				myWinMobile_ManagePaymentMethodPage.makePaymentAmount("212213234");
				//4828572866336019,5454545454545454,212213234
				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
				vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
			}
			Reporter.log(testMethodName + " ==> " + "Test case passed", true);
		}
		

	
	@Test
	public void myWin_ViewBillingHistory() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerMobileTestCases);
		myWinMobile_LoginPage.navigateTo_MywinHome2(menu);
		Reporter.log("User Story : Billing-Payments Test Cases", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {

			try {
				userStoryDescription = "Billing - Bills - View Billing History";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "View Billing History");

				//myWinMobile_BillingPage.getAvailableBills("Jul 16, 2018");
				//myWinMobile_BillingPage.downloadBills();
				myWinMobile_BillingPage.availablebills();

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
	public void myWin_EnrollAutoPay() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerOffers);
		myWinMobile_LoginPage.navigateTo_MywinHome2(menu);
		Reporter.log("User Story : AutoPay Test Cases", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {
			
			try {
				userStoryDescription = "ManageAutoPay - Enroll AutoPay UI & Functionality";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "ManageAutoPay - Enroll Autopay");

				myWinMobile_ManageAutoPayPage.enrollAutoPay();

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
	public void myWin_DerollAutoPay() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerOffers);
		myWinMobile_LoginPage.navigateTo_MywinHome2(menu);
		Reporter.log("User Story : AutoPay Test Cases", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {

			try {
				userStoryDescription = "ManageAutoPay - De-Enroll AutoPay";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "ManageAutoPay - De-Enroll Autopay");

				myWinMobile_ManageAutoPayPage.deenrollAutoPay();

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
	public void myWin_SuspendAutoPay() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerOffers);
		myWinMobile_LoginPage.navigateTo_MywinHome2(menu);
		Reporter.log("User Story : AutoPay Test Cases", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {

			try {
				userStoryDescription = "ManageAutoPay - Suspend AutoPay Functionality";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription,
						"ManageAutoPay - Suspend AutoPay Functionality");

				myWinMobile_ManageAutoPayPage.suspendedAutopayStatus();

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
	public void myWin_AddDeleteElectronicCheck() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerOffers);
		myWinMobile_LoginPage.navigateTo_MywinHome2(menu);
		Reporter.log("User Story : Add_Delete-ElectronicCheck", true);
		successMsgDesc = "";
		failMsgDesc = "";

			
			
			try {
				userStoryDescription = "ManagePaymentMethods - Add_Delete Electronic Check Functionality";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "ManagePaymentMethods - AddElectonicCheck Functionality");

				myWinMobile_ManagePaymentMethodPage.addAnddeleteElectonicCheck("212213234");
				

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
				vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
			}
			Reporter.log(testMethodName + " ==> " + "Test case passed", true);
		}
	
	@Test
	public void myWin_AddCredit_DebitCard() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerOffers);
		myWinMobile_LoginPage.navigateTo_MywinHome2(menu);
		Reporter.log("User Story : MyWin_AddCredit_DebitCard", true);
		successMsgDesc = "";
		failMsgDesc = "";

		
			try {
				userStoryDescription = "ManagePaymentMethods - Add Credit/Debit Card";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "ManagePaymentMethods - Add Credit/Debit Card");
		
				myWinMobile_ManagePaymentMethodPage.addCreditCard("4828572866336019");
				
				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			}catch (Throwable e) {
				e.printStackTrace();
				Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
				vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
			}
			Reporter.log(testMethodName + " ==> " + "Test case passed", true);
		}
	
	@Test
	public void myWin_AddDeleteCredit_DebitCard() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerOffers);
		myWinMobile_LoginPage.navigateTo_MywinHome2(menu);
		Reporter.log("User Story : MyWin_AddCredit_DebitCard", true);
		successMsgDesc = "";
		failMsgDesc = "";

		
			try {
				userStoryDescription = "ManagePaymentMethods - Add_Delete Credit/Debit Card";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "ManagePaymentMethods - Add Credit/Debit Card");
		
				myWinMobile_ManagePaymentMethodPage.addDelete_CreditCard("4828572866336019");
				
				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			}catch (Throwable e) {
				e.printStackTrace();
				Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
				vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
			}
			Reporter.log(testMethodName + " ==> " + "Test case passed", true);
		}
	
	
	@Test
	public void myWin_negativeCheck_ElectonicCheck() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerMobileTestCases);
		myWinMobile_LoginPage.navigateTo_MywinHome2(menu);
		Reporter.log("User Story : MyWin_Negative TestCases-Electronic Check", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {
			
			try {
				userStoryDescription = "ManagePaymentMethods - AddElectonicCheck - Invalid";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "ManagePaymentMethods - AddElectonicCheck - Invalid");

				myWinMobile_ManagePaymentMethodPage.addElectronicCheckInvalid("123454");

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
	public void myWin_DeleteAddedCards() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerOffers);
		myWinMobile_LoginPage.navigateTo_MywinHome2(menu);
		Reporter.log("User Story : MyWin_DeleteAddedCards", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {
			
			try {
				userStoryDescription = "ManagePaymentMethods - Delete DeleteAddedCards";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "ManagePaymentMethods - DeleteAddedCards");

				
				myWinMobile_ManagePaymentMethodPage.deleteCards();

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
	