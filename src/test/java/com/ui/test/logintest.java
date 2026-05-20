package com.ui.test;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.POJOS.user;
import com.ui.page.HomePage;
import com.utility.LoggerUtility;
@Listeners(com.ui.listeners.testlistner.class)
public class logintest extends testbase
{
	
	
	@Test(description="verifies if the user is able to sign in ", groups= {"e2e","sanity"},dataProviderClass=com.ui.dataprovider.Logindataprovider.class,dataProvider="logindata",retryAnalyzer=com.ui.listeners.myretrylistener.class)
	 void login(user user)
	{
       
       
		assertEquals(homepage.Go_To_Login().dologinwith(user.getEmailAddress(),user.getPassword()).getusername("Anirudh Grover"),"Anirudh Grover");

	}

	//@Test(description="verifies if the user is able to sign in ", groups= {"e2e","sanity"},dataProviderClass=com.ui.dataprovider.Logindataprovider.class,dataProvider="csvlogindata")
	///public void login(user user)
	//{

	//		assertEquals(homepage.Go_To_Login().dologinwith(user.getEmailAddress(),user.getPassword()).getusername("Anirudh Grover"),"Anirudh Grover");

	///}
	//@Test(description="verifies if the user is able to sign in ", groups= {"e2e","sanity"},dataProviderClass=com.ui.dataprovider.Logindataprovider.class,dataProvider="excelogindata")
	//public void loginexceltest(user user)
	//{

			//assertEquals(homepage.Go_To_Login().dologinwith(user.getEmailAddress(),user.getPassword()).getusername("Anirudh Grover"),"Anirudh Grover");

	//}
}
