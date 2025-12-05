package com.orangehrm.tests;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.PIMPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateEmployeeDetailsTest extends BaseClass {

    @Test
    public void verifyUpdateEmployeeDetails() {

        LoginPage login = new LoginPage(driver);
        login.login(prop.getProperty("username"), prop.getProperty("password"));

        PIMPage pim = new PIMPage(driver);

        pim.goToEmployeeList();
        pim.searchEmployee("Deepak");   // Replace dynamically later
        pim.openEmployeeFromList();

        pim.updateEmployeeDetails("DK", "12345");

        Assert.assertTrue(pim.isUpdateSuccessful(),
                "❌ Employee details not updated!");
    }
}
