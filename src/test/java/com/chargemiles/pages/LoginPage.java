package com.chargemiles.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	//Constructor
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	//find all the elements by name and xpath..
	@FindBy(name="contact") WebElement uname;
	
	@FindBy(name="password") WebElement pass;
	
	@FindBy(xpath ="//button[contains(text(),'LOGIN')]") WebElement loginButton;
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]") WebElement logoutLink;
	
	
	//method to check user is already logged in or not..
	public boolean isUserLoggedIn() {
		System.out.println("Checking If User is Logged in or Not...");
		return driver.findElements(By.xpath("//p[contains(text(),'Logout')]")).size() > 0;
		
	}
	
	public void logout() {
		logoutLink.click();
	}
	
	//mrthod for login with credentials..
	public void loginChargeMiles(String usernameApplication, String passwordApplication) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		uname.sendKeys(usernameApplication);
		pass.sendKeys(passwordApplication);
		
		loginButton.click();

	}
}
