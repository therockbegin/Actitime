package com.Actitime.Testscript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.ObjectRepository.HomePage;
import com.Actitime.ObjectRepository.TaskPage;

public class CreateCustmer extends Baseclass {
   
	@Test
	public void create () {
	  HomePage hp=new HomePage(diver);
	  hp.getTasklnk().click();
	  TaskPage tp=new TaskPage(driver);
	  tp.getAddnewbtn().click();
	  tp.getCustomername().click();
	  FileLibrary f=new FileLibrary();
	 String custname = f.readDataFromExcel("CUSTOMER", 1, 1);
	  String custdesp = f.readDataFromExcel("CUSTOMER", 1, 2);
	  tp.getCustomername().sendKeys(custname);
	  tp.getCustdesp().sendKeys(custdesp);
	  tp.getCreatecustomerbtn().click();
	  String expecteddata = custname;
	   actualdata = driver.findElement(By.xpath("(//div[.='"+custname+"')");
	
	
	}
	
}
