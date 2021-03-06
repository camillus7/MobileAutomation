package com.mobile.WeConnect.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.mobile.MyWin.pageobject.MyWinMobile_BillingPage;
import com.mobile.MyWin.pageobject.MyWinMobile_LandingPage;
import com.mobile.MyWin.pageobject.MyWinMobile_ManagePaymentMethodPage;
import com.webautomation.validation.Validator;

public class WeConnect_BillingPage {

	final WebDriver driver;
	private Validator vc;
	

	public WeConnect_BillingPage(WebDriver driver) {
		this.driver = driver;
		this.vc = new Validator(driver);
	}
	
	@FindBy(id = "label_payment_accounts")
	public WebElement billingtitle;
	
	@FindBy(id="filter_icon")
	public WebElement filtericon;
	
	@FindBy(id="amount_sort")
	public WebElement sortByAmount;
	
	@FindBy(id="account_sort")
	public WebElement sortByAccount;
	
	@FindBy(id="date_sort")
	public WebElement sortByDueDate;
	
	@FindBy(id="text_big_price")
	public WebElement currentBalanceDue;
		
	@FindBy(xpath = "//android.widget.TextView[@text='Current Bill']")
	public static WebElement currentBillTitle;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Current Bill']")
	public static WebElement currentBillTab;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Invoices']")
	public static WebElement invoicesTab;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Options']")
	public static WebElement optionsTab;
	
	@FindBy(id = "txt_account_id")
	public WebElement accountid;
	
	@FindBy(id = "text_big_price")
	public WebElement amountDue;
	
	
	
	
	public String billTitle, billValues,dueamount;
	public String billDate;
	
	 

	public boolean validateCreditCard(String cardNo) throws InterruptedException {

		boolean cardAvailability = false;
		vc.getMobileDriverUtils().elementAvailablity(cardholderName, "ManagePaymentMethod-Screen");
		Reporter.log("Validating "+ cardNo + "is deleted or not",true);
		List<WebElement> cardHolderNames = driver.findElements(By.className("android.widget.TextView"));
		for (int i = 0; i < cardHolderNames.size(); i++) {
			String list = cardHolderNames.get(i).getText();	
			int ilen = cardNo.length();
			String cNum = cardNo.substring(ilen - 4, ilen);
			if (list.contains(cNum)) {
				cardAvailability = true;
				break;		
			} else {
				cardAvailability = false;
			}
		}
		return cardAvailability;
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Billing']")
	public  WebElement billingMenu;
	
	@FindBy(id = "account_number")
	public WebElement accountNumber;
	
	@FindBy(id = "amount_due")
	public WebElement dueAmount;
	
	public void makePaymentAmount(String cardNo) throws InterruptedException {
		vc.getMobileDriverUtils().clickMobileElement(billingMenu, "Billing-Screen");
		noBillingAccount();
		if(vc.getMobileDriverUtils().elementAvailablity(accountNumber, "AccountDetails")) {
			Reporter.log("Accounts available",true);
			String text = dueAmount.getText();
			Reporter.log("TOTAL AMOUNT DUE IS ====> " + text ,true);
			if(text.equals("$0.00")) {
				Reporter.log("You do not have any dues", true);
			}else {
				payOtherAmount();
				if(checkCardAvailability()) {
					Reporter.log("CARDS ALREADY ADDED", true);
				//	makePaymentWithoutSelecting();
					makePayment();
					
				}else {
					Reporter.log("No Cards Available. Adding Card...", true);
					addElectronicCheck(cardNo);
					if (validateCreditCard(cardNo)) {
						Reporter.log(cardNo + " credit/Debit Card is Successfully added",true);
						makePayment();
					}else {
						Reporter.log("Card is not added",true);
					}
					
				}
			}
		}else {
			Reporter.log("Accounts not available",true);
		}
		
		
	}
	
	@FindBy(id = "other_amount")
	public WebElement otherAmount;
	
	@FindBy(id="custom_amount")
	public WebElement customAmount;
	
	@FindBy(id = "next")
	public WebElement nextbtn;
	
	public void payOtherAmount() throws InterruptedException {
		Reporter.log("Account Number to be selected is " + accountNumber.getText() ,true);
		vc.getMobileDriverUtils().clickMobileElement(accountNumber, "Account");
		vc.getMobileDriverUtils().clickMobileElement(payNowButton, "PayNow-Button");
		vc.getMobileDriverUtils().selectMobileRadioButton(otherAmount, "OtherAmount");
		vc.getMobileDriverUtils().mobile_EnterText(customAmount, "1", "CustomAmount");
		vc.getMobileDriverUtils().clickMobileElement(nextbtn, "NextButton");
	}
	
	@FindBy(id="amount")
	public WebElement amountPaid;
	
	@FindBy(id="confirmation")
	public WebElement paymentConfirmationNo;
	
	@FindBy(xpath = "//android.widget.Button[@text='NEXT']")
	public  WebElement nextbutton;
	
	@FindBy(xpath = "//android.widget.Button[@text='Submit Payment']")
	public  WebElement submitButton;
	
	@FindBy(id="current_balance")
	public WebElement enteredAmount;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Current Bill']")
	public WebElement CurrentBill;
	
	@FindBy(xpath="//android.widget.TextView[@text='Enjoying the MyWin app?']")
	public WebElement happywithMYWinapp; 
	
	@FindBy(id="sad")
	public WebElement sadSmiley;
	
	@FindBy(id="happy")
	public WebElement happySmiley;
	
	@FindBy(id = "edt_comments")
	public WebElement feedbackComments;
	
	@FindBy(id = "rb_feedback")
	public WebElement feedbackStar;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Payment Failed. Please try again later.']")
	public WebElement paymentFailedMessage;
	
	@FindBy(id="message")
	public WebElement cardChangeMessage;
	
	
	public void makePayment() throws InterruptedException {
		vc.getMobileDriverUtils().selectMobileRadioButton(cardholderName, "Card");
		Reporter.log("Selected " + cardholderName.getText() + " from saved cards ", true);
		vc.getMobileDriverUtils().clickMobileElement(nextbutton, "Next-Button");
		vc.getMobileDriverUtils().selectCheckbox(termsCheckbox, "TermsandConditions");
		vc.getMobileDriverUtils().clickMobileElement(submitButton, "SubmitPayment-Button");
		vc.getMobileDriverUtils().sleep(2000);
		if (vc.getMobileDriverUtils().elementAvailablity(paymentSuccessMessage, "PaymentSuccess-Message")) {
			/*Reporter.log(amountPaid.getText().toUpperCase(), true);
			Reporter.log(paymentSuccessMessage.getText(), true);
			Reporter.log(paymentConfirmationNo.getText(), true);
			Reporter.log(paymentDate.getText(), true);*/
			vc.getMobileDriverUtils().clickMobileElement(doneButton, "Done-Button");

			if (vc.getMobileDriverUtils().elementAvailablity(CurrentBill, "BillingScreen")) {
				Reporter.log("Current Balance after paying Other Amount is ==> " + currentBalanceDue.getText(), true);
			}

			else if (vc.getMobileDriverUtils().elementAvailablity(happywithMYWinapp, "Happy-Popup")) {
				Reporter.log(happywithMYWinapp.getText(), true);
				vc.getMobileDriverUtils().clickMobileElement(sadSmiley, "Prompt Message");

				if (vc.getMobileDriverUtils().elementAvailablity(feedbackComments, "FeedBackScreen")) {
					vc.getMobileDriverUtils().mobile_EnterText(feedbackComments, "Test", "Comments");
					vc.getMobileDriverUtils().clickMobileElement(feedbackStar, "FeedbackStars");
					driver.navigate().back();
					vc.getMobileDriverUtils().clickMobileElement(submitButton, "Submit-Button");
					driver.navigate().back();
					vc.getMobileDriverUtils().clickMobileElement(doneButton, "Done-Button");
					Reporter.log("Current Balance after paying Other Amount is ==> " + currentBalanceDue.getText(),
							true);
				} else {
					vc.getMobileDriverUtils().elementAvailablity(currentBalanceDue, "DueAmount");
					Reporter.log("Current Balance after paying Other Amount is ==> " + currentBalanceDue.getText(),
							true);
				}

			}
		} else if (vc.getMobileDriverUtils().elementAvailablity(paymentFailedMessage, "PaymentFailed")) {
			Reporter.log(paymentFailedMessage.getText(), true);
			Assert.assertFalse(true, "PaymentFailed");
		}

		else if (vc.getMobileDriverUtils().elementAvailablity(cardChangeMessage, "ChangeCard-Message")) {
			Reporter.log(cardChangeMessage.getText(), true);
			Assert.assertFalse(true, "CardExpired");
		} else {
			Reporter.log("Something Went Wrong", true);
		}
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Manage Payment Methods ']")
	public WebElement managePaymentmethod;

	@FindBy(xpath = "//android.widget.TextView[@text='Manage AutoPay ']") 
	public WebElement manageAutoPay;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Options']")
	public WebElement Options;
	
	@FindBy(xpath = "//android.widget.TextView[@text='You are not Enrolled in AutoPay']")
	public WebElement notEnrolledAutopay;
	
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

	@FindBy(xpath = "//android.widget.TextView[@text='Your AutoPay has been successfully updated.']")
	public WebElement confirmationMessage;
	
	@FindBy(id = "auto_pay_status")
	public WebElement autopayStatus;
	
	@FindBy(id = "done")
	public WebElement doneButton;
	
	@FindBy(id = "deenroll")
	public WebElement deenrollBtn;
	
	@FindBy(id = "title")
	public WebElement autoPayText;
	
	@FindBy(id="com.windstream.enterprise.we.dev:id/id_option_txt")
	public List<WebElement> optionsext;
	
	public void enrollAutoPay() throws InterruptedException {
		vc.getMobileDriverUtils().clickMobileElement(billingMenu, "Billing-Screen");
		noBillingAccount();
		vc.getMobileDriverUtils().clickMobileElement(accountNumber, "Account");
		vc.getMobileDriverUtils().clickMobileElement(Options, "Options");
		vc.getMobileDriverUtils().elementAvailablity(managePaymentmethod, "ManagePaymentMethod");
		vc.getMobileDriverUtils().elementAvailablity(manageAutoPay, "ManageAutoPay");
		
		vc.getMobileDriverUtils().clickMobileElement(manageAutoPay, "ManageAutopay");
		vc.getMobileDriverUtils().elementAvailablity(paymentOptionDropdown, "ManageAutoPay-Screen");
		if (vc.getMobileDriverUtils().elementAvailablity(notEnrolledAutopay, "NotEnrolledInAutopay")) {
			Reporter.log(notEnrolledAutopay.getText(), true);
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
			//	vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.ok, "OK");

				if (vc.getMobileDriverUtils().elementAvailablity(confirmationMessage,
						"AutoPayEnrolled-SuccessMessage")) {
					Reporter.log(autopayStatus.getText(), true);
					vc.getMobileDriverUtils().clickMobileElement(doneButton, "Done - Button");
					vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.Options, "Options");
					vc.getMobileDriverUtils().clickMobileElement(manageAutoPay, "ManageAutoPay");
					vc.getMobileDriverUtils().elementAvailablity(deenrollBtn, "Deenroll");
					/*vc.getMobileDriverUtils().elementAvailablity(paymentOptionDropdown, "ManageAutoPay-Screen");
					vc.getMobileDriverUtils().elementAvailablity(autoPayText, "AutoPay-Status");
					vc.getMobileDriverUtils().elementAvailablity(noLimitRadioBtn, "RadioButton");*/
					Assert.assertEquals(autoPayText.getText(), "You are Enrolled in AutoPay");
					Reporter.log(autoPayText.getText(), true);
					driver.navigate();

				} else {
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
	
	@FindBy(id = "button1")
	public WebElement CancelAutoPayYes;
	
	public void deenrollAutoPay() {
		vc.getMobileDriverUtils().clickMobileElement(billingMenu, "Billing-Screen");
		noBillingAccount();
		vc.getMobileDriverUtils().clickMobileElement(accountNumber, "Account");
		vc.getMobileDriverUtils().clickMobileElement(Options, "Options");
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
		
	@FindBy(xpath = "//android.widget.TextView[@text='No billing accounts found.']")
	public WebElement noBillingAccount;
	
	public void getDueAmount() throws InterruptedException {
		vc.getWebDriverUtils().clickMobileElement(billingMenu, "Billing-Screen");
		vc.getWebDriverUtils().elementAvailablity(billingtitle, "Billing-Title");	
		noBillingAccount();
			String dueAmount_Billing = vc.getMobileDriverUtils().getText(dueAmount, "CurrentBalanceDue");
			Reporter.log("TOTAL AMOUNT DUE IN BILLING SCREEN IS  ====> " + dueAmount_Billing, true);
			vc.getMobileDriverUtils().clickMobileElement(accountNumber, "Account");
			String dueAmount_CurrentBill = currentBalanceDue.getText();
			Reporter.log("TOTAL AMOUNT DUE IS IN PAYMENT SCREEN IS====> " + dueAmount_CurrentBill, true);
			Assert.assertEquals(dueAmount_Billing, dueAmount_CurrentBill, "DueAmount is not same");
			Reporter.log("Dueamount is same in Billing and in Payment Screen", true);
		

	}

	public boolean noBillingAccount(){
		boolean accountAvailablity = false;
		if(vc.getMobileDriverUtils().elementAvailablity(accountNumber, "BillingAccount-Number")) {
			accountAvailablity = true;
			Reporter.log("Billing Account is Available",true);
			
		}else {
			accountAvailablity = false;
			Reporter.log(noBillingAccount.getText().toUpperCase(), true);
			Assert.assertFalse(true);
		}
		return accountAvailablity;
				
	}
	@FindBy(xpath = "//android.widget.TextView[@text='Add Payment Method']")
	public WebElement addPaymentMethodButton;
	
	@FindBy(id = "check")
	public WebElement optionsBlock;
	
	@FindBy(xpath = "//android.view.View[@text='ELECTRONIC CHECK']")
	public WebElement electronicCheckOption;

	@FindBy(xpath = "//android.view.View[@text='DEBIT/CREDIT CARD']")
	public WebElement debitCreditCardOption;

	@FindBy(id = "new_BankAccountType")
	public WebElement BankAccountType;

	@FindBy(id = "new_PayeeLastName")
	public WebElement PayeeLastName;

	@FindBy(id = "new_PayeeFirstName")
	public WebElement PayeeFirstName;

	@FindBy(id = "new_BankRoutingNumber")
	public WebElement BankRoutingNumber;

	@FindBy(id = "new_BankAccountNumber")
	public WebElement BankAccountNumber;

	@FindBy(id = "new_ecZip")
	public WebElement ZipCode;

	@FindBy(xpath = "//android.view.View[@text='Add Check']")
	public WebElement addCheckButton;
	
	@FindBy(id = "AddECSubmit")
	public WebElement addCheckButton1;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Unable to communicate with server']")
	public WebElement serverError;
	
	@FindBy(id = "name")
	public WebElement cardholderName;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Delete']")
	public WebElement Delete;
	
	@FindBy(id = "NewECError")
	public WebElement addPaymentErrorMessage;
	
	public void addElectronicCheck(String Cardnum) throws InterruptedException {
		vc.getMobileDriverUtils().clickMobileElement(billingMenu, "Billing-Screen");
		noBillingAccount();
		vc.getMobileDriverUtils().clickMobileElement(accountNumber, "Account");
		vc.getMobileDriverUtils().clickMobileElement(Options, "Options");
		vc.getMobileDriverUtils().clickMobileElement(managePaymentmethod, "ManagePaymentmethod");
		vc.getMobileDriverUtils().elementAvailablity(addPaymentMethodButton, "AddPaymentMethod");
		vc.getMobileDriverUtils().clickMobileElement(addPaymentMethodButton, "AddPaymentMethod");
		vc.getMobileDriverUtils().elementAvailablity(optionsBlock, "PaymentType");
		vc.getMobileDriverUtils().selectMobileRadioButton(electronicCheckOption, "ElectronicCheck-Option");
		vc.getMobileDriverUtils().mobile_EnterText(PayeeLastName, "LastName", "LastName");
		vc.getMobileDriverUtils().mobile_EnterText(PayeeFirstName, "FirstName", "FirstName");
		driver.navigate().back();
		vc.getMobileDriverUtils().mobile_EnterText(BankRoutingNumber, "061119888", "RoutingNo");
		driver.navigate().back();
		vc.getMobileDriverUtils().mobile_EnterText(BankAccountNumber, Cardnum, "AccountNumber");
		driver.navigate().back();
		vc.getMobileDriverUtils().mobile_EnterText(ZipCode, "11111", "ZipCode");
		driver.navigate().back();
		vc.getMobileDriverUtils().elementAvailablity(addCheckButton, "Add Check button");
		vc.getMobileDriverUtils().sleep(2000);
		vc.getMobileDriverUtils().clickMobileElement(addCheckButton1, "AddCheck-Button");
		vc.getMobileDriverUtils().clickMobileElement(addCheckButton, "AddCheck-Button");
		vc.getMobileDriverUtils().elementAvailablity(cardholderName, "ManagePaymentMethod-Screen");
	}
	
	
	public void addAnddeleteElectonicCheck(String Cardnum) throws InterruptedException {

		addElectronicCheck(Cardnum);

		if (vc.getMobileDriverUtils().validateCreditCard(Cardnum)) {
			Reporter.log("Electronic check is Successfully added", true);
			vc.getMobileDriverUtils().elementAvailablity(cardholderName, "ManagePaymentMethod-Screen");
			int ilen = Cardnum.length();
			String cNum = Cardnum.substring(ilen - 4, ilen);
			Reporter.log("Added Electronic check is " + cNum, true);
			WebElement MoreBtn = driver
					.findElement(By.xpath("//android.widget.TextView[@text='********" + cNum + "']"));
			vc.getMobileDriverUtils().clickMobileElement(MoreBtn, "More Button");
			vc.getMobileDriverUtils().clickMobileElement(Delete, "More -> Delete Button");
			vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.ok, "OK");
			vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.ok, "OK");
			vc.getMobileDriverUtils().sleep(2000);

			if (vc.getMobileDriverUtils().validateCreditCard(Cardnum)) {
				Assert.assertFalse(true, Cardnum + " Deleting card Failed");
			} else {
				Reporter.log(Cardnum + " ElectronicCheck Deleted Successfully", true);

			}

		} else if (addPaymentErrorMessage.getText().contains("Electronic Check already exists for the account!")) {
			Reporter.log(addPaymentErrorMessage.getText().toUpperCase(), true);
			Reporter.log("PLEASE ADD NEW ELECTRONIC CHECK ACCOUNT", true);
		} else if (vc.getMobileDriverUtils().elementAvailablity(addPaymentErrorMessage,
				"AddPaymentAlert-Message") == true) {
			Reporter.log(addPaymentErrorMessage.getText(), true);
			Assert.assertFalse(true, "Adding ElectronicCheck  Failed");

		} else {
			Reporter.log("Adding ElectronicCheck Failed", true);
			Assert.assertFalse(true);

		}
	}
	
	
	@FindBy(id = "new_ccNumber")
	public WebElement cardNumber;

	@FindBy(xpath = "//android.widget.Spinner[@text='MM']")
	public WebElement expiryMonth;

	@FindBy(xpath = "//android.widget.Spinner[@text='YYYY']")
	public WebElement expiryYear;
	
	@FindBy(id = "new_ccCVV2")
	public WebElement cvvNumber;

	@FindBy(id = "new_ccZip")
	public WebElement cardZipCode;

	@FindBy(id = "addNewCCSubmit")
	public WebElement addCardButton;

	@FindBy(xpath = "//android.view.View[@text='Add Card']")
	public WebElement AddCard;

	@FindBy(id = "NewCCError")
	public WebElement addCardErrorMessage;
	
	@FindBy(xpath="//android.widget.CheckedTextView")
	public List<WebElement> yearMonthDd;

	
	public void selectDropdown(WebElement element, String dropdownName, String dropdownValue) {
		vc.getMobileDriverUtils().clickMobileElement(element, dropdownName);
		List<WebElement> ccDropdown = driver.findElements(By.className("android.widget.CheckedTextView"));
		for (int i = 0; i < ccDropdown.size(); i++) {
			if (ccDropdown.get(i).getText().contains(dropdownValue)) {
				ccDropdown.get(i).click();
				Reporter.log("Selected == " + dropdownValue + "from " + dropdownName, true);
				break;
			}

		}
	}
	
	public void addCreditCard(String cardNo) throws InterruptedException {

		vc.getMobileDriverUtils().clickMobileElement(billingMenu, "Billing-Screen");
		noBillingAccount();
		vc.getMobileDriverUtils().clickMobileElement(accountNumber, "Account");
		vc.getMobileDriverUtils().clickMobileElement(Options, "Options");
		vc.getMobileDriverUtils().clickMobileElement(managePaymentmethod, "ManagePaymentmethod");
		vc.getMobileDriverUtils().elementAvailablity(addPaymentMethodButton, "AddPaymentMethod");
		vc.getMobileDriverUtils().clickMobileElement(addPaymentMethodButton, "AddPaymentMethod");
		vc.getMobileDriverUtils().elementAvailablity(optionsBlock, "PaymentType");
		vc.getMobileDriverUtils().selectMobileRadioButton(debitCreditCardOption, "CreditCard-Option");
		vc.getMobileDriverUtils().mobile_EnterText(cardNumber, cardNo, "Card Number");
		driver.navigate().back();
		selectDropdown(expiryMonth, "ExpiryMonthDropdown", "04");
		selectDropdown(expiryYear, "ExpiryYearDropdown", "2020");
		vc.getMobileDriverUtils().mobile_EnterText(cvvNumber, "744", "Cvv");
		driver.navigate().back();
		vc.getMobileDriverUtils().mobile_EnterText(cardZipCode, "24577", "Zipcode");
		vc.getMobileDriverUtils().elementAvailablity(AddCard, "Add Card Button");
		vc.getMobileDriverUtils().clickMobileElement(addCardButton, "AddCard-Button");
		vc.getMobileDriverUtils().clickMobileElement(addCardButton, "AddCard-Button");
	}

	public void addDebit_CreditCard(String cardNo) throws InterruptedException {
	
		addCreditCard(cardNo);
					
			if (vc.getMobileDriverUtils().validateCreditCard(cardNo)) {
				Reporter.log(cardNo + " credit/Debit Card is Successfully added",true);
				vc.getMobileDriverUtils().elementAvailablity(cardholderName, "ManagePaymentMethod-Screen");
				int ilen = cardNo.length();
				String cNum = cardNo.substring(ilen - 4, ilen);
				Reporter.log(cNum, true);
				WebElement MoreBtn=driver.findElement(By.xpath("//android.widget.TextView[@text='XXXXXXXXXXXX"+cNum+"']"));
				vc.getMobileDriverUtils().clickMobileElement(MoreBtn, "More Button");
				vc.getMobileDriverUtils().sleep(2000);
				vc.getMobileDriverUtils().clickMobileElement(Delete, "More -> Delete Button");
				//vc.getMobileDriverUtils().clickMobileElement(DelDelete, "Delete Button");
				vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.ok, "OK");
				vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.ok, "OK");
				vc.getMobileDriverUtils().sleep(2000);
				if(vc.getMobileDriverUtils().validateCreditCard(cardNo)) {
					Assert.assertFalse(true, cardNo + "Deleting card Failed");
				} else {
					Reporter.log(cardNo + " Card Deleted Successfully", true);

				}
		
		} else if (vc.getMobileDriverUtils().elementAvailablity(addCardErrorMessage,
				"AddPaymentAlert-Message") == true) {
			Reporter.log(addCardErrorMessage.getText(), true);
			Assert.assertFalse(true, "Adding Credit/Debit Card Failed");

		} else {
			Reporter.log("Adding Credit/Debit card Failed", true);
			Assert.assertFalse(true);
			
		}
	}
	
	public boolean checkCardAvailability() {
		return (vc.getMobileDriverUtils().elementAvailablity(cardDetails, "CardDetails"));
	}

	@FindBy(id = "btn_pay_now")
	public WebElement payNowButton;
	
	@FindBy(id = "payment_date")
	public WebElement paymentDate;
	
	@FindBy(id="button1")
	public WebElement ok;
	
	@FindBy(id = "btn_pay_now")
	public WebElement continueButton;
	
	@FindBy(xpath="//android.widget.TextView[@text='Payment Successful']")
	public WebElement paymentSuccessMessage;
	
	
	public void schedulePayment() throws InterruptedException {
		vc.getMobileDriverUtils().clickMobileElement(billingMenu, "Billing-Screen");
		noBillingAccount();
		if (vc.getMobileDriverUtils().elementAvailablity(accountNumber, "AccountDetails")) {
			String text = dueAmount.getText();
			if (text.equals("$0.00")) {
				Reporter.log("You do not have any dues", true);
			} else {
				vc.getMobileDriverUtils().clickMobileElement(accountNumber, "Account");
				vc.getMobileDriverUtils().clickMobileElement(payNowButton, "PayNow-Button");
				if (!vc.getMobileDriverUtils().elementAvailablity(paymentDate, "PaymentDate-DateSelection")) {
					Reporter.log("Schedule Payment options is not available", true);
				} else {
					vc.getMobileDriverUtils().clickMobileElement(paymentDate, "PaymentDate-DateSelection");
					vc.getMobileDriverUtils().clickMobileElement(ok, "OK-Button");
					WebElement selectedDate = driver.findElement(By.xpath(
							"//android.widget.RelativeLayout[contains(@resource-id,'payment_date')]//android.widget.TextView"));
					Reporter.log("Selected Date is ==> " + selectedDate.getText(), true);
					vc.getMobileDriverUtils().clickMobileElement(continueButton, "Continue");

					if (checkCardAvailability()) {
						Reporter.log("CARDS ALREADY ADDED", true);
						vc.getMobileDriverUtils().selectMobileRadioButton(cardholderName, "Card");
						vc.getMobileDriverUtils().selectCheckbox(termsCheckbox, "TermsandConditions");
						vc.getMobileDriverUtils().clickMobileElement(payNowButton, "PayNow-Button");
						if (vc.getMobileDriverUtils().elementAvailablity(paymentSuccessMessage,
								"PaymentSuccess-Message")) {
							Reporter.log(paymentDate.getText(), true);
							Reporter.log("Payment Scheduled Successfully", true);
							vc.getMobileDriverUtils().clickMobileElement(doneButton, "Done-Button");

						} else {
							Reporter.log("Exception", true);
						}
					} else {
						Reporter.log("No Cards Available. Add Card...", true);
					}
				}
			}
		} else {
			Reporter.log("Accounts not available", true);
		}
	}

}
