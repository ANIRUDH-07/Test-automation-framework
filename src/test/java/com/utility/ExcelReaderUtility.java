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

public class ExcelReaderUtility 
{
 public static Iterator<Object> readdatafromexcel(String filename)  
 {
	  File myfile=new File(System.getProperty("user.dir")+"//testData//"+filename);
	  XSSFWorkbook xssfworkbook;
	  XSSFSheet xssfsheet;
	  Iterator<Row> rowIterator;
	//  List<user>Userlist = null;
	  List<Object>Userlist = null;
	  Cell emailaddresscell;
	  Cell passwordcell;
	try 
	{
		xssfworkbook = new XSSFWorkbook(myfile);
		 xssfsheet=xssfworkbook.getSheet("Sheet1");
		   rowIterator=xssfsheet.iterator();
		//  Userlist=new ArrayList<user>();
		  Userlist=new ArrayList<Object>();
		  rowIterator.next();
		  
		  while(rowIterator.hasNext()) 
		  {
			  
			 Row row= rowIterator.next();
			   emailaddresscell=row.getCell(0);
			   passwordcell=row.getCell(1);

			  user user=new user(emailaddresscell.toString(),passwordcell.toString());
			  Userlist.add(user);
			  xssfworkbook.close();
		  }
	} 
	catch (InvalidFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	return Userlist.iterator();
 }

}
