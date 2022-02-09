package com.flipkart.tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.flipkart.pages.HomePage;
import com.flipkart.utils.ExecutionRequired;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest extends BaseTest {

	/* Initializing Logger */

	private static Logger logger = LogManager.getLogger(HomePageTest.class);
	private static String testPageData = "HomePageTestData";

	@Test(groups = { "home" }, priority = 0, enabled = true)
	public void dropDownElectronics() {
		String testName = "dropDownElectronics";
		logger.info("Test :: dropDownElectronics on Home Page  Test Case Started");
		extentTest = extent.startTest("Verify that the User is able to access Dropdown");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
		HomePage home = new HomePage(driver);
		home.clickdropdown();
		assertEquals(home.verifydropdown(), "Best of Electronics");
		extentTest.log(LogStatus.PASS, "dropDownElectronics on Home Page  Test Case Passed");
		logger.info("Test :: dropDownElectronics on Home Page  Test Case Ended");
		extent.endTest(extentTest);
	}
}
