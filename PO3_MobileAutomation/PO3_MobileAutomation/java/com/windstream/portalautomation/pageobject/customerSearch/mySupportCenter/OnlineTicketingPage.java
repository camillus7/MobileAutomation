package com.windstream.portalautomation.pageobject.customerSearch.mySupportCenter;

//import java.util.List;
/*This class creates Online Ticket for Carrier CABS
 * The ticket generates a new Incident and that Incident is used by
 * Trouble*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

//import com.windstream.portalautomation.tests.Helper;


public class OnlineTicketingPage {
     WebDriver driver;
	
	@FindBy(css="h2.orderServices")
	private WebElement title;
	
	
	@FindBy(linkText="(Sign Out)"			)
	private WebElement signOut;
	
	
	/****************************************************************/

	@FindBy(xpath=".//*[@id='FttTroubleTicket']/div[6]/div[2]")
	private WebElement frameTroubleTicket;
	
		

	
//.//*[@id='ckt-id']

	@FindBy(id="ckt-id")
	private WebElement circuitID;

	@FindBy(css="img.icon-style")
	private WebElement circuitIDSearch;
	
	@FindBy(id="cancelButton")
	private WebElement circuitSearchCancel;   
	
	@FindBy(id="txtSearch2")
	private WebElement circuitSearchTextBox; //TextBox to search circuit Id IN popup
	
	//@FindBy(xpath=".//*[@id='cktNotFoundTextDiv']")//.//*[@id='circuit-search']/div[1]/div[2]") EDITED AFTER CHANGE
	
	@FindBy(id="cktNotFoundTextDiv")
	private WebElement circuitSearchPopUpText; //Verifying text on Circuit SEarch Popup
		

    private static final String circuitIDElem = ".//*[@id='myGrid']/div[5]/div/div[";// this xpath is static till tr[
   // .//*[@id='myGrid']/div[5]/div/div[1]/div
	
	@FindBy(xpath=".//*[@id='myGrid']/div[5]/div/div[1]/div")//.//*[@id='circuit-search']/div[1]/div[2]/b")
	private WebElement circuitIDElem1;
	
	@FindBy(xpath="//div[@id='myGrid']/div[5]/div/div[10]/div")//.//*[@id='circuit-search']/div[1]/div[2]/b")
	private WebElement circuitIDElem2;
	
	@FindBy(xpath="//div[@id='myGrid']/div[5]/div/div[9]/div")//.//*[@id='circuit-search']/div[1]/div[2]/b")
	private WebElement circuitIDElem3;
	
	@FindBy(xpath="//div[@id='myGrid']/div[5]/div/div[4]/div")//.//*[@id='circuit-search']/div[1]/div[2]/b")
	private WebElement circuitIDElem4;
	
	@FindBy(xpath="//div[@id='myGrid']/div[5]/div/div[5]/div")//.//*[@id='circuit-search']/div[1]/div[2]/b")
	private WebElement circuitIDElem5;
	
		
	// driver.findElement(By.xpath("//div[@id='myGrid']/div[5]/div/div[4]/div")).click();
	 
	@FindBy(id="FttTroubleTicket_fttTroubleTicket_fttTroubleTicketDetails_ticketNumber")
	private WebElement customerTicketNumber;
	
	@FindBy(xpath=".//*[@id='custTktNumberIcon']/img")//css="img.info-icon")//xpath=".//*[@id='FttTroubleTicket']/div[6]/div[3]/table/tbody/tr[1]/td[4]/div[2]/img") 
	private WebElement customerTicketNumberInfo;//INC000024337881
	
	
	@FindBy(id="FttTroubleTicket_fttTroubleTicket_fttTroubleTicketDetails_powerVerifiedSelected")
	private WebElement powerVerified;

	@FindBy(xpath=".//*[@id='powerVerifiedIcon']/img")//.//*[@id='FttTroubleTicket']/div[6]/div[3]/table/tbody/tr[3]/td[2]/div[2]/img")
	private WebElement powerVerifiedInfo; //done
	
	/****************************************************************/
	

	@FindBy(xpath=".//*[@id='FttTroubleTicket']/div[7]/div[3]")
	private WebElement frameCompanyInformation;
	
	
	

	@FindBy(id="company-name")
	private WebElement companyName;

	@FindBy(id="street-id")
	private WebElement address;

	@FindBy(id="city-id")
	private WebElement city;

	@FindBy(id="state-id")
	private WebElement state;

	@FindBy(id="zip-id")
	private WebElement zipPostalCode;

	@FindBy(id="country-id")
	private WebElement country;
	
	@FindBy(xpath=".//*[@id='FttTroubleTicket']/div[6]/div[4]/table[2]/tbody/tr/td[2]")
	private WebElement companyInfoNote;
	

	/****************************************************************/
	
	
	
	@FindBy(xpath=".//*[@id='FttTroubleTicket']/div[8]/div[3]")
	private WebElement frameRequestDetails;


	
	@FindBy(id="fttTroubleTicket.fttTroubleTicketDetails.tier3TicketSelType")
	private WebElement ticketType;
	
	@FindBy(xpath=".//*[@id='alertAllOtherMsg']/div[2]/div[2]/table/tbody/tr/td[2]/h2")
	private WebElement allOtherTicketTypeMsg;
	
	@FindBy(id="FttTroubleTicket_6")
	private WebElement allOtherTicketTypeOk;
	
	
	@FindBy(xpath=".//*[@id='alertVoiceTicketsMsg']/div[2]/div[2]/table/tbody/tr/td[2]/h2")
	private WebElement voiceTicketTypeMsg;
	
	@FindBy(id="FttTroubleTicket_4")
	private WebElement voiceTicketTypeCancel;
	
	@FindBy(xpath=".//*[@id='alertDarkFiberMsg']/div[2]/div[2]/table/tbody/tr/td[2]/h2")
	private WebElement darkFibreTicketTypeMsg;
	
	@FindBy(id="FttTroubleTicket_8")
	private WebElement darkFibreTicketTypeOk;
	
	
	
	
	
	@FindBy(xpath=".//*[@id='tktTypeHelpIcon']")//.//*[@id='FttTroubleTicket']/div[8]/div[4]/table[1]/tbody/tr[1]/td[3]/img")
	private WebElement ticketTypeInfo;

	@FindBy(id="FttTroubleTicket_fttTroubleTicket_fttTroubleTicketDetails_tier3SelectedType")
	private WebElement troubleType;
		
	@FindAll({@FindBy(xpath=".//*[@id='FttTroubleTicket_fttTroubleTicket_fttTroubleTicketDetails_tier3SelectedType']")})
	private List<WebElement> troubleTypeList;
 
	@FindBy(id="FttTroubleTicket_fttTroubleTicket_fttTroubleTicketDetails_additionalInformation")
	private WebElement descriptionofProblem;
	
	/****************************************************************/
	
	

	@FindBy(xpath=".//*[@id='FttTroubleTicket']/div[9]/div[3]")
	private WebElement frameContactInformation;

	@FindBy(id="firstNamePrimary")
	private WebElement primaryFirstName;
	
	@FindBy(id="lastNamePrimary")
	private WebElement primaryLastName;

	@FindBy(id="phoneNumberPrimary")
	private WebElement primaryPhone;
	
	@FindBy( id="extnNumberPrimary")
	private WebElement primaryextension;

	@FindBy(id="phoneTypePrimary")
	private WebElement primaryPhoneType;

	@FindBy(id="emailPrimary")
	private WebElement primaryEMail;
	
	@FindBy(xpath=".//*[@id='primaryEmailIcon']/img")//.//*[@id='FttTroubleTicket']/div[8]/div[4]/table/tbody/tr/td[1]/table/tbody/tr[10]/td[2]/div[2]/img")
	private WebElement primaryEMailInfo;//done

	@FindBy(id="sameAsPrimary")
	private WebElement sameAsPrimary;
	
	@FindBy(id="firstNameLocal")
	private WebElement localFirstName;
	

	@FindBy(id="lastNameLocal")
	private WebElement localLastName;

	@FindBy(id="phoneNumberLocal")
	private WebElement localPhone;

	@FindBy(id="phoneTypeLocal")
	private WebElement localPhoneType;

	@FindBy(id="emailLocal")
	private WebElement localEMail; 
	
	@FindBy( id="extnNumberLocal")
	private WebElement localextension;

	@FindBy(xpath=".//*[@id='localEmailIcon']/img")//.//*[@id='FttTroubleTicket']/div[9]/div[4]/table/tbody/tr/td[2]/table/tbody[1]/tr[10]/td[2]/div[2]/img")
	private WebElement localEMailInfo;//Done
	
	@FindBy(xpath=".//*[@id='circuit-search']")
	private String circuitPopUp;//Done
	
	@FindBy(id="FttTroubleTicket_12")
	private WebElement buttonSubmit;  //Done

	@FindBy(id="FttTroubleTicket_0")
	private WebElement submitOK;//Done	
	
	@FindBy(id="FttTroubleTicket_10")
	private WebElement circuitUnavailableClickOk;//Done
	
	//@FindBy(xpath=".//*[@id='incident-number']/div[2]/div[2]/table/tbody/tr/td[2]/h2")
	               ////div[@id='incident-number']/div[2]/div[2]/table/tbody/tr/td[2]/h2
	////@FindBy(xpath=".//*[@id='successBoxBody1']/table/tbody/tr/td[2]/h2")
	//@FinfBy(xpath=".//*[@id='successBoxBody1']/table/tbody/tr/td[2]/h2")
	@FindBy(xpath=".//*[@id='incident-number']/div[2]/div[2]/table/tbody/tr/td[2]/h2")
	private WebElement submitOKMsg;//Done
	
	
	
	
	String selectedCircuit="";
	
	
	public String ispageLoad(WebDriver driver) {
		String s = driver.getTitle();
		System.out.println(s);;
		return s;
      }
	
	/************************Ticket Details Functions**************************************/
	
	 /* getCircuitIDElem populates the CircuitID textbox  by searching the circuits
	 *  When circuit selected is unavailable new circuit is selected from Search Box.
	 *  This function call generateCircuitIdpath function.which generates the new path
	 *  for next circuit in the list.
	 * */
	public String getCircuitIDElem(WebDriver driver) throws Throwable {
		clickOnCircuitIDSearch();
		//List circuitList = new ArrayList();
		//circuitList.addAll(arg0);
		int x=1;String str;
		 str=circuitIDElem1.getText();
		
		 circuitIDElem1.click();
		 str=circuitID.getAttribute("value");
		 //driver.
		 Thread.sleep(15000);
		// selectedCircuit=circuitID.getText();
		// Thread.sleep(15000);
		 System.out.println(1+"circuitIDElem1.getText()==="+selectedCircuit);
		
		 try{
			
			 do{
				 circuitUnavailableClickOk.click();Thread.sleep(1000);
				 clickOnCircuitIDSearch(); Thread.sleep(1000);
				 x=x+1;
				 str= generateCircuitIdElem(x,driver,selectedCircuit);driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 System.out.println("do circuitIDElem1.getText()==="+selectedCircuit);
			 }
			 while( circuitUnavailableClickOk.isDisplayed());
		//circuitIDElem2.getText();
		// selectedCircuit=circuitIDElem1.getText();
		
		 Thread.sleep(15000);
		 System.out.println(2+"==="+str);
		
		 }catch (Throwable e){ System.out.println("Throwable 2"+e);}
		 System.out.println("Circuit selected===="+str);
		
		Thread.sleep(3000);
		return str;
		
	}
	
		
	public String  generateCircuitIdElem(int i,WebDriver driver, String str) throws Throwable {
		
				
		
			
			System.out.println("11");
		By element = By.xpath(circuitIDElem+i+"]/div");
		//str=driver.findElement(element).getAttribute("value");
		System.out.println("selectedCircuit newwwwww" +element);
		driver.findElement(element).click();Thread.sleep(1000);
		 str=circuitID.getAttribute("value");
		System.out.println("selectedCircuit newwwwww" +str);
		
		return str;
		//driver.findElement(element).click();System.out.println("14");

		
		
			
	}
	
	public void typeCustomerTicketNumberInfo(String num) throws Throwable {
		customerTicketNumber.sendKeys(num);
		Thread.sleep(500);
	}
	public void clickOnCircuitIDSearch() throws Throwable  {
		circuitIDSearch.click();
		
		validateCircuitSearchPopUpText();
		
        Thread.sleep(5000);
		circuitSearchTextBox.sendKeys("30");
		Thread.sleep(5000);
		circuitSearchCancel.click();
		System.out.println("Hit Cancel");
		
		circuitIDSearch.click();
		
		Thread.sleep(3000);		
		
	}
	
	
	
	public void clickOnCustomerTicketNumberInfo()throws Throwable  {
		customerTicketNumberInfo.click();
		Thread.sleep(3000);
		
		
	}
	
	public void clickOnPowerVerifiedInfo()throws Throwable  {
		powerVerifiedInfo.click();
		Thread.sleep(3000);
		
		
	}
	public void selectPowerVerified(WebDriver driver)throws Throwable  {
		new Select(powerVerified).selectByIndex(2);
		Thread.sleep(3000);
		
		
	}
	
	/************************Company Information Functions**************************************/
	//////

	public WebElement getFrameCompanyInformation() {
		return frameCompanyInformation;
	}

	

	public WebElement getFrameContactInformation() {
		return frameContactInformation;
	}
	
	public String getCompanyName() throws Throwable {
		if((companyName.getText()).equals(null)||(companyName.getText()).equals(""))
		{
			
			companyName.clear();
			companyName.sendKeys("VERIZON");
			
		}
		
		return companyName.getText();
	//	Thread.sleep(500);
	}
	public String getaddress() throws Throwable {
		if((address.getText()).equals(null)||(address.getText()).equals(" "))
		{   address.clear();
			address.sendKeys("500   2ND AV SE");
			
		}
		return address.getText();
		//Thread.sleep(500);
	}
	public String getCity() throws Throwable {
		
		if((city.getText()).equals(null)||(city.getText()).equals(" "))
		{
			city.clear();
			city.sendKeys("CEDAR RAPIDS");
			
		}
		return city.getText();
		//Thread.sleep(500);
	}
	public String getState() throws Throwable {
		
		if((state.getText()).equals(null)||(state.getText()).equals(" "))
		{state.clear();
			state.sendKeys("IA");
			
		}
		return state.getText();
		//Thread.sleep(500);
	}
	public String getZipPostalCode() throws Throwable {
		
		if((zipPostalCode.getText()).equals(null)||(zipPostalCode.getText()).equals(" "))
		{
			zipPostalCode.clear();
			zipPostalCode.sendKeys("52401");
			
		}
		return zipPostalCode.getText();
		//Thread.sleep(500);
	}
	public String getCountry() throws Throwable {
		if((country.getText()).equals(null)||(country.getText()).equals(" "))
		{
			country.clear();
			country.sendKeys("US");
			
		}
		return country.getText();
		//Thread.sleep(500);
	}
	
	/************************Ticket Details Functions**************************************/
	public void clickOnTicketTypeInfo()throws Throwable  {
		ticketTypeInfo.click();
		Thread.sleep(3000);
		
		
	}
	
   public void selectTicketType()throws Throwable  {
		
		new Select(ticketType).selectByValue("Fiber to the Tower");
		Thread.sleep(3000);
		
		
	}
   
   public void selectAllOtherTicketType()throws Throwable  {
		
		new Select(ticketType).selectByValue("All Other");
		
		verifyAllOtherTicketTypeMsg();
		allOtherTicketTypeOk.click();
		Thread.sleep(3000);
		
		
	}
   
   
   
   public void selectVoiceTicketType()throws Throwable  {
		
		new Select(ticketType).selectByValue("Voice Tickets");
		
		verifyVoiceTicketTypeMsg();
		voiceTicketTypeCancel.click();
		Thread.sleep(3000);
		
		
	}
   
   public void selectDarkFibreTicketType() throws Throwable {
		
		new Select(ticketType).selectByValue("Dark Fiber");
		
		verifyDarkFibreTicketTypeMsg();
		darkFibreTicketTypeOk.click();
		Thread.sleep(3000);
		
		
	}
      
   public void selectTroubleType()throws Throwable  {
		
		new Select(ticketType).selectByValue("TDM/Ethernet Circuits");
		verifyTroubleTypeList();
		new Select(ticketType).selectByValue("Fiber to the Tower");
		verifyTroubleTypeList();
		Thread.sleep(3000);
		
		
	}
   public void typeDescriptionofProblem(String desc)throws Throwable  {
		
	   descriptionofProblem.sendKeys(desc);
		//Thread.sleep(500);
	}
   /************************Ticket Details Functions**************************************/
	
	public WebElement getFrameRequestDetails() {
		return frameRequestDetails;
	}
	
	public WebElement getFrameTroubleTicket() {
		return frameTroubleTicket;
		
		
	}
	
	

	 public void typePrimaryFirstName(String fname) throws Throwable {
		 primaryFirstName.sendKeys(fname);
			//Thread.sleep(500);
		}
	 public void typePrimaryLastName(String desc) throws Throwable {
		 primaryLastName.sendKeys(desc);
			//Thread.sleep(500);
		}
	 public void typePrimaryPhone(String desc) throws Throwable {
		 primaryPhone.sendKeys(desc);
			//Thread.sleep(500);
		}
	 public void typePrimaryextension(String desc) throws Throwable {
		 primaryextension.sendKeys(desc);
			//Thread.sleep(500);
		}
	  public void selectPrimaryPhoneType()throws Throwable  {
			
			new Select(primaryPhoneType).selectByIndex(2);
			Thread.sleep(3000);
			
			
		}
	  public void typePrimaryEMail(String desc) throws Throwable {
		  primaryEMail.sendKeys(desc);
			//Thread.sleep(500);
		}

	 
	  public void clickOnPrimaryEMailInfo()throws Throwable  {
			primaryEMailInfo.click();
			Thread.sleep(3000);
			
			
		}
	  

	  public void checkSameAsPrimary()throws Throwable  {
		  sameAsPrimary.click();
			Thread.sleep(3000);
			
			
		}
		 public void typeLocalFirstName(String desc) throws Throwable {
			 localFirstName.clear();
			 localFirstName.sendKeys(desc);
				//Thread.sleep(500);
			}
		 public void typeLocalLastName(String desc) throws Throwable {
			 localLastName.clear();
			 localLastName.sendKeys(desc);
				//Thread.sleep(500);
			}
		 public void typeLocalPhone(String desc) throws Throwable {
			 localPhone.clear();
			 localPhone.sendKeys(desc);
				//Thread.sleep(500);
			}
		 public void typeLocalEMail(String desc) throws Throwable {
			 localEMail.clear();
			 localEMail.sendKeys(desc);
				//Thread.sleep(500);
			}
		  public void selectLocalPhoneType()throws Throwable  {
				
				new Select(localPhoneType).selectByIndex(2);
				Thread.sleep(3000);
				
				
			}
		  public void typeLocalextension(String desc) throws Throwable {
			  localextension.clear();
			  localextension.sendKeys(desc);
				//Thread.sleep(500);
			}
		  public void clickLocalEMailInfo(String desc) throws Throwable {
			  localEMailInfo.clear();
			  localEMailInfo.click();
				//Thread.sleep(500);
			}
		  
	

	
	
	
	
	
	
	public void clickOnLocalEMailInfo()throws Throwable  {
		localEMailInfo.click();
		Thread.sleep(3000);
		
		
	}
	

	
	public void clickOnButtonSubmit()throws Throwable  {
		buttonSubmit.click();
		Thread.sleep(3000);
		
		
	}
	
	public String clickOnSubmitOK()throws Throwable  {
		String incidentNum=getIncidentNumInSubmitOKMsg();
		submitOK.click();//.//*[@id='incident-number']/div[2]/div[2]/table/tbody/tr/td[1]/img
		Thread.sleep(3000);
		return incidentNum;
		
	}
	
	public String getIncidentNumInSubmitOKMsg()throws Throwable  {
		String incidentNum=submitOKMsg.getText();
		System.out.println("Confirm Text="+incidentNum );
		
		int start=incidentNum.indexOf("INC");
		String incident=incidentNum.substring(start, start+15);
		System.out.println("Indexes======"+incident);
		Thread.sleep(3000);
		
		return incident;
	}
	
	
	
	public void clickOnSignOut()throws Throwable  {
		signOut.click();
		Thread.sleep(3000);
		
		
	}
	
	/**************************Negative testing********************************/
	public void validateCircuitIDBoxUnEditable(){
		
		
		if((circuitID.getAttribute("readonly")).equals("true")){
			System.out.println("Verified Uneditable CircuitID BOX");
		}
		else
		{ System.out.println("%%%%%%%%%%% Caught Throwable in validateCircuitIDBoxUnEditable%%%%%%%%%%");}
		
	}
	
public void validateCircuitSearchPopUpText(){
		
	
	//circuitSearchPopUpText
	String Actualtext = circuitSearchPopUpText.getText();
	//String Actualtext2 = circuitSearchPopUpText2.getText();
	try {
		// System.out.println("Actualtext="+Actualtext1 +"<bbbb>"+Actualtext2);
		// Assert.assertEquals(Actualtext2, "844-WIN-CNOC or 844-946-2662");
		Assert.assertEquals(Actualtext, "If the Circuit ID is not found contact Carrier Operations Center to assist you 844-WIN-CNOC or 844-946-2662.");
		
	} catch (Throwable e) {
	//webDriverUtils.takeScreenshot("users__Error");
		System.out.println(e.getMessage());
		Reporter.log("failed due to data is not matching" + e.getLocalizedMessage());
		
	}

		
	}
public void verifyCompanyInfoNote(){
	
	String Actualtext = companyInfoNote.getText();	
	try {
		Assert.assertEquals(Actualtext, "Check accuracy of terminating circuit information to streamline your ticket processing.");
		
	} catch (Throwable e) {
	//webDriverUtils.takeScreenshot("users__Error");
		System.out.println(e.getMessage());
		Reporter.log("failed due to data is not matching" + e.getLocalizedMessage());
		
	}

		
	}



public void verifyAllOtherTicketTypeMsg(){
	
	String Actualtext = allOtherTicketTypeMsg.getText();	
	try {
		Assert.assertEquals(Actualtext, "For all other issues, please contact Carrier Operations Center at 844 -WIN-CNOC or 844-946-2662.");
		
	} catch (Throwable e) {
	//webDriverUtils.takeScreenshot("users__Error");
		System.out.println(e.getMessage());
		Reporter.log("failed due to data is not matching" + e.getLocalizedMessage());
		
	}

		
	}

public void verifyVoiceTicketTypeMsg(){
	
	String Actualtext = voiceTicketTypeMsg.getText();	
	try {
		Assert.assertEquals(Actualtext, "Selecting Voice as a ticket type will redirect you to a new page.");
		
	} catch (Throwable e) {
	//webDriverUtils.takeScreenshot("users__Error");
		System.out.println(e.getMessage());
		Reporter.log("failed due to data is not matching" + e.getLocalizedMessage());
		
	}

		
	}

public void verifyDarkFibreTicketTypeMsg(){
	
	String Actualtext = darkFibreTicketTypeMsg.getText();	
	try {
		Assert.assertEquals(Actualtext, "For Dark Fiber Issues, please contact Carrier Operations Center at 844-WIN-CNOC or 844-946-2662 option 5."+"\n"+"\n"+"Please have your IRU Number and OTDR information ready."); 

		
	} catch (Throwable e) {
	//webDriverUtils.takeScreenshot("users__Error");
		System.out.println(e.getMessage());
		Reporter.log("failed due to data is not matching" + e.getLocalizedMessage());
		
	}

		
	}

public void verifyTroubleTypeList() throws Throwable{
	new Select(troubleType).selectByValue("Degraded Service");
	System.out.println("Found Degraded Service");

}
}

/*
 * manual test cases for carriercabs tickets
TC177076


1)User should not be able to Type in Circuit Id Text box

2)click cancel on circuitid popup
3) enter data in text search

4)At the bottom of the circuit Id search screen there should be always a message which says "If the Circuit ID is not found contact Customer Care to assist you 844-WIN-CNOC or 844-946-2662




5)e At the bottom of the Company information section note displays as -- Note: Check accuracy of terminating circuit information to streamline your ticket processing. " in bold red font

Under Request Details - 

6)a Ticket Type - Choose in Drop-down - All Others

User should see the following message only if the All Other option is chosen


7) User should see the following message only if Voice Tickets is chosen 

8) User will see the following message when selecting Dark Fiber 

9 )The Degraded Service Trouble Types will be available if the Ticket Type is Fiber to Tower or TDM/Ethernet Circuits


http://cwwapp245.windstream.com/SpiraTeam/126/TestCase/List.aspx*/
