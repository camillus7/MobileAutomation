package com.webautomation.testdata.menu;

public enum module1AppMenu implements AppMenu {
	
	//WE Connect
	TestCase1("testCase1"),
	TestCase2("testCase2"),
	TestCase3("testCase3"),
	TestCase4("testCase4"),
	TestCase5("testCase5"),
	ELNK_User("ELNK_User"),
	BVN_User("BVN_User"),
	WOL_User("WOL_User"),
	SMB_User("SMB_User"),
	ConsumerMobileTestCases("ConsumerUser"),
	ConsumerOffers("ConsumerOffers"),
	Automation("Automation"),
	
	ELNK_User2("ELNK_User2"),
	BVN_User2("BVN_User2"),
	WOL_User2("WOL_User2"),
	SMB_User2("SMB_User2"),
	
	//HWin Consumer
	Billing("Billing"),
	PaymentHistory("PaymentHistory"),
	PaperBills("PaperBills"),
	ViewBills("ViewBills"),
	AutoPay("AutoPay"),
	PayNow("PayNow"),
	Support("Support"),
	Home("Home"),
	Gopaperless("Gopaperless"),
	Users("Users"), 
	MyProfile("MyProfile"), 
	
	LoadTestUser1("loadTestUser1"),
	LoadTestUser2("loadTestUser2"),
	LoadTestUser3("loadTestUser3"),
	LoadTestUser4("loadTestUser4"),
	LoadTestUser5("loadTestUser5"),
	LoadTestUser6("loadTestUser6"),
	
	//Sample
	SalesDemo("salesDemo");
	

	
	
	
	
	
private String title;
	
  module1AppMenu(String value) {
		this.title = value;
	}
	
	public String getMenuTitle() {
		return this.title;
	}
}
