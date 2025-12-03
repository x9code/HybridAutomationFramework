package com.orangehrm.tests;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.LeavePage;
import com.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeaveModuleTest extends BaseClass {

    @Test
    public void verifyApplyLeave() {

        logger.info("===== Starting Leave Module Test =====");

        // Login
        LoginPage login = new LoginPage(driver);
        login.login(prop.getProperty("username"), prop.getProperty("password"));
        logger.info("Logged in successfully");

        // Navigate to Leave section
        LeavePage leave = new LeavePage(driver);
        leave.goToLeaveSection();
        logger.info("Opened Leave section");

        // Apply leave
        leave.applyLeave("2025-12-20", "2025-12-21");
        logger.info("Applied leave for given dates");

        // Assertion
        Assert.assertTrue(
                leave.isLeaveApplied(),
                "❌ Leave was not applied!"
        );

        logger.info("✅ Leave applied successfully");
    }
}
