package com.flipkart.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.flipkart.pages.Logout;

public class LogoutTest  extends BaseTest{


	@Test(priority = 1)
	public void logout()  {
		Logout logout = new Logout(driver);
		extentTest = extent.startTest("Verify LogOut  with Valid Credentials");
		gottLogoutPage();
		logout.clickLogout();		
		extent.endTest(extentTest);
		System.out.println(logout.verifyMsg());
		assertEquals(logout.verifyMsg(), "Logout");
	}

	
}