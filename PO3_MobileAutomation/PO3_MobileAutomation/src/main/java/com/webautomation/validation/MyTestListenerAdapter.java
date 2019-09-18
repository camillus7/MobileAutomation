package com.webautomation.validation;


import java.util.Iterator;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class MyTestListenerAdapter extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        if (result.getMethod().getRetryAnalyzer() != null) {
            Retry retryAnalyzer = (Retry)result.getMethod().getRetryAnalyzer();

            if(retryAnalyzer.isRetryAvailable()){
                result.setStatus(ITestResult.SKIP);
            } else {
					  result.setStatus(ITestResult.FAILURE);
            }
            Reporter.setCurrentTestResult(result);
        }
    }

  @Override
   public void onFinish(ITestContext context) {
     Iterator<ITestResult> failedTestCases =context.getFailedTests().getAllResults().iterator();
     ITestResult failedTestCase1 = failedTestCases.next();
     ITestNGMethod method1 = failedTestCase1.getMethod();
 	System.out.println("Test Result:="+ context.getFailedTests().getResults(method1));
    while (failedTestCases.hasNext()) {
        System.out.println("failedTestCases");
        ITestResult failedTestCase = failedTestCases.next();
        ITestNGMethod method = failedTestCase.getMethod();
        if (context.getFailedTests().getResults(method).size() > 1) {
            System.out.println("failed test case remove as duplicate:" + failedTestCase.getTestClass().toString());
            failedTestCases.remove();
        } else {
            if (context.getPassedTests().getResults(method).size() > 0) {
                System.out.println("failed test case remove as pass retry:" + failedTestCase.getTestClass().toString());
                failedTestCases.remove();
            }
        }
    }
   }
}