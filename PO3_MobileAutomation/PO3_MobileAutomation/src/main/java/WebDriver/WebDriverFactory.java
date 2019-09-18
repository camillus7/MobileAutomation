package WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import commonUtil.PropertiesUtil;
import io.appium.java_client.android.AndroidDriver;

public final class WebDriverFactory {

	public final static String ANDROID = "android";
	public final static String EDGE = "edge";
	public static final String CHROME = null;
	public static final String FIREFOX = null;
	public static final String IE = null;
	

	
	
	public static WebDriver getAndroidDriver() throws MalformedURLException {
		return getandroidDriver(PropertiesUtil.getValue(PropertiesUtil.BROWSER_PROPERTY));
				
	}

	
	//Added this method for Mobile
	public static WebDriver getandroidDriver(String browser) throws MalformedURLException {
		@SuppressWarnings("rawtypes")
		AndroidDriver driver = null;
		

		if (browser.contains(ANDROID)) {
		
			driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), getCapabilities());
		} 
		

	

		try {
			Thread.sleep(5000);
		}catch(Exception e) {
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static DesiredCapabilities getCapabilities() {

		DesiredCapabilities capabilities = new DesiredCapabilities();
	
		
		capabilities.setCapability("deviceName", "galaxys8");
		capabilities.setCapability("udid", "988e16314c4546414d");
		
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.1.1");

		// enterprise
		capabilities.setCapability("appPackage", "com.windstream.enterprise.we.dev");
		capabilities.setCapability("appActivity", "com.windstream.po3.business.features.winauth.WinAuthActivity");

		//consumer
		/*capabilities.setCapability("appPackage", "com.windstream.residential.dev");
		 capabilities.setCapability("appActivity","com.windstream.po3.residential.winauth.WinAuthActivity");*/

		capabilities.setCapability("noReset", true);
		
		

		return capabilities;

	}
}
