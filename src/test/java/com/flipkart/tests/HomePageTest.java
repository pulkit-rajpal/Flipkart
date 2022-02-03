package com.flipkart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.flipkart.pages.HomePage;

public class HomePageTest extends BaseTest {

	public static Logger logger = LogManager.getLogger(HomePageTest.class);

	@Test(priority = 20, dependsOnGroups = "validLogin", groups = "Home")
	public void srcollHome() {
		logger.info("Test :: Scrolling on Home Page  Test Case Started");
		HomePage home = new HomePage(driver);
		extentTest = extent.startTest("Verify Scroll  on the Home Page");
		home.scroll();
		extent.endTest(extentTest);
		logger.info("Test :: Scrolling on Home Page  Test Case Ended");

	}

}
