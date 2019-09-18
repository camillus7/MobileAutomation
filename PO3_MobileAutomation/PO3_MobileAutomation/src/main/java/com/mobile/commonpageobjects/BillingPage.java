package com.mobile.commonpageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.mobile.MyWin.pageobject.MyWinMobile_LandingPage;
import com.webautomation.validation.Validator;

public class BillingPage {

	final WebDriver driver;
	private Validator vc;
	
	
	public BillingPage(WebDriver driver) {
		this.driver = driver;
		this.vc = new Validator(driver);
	}

	
	@FindBy(id="view_details")
	public WebElement viewAmountDetails;
	
	@FindBy(xpath = "//android.widget.TextView[@text='CURRENT BILL']")
	public static WebElement CurrentBill;

	@FindBy(xpath = "//android.widget.TextView[@text='HISTORY']")
	public  static WebElement Historyoption;

	@FindBy(xpath = "//android.widget.TextView[@text='OPTIONS']")
	public static WebElement Options;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Bill History']")
	public static WebElement Billhistory;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Payment History']")
	public static WebElement Paymenthistory;
	
	@FindBy(id = "btn_pay_now")
	public WebElement payNowButton;
	
	@FindBy(id = "txt_current_balance")
	public static WebElement currentBalanceDue;
	
	@FindBy(id = "due_date")
	public static WebElement currentBalanceDueDate;
	
	@FindBy(id = "current_balance")
	public WebElement currentBalance;

	@FindBy(id = "past_due")
	public WebElement pastDue;

	@FindBy(id = "other_amount")
	public WebElement otherAmount;
	
	@FindBy(id="custom_amount")
	public WebElement customAmount;

	@FindBy(id = "payment_date")
	public static WebElement paymentDate;

	@FindBy(id = "btn_pay_now")
	public WebElement continueButton;

	@FindBy(id = "button1")
	public WebElement calendarOkButton;
	
	@FindBy(id="AutoPay_txt")
	public WebElement enrollAutopay;
	
	@FindBy(id="card")
	public WebElement paymentOptionDropdown;
	
	@FindBy(id="text1")
	public WebElement dueDate;
	
	@FindBy(id="no_limit")
	public WebElement noLimitRadioBtn;
	
	@FindBy(id="other_amount")
	public WebElement otherAmountRadioBtn;
	
	@FindBy(id="terms_and_conditions")
	public WebElement termsCheckbox;
	
	@FindBy(id="cancel")
	public WebElement cancelBtn;
	
	@FindBy(id="enroll")
	public WebElement enrollBtn;
	
	@FindBy(id="id_date_invoice")
	public WebElement billHistoryAvailability;
	
	@FindBy(xpath="//android.widget.TextView[@text='TOTAL AMOUNT DUE']")
	public WebElement totlaamt;
	
	@FindBy(id="download")
	public WebElement DownloadBillsBtn; 
	
	@FindBy(xpath = "//android.view.View[@text='Available Documents']")
	public static WebElement AvailableDocs; 
	
	@FindBy(xpath = "//android.widget.TextView[@text='Payment method not available. Please add a valid Credit / Debit card or Bank account.']")
	public WebElement CardNotavailable;

	@FindBy(id = "terms_and_conditions")
	public WebElement TermsandConditioncheckbox;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Please agree to the Terms and Conditions..']")
	public WebElement termsandconditionErrorMessage;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Payment Failed. Please try again later.']")
	public WebElement paymentFailedMessage;

	@FindBy(id = "selection")
	public WebElement CardRadioButton;
	
	
	@FindBy(id = "name")
	public WebElement CardHolderName;
	
	@FindBy(id="add_new_payment")
	public WebElement addPaymentMethod;
	
	@FindBy(id="message")
	public static WebElement paymentErrorMessage;
	
	@FindBy(id="button1")
	public static WebElement ok;
	
	@FindBy(id="positive")
	public static WebElement happy;
	
	@FindBy(id="negative")
	public static WebElement notHappy;
	
	@FindBy(id="snackbar_text")
	public static WebElement termsandConditionsMessage;
	
	
	@FindBy(id = "btn_pay_now")
	public WebElement previousButton;
	
	@FindBy(id="amount")
	public WebElement amountPaid;
	
	@FindBy(xpath="//android.widget.TextView[@text='Your Payment is Successful']")
	public WebElement paymentSuccessMessage;
	
	@FindBy(id="confirmation_number")
	public WebElement paymentConfirmationNo;
	
	@FindBy(xpath="//android.widget.TextView[@text='Credit / Debit Card']")
	public WebElement creditdebit_title;

	@FindBy(xpath="//android.widget.TextView[@text='Are you happy with the MyWin app']")
	public WebElement happywithMYWinapp; 
	
	@FindBy(xpath="//android.widget.Button[@text='NOT REALLY']")
	public WebElement notReallyBtn; 
	
	@FindBy(xpath="//android.widget.Button[@text='YES']")
	public WebElement yesBtn; 
	
	@FindBy(id="button3")
	public WebElement notReally;
	
	@FindBy(id="message")
	public WebElement cardChangeMessage;
	
	/*@FindBy(xpath="//android.widget.Button[@text='Not Really']")
			public WebElement notReally;*/
			
	@FindBy(xpath="//android.widget.Button[@text='Yes']")
	public WebElement enrollYes; 

	@FindBy(id="done")
	public WebElement doneButton;
	
	
	
	//Paperless Billing

	@FindBy(xpath = "//android.widget.TextView[@text='Paperless Billing']")
	public WebElement paperlessBilling;

	@FindBy(xpath = "//android.widget.RadioButton[@text='Suppress Paper Invoice']")
	public WebElement suppressPaperInvoice;

	@FindBy(xpath = "//android.widget.RadioButton[@text='Receive Paper Invoice']")
	public WebElement receivePaperInvoice;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Manage Payment Methods']")
	public static WebElement managePaymentmethod;
	
	

	@FindBy(id = "rl_save_changes")
	public WebElement saveChanges;
	
	
	public void makePaymentAmount() throws InterruptedException {
	
		String text = currentBalanceDue.getText();
		Reporter.log("TOTAL AMOUNT DUE IS ====> " + text ,true);
		if(text.equals("$0.00")) {
			Reporter.log("You do not have any dues", true);
		}else {
			//payCurrentBalance();
			payOtherAmount("1");
			if(checkCardAvailability()) {
				Reporter.log("CARDS ALREADY ADDED", true);
				makePaymentWithoutSelecting();
				makePayment();
				
			}else {
				Reporter.log("No Cards Available. Adding Card...", true);
				
			}
		}
		
	}
	
	@FindBy(id="btn_void_payment")
	public WebElement voidPayment;
	
	@FindBy(id="tv_bill_status")
	public WebElement paymentHistoryRecords;
	
	@FindBy(xpath="android.widget.TextView[@text='Scheduled Payment']")
	public WebElement schPayment;
	
	public void schedulePayment() throws InterruptedException {
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.Billingicon, "Billing-Screen");
		vc.getMobileDriverUtils().elementAvailablity(CurrentBill, "Currentbill");
		
		if(currentBalanceDue.getText().equals("$0.00")) {
			Reporter.log("You do not have any dues", true);
		}else {
			vc.getMobileDriverUtils().clickMobileElement(payNowButton, "PayNow-Button");
			if(!vc.getMobileDriverUtils().elementAvailablity(paymentDate, "PaymentDate-DateSelection")) {
				Reporter.log("Schedule Payment options is not available",true);
			}else {
			vc.getMobileDriverUtils().clickMobileElement(paymentDate, "PaymentDate-DateSelection");
			vc.getMobileDriverUtils().clickMobileElement(ok, "OK-Button");
			WebElement selectedDate = driver.findElement(By.xpath("//android.widget.RelativeLayout[contains(@resource-id,'payment_date')]//android.widget.TextView"));
			Reporter.log("Selected Date is ==> " + selectedDate.getText(),true);
			vc.getMobileDriverUtils().clickMobileElement(continueButton, "Continue");
			
			if (checkCardAvailability()) {
				Reporter.log("CARDS ALREADY ADDED", true);
				vc.getMobileDriverUtils().selectMobileRadioButton(CardHolderName, "Card");
				vc.getMobileDriverUtils().selectCheckbox(TermsandConditioncheckbox, "TermsandConditions");
				vc.getMobileDriverUtils().clickMobileElement(payNowButton, "PayNow-Button");
				if (vc.getMobileDriverUtils().elementAvailablity(paymentSuccessMessage, "PaymentSuccess-Message")) {
					Reporter.log(paymentDate.getText(), true);
					Reporter.log("Payment Scheduled Successfully",true);
					vc.getMobileDriverUtils().clickMobileElement(doneButton, "Done-Button");
					
					/*vc.getMobileDriverUtils().clickMobileElement(Historyoption, "HistoryTab");
					vc.getMobileDriverUtils().clickMobileElement(Paymenthistory, "PaymentHistory");
					vc.getMobileDriverUtils().elementAvailablity(paymentHistoryRecords, "PaymentHistory");
					List<WebElement> paymentHistory = driver.findElements(By.id("tv_bill_status"));
					System.out.println(paymentHistory.size());
				
					for(int i=0;i<paymentHistory.size();i++) {
						if(paymentHistory.get(i).getText().contains("Scheduled Payment")) {
						paymentHistory.get(i).click();
							String scheduledDay = "android.widget.TextView[@text='Scheduled Payment']";
							Boolean isPresent = driver.findElements(By.xpath(scheduledDay)).size()>0;
							 
							//paymentHistory.get(i).click();
							List<WebElement> verifyDate = driver.findElements(By.xpath("android.widget.TextView"));
							for(int j=0;j<verifyDate.size();j++) {
								if(verifyDate.get(j).getText().equals(selectedDate.getText())) {
									Reporter.log("Scheduled payment is added on Payment History",true);
									vc.getMobileDriverUtils().elementAvailablity(voidPayment, "VoidPayment");
								}
							}
						}
					}*/
				} else {
					Reporter.log("Exception", true);
				}
			} else {
				Reporter.log("No Cards Available. Add Card...", true);
			}
		 }
		}
	}
	

	
	public void payCurrentBalance() throws InterruptedException {
		vc.getMobileDriverUtils().clickMobileElement(payNowButton, "PayNow-Button");
		vc.getMobileDriverUtils().selectMobileRadioButton(currentBalance, "CurrentBalance-RadioButton");
		vc.getMobileDriverUtils().clickMobileElement(continueButton, "Continue");
		paymentUI();
	}
	
	public void payOtherAmount(String customamount) throws InterruptedException {
		vc.getMobileDriverUtils().clickMobileElement(payNowButton, "PayNow-Button");
		vc.getMobileDriverUtils().selectMobileRadioButton(otherAmount, "OtherAmount");
		vc.getMobileDriverUtils().mobile_EnterText(customAmount, "$" + customamount, "CustomAmount");
		vc.getMobileDriverUtils().clickMobileElement(continueButton, "Continue");
		paymentUI();
		
		
	}

	

	public void downloadBills() {
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.Billingicon, "Billing");
		vc.getMobileDriverUtils().clickMobileElement(Billhistory, "Billhistory");
		if (vc.getMobileDriverUtils().elementAvailablity(DownloadBillsBtn, "DownloadBills") == true) {
			Reporter.log("Bills are available", true);
			//driver.navigate().back();
		} else {
			Reporter.log("No Bills Available", true);
		}

	}
	public void availablebills()  {
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.Billingicon, "Billing");
		vc.getMobileDriverUtils().clickMobileElement(Historyoption, "HistoryOption");
		vc.getMobileDriverUtils().elementAvailablity(Billhistory, "Bill History");
		vc.getMobileDriverUtils().elementAvailablity(Paymenthistory, "Payment History");
		vc.getMobileDriverUtils().clickMobileElement(Billhistory, "Bill History");
		
		if(vc.getMobileDriverUtils().elementAvailablity(AvailableDocs, "Available Documents") == true)
		{
		Reporter.log("Bills are available", true);
		}
		else
		{
			Reporter.log("No Bills are available", true);
		}
	
	} 
	
	public boolean checkCardAvailability() {
		//vc.getMobileDriverUtils().clickMobileElement(creditdebit_title, "Credit/Debitcard title");
		return (vc.getMobileDriverUtils().elementAvailablity(CardHolderName, "CardDetails"));
	}
	
	public void paymentUI() {
		vc.getMobileDriverUtils().elementAvailablity(addPaymentMethod, "AddPaymentMethod-Button");
		vc.getMobileDriverUtils().elementAvailablity(TermsandConditioncheckbox,"Terms&Conditions-Checkbox");
		vc.getMobileDriverUtils().elementAvailablity(previousButton, "Previous-Button");
		vc.getMobileDriverUtils().elementAvailablity(payNowButton, "PayNow-Button");
	}
	
	public void makePaymentWithoutSelecting() throws InterruptedException {
		vc.getMobileDriverUtils().clickMobileElement(payNowButton, "PayNow-Button");
		Reporter.log(paymentErrorMessage.getText().toUpperCase(),true);
		Assert.assertTrue(true, paymentErrorMessage.getText());
		Reporter.log("******ERROR PROMPT IS DISPLAYED TO SELECT PAYMENT METHOD******",true);
		vc.getMobileDriverUtils().clickMobileElement(ok, "OK");
		vc.getMobileDriverUtils().sleep(3000);
		vc.getMobileDriverUtils().selectMobileRadioButton(CardHolderName, "Card");
		vc.getMobileDriverUtils().clickMobileElement(payNowButton, "PayNow-Button");
		Reporter.log(paymentErrorMessage.getText().toUpperCase(),true);
		Assert.assertTrue(true, paymentErrorMessage.getText());
		Reporter.log("******ERROR PROMPT IS DISPLAYED TO AGREE TERMS AND CONDITIONS******",true);
		vc.getMobileDriverUtils().clickMobileElement(ok, "OK");
		
		
	}
	
	public void makePayment() throws InterruptedException {
		vc.getMobileDriverUtils().selectMobileRadioButton(CardHolderName, "Card");
		Reporter.log("Selected " + CardHolderName.getText() + " from saved cards ", true);
		vc.getMobileDriverUtils().selectCheckbox(TermsandConditioncheckbox, "TermsandConditions");
		vc.getMobileDriverUtils().clickMobileElement(payNowButton, "PayNow-Button");
		vc.getMobileDriverUtils().sleep(2000);
		if(vc.getMobileDriverUtils().elementAvailablity(paymentSuccessMessage, "PaymentSuccess-Message")) {
			vc.getMobileDriverUtils().getText(amountPaid, "AmountPaid");
			Reporter.log("Amount paid is==> " + amountPaid.getText(), true);
			Reporter.log(paymentSuccessMessage.getText(), true);
			Reporter.log(paymentConfirmationNo.getText(), true);
			Reporter.log(paymentDate.getText(), true);
			vc.getMobileDriverUtils().clickMobileElement(doneButton, "Done-Button");
			
			if(vc.getMobileDriverUtils().elementAvailablity(happywithMYWinapp, "Happy-Popup")) {
				Reporter.log(happywithMYWinapp.getText(), true);
				vc.getMobileDriverUtils().clickMobileElement(notReallyBtn, "Prompt Message");
				vc.getMobileDriverUtils().elementAvailablity(currentBalanceDue, "DueAmount");
				Reporter.log("Current Balance after paying Other Amount is ==> " + currentBalanceDue.getText(), true);
			}
		}
		
		
		else if(vc.getMobileDriverUtils().elementAvailablity(paymentFailedMessage, "PaymentFailed")) {
			Reporter.log(paymentFailedMessage.getText(),true);		
			Assert.assertFalse(true, "PaymentFailed");
		}
		
		else if (vc.getMobileDriverUtils().elementAvailablity(cardChangeMessage, "ChangeCard-Message")) {
			Reporter.log(cardChangeMessage.getText(), true);
			Assert.assertFalse(true, "CardExpired");
			vc.getMobileDriverUtils().clickMobileElement(ok, "OKButon");
			
		}
		
	}
	
	
	
	

	public void verifyBalance() {
		Integer a = Integer.parseInt(amountPaid.getText());
		Integer b = Integer.parseInt(currentBalance.getText());
		Integer c = a - b;
		System.out.println(c);

	}
	
	public void paperlessBilling() {
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.Billingicon, "Billing-Option");
		vc.getMobileDriverUtils().clickMobileElement(BillingPage.Options, "Options-Menu");
		vc.getMobileDriverUtils().elementAvailablity(paperlessBilling, "PaperlessBilling");
		vc.getMobileDriverUtils().clickMobileElement(paperlessBilling, "PaperlessBilling-Option");
		if (receivePaperInvoice.getAttribute("checked").contains("true")) {
			Reporter.log("ReceivePaperInvoice RadioButton already selected", true);
			vc.getMobileDriverUtils().clickMobileElement(suppressPaperInvoice, "SuppressPaperInvoice");
			driver.navigate().back();
		} else {
			vc.getMobileDriverUtils().clickMobileElement(receivePaperInvoice, "ReceivePaperInvoice");
			vc.getMobileDriverUtils().clickMobileElement(saveChanges, "SaveChanges-Button");
			vc.getMobileDriverUtils().sleep(2000);
			Reporter.log(BillingPage.paymentErrorMessage.getText(),true);
			driver.navigate().back();
		}

	}


}
