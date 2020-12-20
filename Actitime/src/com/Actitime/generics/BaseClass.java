package com.Actitime.generics;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}
	public WebDriver driver;
	public FileLib f = new FileLib();
	@BeforeTest
	public void openbrowser() throws IOException {
		String browser = f.getpropertyfiledata("browser");
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else {
			if(browser.equals("firefox"));
		}
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	@BeforeClass
	public void beforeclass() {
		Reporter.log("beforeclass",true);
	}
	
	@AfterClass
	public void afterclass() {
		Reporter.log("beforeclass",true);
	}
	
	@BeforeMethod
	public void loginpage() throws IOException, InterruptedException {
		String url = f.getpropertyfiledata("url");
		String username = f.getpropertyfiledata("username");
		String pwd = f.getpropertyfiledata("password");
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.name("pwd")).sendKeys(pwd);

		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(2000);
	}
	@AfterMethod
	public void logout() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.linkText("Logout"));

	}
}


