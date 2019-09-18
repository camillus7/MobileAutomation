package com.mobile.WeConnect.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.webautomation.validation.Validator;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

public class WeConnect_SupportRequestPage {

	final WebDriver driver;
	private Validator vc;
	

	public WeConnect_SupportRequestPage(WebDriver driver) {
		this.driver = driver;
		this.vc = new Validator(driver);
	}
	
	@FindBy(className="android.widget.ImageButton")
	public WebElement createNewRequest;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'com.windstream.enterprise.we.dev:id/item_text') and @text='Support Requests']")
	public  WebElement supportRequestsOption;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'com.windstream.enterprise.we.dev:id/item_text') and @text='OfficeSuite UC']")
	public  WebElement officeSuiteUCOption;
	
	@FindBy(id="com.windstream.enterprise.we.dev:id/location")
	public  WebElement locationDropdown;
	
	@FindBy(id="com.windstream.enterprise.we.dev:id/account")
	public  WebElement accountDropdown;
	
	@FindBy(id="com.windstream.enterprise.we.dev:id/product")
	public  WebElement servicesDropdown;
	
	@FindBy(id="com.windstream.enterprise.we.dev:id/listItem")
	public  WebElement locationList;
	
	@FindBy(id="general_issue")
	public  WebElement generalIssueDropdown;
	
	@FindBy(id="search_src_text")
	public  WebElement generalIssueSearchField;
	
	@FindBy(id="answer")
	public  WebElement additionalInfo_Opt;
	
	@FindBy(id="next")
	public  WebElement nextButton;
	
	@FindBy(id="anytime")
	public  WebElement anytimeRadioButton;
	
	@FindBy(id="contact_name")
	public  WebElement primaryContactDropdown;
	@FindBy(id="contact_method")
	public  WebElement preferredContactDropdown;
	@FindBy(id="site_contact")
	public  WebElement siteContactDropdown;
	@FindBy(id="site_contact_method")
	public  WebElement site_preferredContactDropdown;
	@FindBy(id="after_hrs_contact")
	public  WebElement afterHoursContactDropdown;
	@FindBy(id="after_hrs_contact_method")
	public  WebElement afterHrs_PreferredContactDropdown;
	
	@FindBy(id="minor")
	public  WebElement minorRadioButton;
	
	@FindBy(id="testing_authorization")
	public  WebElement testingAuthorizationDD;
	
	@FindBy(id="charges_authorization")
	public  WebElement chargesauthorizationDD;
	
	@FindBy(id="com.windstream.enterprise.we.dev:id/submit")
	public  WebElement submitButton;
	
	@FindBy(id="searchFilterRecyclerView")
	public  WebElement list;
	
	@FindBy(id="listView")
	public WebElement dropdownList;
	
	@FindBy(id="listItem")
	public WebElement authorizationDropdownList;
	
	@FindBy(xpath="//android.widget.LinearLayout")
	public WebElement testingAuthDropdown;
	
	@FindBy(id="yes")
	public WebElement testingAuth_Yes;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Yes']")
	public WebElement chargesAuth_Yes;
	
	@FindBy(xpath="//android.widget.Button[@text='REVIEW REQUEST']")
	public WebElement reviewRequest;
	
	@FindBy(id="message")
	public WebElement successMessage;
	
	@FindBy(id="button1")
	public WebElement okButton;
	
	@FindBy(xpath="//android.widget.Button[@text='REVIEW REQUEST']")
	public List<WebElement> nextButtons;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Open']")
	public WebElement OpenTab;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Monitoring']")
	public WebElement monitoringTab;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Resolved']")
	public WebElement resolvedTab;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Closed']")
	public WebElement closedTab;
	
	@FindBy(id="status")
	List<WebElement> statusText;
	
	@FindBy(id="status")
	public WebElement status;
	
	public void getTicketDetails(WebElement statusTab,WebElement ticketAvailability) {
		vc.getMobileDriverUtils().clickMobileElement(statusTab, "StatusTab");
		if(vc.getMobileDriverUtils().elementAvailablity(status, "TicketDetails")) {
			Reporter.log(statusText.size()+"==>" + statusTab.getText() + " Tickets is Available",true);
		}else {
			Reporter.log(statusTab.getText() + " Tickets is Not Available",true);
		}
		
	}
	public void navigatetoCreateNewSupportRequest(String userStoryDescription) throws Exception {
		 
		
		Reporter.log("************************ Navigating to Create Support request ************************", true);
		vc.getWebDriverUtils().logUserStoryStart(userStoryDescription, "Support -> New Support Request");
		vc.getMobileDriverUtils().clickMobileElement(WeConnect_LandingPage.HamburgerMenu, "HamburgerMenu");
		vc.getMobileDriverUtils().clickMobileElement(supportRequestsOption, "SupportRequests");
		
		Reporter.log("****Navigate between tabs****",true);
		getTicketDetails(OpenTab, status);
		getTicketDetails(monitoringTab, status);
		getTicketDetails(resolvedTab, status);
		getTicketDetails(closedTab, status);
		
		/*vc.getMobileDriverUtils().sleep(5000);
		swipeVertical(0.1,0.9,0.5,3000);
		*/
		
		vc.getMobileDriverUtils().clickMobileElement(createNewRequest, "Create-NewSupportRequests");
		
		
		Reporter.log("****CREATE REQUEST - LOCATION/ACCOUNT****");
		vc.getMobileDriverUtils().selectDropDown_FirstItem(locationDropdown,dropdownList,"LocationDropdown");
		vc.getMobileDriverUtils().selectDropDown_FirstItem(accountDropdown,dropdownList,"AccountDropdown");
		vc.getMobileDriverUtils().clickMobileElement(nextButton, "Nextbutton");
		
		Reporter.log("****SERVICE TYPE - SERVICES/GENERALISSUE****");
		vc.getMobileDriverUtils().selectDropDown_FirstItem(servicesDropdown,dropdownList, "ServicesDropdown");
		if(vc.getMobileDriverUtils().elementAvailablity(generalIssueDropdown, "GeneralIssue-Dropdown")) {
			vc.getMobileDriverUtils().selectDropDown_FirstItem(generalIssueDropdown,dropdownList, "GeneralIssueDropdown");
			vc.getMobileDriverUtils().mobile_EnterText(additionalInfo_Opt, "Testing-Please Ignore", "AdditionalInfo-Field");
			driver.navigate().back();
			driver.findElement(By.xpath("//android.widget.Button[@text='NEXT'][1]")).click();
		}
		
		Reporter.log("****CONTACT INFORMATION - PRIMARY/SITE/AFTERHOURS CONTACT METHOD****");
		vc.getMobileDriverUtils().selectDropDown_Index(primaryContactDropdown,dropdownList, "PrimaryContact", 1);
		vc.getMobileDriverUtils().selectDropDown_Index(siteContactDropdown,dropdownList, "SiteContact", 1);	
		vc.getMobileDriverUtils().selectDropDown_Index(afterHoursContactDropdown,dropdownList, "AfterHoursContact", 1);	
		List<WebElement> nextBtn = driver.findElements(By.xpath("//android.widget.Button[@text='NEXT']"));
		for(int i=0;i<nextBtn.size();i++){
			nextBtn.get(1).click();
			Reporter.log("Clicked on Nextbutton");
		}
	
		Reporter.log("****AUTHORIZATION****");
		vc.getMobileDriverUtils().clickMobileElement(testingAuthorizationDD, "TestingAuthorizationDropdown");
		vc.getMobileDriverUtils().clickMobileElement(testingAuth_Yes, "Yes-Option");	
		vc.getMobileDriverUtils().selectDropDown_Index(chargesauthorizationDD,dropdownList,"ChargesauthorizationDropdown", 1);
		vc.getMobileDriverUtils().clickMobileElement(reviewRequest, "ReviewRequest-Button");
	
		
		
		
		vc.getWebDriverUtils().scrollToViewElement(submitButton, "submitButton");
		submitButton.click();
		
	//	vc.getMobileDriverUtils().elementAvailablity(submitButton, "SubmitButton");
	//	vc.getWebDriverUtils().clickMobileElement(submitButton, "Submit");
	
	}
		
	public  void swipeVertical(double startPercentage, double finalPercentage, double anchorPercentage, int duration) throws Exception {
        org.openqa.selenium.Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * finalPercentage);
        new TouchAction((MobileDriver) driver).press(startPoint, anchor).waitAction().moveTo(endPoint, anchor).release().perform();
    }
	
	@FindBy(id="status")
	public List<WebElement> tickets;
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
	public WebElement moreOption;
	
	@FindBy(xpath = "//android.widget.TextView[@index='1']")
	public WebElement incNumber;
	
	
	@FindBy(xpath = "//android.widget.TextView[@text='Post Comment']")
	public WebElement postComment;
	
	@FindBy(id="new_comment")
	public WebElement newComment;
	
	@FindBy(id="post_comment")
	public WebElement postCommentBtn;
	
	@FindBy(id="ticket_details")
	public WebElement ticketDetails;
	
	public void updateSupportRequest() {
		vc.getMobileDriverUtils().clickMobileElement(WeConnect_LandingPage.HamburgerMenu, "HamburgerMenu");
		vc.getMobileDriverUtils().clickMobileElement(supportRequestsOption, "SupportRequests");
		vc.getMobileDriverUtils().clickMobileElement(ticketDetails, "TicketDetails");
		String incNo = incNumber.getText();
		Reporter.log("Selected Ticket's Incident Number is  ==>" + incNo,true);
		vc.getMobileDriverUtils().clickMobileElement(moreOption, "More");
		vc.getMobileDriverUtils().clickMobileElement(postComment, "PostComment");
		vc.getMobileDriverUtils().mobile_EnterText(newComment, "Testing-Pleaseignore", "NewComment");
		driver.navigate().back();
		vc.getMobileDriverUtils().clickMobileElement(postCommentBtn, "PostComment-Btn");

	}
	
}
