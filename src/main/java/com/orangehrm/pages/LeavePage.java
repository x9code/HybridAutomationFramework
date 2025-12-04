package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeavePage extends BasePage {

    public LeavePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // ========== MENU ==========
    @FindBy(xpath = "//span[text()='Leave']")
    WebElement leaveMenu;

    @FindBy(xpath = "//a[text()='Apply']")
    WebElement applyMenu;

    @FindBy(xpath = "//a[text()='My Leave']")
    WebElement myLeaveMenu;

    // ========== APPLY LEAVE ==========
    @FindBy(xpath = "//label[text()='From Date']/following::input[1]")
    WebElement fromDateField;

    @FindBy(xpath = "//label[text()='To Date']/following::input[1]")
    WebElement toDateField;

    @FindBy(xpath = "//label[text()='Leave Type']/following::div[contains(@class,'oxd-select-text-input')]")
    WebElement leaveTypeDropdown;

    @FindBy(xpath = "//div[@role='listbox']//span")
    WebElement leaveOptionAny;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement applyButton;

    @FindBy(xpath = "//div[contains(@class,'oxd-toast-content--success')]")
    WebElement leaveSuccessToast;

    // ========== MY LEAVE ==========
    @FindBy(xpath = "//button[text()=' Search ']")
    WebElement searchButton;

    @FindBy(xpath = "//div[text()='No Records Found']")
    WebElement noRecordsRow;


    // ----------- ACTIONS -----------

    public void goToApplyLeave() {
        click(leaveMenu);
        wait(1);
        click(applyMenu);
    }

    public void applyLeave(String from, String to) {

        waitForVisibility(fromDateField, 5);

        clearField(fromDateField);
        fromDateField.sendKeys(from);

        clearField(toDateField);
        toDateField.sendKeys(to);

        click(leaveTypeDropdown);
        click(leaveOptionAny);

        click(applyButton);
    }


    public boolean isLeaveApplied() {
        try {
            waitForVisibility(leaveSuccessToast, 5);
            return leaveSuccessToast.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // ----------- MY LEAVE Page -----------

    public void goToMyLeave() {
        click(leaveMenu);
        wait(1);
        click(myLeaveMenu);
    }

    public void searchLeave(String from, String to) {
        clearAndType(fromDateField, from);
        clearAndType(toDateField, to);
        click(searchButton);
        wait(2);
    }

    public boolean isResultDisplayed() {
        // TRUE if table has at least one row
        try {
            driver.findElement(By.xpath("//div[@class='oxd-table-card']"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
