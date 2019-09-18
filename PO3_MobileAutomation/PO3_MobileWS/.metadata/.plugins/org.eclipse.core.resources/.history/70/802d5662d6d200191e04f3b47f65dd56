package com.mobile.WeConnect.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.webautomation.validation.Validator;

public class WeConnect_NotificationSubscriptionPage {

	final WebDriver driver;
	private Validator vc;
	

	public WeConnect_NotificationSubscriptionPage(WebDriver driver) {
		this.driver = driver;
		this.vc = new Validator(driver);
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Notification Subscriptions']")
	public WebElement notificationSubscription;
	
	@FindBy(id = "search_src_text")
	public WebElement searchProfiles;
	
	@FindBy(id = "profile_add_floating")
	public WebElement addProfile;
	
	@FindBy(id="contact_name")
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
	
	@FindBy(id="listItem")
	public List<WebElement> accountList;
	
	@FindBy(id="contact_name")
	public WebElement addedAccount;
	
	@FindBy(id="contact_name")
	public List<WebElement> addedAccounts;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Done']")
	public WebElement doneButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Save']")
	public WebElement saveButton;
	
	@FindBy(id="id_email_details_layout")
	public WebElement profileDetails;
	
	@FindBy(id="switch1")
	public WebElement notificationsChkBox;
	
	@FindBy(xpath="//android.widget.Button[@text='OK']")
	public WebElement ok;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Edit']")
	public WebElement editButton1;
	
	@FindBy(id="EditText")
	public WebElement editButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Delete Contact']")
	public WebElement deleteContact;
	
	@FindBy(id = "id_email_notification_txt")
	public WebElement addedScreen;
	
	@FindBy(xpath="//android.widget.Button[@text='YES']")
	public WebElement deleteContact_yesBtn; 
	
	
	public void notifications(String firstname,String lastname) {		
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
		vc.getMobileDriverUtils().selectFirstItem(accountList,"SelectAccounts");
		vc.getMobileDriverUtils().sleep(2000);
		vc.getMobileDriverUtils().selectFirstItem(accountList,"ContactType");
		vc.getMobileDriverUtils().clickMobileElement(doneButton, "DoneButton");
		vc.getMobileDriverUtils().elementAvailablity(fName, "AddContact-Screen");
		vc.getMobileDriverUtils().clickMobileElement(saveButton, "SaveButton");
		vc.getMobileDriverUtils().elementAvailablity(searchProfiles, "ProfileScreen");
		Reporter.log("***SEARCH PROFILE***", true);
		
		vc.getMobileDriverUtils().searchandClick(searchProfiles, firstname+" "+lastname, addedAccounts);
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
		if(!vc.getMobileDriverUtils().searchandClick(searchProfiles, firstname+" "+lastname, addedAccounts)){
			Reporter.log(firstname+" "+lastname + " PROFILE IS DELETED SUCCESSFULLY", true);
		} else {
			Reporter.log(firstname+" "+lastname + " PROFILE IS NOT DELETED", true);
			Assert.assertFalse(true);
		}
		
	}
	
	
}
