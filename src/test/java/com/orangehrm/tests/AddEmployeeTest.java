package com.orangehrm.tests;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddEmployeeTest extends BaseClass {

    @Test
    public void verifyAddEmployee() {

        LoginPage login = new LoginPage(driver);
        login.login(prop.getProperty("username"), prop.getProperty("password"));

        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.isDashboardDisplayed());

        PIMPage pim = new PIMPage(driver);
        pim.goToPIM();

        pim.addEmployee("Deepak", "Kumar", "Rana");

        Assert.assertTrue(pim.isEmployeeAdded());
    }
}
