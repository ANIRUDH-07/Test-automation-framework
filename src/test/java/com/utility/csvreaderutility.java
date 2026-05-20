package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.POJOS.user;

public class csvreaderutility
{
 public static Iterator<user> readdatafromexcel(String filename)
 {
	 
	 File csvfile=new File(System.getProperty("user.dir")+"//testData//"+filename);
	 XSSFWorkbook xssfworkbook=null;
	 Row row;
	 Cell emailaddresscell;
	 Cell passwordcell;
	 List<user>UserList=null;
	 user user;
	 XSSFSheet xssfsheet;
	 Iterator<Row>rowiterator;
	try {
		xssfworkbook = new XSSFWorkbook(csvfile);
		xssfsheet= xssfworkbook.getSheet("Sheet1");
		rowiterator= xssfsheet.iterator();
		
		 
		 rowiterator.next();
		 
		 while(rowiterator.hasNext()) {
			  row=rowiterator.next();
			  emailaddresscell=row.getCell(0);
			  passwordcell=row.getCell(1);
			 
			 UserList=new ArrayList<user>();
			 user=new user(emailaddresscell.toString(),passwordcell.toString());
			 UserList.add(user);
			 System.out.println(UserList);
			 xssfworkbook.close();
		 }
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return UserList.iterator();
	 }
 
}


