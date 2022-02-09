package com.flipkart.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import com.flipkart.utils.FileReadExcel;
import com.flipkart.utils.Screenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {

	/* Base Test which is extended to all our Test Classes */
	/*
	 * Base Test contains the functions which can ease the Running of test classes
	 * Also it contains @before @after method, Suite function which Initialize
	 * common functionalities like Initializing reports, Reading Excel
	 */

	/* Declaring the Static variables */

	public static WebDriver driver;
	static File file1 = new File(".\\Resource\\config.properties");
	static FileInputStream fis1 = null;
	static Properties prop1 = new Properties();
	static FileReadExcel fileExcel;

	/* Initializing Logger */

	private static final Logger logger = Logger.getLogger(BaseTest.class);

	/* Initializing static extent report Variable */
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	static {
		try {
			fis1 = new FileInputStream(file1);
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		try {
			prop1.load(fis1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Starting Extent Report & Initializing from the Excel File class n storing it
	 * to a variable
	 */

	@BeforeSuite(groups = { "Login", "Logout", "home", "profile", "cart", "wishlist", "product" })
	public void setExtent() {
		extent = new ExtentReports(".\\Reports\\extentreport.html", true);
		logger.info("Extent Reporting is  Initiated");
		fileExcel = new FileReadExcel(".\\Resource\\TestCasesFile.xlsx");
	}

	/* Closing Extent Report and then storing it into html file */

	@AfterSuite(groups = { "Login", "Logout", "home", "profile", "cart", "wishlist", "product" })
	public void endReport() {
		extent.flush();
		extent.close();
		logger.info("Extent Reporting  is Finished");
	}

	/*
	 * Starting the driver by fetching driver properties from the config files and
	 * choosing browser & whether to Run the test case mode or not by fetching from
	 * properties file
	 */

	@BeforeMethod(groups = { "Login", "Logout", "home", "profile", "cart", "wishlist", "product" })
	public static void initializeWebdriver() {
		if (prop1.getProperty("Browser").equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if (prop1.getProperty("headless").equalsIgnoreCase("true")) {
				options.addArguments("--headless");
			}
			System.setProperty(prop1.getProperty("chromeDriverProperty"), prop1.getProperty("chromeDriverPath"));
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}

		else if (prop1.getProperty("Browser").equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			if (prop1.getProperty("headless").equalsIgnoreCase("true")) {
				options.setHeadless(true);
			}

			System.setProperty(prop1.getProperty("firefoxDriverProperty"), prop1.getProperty("firefoxDriverPath"));
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();

		}

		else if (prop1.getProperty("Browser").equalsIgnoreCase("edge")) {
			System.setProperty(prop1.getProperty("edgeDriverProperty"), prop1.getProperty("edgeDriverPath"));
			driver = new EdgeDriver();
		}
	}

	/* Navigating to the home page of the Flipkart */

	@BeforeMethod(groups = { "Login", "Logout", "home", "profile", "cart", "wishlist" })
	public static void navigateToFlipkart() {
		driver.get(prop1.getProperty("loginurl"));
	}

	/* Navigating to the Login page of the Flipkart */

	@BeforeMethod(groups = { "product" })
	public static void navigateToFlipkartlogin() {
		driver.get(prop1.getProperty("login"));
	}

	/* Quitting the driver after every Successive TesT case */

	@AfterMethod(groups = { "Login", "Logout", "home", "profile", "cart", "wishlist", "product" })
	public static void closebrowser() {
		driver.quit();
		logger.info("Webdriver is Closed");
	}

	/* Attaching Screenshot to the Extent Report on Every Failure */

	@AfterMethod(groups = { "Login", "Logout", "home", "profile", "cart", "wishlist", "product" })
	public void attachScreenshot(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = Screenshot.captureScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
			extent.endTest(extentTest);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case Passed Successfully!!!");
		}
	}

}
