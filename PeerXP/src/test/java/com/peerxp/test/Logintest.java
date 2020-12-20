package com.peerxp.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.peerxp.Generics.BaseClass;
import com.peerxp.Generics.ExcelUtils;
import com.peerxp.pom.Loginpage;
@Listeners(com.peerxp.Generics.ListenerImplementation.class)

public class Logintest extends BaseClass{
	@BeforeMethod
	public void openpge() {
		driver.get("https://gitlab.com/users/sign_in");
		WebDriverWait wait=new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.titleIs("https://gitlab.com/users/sign_in?__cf_chl_jschl_tk__="));
		
	}

	@Test(dataProvider="logindata")

	public void test(String usrname ,String passwrd) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	//	WebDriverWait wait=new WebDriverWait(driver, 5000);
		//wait.until(ExpectedConditions.titleIs("https://gitlab.com/users/sign_in?__cf_chl_jschl_tk__="));

		
		Loginpage pg =new Loginpage();
		pg.getUsernamae().sendKeys(usrname);
		pg.getPassword().sendKeys(passwrd);
		pg.getSignin().click();

	}
	
	@DataProvider(name="logindata")
	public Object[][] getdata() throws IOException{
			String excelpath="./src/test/resources/data/properties.xlsx";
			String sheetname ="loginpage";
		Object data[][]=testdata(excelpath, "loginpage");
			return data;
		}
		public  Object[][] testdata(String excelpath,String sheetname) throws IOException {
			Object[][]exceldata=null;
			ExcelUtils excel=new ExcelUtils(excelpath, sheetname);
			int rowcount = excel.getRowCount();
			System.out.println(rowcount);
			int colcount =excel.getcelcount();
			System.out.println(colcount);
			Object data[][]=new Object[rowcount-1][colcount];
			for(int i=1;i<rowcount;i++) {
				for(int j=0;j<colcount;j++) {
				exceldata[i-1][j] =excel.getcellDataNum(excelpath, j, i);
					
					
				}
			}
			return data;
			
		}
}
