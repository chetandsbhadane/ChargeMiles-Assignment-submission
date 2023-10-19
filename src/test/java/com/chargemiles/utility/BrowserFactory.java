package com.chargemiles.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	public static WebDriver startApplication(WebDriver driver,String browserName, String appURL) {
		if(browserName.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
//		else if(browserName.equals("Firefox")) {
//			//just give the driver properties. As I only go for the chrome but I keep this for advantage.
//		}
//		else if(browserName.equals("IE")) {
//			//just give the driver properties. As I only go for the chrome but I keep this for advantage.
//		}
		else {
			System.out.println("We do not support browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
		return driver;
	}
	
	//after work driver chrome driver window will be quit
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
		
	}

}
