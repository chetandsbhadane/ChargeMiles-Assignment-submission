package com.chargemiles.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.chargemiles.pages.BaseClass;
import com.chargemiles.pages.LoginPage;
import com.chargemiles.utility.BrowserFactory;
import com.chargemiles.utility.ExcelDataProvider;
import com.chargemiles.utility.Helper;


public class LoginTest extends BaseClass{
	
	//Test for the user is already logged in or not if logged in then logout and id no then login..
	
	@Test
	public void loginApp() {
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		// Check if the user is logged in
		if (loginPage.isUserLoggedIn()) {
			// If logged in, log out
			loginPage.logout();
			System.out.println("Log-out");
		} else {
			// If not logged in, provide credentials and login
			loginPage.loginChargeMiles(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
			System.out.println("Log-in successful");
			
		}
		
	}
}
