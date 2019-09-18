package com.windstream.unit;

import org.testng.Assert;
import org.testng.annotations.Test;
import commonUtil.PropertiesUtil;

public class PropertiesUtilTest {

	private final String NOT_FOUND_MESSAGE = "' property was not found."; 	
	
	@Test
	public void findAllPropertiesTest() {	
		PropertiesUtil.resetPropertiesUtil(".\\src\\test\\resources\\configGridTrue.properties");
		Assert.assertNotNull(PropertiesUtil.getValue(PropertiesUtil.BROWSER_PROPERTY), "'"+PropertiesUtil.BROWSER_PROPERTY+NOT_FOUND_MESSAGE);
		Assert.assertNotNull(PropertiesUtil.getValue(PropertiesUtil.URL_PROPERTY), "'"+PropertiesUtil.URL_PROPERTY+NOT_FOUND_MESSAGE);
		Assert.assertNotNull(PropertiesUtil.getValue(PropertiesUtil.SCREENSHOT_PATH_PROPERTY), "'"+PropertiesUtil.SCREENSHOT_PATH_PROPERTY+NOT_FOUND_MESSAGE);
		Assert.assertNotNull(PropertiesUtil.getValue(PropertiesUtil.TESTDATAPATH_PROPERTY), "'"+PropertiesUtil.TESTDATAPATH_PROPERTY+NOT_FOUND_MESSAGE);
		Assert.assertNotNull(PropertiesUtil.getValue(PropertiesUtil.RUNTIMEPLATFORM_PROPERTY), "'"+PropertiesUtil.RUNTIMEPLATFORM_PROPERTY+NOT_FOUND_MESSAGE);
	}	
	
	@Test
	public void canNotFindConfigFileTest() {		
		PropertiesUtil.resetPropertiesUtil("dummy");
		Assert.assertNull(PropertiesUtil.getValue(PropertiesUtil.BROWSER_PROPERTY), "when config.properites file can not be found, all property value requests will return 'null'.");	  
	}
	
	@Test
	public void isGridPlatformTest() {		
		PropertiesUtil.resetPropertiesUtil(".\\src\\test\\resources\\configGridTrue.properties");
		Assert.assertTrue(PropertiesUtil.isGridPlatform(), ".");		
		
		PropertiesUtil.resetPropertiesUtil(".\\src\\test\\resources\\configGridFalse.properties");
		Assert.assertFalse(PropertiesUtil.isGridPlatform(), ".");
	}

}
