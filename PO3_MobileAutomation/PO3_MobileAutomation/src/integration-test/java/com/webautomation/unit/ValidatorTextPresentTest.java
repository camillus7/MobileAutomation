package com.windstream.unit;

import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import WebDriver.WebDriverFactory;
import com.windstream.portalautomation.validation.Validator;

public class ValidatorTextPresentTest {
	
	private WebDriver driver;
	private Validator validator;
	private final String yahooUrl = "http://www.yahoo.com"; 
	private final String mailText = "mail";
	private final String xxxxxxxText = "xxxxxxx";
	private final String mailFailMessage = "failed to find 'mail' text on yahoo.com";
	private final String xxxxxxxFailMessage = "should not find 'xxxxxxx' on yahoo.com";
	
	@BeforeMethod
	public void beforeMethod() {
		driver = WebDriverFactory.getSeleniumWebDriver(WebDriverFactory.CHROME, false, null);
		validator = new Validator(driver);
		validator.getDriver().get(yahooUrl);
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
		validator = null;
	}
	
	@Test
	public void waitUntilValidationTextIsPresentTest() {				
		try {			
			assertTrue(validator.waitUntilValidationTextIsPresent(mailText),mailFailMessage);			
		} catch (InterruptedException e) {
			assertTrue(false,mailFailMessage);
		}			
	}
	
	@Test
	public void waitUntilValidationTextIsPresent_NotFoundTest() {			
		try {			
			assertFalse(validator.waitUntilValidationTextIsPresent(xxxxxxxText),xxxxxxxFailMessage);			
		} catch (InterruptedException e) {
			assertTrue(false);
		}			
	}
	
	@Test
	public void waitUntilTextIsPresentTest() {				
		assertTrue(validator.waitUntilTextIsPresent(mailText),mailFailMessage);			
	}
	
	@Test
	public void waitUntilTextIsPresent_NotFoundTest() {		
		assertFalse(validator.waitUntilTextIsPresent(xxxxxxxText),xxxxxxxFailMessage);	
	}	

}
