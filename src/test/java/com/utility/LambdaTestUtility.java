package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtility {
	 public static final String hubURL = "https://hub.lambdatest.com/wd/hub";
	 private static ThreadLocal<WebDriver> driverlocal=new ThreadLocal<WebDriver>();
	 private static ThreadLocal<DesiredCapabilities> capabilitieslocal=new ThreadLocal<DesiredCapabilities>();
	 
	 public static WebDriver initializelambdatest(String browser,String testname) {
		  DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("browserName", browser);
	        capabilities.setCapability("browserVersion", "latest");
	        Map<String, Object> ltOptions = new HashMap<>();
	        ltOptions.put("user","anirudhgrover946255");
	        ltOptions.put("accessKey","LT_rkcZ8KvZZFkZx3oLrdqJ1ylPvyK2h4jlgvVwecfAqZbABgX");
	        ltOptions.put("build", "Selenium 4");
	        ltOptions.put("name", testname);
	        ltOptions.put("platformName", "Windows 10");
	        ltOptions.put("seCdp", true);
	        ltOptions.put("selenium_version", "latest");
	        capabilities.setCapability("LT:Options", ltOptions);
	        capabilitieslocal.set(capabilities);
	        
	        WebDriver driver=null;
	        try {
				driver=new RemoteWebDriver(new URL(hubURL), capabilitieslocal.get());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
			driverlocal.set(driver);
	        System.out.println(driver);
	        return driverlocal.get();
	 }
	 public static void quitsession() {
		 if(driverlocal.get() != null)
			 driverlocal.get().quit();
	 }
}

