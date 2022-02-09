package com.flipkart.tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.flipkart.pages.FlipkartProfile;
import com.flipkart.pages.Login;
import com.flipkart.utils.ExecutionRequired;
import com.relevantcodes.extentreports.LogStatus;

public class FlipkartProfileInfoTest extends BaseTest {

	/* Initializing Logger */

	private static Logger logger = LogManager.getLogger(FlipkartProfileInfoTest.class);
	private static String testPageData = "FlipkartProfileInfoTestData";

	@Test(groups = { "profile" }, priority = 18, enabled = true)
	public void changeName() {
		String testName = "changeName";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
		logger.info("Test :: Change Profile Name Test Case Started");
		extentTest = extent.startTest("Verify that the User is able to change Name for the Flipkart Account");
		logger.info("Test :: " + testName + " Signing Up to Flipkart Web App");
		Login login = new Login(driver);
		login.entermobileNo(testData.get("mob").replace("\"", ""));
		login.enterPassword(testData.get("pwd"));
		login.click_LoginButton();
		FlipkartProfile profile = new FlipkartProfile(driver);
		profile.gotoProfile();
		profile.changeName(testData.get("name"));
		extentTest.log(LogStatus.PASS, testName + " Test has Passed");
		extent.endTest(extentTest);
		assertEquals(profile.verifyName(), "pulkit");
		logger.info("Test :: Change Profile Name Test Case Ended");
	}

	@Test(groups = { "profile" }, priority = 19, enabled = true)
	public void changeGender() {
		String testName = "changeGender";
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
		logger.info("Test :: Change Gender  Test Case Started");
		FlipkartProfile profile = new FlipkartProfile(driver);
		logger.info("Test :: " + testName + " Signing Up to Flipkart Web App");
		Login login = new Login(driver);
		login.entermobileNo(testData.get("mob").replace("\"", ""));
		login.enterPassword(testData.get("pwd"));
		login.click_LoginButton();
		extentTest = extent.startTest("Verify that the User is able to change Gender for the Flipkart Account");
		profile.gotoProfile();
		profile.changeGender();
		assertEquals(profile.verifyGender().toLowerCase(), "male");
		extentTest.log(LogStatus.PASS, testName + " Test has Passed");
		extent.endTest(extentTest);
		logger.info("Test :: Change Gender  Test Case Ended");
	}
}
