package WebDriver;



import org.openqa.selenium.remote.DesiredCapabilities;

public interface ApplicationWebDriver {
    
   
    DesiredCapabilities getCapabilities();
    io.appium.java_client.android.AndroidDriver getAndroidDriver();
    
}


