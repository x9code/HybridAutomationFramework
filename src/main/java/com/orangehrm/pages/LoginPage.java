package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    // Locators
    @FindBy(name = "username")
    WebElement usernameInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//p[text()='Invalid credentials']")
    WebElement invalidCredentialsMsg;

    @FindBy(xpath = "//span[text()='Required']")
    WebElement requiredFieldMsg;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    WebElement dashboardHeader;

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void login(String user, String pass) {

        if (!user.equalsIgnoreCase("EMPTY")) {
            clearAndType(usernameInput, user);
        }

        if (!pass.equalsIgnoreCase("EMPTY")) {
            clearAndType(passwordInput, pass);
        }

        click(loginBtn);
    }

    // Validations
    public boolean isDashboardDisplayed() {
        try {
            return dashboardHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isInvalidCredentialsDisplayed() {
        try {
            waitForVisibility(invalidCredentialsMsg, 5);
            return invalidCredentialsMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isRequiredFieldMessageDisplayed() {
        try {
            return requiredFieldMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
