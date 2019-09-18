package commonUtil;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.webautomation.validation.Validator;

public class WebDriverUtils {

	/*
	 * private WebDriver driver; private Validator vc;
	 */

	final WebDriver driver;

	private Validator vc;
	private WebDriverWait wait;

	public WebDriverUtils(WebDriver driver) {
		this.driver = driver;

	}

	public void takeScreenshot(String screenShotName) {
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String out = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss").format(new Date());
		try {
			File file = new File(PropertiesUtil.getValue(PropertiesUtil.SCREENSHOT_PATH_PROPERTY) + "/" + out + "/"
					+ screenShotName + out + ".png");
			FileUtils.copyFile(screenShotFile, file);
			Reporter.log(file.getAbsolutePath());

		} catch (Throwable e) {
			System.out.println("Failed to capture screenshot");
		}
		Assert.assertTrue(false, "this will make the test method fail");
	}

	public void takeTestStepScreenshot(String screenShotName) {
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String out = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss").format(new Date());
		try {
			File file = new File(PropertiesUtil.getValue(PropertiesUtil.SCREENSHOT_PATH_PROPERTY) + "/" + out + "/"
					+ screenShotName + out + ".png");
			FileUtils.copyFile(screenShotFile, file);
			Reporter.log(file.getAbsolutePath(), true);

		} catch (Throwable e) {
			System.out.println("Failed to capture screenshot");
		}
	}

	@Deprecated
	public void testFailLogScreenshot(ExtentTest test, String logscreenShotName, String testDescription) {
		File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String out = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss").format(new Date());
		try {
			FileUtils.copyFile(screenShotFile, new File(
					System.getProperty("user.dir") + "/HTML_Reports/Screenshots/" + logscreenShotName + out + ".png"));

			// test.log(LogStatus.ERROR, testDescription);
			String imgpath = test.addScreenCapture(
					System.getProperty("user.dir") + "/HTML_Reports/Screenshots/" + logscreenShotName + out + ".png");

			test.log(LogStatus.FAIL, logscreenShotName + " : " + testDescription, imgpath);
		} catch (Throwable e) {
			System.out.println("Failed to capture screenshot");
		}
	}

	public boolean validateBrowser2(String winHandleBefore, String validateContent) throws InterruptedException {
		vc = new Validator(this.driver);
		Thread.sleep(3000);
		driver.getWindowHandles();

		Set<String> allHandles = driver.getWindowHandles();
		for (String currentHandle : allHandles) {
			if (!currentHandle.equals(winHandleBefore)) {
				driver.switchTo().window(currentHandle);
				System.out.println(driver.switchTo().window(currentHandle).getTitle());
				Assert.assertTrue(vc.waitUntilTextIsPresent(validateContent));
				Reporter.log("Displayed message : " + validateContent + " successfully");
				break;
			}
		}
		driver.close();
		driver.switchTo().window(winHandleBefore);
		return false;
	}

	public boolean validateBrowser2ReportFrame(String winHandleBefore, String validateContent)
			throws InterruptedException {

		Validator vc = new Validator(driver);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.getWindowHandles();
		Set<String> allHandles = driver.getWindowHandles();
		for (String currentHandle : allHandles) {
			if (!currentHandle.equals(winHandleBefore)) {
				driver.switchTo().window(currentHandle);
				System.out.println(driver.switchTo().window(currentHandle).getTitle());
				checkPageIsReady();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				Thread.sleep(2000);
				driver.switchTo().frame("ReportFrameReportViewer1");
				Thread.sleep(500);
				driver.switchTo().frame("report");
				Thread.sleep(500);
				Reporter.log("Focus set to Report frame to Validate the text from the report");
				vc.waitUntilTextIsPresent(validateContent);
				assert (vc.waitUntilTextIsPresent(validateContent));
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				break;
			}
		}
		driver.close();
		driver.switchTo().window(winHandleBefore);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return false;
	}

	public boolean clickLinkText(String linkText) throws InterruptedException {
		Validator vc = new Validator(driver);
		vc.waitUntilTextIsPresent(linkText);
		driver.findElement(By.partialLinkText(linkText)).click();
		checkPageIsReady();
		Reporter.log("Clicked link : " + linkText);
		return false;
	}

	public boolean validateFutureDate(String linkText) throws InterruptedException {
		if (driver.findElements(By.partialLinkText(linkText)).size() != 0) {
			return true;
		} else {
			return false;
		}
	}

	public void validateToolTipText(WebElement element, String testDescription, String validateContent)
			throws InterruptedException {
		// Create action class object
		Actions builder = new Actions(driver);
		Thread.sleep(2000);
		// Mouse hover to that text message and Extract text from tooltip
		builder.moveToElement(driver.findElement(By.xpath("//a[contains(.,'Logout')]"))).build().perform();
		Thread.sleep(2000);
		builder.moveToElement(element).build().perform(); // Get the action
		// takeScreenshot(testDescription);
		Reporter.log("Tooltip displayed = : " + element.getAttribute("data-title"), true);

		if (validateContent.contains(element.getAttribute("data-title"))) {
			Reporter.log(testDescription + " Tool tip:= " + "Tool tip text displayed as expected := "
					+ element.getAttribute("data-title"), true);
		} else {
			Reporter.log(testDescription + " Tool tip text not displayed as expected", true);
			InterruptedException e = new InterruptedException();
			throw e;
		}
		builder.moveToElement(driver.findElement(By.xpath("//a[contains(.,'Logout')]"))).build().perform();
	}

	public void validateToolTipTextTitle(WebElement element, String testDescription, String validateContent)
			throws InterruptedException {
		// Create action class object
		Actions builder = new Actions(driver);
		Thread.sleep(2000);
		// Mouse hover to that text message and Extract text from tooltip
		builder.moveToElement(driver.findElement(By.xpath("//a[contains(.,'Logout')]"))).build().perform();
		Thread.sleep(2000);
		builder.moveToElement(element).build().perform(); // Get the action
		Reporter.log("Tooltip displayed = : " + element.getAttribute("title"), true);

		if (element.getAttribute("title").contains(validateContent)) {
			Reporter.log(testDescription + " Tool tip:= " + "Tool tip text displayed as expected := "
					+ element.getAttribute("title"), true);
		} else if (validateContent.contains(element.getAttribute("title"))) {
			Reporter.log(testDescription + " Tool tip:= " + "Tool tip text displayed as expected := "
					+ element.getAttribute("title"), true);
		} else {
			Reporter.log(testDescription + " Tool tip text not displayed as expected", true);
			InterruptedException e = new InterruptedException();
			throw e;
		}

		builder.moveToElement(driver.findElement(By.xpath("//a[contains(.,'Logout')]"))).build().perform();
	}

	public void validateToolTipTextFromPageSource(WebElement element, String testDescription, String validateContent)
			throws InterruptedException {
		// Create action class object
		Actions builder = new Actions(driver);
		Thread.sleep(2000);
		// Mouse hover to that text message and Extract text from tooltip
		builder.moveToElement(driver.findElement(By.xpath("//a[contains(.,'Logout')]"))).build().perform();
		Thread.sleep(2000);
		builder.moveToElement(element).build().perform(); // Get the action
		if (driver.getPageSource().contains(validateContent)) {

			Reporter.log(testDescription + " Tool tip:= " + "Tool tip text displayed as expected :=" + validateContent,
					true);
		} else {
			Reporter.log(testDescription + " Tool tip text not displayed as expected", true);
			InterruptedException e = new InterruptedException();
			throw e;
		}

		builder.moveToElement(driver.findElement(By.xpath("//a[contains(.,'Logout')]"))).build().perform();
	}

	/*
	 * public void validateToolTipText(WebElement element, String testDescription,
	 * String validateContent) throws InterruptedException { // Create action class
	 * object Actions builder = new Actions(driver); Thread.sleep(2000); // Mouse
	 * hover to that text message and Extract text from tooltip
	 * builder.moveToElement(driver.findElement(By.xpath("//a[contains(.,'Logout')]"
	 * ))) .build().perform(); Thread.sleep(2000);
	 * builder.moveToElement(element).build().perform(); // Get the action
	 * 
	 * String openWindowHandle = driver.getTitle();
	 * System.out.println(openWindowHandle); Thread.sleep(1000); Set<String>
	 * allWindowHandles = driver.getWindowHandles(); for (String currentWindowHandle
	 * : allWindowHandles) { if (!currentWindowHandle.equals(openWindowHandle)) {
	 * driver.switchTo().window(currentWindowHandle);
	 * //System.out.println(driver.getPageSource()); if
	 * (driver.getPageSource().contains(validateContent)) {
	 * Reporter.log("Tool Tip -:="+driver.getPageSource(),true);
	 * Reporter.log(testDescription + " Tool tip:= " +
	 * "Tool tip text displayed as expected",true); } else {
	 * Reporter.log(testDescription +
	 * " Tool tip text not displayed as expected",true); InterruptedException e =
	 * new InterruptedException(); throw e; } } } builder.moveToElement(driver.
	 * findElement(By.xpath("//a[contains(.,'Logout')]"))) .build().perform(); }
	 */

	/**
	 * Wait until element is available and then click it. Wait for up to 120
	 * milliseconds.
	 * 
	 * @param webElement - the element to wait for.
	 * @return WebElement
	 */
	public WebElement clickNoWait(WebElement webElement) {

		System.out.println("Checking if element is clickable");
		try {
			WebElement myDynamicElement = (new WebDriverWait(driver, 120))
					.until(ExpectedConditions.elementToBeClickable(webElement));

			if (myDynamicElement != null && webElement.isEnabled()) {
				// System.out.println("Found element: " + webElement.getText());
				webElement.click();
			}
		} catch (TimeoutException e) {
			System.out.println("Timed out waiting for element");
		}

		return webElement;
	}

	/**
	 * Wait until element is available and then click it. Wait for up to 120
	 * milliseconds. Then wait for the wheel spinner to finish.
	 * 
	 * @param webElement - the element to wait for.
	 * @param spinner    - the cssValue of the wheel spinner to wait for.
	 * @return WebElement
	 */
	public WebElement clickAndWait(WebElement webElement, String spinner) {

		System.out.println("Checking element is clickable ");
		try {
			WebElement myDynamicElement = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions.elementToBeClickable(webElement));

			if (myDynamicElement != null && webElement.isEnabled()) {
				// System.out.println("Found element: " + webElement.getText());
				webElement.click();
			}
		} catch (TimeoutException e) {
			System.out.println("Timed out waiting for element");
		}
		try {
			waitUntilNoWheelSpins(spinner);
		} catch (InterruptedException e) {
			System.out.println("Exception caught " + e.getMessage());
		}

		return webElement;
	}

	@Deprecated
	public boolean clickLinkText(WebDriver driver, String linkText) throws InterruptedException {
		Validator vc = new Validator(driver);
		vc.waitUntilTextIsPresent(linkText);
		driver.findElement(By.partialLinkText(linkText)).click();
		Reporter.log("Clicked link : " + linkText);
		return false;
	}

	public void waitUntilNoWheelSpins(String cssValue) throws InterruptedException {
		System.out.println(driver.findElements(By.cssSelector(cssValue)).size());
		while (driver.findElement(By.cssSelector(cssValue)).isDisplayed()) {
			System.out.println("waiting");
			Thread.sleep(1000);
		}
	}

	@Deprecated
	public void waitUntilNoWheelSpins(WebDriver driver, String cssValue) throws InterruptedException {
		do {
			Thread.sleep(1000);
			System.out.println("waiting");
		} while (driver.findElements(By.cssSelector(cssValue)).size() != 0);
	}

	public long getDateDiff(String Date1, String Date2, TimeUnit timeUnit) throws ParseException {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm aa", Locale.getDefault());

		String startTime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.getDefault())
				.format(simpleDateFormat.parse(Date1));
		System.out.println(startTime);

		String endTime = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.getDefault())
				.format(simpleDateFormat.parse(Date2));
		System.out.println(endTime);

		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date startDate = df.parse(startTime);

		Date endDate = df.parse(endTime);

		long diffInMillies = endDate.getTime() - startDate.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

	public void spinnerWheelImageTimingMethod() throws InterruptedException {
		while (driver.findElement(By.xpath(
				"//*[@id='tollfreesearchactivationdiv']/div/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr/td[2]/table/tbody/tr/td[2]/img"))
				.isDisplayed()) {
			Thread.sleep(2000);
			System.out.println("waiting");
		}
	}

	public void checkPageIsReady() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Initially below if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			Thread.sleep(500);
			System.out.println("Page loaded.");
			return;
		}
		// This loop will iterate for 120 times to check If page Is ready after
		// every 1second.
		// We can replace the value 120 if we need to increase or decrease wait
		// time.
		for (int i = 0; i < 240; i++) {
			try {
				Thread.sleep(5000);
				System.out.println("Waiting for page to load");
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}
	
	public void pageRefresh() throws InterruptedException {
		driver.navigate().refresh();
		checkPageIsReady();
		waitUntilDoubleRingWheelExists();
	}

	public void waitUntilLoadingWheelExists() throws InterruptedException {
		checkPageIsReady();
		try {
			while (driver.findElement(By.xpath("//img[@src='/Images/loading.gif']")).isDisplayed()) {
				Thread.sleep(1000);
				System.out.println("waiting");

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			while (driver.findElement(By.xpath("//div[@ng-show='pageLoading']")).isDisplayed()) {
				Thread.sleep(1000);
				System.out.println("waiting");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void waitUntilDoubleRingWheelExists() throws InterruptedException {
		// checkPageIsReady();
		/*
		 * System.out.println("IsDisplayed :="+driver.findElement(By.xpath(
		 * "//div[@class='lds-double-ring']")).isDisplayed());
		 * System.out.println("IsEnabled :="+driver.findElement(By.xpath(
		 * "//div[@class='lds-double-ring']")).isEnabled()); int
		 * prevCSSCount=driver.findElements(By.cssSelector("div.lds-double-ring")).size(
		 * );
		 */

		try {
			// div[contains(concat(' ', @class, ' '), 'lds-double-ring')]
			while (driver.findElement(By.xpath("//*[@id='LoadingPanel']/div[2]")).isDisplayed()) {
				// while
				// (driver.findElement(By.xpath("//div[@class='lds-double-ring']")).isDisplayed())
				// {
				// div[@style='width:100%;height:100%']
				Thread.sleep(1000);
				System.out.println("loading ---> Double Ring Wheel exists");
				// System.out.println("CSS
				// :="+driver.findElements(By.cssSelector("div.lds-double-ring")).size());

			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception");
		}
		checkPageIsReady();
	}

	public void mouseHoveronElement(WebElement element) throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(element).build().perform();
	}

	@Deprecated
	public void mouseHoveronElementOld(WebElement element) throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//a[contains(.,'Contact Us')]"))).build().perform();
		Thread.sleep(1000);
		builder.moveToElement(element).build().perform();
	}

	public int totalTestCaseCount(String testCaseName, int totalTestCaseCount) throws InterruptedException {
		Reporter.log("*********** ^^^^^^^ ***********  Started Test Case := " + testCaseName
				+ " *********** ^^^^^^^ ***********", true);
		totalTestCaseCount = totalTestCaseCount + 1;
		return totalTestCaseCount;
	}

	public int passCount(String testCaseName, int passCount) throws InterruptedException {
		Reporter.log(" ###  Test Step Pass := " + testCaseName + " ### ", true);
		return passCount = passCount + 1;
	}

	public int failCount(Throwable e, String testCaseName, int failCount) throws InterruptedException {
		failCount = failCount + 1;
		Reporter.log("****  Test Step Fail := " + testCaseName + " Failed ***********", true);
		takeTestStepScreenshot(testCaseName.trim().substring(0, 12) + "_Error");

		// Reporter.log("Message: " + e.getMessage(),true);

		Reporter.log("Failed on method:" + testCaseName + "_Error", true);
		// Reporter.log("Localized Message: " + e.getLocalizedMessage(),true);
		Reporter.log("*************************************************************", true);
		return failCount;
	}

	public void logUserStoryStart(String userStoryDescription, String logMessage) {
		Reporter.log("                                                             ", true);
		Reporter.log("                         " + userStoryDescription + "                                     ",
				true);
		Reporter.log("****************   " + logMessage + "   ****************", true);
	}

	public String logUserStoryEndSuccess(String userStoryDescription, String successMsgDesc) {
		Reporter.log(userStoryDescription + " Successfully executed", true);
		if (!(successMsgDesc == "")) {
			successMsgDesc = successMsgDesc + userStoryDescription + "|";
		} else {
			successMsgDesc = userStoryDescription + "|";
		}
		System.out.println(successMsgDesc);
		return successMsgDesc;
	}

	public String logUserStoryEndFail(String userStoryDescription, String failMsgDesc) {
		Reporter.log("Failed := " + userStoryDescription, true);
		takeTestStepScreenshot(userStoryDescription.replace(" ", "").substring(0, 12) + "_Error");
		if (!(failMsgDesc == "")) {
			failMsgDesc = failMsgDesc + userStoryDescription + "|";
		} else {
			failMsgDesc = userStoryDescription + "|";
		}
		System.out.println(failMsgDesc);

		return failMsgDesc;

	}

	public void displayExecutionResults(String successMsgDesc, String failMsgDesc) {
		Reporter.log("                                                             ", true);
		Reporter.log("^^^^^^^^^^^^^^^^^^^^^^    Execution Results    ^^^^^^^^^^^^^^^^^^^^^^^^^^", true);
		int failCount = failMsgDesc.length() - failMsgDesc.replace("|", "").length();
		int passCount = successMsgDesc.length() - successMsgDesc.replace("|", "").length();
		String totalCount = String.valueOf(passCount + failCount);
		Reporter.log("Total Test Count :=" + totalCount, true);
		Reporter.log("Passed Test Count :=" + String.valueOf(passCount), true);
		Reporter.log("Passed Test Description :=" + successMsgDesc, true);
		Reporter.log("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv", true);
		if (failCount > 0) {
			Reporter.log("Failed Test Count :=" + String.valueOf(failCount), true);
			Reporter.log("Failed Test Description :=" + failMsgDesc, true);
			Reporter.log("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv", true);
			Assert.assertFalse(true);
		} else if (passCount == 0 && failCount == 0) {
			Reporter.log(" ------- Overall Test Failed ------", true);
			Reporter.log(" ---- No test cases executed ----", true);
			Assert.assertFalse(true);
		}
	}

	// New Re-usable methods
	// ******************* Select a Checkbox ******************* //
	public void selectCheckbox(WebElement element, String elementName) {
		try {
			if (element.isSelected()) {
				Reporter.log("Checkbox: " + elementName + " is already selected", true);
				
			} else {
				// Select the checkbox
				element.click();
				checkPageIsReady();
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

	// ******************* Un-Select a Checkbox ******************* //
	public void selectCheckBoxFromList(WebElement element, String valueToSelect) {
		List<WebElement> allOptions = element.findElements(By.tagName("input"));
		for (WebElement option : allOptions) {
			System.out.println("Option value " + option.getText());
			if (valueToSelect.equals(option.getText())) {
				option.click();
				break;
			}
		}
	}

	// ******************* Select By Visible Text ******************* //
	public void selectByVisibleText(WebElement element, String valueToSelect, String elementName) {

		try {
			Select select = new Select(element);
			select.selectByVisibleText(valueToSelect);
			Reporter.log(valueToSelect + " Value selected from dropdown " + elementName, true);
		} catch (NoSuchElementException e) {
			Reporter.log("Value not found in dropdown", true);

		}
		// Verifying if selected value is displaying or not
		Assert.assertEquals(getSelectedOption(element), valueToSelect, "Selected Value not displaying");
	}

	// ******************* Select By Index ******************* //
	public void selectByIndexValue(WebElement element, int indexVal, String elementName) {

		try {
			Select select = new Select(element);
			select.selectByIndex(indexVal);
			Reporter.log(getSelectedOption(element) + " Value selected from dropdown " + elementName, true);
		} catch (NoSuchElementException e) {
			Reporter.log("Value not found in dropdown", true);

		}
	}

	// ******************* Select By Value ******************* //
	public void selectByValue(WebElement element, String valueToSelect, String elementName) {

		try {
			Select select = new Select(element);
			select.selectByValue(valueToSelect);
			Reporter.log(valueToSelect + " Value selected from dropdown " + elementName, true);
		} catch (NoSuchElementException e) {
			System.out.println("Value not find in dropdown");

		}
		// Verifying if selected value is displaying or not
		Assert.assertEquals(getSelectedOption(element), valueToSelect, "Selected Value not displaying");
	}

	// ************** Set a Value in Edit Box/Text Field *****//
	public void enterText(WebElement element, String strValue, String elementName) {
		try {
			highLightElement(element);
			element.clear();
			element.sendKeys(strValue);
			Reporter.log(strValue + " entered in the " + elementName + " field", true);
		} catch (NoSuchElementException e) {
			Reporter.log(elementName + " : element not found", true);

		}
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

	// ************** Get Attribute *****//
	public String getAttribute(WebElement element, String attribute, String elementName) {
		String getValue = element.getAttribute(attribute);
		Reporter.log("Attribute '" + attribute + "' Value for element " + elementName + " displayed as " + getValue,
				true);
		return getValue;
	}

	// ************** Select Span DropDown Value *****//
	public void selectSpanDropDownValue(WebElement element, String elementName, String spanValue)
			throws InterruptedException {
		clickElement(element, elementName);
		String xpathContent = "//span[contains(.," + "'" + spanValue + "'" + ")]";
		driver.findElement(By.xpath(xpathContent)).click();
		Reporter.log("Selected value :" + spanValue + " for  " + elementName + " dropdown", true);
	}
	// ************** Select DropDown Value *****//
	// eleDropDownButton is the element which shows the list
	// eleDropDownList is the list of items

	@Deprecated
	public boolean dropDownInnerSelectPicker(WebElement eleDropDownButton, WebElement dropDownList, String elementName,
			String selectValue) throws InterruptedException {
		eleDropDownButton.click();
		boolean searchFlag = false;
		List<WebElement> childs = dropDownList.findElements(By.tagName("li"));
		System.out.println("Size := " + childs.size());
		for (WebElement e : childs) {
			System.out.println(e.getAttribute("innerHTML"));
			if (e.getAttribute("innerHTML").contains(selectValue)) {
				if (e.isDisplayed() && e.getAttribute("class") != "selected") {
					e.click();
				} else {
					try {
						Actions builder = new Actions(driver);
						builder.moveToElement(e).build().perform(); // Get the action
						builder.moveToElement(e).click();
						e.click();
					} catch (Exception e2) {
						JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
						jsExecutor.executeScript("arguments[0].click();", e);
					}
				}
				Reporter.log("Successfully selected value :" + selectValue + " from dropdown :" + elementName, true);
				searchFlag = true;
				break;
			}
		}
		return searchFlag;
	}

	@Deprecated
	public boolean dropDownSelectFirstItem(WebElement eleDropDownButton, WebElement dropDownList, String elementName)
			throws InterruptedException {
		eleDropDownButton.click();
		boolean searchFlag = false;
		List<WebElement> childItems = dropDownList.findElements(By.tagName("li"));
		System.out.println("No of items in the " + elementName + " drop down := " + childItems.size());
		int itemCount = 0;
		for (WebElement e : childItems) {
			itemCount = itemCount + 1;
			System.out.println("Item " + itemCount + ":= " + e.getText());
			// if (!e.getText().contains("Select")) {
			if (e.getText() != null && !e.getText().trim().isEmpty() && (!e.getText().contains("Select"))) {
				Actions builder = new Actions(driver);
				builder.moveToElement(e).build().perform(); // Get the action
				builder.moveToElement(e).click();
				e.click();
				break;
			}
			// }
		}
		return searchFlag;
	}

	/*
	 * public boolean dropDownInnerSelectPicker(WebElement
	 * eleDropDownButton,WebElement dropDownList,String elementName,String
	 * selectValue) throws InterruptedException { eleDropDownButton.click(); boolean
	 * searchFlag=false; List<WebElement> childs =
	 * dropDownList.findElements(By.tagName("li"));
	 * System.out.println("Size := "+childs.size()); for (WebElement e : childs) {
	 * System.out.println(e.getAttribute("innerHTML")); if
	 * (e.getAttribute("innerHTML").contains(selectValue)) { if (e.isDisplayed() &&
	 * e.getAttribute("class")!="selected") { e.click(); } else { try { Actions
	 * builder = new Actions(driver); builder.moveToElement(e).build().perform(); //
	 * Get the action builder.moveToElement(e).click(); e.click(); } catch
	 * (Exception e2) { JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	 * jsExecutor.executeScript("arguments[0].click();", e); } }
	 * Reporter.log("Successfully selected value :"+selectValue+
	 * " from dropdown :"+elementName,true); searchFlag=true; break; } } return
	 * searchFlag; }
	 */
	public boolean selectDropDownDefaultFirstItem(WebElement dropDownElement, String elementName)
			throws InterruptedException {
		boolean searchFlag = false;

		Select childItems = new Select(dropDownElement);
		WebElement selectedOption = childItems.getFirstSelectedOption();
		System.out.println(selectedOption.getText());
		if (!selectedOption.getText().contains("Select")) {
			Reporter.log("Default Selected value: " + selectedOption.getText() + " for dropdown " + elementName, true);
			searchFlag = true;
		} else {
			List<WebElement> options = childItems.getOptions();
			System.out.println("No of items in the " + elementName + " drop down := " + options.size());

			for (WebElement option : options) {
				System.out.println(option.getText());
				if (!option.getText().contains("Select")) {
					option.click();
					Reporter.log("Selected value: " + option.getText() + " for dropdown " + elementName, true);
					searchFlag = true;
					break;
				}
			}
		}
		return searchFlag;
	}

	public boolean genericDropDownSelectSpecificValue(WebElement eleDropDownButton, String elementName,
			String selectValue) throws InterruptedException {
		eleDropDownButton.click();
		boolean searchFlag = false;
		List<WebElement> childDropDowns = driver.findElements(
				By.xpath("//ul[contains(concat(' ', @class, ' '), 'dropdown-menu inner selectpicker ddown-active')]"));
		// System.out.println("No of items in the "+ elementName+ " drop down :=
		// "+childDropDowns.size());
		int childDDCount = 0;
		for (WebElement e : childDropDowns) {
			childDDCount = childDDCount + 1;
			if (e.isDisplayed()) {
				List<WebElement> childItems = e.findElements(By.tagName("li"));
				System.out.println("No of items in the " + elementName + " drop down := " + childItems.size());
				int itemCount = 0;
				for (WebElement f : childItems) {
					itemCount = itemCount + 1;
					System.out.println("Item " + itemCount + ":= " + f.getAttribute("innerHTML"));
					// if(f.getText() != null && !f.getText().trim().isEmpty() &&
					// (!f.getText().contains("Select")) &&
					// f.getAttribute("innerHTML").contains(selectValue)) {
					if (f.getAttribute("innerHTML").contains(selectValue)) {
						Actions builder = new Actions(driver);
						builder.moveToElement(f).build().perform(); // Get the action
						builder.moveToElement(f).click();
						f.click();
						searchFlag = true;
						if (e.isDisplayed()) {
							eleDropDownButton.click();
						}
						break;
						// }
					}
				}
			}
			if (searchFlag) {
				break;
			}
		}
		return searchFlag;
	}

	public boolean genericDropDownSelectFirstItem(WebElement eleDropDownButton, String elementName)
			throws InterruptedException {
		eleDropDownButton.click();
		boolean searchFlag = false;
		List<WebElement> childDropDowns;

		/*
		 * if (elementName.equalsIgnoreCase("chooseLocation")) { childDropDowns =
		 * driver.findElements(By.xpath("//ul[@ng-click='chooseLocation()']")); } else
		 * if (elementName.equalsIgnoreCase("chooseAccount")) { childDropDowns =
		 * driver.findElements(By.xpath("//ul[@ng-click='chooseAccount()']")); } else {
		 * childDropDowns = driver.findElements(By.xpath(
		 * "//ul[contains(concat(' ', @class, ' '), 'dropdown-menu inner selectpicker ddown-active')]"
		 * )); }
		 */

		if (elementName.equalsIgnoreCase("chooseLocation")) {
			childDropDowns = driver.findElements(By.xpath("//ul[@ng-click='chooseLocation($event)']"));
		} else if (elementName.equalsIgnoreCase("chooseAccount")) {
			childDropDowns = driver.findElements(By.xpath("//ul[@ng-click='chooseAccount($event)']"));
		} else {
			childDropDowns = driver.findElements(By.xpath(
					"//ul[contains(concat(' ', @class, ' '), 'dropdown-menu inner selectpicker ddown-active')]"));
		}

		// List<WebElement> childDropDowns =
		// driver.findElements(By.xpath("//*[@class='mCSB_container']/ul"));
		System.out.println("No of items in the " + elementName + " drop down := " + childDropDowns.size());
		int childDDCount = 0;
		for (WebElement e : childDropDowns) {
			childDDCount = childDDCount + 1;
			if (e.isDisplayed()) {
				List<WebElement> childItems = e.findElements(By.tagName("li"));
				Reporter.log("No of items in the " + elementName + " drop down := " + childItems.size(),true);
				int itemCount = 0;
				for (WebElement f : childItems) {
					itemCount = itemCount + 1;
					System.out.println("Item " + itemCount + ":= " + f.getText());
					if (f.getText() != null && !f.getText().trim().isEmpty() && (!f.getText().contains("Select"))
							&& (!f.getText().contains("Choose")) && (!f.getText().contains("Show All"))) {
						Actions builder = new Actions(driver);
						builder.moveToElement(f).build().perform(); // Get the action
						builder.moveToElement(f).click();
						f.click();
						searchFlag = true;
						try {
							Reporter.log("Selected Value:=" + eleDropDownButton.getText(), true);
							waitUntilLoadingWheelExists();
						} catch (Exception e2) {
							// TODO: handle exception
						}

						break;
					}
				}
			}
			if (searchFlag) {
				break;
			}
		}
		return searchFlag;
	}

	// subsubmenu open Ex: class='subsubmenu open'
	public boolean clickSubMenuOption(String strSubMenuName) throws InterruptedException {
		boolean clickFlag = false;
		List<WebElement> childs = driver.findElements(By.cssSelector("div.subsubmenu.open"));
		System.out.println("Size of Submenu:= " + childs.size());
		for (WebElement e1 : childs) {
			List<WebElement> childMenu = e1.findElements(By.tagName("a"));
			for (WebElement e2 : childMenu) {
				// System.out.println(e2.getAttribute("innerHTML"));
				if (e2.getText().contains(strSubMenuName)) {
					System.out.println("Clicking :=" + e2.getAttribute("innerHTML"));
					highLightAndClickMethod(e2);
					// e2.click();
					Reporter.log("Successfully clicked menu :" + strSubMenuName, true);
					clickFlag = true;
					break;
				}
			}
		}
		return clickFlag;
	}

	// ************** Click an Element (Link/Button) *****//
	public void clickElement(WebElement element, String elementName) throws InterruptedException {
		checkPageIsReady();
		try {
			WebElement myDynamicElement = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.elementToBeClickable(element));

			if (myDynamicElement != null && element.isEnabled()) {
				final long startTime = System.nanoTime();
				// mouseHoveronElement(element);
				highLightAndClickMethod(element);
				// element.click();
				// waitUntilNoWheelSpins(".lds-double-ring>div");
				checkPageIsReady();
				final long duration = System.nanoTime() - startTime;
				long seconds = TimeUnit.NANOSECONDS.toSeconds(duration);
				// Reporter.log("Clicked on " + elementName +" loaded in
				// "+(duration/1000000000)+ " seconds", true);
				Reporter.log("Clicked on " + elementName + " loaded in " + (seconds) + " seconds", true);
				checkPageIsReady();
				waitUntilDoubleRingWheelExists();

			}
		} catch (NoSuchElementException e) {
			Reporter.log("Timed out waiting for element := " + elementName, true);
			Assert.assertFalse(true);
		}
	}

	public void clickHiddenElement(WebElement element, String elementName) throws InterruptedException {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].click();", element);
			Reporter.log("Clicked on " + elementName, true);
			checkPageIsReady();
		} catch (Exception e) {
			Reporter.log("Timed out waiting for element := " + elementName, true);
			Assert.assertFalse(true);
		}
	}

	public void scrollToViewElement(WebElement element, String elementName) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
	}

	public void scrollBy() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(250, 350)");
	}

	// Custom method to highlight and Click an element
	public void highLightAndClickMethod(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: none; border: 2px solid red;');",
				element);
		element.click();
		// jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void highLightElement(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
				element);
	}

	// ************** select Radio Button *****//
	public void selectRadioButton(WebElement element, String elementName) throws InterruptedException {
		boolean checkstatus;
		checkPageIsReady();
		checkstatus = element.isSelected();
		if (checkstatus == true) {
			Reporter.log(elementName + " : RadioButton already selected", true);
		} else {
			element.click();
			Reporter.log(elementName + " Radiobutton Selected ", true);
		}
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

	// getSelectedOption
	public String getSelectedOption(WebElement element) {
		Select select = new Select(element);
		WebElement selectedElement = select.getFirstSelectedOption();
		String selectedOption = selectedElement.getText();
		return selectedOption;
	}

	// Check for elementAvailablity
	public boolean elementAvailablity(WebElement elementType, String elementName) {
		Reporter.log("Searching for element :=" + elementName, true);
		boolean elementIdentifier = false;
		try {

			wait = new WebDriverWait(driver, 60);
			if (wait.until(ExpectedConditions.elementToBeClickable(elementType)) != null) {
				WebElement element = elementType;

				if (element.isDisplayed()) {
					elementIdentifier = true;
					if (elementName != null && !elementName.isEmpty())
						Reporter.log("Web element = '" + elementName + "' is identified successfully", true);

				}

			} else {
				elementIdentifier = false;

				if (elementName != null && !elementName.isEmpty())
					Reporter.log("Web element = '" + elementName + "' is not identified", true);
			}
		} catch (Exception e) {
			Reporter.log("Timed out waiting for element := " + elementName, true);
			if (elementName != null && !elementName.isEmpty())
				Reporter.log("Web element = '" + elementName + "' is not identified", true);
			// Assert.fail("TIMEOUT EXCEPTION element does not exist " + elementName);
		}
		return elementIdentifier;

	}

	public void clickMobileElement(WebElement elementtype, String elementName) {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 60);
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

	// This method will get the text of an element
	public String getText(WebElement elementtype, String elementName) throws InterruptedException {
		String returnText = null;
		checkPageIsReady();
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

	public void mobile_waituntillText(WebElement text, String errorMsg) {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		if (wait.until(ExpectedConditions.visibilityOf(text)) != null) {
			String verificationText = text.getText();
			Assert.assertEquals(verificationText, errorMsg);
			Reporter.log(verificationText, true);
		} else {
			Assert.assertFalse(true);
		}
	}

	// Get Dropdown Values
	public void dropdownSelect(WebElement dropdown, String dropDownValue) throws InterruptedException {

		vc.getWebDriverUtils().clickElement(dropdown, "Dropdown");
		List<WebElement> forExtensionDropdown = driver
				.findElements(By.xpath("//div[@class='btn-group bootstrap-select open']/div/div/div/div/ul/li/a/span"));
		Reporter.log("Total Number of Dropdown values are ==" + forExtensionDropdown.size(), true);
		for (int i = 0; i < forExtensionDropdown.size(); i++) {

			if (forExtensionDropdown.get(i).getText().equalsIgnoreCase(dropDownValue)) {
				forExtensionDropdown.get(i).click();
				Reporter.log("Selected ==" + dropDownValue + "from For Extension Dropdown", true);
				break;
			}

		}

	}

	// verify Element Present
	public boolean isElementPresentCheckUsingJavaScriptExecutor(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		try {
			Object obj = jse.executeScript("return typeof(arguments[0]) != 'undefined' && arguments[0] != null;",
					element);
			;
			if (obj.toString().contains("true")) {
				System.out.println("isElementPresentCheckUsingJavaScriptExecutor: SUCCESS" + element.toString());
				return true;
			} else {
				System.out.println("isElementPresentCheckUsingJavaScriptExecutor: FAIL" + element.toString());
			}
		} catch (NoSuchElementException e) {
			System.out.println("isElementPresentCheckUsingJavaScriptExecutor: FAIL");
		}
		return false;
	}

	public void scrollPage(WebElement widgetname) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", widgetname);
	}

	public static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");// dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

	public boolean elementEnable(WebElement elementType, String elementName) {
		Reporter.log("Searching for element :=" + elementName, true);
		boolean elementIdentifier = false;
		try {

			wait = new WebDriverWait(driver, 20);
			if (wait.until(ExpectedConditions.elementToBeClickable(elementType)) != null) {
				WebElement element = elementType;

				if (element.isEnabled()) {
					elementIdentifier = true;
					if (elementName != null && !elementName.isEmpty())
						Reporter.log("Web element = '" + elementName + "' is enabled ", true);

				}

			} else {
				elementIdentifier = false;

				if (elementName != null && !elementName.isEmpty())
					Reporter.log("Web element = '" + elementName + "' is disabled ", true);
			}
		} catch (Exception e) {
			Reporter.log("Timed out waiting for element := " + elementName, true);
			if (elementName != null && !elementName.isEmpty())
				Reporter.log("Web element = '" + elementName + "' is not identified", true);
			// Assert.fail("TIMEOUT EXCEPTION element does not exist " + elementName);
		}
		return elementIdentifier;

	}

	public void validatePageTitle(String expectedTitle) {
		if (driver.getTitle().trim().contains(expectedTitle)) {
			Reporter.log("Page Title displayed as expected := " + driver.getTitle(), true);
		} else {
			Reporter.log("Page Title not displayed as expected := " + expectedTitle + " and actual is :="
					+ driver.getTitle(), true);
			Assert.assertFalse(true);
		}
	}
}
