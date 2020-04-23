package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy (id="username")
	private WebElement untbx;

	@FindBy (name="pwd")
	private WebElement pwtbx;
	
	@FindBy (id="loginButton")
	private WebElement lgin;

	@FindBy (linkText="Logout")
	private WebElement lgout;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	} 
	
	public void setlogin(String un,String pw) {
		untbx.sendKeys(un);
		pwtbx.sendKeys(pw);
		lgin.click();
		 
	}

	public WebElement getLgout() {
		return lgout;
	}


}
