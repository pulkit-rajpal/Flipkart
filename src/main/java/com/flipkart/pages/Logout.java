package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {

	WebDriver driver;

	public Logout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//span[@class='_16v3bB']")
	public WebElement logOut;

	@FindBy(how = How.CLASS_NAME, using = "_1_3w1N")
	public WebElement loginmsg;


	
	
	public void clickLogout() {
		logOut.click();
	}
	public String verifyMsg() {
		return logOut.getText();
	}
	
	public void gotoProfile() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement menu = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(".//div[@class='exehdJ'][normalize-space()='pulkit']")));
		Actions actions = new Actions(driver);
		actions.moveToElement(menu).perform();
		WebElement prof = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='My Profile']")));
		actions.moveToElement(prof);
		actions.click().build().perform();
	}


}
