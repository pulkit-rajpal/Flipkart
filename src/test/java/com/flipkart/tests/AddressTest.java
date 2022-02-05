package com.flipkart.tests;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.flipkart.pages.Address;
import com.flipkart.pages.Login;

public class AddressTest extends BaseTest {

	public static Logger logger = LogManager.getLogger(AddressTest.class);

	@Test(groups = "profile", priority = 4, enabled = false)
	public void addValidAddress() {
		extentTest = extent.startTest("Verify adding a valid Address");
		logger.info("Test :: Valid Address Test Case Started");
		Address address = new Address(driver);
		Login login = new Login(driver);
		login.entermobileNo(mobNo);
		login.enterPassword(pwd);
		login.click_LoginButton();
		address.gotoProfile();
		address.click_ManageAddress();
		address.click_add();
		address.add_details(nameval, mob, pin, ad1, ad2, cty);
		assertEquals(driver.getTitle(), "Manage Addresses");
		extent.endTest(extentTest);
		logger.info("Test :: Valid Address Test Case Ended");
	}

	@Test(groups = "profile", priority = 5)
	public void addInValidAddress() {
		logger.info("Test :: InValid Address Test Case Started");
		extentTest = extent.startTest("Verify that the user won't be able to save an Invalid Address");
		Address address = new Address(driver);
		address.gotoProfile();
		address.click_ManageAddress();
		address.click_add();
		address.add_details(nameval, mob, invalidpin, ad1, ad2, cty);
		assertEquals(address.getErrorMsg(), "Pincode entered is wrong.");
		extent.endTest(extentTest);
		logger.info("Test :: InValid Address Test Case Ended");
	}

}
