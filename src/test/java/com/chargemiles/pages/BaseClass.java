package com.chargemiles.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.internal.TestResult;

import com.chargemiles.utility.BrowserFactory;
import com.chargemiles.utility.ConfigDataProvider;
import com.chargemiles.utility.ExcelDataProvider;
import com.chargemiles.utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	
	
	@BeforeSuite
	public void setUpSuit() {
		excel = new ExcelDataProvider();
		config= new ConfigDataProvider();
	}
	
	//To setup the driver
	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApplication(driver, config.getBrowser(),config.getStagingUrl());
	}
	
	//To quit the browser after work
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
		}
	}
}
