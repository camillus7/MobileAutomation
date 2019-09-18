package commonUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Properties;

import WebDriver.WebDriverFactory;

/**
 * Class is used to read the property values found in 'config.properties'.
 */
public class PropertiesUtil {

	public static final String BROWSER_PROPERTY = "browser";
	public static final String URL_PROPERTY = "url";
	public static final String ROLE_PROPERTY = "role";
	public static final String URLExternal_PROPERTY = "externalUrl";
	public static final String SCREENSHOT_PATH_PROPERTY = "screenshot.path";
	public static final String TESTDATAPATH_PROPERTY = "testdatapath";
	public static final String TESTDATAPATHExternal_PROPERTY = "testdatapathExternal";
	public static final String RUNTIMEPLATFORM_PROPERTY = "runtimePlatform";
	public static final String HUBURL_PROPERTY = "huburl";
	public static final String URL_SALESDEMO_PROPERTY = "urlSalesDemo";
	

	private static Properties prop = new Properties();

	static {
		resetPropertiesUtil("./src/test/resources/config.properties");		
	}	

	public static void resetPropertiesUtil(String fileName) {
		try {
			prop = new Properties();
			prop.load(new FileInputStream(new File(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getValue(String key) {
		return (System.getProperty(key, prop.getProperty(key)));
	}
	
	/**
	 * Call this method before running integration tests.
	 * This method changes property 'testdatapath' to point to an Excel file intended for integration testing.
	 */
	public static void useIntegrationTestData() {
		prop.setProperty(TESTDATAPATH_PROPERTY, "./TestData/AutomatedRegressionMasterTEMP_Integration_Test.xls");		
	}

	/**
	 * Convenience method to indicated whether or not 'runtimePlatfrom' property
	 * is set to 'grid'.
	 * 
	 * @return 'true' if property value set to 'grid', else 'false'.
	 */
	public static boolean isGridPlatform() {
		boolean isGrid = false;
		String value = getValue(PropertiesUtil.RUNTIMEPLATFORM_PROPERTY);
		if (value.equalsIgnoreCase("grid")) {
			isGrid = true;
		}
		return isGrid;
	}

	/**
	 * Convenience method to construct and return the grid url.	  
	 * @return String containing 'http://'+localIP+':4545/wd/hub'.  Or return null if not able to discover local IP.
	 */
	public static String getGridUrl() {
		return prop.getProperty(HUBURL_PROPERTY);
	}

	/**
	 * Determine if the browser property is set to 'chrome'.
	 * @return
	 */
	public static boolean isChrome() {
		boolean isChrome = false;
		if (WebDriverFactory.CHROME.equals(prop.getProperty(BROWSER_PROPERTY))) {
			isChrome = true;
		}
		return isChrome;
	}

	/**
	 * Determine if the browser property is set to 'firefox'.
	 * @return
	 */
	public static boolean isFirefox() {
		boolean isFirefox = false;
		if (WebDriverFactory.FIREFOX.equals(prop.getProperty(BROWSER_PROPERTY))) {
			isFirefox = true;
		}
		return isFirefox;
	}

	/**
	 * Determine if the browser property is NOT 'Internet Explorer'.
	 * @return
	 */
	public static boolean isNotIe() {
		boolean isNotIe = false;
		if (isFirefox() || isChrome()) {
			isNotIe = true;
		}
		return isNotIe;
	}

	/**
	 * Determine if the browser property is set to 'Internet Explorer'.
	 * @return
	 */
	public static boolean isInternetExplorer() {
		boolean isIe = false;
		if (WebDriverFactory.IE.equals(prop.getProperty(BROWSER_PROPERTY))) {
			isIe = true;
		}
		return isIe;
	}
	
	/**
	 * Determine if the role property is set to 'internal'.
	 * @return
	 */
	public static boolean isRoleInternal() {
		boolean isRoleInternal = false;
		if (prop.getProperty(ROLE_PROPERTY).equalsIgnoreCase("internal")) {
			isRoleInternal = true;
		}
		return isRoleInternal;
	}

}