package com.flipkart.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.flipkart.pages.Login;

public class LoginTest extends BaseTest {

	public static Logger logger = LogManager.getLogger(LoginTest.class);

	@Test(groups = { "Login", "validlogin" }, priority = 1)
	public void validLogin() {
		logger.info("Test :: Valid Login Test Case Started");
		extentTest = extent.startTest("Verify Login with Valid Credentials");
		Login login = new Login(driver);
		login.entermobileNo(mobNo);
		login.enterPassword(pwd);
		login.click_LoginButton();
		extent.endTest(extentTest);
		assertEquals(login.verifyName(), "pulkit");
		logger.info("Test :: Valid Login Test Case Ended");
	}

	@Test(groups = "Login", priority = 0)
	public void invalidLogin() {
		logger.info("Test :: InValid Login Test Case Started");
		extentTest = extent.startTest("Verify not able to Login with InValid Credentials");
		Login login = new Login(driver);
		login.entermobileNo(mobNo);
		login.enterPassword("wrongpassword");
		login.click_LoginButton();
		extent.endTest(extentTest);
		assertNotEquals(login.getError(), "Your username or password is incorrect");
		logger.info("Test :: InValid Login Test Case Ended");

	}
}
