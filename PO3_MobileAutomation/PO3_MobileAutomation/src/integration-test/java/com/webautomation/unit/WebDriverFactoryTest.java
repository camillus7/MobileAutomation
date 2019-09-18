package com.windstream.unit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebDriver.ApplicationWebDriver;
import WebDriver.WebDriverFactory;


public class WebDriverFactoryTest {
		
	@Test
	public void getWebDriverGridFalseTest() {		
		
		WebDriver driver;
		
		try {
			driver = (ChromeDriver) WebDriverFactory.getWebDriver("chrome").getWebDriver();
			driver.close();			
		} catch (Exception e) {
			Assert.assertTrue(false, "Failed to get a ChromeDriver object.");			
		}
			
//		try {
//			driver = (FirefoxDriver) WebDriverFactory.getWebDriver("firefox").getWebDriver();
//			driver.close();			
//		} catch (Exception e) {
//			Assert.assertTrue(false, "Failed to get a FirefoxDriver object.");			
//		}
		
		try {
			driver = (InternetExplorerDriver) WebDriverFactory.getWebDriver("ie").getWebDriver();
			driver.close();			
		} catch (Exception e) {			
			Assert.assertTrue(false, "Failed to get a InternetExplorerDriver object.");			
		}
		
	}
	
	@Test
	public void getSeleniumWebDriverGridFalseTest() {		
			
		WebDriver driver;
		
		try {
			driver = (ChromeDriver) WebDriverFactory.getSeleniumWebDriver(WebDriverFactory.CHROME, false, null);
			driver.close();			
		} catch (Exception e) {
			Assert.assertTrue(false, "Failed to get a ChromeDriver object.");	
		}	
		
//		try {
//			driver = (FirefoxDriver) WebDriverFactory.getSeleniumWebDriver(WebDriverFactory.FIREFOX, false, null);
//			driver.close();			
//		} catch (Exception e) {
//			Assert.assertTrue(false, "Failed to get a FirefoxDriver object.");			
//		}		
		
		try {
			driver = (InternetExplorerDriver) WebDriverFactory.getSeleniumWebDriver(WebDriverFactory.IE, false, null);
			driver.close();			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false, "Failed to get a InternetExplorerDriver object.");			
		}
		
	}
	
	@Test
	public void getWebDriverCaseInsensitiveTest() {		
		
		WebDriver driver;
		
		try {
			driver = (ChromeDriver) WebDriverFactory.getWebDriver("cHRome").getWebDriver();
			driver.close();			
		} catch (Exception e) {
			Assert.assertTrue(false, "Failed to get a ChromeDriver object.");			
		}
			
//		try {
//			driver = (FirefoxDriver) WebDriverFactory.getWebDriver("fireFOX").getWebDriver();
//			driver.close();			
//		} catch (Exception e) {
//			Assert.assertTrue(false, "Failed to get a FirefoxDriver object.");			
//		}
		
		try {
			driver = (InternetExplorerDriver) WebDriverFactory.getWebDriver("iE").getWebDriver();
			driver.close();			
		} catch (Exception e) {			
			Assert.assertTrue(false, "Failed to get a InternetExplorerDriver object.");			
		}		
		
	}
	
	@Test
	public void getWebDriverErrorTest() {		
		
		ApplicationWebDriver driver;
		
		try {
			driver = WebDriverFactory.getWebDriver("this browser name does not exist");
			Assert.assertTrue(null == driver, "Failed to return null when browser name is misspelled or not 'chrome', 'ie', or 'firefox'");				
		} catch (Exception e) {			
			Assert.assertTrue(false, "Failed to get a null driver object.");			
		}			
		
	}

}
