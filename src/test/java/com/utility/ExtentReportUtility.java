package com.utility;

import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	private static ExtentReports extentreports;
	private static ThreadLocal<ExtentTest>extenttest=new ThreadLocal<ExtentTest>();
	public static void setupextentsparkreporter(String filename) {
		ExtentSparkReporter extentsparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+filename);
	    extentreports=new ExtentReports();
	    extentreports.attachReporter( extentsparkreporter);
	}
	public static void createextenttest(String testname) {
		ExtentTest test=extentreports.createTest(testname);
		extenttest.set(test);
	}
	public  static ExtentTest gettest() {
		return extenttest.get();
	}
	public static void flushreport() {
		extentreports.flush();
	}

  }

