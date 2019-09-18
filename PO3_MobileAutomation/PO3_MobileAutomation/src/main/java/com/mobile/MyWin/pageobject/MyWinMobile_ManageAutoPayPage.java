package com.mobile.MyWin.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.webautomation.validation.Validator;

import commonUtil.WebDriverUtils;

public class MyWinMobile_ManageAutoPayPage {

	final WebDriver driver;
	private Validator vc;

	

	public MyWinMobile_ManageAutoPayPage(WebDriver driver) {
		this.driver = driver;
		this.vc = new Validator(driver);
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Paperless Billing']")
	public WebElement paperlessBilling;

	@FindBy(xpath = "//android.widget.RadioButton[@text='Suppress Paper Invoice']")
	public WebElement suppressPaperInvoice;

	@FindBy(xpath = "//android.widget.RadioButton[@text='Receive Paper Invoice']")
	public WebElement receivePaperInvoice;

	@FindBy(xpath = "//android.widget.TextView[@text='Manage Payment Methods']")
	public static WebElement managePaymentmethod;

	@FindBy(xpath = "//android.widget.TextView[@text='Manage AutoPay']")
	public WebElement manageAutoPay;
	
	@FindBy(xpath = "//android.widget.TextView[@text='You are Enrolled in AutoPay']")
	public WebElement enrolledAutopay;
	
	@FindBy(xpath = "//android.widget.TextView[@text='You are not Enrolled in AutoPay']")
	public WebElement notEnrolledAutopay;

	@FindBy(id = "AutoPay_txt")
	public WebElement enrollAutopay;

	@FindBy(id = "title")
	public WebElement autoPayText;

	@FindBy(id = "card")
	public WebElement paymentOptionDropdown;

	@FindBy(id = "text1")
	public WebElement dueDate;

	@FindBy(xpath = "//android.widget.CheckedTextView[4]")
	public WebElement selectDate;

	@FindBy(id = "no_limit")
	public WebElement noLimitRadioBtn;

	@FindBy(id = "other_amount")
	public WebElement otherAmountRadioBtn;

	@FindBy(id = "terms_and_conditions")
	public WebElement termsCheckbox;

	@FindBy(id = "cancel")
	public WebElement cancelBtn;

	@FindBy(id = "enroll")
	public WebElement enrollBtn;

	@FindBy(id = "name")
	public WebElement cardDetails;

	@FindBy(id = "auto_pay_status")
	public WebElement autopayStatus;

	@FindBy(id = "update")
	public WebElement updateBtn;

	@FindBy(id = "deenroll")
	public WebElement deenrollBtn;

	@FindBy(xpath = "//android.widget.TextView[@text='Your AutoPay has been successfully updated.']")
	public WebElement confirmationMessage;

	@FindBy(id = "done")
	public WebElement doneButton;
	
	@FindBy(xpath = "//android.widget.Switch[@text='ON']")
	public WebElement toggleButton_ON;
	
	@FindBy(xpath = "//android.widget.Switch[@text='OFF']")
	public WebElement toggleButton_OFF;
	
	@FindBy(id = "suspend_toggle")
	public WebElement toggleButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='AutoPay suspended successfully.']")
	public WebElement autopaySuspendedPopup;
	
	@FindBy(xpath = "//android.widget.TextView[@text='AutoPay resumed successfully.']")
	public WebElement autopayResumedPopup;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Update AutoPay']")
	public WebElement updateAutopay;
	
	@FindBy(id = "AutoPay_txt")
	public WebElement autoPay;
	
	@FindBy(id = "message")
	public WebElement autoPayMessage;

	/*
	 * @FindBy(
	 * xpath="//android.widget.TextView[@text='You are Enrolled in AutoPay']")
	 * public WebElement EnrolledAutoPay;
	 * 
	 * @FindBy(
	 * xpath="//android.widget.TextView[@text='You are not Enrolled in AutoPay']")
	 * public WebElement DerolledAutoPay;
	 */

	@FindBy(id = "button1")
	public WebElement CancelAutoPayYes;

	@FindBy(id = "button2")
	public WebElement CancelAutoPayNo;

	@FindBy(xpath = "//android.widget.TextView[@text='Your have successfully un-subscribed from AutoPay.']")
	public WebElement DeenrollSuccess;

	public void optionsUI() {
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.Billingicon, "Billing");
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.Options, "Options");
		vc.getMobileDriverUtils().elementAvailablity(managePaymentmethod, "ManagePaymentMethod");
		vc.getMobileDriverUtils().elementAvailablity(manageAutoPay, "ManageAutoPay");
		vc.getMobileDriverUtils().elementAvailablity(paperlessBilling, "PaperlessBilling");
	}

	public void enrollAutopayUI() {
		vc.getMobileDriverUtils().elementAvailablity(paymentOptionDropdown, "PaymentOption-Dropdown");
		vc.getMobileDriverUtils().elementAvailablity(dueDate, "DueDate-Dropdown");
		vc.getMobileDriverUtils().elementAvailablity(noLimitRadioBtn, "NoLimit-RadioButton");
		vc.getMobileDriverUtils().elementAvailablity(otherAmountRadioBtn, "OtherAmount-RadioButton");
		vc.getMobileDriverUtils().elementAvailablity(termsCheckbox, "TermsandConditions-Checkbox");
		vc.getMobileDriverUtils().elementAvailablity(cancelBtn, "Cancel-Button");
		vc.getMobileDriverUtils().elementAvailablity(enrollBtn, "Enroll-Button");
	}

	public void suspendedAutopayStatus() {
		optionsUI();
		vc.getMobileDriverUtils().clickMobileElement(manageAutoPay, "ManageAutoPay");
		vc.getMobileDriverUtils().elementAvailablity(autoPayText, "AutoPay");
		vc.getMobileDriverUtils().elementAvailablity(paymentOptionDropdown, "PaymentOption-Dropdown");

		if (vc.getMobileDriverUtils().elementAvailablity(enrolledAutopay, "AutopayEnrolled")) {
			Reporter.log(enrolledAutopay.getText(),true);
			if (vc.getMobileDriverUtils().elementAvailablity(toggleButton_OFF, "SuspendAutopay_Disabled")) {
				Reporter.log("AutoPay is Suspended for the User", true);
				vc.getMobileDriverUtils().clickMobileElement(toggleButton, "AutoPay- ToggleButton");
				vc.getMobileDriverUtils().elementAvailablity(autopaySuspendedPopup, "SuspendAutopay");
				Reporter.log(autopaySuspendedPopup.getText(),true);
				vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.ok, "OkButton");
				
			} else {
				Reporter.log("AutoPay is Not Suspended for the User", true);
				vc.getMobileDriverUtils().clickMobileElement(toggleButton, "AutoPay- ToggleButton");
				vc.getMobileDriverUtils().elementAvailablity(autopayResumedPopup, "ResumeAutopay");
				Reporter.log(autopayResumedPopup.getText(),true);
				vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.ok, "OkButton");
			}

		} else {
			Reporter.log("User is not Enrolled in AutoPay", true);
		}

	}

	@FindBy(xpath="//android.widget.TextView[@text='Enjoying the MyWin app?']")
	public WebElement happywithMYWinapp; 
	
	@FindBy(xpath="//android.widget.Button[@text='NOT REALLY']")
	public WebElement notReallyBtn; 
	
	@FindBy(xpath="//android.widget.Button[@text='YES']")
	public WebElement yesBtn; 
	
	@FindBy(id="sad")
	public WebElement sadSmiley;
	
	@FindBy(id="happy")
	public WebElement happySmiley;
	
	@FindBy(id="button3")
	public WebElement notReally;
	
	public void enrollAutoPay() throws InterruptedException {
		optionsUI();
		vc.getMobileDriverUtils().clickMobileElement(manageAutoPay, "ManageAutopay");
		vc.getMobileDriverUtils().elementAvailablity(paymentOptionDropdown, "ManageAutoPay-Screen");
		if (vc.getMobileDriverUtils().elementAvailablity(notEnrolledAutopay, "NotEnrolledInAutopay")) {
			Reporter.log(notEnrolledAutopay.getText(), true);
			enrollAutopayUI();
			vc.getMobileDriverUtils().clickMobileElement(termsCheckbox, "TermsandConditions-Checkbox");
			vc.getMobileDriverUtils().clickMobileElement(enrollBtn, "EnrollAutopay");
			Assert.assertTrue(true, MyWinMobile_BillingPage.paymentErrorMessage.getText());
			Reporter.log(MyWinMobile_BillingPage.paymentErrorMessage.getText().toUpperCase(), true);
			Reporter.log("******ERROR PROMPT IS DISPLAYED TO SELECT PAYMENT METHOD******", true);
			vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.ok, "OK");
			vc.getMobileDriverUtils().clickMobileElement(paymentOptionDropdown, "PaymentOption-Dropdown");
			vc.getMobileDriverUtils().sleep(3000);
			if (vc.getMobileDriverUtils().elementAvailablity(cardDetails, "Cards")) {
				vc.getMobileDriverUtils().clickMobileElement(cardDetails, "Card");
				Reporter.log("Selected " + paymentOptionDropdown.getText() + " from Saved Payment Option", true);
				vc.getMobileDriverUtils().clickMobileElement(dueDate, "DueDate-Dropdown");
				vc.getMobileDriverUtils().clickMobileElement(selectDate, "SelectDate");
				Reporter.log("Selected " + dueDate.getText() + " from DueDate Dropdown ", true);
				vc.getMobileDriverUtils().selectMobileRadioButton(noLimitRadioBtn, "NoLimit");
				vc.getMobileDriverUtils().clickMobileElement(enrollBtn, "Enroll-Button");
				vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.ok, "OK");

				if (vc.getMobileDriverUtils().elementAvailablity(confirmationMessage,
						"AutoPayEnrolled-SuccessMessage")) {
					Reporter.log(autopayStatus.getText(), true);
					vc.getMobileDriverUtils().clickMobileElement(doneButton, "Done - Button");
					vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.Options, "Options");
					vc.getMobileDriverUtils().clickMobileElement(manageAutoPay, "ManageAutoPay");
					vc.getMobileDriverUtils().elementAvailablity(deenrollBtn, "Deenroll");
					Assert.assertEquals(autoPayText.getText(), "You are Enrolled in AutoPay");
					Reporter.log(autoPayText.getText(), true);
					
				}else if (vc.getMobileDriverUtils().elementAvailablity(happywithMYWinapp, "Happy-Popup")) {
					Reporter.log(happywithMYWinapp.getText(), true);
					vc.getMobileDriverUtils().clickMobileElement(sadSmiley, "Prompt Message");
				} 
				
				
				else {
					Reporter.log("Unable to Enroll Autopay", true);
					Assert.assertEquals(MyWinMobile_BillingPage.paymentErrorMessage.isDisplayed(), false,
							MyWinMobile_BillingPage.paymentErrorMessage.getText());
				}

			} else {
				Reporter.log("Card Details Not Available. Please Add payment option",true);
			}
		} else {
			Reporter.log(autoPayText.getText(), true);
		}

	}

	public void deenrollAutoPay() {
		optionsUI();
		vc.getMobileDriverUtils().clickMobileElement(manageAutoPay, "ManageAutopay");

		vc.getMobileDriverUtils().elementAvailablity(paymentOptionDropdown, "ManageAutoPay-Screen");
		if (autoPayText.getText().contains("You are Enrolled in AutoPay")) {
			Reporter.log("User is Enrolled in AutoPay", true);
			vc.getMobileDriverUtils().clickMobileElement(deenrollBtn, "De-Enroll");
			vc.getMobileDriverUtils().clickMobileElement(CancelAutoPayYes, "Confirm De-enroll");
			vc.getMobileDriverUtils().sleep(3000);
			if (autopayStatus.getText().contains("Your have successfully un-subscribed from AutoPay.")) {
				Reporter.log(autopayStatus.getText(), true);
				vc.getMobileDriverUtils().clickMobileElement(doneButton, "DoneButton");
				vc.getMobileDriverUtils().clickMobileElement(manageAutoPay, "ManageAutoPay");
				vc.getMobileDriverUtils().elementAvailablity(paymentOptionDropdown, "ManageAutoPay-Screen");
				Assert.assertEquals(autoPayText.getText(), "You are not Enrolled in AutoPay");
				// Reporter.log(DeenrollSuccess.getText(), true);
				driver.navigate().back();
			} else if (vc.getMobileDriverUtils().elementAvailablity(MyWinMobile_BillingPage.paymentErrorMessage,
					"ErrorMessage")) {
				Reporter.log(MyWinMobile_BillingPage.paymentErrorMessage.getText(), true);
				Assert.assertFalse(true, "AutoPay Enrollment Failed. Please try again later.");
			}

		} else {
			Reporter.log("User is not Enrolled in Autopay", true);

		}

	}

}
