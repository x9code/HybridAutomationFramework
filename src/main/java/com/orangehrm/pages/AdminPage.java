package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends BasePage {

    public AdminPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//span[text()='Admin']")
    WebElement adminMenu;

    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    WebElement usernameSearchInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='oxd-table-card']//div[@role='cell'][2]")
    WebElement firstUserInTable;

    // Methods

    public void goToAdmin() {
        click(adminMenu);
    }

    public void searchUser(String username) {
        type(usernameSearchInput, username);
        click(searchButton);
    }

    public boolean isUserFound() {
        return isDisplayed(firstUserInTable);
    }
}
