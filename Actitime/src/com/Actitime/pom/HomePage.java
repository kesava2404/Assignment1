package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
@FindBy (xpath="//div[.='Tasks']")
private WebElement Tasktab;
public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public void clickontasktab() {
	Tasktab.click();
}
}
