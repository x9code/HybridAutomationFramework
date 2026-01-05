package com.orangehrm.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.orangehrm.base.BaseClass;
import com.orangehrm.utilities.ExtentReportManager;
import com.orangehrm.utilities.ScreenshotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    private static final Logger logger = LogManager.getLogger(Listeners.class);
    private static ExtentReports extent ;
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        logger.info("🟦 Test Started: " + result.getName());
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, result.getName()+" Passed");
        logger.info("✅ Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getName();
        logger.error("❌ Test Failed: " + testName);
        test.log(Status.FAIL, result.getName()+" failed");

        Object testObj = result.getInstance();
        WebDriver driver = null;

        if (testObj instanceof BaseClass) {
            driver = ((BaseClass) testObj).driver;
        }

        if (driver != null) {
            String path = ScreenshotUtil.takeScreenshot(driver, testName);
            logger.info("📸 Screenshot captured at: " + path);
        }
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("===== Test Suite Started =====");
        extent = ExtentReportManager.getInstance();
    }

    @Override
    public void onFinish(ITestContext context) {

        logger.info("===== Test Suite Finished =====");
        extent.flush();
    }
}
