package com.utility;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.constants.Browser;

public abstract class BrowserUtility {
 private static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
  public WebDriver getdriver() {
	  return driver.get();
  }
  
public  BrowserUtility(WebDriver driver){
	super();
	 this.driver.set(driver);
 }
public BrowserUtility(String browsername) {
	if(browsername.equalsIgnoreCase("chrome")) {
		driver.set(new ChromeDriver());
	}
	else if(browsername.equalsIgnoreCase("edge")) {
		driver.set(new EdgeDriver());
		}
	else 
		System.out.println("enter valid browser name ");
}
public BrowserUtility(Browser browsername) {
	if(browsername == Browser.Chrome) {
		driver.set(new ChromeDriver());
	}
	else if(browsername == Browser.EDGE) {
		driver.set(new EdgeDriver());
		}
	else 
		System.out.println("enter valid browser name ");
}

public BrowserUtility(Browser browsername,boolean isheadless) {
	if(browsername == Browser.Chrome) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=old");
		options.addArguments("--window-size=1920,1080");
		driver.set(new ChromeDriver(options));
	}
	else if(browsername == Browser.EDGE) {
		if(isheadless) {
		EdgeOptions options=new EdgeOptions();
		options.addArguments("--headless=old");
		options.addArguments("disable-gpu");
		driver.set(new EdgeDriver(options));

		}
		else {
		driver.set(new EdgeDriver());
		}
	}
	else
		System.out.println("enter valid browser name ");
}



 public WebDriver getDriver() {
	return driver.get();
}
 public void GoToWebsite(String url) {
	 driver.get().get(url);
	 }
 public void maximizewindow() {
	 driver.get().manage().window().maximize();
 }
 public void click(By element) {
	 WebElement Element=driver.get().findElement(element);
	 Element.click();
 }
 public void Entertext(By entertext,String texttoenter) {
	 WebElement Entertext=driver.get().findElement(entertext);
	 Entertext.sendKeys(texttoenter);
 }
 public String username(By locator) {
	 WebElement Element=driver.get().findElement(locator);
	 return Element.getText();
 }

  public String takescreenshot(String name) 
  {
	  TakesScreenshot screenshot=(TakesScreenshot)driver.get();
	  Date date=new Date();
	  SimpleDateFormat format=new  SimpleDateFormat("HH-mm-ss");
	  String timestamp=format.format(date);
	  String path = System.getProperty("user.dir") 
		        + "//screenshots//" 
		        + name + "-" + timestamp + ".png";	  File screenshotdata=screenshot.getScreenshotAs(OutputType.FILE);
	  File screenshotfile=new File(path);
	  try {
		FileUtils.copyFile(screenshotdata,screenshotfile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return path;
  }
 
}
