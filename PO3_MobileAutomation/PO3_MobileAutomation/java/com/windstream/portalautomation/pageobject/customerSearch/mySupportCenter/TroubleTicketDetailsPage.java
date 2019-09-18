package com.windstream.portalautomation.pageobject.customerSearch.mySupportCenter;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class TroubleTicketDetailsPage {

	  WebDriver driver;
		
		@FindBy(css="h2.orderServices")
		private WebElement userTitle;
		
		
		public WebElement getUserTitle() {
			return userTitle;
		}

		@FindBy(linkText="(Sign Out)")
		private WebElement signOut;
		
		/******Search Criteria Starts here********/
	
		@FindBy(css="input.gwt-TextBox")
		private WebElement searchTextBox;			
				
		
		@FindBy(xpath=".//*[@id='viewtroubleticketingdiv']/div/div[2]/div/div[1]/div/table[2]/tbody/tr/td[2]/select")
		private WebElement searchBy;//Search By Incident > Type in Trouble ticket number without INC and leading Zeros INC and 0s are appended before the number entered , Trouble ticket details are displayed in the drop down
		//On each tab click on an incident hyperlink to generate the BI report. 
		
		@FindBy(css="input.gwt-TextBox")// gwt-TextBox-readonly")
		private WebElement circuitID;
		
		@FindBy(css="img.GEGKQPOBEI")
		private WebElement circuitIDSearch;
		
	//	@FindBy(xpath=".//*[@id='circuit-search']/div[1]/div[2]")//.//*[@id='cktNotFoundTextDiv']")///div/div/table/tbody/tr[4]/td/div")//.//*[@id='myGrid']/div[5]/div/div[2]/div
		
		@FindBy(css="div.padTop5.padBottom5")
		//@FindBy(xpath=".//*[@id='myGrid']/div[5]/div/div[4]/div")
		private WebElement circuitSearchPopUpText; //Verifying text on Circuit SEarch Popup
		
		
		
		@FindBy(css="div.GEGKQPOBAB.GEGKQPOBBB > div")//.//*[@id='myGrid']/div[5]/div/div[2]/div  GEGKQPOBCB	
		
		//@FindBy(css="div.GEGKQPOBAB")
		private WebElement circuitIdSearchElem; //Verifying text on Circuit SEarch Popup
		
		@FindBy(css="button.gwt-Button")
		private WebElement circuitSearchCancel;   
		
		@FindBy(xpath="(//input[@type='text'])[2]")//input.gwt-TextBox")
		private WebElement circuitSearchTextBox; //TextBox to search circuit Id IN popup
		
		@FindBy(css="button.gwt-Button")
		private WebElement searchCircuitsorIncidentsButton;		

		@FindBy(css="div.GEGKQPOBAB.GEGKQPOBDB > div")// > div")//xpath=".//div/div[7]/div")//div[70]/div")//div[9]/div/div/div[1]/div/table/tbody/tr[2]/td/div/div/div/div/div[1]/div[5]/div")
		private WebElement circuitIdElem ;		
		
		@FindBy(xpath="//td/div/div/div/div/div/div/div")
		private WebElement circuitIdElemBox ;
		@FindBy(css="button.gwt-Button")
		private WebElement searchCircuitsPopuUpCancel ;
		
		//@FindBy(xpath=".//div[9]/div/div/div[1]/div/table/tbody/tr[4]/td/div")///div/div/table/tbody/tr[4]/td/div")
		//private WebElement searchCircuitPopupAssertText ;		
		
		@FindBy(xpath=".//div/div/table/tbody/tr[4]/td/div")//div[9]/div/div/div[1]/div/table/tbody/tr[4]/td/div")
		private WebElement searchCircuitPopuUpText ;
		
		//@FindBy(xpath="./div[9]/div/div/div[1]/div/table/tbody/tr[2]/td/div/div/div/div/div[1]/div/div")//div[9]/div/div/div[1]/div/table/tbody/tr[4]/td/div")
		@FindBy(css="div.GEGKQPOBAB.GEGKQPOBDB > div")
		private WebElement selectedCircuit ;
		
		
		
		/******Search Criteria Ends here********/
		
		/******Tabs Start********/
	
		@FindBy(xpath=".//*[@id='viewtroubleticketingdiv']/div/div[3]/div/div/div[2]/div/div[1]/div/div")
		private WebElement openTab ;
		
		@FindBy(xpath=".//*[@id='viewtroubleticketingdiv']/div/div[3]/div/div/div[2]/div/div[2]/div/div")
		private WebElement waitingTab ;
		
		
		@FindBy(xpath=".//*[@id='viewtroubleticketingdiv']/div/div[3]/div/div/div[2]/div/div[3]/div/div")
		private WebElement resolvedTab;
	
		@FindBy(xpath=".//*[@id='viewtroubleticketingdiv']/div/div[3]/div/div/div[2]/div/div[4]/div/div")
		private WebElement closedTab;
		
		/******Tabs Ends here********/
		
		@FindBy(id="gwt-debug-recentOpenedTicket1-input")
		private WebElement sortOpen;
		
		@FindBy(id="gwt-debug-recentCreatedTicket1-input")
		private WebElement sortRecent ;
		
		@FindBy(css="img.gwt-Image")
		private WebElement editImage ;//On OPEN or WAITING incidents click on the EDIT (pencil Icon) NOTES can not be added to RESOLVED or CLOSED tickets
		
		@FindBy(css="img.gwt-Image.GEGKQPOBBK")
		private WebElement editImageCross ;
		
		
		
		@FindBy(css="div.lightBoxContentBtnContainer.marginautoWidth > button.gwt-Button")
		private WebElement editImageCancel ;
		
		@FindBy(css="textarea.gwt-TextArea")
		private WebElement editImageText ;//On the Trouble Ticket Details Screen - click on the EDIT (pencil icon) - enter comments greater than 2000 characters 
		//(//button[@type='button'])[3]
		@FindBy(xpath="(//button[@type='button'])[3]")
		private WebElement editImageSave ;
		
		@FindBy(css="button.gwt-Button.formButtonShort")
		private WebElement editImageSubmitOk ;
		

		@FindBy(id="gwt-debug-NIMarkAsResCB-input")
		private WebElement editImageMarkAsResolved ;
		
		
		@FindBy(xpath="//div[9]/div/div/div[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div[3]/button")
		private WebElement editImageMarkAsResolvedOkButton ;
		
		
		//After clicking on the pencil icon and receiving the additional comments pop-up - check the "Mark as Resolved"  box. 
		
		
		public void clickOnSignOut()throws Throwable  {
			signOut.click();
			Thread.sleep(3000);
		}
		
		
		public void clickOnSearchByCircuitID()throws Throwable  {
			//.click();
			new Select(searchBy).selectByIndex(1);//.selectByValue("Circuit ID");//
		//	Thread.sleep(3000);
			Thread.sleep(15000);
}
		public void clickOnSearchByIncident(String str)throws Throwable  {
			//.click();
			//new Select(searchBy).selectByValue(str);
			clickOnSearchText(str);
			Thread.sleep(15000);
}
		
		/***Circuit Popup Functions starts here***/
		public void clickonSearchImage()throws Throwable  {
			circuitIDSearch.click();
			Thread.sleep(15000);
}
	
		
	
		public void clickOnSearchCircuitCancel()throws Throwable  {
			clickOnSearchByCircuitID();
			searchCircuitsPopuUpCancel.click();
			Thread.sleep(3000);
}
		
		public void getSearchCircuitIDElem(WebDriver driver) throws Throwable {
			clickOnSearchByCircuitID();
			searchCircuitPopuUpText.sendKeys("1");
			//circuitIdElem.click();
			Thread.sleep(3000);			
			
		}
		
		//Method to select Circuit from Cicuit ID pop up
		public void clickOnCircuitIDSearch(String str) throws Throwable  {
			
				
			circuitIDSearch.click();
			  Thread.sleep(15000);
			validateCircuitSearchPopUpText();			
	        Thread.sleep(10000);			
			circuitSearchCancel.click();
			  Thread.sleep(10000);
			System.out.println("Hit Cancel");			
			circuitIDSearch.click();	
			Thread.sleep(15000);					
			circuitSearchTextBox.sendKeys(str);
			Thread.sleep(10000);
			circuitIdElemBox.click();//Select the new element searched
			  Thread.sleep(10000);
			if(circuitSearchCancel.isDisplayed()){circuitSearchCancel.click();}
			searchTextBox.getText();
			Thread.sleep(10000);	
			
			
		}	
		
		
		public void validateCircuitSearchPopUpText(){
			
			
			//circuitSearchPopUpText
			String Actualtext = circuitSearchPopUpText.getText();
			//String Actualtext2 = circuitSearchPopUpText2.getText();
			try {
				// System.out.println("Actualtext="+Actualtext1 +"<bbbb>"+Actualtext2);
				// Assert.assertEquals(Actualtext2, "844-WIN-CNOC or 844-946-2662");
				Assert.assertEquals(Actualtext, "If the Circuit ID is not found contact Carrier Operations to assist you 844-WIN-CNOC or 844-946-2662.");
				
			} catch (Throwable e) {
			//webDriverUtils.takeScreenshot("users__Error");
				System.out.println(e.getMessage());
				Reporter.log("failed due to data is not matching" + e.getLocalizedMessage());
				
			}

				
			}
				
		/***Circuit Popup Functions End here***/
		
		public void clickOnSearchText(String str)throws Throwable  {///Check need of this one
			searchTextBox.sendKeys(str);
			Thread.sleep(10000);
}
		
		
		public void clickOnsearchButton()throws Throwable  {
			searchCircuitsorIncidentsButton.click();
			Thread.sleep(15000);
}
		
			
		/***Tabs Function Start here***/
		
		public void clickOnOpenTab()throws Throwable  {
			openTab.click();
			Thread.sleep(10000);
			sortOpen.click();Thread.sleep(10000);
			sortRecent.click();Thread.sleep(10000);
			
			editPopuUp();
			Thread.sleep(3000);
		}
		
		public void clickOnWaitingTab()throws Throwable  {
			waitingTab.click();Thread.sleep(10000);
			//editImage.click();
			Thread.sleep(5000);
		}
		
		public void clickOnResolvedTab()throws Throwable  {
			resolvedTab.click();
			Thread.sleep(10000);
		}
		
		public void clickOnClosedTab()throws Throwable  {
			closedTab.click();
			Thread.sleep(10000);
		}
		
		public void validateCircuitIDBoxUnEditable(){
			
			
			if((searchTextBox.getAttribute("readonly")).equals("true")){
				System.out.println("Verified Uneditable CircuitID BOX");
			}
			else
			{ System.out.println("%%%%%%%%%%% Caught  in validateCircuitIDBoxUnEditable%%%%%%%%%%");}
			
		}
		
		
		public void editPopuUp()throws Throwable{
			
			editImage.click();
			editImageCross.click();
			Thread.sleep(10000);
			System.out.println(1);
			editImage.click();
			editImageCancel.click();
			Thread.sleep(10000);
			System.out.println(2);
			editImage.click();
			editImageText.sendKeys("test");
			Thread.sleep(10000);
			System.out.println(3);
			editImageMarkAsResolved.click();System.out.println(4);Thread.sleep(10000);
			//editImageText.sendKeys("test");
			//editImageMarkAsResolvedOkButton.click();
			editImageSave.click();Thread.sleep(10000);
			editImageSubmitOk.click();System.out.println(5);Thread.sleep(10000);
		}
		/***Tabs Function End here***/
		
		/***Search Results functions start here***/
		
		/***Search Results functions end here***/
		
		/**
		 * Search for an invalid incident Number - Invalid user will receive the following message  
		 * Search on a circuit with no active trouble tickets--If there is no open ticket associated with Circuit Id User should get a message-  No Active tickets associated
		 * 
		 * Create a TT log out and log back in and search for the TT with Invalid INC #--Incident you have searched is invalid
		 * */
		
}

