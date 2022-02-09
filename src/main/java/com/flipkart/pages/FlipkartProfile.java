package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartProfile extends BasePage {

	WebDriver driver;


	/*
	 * Flipkart profile Page for getting Locators for Profile Page like name,address and other input text
	 * fields
	 */

	public FlipkartProfile(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	/* Declare web elements using different locators. */

	@FindBy(className = "oKZoMV")
	public WebElement edit;

	@FindBy(name = "firstName")
	public WebElement nameBox;

	@FindBy(xpath = "//label[@for='Male']//div[@class='_1XFPmK']")
	public WebElement gender;

	@FindBy(xpath = "//button[normalize-space()='SAVE']")
	public WebElement save;

	
	
	/*
	 * Various Task Methods for performing the required task for executing profile
	 * Test Completely .
	 */

	public void gotoProfile() {
		WebDriverWait wait = new WebDriverWait(driver, IMPLITICIT_WAIT_10);
		WebElement menu = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(".//div[@class='exehdJ'][normalize-space()='pulkit']")));
		Actions actions = new Actions(driver);
		actions.moveToElement(menu).perform();
		WebElement prof = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='My Profile']")));
		actions.moveToElement(prof);
		actions.click().build().perform();
	}

	public void changeName(String name) {
		edit.click();
		nameBox.clear();
		nameBox.sendKeys(name);
		save.click();
	}

	public void changeGender() {
		edit.click();
		gender.click();
		save.click();
	}

	public String verifyName() {
		WebDriverWait wait = new WebDriverWait(driver, IMPLITICIT_WAIT_10);
		WebElement nameBox1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstName']")));
		return nameBox1.getAttribute("value");
	}

	public String verifyGender() {
		WebDriverWait wait = new WebDriverWait(driver, IMPLITICIT_WAIT_10);
		WebElement gender1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._2jIO64")));
		return gender1.getText();
	}

}
