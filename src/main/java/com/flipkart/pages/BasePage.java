package com.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;

	public void waitForElementTobeClickable(WebElement webElement, WebDriver driver) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(webElement));
	}

	public void waitForElementToBeVisible(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/*
	 * public void waitForPageToLoad() { new WebDriverWait(driver, 30).until(
	 * webDriver -> ((JavascriptExecutor)
	 * webDriver).executeScript("return document.readyState").equals("complete")); }
	 */
}
