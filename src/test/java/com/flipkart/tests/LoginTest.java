package com.flipkart.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.flipkart.pages.Login;
import com.flipkart.utils.ExecutionRequired;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BaseTest {

	/* Initializing Logger */

	private static Logger logger = LogManager.getLogger(LoginTest.class);

	private static String testPageData = "LoginTestData";

	
	
	@Test(groups = { "Login" }, priority = 2,enabled = true)
	public void validLogin() {
		String testName = "validLogin";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
		logger.info("Test :: Valid Login Test Case Started");
		extentTest = extent.startTest("Verify Login with Valid Credentials");
		Login login = new Login(driver);
		logger.info("Test :: " + testName + " Signing Up to Flipkart Web App");
		
		login.entermobileNo(testData.get("mob").replace("\"", ""));
		login.enterPassword(testData.get("pwd"));
		login.click_LoginButton();
		extent.endTest(extentTest);
		extentTest.log(LogStatus.PASS, testName + " Test has Passed");
		assertEquals(login.verifyName(), "pulkit");
		logger.info("Test :: Valid Login Test Case Ended");
	}

	@Test(groups = { "Login" }, priority = 1,enabled = true)
	public void invalidLogin() {
		String testName = "invalidLogin";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
		//System.out.println(testData.get("mob"));
		logger.info("Test :: InValid Login Test Case Started");
		extentTest = extent.startTest("Verify not able to Login with InValid Credentials");
		logger.info("Test :: " + testName + " Signing Up to Flipkart Web App");
		Login login = new Login(driver);
		login.entermobileNo(testData.get("mob").replace("\"", ""));
		login.enterPassword(testData.get("pwd"));
		login.click_LoginButton();
		extent.endTest(extentTest);
		extentTest.log(LogStatus.PASS, testName + " Test has Passed");
		assertNotEquals(login.getError(), "Your username or password is incorrect");
		logger.info("Test :: InValid Login Test Case Ended");
		
	}
}
