package com.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;

import java.io.FileNotFoundException;

import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.PropertiesUtility;

public final class HomePage extends BrowserUtility{
	public HomePage(WebDriver lambdadriver) throws FileNotFoundException {
		super(lambdadriver);
		super.GoToWebsite(JSONUtility.readJSON(QA).getURL());
	}
	
	public HomePage(Browser browsername,boolean isheadless) throws FileNotFoundException {
		super(browsername,true);
		super.GoToWebsite(JSONUtility.readJSON(QA).getURL());
	}
	
	private static final By singinLinkLocator=By.xpath("//a[normalize-space()='Sign in']");
	
	public LoginPage Go_To_Login() {
		click(singinLinkLocator);
		LoginPage loginpage=new LoginPage(getDriver());
		return loginpage;
	}
}
