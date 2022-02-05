package com.flipkart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.flipkart.pages.HomePage;
import com.flipkart.pages.Login;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageTest extends BaseTest {

	public static Logger logger = LogManager.getLogger(HomePageTest.class);

	@Test(groups = "profile", priority = 6)
	public void srcollHome() {
		logger.info("Test :: Scrolling on Home Page  Test Case Started");
		HomePage home = new HomePage(driver);
		Login login = new Login(driver);
		login.entermobileNo(mobNo);
		login.enterPassword(pwd);
		login.click_LoginButton();
		extentTest = extent.startTest("Verify Scroll  on the Home Page");
		// home.scroll();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,100)");
		extentTest.log(LogStatus.PASS, "Scrolling on Home Page  Test Case Passed");
		extent.endTest(extentTest);
		logger.info("Test :: Scrolling on Home Page  Test Case Ended");
	}

}
