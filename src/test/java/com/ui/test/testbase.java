package com.ui.test;



import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.page.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;

public class testbase {
	protected HomePage homepage; 
	private static boolean islambda;
	
	//protected static ThreadLocal<HomePage> homepage = new ThreadLocal<>();
	@BeforeMethod()
	@Parameters({"browser","islambda","isheadless"})

	public void setup(
			@Optional("edge")String browser,
			@Optional("false")boolean islambda,
			@Optional("false")boolean isheadless,ITestResult result ) throws FileNotFoundException
	{
		this.islambda=islambda;
		WebDriver lambdadriver;
		
		if(islambda) {
			
			lambdadriver = LambdaTestUtility.initializelambdatest( browser,result.getMethod().getMethodName() );
			homepage=new HomePage(lambdadriver);
			System.out.println("Browser value = " + browser);
		}
		else {
		 homepage=new HomePage(Browser.valueOf(browser.toUpperCase()),isheadless);
		 System.out.println("Browser value = " + browser);
	}
	}
	
	public BrowserUtility getinstance() {
		return homepage;
	}
	@AfterMethod
	public void tearDown() {
		if(islambda) {
			LambdaTestUtility.quitsession();
		}
	}
}
