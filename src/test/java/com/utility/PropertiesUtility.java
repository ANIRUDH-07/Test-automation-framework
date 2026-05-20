 package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtility {
 public static String readProperty(Env env , String propertyname)  {
	 File myfile=new File(System.getProperty("user.dir")+"\\config\\"+env+".properties");
	 FileReader filereader = null;
	try {
		filereader = new FileReader(myfile);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 Properties properties=new Properties();
	 try {
		properties.load(filereader);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String value= properties.getProperty(propertyname.toUpperCase());
	return value;
 }
}
