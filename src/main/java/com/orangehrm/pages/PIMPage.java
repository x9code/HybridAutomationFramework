package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage extends BasePage {

    public PIMPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Locators using PageFactory
    @FindBy(xpath = "//span[text()='PIM']")
    WebElement pimMenu;

    @FindBy(xpath = "//button[text()=' Add ']")
    WebElement addButton;

    @FindBy(name = "firstName")
    WebElement firstName;

    @FindBy(name = "middleName")
    WebElement middleName;

    @FindBy(name = "lastName")
    WebElement lastName;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveBtn;

    @FindBy(xpath = "//div[@role='alert']")
    WebElement successToast;

    // Navigate to PIM module
    public void goToPIM() {
        click(pimMenu);
    }

    // Add Employee
    public void addEmployee(String fname, String mname, String lname) {
        click(addButton);
        type(firstName, fname);
        type(middleName, mname);
        type(lastName, lname);
        click(saveBtn);
    }

    // Validate success
    public boolean isEmployeeAdded() {
        return isDisplayed(successToast);
    }
}
