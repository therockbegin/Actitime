package com.Actitime.GenericLibrary;

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

public class BaseClass {
   WebDriver driver;
	@BeforeSuite
	public void databaseConnection () {
		Reporter.log("database connected", true);
	}
	
	@BeforeClass
	public void launchBrowser () {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.actitime.com");
		Reporter.log("browser launched successfully", true);
	}
	
	@BeforeMethod
	public void Login () {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		Reporter.log("logged in successfully", true);
    }
	
	@AfterMethod
	public void logout () {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("logged out successfully", true);
	}
  
	@AfterClass
	public void closebrowser () {
		driver.close();
		Reporter.log("browser closed successfully", true);
	}
	  
	@AfterSuite
	public void databasedisconnected () {
		Reporter.log("database disconnected", true);
	}
	
}
