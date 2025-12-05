package com.orangehrm.tests;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.PIMPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteEmployeeTest extends BaseClass {

    @Test
    public void verifyDeleteEmployee() {

        LoginPage login = new LoginPage(driver);
        login.login(prop.getProperty("username"), prop.getProperty("password"));

        PIMPage pim = new PIMPage(driver);
        pim.goToEmployeeList();

        pim.searchEmployee("Linda");
        pim.deleteEmployee();

        Assert.assertTrue(pim.isDeleteSuccessDisplayed(),
                "❌ Employee deletion failed!");

        logger.info("🗑 Employee deleted successfully");
    }
}
