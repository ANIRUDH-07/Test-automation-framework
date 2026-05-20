package com.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility{

	static final By email_btn_locator=By.xpath("//input[@id='email']");
	static final By password_btn_locator=By.xpath("//input[@id='passwd']");
	static final By submit_btn_locator=By.xpath("//span[normalize-space()='Sign in']");
			
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public MyAccountPage dologinwith(String email , String password) {
		Entertext(email_btn_locator,email);
		Entertext(password_btn_locator,password);
		click(submit_btn_locator);
		
		MyAccountPage myaccount=new MyAccountPage(getDriver());
		return myaccount;
	}
}
