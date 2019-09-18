package com.mobile.MyWin.pageobject;

import java.sql.Driver;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.webautomation.testdata.factory.MenuFactory;
import com.webautomation.testdata.menu.Menu;
import com.webautomation.testdata.menu.module1AppMenu;
import com.webautomation.validation.Validator;

import commonUtil.PropertiesUtil;

public class MyWinMobile_MorePage {

	final WebDriver driver;
	private static Validator vc;

	MyWinMobile_LoginPage loginPage;

	public MyWinMobile_MorePage(WebDriver driver) {
		this.driver = driver;
		this.vc = new Validator(driver);
	}

	@FindBy(xpath = "//android.widget.TextView[@text='View Support Tickets']")
	public WebElement viewSupportRequest;

	
	
	
	
	
	@FindBy(id = "name")
	public WebElement userName;

	@FindBy(id = "user_email")
	public WebElement userEmail;

	@FindBy(id="email")
	public static WebElement emailLink;

	@FindBy(id = "tv")
	public WebElement scheduleLink;

	@FindBy(id = "rewards")
	public WebElement referFriendsLink;

	@FindBy(id="news")
	public static WebElement newsLink;

	@FindBy(id = "wifi_test")
	public static WebElement networkSupportCenter;

	@FindBy(id = "speed_test")
	public static WebElement speedTest;

	@FindBy(id = "about")
	public static WebElement about;

	@FindBy(id = "settings")
	public WebElement settings;

	@FindBy(id = "linear_start_pg")
	public WebElement setStartPage;

	@FindBy(id = "linear_change_pwd")
	public WebElement changePassword;

	@FindBy(id = "linear_home")
	public static WebElement homePage;

	@FindBy(id = "view_billingframe")
	public static WebElement billingPage;

	@FindBy(id = "view_billingframe")
	public static WebElement supportPage;

	@FindBy(id = "view_billingframe")
	public static WebElement newsPage;

	@FindBy(id = "view_billingframe")
	public static WebElement emailPage;

	// About
	@FindBy(id = "welcome_tour")
	public static WebElement welcomeTour;

	@FindBy(id = "blog")
	public static WebElement windstreamBlog;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Windstream Blog']")
	public static WebElement windstreamBlogNavigation; 

	@FindBy(id = "app_feedback")
	public static WebElement appFeedback;

	@FindBy(id = "privacy_policy")
	public static WebElement privacyPolicyLink;

	@FindBy(id = "terms_condition")
	public static WebElement termsandConditionsLink;

	@FindBy(id = "software_attribution")
	public static WebElement softwareLicencesLink;

	@FindBy(id = "version")
	public static WebElement appVersion;

	// Feedback
	@FindBy(id = "rb_feedback")
	public WebElement feedbackStar;

	@FindBy(id = "tv_rating")
	public WebElement ratingText;

	@FindBy(id = "edt_comments")
	public WebElement feedbackComments;

	@FindBy(id = "btn_submit")
	public WebElement submitButton;
	
	@FindBy(id="about-top-trigger")
	public WebElement privacyPolicyText;
	
	@FindBy(xpath = "//android.view.View[@text='Privacy Policy']")
	public WebElement privacyPolicyNavigation; 
	
		//WelcomeTour
		
		@FindBy(id = "landing_txt_title")
		public static WebElement welcomeTourLanding;
		
		@FindBy(id = "skip")
		public static WebElement close;
		
		@FindBy(id = "start")
		public static WebElement letgetstarted;
		
		@FindBy(xpath = "//android.view.View[@id='indicator']")
		public WebElement indicator;
		
		@FindBy(id = "next")
		public static WebElement next;
		
		@FindBy(id = "done")
		public static WebElement done; 

	
	//Email Page
	@FindBy(xpath = "//android.view.View[@text='Login using a Windstream email address.']")
	public static WebElement emailPageNavigation;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Refer Friends']")
	public WebElement referFriendsNavigation;
	
	@FindBy(xpath = "//android.view.View[@text=' Search for Shows & Movies']")
	public WebElement watchTvNavigation;
	
	@FindBy(xpath = "//android.widget.TextView[@text='News']")
	public static WebElement newsNavigation;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Terms and Conditions']")
	public WebElement termsandConditionNavigation;
	
	@FindBy(xpath = "//android.view.View[@text='Retrofit']")
	public WebElement softwareLicenceNavigation;
	
	@FindBy(xpath = "//android.widget.Button[@text='Log In']")
	public WebElement networkSupportNavigation;
	
	@FindBy(xpath = "//android.widget.Button[@text='start your speedtest']")
	public WebElement startSpeedTest;
	
	@FindBy(id="snackbar_text")
	public static WebElement rateApp;
	
	public static String version;
	
	public static void versionNavigation()
	{
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.More, "More-Option");
		vc.getMobileDriverUtils().clickMobileElement(about, "About");
		version = appVersion.getText();
		Reporter.log(version, true);
	}
	
	
	public static String version() {
		if(PropertiesUtil.getValue(PropertiesUtil.BROWSER_PROPERTY).contains("android")) {	
		Reporter.log(version, true);
		
		}
		return version;
	}
	
	

	public void moreScreenUI() {
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.More, "More-Option");
		Reporter.log("Username is ==> " + userName.getText(), true);
		Reporter.log("UserEmail is ==> " + userEmail.getText(), true);
		vc.getMobileDriverUtils().elementAvailablity(emailLink, "Email-Link");
		vc.getMobileDriverUtils().elementAvailablity(scheduleLink, "Schedule-Link");
		vc.getMobileDriverUtils().elementAvailablity(referFriendsLink, "ReferFriends-Link");
		vc.getMobileDriverUtils().elementAvailablity(newsLink, "News-Link");
		vc.getMobileDriverUtils().elementAvailablity(networkSupportCenter, "NetworkSupportCenter-Menu");
		vc.getMobileDriverUtils().elementAvailablity(speedTest, "SpeedTest-Menu");
		vc.getMobileDriverUtils().elementAvailablity(about, "About-Menu");
		vc.getMobileDriverUtils().elementAvailablity(settings, "Settings-Menu");
	}

	

	public void aboutUI() {
		vc.getMobileDriverUtils().clickMobileElement(about, "About");
		Reporter.log("App Version -- " + appVersion.getText(), true);
		vc.getMobileDriverUtils().elementAvailablity(welcomeTour, "WelcomeTour");
		vc.getMobileDriverUtils().elementAvailablity(windstreamBlog, "WindstreamBlog");
		vc.getMobileDriverUtils().elementAvailablity(appFeedback, "AppFeedback");
		vc.getMobileDriverUtils().elementAvailablity(privacyPolicyLink, "PrivacyPolicy");
		vc.getMobileDriverUtils().elementAvailablity(termsandConditionsLink, "TermsandConditions");
		vc.getMobileDriverUtils().elementAvailablity(softwareLicencesLink, "SoftwareLicences");
	}

	public void appFeedBack() {
		vc.getMobileDriverUtils().clickMobileElement(appFeedback, "AppFeedback");
		vc.getMobileDriverUtils().mobile_EnterText(feedbackComments, "Test", "Comments");
		driver.navigate().back();
		vc.getMobileDriverUtils().clickMobileElement(submitButton, "Submit-Button");
		Reporter.log(rateApp.getText(), true);
		vc.getMobileDriverUtils().clickMobileElement(feedbackStar, "FeedbackStars");
		Reporter.log("Selected Rating is -- " + ratingText.getText(), true);
		driver.navigate().back();
	}
	
	
	
	public void emailNavigation() {
		vc.getMobileDriverUtils().clickMobileElement(emailLink, "Email-Link");
	//	Assert.assertTrue(vc.getMobileDriverUtils().mobile_waituntillText(emailPageNavigation, "Login using a Windstream email address."));
		driver.navigate().back();
		driver.navigate().back();
		vc.getMobileDriverUtils().mobileNavigation(emailLink, emailPageNavigation, "Login using a Windstream email address.","Email-Link");
		
	
	}
	
	public void watchTvNavigation() {
		vc.getMobileDriverUtils().clickMobileElement(scheduleLink, "WatchTv-Link");
	//	Assert.assertTrue(vc.getMobileDriverUtils().mobile_waituntillText(watchTvNavigation, " Search for Shows & Movies"));
		driver.navigate().back();
		vc.getMobileDriverUtils().mobileNavigation(scheduleLink,watchTvNavigation , " Search for Shows & Movies","WatchTv-Link");
	}
	
	
	public void referFriendsNavigation() {
		vc.getMobileDriverUtils().clickMobileElement(referFriendsLink, "ReferFriends-Link");
	//	Assert.assertTrue(vc.getMobileDriverUtils().mobile_waituntillText(referFriendsNavigation, "Refer Friends"));
		driver.navigate().back();
		vc.getMobileDriverUtils().mobileNavigation(referFriendsLink, referFriendsNavigation, "Refer Friends","ReferFriends-Link");
	}
	
	
	public void newsNavigation() {
		vc.getMobileDriverUtils().clickMobileElement(newsLink, "News-Link");
	//	Assert.assertTrue(vc.getMobileDriverUtils().mobile_waituntillText(newsNavigation, "News"));
		driver.navigate().back();
		vc.getMobileDriverUtils().mobileNavigation(newsLink, newsNavigation, "News","News-Link");
	}
	
	public void privacyPolicyNavigation() {
		vc.getMobileDriverUtils().clickMobileElement(privacyPolicyLink, "PrivacyPolicy-Link");
	//	Assert.assertTrue(vc.getMobileDriverUtils().mobile_waituntillText(privacyPolicyNavigation, "Privacy Policy"));
		driver.navigate().back();
		vc.getMobileDriverUtils().mobileNavigation(privacyPolicyLink, privacyPolicyNavigation, "Privacy Policy","PrivacyPolicy-Link");
	}
	
	public void termsandConditionsNavigation() {
		vc.getMobileDriverUtils().clickMobileElement(termsandConditionsLink, "TermsAndConditions-Link");
	//	Assert.assertTrue(vc.getMobileDriverUtils().mobile_waituntillText(termsandConditionNavigation, "Terms and Conditions"));
		driver.navigate().back();
		vc.getMobileDriverUtils().mobileNavigation(termsandConditionsLink, termsandConditionNavigation, "Terms and Conditions","TermsAndConditions-Link");
	}
	
	public void softwareLicencesNavigation() {
		
		vc.getMobileDriverUtils().clickMobileElement(softwareLicencesLink, "SoftwareLicenses");
		//Assert.assertTrue(vc.getMobileDriverUtils().mobile_waituntillText(softwareLicenceNavigation, "Retrofit"));
		//driver.navigate().back();
		vc.getMobileDriverUtils().mobileNavigation(softwareLicencesLink, softwareLicenceNavigation, "Retrofit","SoftwareLicenses-Link");
		driver.navigate().back();
	}
	
	public void networkSupportCenterNavigation() {
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_MorePage.networkSupportCenter, "NetworkSupportCenter-Link");
	//	Assert.assertTrue(vc.getMobileDriverUtils().mobile_waituntillText(networkSupportNavigation, "Log In"));
		driver.navigate().back();
		driver.navigate().back();
		
		vc.getMobileDriverUtils().mobileNavigation(MyWinMobile_MorePage.networkSupportCenter,networkSupportNavigation , "Log In", "NetworkSupportCenter-Link");
		
	}
	
	 
		public void windstreamBlog()
		{
			vc.getMobileDriverUtils().clickMobileElement(windstreamBlog, "WindstreamBlog-Link");
		//	Assert.assertTrue(vc.getMobileDriverUtils().mobile_waituntillText(windstreamBlogNavigation, "Windstream Blog"));
			driver.navigate().back();
			
			vc.getMobileDriverUtils().mobileNavigation(windstreamBlog, windstreamBlogNavigation, "Windstream Blog","Windstream-Blog");
			
		} 

		public void getSpeedTestReport() throws Exception {
			vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_MorePage.speedTest, "SpeedTestOption");
			vc.getMobileDriverUtils().clickMobileElement(startSpeedTest, "StartSpeedTest");
			vc.getMobileDriverUtils().sleep(3000);
			List<WebElement> billvalues = driver.findElements(By.className("android.view.View"));

			for (WebElement webElement : billvalues) {

				String values = webElement.getText();
				System.out.println(values);
			}

			driver.navigate().back();

		}
		
		
		public void setStartPage(WebElement homePage,WebElement startPage,String pageTitle) throws Exception {
			Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.ConsumerOffers);
			vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.More, "More-Option");
			vc.getMobileDriverUtils().clickMobileElement(settings, "Settings");
			vc.getMobileDriverUtils().elementAvailablity(setStartPage, "SetStartPage");
			vc.getMobileDriverUtils().elementAvailablity(changePassword, "ChangePassword");
			vc.getMobileDriverUtils().clickMobileElement(setStartPage, "SetStartPage");
			vc.getMobileDriverUtils().clickMobileElement(homePage, homePage.getText());
			driver.navigate().back();
			driver.navigate().back();
			vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LoginPage.Signout, "SignOut");
			vc.getMobileDriverUtils().elementAvailablity(MyWinMobile_LoginPage.userName, "userName");
			
			vc.getMobileDriverUtils().mobile_EnterText(MyWinMobile_LoginPage.userName, menu.getUsername(), "Username");
			vc.getMobileDriverUtils().mobile_EnterText(MyWinMobile_LoginPage.password, menu.getPassword(), "Password");
			
			//vc.getMobileDriverUtils().mobile_EnterText(MyWinMobile_LoginPage.userName, menu.getUsername(), "Username");
			//vc.getMobileDriverUtils().mobile_EnterText(MyWinMobile_LoginPage.password, menu.getPassword(), "Password");
			driver.navigate().back();
			vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LoginPage.signInBtn, "Sign In Button");
			vc.getMobileDriverUtils().elementAvailablity(MyWinMobile_LoginPage.Homeicon, "Homeicon");
			if (vc.getMobileDriverUtils().elementAvailablity(startPage, startPage.getText())) {
				Reporter.log(pageTitle + " Set as Start Page", true);
			} else {
				Reporter.log(pageTitle + " is not Set as Start Page", true);
				Assert.assertFalse(true);
			}

		}

	
	
	public void welcomeTour() throws InterruptedException,NoSuchElementException

    {
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.More, "More-Option");
		vc.getMobileDriverUtils().clickMobileElement(about, "About-Option");
           vc.getMobileDriverUtils().clickMobileElement(welcomeTour, "Welcome Tour");
           vc.getMobileDriverUtils().clickMobileElement(letgetstarted, "Let's get started");

           List<WebElement> list =driver.findElements(By.className("android.widget.TextView"));      
           Iterator<WebElement> itr =  list.iterator();
               while(itr.hasNext()) {
                  WebElement navigation = (WebElement)itr.next();
                   Reporter.log(welcomeTourLanding.getText(), true);

                    if(next.isDisplayed()) {
                           vc.getMobileDriverUtils().clickMobileElement(next, "NEXT");
                           itr.next();
                    }
               }
               Reporter.log(welcomeTourLanding.getText(), true);
               vc.getMobileDriverUtils().clickMobileElement(done, "DONE");
               vc.getMobileDriverUtils().elementAvailablity(MyWinMobile_LandingPage.Homeicon, "Home icon");

    }
	
}

