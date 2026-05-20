package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.test.testbase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;

public class testlistner implements ITestListener {
	 
	 ExtentSparkReporter extentsparkreporter;
	 ExtentReports extentreports;
	 ExtentTest extenttest;
	 
	  Logger logger=LoggerUtility.getlogger(this.getClass());
	  
	 public void onTestStart(ITestResult result) {
		   logger.info(result.getMethod().getMethodName());
		   logger.info(result.getMethod().getDescription());
		   logger.info(Arrays.toString(result.getMethod().getGroups()));
		   ExtentReportUtility.createextenttest(result.getMethod().getMethodName());
		  }
	 public void onTestSuccess(ITestResult result) {
		   logger.info(result.getMethod().getMethodName()+ ""+"Passed");
		   ExtentReportUtility.gettest().log(Status.PASS, result.getMethod().getMethodName()+ ""+"Passed");

		  }
	 public void onTestFailure(ITestResult result) {
		   logger.info(result.getMethod().getMethodName()+""+"Failed");
		   logger.info(result.getThrowable().getMessage());
		   ExtentReportUtility.gettest().log(Status.FAIL, result.getMethod().getMethodName()+ ""+"Failed");
		   
		   Object testclass=result.getInstance();
		   BrowserUtility browserutility=((testbase)(testclass)).getinstance();
		   String screenshotpath=browserutility.takescreenshot(result.getMethod().getMethodName());
		   ExtentReportUtility.gettest().addScreenCaptureFromPath(screenshotpath);
		  }

	 public void onTestSkipped(ITestResult result) {
		   logger.warn(result.getMethod().getMethodName()+""+"Skipped");
		   ExtentReportUtility.gettest().log(Status.SKIP, result.getMethod().getMethodName()+ ""+"Skipped");


		  }
	 public void onStart(ITestContext context) {
		    logger.info("Test Suite Started");
		    ExtentReportUtility.setupextentsparkreporter("//test_report.html");
	 }
	 public void onFinish(ITestContext context) {
		    logger.info("Test Suite Finished");
		   ExtentReportUtility.flushreport();
		  }
	 
}
