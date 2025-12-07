package com.orangehrm.pages;

import com.orangehrm.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

public class LeavePage extends BasePage {

    public LeavePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // -------------------- MENU LOCATORS --------------------
    @FindBy(xpath = "//span[text()='Leave']")
    WebElement leaveMenu;

    @FindBy(xpath = "//a[contains(.,'Apply')]")
    WebElement applyMenu;

    @FindBy(xpath = "//a[contains(.,'My Leave')]")
    WebElement myLeaveMenu;

    // -------------------- DATE FIELD LOCATORS (Correct Final Version) --------------------
    @FindBy(xpath = "//label[text()='From Date']/../following-sibling::div//input")
    WebElement fromDateField;

    @FindBy(xpath = "//label[text()='To Date']/../following-sibling::div//input")
    WebElement toDateField;

    // -------------------- OTHER LOCATORS --------------------
    @FindBy(xpath = "//label[text()='Leave Type']/following::div[contains(@class,'oxd-select-text-input')]")
    WebElement leaveTypeDropdown;

    @FindBy(xpath = "//div[@role='listbox']//span")
    WebElement leaveOptionAny;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//div[contains(@class,'oxd-toast-content--success')]")
    WebElement successToast;

    @FindBy(xpath = "//button[text()=' Search ']")
    WebElement searchBtn;

    @FindBy(xpath = "//div[@class='oxd-table-card']")
    WebElement resultRow;


    // =====================================================================
    //                           NAVIGATION METHODS
    // =====================================================================

    /** Navigate to Apply Leave page */
    public void goToApplyLeave() {
        click(leaveMenu);
        waitForElementClickable(applyMenu, 5);
        click(applyMenu);

        // Wait until Apply Leave page header is visible
        //waitForVisibility(By.xpath("//h6[text()='Apply Leave']"), 5);
    }

    /** Navigate to My Leave page */
    public void goToMyLeave() {
        click(leaveMenu);
        waitForElementClickable(myLeaveMenu, 5);
        click(myLeaveMenu);

        // Wait until My Leave List header is visible
        //waitForVisibility(By.xpath("//h6[text()='My Leave List']"), 5);
    }


    // =====================================================================
    //                SAFE DATE TYPING (STABLE, RETRY MECHANISM)
    // =====================================================================

    private void safeType(By locator, String value) {
        int attempts = 0;

        while (attempts < 3) {
            try {
                WebElement fresh = driver.findElement(locator);
                waitForVisibility(fresh, 5);

                fresh.click();
                fresh.sendKeys(Keys.CONTROL + "a");
                fresh.sendKeys(Keys.DELETE);
                fresh.sendKeys(value);

                return; // SUCCESS
            }
            catch (StaleElementReferenceException e) {
                wait(1);
                attempts++;
            }
        }

        throw new RuntimeException("❌ Failed to type date after 3 retries → " + locator);
    }


    // =====================================================================
    //                           APPLY LEAVE
    // =====================================================================

    public void applyLeave(String from, String to) {

        safeType(By.xpath("//label[text()='From Date']/../following-sibling::div//input"), from);
        safeType(By.xpath("//label[text()='To Date']/../following-sibling::div//input"), to);

        click(leaveTypeDropdown);
        waitForElementClickable(leaveOptionAny, 5);
        click(leaveOptionAny);

        click(submitButton);
    }

    public boolean isLeaveApplied() {
        try {
            waitForVisibility(successToast, 5);
            return successToast.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    // =====================================================================
    //                           MY LEAVE SEARCH
    // =====================================================================

    public void searchLeave(String from, String to) {

        safeType(By.xpath("//label[text()='From Date']/../following-sibling::div//input"), from);
        safeType(By.xpath("//label[text()='To Date']/../following-sibling::div//input"), to);

        click(searchBtn);
        wait(1);
    }

    public boolean isResultDisplayed() {
        try {
            waitForVisibility(resultRow, 4);
            return resultRow.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
