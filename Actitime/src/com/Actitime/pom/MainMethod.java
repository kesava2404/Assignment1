package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainMethod {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
	}
	public static void main (String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.get("https://demo.actitime.com/");
		LoginPage lg=new LoginPage(driver);
		lg.setlogin("admin1", "manager1");
		Thread.sleep(3000);
		lg.setlogin("admin", "manager");
		Thread.sleep(3000);
		lg.getLgout().click();
	}

}
