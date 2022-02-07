package com.flipkart.tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.flipkart.pages.FlipkartProfile;
import com.flipkart.utils.ExecutionRequired;
import com.relevantcodes.extentreports.LogStatus;

public class FlipkartProfileInfoTest extends BaseTest {

	public static Logger logger = LogManager.getLogger(FlipkartProfileInfoTest.class);
	public static String testPageData = "FlipkartProfileInfoTest";

	@Test(groups = "profile", priority = 6)
	public void changeName() {
		String testName = "changeName";
		HashMap<String, String> map = new HashMap<String, String>();
		map = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(map.get("Execution Required"));
		logger.info("Test :: Change Profile Name Test Case Started");
		extentTest = extent.startTest("Verify that the User is able to change Name for the Flipkart Account");
		FlipkartProfile profile = new FlipkartProfile(driver);
		profile.gotoProfile();
		profile.changeName("pulkit");
		extent.endTest(extentTest);
		assertEquals(profile.verifyName(), "pulkit");
		extentTest.log(LogStatus.PASS, testName + " Test has Passed");
		logger.info("Test :: Change Profile Name Test Case Ended");
	}

	@Test(groups = "profile", priority = 7)
	public void changeGender() {
		String testName = "changeGender";
		HashMap<String, String> map = new HashMap<String, String>();
		map = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(map.get("Execution Required"));
		logger.info("Test :: Change Gender  Test Case Started");
		FlipkartProfile profile = new FlipkartProfile(driver);
		extentTest = extent.startTest("Verify that the User is able to change Gender for the Flipkart Account");
		profile.gotoProfile();
		profile.changeGender();
		extent.endTest(extentTest);
		extentTest.log(LogStatus.PASS, testName + " Test has Passed");

		logger.info("Test :: Change Gender  Test Case Ended");
	}
}
