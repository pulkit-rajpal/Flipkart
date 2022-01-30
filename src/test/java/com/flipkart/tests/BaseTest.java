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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

import com.flipkart.utils.Screenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {

	public static WebDriver driver;
	static File file1 = new File(".\\Resources\\config.properties");
	static File file2 = new File(".\\Resources\\testData.properties");
	static FileInputStream fis1 = null;
	static FileInputStream fis2 = null;
	static Properties prop1 = new Properties();
	static Properties prop2 = new Properties();
	public static final Logger log = Logger.getLogger(BaseTest.class);

	public static ExtentReports extent;
	public static ExtentTest extentTest;
	static {
		try {
			fis1 = new FileInputStream(file1);
			fis2 = new FileInputStream(file2);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			prop1.load(fis1);
			prop2.load(fis2);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void setExtent() {
		extent = new ExtentReports(".\\Reports\\extentreport.html");

	}

	@AfterSuite
	public void endReport() {
		extent.flush();
		extent.close();
	}

	@BeforeSuite
	public static void initializeWebdriver() {
		if (prop1.getProperty("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty(prop1.getProperty("chromeDriverProperty"), prop1.getProperty("chromeDriverPath"));
			ChromeOptions options = new ChromeOptions();
//	        options.addArguments("--headless");
			driver = new ChromeDriver(options);
			System.out.println(driver);
		} else if (prop1.getProperty("Browser").equalsIgnoreCase("ie")) {
			System.setProperty(prop1.getProperty("ieDriverProperty"), prop1.getProperty("ieDriverPath"));
			driver = new InternetExplorerDriver();
		} else if (prop1.getProperty("Browser").equalsIgnoreCase("edge")) {
			System.setProperty(prop1.getProperty("edgeDriverProperty"), prop1.getProperty("edgeDriverPath"));
			driver = new EdgeDriver();
		} else if (prop1.getProperty("Browser").equalsIgnoreCase("firefox")) {
			System.setProperty(prop1.getProperty("firefoxDriverProperty"), prop1.getProperty("firefoxDriverPath"));
			driver = new FirefoxDriver();
		}

	}

	@BeforeMethod
	public static void navigateToGoogleSearchPage() {

		driver.get(prop1.getProperty("loginurl"));
	}

	@AfterSuite
	public static void closebrowser() {
		driver.close();
		driver.quit();
	}

	    @AfterMethod()
		public void attachScreenshot(ITestResult result) {
			if (result.getStatus() == ITestResult.FAILURE) {
				String screenshotPath = Screenshot.captureScreenshot(driver, result.getName());
				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
				extent.endTest(extentTest);
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				extentTest.log(LogStatus.PASS, "Test Case Passed Successfully!!!");
			}
		}
	    
	    
	public static void ReturnToHomePage() {

		driver.get(prop1.getProperty("url"));
	}

	public static void ReturnToAddressPage() {
		driver.get(prop1.getProperty("addressurl"));
	}

	public static void ReturnToSignInPage() {
		driver.get(prop1.getProperty("loginurl"));
	}
	
	public static void gottLogoutPage() {
		driver.get(prop1.getProperty("accounturl"));
	}
}
