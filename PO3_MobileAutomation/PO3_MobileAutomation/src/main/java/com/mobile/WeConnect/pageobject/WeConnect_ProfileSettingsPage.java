package com.mobile.WeConnect.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.mobile.MyWin.pageobject.MyWinMobile_LoginPage;
import com.webautomation.testdata.factory.MenuFactory;
import com.webautomation.testdata.menu.Menu;
import com.webautomation.testdata.menu.module1AppMenu;
import com.webautomation.validation.Validator;

public class WeConnect_ProfileSettingsPage {

	final WebDriver driver;
	private Validator vc;

	

	MyWinMobile_LoginPage loginPage;

	public WeConnect_ProfileSettingsPage(WebDriver driver) {
		this.driver = driver;
		this.vc = new Validator(driver);
	}

	
	@FindBy(id = "icon_profile")
	public WebElement profileIcon;

	@FindBy(id = "start_page_title")
	public WebElement startPageTitle;

	@FindBy(xpath = "//*[@text='OfficeSuite UC']")
	public WebElement startPage_OfficeSuite;

	@FindBy(xpath = "//*[@text='Sign Out']")
	public WebElement signoutButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Coworkers']")
	public WebElement coworkersTab;

	public void setStartPage(String StartPageName) throws Exception {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.Automation);
		vc.getMobileDriverUtils().clickMobileElement(profileIcon, "ProfileIcon");
		vc.getMobileDriverUtils().clickMobileElement(startPageTitle, "StartPageTitle");
		vc.getMobileDriverUtils().clickMobileElement(startPage_OfficeSuite, "OfficeSuiteUC");
		vc.getMobileDriverUtils().clickMobileElement(signoutButton, "SignOut-Button");

		vc.getMobileDriverUtils().elementAvailablity(MyWinMobile_LoginPage.userName, "userName");
		vc.getMobileDriverUtils().mobile_EnterText(MyWinMobile_LoginPage.userName, menu.getUsername(), "Username");
		vc.getMobileDriverUtils().mobile_EnterText(MyWinMobile_LoginPage.password, menu.getPassword(), "Password");
		driver.navigate().back();
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LoginPage.signInBtn, "Sign In Button");
		if (vc.getMobileDriverUtils().elementAvailablity(coworkersTab, "CoworkersList")) {
			Reporter.log(StartPageName + " Set as Start Page", true);
		} else {
			Reporter.log(StartPageName + " is not Set as Start Page", true);
			Assert.assertFalse(true);
		}

	}
	
	@FindBy(xpath = "//*[@text='OfficeSuite User Settings']")
	public WebElement officeSuiteSettings;

	@FindBy(xpath = "//*[@text='Shortcut to Contact Book']")
	public WebElement shortcutToContactBook;

	@FindBy(xpath = "//android.widget.TextView[@text='Coworkers']")
	public static WebElement coworkersPage;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Favorites']")
	public static WebElement favoritesPage;

	@FindBy(xpath = "//*[@text='Groups']")
	public WebElement groupsPage;

	public void setShortcutToContactBook(WebElement shortcutoption,String shortcutName) throws Exception {
		Menu menu = MenuFactory.getModule1MenuByTitle(module1AppMenu.Automation);
		vc.getMobileDriverUtils().clickMobileElement(profileIcon, "ProfileIcon");
		vc.getMobileDriverUtils().clickMobileElement(officeSuiteSettings, "OfficeSuiteSettings");
		vc.getMobileDriverUtils().clickMobileElement(shortcutToContactBook, "ShortcutToContactBook");
		vc.getMobileDriverUtils().clickMobileElement(shortcutoption, shortcutName);
		vc.getMobileDriverUtils().clickMobileElement(WeConnect_OfficeSuiteUCPage.backKey, "Back");
		vc.getMobileDriverUtils().clickMobileElement(WeConnect_OfficeSuiteUCPage.backKey, "Back");
		vc.getMobileDriverUtils().clickMobileElement(signoutButton, "SignOut-Button");

		vc.getMobileDriverUtils().elementAvailablity(MyWinMobile_LoginPage.userName, "userName");
		vc.getMobileDriverUtils().mobile_EnterText(MyWinMobile_LoginPage.userName, menu.getUsername(), "Username");
		vc.getMobileDriverUtils().mobile_EnterText(MyWinMobile_LoginPage.password, menu.getPassword(), "Password");
		driver.navigate().back();
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LoginPage.signInBtn, "Sign In Button");

		vc.getMobileDriverUtils().elementAvailablity(WeConnect_LandingPage.HamburgerMenu, "LandingScreen");
		vc.getMobileDriverUtils().clickMobileElement(WeConnect_LandingPage.OfficeSuiteUC, "officeSuite");
		if (vc.getMobileDriverUtils().elementAvailablity(WeConnect_OfficeSuiteUCPage.contactName, "CoworkerList")) {
			Reporter.log(shortcutName + "is set as Shortcut to Contact", true);
		} else {
			Reporter.log(shortcutName + "is not set as Shortcut to Contact", true);
			Assert.assertFalse(true);
		}

	}
	
	@FindBy(id ="com.windstream.enterprise.we.dev:id/status")
	public WebElement statustext;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Presence Status']")
	public WebElement presenceStatusMenu;	
	
	@FindBy(id = "id_Presence_available_txt")
	public WebElement presenceStatus;
	
	@FindBy(id = "listItem")
	public List<WebElement> presenceStatusOptions;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Follows Phone Status']")
	public WebElement followPhoneStatus;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Available']")
	public WebElement availableStatus;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Busy']")
	public WebElement busyStatus;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Do Not Disturb']")
	public WebElement doNotDisturbStatus;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Be Right Back']")
	public WebElement beRightBackStatus;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Away']")
	public WebElement awayStatus;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Out of Office']")
	public WebElement oooStatus;
	
	@FindBy(xpath = "//android.widget.TextView[@text='New Custom Status']")
	public WebElement newCustomStatus;
	
	
	
	public void changePresenceStatus(WebElement presence,String statusMessage) {
		vc.getMobileDriverUtils().clickMobileElement(profileIcon, "ProfileIcon");
		vc.getMobileDriverUtils().clickMobileElement(statustext, "Status");
		vc.getMobileDriverUtils().printList(presenceStatusOptions, "Status");
		vc.getMobileDriverUtils().clickMobileElement(presence, statusMessage);
		if (vc.getMobileDriverUtils().elementAvailablity(WeConnect_OfficeSuiteUCPage.toastMessage, "toastMessage")) {
			Reporter.log(WeConnect_OfficeSuiteUCPage.toastMessage.getText().toUpperCase(), true);
			vc.getMobileDriverUtils().clickMobileElement(WeConnect_OfficeSuiteUCPage.backKey, "Back");
			String setStatus = statustext.getText();
			String profileStatus = presence.getText();
			Assert.assertEquals(profileStatus,setStatus);
			Reporter.log("PRESENCE STATUS IS SUCCESSFULLY SET TO " + profileStatus.toUpperCase(), true);
			
		}else {
			Reporter.log("Status not updated",true);
			Assert.assertFalse(true);
		}
	}		
		
	@FindBy(id="com.windstream.enterprise.we.dev:id/edt_custom_status")
	public WebElement searchField;
	
	@FindBy(id="com.windstream.enterprise.we.dev:id/save_custom")
	public WebElement saveCustomStatus;
	
	@FindBy(id="com.windstream.enterprise.we.dev:id/delete")
	public WebElement customStatusDelete;
	
	@FindBy(id="android:id/button2")
	public WebElement deleteYesButton;
	
	
	
	public void setNewCustomStatus(String status) {
		vc.getMobileDriverUtils().clickMobileElement(profileIcon, "ProfileIcon");
		vc.getMobileDriverUtils().clickMobileElement(statustext, "Status");
		vc.getMobileDriverUtils().clickMobileElement(newCustomStatus, "NewCustomStatus");
		vc.getMobileDriverUtils().mobile_EnterText(searchField, status, "CustomStatus");
		vc.getMobileDriverUtils().clickMobileElement(saveCustomStatus, "SaveButton");
		if (vc.getMobileDriverUtils().getNamesFromList(presenceStatusOptions).contains(status)) {
			Reporter.log("CUSTOM STATUS HAS BEEN SUCCESSFULLY ADDED ==>" + status.toUpperCase(), true);
			for (int i = 0; i < presenceStatusOptions.size(); i++) {
				if (presenceStatusOptions.get(i).getText().contains(status)) {
					presenceStatusOptions.get(i).click();
				}
			}

			if (vc.getMobileDriverUtils().elementAvailablity(WeConnect_OfficeSuiteUCPage.toastMessage,
					"toastMessage")) {
				Reporter.log(WeConnect_OfficeSuiteUCPage.toastMessage.getText().toUpperCase(), true);
				vc.getMobileDriverUtils().clickMobileElement(WeConnect_OfficeSuiteUCPage.backKey, "Back");
				String setStatus = statustext.getText();
				Assert.assertEquals(setStatus, status);
				Reporter.log("PRESENCE STATUS IS SUCCESSFULLY SET TO " + status.toUpperCase(), true);

				Reporter.log("***Delete Custom Status***", true);
				vc.getMobileDriverUtils().clickMobileElement(statustext, "Status");
				vc.getMobileDriverUtils().clickMobileElement(customStatusDelete, "Delete");
				vc.getMobileDriverUtils().clickMobileElement(deleteYesButton, "YesButton");
				if (!vc.getMobileDriverUtils().getNamesFromList(presenceStatusOptions).contains(status)) {
					Reporter.log("CUSTOM STATUS IS DELETED SUCCESSFULLY", true);
					vc.getMobileDriverUtils().clickMobileElement(WeConnect_OfficeSuiteUCPage.backKey, "Back");
					if (statustext.getText().contains(status)) {
						Reporter.log("CUSTOM STATUS IS NOT DELETED SUCCESSFULLY", true);
						Assert.assertFalse(true);
					} else {
						Reporter.log("CURRENT STATUS IS MOVED TO " + statustext.getText(), true);
					}

				}
			}

		} else {
			Reporter.log("Custom Status is not set", true);
			Assert.assertFalse(true);
		}

	}
	
}
