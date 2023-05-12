package com.ActiTime.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ActiTime.GenericLibrary.Baseclass;
import com.ActiTime.GenericLibrary.Filelibrary;
import com.ActiTime.ObjectRepository.HomePage;
import com.ActiTime.ObjectRepository.TaskPage;
//11-05-23.
public class Task extends Baseclass{
    @Test
    public void createCustomer() throws EncryptedDocumentException, IOException {
    	HomePage hp=new HomePage(driver);
    	hp.getTasktab().click();
    	
    	TaskPage tp=new TaskPage(driver);
    	tp.getAddbtn().click();
    	tp.getNewbtn().click();
    	
    	Filelibrary f=new Filelibrary();
    	String createcustomer = f.readDataFromExcel("Sheet1", 1, 1);       //customer value.
    	tp.getCusttbx().sendKeys(createcustomer);
    	
    	String value1 = f.readDataFromExcel("Sheet1", 1, 2);      //description value.
    	tp.getCustdes().sendKeys(value1);
    	
    	tp.getCreatecust().click();
    	
    	String expectedresult = createcustomer;    //verification
    	String Actualresult = driver.findElement(By.xpath("(//div[.='"+createcustomer+"'])[2]")).getText();
    	SoftAssert s=new SoftAssert();
    	s.assertEquals(Actualresult, expectedresult);
    	s.assertAll();
    }
}
