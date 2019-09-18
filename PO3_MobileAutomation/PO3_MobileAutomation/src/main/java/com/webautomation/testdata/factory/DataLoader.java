package com.webautomation.testdata.factory;

import com.webautomation.testdata.menu.Menu;
import com.webautomation.testdata.module.AppModule;
import com.webautomation.testdata.menu.AppMenu;

public abstract class DataLoader {

	public abstract Menu getMenuByTitle(AppModule role, AppMenu wolMenu) throws Exception;  
	
}
