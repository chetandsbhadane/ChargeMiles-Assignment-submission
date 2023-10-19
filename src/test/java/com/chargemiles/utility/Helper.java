package com.chargemiles.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	///Screenshots, alerts, frames, windows, sync, issue, javascript, executor
	public static void captureScreenshot(WebDriver driver) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File("./Screenshots/chargeMiles_"+ getCurrentDateTime() +".png"));
			
			System.out.println("Screenshot captured..");
		} catch (Exception e) {
			System.out.println("Unable to capture screenshots"+e.getMessage());
		}
	}
	
	
	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		
		return customFormat.format(currentDate);
	}
}
