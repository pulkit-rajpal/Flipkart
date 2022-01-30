package com.flipkart.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	
		public static String captureScreenshot(WebDriver driver, String testName) {
			System.out.println(testName);
			String screenshotPath = System.getProperty("user.dir")+"\\FailedScreenshots\\"+testName+".jpg";
			
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File(screenshotPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return screenshotPath;
	}
}
