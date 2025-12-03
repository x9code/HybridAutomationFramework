package com.orangehrm.tests;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test (retryAnalyzer = com.orangehrm.utilities.RetryAnalyzer.class)
    public void verifyValidLogin() {

        logger.info("----- Starting Login Test -----");

        LoginPage lp = new LoginPage(driver);
        lp.login(prop.getProperty("username"), prop.getProperty("password"));
        logger.info("Entered username and password");

        DashboardPage dp = new DashboardPage(driver);

        Assert.assertTrue(
                dp.isDashboardDisplayed(),
                "❌ Dashboard not displayed → Login failed!"
        );

        logger.info("✅ Login successful → Dashboard visible");
    }
}
