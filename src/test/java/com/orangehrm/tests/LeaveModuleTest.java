package com.orangehrm.tests;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.LeavePage;
import com.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeaveModuleTest extends BaseClass {

    @Test
    public void verifyApplyLeave() {

        LoginPage login = new LoginPage(driver);
        login.login(prop.getProperty("username"), prop.getProperty("password"));

        LeavePage leave = new LeavePage(driver);

        // 1️⃣ Apply Leave
        leave.goToApplyLeave();
        leave.applyLeave("2025-01-10", "2025-01-10");
        Assert.assertTrue(leave.isLeaveApplied(), "❌ Leave not applied!");

        // 2️⃣ Go to My Leave
        leave.goToMyLeave();

        // 3️⃣ Search Leave List
        leave.searchLeave("2025-01-01", "2025-12-31");

        // 4️⃣ Validate record exists
        Assert.assertTrue(leave.isResultDisplayed(),
                "❌ Leave record not found in My Leave list!");
    }
}
