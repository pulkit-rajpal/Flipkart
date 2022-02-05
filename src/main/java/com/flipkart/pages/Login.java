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

public class Login {

	WebDriver driver;

	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

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

	public void entermobileNo(String mobNo) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement mobileNumber = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='_2IX_2- VJZDxU']")));
		mobileNumber.sendKeys(mobNo);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void click_LoginButton() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public String verifyName() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'pulkit')]")));
		String name = element.getText();
		return name;
	}

	public String getError() {
		return getErrorMsg.getText();
	}

}
