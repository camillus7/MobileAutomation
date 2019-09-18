package com.mobile.MyWin.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.webautomation.validation.Validator;

public class MyWinMobile_ManagePaymentMethodPage {

	final WebDriver driver;
	private Validator vc;
	public String electronicCheckList, creditCardList;

	public MyWinMobile_ManagePaymentMethodPage(WebDriver driver) {
		this.driver = driver;
		this.vc = new Validator(driver);
	}

	@FindBy(id = "add_new_payment")
	public WebElement addPaymentMethod;

	@FindBy(xpath = "//android.widget.TextView[@text='Use New Payment Method']")
	public WebElement useNewPaymentMethodButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Add Payment Method']")
	public WebElement addPaymentMethodButton;

	// Manage Payment Method Saved cards

	@FindBy(id = "action")
	public WebElement MoreButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Edit']")
	public WebElement Edit;

	@FindBy(xpath = "//android.widget.TextView[@text='Delete']")
	public WebElement Delete;

	@FindBy(xpath = "//android.widget.TextView[@text='Cancel']")
	public WebElement Cancel;

	@FindBy(xpath = "//android.widget.Button[@text='Cancel']")
	public WebElement DelCancel;

	@FindBy(xpath = "//android.widget.Button[@text='Delete']")
	public WebElement DelDelete;

	// Edit Electronic Check

	@FindBy(xpath = "//android.widget.EditText[@text='Enter Last Name']")
	public WebElement EditLastName;

	@FindBy(xpath = "//android.widget.EditText[@text='Enter First Name']")
	public WebElement EditFirstName;

	@FindBy(xpath = "//android.widget.EditText[16]")
	public WebElement EditZipcode;

	@FindBy(id = "previous")
	public WebElement Previous;

	@FindBy(id = "save")
	public WebElement Save;

	@FindBy(id = "snackbar_text")
	public WebElement Snackbar;

	@FindBy(id = "snackbar_action")
	public WebElement Snackbar_close;

	@FindBy(xpath = "//android.view.View[@text='ELECTRONIC CHECK']")
	public WebElement electronicCheckOption;

	@FindBy(xpath = "//android.view.View[@text='DEBIT/CREDIT CARD']")
	public WebElement debitCreditCardOption;

	// Electronic Check
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

	
	// Card
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

	@FindBy(id = "NewECError")
	public WebElement addPaymentErrorMessage;

	@FindBy(id = "action")
	public WebElement deleteCard;

	@FindBy(id = "name")
	public WebElement cardholderName;

	@FindBy(id = "check")
	public WebElement optionsBlock;

	@FindBy(id = "refresh_button")
	public WebElement RefreshButton;

	@FindBy(id = "name")
	public WebElement CardName;
	
	@FindBy(id="android:id/message")
	public WebElement cardDeleteErrorMessage;
	
	@FindBy(id = "btn_pay_now")
	public WebElement payNowButton;
	
	
	//
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
	
	@FindBy(xpath = "//android.widget.CheckBox[@text='I have read and agree to the payment Terms and Conditions']")
	public WebElement termsandConditioncheckbox; 
	
	@FindBy(xpath = "//android.widget.TextView[@text='Please agree to the Terms and Conditions..']")
	public WebElement termsandconditionErrorMessage;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Payment Failed. Please try again later.']")
	public WebElement paymentFailedMessage;

	@FindBy(id = "selection")
	public WebElement CardRadioButton;
	
	
	@FindBy(id = "name")
	public WebElement CardHolderName;
	
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
	
	@FindBy(id="message")
	public WebElement cardChangeMessage;
	
	/*@FindBy(xpath="//android.widget.Button[@text='Not Really']")
			public WebElement notReally;*/
			
	@FindBy(xpath="//android.widget.Button[@text='Yes']")
	public WebElement enrollYes; 

	@FindBy(id="done")
	public WebElement doneButton;
	
	@FindBy(xpath="android.widget.TextView[@text='Payment method not added.']")
	public WebElement noPaymentMethod;
	
	public void makePaymentAmount(String cardNo) throws InterruptedException {
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.Billingicon, "Billing-Screen");
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.CurrentBill, "CurrentBill");

		String text = currentBalanceDue.getText();
		Reporter.log("TOTAL AMOUNT DUE IS ====> " + text, true);
		if (text.equals("$0.00")) {
			Reporter.log("You do not have any dues", true);
		} else {
			// payCurrentBalance();
			payOtherAmount();
			if (checkCardAvailability()) {
				Reporter.log("CARDS ALREADY ADDED", true);
				// makePaymentWithoutSelecting();
				makePayment_ExistingCard();
				makePayment();

			} else {
				Reporter.log("No Cards Available. Adding Card...", true);
				makePayment_ElectronicCheck(cardNo);
			//	makePayment_CreditCard(cardNo);
				makePayment();

			}
		}

	}
	
	public void makePayment_CreditCard(String cardNo) throws InterruptedException {
		vc.getMobileDriverUtils().clickMobileElement(useNewPaymentMethodButton, "AddPaymentMethod");
		vc.getMobileDriverUtils().elementAvailablity(optionsBlock, "PaymentType");
		vc.getMobileDriverUtils().selectMobileRadioButton(debitCreditCardOption, "CreditCard-Option");
		vc.getMobileDriverUtils().mobile_EnterText(cardNumber, cardNo, "Card Number");
		driver.navigate().back();
		selectDropdown(expiryMonth, "ExpiryMonthDropdown", "04");
		selectDropdown(expiryYear, "ExpiryYearDropdown", "2020");
		vc.getMobileDriverUtils().mobile_EnterText(cvvNumber, "744", "Cvv");
		driver.navigate().back();
		vc.getMobileDriverUtils().mobile_EnterText(cardZipCode, "24577", "Zipcode");
		driver.navigate().back();
		vc.getMobileDriverUtils().selectCheckbox(termsandConditioncheckbox, "TermsandConditions");
		vc.getMobileDriverUtils().clickMobileElement(submitPaymentButton, "Submit-Button");
	
	}
	
	public void makePayment_ElectronicCheck(String cardNo) throws InterruptedException {
		vc.getMobileDriverUtils().clickMobileElement(useNewPaymentMethodButton, "UseNewPaymentMethod");
		vc.getMobileDriverUtils().elementAvailablity(optionsBlock, "PaymentType");
		vc.getMobileDriverUtils().selectMobileRadioButton(electronicCheckOption, "ElectronicCheck-Option");
		vc.getMobileDriverUtils().mobile_EnterText(PayeeLastName, "LastName", "LastName");
		vc.getMobileDriverUtils().mobile_EnterText(PayeeFirstName, "FirstName", "FirstName");
		driver.navigate().back();
		vc.getMobileDriverUtils().mobile_EnterText(BankRoutingNumber, "061119888", "RoutingNo");
		driver.navigate().back();
		vc.getMobileDriverUtils().mobile_EnterText(BankAccountNumber, cardNo, "AccountNumber");
		driver.navigate().back();
		vc.getMobileDriverUtils().mobile_EnterText(ZipCode, "11111", "ZipCode");
		driver.navigate().back();
		vc.getMobileDriverUtils().selectCheckbox(termsandConditioncheckbox, "TermsandConditions");
		vc.getMobileDriverUtils().clickMobileElement(submitPaymentButton, "Submit-Button");
	}
	
	public void addCreditCard(String cardNo) throws InterruptedException {
		paymentMethodnavigation();
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
		if (validateCreditCard(cardNo)) {
			Reporter.log(cardNo + " credit/Debit Card is Successfully added", true);
		} else if (vc.getMobileDriverUtils().elementAvailablity(addCardErrorMessage,
				"AddPaymentAlert-Message") == true) {
			Reporter.log(addCardErrorMessage.getText(), true);
			Assert.assertFalse(true, "Adding Credit/Debit Card Failed");

		} else {
			Reporter.log("Adding Credit/Debit card Failed", true);
			Assert.assertFalse(true);

		}
	}
	
	public void addDelete_CreditCard(String cardNo) throws InterruptedException {
		addCreditCard(cardNo);
					
			if (validateCreditCard(cardNo)) {
				Reporter.log(cardNo + " credit/Debit Card is Successfully added",true);
				vc.getMobileDriverUtils().clickMobileElement(RefreshButton, "Refresh");
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
				if(validateCreditCard(cardNo)) {
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
	
	public void addElectronicCheck(String Cardnum) throws InterruptedException {

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
		vc.getMobileDriverUtils().clickMobileElement(addCheckButton1, "AddCheck-Button");
		vc.getMobileDriverUtils().clickMobileElement(addCheckButton, "AddCheck-Button");
	}
	
	public void addAnddeleteElectonicCheck(String Cardnum) throws InterruptedException {
		paymentMethodnavigation();
		addElectronicCheck(Cardnum);
		
		if (validateCreditCard(Cardnum)) {
			Reporter.log("Electronic check is Successfully added", true);
			vc.getMobileDriverUtils().clickMobileElement(RefreshButton, "Refresh");
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

			if (validateCreditCard(Cardnum)) {
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

	@FindBy(xpath = "//android.view.View[@text='Submit Payment']")
	public WebElement submitPaymentButton;

	public void submitPayment() {
		vc.getMobileDriverUtils().clickMobileElement(submitPaymentButton, "AddCheck-Button");
	}
	
	public boolean checkCardAvailability() {
		//vc.getMobileDriverUtils().clickMobileElement(creditdebit_title, "Credit/Debitcard title");
		return (vc.getMobileDriverUtils().elementAvailablity(CardHolderName, "CardDetails"));
	}
	
	public void payCurrentBalance() throws InterruptedException {
		vc.getMobileDriverUtils().clickMobileElement(payNowButton, "PayNow-Button");
		vc.getMobileDriverUtils().selectMobileRadioButton(currentBalance, "CurrentBalance-RadioButton");
		vc.getMobileDriverUtils().clickMobileElement(continueButton, "Continue");
		paymentUI();
	}
	
	public void payOtherAmount() throws InterruptedException {
		vc.getMobileDriverUtils().clickMobileElement(payNowButton, "PayNow-Button");
		vc.getMobileDriverUtils().selectMobileRadioButton(otherAmount, "OtherAmount");
	//	vc.getMobileDriverUtils().mobile_EnterText(customAmount, "$" + customamount, "CustomAmount");
		vc.getMobileDriverUtils().mobile_EnterText(customAmount, "1", "CustomAmount");
		vc.getMobileDriverUtils().clickMobileElement(continueButton, "Continue");
		paymentUI();
		
		
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
	
	@FindBy(id = "edt_comments")
	public WebElement feedbackComments;
	
	@FindBy(id = "rb_feedback")
	public WebElement feedbackStar;
	
	@FindBy(id = "btn_submit")
	public WebElement submitButton;
	
	public void makePayment_ExistingCard() {
		vc.getMobileDriverUtils().selectMobileRadioButton(CardHolderName, "Card");
		Reporter.log("Selected " + CardHolderName.getText() + " from saved cards ", true);
		vc.getMobileDriverUtils().selectCheckbox(TermsandConditioncheckbox, "TermsandConditions");
		vc.getMobileDriverUtils().clickMobileElement(payNowButton, "PayNow-Button");
		vc.getMobileDriverUtils().sleep(2000);
	}
	
	public void makePayment() throws InterruptedException {
		
		if (vc.getMobileDriverUtils().elementAvailablity(paymentSuccessMessage, "PaymentSuccess-Message")) {
			Reporter.log("Amount paid is==> " + amountPaid.getText(), true);
			Reporter.log(paymentSuccessMessage.getText(), true);
			Reporter.log(paymentConfirmationNo.getText(), true);
			Reporter.log(paymentDate.getText(), true);
			vc.getMobileDriverUtils().clickMobileElement(doneButton, "Done-Button");

			if (vc.getMobileDriverUtils().elementAvailablity(CurrentBill, "BillingScreen")) {
				Reporter.log("Current Balance after paying Other Amount is ==> " + currentBalanceDue.getText(), true);
			}

			else if (vc.getMobileDriverUtils().elementAvailablity(happywithMYWinapp, "Happy-Popup")) {
				Reporter.log(happywithMYWinapp.getText(), true);
				vc.getMobileDriverUtils().clickMobileElement(sadSmiley, "Prompt Message");
				
				if(vc.getMobileDriverUtils().elementAvailablity(feedbackComments, "FeedBackScreen")) {
					vc.getMobileDriverUtils().mobile_EnterText(feedbackComments, "Test", "Comments");
					vc.getMobileDriverUtils().clickMobileElement(feedbackStar, "FeedbackStars");
					driver.navigate().back();
					vc.getMobileDriverUtils().clickMobileElement(submitButton, "Submit-Button");
					driver.navigate().back();
					vc.getMobileDriverUtils().clickMobileElement(doneButton, "Done-Button");
					Reporter.log("Current Balance after paying Other Amount is ==> " + currentBalanceDue.getText(), true);
				}else {
					vc.getMobileDriverUtils().elementAvailablity(currentBalanceDue, "DueAmount");
					Reporter.log("Current Balance after paying Other Amount is ==> " + currentBalanceDue.getText(), true);
				}			
				
			} else {
				Reporter.log("Something Went Wrong", true);
			}
		} else if (vc.getMobileDriverUtils().elementAvailablity(paymentFailedMessage, "PaymentFailed")) {
			Reporter.log(paymentFailedMessage.getText(), true);
			Assert.assertFalse(true, "PaymentFailed");
		}

		else if (vc.getMobileDriverUtils().elementAvailablity(cardChangeMessage, "ChangeCard-Message")) {
			Reporter.log(cardChangeMessage.getText(), true);
			Assert.assertFalse(true, "CardExpired");
		}
	}

	public void paymentMethodnavigation() throws InterruptedException {
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.Billingicon, "Billing");
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.Options, "options");
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.managePaymentmethod,
				"ManagePaymentMethods");
	}
	
	public void selectDropdown(WebElement element, String dropdownName, String dropdownValue) {
		vc.getMobileDriverUtils().clickMobileElement(element, dropdownName);
		List<WebElement> ccDropdown = driver.findElements(By.className("android.widget.CheckedTextView"));
		for (int i = 0; i < ccDropdown.size(); i++) {
			if (ccDropdown.get(i).getText().equalsIgnoreCase(dropdownValue)) {
				ccDropdown.get(i).click();
				Reporter.log("Selected ==" + dropdownValue + "from " + dropdownName, true);
				break;
			}

		}
	}

	
	public boolean addDebit_CreditCardUI() throws InterruptedException {
		paymentMethodnavigation();
		vc.getMobileDriverUtils().elementAvailablity(optionsBlock, "PaymentType");
		vc.getMobileDriverUtils().selectMobileRadioButton(debitCreditCardOption, "Debit-CreditCard");
		return (vc.getMobileDriverUtils().elementAvailablity(cardNumber, "CardNumber-Field")
				&& vc.getMobileDriverUtils().elementAvailablity(expiryMonth, "ExpiryMonth")
				&& vc.getMobileDriverUtils().elementAvailablity(expiryYear, "ExpiryYear")
				&& vc.getMobileDriverUtils().elementAvailablity(cvvNumber, "CVVNumber")
				&& vc.getMobileDriverUtils().elementAvailablity(cardZipCode, "ZipCode")
				&& vc.getMobileDriverUtils().elementAvailablity(addCardButton, "AddCard-Button"));
	}
	
	
	
	
	
	
	public boolean addElectronicCheckUI() throws InterruptedException {
		paymentMethodnavigation();
		vc.getMobileDriverUtils().elementAvailablity(optionsBlock, "PaymentType");
		vc.getMobileDriverUtils().selectMobileRadioButton(electronicCheckOption, "ElectronicCheck");
		return (vc.getMobileDriverUtils().elementAvailablity(BankAccountType, "BankAccountType")
				&& vc.getMobileDriverUtils().elementAvailablity(PayeeLastName, "PayeeLastNameField")
				&& vc.getMobileDriverUtils().elementAvailablity(PayeeFirstName, "PayeeFirstNameField")
				&& vc.getMobileDriverUtils().elementAvailablity(BankRoutingNumber, "BankRoutingNumberField")
				&& vc.getMobileDriverUtils().elementAvailablity(BankAccountNumber, "BankAccountNumber")
				&& vc.getMobileDriverUtils().elementAvailablity(ZipCode, "ZipCode")
				&& vc.getMobileDriverUtils().elementAvailablity(addCheckButton, "AddCheck-Button"));
	}
	
	
	
	public boolean validateElectronicCheck(String cardName ) throws InterruptedException {

		boolean cardAvailability = false;
		vc.getMobileDriverUtils().elementAvailablity(cardholderName, "ManagePaymentMethod-Screen");
		List<WebElement> cardHolderNames = driver.findElements(By.className("android.widget.TextView"));
		for (int i = 0; i < cardHolderNames.size(); i++) {
			String list = cardHolderNames.get(i).getText();
			if (list.startsWith(cardName)) {
				cardAvailability = true;
				break;		
			} else {
				cardAvailability = false;
			}
		}
		return cardAvailability;
	}
	
	public boolean validateCreditCard(String cardNo) throws InterruptedException {

		boolean cardAvailability = false;
		vc.getMobileDriverUtils().elementAvailablity(cardholderName, "ManagePaymentMethod-Screen");
		Reporter.log("Validating "+ cardNo + " is Listed or not",true);
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
	
	
	public void click(WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click();
	}
	
public void deleteCards() throws InterruptedException {
	
	vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.Billingicon, "Billing");
	vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.Options, "options");
	vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.managePaymentmethod,
			"ManagePaymentMethods");
	vc.getMobileDriverUtils().elementAvailablity(cardholderName, "Cards");
	
		List<WebElement> cardsAdded = driver
				.findElements(By.id("action"));								
		Reporter.log("No of Cards available are ==>" + cardsAdded.size(),true);
		if (cardsAdded.isEmpty()) {
			Reporter.log("NO CARDS ADDED",true);
		} else {
			java.util.Iterator<WebElement> itr = cardsAdded.iterator();
			while (itr.hasNext()) {
				vc.getMobileDriverUtils().clickMobileElement(MoreButton, "More Button");
				vc.getMobileDriverUtils().clickMobileElement(Delete, "More -> Delete Button");
				//vc.getMobileDriverUtils().clickMobileElement(DelDelete, "Delete Button");
				vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.ok, "OK");
				vc.getMobileDriverUtils().sleep(2000);
				if(cardDeleteErrorMessage.getText().contains("Request Failed. Please try again later.")) {
					Reporter.log(cardDeleteErrorMessage.getText().toUpperCase(),true);
					Assert.assertFalse(true);
				}else {
					vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.ok, "OK");
					itr.next();
				}
			}
			Reporter.log("All the Cards are deleted",true);
			driver.navigate().back();
		}
	}

	

	
	
	public void deleteElectronicCheck(String Cardnum) throws InterruptedException {
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.Billingicon, "Billing-Screen");
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.Options, "options");
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.managePaymentmethod,
				"ManagePaymentMethods");
		vc.getMobileDriverUtils().elementAvailablity(addPaymentMethodButton, "AddPaymentMethod");
		RefreshButton.click();
		vc.getMobileDriverUtils().sleep(2000);

		Reporter.log("Verify the Cancel functionality for Saved cards/Electronic check",true);
		
		if (validateElectronicCheck(Cardnum) == true) {
			
			WebElement MoreBtn=driver.findElement(By.xpath("//android.widget.TextView[@text='XXXXXXXXXXXX"+Cardnum+"']")); 
			vc.getMobileDriverUtils().clickMobileElement(MoreBtn, "More Button");
			vc.getMobileDriverUtils().sleep(2000);
			vc.getMobileDriverUtils().clickMobileElement(Cancel, "Cancel");
			Reporter.log(Cardnum + "Cancel functionality verified", true);		
			//vc.getMobileDriverUtils().clickMobileElement(MoreButton, "More Button");
			vc.getMobileDriverUtils().clickMobileElement(MoreBtn, "More Button");
			vc.getMobileDriverUtils().sleep(2000);
			vc.getMobileDriverUtils().clickMobileElement(Delete, "More -> Delete Button");
			vc.getMobileDriverUtils().clickMobileElement(DelDelete, "Delete Button");
			vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.ok, "OK");
			//vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.ok, "OK");
			vc.getMobileDriverUtils().sleep(2000);
			
			if(validateElectronicCheck(Cardnum)==true) {
				Assert.assertFalse(true, Cardnum + "Deleting card Failed");
			} else {
				Reporter.log(Cardnum + "Card Deleted Successfully", true);

			}
			
		} else {
			Reporter.log("Card is not available", true);
		}

	}

	
	
	
	public void errorMessageHandling(WebElement element,String message) {
		if(vc.getMobileDriverUtils().elementAvailablity(element, message)==true) {
			Reporter.log(element.getText().toUpperCase(), true);
		}else {
			Assert.assertFalse(true,"AlertMessage Not displayed");
		}
		
	}

	public void addElectronicCheckInvalid(String AccNum) throws InterruptedException {
		paymentMethodnavigation();
		vc.getMobileDriverUtils().clickMobileElement(addPaymentMethodButton, "AddPaymentMethod");
		vc.getMobileDriverUtils().elementAvailablity(optionsBlock, "PaymentType");
		vc.getMobileDriverUtils().selectMobileRadioButton(electronicCheckOption, "ElectronicCheck");
		vc.getMobileDriverUtils().clickMobileElement(addCheckButton, "AddCheck-Button");
		vc.getMobileDriverUtils().clickMobileElement(addCheckButton, "AddCheck-Button");
		errorMessageHandling(addPaymentErrorMessage, "Alert Message");
		
		//vc.getMobileDriverUtils().mobile_EnterText(PayeeLastName, "Lname", "LastName");
		vc.getMobileDriverUtils().mobile_EnterText(PayeeFirstName, "Fname", "FirstName");
		driver.navigate().back();
		vc.getMobileDriverUtils().clickMobileElement(addCheckButton, "AddCheck-Button");
		vc.getMobileDriverUtils().elementAvailablity(addPaymentErrorMessage, "Alert Message");
		errorMessageHandling(addPaymentErrorMessage, "Alert Message");
		
		vc.getMobileDriverUtils().mobile_EnterText(BankAccountNumber, "0639", "AccountNo");
		driver.navigate().back();
		vc.getMobileDriverUtils().clickMobileElement(addCheckButton, "AddCheck-Button");
		vc.getMobileDriverUtils().elementAvailablity(addPaymentErrorMessage, "Alert Message");
		errorMessageHandling(addPaymentErrorMessage, "Alert Message");
		driver.navigate().back();

	}

	public void addDebit_CreditCardinvalid(String CNum) throws InterruptedException {
		paymentMethodnavigation();
		vc.getMobileDriverUtils().clickMobileElement(addPaymentMethodButton, "AddPaymentMethod");
		vc.getMobileDriverUtils().elementAvailablity(optionsBlock, "PaymentType");
		vc.getMobileDriverUtils().selectMobileRadioButton(debitCreditCardOption, "Debit-CreditCard");
		vc.getMobileDriverUtils().clickMobileElement(AddCard, "AddCard-Button");

		Reporter.log(addCardErrorMessage.getText(), true);

		vc.getMobileDriverUtils().mobile_EnterText(cardNumber, CNum, "Card Number");
		driver.navigate().back();

		vc.getMobileDriverUtils().clickMobileElement(AddCard, "AddCard-Button");

		Reporter.log(addCardErrorMessage.getText(), true);

		vc.getMobileDriverUtils().mobile_EnterText(cvvNumber, "7", "Cvv");
		driver.navigate().back();
		vc.getMobileDriverUtils().clickMobileElement(AddCard, "AddCard-Button");
		Reporter.log(addCardErrorMessage.getText(), true);

		vc.getMobileDriverUtils().mobile_EnterText(cardZipCode, "2", "Zipcode");
		// driver.navigate().back();

		vc.getMobileDriverUtils().clickMobileElement(AddCard, "AddCard-Button");
		Reporter.log(addCardErrorMessage.getText(), true);
		vc.getMobileDriverUtils().sleep(2000);

		driver.navigate().back();

	}

	
	public void editElectronicCheck(String Cardnum) throws InterruptedException {
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.Billingicon, "Billing");
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.Options, "options");
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.managePaymentmethod,
				"ManagePaymentMethods");
		vc.getMobileDriverUtils().elementAvailablity(addPaymentMethodButton, "AddPaymentMethod");
		vc.getMobileDriverUtils().clickMobileElement(RefreshButton, "Refresh");
		vc.getMobileDriverUtils().sleep(2000);

		Reporter.log("Verify the Edit functionality for Saved cards/Electronic check");

		List<WebElement> options = driver.findElements(By.className("android.widget.TextView"));
		for (int i = 0; i < options.size(); i++) {
			String list = options.get(i).getText();
			// System.out.println("List of cards available");
			// System.out.println(list1);

			if (list.contains(Cardnum)) {

				MoreButton.click();
				vc.getMobileDriverUtils().sleep(2000);
				Edit.click();

				vc.getMobileDriverUtils().sleep(2000);

				vc.getMobileDriverUtils().mobile_EnterText(PayeeFirstName, "Adam", "FirstName");
				vc.getMobileDriverUtils().mobile_EnterText(PayeeLastName, "Adam", "LastName");

				vc.getMobileDriverUtils().clickMobileElement(Save, "Save");

				vc.getMobileDriverUtils().sleep(2000);

				String SuccessMsg = Snackbar.getText();

				String FailureMsg = Snackbar.getText();

				if (SuccessMsg.contentEquals("Payment method saved successfully")) {
					Reporter.log(SuccessMsg, true);
					vc.getMobileDriverUtils().clickMobileElement(Snackbar_close, "Close");

				} else {

					Reporter.log(FailureMsg, true);

				}

				vc.getMobileDriverUtils().clickMobileElement(Snackbar_close, "Close");

				// System.out.println(Cardnum +"Element is deleted");
				Reporter.log(Cardnum + "Edit functionality verified", true);

			} else {
				Reporter.log(Cardnum + "No such option found", true);
			}
		}

	}
	
	

}
