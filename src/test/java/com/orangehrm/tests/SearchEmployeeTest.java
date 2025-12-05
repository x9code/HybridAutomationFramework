package com.orangehrm.tests;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.PIMPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchEmployeeTest extends BaseClass {

    @Test
    public void verifySearchEmployee() {

        LoginPage login = new LoginPage(driver);
        login.login(prop.getProperty("username"), prop.getProperty("password"));

        PIMPage pim = new PIMPage(driver);
        pim.goToEmployeeList();

        pim.searchEmployee("Linda");

        Assert.assertTrue(pim.isSearchResultDisplayed(),
                "❌ Employee search result NOT displayed!");

        logger.info("✅ Employee search verified");
    }
}
