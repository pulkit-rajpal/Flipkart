package com.flipkart.tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import com.flipkart.pages.Login;
import com.flipkart.pages.Logout;
import com.flipkart.utils.ExecutionRequired;
import com.relevantcodes.extentreports.LogStatus;

public class LogoutTest extends BaseTest {

	/* Initializing Logger */

	private static Logger logger = LogManager.getLogger(LogoutTest.class);
	private static String testPageData = "LogoutTestData";

	@Test(groups = { "Logout" }, priority = 4,enabled = true)
	public void logout() {
		String testName = "logout";
		extentTest = extent.startTest("Verify LogOut after Login");
		HashMap<String, String> testData = new HashMap<String, String>();
		testData = fileExcel.getRowTestData(testPageData, testName);
		ExecutionRequired.checkExecutionRequired(testData.get("Execution Required"));
		Login login = new Login(driver);
		logger.info("Test :: " + testName + " Signing Up to Flipkart Web App");
		login.entermobileNo(testData.get("mob").replace("\"", ""));
		login.enterPassword(testData.get("pwd"));
		login.click_LoginButton();
		logger.info("Test :: Logout Test Case Started");
		Logout logout = new Logout(driver);
		logout.gotoProfile();
		logout.clickLogout();
		extentTest.log(LogStatus.PASS, testName + " Test has Passed");
		extent.endTest(extentTest);
		assertEquals(logout.verifyMsg(), "Logout");
		logger.info("Test :: Logout Test Case Ended");
	}
}
