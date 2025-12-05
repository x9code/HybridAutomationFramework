package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage extends BasePage {

    public PIMPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // --- Locators ---
    @FindBy(xpath = "//span[text()='PIM']")
    WebElement pimMenu;

    @FindBy(xpath = "//a[text()='Add Employee']")
    WebElement addEmployeeTab;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name='middleName']")
    WebElement middleName;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastName;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveBtn;

    @FindBy(xpath = "//div[contains(@class,'oxd-toast-content')]")
    WebElement successToast;
    
    @FindBy(xpath = "//a[text()='Employee List']")
    WebElement employeeListMenu;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeSearchField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='oxd-table-card']")
    WebElement resultRow;
    
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    WebElement deleteIcon;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
    WebElement confirmDeleteBtn;

    @FindBy(xpath = "//div[contains(@class,'success')]")
    WebElement deleteSuccessToast;

    public void deleteEmployee() {
        click(deleteIcon);
        click(confirmDeleteBtn);
    }

    public boolean isDeleteSuccessDisplayed() {
        return isDisplayed(deleteSuccessToast);
    }


    public void goToEmployeeList() {
        click(pimMenu);
        click(employeeListMenu);
    }

    public void searchEmployee(String name) {
        type(employeeSearchField, name);
        click(searchButton);
    }

    public boolean isSearchResultDisplayed() {
        return isDisplayed(resultRow);
    }


    // ---------- Page Actions ----------

    // Navigate to PIM module
    public void goToPIM() {
        click(pimMenu);
        wait(1);
        click(addEmployeeTab);
    }

    // Add employee with waits + scroll into view
    public void addEmployee(String fName, String mName, String lName) {

        waitForVisibility(firstName, 10);

        type(firstName, fName);
        type(middleName, mName);
        type(lastName, lName);

        scrollToElement(saveBtn);
        wait(1);

        click(saveBtn);
    }

    // Validate the success toast message
    public boolean isEmployeeAdded() {
        try {
            waitForVisibility(successToast, 10);
            return successToast.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
