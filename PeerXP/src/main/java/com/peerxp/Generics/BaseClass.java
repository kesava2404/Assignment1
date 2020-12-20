package com.peerxp.Generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
		
	}
	protected WebDriver driver;
	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		driver=new ChromeDriver();
		Thread.sleep(5000);
		driver.get("https://gitlab.com/users/sign_in");
		Thread.sleep(5000);
	}
	/*@AfterTest
	public void CloseBrowser() {
		driver.close();
	}*/
	
}
