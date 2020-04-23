package com.Actitime.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Actitime.generics.BaseClass;
import com.Actitime.pom.HomePage;
import com.Actitime.pom.TaskPage;
@Listeners(com.Actitime.generics.ListenersImplementation.class)
public class CreateCustomer extends BaseClass{
	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		String expected = f.getexceldata("./data/properties.xlsx", "customer sheet", 1, 2);
	
		HomePage hm= new HomePage(driver);
		hm.clickontasktab();
		Thread.sleep(5000);
		TaskPage ts=new TaskPage(driver );
		Thread.sleep(5000);
		ts.getClickonAddnew().click();
		ts.getClickonnewcustomer().click();
		Thread.sleep(5000);
		ts.getEntercustomername().sendKeys(expected);
		ts.getSelectcustomer().click();
		ts.getClickourcompany().click();
		ts.getCreatecustomer().click();
		Thread.sleep(5000);
	String actualresult = ts.getAtual().getText();
		Assert.assertEquals(actualresult,expected ); 
	}

}
