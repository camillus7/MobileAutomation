package com.windstream.unit;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.windstream.portalautomation.testdata.excel.ExcelDataLoader;
import com.windstream.portalautomation.testdata.menu.CamsBusWolMenu;
import com.windstream.portalautomation.testdata.menu.Menu;
import com.windstream.portalautomation.testdata.role.WolRole;
import commonUtil.ExcelUtils_SelGrid;
import commonUtil.PropertiesUtil;

public class ExcelDataLoaderTest {
	
	@BeforeClass
	public void beforeClass() {
		PropertiesUtil.useIntegrationTestData();
	}
		
	@Test
	public void getMenuByMenuTitleTest() throws Exception {		
		Menu contactUsMenu = new ExcelDataLoader().getMenuByTitle(WolRole.camsBus, CamsBusWolMenu.Contact_Us );
		
		assertTrue(contactUsMenu.getCustomerNumber().equals("060440376"),"customer number does not match.");	
		assertTrue(contactUsMenu.getUsername().equals("juliet92149*"),"username does not match.");		
		
		Menu goPaperLessMenu = new ExcelDataLoader().getMenuByTitle(WolRole.camsBus, CamsBusWolMenu.Go_Paperless);
		
		assertTrue(goPaperLessMenu.getCustomerNumber().equals("060440376"),"customer number does not match.");	
		assertTrue(goPaperLessMenu.getUsername().equals("freshfromflorida*"),"username does not match.");	
		
		Menu userGuideMenu = new ExcelDataLoader().getMenuByTitle(WolRole.camsBus, CamsBusWolMenu.WIN_Network_Portal_User_Guide );
		
		assertTrue(userGuideMenu.getCustomerNumber().equals("011921607"),"customer number does not match.");	
		assertTrue(userGuideMenu.getUsername().equals("unregistered"),"username does not match.");	
	}
	
	@Test
	public void getSalesAgentAccountNumber() throws Exception {		
		
		List<String> testDataValues = new ExcelUtils_SelGrid().setTestDataSelGrid("Customer Invoices", "Sales Agent" );
		
		for (String value : testDataValues) {
			System.out.println(" value: "+value);
		}	
		
		Assert.assertTrue(testDataValues.size() == 6, "shall be 6 potential values.");
		Assert.assertTrue(testDataValues.get(2).equals("4359690"), "bad 3 value of role 'Sales Agent', menu 'Customer Invoices");
		
	}

}
