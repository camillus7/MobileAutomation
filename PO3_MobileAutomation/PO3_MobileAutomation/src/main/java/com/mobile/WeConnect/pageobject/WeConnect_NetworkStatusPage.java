package com.mobile.WeConnect.pageobject;

import org.openqa.selenium.WebDriver;

import com.webautomation.validation.Validator;

public class WeConnect_NetworkStatusPage {

	final WebDriver driver;
	private Validator vc;
	

	public WeConnect_NetworkStatusPage(WebDriver driver) {
		this.driver = driver;
		this.vc = new Validator(driver);
	}
	

	
	
}
