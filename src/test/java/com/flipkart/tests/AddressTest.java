package com.flipkart.tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.flipkart.pages.Address;
import com.flipkart.pages.Login;
import com.flipkart.utils.ExecutionRequired;
import com.relevantcodes.extentreports.LogStatus;

public class AddressTest extends BaseTest {

	/* Initializing Logger */

	private static Logger logger = LogManager.getLogger(AddressTest.class);
	private static String testPageData = "AddressTestData";

	@Test(groups = { "profile" }, priority = 16, enabled = true)
	public void addValidAddress() {
		String testName = "addValidAddress";
		HashMap<String, String> testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
		extentTest = extent.startTest("Verify adding a valid Address");
		logger.info("Test :: Valid Address Test Case Started");
		Address address = new Address(driver);
		logger.info("Test :: " + testName + " - Signing Up to Flipkart Web App");
		Login login = new Login(driver);
		login.entermobileNo(testData.get("mob").replace("\"", ""));
		login.enterPassword(testData.get("pwd"));
		login.click_LoginButton();
		address.gotoProfile();
		address.click_ManageAddress();
		address.click_add();
		address.add_details(testData.get("nameval"), testData.get("mobno").replace("\"", ""),
				testData.get("pin").replace("\"", ""), testData.get("ad1"), testData.get("ad2"));
		logger.info("Test :: " + testName + "A New Address Added to the profile");
		assertEquals(driver.getTitle(), "Manage Addresses");
		extentTest.log(LogStatus.PASS, testName + " Test has Passed");
		extent.endTest(extentTest);
		logger.info("Test :: Valid Address Test Case Ended");
	}

	@Test(groups = { "profile" }, priority = 17, enabled = true)
	public void addInValidAddress() {
		String testName = "addInValidAddress";
		HashMap<String, String> testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
		logger.info("Test :: InValid Address Test Case Started");
		extentTest = extent.startTest("Verify that the user won't be able to save an Invalid Address");
		Address address = new Address(driver);
		Login login = new Login(driver);
		logger.info("Test :: " + testName + " -Signing Up to Flipkart Web App");
		login.entermobileNo(testData.get("mob").replace("\"", ""));
		login.enterPassword(testData.get("pwd"));
		login.click_LoginButton();
		address.gotoProfile();
		address.click_ManageAddress();
		address.click_add();
		address.add_details(testData.get("nameval"), testData.get("mobno"),
				testData.get("invalidpin").replace("\"", ""), testData.get("ad1"), testData.get("ad2"));
		assertEquals(address.getErrorMsg(), "Pincode entered is wrong.");
		extentTest.log(LogStatus.PASS, testName + " Test has Passed");
		extent.endTest(extentTest);
		logger.info("Test :: InValid Address Test Case Ended");
	}

}
