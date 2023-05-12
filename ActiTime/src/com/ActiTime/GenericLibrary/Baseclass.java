package com.ActiTime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ActiTime.ObjectRepository.HomePage;
import com.ActiTime.ObjectRepository.LoginPage;

public class Baseclass {
	public static WebDriver driver;
	Filelibrary f=new Filelibrary();   //getting data from filelibrary.
	
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database connected",true);
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String URL = f.readDataFromPropertyFile("url");                   //read data from property file.
		driver.get(URL);
		Reporter.log("Browser launch",true);
	}
	
	@BeforeMethod
	public void login() throws IOException {
		
		LoginPage lp=new LoginPage(driver);
		String UN = f.readDataFromPropertyFile("username");
		String PW = f.readDataFromPropertyFile("password");
		lp.getUntbx().sendKeys(UN);
		lp.getPwtbx().sendKeys(PW);
		lp.getLgbtn().click();
		
		Reporter.log("Login successfully",true);
	}
	
	@AfterMethod
	public void logout() {
		HomePage hp=new HomePage(driver);
		hp.getLgoutlink().click();
		Reporter.log("Logout successfully",true);
	}
	
	@AfterClass
	public void closebrowser() {
		driver.close();
		Reporter.log("Browser closed",true);
	}
	
	@AfterSuite
	public void databasedisconnection() {
		Reporter.log("database disconnected",true);
	}
	

}
