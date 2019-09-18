package com.windstream.portalautomation.pageobject.customerSearch.mySupportCenter;

//import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MySupportCenterPage {

	@FindBy(linkText= "MY SUPPORT CENTER")
	private WebElement viewMySupportCenter;
	
	@FindBy(linkText= "Online Ticketing")  
	private WebElement onlineTicketing;
	

	@FindBy(linkText= "Trouble Ticket Details")  
	private WebElement troubleTicketDetails;
	
	@FindBy(linkText= "Trouble Ticketing")
	private WebElement troubleTicketing;
	
	@FindBy(linkText= "View Requests")
	private WebElement viewRequests;
	
	@FindBy(linkText=" My Profile ")
	private WebElement myProfile;
	

	@FindBy(linkText="Create Request")
	private WebElement createRequest;
	
	
	@FindBy(linkText="Network Maintenance")
	private WebElement networkMaintenance;
	
	@FindBy(linkText=" Contact Us ")
	private WebElement contactUs;
	
	@FindBy(linkText=" About Us ")
	private WebElement aboutUs;
	
	@FindBy(linkText=" Help ")
	private WebElement help;

	public void clickonViewMySupportCenter() {
		viewMySupportCenter.click();
		}
	
	
	
	public MySupportCenterPage clickOnonlineTicketing() {
		onlineTicketing.click();
	return this;
}
	public MySupportCenterPage clickOntroubleTicketDetails() {
		troubleTicketDetails.click();
	return this;
}
	public MySupportCenterPage clickOntroubleTroubleTicketing() {
		troubleTicketing.click();
	return this;
}
		public MySupportCenterPage clickOnviewRequests() {
			viewRequests.click();
		return this;
}

	public MySupportCenterPage clickOncreateRequest() {
		createRequest.click();
		return this;
}
	
	public MySupportCenterPage clickOnnetworkMaintenance() {
		networkMaintenance.click();
		return this;
}
	public void clickOnaboutUs() {
		aboutUs.click();
	
	}
	
	public void clickOnhelp() {
		help.click();
	
	}
	
	public void clickOncontactUs() {
		contactUs.click();
	
	}
	
	public String getTextForContactUs() {
		return contactUs.getText();
		
	}
	public void clickOnMyProfile() {
		myProfile.click();
	}
	
	
}

