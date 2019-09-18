package com.windstream.portalautomation.pageobject.customerSearch.mySupportCenter;

//import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateRequestPage {

	@FindBy(linkText= "MY SUPPORT CENTER")
	private WebElement viewMySupportCenter;
	
	@FindBy(linkText= "View Requests")
	private WebElement viewRequests;
	
	

	@FindBy(linkText="Create Request")
	private WebElement createRequest;
	
	
	@FindBy(linkText="Network Maintenance")
	private WebElement networkMaintenance;
	

	

	public void clickonViewMySupportCenter() {
		viewMySupportCenter.click();
		}
	

		public CreateRequestPage clickOnviewRequests() {
			viewRequests.click();
		return this;
}

	public CreateRequestPage clickOncreateRequest() {
		createRequest.click();
		return this;
}
	
	public CreateRequestPage clickOnnetworkMaintenance() {
		networkMaintenance.click();
		return this;
}

	
}

