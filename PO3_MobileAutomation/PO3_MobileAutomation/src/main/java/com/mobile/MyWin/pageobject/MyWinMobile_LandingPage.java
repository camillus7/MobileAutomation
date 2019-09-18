package com.mobile.MyWin.pageobject;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.webautomation.validation.Validator;

public class MyWinMobile_LandingPage {

	final WebDriver driver;
	private Validator vc;
	

	public MyWinMobile_LandingPage(WebDriver driver) {
		this.driver = driver;
		this.vc = new Validator(driver);
	}

	

	@FindBy(xpath = "//android.widget.TextView[@text='Home']")
	public static WebElement Homeicon;

	@FindBy(xpath = "//android.widget.TextView[@text='Billing']")
	public static WebElement Billingicon;

	@FindBy(xpath = "//android.widget.TextView[@text='Support']")
	public static WebElement Supporticon;

	@FindBy(xpath = "//android.widget.TextView[@text='More']")
	public static WebElement More;
	
	@FindBy(id="amount_value")
	public static WebElement dueAmount;
	
	@FindBy(id="amount_month")
	public WebElement dueDate;
	
	@FindBy(id = "txt_current_balance")
	public WebElement currentBalanceDue;
	
	@FindBy(id = "due_date")
	public WebElement currentBalanceDueDate;
	
	//Posters
	@FindBy(id="label_1")
	public WebElement moveForwardPoster;
	
	@FindBy(xpath="//android.widget.LinearLayout[@resource-id='label_1']/android.widget.RelativeLayout")
	public WebElement posterCount;
	
	@FindBy(id="upgrade_label")
	public WebElement learnMoreButton;
	
	@FindBy(id="upgrade")
	public WebElement getItNow;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Move Forward with Kinetic in Your Home']")
	public WebElement moveForwardPosterNavigation;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Refer Friends!Get Rewarded!']")
	public WebElement referFriendsNavigation;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Drop Cable and Switch to DIRECTV']")
	public WebElement dropCableNavigation;
	
	@FindBy(xpath = "//android.widget.TextView[@text='It's Your TV,Take It With You']")
	public WebElement tvNavigation;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Special Offer']")
	public WebElement specialOfferNavigation;
	
	

	

	public boolean homeScreenUI() {
		return (vc.getMobileDriverUtils().elementAvailablity(Homeicon, "Homeicon")
				&& vc.getMobileDriverUtils().elementAvailablity(Billingicon, "billingicon")
				&& vc.getMobileDriverUtils().elementAvailablity(Supporticon, "supporticon")
				&& vc.getMobileDriverUtils().elementAvailablity(More, "moreicon"));
	}
	
	public void getDueAmount() {
		vc.getMobileDriverUtils().elementAvailablity(dueAmount, "DueAmountDetails");
		String dueAmount_Landing = dueAmount.getText();
		String dueDate_landing = dueDate.getText();
		Reporter.log("In Landing screen --> Current balance due " + dueDate_landing + " is " + dueAmount_Landing,true );
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.Billingicon, "Billing-Screen");
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_BillingPage.CurrentBill, "CurrentBill");
		String dueAmount_Billing =currentBalanceDue.getText();
		String dueDate_Billing = currentBalanceDueDate.getText();
		Reporter.log("In Billing screen --> Current balance due " + dueDate_Billing + " is " + dueAmount_Billing,true );
		Assert.assertEquals(dueDate_landing, dueDate_Billing,"DueDate is not same");
		Assert.assertEquals(dueAmount_Landing, dueAmount_Billing,"DueAmount is not same");
		Reporter.log("Due Date and amount is same in Landing and in Billing Screen",true);
	}
	
	public boolean swipeImages() {
		try {
			List<WebElement> posterCount = driver.findElements(By.id("label_1"));
			for(int i=0;i<posterCount.size();i++) {
				
				String pageString = posterCount.get(i).getAttribute("index");
				Reporter.log("Total no of posters available are" + posterCount.size(),true);
				
				Reporter.log(posterCount.get(i).getText(),true);
				int length = pageString.length();
				System.out.println(length);
				String count_string = pageString.substring(length - 2, length).trim();
				int count = Integer.parseInt(count_string);
				System.out.println("Number of Image available to Swipe: " + count);
				for (int j = 0; j <= count; j++) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					HashMap scrollObject = new HashMap();
					scrollObject.put("direction", "right");
					js.executeScript("mobile: scroll", scrollObject);
				}
				System.out.println("Swipe Successfully");
			}
			
			
		} catch (Exception e) {
			System.out.println("Image swipe was not successfull");
		}
		return false;
	}
	
	public void posterFunctionality() {
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.Homeicon, "Home");
		
		if(vc.getMobileDriverUtils().elementAvailablity(moveForwardPosterNavigation, "Move Forward")==true) {
			vc.getMobileDriverUtils().mobileNavigation(learnMoreButton, moveForwardPosterNavigation,
					"Move Forward with Kinetic in Your Home", "Move Forward with Kinetic in Your Home");
		}else if (vc.getMobileDriverUtils().elementAvailablity(referFriendsNavigation, "Refer Friends")==true) {
			vc.getMobileDriverUtils().mobileNavigation(getItNow, referFriendsNavigation, "Refer Friends!Get Rewarded!",
					"Refer Friends!Get Rewarded");
		}else if (vc.getMobileDriverUtils().elementAvailablity(dropCableNavigation, "Drop Cable")==true) {
			vc.getMobileDriverUtils().mobileNavigation(learnMoreButton, dropCableNavigation,
					"Drop Cable and Switch to DIRECTV", "Drop Cable and Switch to DIRECTV");
		}else if (vc.getMobileDriverUtils().elementAvailablity(tvNavigation, "TV ")==true) {
			vc.getMobileDriverUtils().mobileNavigation(learnMoreButton, tvNavigation, "It's Your TV,Take It With You",
					"It's Your TV,Take It With You");
		}else if (vc.getMobileDriverUtils().elementAvailablity(specialOfferNavigation, "Special Offer ")==true) {
			vc.getMobileDriverUtils().mobileNavigation(getItNow, specialOfferNavigation, "Special Offer",
					"Special Offer");
		}else {
			Reporter.log("Carousels not available",true);
		}
	}

}
