package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	@FindBy (xpath="//div[.='Add New']")
	private WebElement clickonAddnew;
	
	@FindBy (xpath="//div[.='+ New Customer']")
	private WebElement clickonnewcustomer;
	
	@FindBy (xpath="//input[@placeholder='Enter Customer Name'and @class]")
	private WebElement entercustomername;
	
	@FindBy (xpath="//div[text()='- Select Customer -'and@class='emptySelection']")
	private WebElement selectcustomer;
	@FindBy (xpath="//div[.='Our company'and@class='itemRow cpItemRow ']")
	private WebElement clickourcompany;
	@FindBy (xpath="//div[@title='HDFC_001']")
	private WebElement atual;
	
	

	public WebElement getAtual() {
		return atual;
	}

	@FindBy (xpath="//div[.='Create Customer']")
	private WebElement createcustomer;
	
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getClickonAddnew() {
		return clickonAddnew;
	}

	public WebElement getClickonnewcustomer() {
		return clickonnewcustomer;
	}

	public WebElement getEntercustomername() {
		return entercustomername;
	}

	public WebElement getSelectcustomer() {
		return selectcustomer;
	}
	public WebElement getClickourcompany() {
		return clickourcompany;
	}

	public WebElement getCreatecustomer() {
		return createcustomer;
	}
	  
	


}
