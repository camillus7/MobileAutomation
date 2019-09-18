package com.windstream.unit;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.windstream.portalautomation.validation.Retry;

public class MyTestListenerAdapter extends TestListenerAdapter {

	//Change 'Fail' to 'Skip' if the Retry is turned on.

	@Override
	public void onTestFailure(ITestResult result) {
		if (result.getMethod().getRetryAnalyzer() != null) {
			Retry retryAnalyzer = (Retry)result.getMethod().getRetryAnalyzer();

			if(retryAnalyzer.isRetryAvailable()) {
				result.setStatus(ITestResult.SKIP);
			} else {
				result.setStatus(ITestResult.FAILURE);
			}
			Reporter.setCurrentTestResult(result);
		}
	}

}
