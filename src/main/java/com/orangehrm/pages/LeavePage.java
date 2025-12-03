package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeavePage extends BasePage {

    public LeavePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Locators
    @FindBy(xpath = "//span[text()='Leave']")
    WebElement leaveMenu;

    @FindBy(xpath = "//a[text()='Apply']")
    WebElement applyMenu;

    @FindBy(xpath = "//label[text()='From Date']/following::input[1]")
    WebElement fromDateField;

    @FindBy(xpath = "//label[text()='To Date']/following::input[1]")
    WebElement toDateField;

    @FindBy(xpath = "//label[text()='Leave Type']/following::div[@class='oxd-select-text-input']")
    WebElement leaveTypeDropdown;

    @FindBy(xpath = "//div[@role='listbox']//span")
    WebElement leaveOptionAny;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement applyButton;

    @FindBy(xpath = "//div[@class='oxd-toast-content oxd-toast-content--success']")
    WebElement leaveSuccessToast;

    // Methods

    public void goToLeaveSection() {
        click(leaveMenu);
        click(applyMenu);
    }

    public void applyLeave(String from, String to) {
        type(fromDateField, from);
        type(toDateField, to);
        click(leaveTypeDropdown);
        click(leaveOptionAny);  // selects first leave type
        click(applyButton);
    }

    public boolean isLeaveApplied() {
        return isDisplayed(leaveSuccessToast);
    }
}
