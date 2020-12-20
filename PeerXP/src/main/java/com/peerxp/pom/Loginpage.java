package com.peerxp.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
@FindBy (xpath="//input[@type='text']")
private WebElement usernamae;
@FindBy (xpath="//input[@type='password']")
private WebElement password;
public WebElement getUsernamae() {
	return usernamae;
}
public WebElement getPassword() {
	return password;
}
public WebElement getSignin() {
	return signin;
}
@FindBy (xpath="//input[@type='submit']")
private WebElement signin;
public void LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
}
