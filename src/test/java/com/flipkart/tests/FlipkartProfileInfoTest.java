package com.flipkart.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.flipkart.pages.FlipkartProfile;

public class FlipkartProfileInfoTest extends BaseTest {

	public static Logger logger = LogManager.getLogger(FlipkartProfileInfoTest.class);

	@Test(groups = "profile", priority = 6)
	public void changeName() {
		logger.info("Test :: Change Profile Name Test Case Started");
		extentTest = extent.startTest("Verify that the User is able to change Name for the Flipkart Account");
		FlipkartProfile profile = new FlipkartProfile(driver);
		profile.gotoProfile();
		profile.changeName("pulkit");
		extent.endTest(extentTest);
		assertEquals(profile.verifyName(), "pulkit");
		logger.info("Test :: Change Profile Name Test Case Ended");

	}

	@Test(groups = "profile", priority = 7)
	public void changeGender() {
		logger.info("Test :: Change Gender  Test Case Started");
		FlipkartProfile profile = new FlipkartProfile(driver);
		extentTest = extent.startTest("Verify that the User is able to change Gender for the Flipkart Account");
		profile.gotoProfile();
		profile.changeGender();
		extent.endTest(extentTest);
		logger.info("Test :: Change Gender  Test Case Ended");
	}
}
