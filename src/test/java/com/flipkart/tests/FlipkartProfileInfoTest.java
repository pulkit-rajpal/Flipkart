package com.flipkart.tests;

import org.testng.annotations.Test;

import com.flipkart.pages.FlipkartProfile;

public class FlipkartProfileInfoTest extends BaseTest {

	@Test(priority = 1, dependsOnGroups = "validLogin")
	public void changeName() {
		FlipkartProfile profile = new FlipkartProfile(driver);
		extentTest = extent.startTest("Verify Scroll  on the Home Page");
		profile.gotoProfile();
		profile.changeName("pulkit");
		extent.endTest(extentTest);
		// assertEquals(profile.verifyName(), "pulkit");
	}

	@Test(priority = 1, dependsOnGroups = "validLogin")
	public void changeGender() {
		FlipkartProfile profile = new FlipkartProfile(driver);
		extentTest = extent.startTest("Verify Scroll  on the Home Page");
		profile.gotoProfile();
		profile.changeGender();
		extent.endTest(extentTest);
	}
}
