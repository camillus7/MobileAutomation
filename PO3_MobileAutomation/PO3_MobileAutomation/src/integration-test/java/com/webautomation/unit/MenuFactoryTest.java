package com.windstream.unit;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.windstream.portalautomation.testdata.factory.MenuFactory;
import com.windstream.portalautomation.testdata.menu.*;
import com.windstream.portalautomation.testdata.role.WolRole;
import commonUtil.PropertiesUtil;

public class MenuFactoryTest {
	
	@BeforeClass
	public void beforeClass() {
		PropertiesUtil.useIntegrationTestData();
	}
	
//	@Test
//	public void getXmlMenuByMenuTitleTest() throws Exception {			
//		MenuFactory.useXml();
//		Menu contactUsMenu = MenuFactory.getMenuByTitle(WolRole.camsRes, CamsResWolMenu.About_Us );
//		
//		assertTrue(contactUsMenu.getCustomerNumber().equals("126106244"),"customer number does not match.");	
//		assertTrue(contactUsMenu.getUsername().equals("mbgolden*"),"username does not match.");		
//		
//		Menu goPaperLessMenu = MenuFactory.getMenuByTitle(WolRole.camsRes, CamsResWolMenu.Go_Paperless);
//		
//		assertTrue(goPaperLessMenu.getCustomerNumber().equals("126106244"),"customer number does not match.");	
//		assertTrue(goPaperLessMenu.getUsername().equals("mbgolden*"),"username does not match.");					
//	}
	
//	@Test
//	public void getXmlCamsResMenuByTitleTest() throws Exception {		
//		MenuFactory.useXml();
//		Menu contactUsMenu = MenuFactory.getCamsResMenuByTitle(CamsResWolMenu.Go_Paperless);
//		
//		assertTrue(contactUsMenu.getCustomerNumber().equals("126106244"),"customer number does not match.");	
//		assertTrue(contactUsMenu.getUsername().equals("mbgolden*"),"username does not match.");					
//	}
	
	@Test
	public void getExcelMenuByMenuTitleTest() throws Exception {			
		MenuFactory.useExcel();
		Menu contactUsMenu = MenuFactory.getMenuByTitle(WolRole.camsBus, CamsBusWolMenu.Contact_Us );
		
		assertTrue(contactUsMenu.getCustomerNumber().equals("060440376"),"customer number does not match.");	
		assertTrue(contactUsMenu.getUsername().contains("juliet"),"username does not match.");
		assertTrue(contactUsMenu.getSheetName().equalsIgnoreCase(WolRole.camsBus.getSheetName()),"spreadsheet tab does not match.");
				
		Menu goPaperLessMenu = MenuFactory.getMenuByTitle(WolRole.camsBus, CamsBusWolMenu.Go_Paperless);
		
		assertTrue(goPaperLessMenu.getCustomerNumber().equals("060440376"),"customer number does not match.");	
		assertTrue(goPaperLessMenu.getUsername().contains("freshfromflorida*"),"username does not match.");					
	}
	
	@Test
	public void getExcelCamsBusMenuByTitleTest() throws Exception {		
		MenuFactory.useExcel();
		Menu joinConference = MenuFactory.getCamsBusMenuByTitle(CamsBusWolMenu.Activate_Join_A_Conference);
		
		assertTrue(joinConference.getCustomerNumber().equals("010083324"),"customer number does not match.");	
		assertTrue(joinConference.getUsername().equals("coral.davis@arkansas.gov*"),"username does not match.");
		assertTrue(joinConference.getSheetName().equalsIgnoreCase(WolRole.camsBus.getSheetName()),"spreadsheet tab does not match.");
	}	
	
	@Test
	public void getFindRolesAndMenusTest() throws Exception {
		
		WolRole[] wolRoles = WolRole.values();
		
		//loop through all the spreadsheet tabs
		for (WolRole role : wolRoles) {
			System.out.println("Role / Spreadsheet tab: "+role.getSheetName());
			
			//for each spreadsheet tab, loop through the menu options
			for (WolMenu wolMenu : role.getWolMenus()) {
				System.out.println("     menu option: "+wolMenu.getMenuTitle());
			}
			
		}		
						
	}
	
	@Test
	public void getLockAndUnlockMenusTest() throws Exception {		
		
		Menu lockUnlockMenu = MenuFactory.getMenuByTitle(WolRole.carrierRcMss, CarrierRcMssWolMenu.Lock_And_Unlock);
		
		assertTrue(lockUnlockMenu.getCustomerNumber().equals("633318189001"),"customer number does not match.");	
		assertTrue(lockUnlockMenu.getUsername().equals("wheeledj"),"username does not match.");					
	}
	
	@Test
	public void getAllLockAndUnlockMenusTest() throws Exception {		
		
		WolRole[] wolRoles = WolRole.values();
		Menu lockUnlockMenu = null;
		
		//loop through all the spreadsheet tabs
		for (WolRole role : wolRoles) {		
			
			//for each spreadsheet tab, loop through the menu options
			for (WolMenu wolMenu : role.getWolMenus()) {
				
				if (wolMenu.getMenuTitle().toLowerCase().contains("lock & unlock")) {
					
					System.out.println(" ....sheetname: "+role.getSheetName());
					System.out.println(" ....menu title: "+wolMenu.getMenuTitle());
					lockUnlockMenu = MenuFactory.getMenuByTitle(role, wolMenu);
					System.out.println(" sheetname: "+role.getSheetName());
					System.out.println("     customer number: "+lockUnlockMenu.getCustomerNumber());
					System.out.println("           user name: "+lockUnlockMenu.getUsername());					
				}			
			}			
		}		
		
	}
	
	@Test
	public void getAllLockAndUnlockMenusTwoTest() throws Exception {	
		
		Menu lockUnlockMenu = MenuFactory.getCarrierRcMssMenuByTitle(CarrierRcMssWolMenu.Lock_And_Unlock);		
		assertTrue(lockUnlockMenu.getCustomerNumber().equals("633318189001"),"customer number does not match.");	
		assertTrue(lockUnlockMenu.getUsername().equals("wheeledj"),"username does not match.");		
		
		lockUnlockMenu = MenuFactory.getCamsBusMenuByTitle(CamsBusWolMenu.Lock_And_Unlock);		
		assertTrue(lockUnlockMenu.getCustomerNumber().equals("62859318"),"customer number does not match.");	
		assertTrue(lockUnlockMenu.getUsername().equals("Mcroenne"),"username does not match.");	
		
		lockUnlockMenu = MenuFactory.getCamsResMenuByTitle(CamsResWolMenu.Lock_And_Unlock);		
		assertTrue(lockUnlockMenu.getCustomerNumber().equals("90242210"),"customer number does not match.");	
		assertTrue(lockUnlockMenu.getUsername().equals("salina04@windstream.net"),"username does not match.");	
		
		lockUnlockMenu = MenuFactory.getCamsTasMenuByTitle(CamsTasWolMenu.Lock_And_Unlock);		
		assertTrue(lockUnlockMenu.getCustomerNumber().equals("11992069"),"customer number does not match.");	
		assertTrue(lockUnlockMenu.getUsername().equals("laurensmom02@gmail.com"),"username does not match.");	
	
	}	
	
	@Test
	public void getAllLockAndUnlockMenusTwoThree() throws Exception {	
		
		List<WolRole> roles = new ArrayList<WolRole>( Arrays.asList(WolRole.camsBus, WolRole.camsRes, WolRole.camsTas, WolRole.carrierRcMss));
		
		for (WolRole role : roles) {
			Menu lockUnlockMenu = MenuFactory.getMenuByTitle(role, CamsResWolMenu.Lock_And_Unlock);	//this assumes that all titles across tabs are the same!
			System.out.println(" sheetname: "+role.getSheetName());
			System.out.println("     customer number: "+lockUnlockMenu.getCustomerNumber());
			System.out.println("           user name: "+lockUnlockMenu.getUsername());		
		}	
	
	}
	
	@Test
	public void getCheckAllRoles() throws Exception {	
		
		Menu menu = MenuFactory.getCarrierRcMssMenuByTitle(CarrierRcMssWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		menu = MenuFactory.getCamsBusMenuByTitle(CamsBusWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		menu = MenuFactory.getCamsResMenuByTitle(CamsResWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		menu = MenuFactory.getCamsTasMenuByTitle(CamsTasWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		
		menu = MenuFactory.getCavtelMasterAgentMenuByTitle(CavtelMasterAgentWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		menu = MenuFactory.getCavtelSalesAgentMenuByTitle(CavtelSalesAgentWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		menu = MenuFactory.getCavtelWhlsMenuByTitle(CavtelWhlsWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		menu = MenuFactory.getCavtelTasMenuByTitle(CavtelTasWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		menu = MenuFactory.getCavtelBusMenuByTitle(CavtelBusWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		menu = MenuFactory.getCavtelResMenuByTitle(CavtelResWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		
		menu = MenuFactory.getSalesAgentMenuByTitle(SalesAgentWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		menu = MenuFactory.getMasterAgentMenuByTitle(MasterAgentWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		
		
		menu = MenuFactory.getRcMssWhslMenuByTitle(RcmssWHSLWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		menu = MenuFactory.getRcMssMenuByTitle(RcMssWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		menu = MenuFactory.getRcMssTasMenuByTitle(RcMssTasWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		menu = MenuFactory.getRcMssResMenuByTitle(RcMssResWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		
		menu = MenuFactory.getNuvoxWhlsMenuByTitle(NuvoxWhlsWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		menu = MenuFactory.getNuvoxSalesAgentMenuByTitle(NuvoxSalesAgentWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		menu = MenuFactory.getNuvoxTasMenuByTitle(NuvoxTasWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		menu = MenuFactory.getNuvoxResMenuByTitle(NuvoxResWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
		menu = MenuFactory.getNuvoxBusMenuByTitle(NuvoxBusWolMenu.Lock_And_Unlock);
		assertTrue(menu.getCustomerNumber() != null && menu.getCustomerNumber() != "");
	}
	
//	@Test
//	//TODO fyi - fake data in is the production Q drive spreadsheet for this test
//	public void getExcelMenuExternalTest() throws Exception {			
//		MenuFactory.useExcel();
//		Menu menu = MenuFactory.getCamsBusMenuByTitle(CamsBusWolMenu.Invoices );
//		
//		assertTrue(menu.getExternalUserName().equals("lazenbytest"),"external username does not match.");	
//		assertTrue(menu.getExternalUserPassword().equals("lazenbytestpw"),"external password does not match.");						
//	}
	
//	@Test
//	//TODO fyi - fake data in is the production Q drive spreadsheet for this test
//	public void getExcelMenuAdditionalValuesTest() throws Exception {	
//
//		//Excel data
//		MenuFactory.useExcel();
//		Menu menu = MenuFactory.getCamsBusMenuByTitle(CamsBusWolMenu.Invoices);
//				
//		assertTrue(menu.getAdditionalCustomerValues().equals("xxxx,yyyy,zzzzz"));
//		
//		List<String> values = menu.getNames();
//		assertTrue(values.size() == 3);
//		assertTrue(values.get(0).equals("xxxx"));
//		assertTrue(values.get(1).equals("yyyy"));
//		assertTrue(values.get(2).equals("zzzzz"));
//		
//		
//		for (String value : menu.getNames()) {
//			switch(value) {
//			case "xxxx": 				
//			case "yyyy":				
//			case "zzzzz":
//				System.out.println("invoices - value: "+value);
//				assertTrue(true);
//				break;
//			default:
//				assertTrue(false);					
//			}
//		}
//		
//		menu = MenuFactory.getCamsBusMenuByTitle(CamsBusWolMenu.Invoice_Reports);
//		assertTrue(menu.getAdditionalCustomerValues().equals(""));
//		
//		values = menu.getNames();
//		assertTrue(values.size() == 0);			
//	}
	

}
