package com.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Logout {

	WebDriver driver;
	public Logout(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH,using = "//span[@class='_16v3bB']")
	public WebElement logOut ;
	
	
	
	@FindBy(how = How.CLASS_NAME,using = "_1_3w1N")
	public WebElement  loginmsg;
	
	
	public void clickLogout()
	{
		logOut.click();		
	}

	
	
	public String  verifyMsg()
	{
		return logOut.getText();
	}

}
