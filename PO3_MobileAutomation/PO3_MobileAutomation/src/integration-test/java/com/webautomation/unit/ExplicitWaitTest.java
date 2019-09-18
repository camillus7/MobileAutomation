package com.windstream.unit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import WebDriver.WebDriverFactory;

import com.windstream.portalautomation.validation.Validator;

public class ExplicitWaitTest {	
	
	private WindstreamonlineTestPage windstreamonlineTestPage;
	private Validator validator;
	private WebDriver driver;	
	
	@BeforeMethod
	public void beforeMethod() {
		driver = WebDriverFactory.getSeleniumWebDriver(WebDriverFactory.CHROME, false, null);
		driver.get("https://www.windstreamonline.com/pol/Home.action");		
		windstreamonlineTestPage = PageFactory.initElements(driver, WindstreamonlineTestPage.class);
		validator = new Validator(driver);
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}		
	
	@Test
	public void visibleAndClickable() {
		Assert.assertTrue(validator.clickElementEnabledCheck(windstreamonlineTestPage.faq));
		Assert.assertTrue(validator.waitForElement(windstreamonlineTestPage.faq,5));
		
		//strange, but true, a title (text), is considered clickable, however nothing will happen if you click it.
		Assert.assertTrue(validator.clickElementEnabledCheck(windstreamonlineTestPage.title));
	}
	
	@Test
	public void elementDoesNotShowUp() {
		Assert.assertFalse(validator.waitForElement(windstreamonlineTestPage.fake, 10));			
	}
	
	@Test
	public void waitingForElementToBeVisible() {
		Assert.assertFalse(validator.waitForElementToBeVisible(windstreamonlineTestPage.fake, 10));	
		Assert.assertTrue(validator.waitForElementToBeVisible(windstreamonlineTestPage.title, 5));
		Assert.assertTrue(validator.waitForElementToBeVisible(windstreamonlineTestPage.faq, 5));
	}

}
