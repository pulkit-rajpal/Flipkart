package com.flipkart.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.flipkart.pages.Logout;

public class LogoutTest  extends BaseTest{

	public static Logger logger = LogManager.getLogger(LogoutTest.class);


	@Test(dependsOnGroups = "validlogin",groups ="Logout",priority = 3)
	public void logout()  {
		logger.info("Test :: Logout Test Case Started");
		Logout logout = new Logout(driver);
		extentTest = extent.startTest("Verify LogOut after Login");
		logout.gotoProfile();
		logout.clickLogout();		
		extent.endTest(extentTest);
		System.out.println(logout.verifyMsg());
		assertEquals(logout.verifyMsg(), "Logout");
		logger.info("Test :: Logout Test Case Ended");

	}

	
}
