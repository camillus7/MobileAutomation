package com.mobile.MyWin.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.webautomation.validation.Validator;

public class MyWinMobile_SupportRequestPage {

	final WebDriver driver;
	private Validator vc;

	public MyWinMobile_SupportRequestPage(WebDriver driver) {
		this.driver = driver;
		this.vc = new Validator(driver);
	}

	@FindBy(xpath = "//android.widget.TextView[@text='View Support Tickets']")
	public static WebElement viewSupportRequest;

	@FindBy(xpath = "//android.widget.TextView[@text='Quick Help']")
	public WebElement quickHelp;

	@FindBy(xpath = "//android.widget.TextView[@text='Contact Us']")
	public WebElement contactUs;

	@FindBy(xpath = "//android.widget.TextView[@text='ALL']")
	public WebElement allTickets;

	@FindBy(xpath = "//android.widget.TextView[@text='OPEN']")
	public WebElement openTickets;
	
	@FindBy(xpath = "//android.widget.TextView[@text='CLOSED']")
	public WebElement closedTickets;
	
	@FindBy(id="trouble_type")
	public WebElement troubleTicketType;
	
	@FindBy(id="ticket_status")
	public WebElement ticketStatus;
	
	@FindBy(id="ticket_detail")
	public WebElement ticketDetails;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Customer Care']")
	public WebElement contactUsScreen;
	
	public void supportUI() {
		vc.getMobileDriverUtils().clickMobileElement(MyWinMobile_LandingPage.Supporticon, "SupportOption");
		vc.getMobileDriverUtils().elementAvailablity(viewSupportRequest, "ViewSupportTickets");
		vc.getMobileDriverUtils().elementAvailablity(quickHelp, "QuickHelp");
		vc.getMobileDriverUtils().elementAvailablity(contactUs, "ContactUs");
		
		vc.getMobileDriverUtils().mobileNavigation(contactUs, contactUs,"Contact Us","ContactUs Screen");
		
	}
	
	
	
	public void viewSupportRequests(WebElement submenu) {
		vc.getMobileDriverUtils().clickMobileElement(viewSupportRequest, "ViewSupportRequest");
		vc.getMobileDriverUtils().clickMobileElement(submenu, submenu.getText());
		if(vc.getMobileDriverUtils().elementAvailablity(ticketDetails, "TicketDetails")==true) {
			List<WebElement> ticketType = driver.findElements(By.id("trouble_type"));
			List<WebElement> ticketStatus = driver.findElements(By.id("ticket_status"));
			for(int i =0;i<ticketType.size();i++) {
				for(int j=0;j<ticketStatus.size();j++) {
					System.out.println(ticketType.get(i).getText() + "==" + ticketStatus.get(j).getText());
				}
			}
		}else {
			Reporter.log("No Tickets Available",true);
		}
		
		
		
		
	}

}
