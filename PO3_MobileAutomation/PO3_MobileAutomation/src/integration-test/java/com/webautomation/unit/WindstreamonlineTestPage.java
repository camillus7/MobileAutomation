package com.windstream.unit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindstreamonlineTestPage {
		
	//something should happen if you click the faq
	@FindBy(xpath = "//*[@id='Login']/table/tbody/tr/td[2]/div/table/tbody/tr[6]/td/p[2]/a[1]")
	public WebElement faq;
		
	//nothing should happen if you click the title
	@FindBy(xpath = "//*[@id='Login']/table/tbody/tr/td[2]/div/table/tbody/tr[1]/td/span[1]")
	public WebElement title;
	
	@FindBy(id = "xyz")
	public WebElement fake;
	
}
