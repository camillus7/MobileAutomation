import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class scrollingTesting {
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//capabilities.setCapability("deviceName", "Samsung");
		//capabilities.setCapability("udid", "33001cc872ce1537");
		
		/*capabilities.setCapability("deviceName", "LG");
		capabilities.setCapability("udid", "LGH81852c15fb1");
		*/
		capabilities.setCapability("deviceName", "galaxys8");
		capabilities.setCapability("udid", "988e16314c4546414d");
		
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "7.1.1");

		// enterprise
		capabilities.setCapability("appPackage", "com.windstream.enterprise.we.dev");
		capabilities.setCapability("appActivity", "com.windstream.po3.business.features.winauth.WinAuthActivity");

		// consumer
		 /*capabilities.setCapability("appPackage", "com.windstream.residential.dev");
		 capabilities.setCapability("appActivity","com.windstream.po3.residential.winauth.WinAuthActivity");*/

		// smb
		/*capabilities.setCapability("appPackage", "com.windstream.enterprise.we.dev");
		capabilities.setCapability("appActivity", "com.windstream.po3.business.features.winauth.WinAuthActivity");*/

		capabilities.setCapability("noReset", true);
		AndroidDriver driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		//RemoteWebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		/*String scrollViewContainer_finder = "new UiSelector().resourceIdMatches(\".*id/your_scroll_view_id\")";
		String neededElement_finder = "new UiSelector().resourceIdMatches(\".*id/elemnt1\")";

		WebElement abc = driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(" + scrollViewContainer_finder + ")" +
		                ".scrollIntoView(" + neededElement_finder + ")"));*/
		
		/*TouchActions ta = new TouchActions(driver).down(5, 100);
		ta.build().perform();	*/
		
		Thread.sleep(5000);
		Dimension size = driver.manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

	
		
		driver.swipe(startx, starty, startx, endy, 3000);
		Thread.sleep(2000);
		driver.swipe(startx, endy, startx, starty, 3000);
		Thread.sleep(2000);
		
	
		
	}

}


