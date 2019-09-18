package com.mobile.WeConnect.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.webautomation.validation.Validator;

public class WeConnect_OrdersPage {

	final WebDriver driver;
	private Validator vc;

	public WeConnect_OrdersPage(WebDriver driver) {
		this.driver = driver;
		this.vc = new Validator(driver);
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Orders']")
	public WebElement OrdersMenu;

	@FindBy(xpath = "//android.widget.TextView[@text='Orders']")
	public WebElement ordersTitle;
	
	@FindBy(id = "order_item_main")
	public WebElement orderItem;
	
	@FindBy(id = "order_item_main")
	public List<WebElement> orderList;
	
	@FindBy(id = "order_item_main")
	public WebElement filteredOrder;
	
	@FindBy(id = "order_id")
	public WebElement orderId;

	@FindBy(id = "account")
	public WebElement accountName;

	@FindBy(id = "date")
	public WebElement orderDate;

	@FindBy(id = "status")
	public WebElement orderStatus;
	
	@FindBy(id = "com.windstream.enterprise.we.dev:id/filter_icon")
	public WebElement filtericon;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Apply Filter']")
	public WebElement applyFilter;
	
	@FindBy(xpath = "//android.widget.EditText[@text='e.g. 12345678']")
	public WebElement editOrderNum;
	
	@FindBy(id = "//android.widget.RelativeLayout//android.widget.TextView[@id='order_top']")
	public WebElement orderIDs;
	
	

	public void getOrderDetails() {
		vc.getWebDriverUtils().clickMobileElement(OrdersMenu, "Orders");
		vc.getWebDriverUtils().elementAvailablity(ordersTitle, "Orders-Title");

		if (vc.getMobileDriverUtils().elementAvailablity(orderItem, "OrderDetails")) {
			Reporter.log("Orders Available", true);
			vc.getMobileDriverUtils().clickFirstRecord(orderList);
			vc.getMobileDriverUtils().sleep(2000);
			String orderID = orderId.getText();
			Reporter.log("Order ID:" + orderID, true);
			Reporter.log("Account Name:" + accountName.getText(), true);
			Reporter.log("Order Date:" + orderDate.getText(), true);
			Reporter.log("Order Status:" + orderStatus.getText(), true);

			Reporter.log("***FILTER ORDERS***", true);
			driver.navigate().back();
			vc.getWebDriverUtils().clickMobileElement(filtericon, "FilterIcon");
			vc.getMobileDriverUtils().mobile_EnterText(editOrderNum, orderID, "OrderID");
			vc.getWebDriverUtils().clickMobileElement(applyFilter, "ApplyFilter");
			vc.getMobileDriverUtils().elementAvailablity(filteredOrder, "OrderDetails");
			if (orderList.size() > 0) {
				vc.getMobileDriverUtils().clickFirstRecord(orderList);

				if (orderID.equals(orderId.getText())) {
					Reporter.log("ORDER DETAILS FOR ORDER ID: " + orderID + " IS FILTERED ", true);
				} else {
					Reporter.log("FILTER NOT WORKING", true);
				}
			} else {
				Reporter.log("ORDERS NOT AVAILABLE FOR THE ORDER ID" + orderID, true);
			}

		} else {
			Reporter.log("Orders Not Available", true);
		}

	}

}