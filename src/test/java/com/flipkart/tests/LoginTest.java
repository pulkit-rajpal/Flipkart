package com.flipkart.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.flipkart.pages.Login;

public class LoginTest extends BaseTest {
	@Test(priority = 1)
	public void validLogin() {
		Login login = new Login(driver);
		extentTest = extent.startTest("Verify Login with Valid Credentials");
		login.entermobileNo(prop1.getProperty("mobNo"));
		login.enterPassword(prop1.getProperty("pwd"));
		login.click_LoginButton();
		extent.endTest(extentTest);
		assertEquals(login.verifyName(), "pulkit");
	}

	@Test(priority = 0,enabled = false)
	public void invalidLogin() {
		Login login = new Login(driver);
		extentTest = extent.startTest("Verify not able to Login with InValid Credentials");
		login.entermobileNo(prop1.getProperty("mobNo"));
		login.enterPassword("wrongpassword");
		login.click_LoginButton();
		extent.endTest(extentTest);
		assertEquals(login.getError(), "Your username or password is incorrect");
	}
}
