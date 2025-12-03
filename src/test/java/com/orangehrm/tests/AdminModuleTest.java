package com.orangehrm.tests;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.AdminPage;
import com.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminModuleTest extends BaseClass {

    @Test
    public void verifySearchUser() {

        logger.info("===== Starting Admin Module Test =====");

        // Login
        LoginPage login = new LoginPage(driver);
        login.login(prop.getProperty("username"), prop.getProperty("password"));
        logger.info("Logged in successfully");

        // Navigate to Admin page
        AdminPage admin = new AdminPage(driver);
        admin.goToAdmin();
        logger.info("Navigated to Admin module");

        // Search for a user
        admin.searchUser("Admin");
        logger.info("Searched for user: Admin");

        // Assertion
        Assert.assertTrue(
                admin.isUserFound(),
                "❌ User not found in Admin table!"
        );

        logger.info("✅ Admin user found successfully");
    }
}
