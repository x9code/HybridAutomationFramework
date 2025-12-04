package com.orangehrm.tests;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddEmployeeTest extends BaseClass {

    @Test
    public void verifyAddEmployee() {

        logger.info("=== Starting Add Employee Test ===");

        // Login
        LoginPage login = new LoginPage(driver);
        login.login(prop.getProperty("username"), prop.getProperty("password"));
        logger.info("Logged in successfully");

        // Dashboard visible
        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.isDashboardDisplayed());
        logger.info("Dashboard displayed");

        // Navigate to PIM
        PIMPage pim = new PIMPage(driver);
        pim.goToPIM();
        logger.info("Navigated to PIM module");

        // Add employee
        pim.addEmployee("Deepak", "Kumar", "Rana");
        logger.info("Filled employee details & clicked Save");

        // Validate
        Assert.assertTrue(pim.isEmployeeAdded(), "❌ Employee was not added!");
        logger.info("✅ Employee added successfully!");
    }
}
