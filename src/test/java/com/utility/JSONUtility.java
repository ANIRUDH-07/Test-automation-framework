package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.POJOS.Environements;
import com.ui.POJOS.config;

public class JSONUtility{
	public static Environements readJSON (Env env) {
 Gson gson=new Gson();
 File jsonfile=new File(System.getProperty("user.dir")+"\\config\\config.json");
 FileReader filereader = null;
try {
	filereader = new FileReader(jsonfile);
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 config Config=gson.fromJson(filereader,config.class);
 //Environements environment = Config.getEnvironments().get(env);
 Environements environment = Config.getEnvironments().get(env.name());
 return environment;
	}
}
