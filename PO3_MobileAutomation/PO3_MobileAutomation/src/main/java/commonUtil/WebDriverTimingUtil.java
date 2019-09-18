package commonUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webautomation.validation.Validator;


public class WebDriverTimingUtil {
	
	private static String startDateString = null;
	static long startTime = 0;
	static long stopTime = 0;
	
	public static String getStartDateString() {
		return startDateString;
	}

	public static void setStartDateString(String startDateString) {
		WebDriverTimingUtil.startDateString = startDateString;
	}

	public static String getFinishDateString() {
		return finishDateString;
	}

	public static void setFinishDateString(String finishDateString) {
		WebDriverTimingUtil.finishDateString = finishDateString;
	}



	private static String finishDateString = null;
	

	/**
	 * @throws InterruptedException
	 */
	public void searchForElement(WebDriver driver, String message,WebElement searchElement, int tries) throws InterruptedException {

		boolean elementIsPresent = false;
		int i=0;
		System.out.println("Searching for: " + message);
		outer:do {
			Thread.sleep(3000);
			try {
				elementIsPresent = new Validator(driver).clickElementEnabledCheck(searchElement);
				
			} catch (Exception e) {
				System.out.println("Caught searching for: " + message);
				driver.navigate().refresh();
				
			}
			if(elementIsPresent){ 
				System.out.println("Found: " + message);
				Thread.sleep(1500);
				break outer;
			}
			i++;
			
		} while (!elementIsPresent && i<tries);
		
	}
	
	/**
	 * @throws InterruptedException
	 */
	public void searchForElement(WebDriver driver, String message,WebElement searchElement) throws InterruptedException {

		boolean elementIsPresent = false;
		int i=0;
		System.out.println("Searching for: " + message);
		outer:do {
			Thread.sleep(3000);
			try {
				elementIsPresent = new Validator(driver).clickElementEnabledCheck(searchElement);
				
			} catch (Exception e) {
				System.out.println("Caught searching for: " + message);
				driver.navigate().refresh();
				
			}
			if(elementIsPresent){ 
				System.out.println("Found: " + message);
				Thread.sleep(1500);
				break outer;
			}
			i++;
			
		} while (!elementIsPresent && i<40);
		
	}
	
	/**
	 * @param message
	 * @throws InterruptedException
	 */
	/**
	 * @throws InterruptedException
	 */
	public void searchForElement_NoRefresh(WebDriver driver, String message,WebElement searchElement) throws InterruptedException {

		boolean elementIsPresent = false;
		int i=0;
		System.out.println("Searching for: " + message);
		outer:do {
			Thread.sleep(5);
			try {
				elementIsPresent = new Validator(driver).clickElementEnabledCheck(searchElement);
				
			} catch (Exception e) {

				System.out.println("Searching for: " + message);
			}
			if(elementIsPresent){ 
				System.out.println("Found: " + message);
				Thread.sleep(1500);
				break outer;
			}
			i++;
			
		} while (!elementIsPresent && i<40);
		
	}
	
	public boolean searchForElement_NoRefresh(WebDriver driver, String message,WebElement searchElement, int tries) throws InterruptedException {

		boolean elementIsPresent = false;
		int i=0;
		System.out.println("Searching for: " + message);
		outer:do {
			Thread.sleep(5);
			try {
				elementIsPresent = new Validator(driver).clickElementEnabledCheck(searchElement);
				
			} catch (Exception e) {

				System.out.println("Searching for: " + message);
			}
			if(elementIsPresent){ 
				System.out.println("Found: " + message);
				Thread.sleep(1500);
				break outer;
			}
			i++;
			
		} while (!elementIsPresent && i<tries);
		return elementIsPresent;
	}
	
	/**
	 * @throws ParseException 
	 * 
	 */
	//calculate start and stop times for Tealeaf
	public static void tealeafTimerOutput(String startFinish) throws ParseException {
		Date date = new java.util.Date();
		
		//Start time
		if (startFinish.toLowerCase().contains("start")) {
			//Date output Start time
			setStartDateString(new SimpleDateFormat("hh:mm:ss").format(date));
			System.out.println("Start  time: " + getStartDateString());
			
			//System start time
			startTime = System.nanoTime();
			System.out.println();
		} else if (!(startFinish.toLowerCase().contains("start"))) {
			//Date output Start time
			System.out.println("Start  time: " + getStartDateString());
			
			//Stop time
			//Date output Stop time
			setFinishDateString(new SimpleDateFormat("hh:mm:ss").format(date));
			System.out.println("Finish time: " + getFinishDateString());
			
			//System stop time difference calulation
			long difference = System.nanoTime() - startTime;
	        System.out.println("Total execution time: " +
	                String.format("%d:%d:%d",
	                        TimeUnit.NANOSECONDS.toHours(difference), TimeUnit.NANOSECONDS.toMinutes(difference),
	                        TimeUnit.NANOSECONDS.toSeconds(difference) -
	                                TimeUnit.MINUTES.toSeconds(TimeUnit.NANOSECONDS.toMinutes(difference))));
	        
	        //Start     Stop      Diff times output to console
			System.out.println("Start     Stop      Diff");
			System.out.println(getStartDateString() + "  "+ getFinishDateString() + "  "+ String.format("%d:%d:%d",
	                TimeUnit.NANOSECONDS.toHours(difference), TimeUnit.NANOSECONDS.toMinutes(difference),
	                TimeUnit.NANOSECONDS.toSeconds(difference) -
	                        TimeUnit.MINUTES.toSeconds(TimeUnit.NANOSECONDS.toMinutes(difference)))); 
			

			System.out.println();
		}
		


		System.out.println();
	}
	
	public void searchForElement(WebDriver driver, String message,WebElement searchElement, int tries, Validator vc) throws InterruptedException {

		boolean elementIsPresent = false;
		int i=0;
		System.out.println("Searching for: " + message);
		outer:do {
			Thread.sleep(3000);
			try {
				elementIsPresent = vc.clickElementEnabledCheck(searchElement);
				
			} catch (Exception e) {
				System.out.println("Caught searching for: " + message);
				driver.navigate().refresh();
				
			}
			if(elementIsPresent){ 
				System.out.println("Found: " + message);
				Thread.sleep(1500);
				break outer;
			}
			i++;
			
		} while (!elementIsPresent && i<tries);
		
	}
	
	
	public boolean searchForElement_NoRefresh(WebDriver driver, String message,WebElement searchElement, int tries, Validator vc) throws InterruptedException {

		boolean elementIsPresent = false;
		int i=0;
		System.out.println("Searching for: " + message);
		outer:do {
			Thread.sleep(5);
			try {
				elementIsPresent = vc.clickElementEnabledCheck(searchElement);
				
			} catch (Exception e) {

				System.out.println("Searching for: " + message);
			}
			if(elementIsPresent){ 
				System.out.println("Found: " + message);
				Thread.sleep(1500);
				break outer;
			}
			i++;
			
		} while (!elementIsPresent && i<tries);
		return elementIsPresent;
	}
	
	
	public boolean searchForElement_NoRefresh(WebDriver driver, String message,WebElement searchElement, Validator vc, int tries) throws InterruptedException {

		boolean elementIsPresent = false;
		int i=0;
		System.out.println("Searching for: " + message);
		outer:do {
			Thread.sleep(5);
			try {
				elementIsPresent = vc.clickElementEnabledCheck(searchElement);
				
			} catch (Exception e) {

				System.out.println("Searching for: " + message);
			}
			if(elementIsPresent){ 
				System.out.println("Found: " + message);
				Thread.sleep(1500);
				break outer;
			}
			i++;
			
		} while (!elementIsPresent && i<tries);
		
		return elementIsPresent;
		
	}
}
