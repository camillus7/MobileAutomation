package com.webautomation.testdata.module;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.webautomation.testdata.menu.Menu;

/**
 * A Role object encapsulates all the menu options and menu test data for a particular WOL role.
 * 
 */
@JacksonXmlRootElement(localName = "module")
public class Module {
	
	@JacksonXmlProperty(isAttribute = true)	
	private String name;	
	
	@JacksonXmlProperty(isAttribute = false, localName = "menu")
	private Menu[] menus = new Menu[0];

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Menu[] getMenus() {
		return menus;
	}

	public void setMenus(Menu[] menu) {
		this.menus = menu;
	}	
}
