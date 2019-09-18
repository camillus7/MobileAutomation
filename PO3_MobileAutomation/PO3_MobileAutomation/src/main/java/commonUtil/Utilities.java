package commonUtil;

import org.openqa.selenium.WebDriver;

public class Utilities {
	
	
	 public void switchtoDefaultFrame(WebDriver driver) {
	        try {
	            driver.switchTo().defaultContent();
	            System.out.println("Navigated back to webpage from frame");
	        } catch (Throwable e) {
	            System.out
	                    .println("unable to navigate back to main webpage from frame"
	                            + e.getStackTrace());
	        }
	    }


}
