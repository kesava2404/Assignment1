package com.Actitime.generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	public String getpropertyfiledata(String key) throws IOException {
		FileInputStream fis =new FileInputStream("./data/commondata.properties.txt");
		Properties p =new Properties();
		p.load(fis);
		   String value = p.getProperty(key);
		return  value;
		
	}
	public String getexceldata(String path,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
	
	  String data = wb.getSheet("registerpage").getRow(row).getCell(cell).toString();
	
		return data;
		
	}

	
}
