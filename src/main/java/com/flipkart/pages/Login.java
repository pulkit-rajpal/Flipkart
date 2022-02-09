package com.flipkart.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends BasePage{

	

	/*
	 * Login Page for getting Locators like name,address and other input text
	 * fields
	 */

	WebDriver driver;

	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	/* Declare web elements using different locators. */

	@FindBy(how = How.XPATH, using = "//input[@class='_2IX_2- VJZDxU']")
	public WebElement mobileNumber;

	@FindBy(how = How.XPATH, using = "//input[@type='password']")
	public WebElement password;

	@FindBy(how = How.XPATH, using = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	public WebElement LoginButton;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'pulkit')]")
	public WebElement getName;

	@FindBy(how = How.CLASS_NAME, using = "_2YULOR")
	public WebElement getErrorMsg;

	/*
	 * Various task Methods for performing the required task for executing Login
	 * Test Completely .
	 */

	public void entermobileNo(String mobNo) {
		WebDriverWait wait = new WebDriverWait(driver, IMPLITICIT_WAIT_10);
		WebElement mobileNumber = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='_2IX_2- VJZDxU']")));
		mobileNumber.sendKeys(mobNo);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void click_LoginButton() {
		driver.manage().timeouts().implicitlyWait(IMPLITICIT_WAIT_10, TimeUnit.SECONDS);
		LoginButton.click();
		driver.manage().timeouts().implicitlyWait(IMPLITICIT_WAIT_10, TimeUnit.SECONDS);

	}

	public String verifyName() {
		WebDriverWait wait = new WebDriverWait(driver, IMPLITICIT_WAIT_10);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'pulkit')]")));
		String name = element.getText();
		return name;
	}

	public String getError() {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		WebElement element = wait
//				.until(ExpectedConditions.elementToBeClickable(By.className("_2YULOR")));
//		String name = element.getText();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return getErrorMsg.getText();
	}

}
