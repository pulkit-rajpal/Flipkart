package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{



	WebDriver driver;
	
	/*
	 * Home Page for getting Locators for testing functionalities of the Home Page
	 * fields
	 */


	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/*
	 * Various Click Methods for performing the required task for executing Home
	 * Test Completely .
	 */

	public void clickdropdown() {
		driver.get(prop1.getProperty("loginurl"));
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ESCAPE).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, IMPLITICIT_WAIT_15);
		WebElement menu = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Electronics')]")));
		Actions actions = new Actions(driver);
		actions.moveToElement(menu).perform();
		WebElement prof = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a._6WOcW9._2-k99T")));
		actions.moveToElement(prof);
		actions.click().build().perform();

	}

	public String verifydropdown() {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement text = wait.until(ExpectedConditions.elementToBeClickable(By.className("_3vKRL2")));
		return text.getText();
	}

}
