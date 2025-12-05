package com.orangehrm.tests;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseClass {

    @Test
    public void verifyInvalidLogin() throws InterruptedException {

        LoginPage login = new LoginPage(driver);
        logger.info("Attempting login with invalid credentials");

        login.login("wrongUser", "wrongPass");
        Assert.assertTrue(login.isInvalidCredentialsDisplayed(),
                "Invalid credentials message NOT displayed");

        logger.info("Invalid login message successfully verified");
    }
}
