package commonUtil;

import org.apache.log4j.Logger;
import org.testng.Reporter;

public class TestLogger {
	/** Initializing the logger class instance */
	public static Logger logger = Logger.getLogger(WebDriverUtils.class.getName());

	/**
	 * @param methodName
	 *            Based on this method name user knows the which method is
	 *            executing
	 */
	public static void methodName(String methodName) {
		logger.info("Test case name = " + methodName);
	}

	public static void beforORAfterMetod(String methodName) {
		logger.info(methodName);
	}

	public static void elementIdentifier(String elementName) {
		if (elementName != null && !elementName.isEmpty())
			logger.info("Web element = '" + elementName + "' is identified successfully");
		
	}
	
	public static void elementClickIdentifier(String elementName) {
		if (elementName != null && !elementName.isEmpty())
			logger.info("Web element = '" + elementName + "' is identified and clicked");
	}
	
	public static void elementIdentifierFail(String elementName) {
		if (elementName != null && !elementName.isEmpty())
			logger.info("Web element = '" + elementName + "' is not identified");
			
	}

	public static void elementCheckBoxIdentifier(String message) {
			logger.info(message);
	}

	public static void elementCheckBoxIdentifierFail(String elementName) {
		if (elementName != null && !elementName.isEmpty())
			logger.info("Web element = '" + elementName + "' is not identified");
			logger.info("**********************************************************");
	}

	public static void elementSelect(String elementName) {
		if (elementName != null && !elementName.isEmpty())
			logger.info(elementName);
	}

	public static void appInfo(String message) {
		logger.info("*************************** " + "\n" + message);
	}
	public static void testMessage(String message)
	{
		logger.info(message);
		logger.info("**********************************************************");
	}
}
