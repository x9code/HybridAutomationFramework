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

    // ---------------------- MAIN MENU ----------------------
    @FindBy(xpath = "//span[text()='PIM']")
    WebElement pimMenu;

    @FindBy(xpath = "//a[text()='Add Employee']")
    WebElement addEmployeeTab;

    @FindBy(xpath = "//a[text()='Employee List']")
    WebElement employeeListTab;


    // ---------------------- ADD EMPLOYEE ----------------------
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



    // ---------------------- SEARCH EMPLOYEE ----------------------
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeSearchField;

    @FindBy(xpath = "//button[text()=' Search ']")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='oxd-table-card']")
    WebElement employeeRow;



    // ---------------------- UPDATE EMPLOYEE ----------------------
    @FindBy(name = "firstName")
    WebElement nickNameInput;

    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement otherIdInput;


    // ---------------------- DELETE EMPLOYEE ----------------------
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    WebElement deleteIcon;

    @FindBy(xpath = "//button[contains(@class,'label-danger')]")
    WebElement confirmDeleteBtn;

    @FindBy(xpath = "//div[contains(@class,'success')]")
    WebElement deleteSuccessToast;



    // ---------------------- ACTION METHODS ----------------------

    // Navigate to PIM → Add Employee
    public void goToPIM_AddEmployee() {
        click(pimMenu);
        click(addEmployeeTab);
    }

    // Add Employee
    public void addEmployee(String f, String m, String l) {
        waitForVisibility(firstName, 10);

        type(firstName, f);
        type(middleName, m);
        type(lastName, l);

        scrollToElement(saveBtn);
        click(saveBtn);
    }

    // Check if employee is added
    public boolean isEmployeeAdded() {
        try {
            waitForVisibility(successToast, 10);
            return successToast.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Navigate to PIM → Employee List
    public void goToEmployeeList() {
        click(pimMenu);
        click(employeeListTab);
    }

    // Search Employee
    public void searchEmployee(String name) {
        type(employeeSearchField, name);
        click(searchButton);
        waitForVisibility(employeeRow, 5);
    }

    // Open Employee Record
    public void openEmployeeFromList() {
        click(employeeRow);
    }

    // Update Employee Details
    public void updateEmployeeDetails(String nick, String id) {
        clearAndType(nickNameInput, nick);
        clearAndType(otherIdInput, id);

        click(saveBtn);
    }

    public boolean isUpdateSuccessful() {
        return isDisplayed(successToast);
    }

    // Delete Employee
    public void deleteEmployee() {
        click(deleteIcon);
        click(confirmDeleteBtn);
    }

    public boolean isDeleteSuccessDisplayed() {
        return isDisplayed(deleteSuccessToast);
    }
}
