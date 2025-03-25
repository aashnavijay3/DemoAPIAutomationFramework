package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class TestListener implements ITestListener{
	 private static final Logger logger = LogManager.getLogger(TestListener.class);

	 public void onStart (ITestContext result) {
		 logger.info("Test Suite Started");
	 }
	 public void onFinish (ITestContext result) {
		 logger.info("Test Suite Finish");
	 }
	 public void onTestStart(ITestResult result) {
	        logger.info("Test Started:"+ result.getMethod().getMethodName());
	        logger.info("Test Started:"+ result.getMethod().getDescription());
	    }
     public void onTestSuccess(ITestResult result) {
	        logger.info("Test Passed:"+ result.getName());
	    }
     public void onTestFailure(ITestResult result) {
	        logger.error("Test Failed"+ result.getMethod().getMethodName());
	        logger.error("Exception"+ result.getThrowable());
	    }
     public void onTestSkipped(ITestResult result) {
	        logger.error("Test Failed:"+ result.getName());
	        logger.error("Exception: "+  result.getThrowable());
	    }
}
