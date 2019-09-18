package com.mobileautomation.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mobile.MyWin.pageobject.MyWinMobile_BillingPage;
import com.mobile.MyWin.pageobject.MyWinMobile_LandingPage;
import com.mobile.MyWin.pageobject.MyWinMobile_MorePage;
import com.mobile.MyWin.pageobject.MyWinMobile_SupportRequestPage;
import com.webautomation.testdata.factory.MenuFactory;
import com.webautomation.testdata.menu.Menu;
import com.webautomation.testdata.menu.module1AppMenu;

import Base.BaseSteps_android;

public class MyWin_OnScreenBoardingSuite extends BaseSteps_android {

	/**
	 * Constructor
	 */

	String winHandleBefore = null;

	boolean elementIsClickable = false;

	private String userStoryDescription;
	private String successMsgDesc = "";
	private String failMsgDesc = "";

	@Test
	public void myWin_OnScreenBoarding() throws Throwable {

		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerMobileTestCases);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : On-Screen Boarding TestCases", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {

			try {
				userStoryDescription = "More- UI Check";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "More- UI Check");

				myWinMobile_MorePage.moreScreenUI();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = vc.getWebDriverUtils().logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}

			try {
				userStoryDescription = "More- Email Page Navigation";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "More- Email Page Navigation");

				myWinMobile_MorePage.emailNavigation();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = vc.getWebDriverUtils().logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}

			
			try {
				userStoryDescription = "More- Schedule Page Navigation";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "More- Schedule Page Navigation");

				myWinMobile_MorePage.watchTvNavigation();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = vc.getWebDriverUtils().logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}

			try {
				userStoryDescription = "More- ReferFriends Page Navigation";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "More- ReferFriends Page Navigation");

				myWinMobile_MorePage.referFriendsNavigation();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = vc.getWebDriverUtils().logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}

			
			try {
				userStoryDescription = "More- News Page Navigation";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "More- News Page Navigation");

				myWinMobile_MorePage.newsNavigation();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = vc.getWebDriverUtils().logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}

		/*	try {
				userStoryDescription = "More - Network Support Center Navigation";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "Network Support Center Navigation");

				myWinMobile_MorePage.networkSupportCenterNavigation();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = vc.getWebDriverUtils().logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}*/

			try {
				userStoryDescription = "More - Get Speedtest Report";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "More -Get Speedtest Report");

				myWinMobile_MorePage.getSpeedTestReport();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = vc.getWebDriverUtils().logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}

			try {
				userStoryDescription = "More-About- UI Check";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "More-About- UI Check");

				myWinMobile_MorePage.aboutUI();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = vc.getWebDriverUtils().logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}

			
			
			
			
			
			try {
				userStoryDescription = "More-About - Windstream Blog Navigation";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "More-About - Windstream Blog Navigation");

				myWinMobile_MorePage.windstreamBlog();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = vc.getWebDriverUtils().logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}
			
			try {
				userStoryDescription = "More-About - AppFeedback Navigation";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "More-About - AppFeedback Navigation");

				myWinMobile_MorePage.appFeedBack();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = vc.getWebDriverUtils().logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}
			
			try {
				userStoryDescription = "More-About-PrivacyPolicy Navigation";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "More-About-PrivacyPolicy Naviagation");

				myWinMobile_MorePage.privacyPolicyNavigation();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = vc.getWebDriverUtils().logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}

			try {
				userStoryDescription = "More-About-Terms&Conditions Navigation";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription,
						"More-About-Terms&Conditions Naviagation");

				myWinMobile_MorePage.termsandConditionsNavigation();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = vc.getWebDriverUtils().logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}

			/*try {
				userStoryDescription = "More-About-SoftwareLicences Navigation";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription,
						"More-About-SoftwareLicences Naviagation");

				myWinMobile_MorePage.softwareLicencesNavigation();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = vc.getWebDriverUtils().logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}
			*/
			try {
				userStoryDescription = "More-About - WelcomeTour Navigation";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "More-About - WelcomeTour Navigation");

				myWinMobile_MorePage.welcomeTour();

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
	public void myWin_SetStartPage_Billing() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerOffers);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : More-Settings - SetStartPage", true);
		successMsgDesc = "";
		failMsgDesc = "";

		

			try {
				userStoryDescription = "More-Settings - SetBilling as StartPage ";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription,
						"More-Settings - SetBilling as StartPage");

				myWinMobile_MorePage.setStartPage(MyWinMobile_LandingPage.Billingicon,
						MyWinMobile_BillingPage.CurrentBill,"Billing");

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
				vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
			}
			Reporter.log(testMethodName + " ==> " + "Test case passed", true);
		}

	@Test
	public void myWin_SetStartPage_Support() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerMobileTestCases);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);

		Reporter.log("User Story : More-Settings - SetStartPage", true);
		successMsgDesc = "";
		failMsgDesc = "";

		

			try {
				userStoryDescription = "More-Settings - SetSupport as StartPage ";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription,
						"More-Settings - SetSupport as StartPage");

				myWinMobile_MorePage.setStartPage(MyWinMobile_LandingPage.Supporticon,
						MyWinMobile_SupportRequestPage.viewSupportRequest,"Support");

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
				vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
			}
			Reporter.log(testMethodName + " ==> " + "Test case passed", true);
		}
	@Test
	public void myWin_SetStartPage_News() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerMobileTestCases);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : More-Settings - SetStartPage", true);
		successMsgDesc = "";
		failMsgDesc = "";

		
			try {
				userStoryDescription = "More-Settings - SetNews as StartPage ";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription,
						"More-Settings - SetNews as StartPage");

				myWinMobile_MorePage.setStartPage(MyWinMobile_MorePage.newsLink,
						MyWinMobile_MorePage.newsNavigation,"News");
				driver.navigate().back();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			}catch (Throwable e) {
				e.printStackTrace();
				Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
				vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
			}
			Reporter.log(testMethodName + " ==> " + "Test case passed", true);
		}
	
	@Test
	public void myWin_SetStartPage_Email() throws Throwable {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerMobileTestCases);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);
		Reporter.log("User Story : More-Settings - SetStartPage", true);
		successMsgDesc = "";
		failMsgDesc = "";

		

			try {
				userStoryDescription = "More-Settings - SetEmail as StartPage ";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription,
						"More-Settings - SetEmail as StartPage");

				myWinMobile_MorePage.setStartPage(MyWinMobile_MorePage.emailLink,
						MyWinMobile_MorePage.emailPageNavigation,"Email");
				driver.navigate().back();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
				vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
			}
			Reporter.log(testMethodName + " ==> " + "Test case passed", true);
		}
	
	@Test
	public void myWin_ViewSupportTickets() throws Throwable {
		
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerOffers);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);

		Reporter.log("User Story : Support - UI & View Support Tickets", true);
		successMsgDesc = "";
		failMsgDesc = "";

		try {

			try {
				userStoryDescription = "Support - SupportScreen UI ";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "Support - SupportScreen UI");

				myWinMobile_SupportRequestPage.supportUI();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				failMsgDesc = vc.getWebDriverUtils().logUserStoryEndFail(userStoryDescription, failMsgDesc);
			}

			try {
				userStoryDescription = "Support - View all/open/Closed Tickets ";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "Support - View Support Tickets");

				myWinMobile_SupportRequestPage.viewSupportRequests(myWinMobile_SupportRequestPage.allTickets);
				myWinMobile_SupportRequestPage.viewSupportRequests(myWinMobile_SupportRequestPage.openTickets);
				myWinMobile_SupportRequestPage.viewSupportRequests(myWinMobile_SupportRequestPage.closedTickets);

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
	public void myWin_CarouselsNavigation() throws Throwable {
		
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerMobileTestCases);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);

		Reporter.log("User Story : LandingScreen - Carousel Navigation", true);
		successMsgDesc = "";
		failMsgDesc = "";

	
			try {
				userStoryDescription = "LandingScreen - Carousel Navigation ";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "LandingScreen - Carousel Navigation");

				myWinMobile_LandingPage.posterFunctionality();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
				vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
			}
			Reporter.log(testMethodName + " ==> " + "Test case passed", true);
		}
	
	@Test
	public void myWin_PaperlessBilling() throws Throwable {
		
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerMobileTestCases);
		myWinMobile_LoginPage.navigateTo_MywinHome(menu);

		Reporter.log("User Story : Billing - PaperlessBilling", true);
		successMsgDesc = "";
		failMsgDesc = "";

		

			try {
				userStoryDescription = "Billing - PaperlessBilling ";
				vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "Billing - PaperlessBilling");

				myWinMobile_BillingPage.paperlessBilling();

				successMsgDesc = vc.getWebDriverUtils().logUserStoryEndSuccess(userStoryDescription, successMsgDesc);
			} catch (Throwable e) {
				e.printStackTrace();
				Reporter.log(testMethodName + " ==> " + "Test case Failed", true);
				vc.getWebDriverUtils().takeScreenshot(testMethodName + "_error");
			}
			Reporter.log(testMethodName + " ==> " + "Test case passed", true);
		}


}
