package com.mobile.WeConnect.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.webautomation.validation.Validator;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class WeConnect_LandingPage {

	final WebDriver driver;
	private Validator vc;

	public WeConnect_LandingPage(WebDriver driver) {
		this.driver = driver;
		this.vc = new Validator(driver);
	}
	
	@FindBy(id = "app_menu")
	public static WebElement HamburgerMenu;

	@FindBy(id = "title")
	public WebElement LandingScreenMenus;

	@FindBy(id = "title")
	public List<WebElement> landingMenus;

	@FindBy(id = "item_text")
	public List<WebElement> hamburgerMenus;

	@FindBy(xpath = "//android.widget.TextView[@text='OfficeSuite UC']")
	public static WebElement OfficeSuiteUC;

	@FindBy(xpath = "//android.widget.TextView[@text='About']")
	public WebElement aboutMenu;

	public void getLandingScreenMenus() {

		vc.getMobileDriverUtils().printList(landingMenus, "LandingScreen");

	}

	public void getHamburgerMenus() throws InterruptedException {
		vc.getMobileDriverUtils().clickMobileElement(HamburgerMenu, "HamburgerMenu");
		vc.getMobileDriverUtils().printList(hamburgerMenus, "HamburgerMenu");

	}

	/*@FindBy(id = "com.windstream.enterprise.we.dev:id/app_current_version")
	public WebElement appVersion;*/
	
	@FindBy(id = "app_current_version")
	public WebElement appVersion;

	public void getAppVersion() throws InterruptedException {
		vc.getMobileDriverUtils().clickMobileElement(HamburgerMenu, "HamburgerMenu");
		vc.getMobileDriverUtils().clickMobileElement(aboutMenu, "AboutMenu");
		Reporter.log("APP VERSION IS " + appVersion.getText(), true);

	}

	@FindBy(id = "app_feedback")
	public WebElement appFeedback;

	@FindBy(id = "rb_feedback")
	public WebElement feedbackStar;

	@FindBy(id = "tv_rating")
	public WebElement ratingText;

	@FindBy(id = "edt_comments")
	public WebElement feedbackComments;

	@FindBy(id = "btn_submit")
	public WebElement submitButton;

	@FindBy(id = "snackbar_text")
	public WebElement rateApp;

	public void appFeedBack() {
		vc.getMobileDriverUtils().clickMobileElement(appFeedback, "AppFeedback");
		vc.getMobileDriverUtils().mobile_EnterText(feedbackComments, "Test", "Comments");
		vc.getMobileDriverUtils().clickMobileElement(WeConnect_OfficeSuiteUCPage.backKey, "Back");
		vc.getMobileDriverUtils().clickMobileElement(submitButton, "Submit-Button");
		Reporter.log(rateApp.getText(), true);
		vc.getMobileDriverUtils().clickMobileElement(feedbackStar, "FeedbackStars");
		Reporter.log("Selected Rating is -- " + ratingText.getText(), true);
		vc.getMobileDriverUtils().clickMobileElement(WeConnect_OfficeSuiteUCPage.backKey, "Back");
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Network Status']")
	public WebElement networkStatus;

	@FindBy(xpath = "//android.widget.TextView[@text='Open']")
	public WebElement openStatus;

	@FindBy(xpath = "//android.widget.TextView[@text='Closed']")
	public WebElement closedStatus;

	@FindBy(xpath = "//android.widget.TextView[@text='All clear. No open tickets.']")
	public WebElement noTicketsMessage_Open;

	@FindBy(xpath = "//android.widget.TextView[@text='There are no past network outages.']")
	public WebElement noTicketsMessage_Closed;

	@FindBy(id = "filter_icon")
	public WebElement filterIcon;

	public void networkStatus() {
		vc.getMobileDriverUtils().clickMobileElement(networkStatus, "NetworkStatusMenu");
		vc.getMobileDriverUtils().clickMobileElement(openStatus, "OpenTickets");
		if (vc.getMobileDriverUtils().elementAvailablity(noTicketsMessage_Open, "NoTickets")) {
			Reporter.log(noTicketsMessage_Open.getText(), true);
		} else {

		}
		vc.getMobileDriverUtils().clickMobileElement(closedStatus, "ClosedTickets");
		if (vc.getMobileDriverUtils().elementAvailablity(noTicketsMessage_Closed, "NoTickets")) {
			Reporter.log(noTicketsMessage_Closed.getText(), true);
		} else {

		}
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Notification Subscriptions']")
	public WebElement notificationSubscription;

	@FindBy(id = "search_src_text")
	public WebElement searchProfiles;

	@FindBy(id = "profile_add_floating")
	public WebElement addProfile;

	@FindBy(id = "contact_name")
	public List<WebElement> profileNames;

	@FindBy(id = "first_name")
	public WebElement fName;

	@FindBy(id = "last_name")
	public WebElement lName;

	@FindBy(id = "email")
	public WebElement email;

	@FindBy(id = "primary_phone")
	public WebElement phoneNo;

	@FindBy(id = "add_accounts_layout")
	public WebElement linkNewAccount;

	@FindBy(id = "listItem")
	public List<WebElement> accountList;

	@FindBy(id = "contact_name")
	public WebElement addedAccount;

	@FindBy(id = "contact_name")
	public List<WebElement> addedAccounts;

	@FindBy(xpath = "//android.widget.TextView[@text='Done']")
	public WebElement doneButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Save']")
	public WebElement saveButton;

	@FindBy(id = "id_email_details_layout")
	public WebElement profileDetails;

	@FindBy(id = "switch1")
	public WebElement notificationsChkBox;

	@FindBy(xpath = "//android.widget.Button[@text='OK']")
	public WebElement ok;

	@FindBy(xpath = "//android.widget.TextView[@text='Edit']")
	public WebElement editButton1;

	@FindBy(id = "EditText")
	public WebElement editButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Delete Contact']")
	public WebElement deleteContact;

	@FindBy(id = "id_email_notification_txt")
	public WebElement addedScreen;

	@FindBy(xpath = "//android.widget.Button[@text='YES']")
	public WebElement deleteContact_yesBtn;

	public void notifications(String firstname, String lastname) {
		vc.getMobileDriverUtils().clickMobileElement(notificationSubscription, "NotificationSubscription");
		Reporter.log("***ADD PROFILE***", true);
		vc.getMobileDriverUtils().clickMobileElement(addProfile, "AddNewProfile");
		vc.getMobileDriverUtils().elementAvailablity(fName, "AddContact-Screen");
		vc.getMobileDriverUtils().mobile_EnterText(fName, firstname, "FirstName");
		vc.getMobileDriverUtils().mobile_EnterText(lName, lastname, "LastName");
		vc.getMobileDriverUtils().mobile_EnterText(email, "testing@we.com", "Email");
		driver.navigate().back();
		vc.getMobileDriverUtils().mobile_EnterText(phoneNo, "1234567890", "PhoneNo");
		driver.navigate().back();
		vc.getMobileDriverUtils().clickMobileElement(linkNewAccount, "LinkNewAccount");
		vc.getMobileDriverUtils().selectFirstItem(accountList, "SelectAccounts");
		vc.getMobileDriverUtils().sleep(2000);
		vc.getMobileDriverUtils().selectFirstItem(accountList, "ContactType");
		vc.getMobileDriverUtils().clickMobileElement(doneButton, "DoneButton");
		vc.getMobileDriverUtils().elementAvailablity(fName, "AddContact-Screen");
		vc.getMobileDriverUtils().clickMobileElement(saveButton, "SaveButton");
		vc.getMobileDriverUtils().elementAvailablity(searchProfiles, "ProfileScreen");
		Reporter.log("***SEARCH PROFILE***", true);

		if (vc.getMobileDriverUtils().searchandClick(searchProfiles, firstname + " " + lastname, addedAccounts)) {
			vc.getMobileDriverUtils().elementAvailablity(profileDetails, "ProfileDetails");

			Reporter.log("***SELECT RECEIVE ALL NOTIFIACTIONS CHECKBOX***", true);
			vc.getMobileDriverUtils().clickMobileElement(notificationsChkBox, "Notifictions-Checkbox");
			vc.getMobileDriverUtils().clickMobileElement(ok, "OkButton");

			Reporter.log("***DELETE ADDED PROFILE***", true);
			vc.getMobileDriverUtils().clickMobileElement(editButton, "EditButton");
			vc.getMobileDriverUtils().elementAvailablity(fName, "EditScreen");
			vc.getMobileDriverUtils().clickMobileElement(deleteContact, "Delete");
			vc.getMobileDriverUtils().clickMobileElement(deleteContact_yesBtn, "DeleteContact");
			vc.getMobileDriverUtils().elementAvailablity(searchProfiles, "NotificationScreen");
			if (!vc.getMobileDriverUtils().searchandClick(searchProfiles, firstname + " " + lastname, addedAccounts)) {
				Reporter.log(firstname + " " + lastname + " PROFILE IS DELETED SUCCESSFULLY", true);
			} else {
				Reporter.log(firstname + " " + lastname + " PROFILE IS NOT DELETED", true);
				Assert.assertFalse(true);
			}
		} else {
			Reporter.log("PROFILE IS NOT ADDED", true);
			Assert.assertFalse(true);
		}

	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Notification Settings']")
	public WebElement notificationSettings;
	
	@FindBy(id = "tv_email")
	public WebElement emails;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Delete']")
	public WebElement deleteEmail;
	
	@FindBy(id = "fab_add_contact")
	public WebElement addNewProfile;
	
	/*@FindBy(xpath = "//android.widget.EditText[@text='Enter Email']")
	public WebElement emailField;*/
	
	@FindBy(id ="com.windstream.enterprise.ilec.dev:id/edt_email")
	public WebElement emailField;	
	
	public void smb_Notifications(String Email) {
		vc.getMobileDriverUtils().clickMobileElement(HamburgerMenu, "HamburgerMenu");
		vc.getMobileDriverUtils().clickMobileElement(notificationSettings, "NotificationSettings");
		Reporter.log("***ADD PROFILE***", true);
		vc.getMobileDriverUtils().clickMobileElement(addNewProfile, "AddNewProfile");
		
		
		
		WebElement em = driver.findElement(By.className("android.widget.EditText"));
		System.out.println(em.getText());
		
		vc.getMobileDriverUtils().elementAvailablity(emailField, "AddContact-Screen");
		vc.getMobileDriverUtils().mobile_EnterText(emailField, "testing@we.com", "Email");
		driver.navigate().back();
		
		vc.getMobileDriverUtils().clickMobileElement(saveButton, "SaveButton");
		vc.getMobileDriverUtils().elementAvailablity(searchProfiles, "ProfileScreen");
		Reporter.log("***SEARCH PROFILE***", true);

		if (vc.getMobileDriverUtils().searchandClick(searchProfiles, Email , addedAccounts)) {
			

			

			Reporter.log("***DELETE ADDED PROFILE***", true);
			
			vc.getMobileDriverUtils().clickMobileElement(deleteEmail, "Delete");
			vc.getMobileDriverUtils().clickMobileElement(deleteContact_yesBtn, "DeleteContact");
			vc.getMobileDriverUtils().elementAvailablity(searchProfiles, "NotificationScreen");
			if (!vc.getMobileDriverUtils().searchandClick(searchProfiles, Email, addedAccounts)) {
				Reporter.log(Email + " PROFILE IS DELETED SUCCESSFULLY", true);
			} else {
				Reporter.log(Email + " PROFILE IS NOT DELETED", true);
				Assert.assertFalse(true);
			}
		} else {
			Reporter.log("PROFILE IS NOT ADDED", true);
			Assert.assertFalse(true);
		}

	}

	@FindBy(xpath = "//android.widget.TextView[@text='Company Contacts']")
	public WebElement companyContacts;

	@FindBy(id = "fab")
	public WebElement addContactIcon;

	public void companyContacts(String firstname, String lastname) {
		vc.getMobileDriverUtils().clickMobileElement(companyContacts, "CompanyContacts");
		Reporter.log("***ADD NEW CONTACT***", true);
		vc.getMobileDriverUtils().clickMobileElement(addContactIcon, "AddNewContact");
		vc.getMobileDriverUtils().elementAvailablity(fName, "AddContact-Screen");
		vc.getMobileDriverUtils().mobile_EnterText(fName, firstname, "FirstName");
		vc.getMobileDriverUtils().mobile_EnterText(lName, lastname, "LastName");
		vc.getMobileDriverUtils().mobile_EnterText(email, "testing@we.com", "Email");
		driver.navigate().back();
		vc.getMobileDriverUtils().mobile_EnterText(phoneNo, "1234567890", "PhoneNo");
		driver.navigate().back();
		vc.getMobileDriverUtils().clickMobileElement(linkNewAccount, "LinkNewAccount");
		vc.getMobileDriverUtils().selectFirstItem(accountList, "SelectAccounts");
		vc.getMobileDriverUtils().sleep(2000);
		vc.getMobileDriverUtils().selectFirstItem(accountList, "ContactType");
		vc.getMobileDriverUtils().clickMobileElement(doneButton, "DoneButton");
		vc.getMobileDriverUtils().elementAvailablity(fName, "AddContact-Screen");
		vc.getMobileDriverUtils().clickMobileElement(saveButton, "SaveButton");
		vc.getMobileDriverUtils().elementAvailablity(searchProfiles, "ProfileScreen");
		Reporter.log("***SEARCH CONTACT***", true);

		if (vc.getMobileDriverUtils().searchandClick(searchProfiles, firstname + " " + lastname, addedAccounts)) {
			vc.getMobileDriverUtils().elementAvailablity(profileDetails, "ProfileDetails");

			Reporter.log("***DELETE ADDED CONTACT***", true);
			vc.getMobileDriverUtils().clickMobileElement(editButton, "EditButton");
			vc.getMobileDriverUtils().elementAvailablity(fName, "EditScreen");
			vc.getMobileDriverUtils().clickMobileElement(deleteContact, "Delete");
			vc.getMobileDriverUtils().clickMobileElement(deleteContact_yesBtn, "DeleteContact");
			vc.getMobileDriverUtils().elementAvailablity(searchProfiles, "NotificationScreen");
			if (!vc.getMobileDriverUtils().searchandClick(searchProfiles, firstname + " " + lastname, addedAccounts)) {
				Reporter.log(firstname + " " + lastname + " CONTACT IS DELETED SUCCESSFULLY", true);
			} else {
				Reporter.log(firstname + " " + lastname + " CONTACT IS NOT DELETED", true);
				Assert.assertFalse(true);
			}
		} else {
			Reporter.log("CONTACT IS NOT ADDED", true);
			Assert.assertFalse(true);
		}

	}
}
