package com.flipkart.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;

	static File file1 = new File(".\\Resource\\config.properties");
	static FileInputStream fis1 = null;
	static Properties prop1 = new Properties();
	
	static {
		try {
			fis1 = new FileInputStream(file1);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			prop1.load(fis1);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public long IMPLITICIT_WAIT_5 = Long.valueOf(prop1.getProperty("implicitwait5"));
	public long IMPLITICIT_WAIT_10 = Long.valueOf(prop1.getProperty("implicitwait10"));
	public long IMPLITICIT_WAIT_15 = Long.valueOf(prop1.getProperty("implicitwait15"));
	public long IMPLITICIT_WAIT_20 = Long.valueOf(prop1.getProperty("implicitwait20"));

	public void waitForElementTobeClickable(WebElement webElement, WebDriver driver) {
		new WebDriverWait(driver, 14).until(ExpectedConditions.elementToBeClickable(webElement));
	}

	public void waitForElementToBeVisible(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 14);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

}
