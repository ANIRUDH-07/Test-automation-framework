package com.ui.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final  class MyAccountPage extends BrowserUtility{
  private static final By user_name_locator=By.xpath("//a[@title=\"View my customer account\"]//span");
	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String getusername(String name) {
		return username(user_name_locator);
	}

}
