package com.peerxp.Generics;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
/*	@DataProvider(name="logindata")
public Object[][] getdata() throws IOException{
		String excelpath="./src/test/resources/properties.xlsx";
		
	Object data[][]=testdata(excelpath, "loginpage");
		return data;
	}
	public  Object[][] testdata(String excelpath,String sheetname) throws IOException {
		
		ExcelUtils excel=new ExcelUtils(excelpath, sheetname);
		int rowcount = excel.getRowCount();
		int colcount =excel.getcelcount();
		Object data[][]=new Object[rowcount-1][colcount];
		for(int i=1;i<rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				String celldata = excel.getcelldatastrinng(i, j);
				data[i-1][j]=celldata;
				
			}
		}
		return data;
		
	*/}

