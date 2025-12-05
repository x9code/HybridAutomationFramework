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

    public boolean isInvalidCredentialsDisplayed() {
        try {
            waitForVisibility(invalidCredentialsMsg, 5);
            return invalidCredentialsMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    // Actions
    public void login(String user, String pass) {
        type(usernameInput, user);
        type(passwordInput, pass);
        click(loginBtn);
    }
}
