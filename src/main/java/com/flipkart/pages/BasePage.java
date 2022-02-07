package com.flipkart.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;

	public void waitForElementTobeClickable(WebElement webElement, WebDriver driver) {
		new WebDriverWait(driver, 14).until(ExpectedConditions.elementToBeClickable(webElement));
	}

	public void waitForElementToBeVisible(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 14);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void resizeBrowser(int width, int height) {
		Dimension d = new Dimension(width, height);
		// Resize current window to the set dimension
		driver.manage().window().setSize(d);
	}

//    protected void waitForListOfElementToBeDisplay(List<WebElement> element) {
//        Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class).pollingEvery(Duration.ofSeconds(2));
//        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(element)));
//    }

	/*
	 * public void waitForPageToLoad() { new WebDriverWait(driver, 30).until(
	 * webDriver -> ((JavascriptExecutor)
	 * webDriver).executeScript("return document.readyState").equals("complete")); }
	 */
}
