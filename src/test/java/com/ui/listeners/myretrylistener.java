package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtility;

public class myretrylistener implements IRetryAnalyzer{
  // private final static int max_number_of_attempts=Integer.parseInt(PropertiesUtility.readProperty(Env.QA,"max_number_of_attempts"));
   private static int current_attempt=1;
   private static final int max_number_of_attempts=JSONUtility.readJSON(Env.QA).getMax_number_of_attempts();

	@Override
	public boolean retry(ITestResult result) {
		if(current_attempt<=max_number_of_attempts) {
			current_attempt++;
			return true;
		}
		return false;
	}

}
