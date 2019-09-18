package com.windstream.unit;

import org.testng.Assert;
import org.testng.annotations.Test;
import commonUtil.StopWatchUtil;

public class StopWatchUtilTest {	
		
	@Test
	public void startAndStopTest() {		
		StopWatchUtil watch = StopWatchUtil.getInstance();
		Assert.assertTrue(null != watch);
		
		watch.start();
		try {
			Thread.sleep(3200);
		} catch (InterruptedException e) {			
		}
		
		watch.stop();
		watch.printTotalDuration();
		Assert.assertTrue(watch.getDurationInSeconds() >= 3, "duration should be atleast 10 seconds.");
		Assert.assertTrue(watch.getDurationInSeconds() < 4, "duration should be less than 12 seconds.");
		
	}
	
	@Test
	public void printTest() {	
		StopWatchUtil watch = StopWatchUtil.getInstance();
		watch.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {			
		}
		
		watch.stop();
		
		Assert.assertFalse(watch.printTotalDuration().contains("lazenby"));
		Assert.assertTrue(watch.printTotalDuration("lazenby").contains("lazenby"));			
	}	

}
