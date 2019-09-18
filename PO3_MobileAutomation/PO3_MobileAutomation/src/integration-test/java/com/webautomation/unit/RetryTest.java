package com.windstream.unit;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.windstream.portalautomation.validation.Retry;

@Listeners({MyTestListenerAdapter.class})
public class RetryTest {

	private static int count = 0;

	@Test
	public void alwaysPassTest() {
		assertTrue(true);
	}

	@Test(retryAnalyzer = Retry.class)	
	public void failThenPassTest() {

		if (count++ < 2) {			
			assertTrue(false, "this test is failing on purpose, its needs to so we can test our Retry feature.");
		} else {			
			assertTrue(true);
		}

	}
	
	

}
