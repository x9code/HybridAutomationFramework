package com.orangehrm.listeners;

import com.orangehrm.base.BaseClass;
import com.orangehrm.utilities.ScreenshotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    private static final Logger logger = LogManager.getLogger(Listeners.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("🟦 Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("✅ Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getName();
        logger.error("❌ Test Failed: " + testName);

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
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("===== Test Suite Finished =====");
    }
}
