package com.mobile.MyWin.pageobject;

import java.util.List;

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

public class MyWinMobile_ChangePasswordPage {

	final WebDriver driver;
	private Validator vc;

	MyWinMobile_LoginPage loginPage;

	public MyWinMobile_ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
		this.vc = new Validator(driver);
	}

	
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

	// Change Password
	@FindBy(id = "username")
	public static WebElement userName;

	@FindBy(id = "password")
	public static WebElement passWord;

	@FindBy(id = "newPassword1")
	public static WebElement newPassword;

	@FindBy(id = "newPassword2")
	public static WebElement confirmNewPassword;

	@FindBy(xpath = "//android.view.View[@text=' Submit']")
	public static WebElement submitBtn;

	@FindBy(xpath = "//android.view.View[@text='New password cannot be blank.']")
	public WebElement emptyNewPassword;

	@FindBy(xpath = "//android.view.View[@text='Username cannot be blank.']")
	public WebElement emptyUsername;

	@FindBy(xpath = "//android.view.View[@text='Current password cannot be blank.']")
	public WebElement emptyCurrentpassword;

	@FindBy(xpath = "//android.view.View[@text='New passwords do not match.']")
	public WebElement passwordMismatch;
	
	@FindBy(xpath = "//android.view.View[@text='Congratulations! You have successfully changed your password.']")
	public WebElement validPassword;
	
	@FindBy(xpath = "//android.view.View[@text=' Return to Login Page']")
	public WebElement returnToLogin;

	@FindBy(xpath = "//android.view.View[@text='We didn't recognize the username or password you entered. Please try again.']")
	public WebElement invalidUNandPW;
	

	public void changePasswordUI() {
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.More, "More-Option");
		vc.getMobileDriverUtils().clickMobileElement(settings, "Settings");
		vc.getMobileDriverUtils().clickMobileElement(changePassword, "Change-Password");
		vc.getMobileDriverUtils().elementAvailablity(userName, "UserName-Field");
		vc.getMobileDriverUtils().elementAvailablity(passWord, "CurrentPassword-Field");
		vc.getMobileDriverUtils().elementAvailablity(newPassword, "NewPassowrd-Field");
		vc.getMobileDriverUtils().elementAvailablity(confirmNewPassword, "ConfirmNewPassword-Field");
		vc.getMobileDriverUtils().elementAvailablity(submitBtn, "Submit-Button");
	}

	public void passwordMismatch(String name, String password, String newPW, String confirmNP) {
		vc.getMobileDriverUtils().mobile_EnterText(userName, name, "Username");
		vc.getMobileDriverUtils().mobile_EnterText(passWord, password, "password");
		vc.getMobileDriverUtils().mobile_EnterText(newPassword, newPW, "NewPassword");
		vc.getMobileDriverUtils().mobile_EnterText(confirmNewPassword, confirmNP, "ConfirmNewPassword");
		driver.navigate().back();
		vc.getMobileDriverUtils().clickMobileElement(submitBtn, "SubmitButton");
		vc.getMobileDriverUtils().mobile_waituntillText(passwordMismatch, "New passwords do not match.");
	}

	public void changePasswordInvalid(String password) {
		vc.getMobileDriverUtils().mobile_EnterText(passWord, password, "password");
		driver.navigate().back();
		vc.getMobileDriverUtils().clickMobileElement(submitBtn, "SubmitButton");
		vc.getMobileDriverUtils().mobile_waituntillText(emptyNewPassword, "New password cannot be blank.");

	}
	
	public void changePasswordvalid(String username,String currentPW,String newPW,String confirmNewPW) {
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.More, "More-Option");
		vc.getMobileDriverUtils().clickMobileElement(settings, "Settings");
		vc.getMobileDriverUtils().clickMobileElement(changePassword, "Change-Password");
		vc.getMobileDriverUtils().elementAvailablity(userName, "UserName-Field");
		vc.getMobileDriverUtils().mobile_EnterText(userName, username, "UserName");
		vc.getMobileDriverUtils().mobile_EnterText(passWord, currentPW, "password");
		driver.navigate().back();
		vc.getMobileDriverUtils().mobile_EnterText(newPassword, newPW, "NewPassword");
		driver.navigate().back();
		vc.getMobileDriverUtils().mobile_EnterText(confirmNewPassword, confirmNewPW, "ConfirmNewPassword");
		driver.navigate().back();
		vc.getMobileDriverUtils().clickMobileElement(submitBtn, "SubmitButton");
		if(vc.getMobileDriverUtils().elementAvailablity(validPassword, "Message")==true) {
			Reporter.log(validPassword.getText(),true);
			vc.getMobileDriverUtils().clickMobileElement(returnToLogin, "ReturnToLogin");
		}else {
			Assert.assertFalse(true,"Password is not Changed");
		}
		//vc.getMobileDriverUtils().mobile_waituntillText2(validPassword, "Congratulations! You have successfully changed your password.");
		//vc.getMobileDriverUtils().clickMobileElement(returnToLogin, "ReturnToLogin");
	}

	
	
}
