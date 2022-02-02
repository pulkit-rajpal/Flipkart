package com.flipkart.tests;

import org.testng.annotations.Test;

import com.flipkart.pages.HomePage;

public class HomePageTest extends BaseTest {

	@Test(priority = 1, dependsOnGroups = "validLogin", groups = "Home")
	public void srcollHome() {
		HomePage home = new HomePage(driver);
		extentTest = extent.startTest("Verify Scroll  on the Home Page");
		home.scroll();
		extent.endTest(extentTest);
	}

}
