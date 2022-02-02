package com.flipkart.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.flipkart.pages.Address;

public class AddressTest extends BaseTest {

	@Test(priority = 0, dependsOnGroups = "validLogin")
	public void addValidAddress() {
		extentTest = extent.startTest("Verify Add a product To Cart");
		Address address = new Address(driver);
		gotoAddress();
		address.click_add();
		address.add_details("test", "9876543210", "122003", "hNO-3434,Block-5,Gurgoan,India", "Gurgoan", "", "Haryana");
		extent.endTest(extentTest);
	}

	@Test(priority = 0, dependsOnGroups = "validLogin")
	public void addInValidAddress() {
		extentTest = extent.startTest("Verify Add a product To Cart");
		Address address = new Address(driver);
		gotoAddress();
		address.click_add();
		address.add_details("test", "9876543210", "12121200120", "hNO-3434,Block-5,Gurgoan,India", "Gurgoan", "Gurgoan",
				"Haryana");
		assertEquals(address.getErrorMsg(), "Pincode entered is wrong.");
		extent.endTest(extentTest);
	}

}
