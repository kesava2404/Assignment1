package com.peerxp.Generics;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook wb;
	static XSSFSheet sheet ;
	public ExcelUtils(String excelpath , String SheetName) throws IOException {

		try {
			FileInputStream fis=new FileInputStream(excelpath);
			wb=new XSSFWorkbook(fis);
			sheet =wb.getSheet(SheetName);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static int getRowCount() {
		int rowcount = 1;
		try {
			rowcount=sheet.getLastRowNum();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rowcount;

	}
	public static int getcelcount() {
		int colcount=0;
		try {
			XSSFRow row = sheet.getRow(0);
			colcount=row.getLastCellNum();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

		}
		return colcount;
	}
	public  static String getcelldatastrinng(String sheetname ,int RowNum ,String colNum) {

		try {
			int col_Num = 0;
			sheet = wb.getSheet(sheetname);
			XSSFRow row = sheet.getRow(0);
			for(int i = 0; i < row.getLastCellNum(); i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(colNum.trim()))
					col_Num = i;
			}

			row = sheet.getRow(RowNum  - 1);
			XSSFCell cell = row.getCell(col_Num);

			if(cell.getCellTypeEnum() == CellType.STRING)
				return cell.getStringCellValue();
			else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA)
			{
				String cellValue = String.valueOf(cell.getNumericCellValue());

				return cellValue;
			}else if(cell.getCellTypeEnum() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "row "+RowNum+" or column "+colNum +" does not exist  in Excel";
		}
	}


public static  String getcellDataNum(String sheetname ,int RowNum ,int colNum) {
	//double	celldata=0;
	try {
		  sheet = wb.getSheet(sheetname);
          XSSFRow row = sheet.getRow(RowNum);
          XSSFCell cell = row.getCell(colNum);
          if(cell.getCellTypeEnum() == CellType.STRING)
              return cell.getStringCellValue();
          else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA)
          {
              String cellValue  = String.valueOf(cell.getNumericCellValue());
             
              return cellValue;
          }else if(cell.getCellTypeEnum() == CellType.BLANK)
              return "";
          else
              return String.valueOf(cell.getBooleanCellValue());
      }
      catch(Exception e)
      {
          e.printStackTrace();
          return "row "+RowNum+" or column "+colNum +" does not exist  in Excel";
      }
	}
	//return celldata;
}



