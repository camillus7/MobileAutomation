package WebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AndroidAppiumDriver {

	protected WebDriver driver = null;
	
	

	@SuppressWarnings("rawtypes")
	public static AndroidDriver getAndroidDriver() {
		String ip = "127.0.0.1";
		String port = "4723";
		io.appium.java_client.android.AndroidDriver<MobileElement> androidDriver = null;
		try {
			androidDriver = new AndroidDriver<>(new URL("http://" + ip + ":" + port + "/wd/hub"), getCapabilities());
		}catch(Exception e){
			Assert.fail("Android driver is null - "+e);
		}
		System.out.println("android app launched");
		androidDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		return androidDriver;
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
