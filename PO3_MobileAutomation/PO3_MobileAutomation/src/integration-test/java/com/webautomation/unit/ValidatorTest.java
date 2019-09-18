package com.windstream.unit;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import WebDriver.WebDriverFactory;

import com.windstream.portalautomation.validation.Validator;

public class ValidatorTest {
	
	private WebDriver driver;
	private Validator validator;
	private WebElement webElement;
	
	@BeforeMethod
	public void beforeMethod() {
		driver = WebDriverFactory.getSeleniumWebDriver(WebDriverFactory.CHROME, false, null);
		driver.get("https://www.windstreamonline.com/pol/Home.action");
		validator = new Validator(driver);
		webElement = driver.findElement(By.xpath("//*[@id='Login']/table/tbody/tr/td[2]/div/table/tbody/tr[6]/td/p[2]/a[1]"));	
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
		validator = null;	
		webElement = null;
	}	
	
	
	@Test
	public void checkReportWindowTest() {			
		webElement.click();
		
		String mainWindowName = validator.switchToReportWindow();		
		assertTrue(validator.waitUntilTextIsPresent("Windstream Online FAQs"));
		
		validator.switchToMainWindow(mainWindowName);		
		assertTrue(driver.getWindowHandles().size() == 1);		
	}
	
	@Test
	public void checkReportWindowDidNotOpenTest() {		
		//there is only 1 window, not 2				
		
		String mainWindowName = validator.switchToReportWindow();
		Assert.assertNull(mainWindowName);					
	}
	

}
