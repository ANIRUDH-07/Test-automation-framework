package com.ui.dataprovider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.POJOS.testData;
import com.ui.POJOS.user;
import com.utility.ExcelReaderUtility;
import com.utility.csvreaderutility;

public class Logindataprovider {

	@DataProvider(name="logindata")
	public Iterator<user> logindataprovider() throws FileNotFoundException {
		Gson gson=new Gson();
		File myfile=new File(System.getProperty("user.dir")+"\\testData\\logindata.json");
		FileReader filereader=new FileReader(myfile);
		testData data=gson.fromJson(filereader,testData.class);
	   //user[] users=new user[0];
	  //return data.getData().toArray(users);
		
		List<user>userdata=new ArrayList<user>();
		for(user userdata1:data.getData()) {
			userdata.add(userdata1);
		}
		//List<Object[]>dataToReturn=new ArrayList<Object[]>();
		//for(user userdata:data.getData()) {
		//	dataToReturn.add(new Object[] {userdata});
		//}
		//return dataToReturn.iterator();
	return userdata.iterator();
		
	}
	//@DataProvider(name="csvlogindata")
	//public static Iterator<user> csvreader() {
	//	return csvreaderutility.readcsvfile("logindata.csv")
	//
	//}
	@DataProvider(name="excelogindata")
	public static  Iterator<Object> loginexceldataprovider(){
	return ExcelReaderUtility.readdatafromexcel("LoginData.xlsx");
	
	}
}
