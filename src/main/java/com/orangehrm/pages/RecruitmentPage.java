package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BasePage;

public class RecruitmentPage extends BasePage {

	public RecruitmentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	//Locators
	
	@FindBy(xpath = "//span[text()='Recruitment']")
	WebElement recruitmentMenu;
	
	@FindBy(linkText = "Candidates")
	WebElement candidatesTab;
	
	@FindBy(linkText = "Vacancies")
	WebElement vacanciesTab;
	
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement candidateSearchInput;
	
	@FindBy(xpath = "//button[contains(., 'Search')] ")
	WebElement searchButton;
	
	@FindBy(xpath = "//div[@class='oxd-table-card']")
    WebElement resultsRow;
	
	@FindBy(xpath = "//h5[text()='Candidates']")
    WebElement candidatesHeader;
	
	// ---------- Add Candidate Locators ----------
	@FindBy(xpath = "//button[text()=' Add ']")
	WebElement addButton;

	@FindBy(name = "firstName")
	WebElement firstNameInput;

	@FindBy(name = "middleName")
	WebElement middleNameInput;

	@FindBy(name = "lastName")
	WebElement lastNameInput;

	@FindBy(xpath = "//label[text()='Vacancy']/following::div[contains(@class,'oxd-select-text-input')]")
	WebElement vacancyDropdown;

	@FindBy(xpath = "//div[@role='listbox']//span")
	WebElement vacancyOptionAny;

	@FindBy(xpath = "//label[text()='Email']/following::input[1]")
	WebElement emailInput;

	@FindBy(xpath = "//label[text()='Contact Number']/following::input[1]")
	WebElement contactInput;

	@FindBy(xpath = "//input[@type='file']")
	WebElement resumeUploadInput;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveCandidateButton;

	@FindBy(xpath = "//div[contains(@class,'oxd-toast-content--success')]")
	WebElement successToastAddCandidate;

	/**
     * Navigate to Recruitment ➝ Candidates page
     */
    public void goToCandidates() {
        click(recruitmentMenu);
        waitForElementClickable(candidatesTab, 5);
        click(candidatesTab);

        // Confirm page is loaded
        waitForVisibility(candidatesHeader, 5);
    }
    public void uploadResume(String filePath) {
        resumeUploadInput.sendKeys(filePath);
        wait(1);
    }
    public void fillCandidateDetails(String fName, String mName, String lName, String email, String phone) {

        type(firstNameInput, fName);
        type(middleNameInput, mName);
        type(lastNameInput, lName);

        selectVacancy();
        
        type(emailInput, email);
        type(contactInput, phone);
    }
    public void saveCandidate() {
        click(saveCandidateButton);
    }
    public boolean isCandidateAdded() {
        try {
            waitForVisibility(successToastAddCandidate, 5);
            return successToastAddCandidate.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void goToAddCandidateForm() {
        click(addButton);
        waitForVisibility(firstNameInput, 5);
    }
    public void selectVacancy() {
        click(vacancyDropdown);
        waitForElementClickable(vacancyOptionAny, 5);
        click(vacancyOptionAny);
    }
    
    /**
     * Search a candidate by name
     */
    public void searchCandidate(String name) {
        waitForVisibility(candidateSearchInput, 5);
        clearAndType(candidateSearchInput, name);

        click(searchButton);

        // Wait for table results to appear
        waitForVisibility(resultsRow, 5);
    }
    
    /**
     * Validate that search returned results
     */
    public boolean isCandidateDisplayed() {
        try {
            waitForVisibility(resultsRow, 5);
            return resultsRow.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
	public void goToRecruitment() {
		waitForElementClickable(recruitmentMenu, 5);
	    click(recruitmentMenu);
	    wait(1);
	}

}
