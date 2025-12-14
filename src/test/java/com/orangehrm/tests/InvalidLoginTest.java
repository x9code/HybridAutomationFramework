package com.orangehrm.tests;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.DataProviderUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseClass {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUtil.class)
    
    public void verifyInvalidLogin(String username, String password, String expectedResult) {

        LoginPage login = new LoginPage(driver);
        login.login(username, password);

        if (expectedResult.equalsIgnoreCase("valid")) {

            Assert.assertTrue(login.isDashboardDisplayed(),
                    "❌ Dashboard not displayed for valid login");

        } else if (expectedResult.equalsIgnoreCase("invalid")) {

            Assert.assertTrue(login.isInvalidCredentialsDisplayed(),
                    "❌ Invalid credentials message not displayed");

        } else if (expectedResult.equalsIgnoreCase("required")) {

            Assert.assertTrue(login.isRequiredFieldMessageDisplayed(),
                    "❌ Required field validation not shown");
        }
    }

}
