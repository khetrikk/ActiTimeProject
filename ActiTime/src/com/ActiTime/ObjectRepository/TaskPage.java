package com.ActiTime.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//11-05-23.
public class TaskPage {
	//declaration
	
	@FindBy(xpath = "//div[.='Add New']")
	private WebElement addbtn;
	
	@FindBy(xpath = "//div[.='+ New Customer']")
	private WebElement newbtn;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement custtbx;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement custdes;
	
	@FindBy(xpath = "//div[.='Create Customer']")
	private WebElement createcust;
	
	@FindBy(xpath = "//div[@class='greyButton cancelBtn']")
	private WebElement cancel;
	
	//initialization
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	
	public WebElement getAddbtn() {
		return addbtn;
	}

	public WebElement getNewbtn() {
		return newbtn;
	}

	public WebElement getCusttbx() {
		return custtbx;
	}

	public WebElement getCustdes() {
		return custdes;
	}

	public WebElement getCreatecust() {
		return createcust;
	}

	public WebElement getCancel() {
		return cancel;
	}
	
	
	
}
