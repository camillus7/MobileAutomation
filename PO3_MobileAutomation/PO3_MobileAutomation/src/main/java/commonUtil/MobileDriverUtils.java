package commonUtil;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.webautomation.validation.Validator;

public class MobileDriverUtils {

	/*
	 * private WebDriver driver; private Validator vc;
	 */

	final WebDriver driver;

	private Validator vc;
	private WebDriverWait wait;

	public MobileDriverUtils(WebDriver driver) {
		this.driver = driver;

	}

	

	public void mobile_EnterText(WebElement element, String strValue, String elementName) {
		try {
			element.clear();
			element.sendKeys(strValue);
			Reporter.log(strValue + " entered in the " + elementName + " field", true);
		} catch (NoSuchElementException e) {
			Reporter.log(elementName + " : element not found", true);

		}
	}
	
	public void selectDropDown_FirstItem(WebElement eleDropDownButton,WebElement dropDownList, String elementName) throws InterruptedException {

		eleDropDownButton.click();
		Reporter.log(elementName + " is clicked", true);

		elementAvailablity(dropDownList, "Dropdown-List");
		List<WebElement> dropdownList = driver.findElements(By.id("com.windstream.enterprise.we.dev:id/listItem"));
		System.out.println("No of items in the " + elementName + " is := " + dropdownList.size());

		for (int i = 0; i < dropdownList.size();) {

			String SelectedValue = dropdownList.get(0).getText();
			Reporter.log("Selected Value from " + elementName + " is " + SelectedValue, true);
			dropdownList.get(0).click();
			break;
		}

	}
	
	public void selectDropDown_Index(WebElement eleDropDownButton,WebElement dropDownList, String elementName,int index)
			throws InterruptedException {
		eleDropDownButton.click();
		Reporter.log(elementName + " is clicked",true);
		
		elementAvailablity(dropDownList, "List");
		List<WebElement> dropdownList = driver.findElements(By.id("com.windstream.enterprise.we.dev:id/listItem"));
		System.out.println("No of items in the " + elementName + " is := " + dropdownList.size());
		
		for(int i=0;i<dropdownList.size();) {
			
			String SelectedValue = dropdownList.get(index).getText();
			Reporter.log("Selected Value from " + elementName + " is " + SelectedValue,true);
			dropdownList.get(index).click();
			break;
		}
		
	
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

	// ************** Get Attribute *****//
	public String getAttribute(WebElement element, String attribute, String elementName) {
		String getValue = element.getAttribute(attribute);
		Reporter.log("Attribute '" + attribute + "' Value for element " + elementName + " displayed as " + getValue,
				true);
		return getValue;
	}

	public void selectMobileRadioButton(WebElement element, String elementName) {

		String checkstatus = element.getAttribute("checked");
		if (checkstatus.equals("true")) {
			Reporter.log(elementName + " : RadioButton already selected", true);
		} else {
			sleep(2000);
			element.click();
			Reporter.log(elementName + " Radiobutton Selected ", true);
		}
	}

	// Check for elementAvailablity
	public boolean elementAvailablity(WebElement elementType, String string) {
		Reporter.log("Searching for element :=" + string, true);
		boolean elementIdentifier = false;
		try {

			wait = new WebDriverWait(driver, 30);
			if (wait.until(ExpectedConditions.elementToBeClickable(elementType)) != null) {
				WebElement element = elementType;

				if (element.isDisplayed()) {
					elementIdentifier = true;
					if (string != null && !string.isEmpty())
						Reporter.log("Web element = '" + string + "' is identified successfully", true);

				}

			} else {
				elementIdentifier = false;

				if (string != null && !string.isEmpty())
					Reporter.log("Web element = '" + string + "' is not identified", true);
			}
		} catch (Exception e) {
			Reporter.log("Timed out waiting for element := " + string, true);
			if (string != null && !string.isEmpty())
				Reporter.log("Web element = '" + string + "' is not identified", true);
		}
		return elementIdentifier;

	}

	public void clickMobileElement(WebElement elementtype, String elementName) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(elementtype));

			if (elementtype.isDisplayed() && elementtype.isEnabled()) {
				final long startTime = System.nanoTime();
				elementtype.click();

				final long duration = System.nanoTime() - startTime;
				long seconds = TimeUnit.NANOSECONDS.toSeconds(duration);
				Reporter.log("Clicked on " + elementName + " loaded in " + (seconds) + " seconds", true);
			}

		} catch (Exception e) {
			Reporter.log("Timed out waiting for element := " + elementName, true);
			TestLogger.elementIdentifierFail("" + elementName);
			Assert.fail("TIMEOUT EXCEPTION element does not exist " + elementName);
		}
	}
	
	public void clickMobileElement_macro(WebElement elementtype, String elementName) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(elementtype));

			if (elementtype.isDisplayed() && elementtype.isEnabled()) {
				final long startTime = System.nanoTime();
				elementtype.click();

				final long duration = System.nanoTime() - startTime;
				long seconds = TimeUnit.NANOSECONDS.toSeconds(duration);
				if (seconds < 10) {
					Reporter.log("ResponseTime_Info -> Clicked on " + elementName + " - page loaded in " + (seconds)
							+ " seconds", true);
				} else {
					Reporter.log("ResponseTime_Warning -> Clicked on " + elementName + " - page loaded in " + (seconds)
							+ " seconds", true);
				}
			}

		} catch (Exception e) {
			Reporter.log("Timed out waiting for element := " + elementName, true);
			TestLogger.elementIdentifierFail("" + elementName);
			Assert.fail("TIMEOUT EXCEPTION element does not exist " + elementName);
		}
	}
	
	

	// ******************* Select a Checkbox ******************* //
		public void selectCheckbox(WebElement element, String elementName) {
			try {
				if (element.isSelected()) {
					Reporter.log("Checkbox: " + elementName + " is already selected", true);
					
				} else {
					// Select the checkbox
					element.click();
					Reporter.log("Checkbox: " + elementName + " successfully checked", true);
				}
			} catch (Exception e) {
				Reporter.log("Unable to select the checkbox: " + elementName, true);
			}
		}
		

		// ******************* Un-Select a Checkbox ******************* //
		public void unSelectCheckbox(WebElement element, String elementName) {
			try {
				if (element.isSelected()) {
					// De-select the checkbox
					element.click();
					Reporter.log("Checkbox: " + elementName + "successfully unchecked", true);
				} else {
					Reporter.log("Checkbox: " + elementName + "is already unchecked", true);
				}
			} catch (Exception e) {
				Reporter.log("Unable to uncheck checkbox: " + elementName, true);
			}
		}
		
		// ***************** SelectTab ***********************************//
		public void selectTab(WebElement element, String elementName) {
			try {
				if (element.isSelected()) {
					Reporter.log("Tab: " + elementName + " is already selected", true);
					
				} else {
					element.click();
					Reporter.log("Tab: " + elementName + " successfully selected", true);
				}
			} catch (Exception e) {
				Reporter.log("Unable to select the Tab: " + elementName, true);
			}
		}
		
	// This method will get the text of an element
	public String getText(WebElement elementtype, String elementName) throws InterruptedException {
		String returnText = null;
		try {

			wait = new WebDriverWait(driver, 20);
			if (wait.until(ExpectedConditions.elementToBeClickable(elementtype)) != null && elementtype.isDisplayed()) {
				returnText = elementtype.getText();
				Reporter.log("Get text for element " + elementName + " := " + returnText, true);
			}
		} catch (NoSuchElementException e) {
			Reporter.log(elementName + " : element not found", true);

		}
		return returnText;
	}

	public void sleep(long millisecs) {
		try {
			Thread.sleep(millisecs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void titleVerification(String aTitle, String eTitle) {
		Assert.assertEquals(aTitle, eTitle);
		Reporter.log("Successfully Navigated To==> " + aTitle, true);
	}

	public void mobileNavigation(WebElement link, WebElement actualtext, String expText, String pageName) {
		clickMobileElement(link, pageName);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		if (wait.until(ExpectedConditions.visibilityOf(actualtext)) != null) {
			String verificationText = actualtext.getText();
			Assert.assertEquals(verificationText, expText, "Navigation Failed");
			Reporter.log("Successfully Navigated To==> " + pageName + " Page ", true);
			driver.navigate().back();
		} else {
			Assert.assertFalse(true);
		}
	}
	
	public boolean waituntillTextisPresent(String validationText) {

		int searchFlag=0;
		int attemptCount = 1;
		int maxAttempts = 11;
		int sleepInterval = 1000;
			Reporter.log("Searching for := "+ validationText,true);	
			
		if(validationText.contains(validationText.toLowerCase())) {
			Reporter.log("Page Title for " + validationText + " is true");
			searchFlag=1;
		}else {
			
		foundIt:
		while (attemptCount <= maxAttempts ) {
			if (validationText.contains(validationText.toLowerCase())) {
				Reporter.log("Page Source for " + validationText + " is true",true);
				searchFlag=1;
				break foundIt;
			} else {					
				try {
					Thread.sleep(sleepInterval);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			attemptCount++;
		}		
	}	
	if (searchFlag==0) {
		Reporter.log("Page Source for " + validationText + " is not found",true);
	}
	return (attemptCount <= maxAttempts) ? true : false;
	}

	public void mobile_waituntillText(WebElement text, String errorMsg) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		if (wait.until(ExpectedConditions.visibilityOf(text)) != null) {
			String verificationText = text.getText();
			Assert.assertEquals(verificationText, errorMsg);
			Reporter.log(verificationText, true);
		} else {
			Assert.assertFalse(true);
		}
	}
	
	public void printList(List<WebElement> listItem,String menuTitle) {
		Reporter.log("LISTED OPTIONS ARE==> " + menuTitle.toUpperCase(),true);
		for(WebElement menus:listItem) {
			Reporter.log( menus.getText(),true);
		}
	}
	
	public void clickFirstRecord(List<WebElement> recordName) {
		for(int i=0;i<recordName.size();i++) {
			
			clickMobileElement(recordName.get(0), "RecordName");
			
	
		}
	}
	
	public void selectFirstItem(List<WebElement> recordName,String pageTitle) {
		for(int i=0;i<recordName.size();) {
			
			String selectedItem = recordName.get(0).getText();
			Reporter.log("SELECTED " + selectedItem.toUpperCase(), true);
			recordName.get(0).click();			
			break;
		}
	}
	
	public List<String> getNamesFromList(List<WebElement> contactNames) {

		List<String> allNames = new ArrayList<String>();
		for (int i = 0; i < contactNames.size(); i++) {
			String namesList = contactNames.get(i).getText();
			allNames.add(namesList);
		}
		return allNames;
	}
	
	public boolean validateCreditCard(String cardNo) throws InterruptedException {

		boolean cardAvailability = false;
		Reporter.log("Verify card no "+ cardNo + "is available in Manage Payment Method screen",true);
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
	
	public boolean searchandClick(WebElement searchField,String searchtext,List<WebElement> searchRecords){
		boolean recordAvailability = false;
		clickMobileElement(searchField, "SearchField");
		mobile_EnterText(searchField, searchtext, "Searchtext");
		for(int i=0;i<searchRecords.size();i++){
			if(searchRecords.get(i).getText().contains(searchtext)){
				recordAvailability = true;
				Reporter.log("RECORD IS AVAILABLE",true);
				searchRecords.get(i).click();
			}else{
				recordAvailability = false;
				Reporter.log("RECORD IS NOT AVAILABLE",true);
				Assert.assertFalse(true);
			}
		}
		return recordAvailability;
	}
	
}
