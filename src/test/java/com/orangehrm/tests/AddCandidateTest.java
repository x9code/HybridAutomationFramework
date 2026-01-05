package com.orangehrm.tests;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.RecruitmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCandidateTest extends BaseClass {

    @Test
    public void verifyAddCandidate() {

        logger.info("===== Test Started: Add Candidate =====");

        LoginPage login = new LoginPage(driver);
        login.login(prop.getProperty("username"), prop.getProperty("password"));
        logger.info("Logged in successfully");

        RecruitmentPage rp = new RecruitmentPage(driver);
        rp.goToRecruitment();
        logger.info("Navigated to Recruitment");

        rp.goToCandidates();
        logger.info("Navigated to Candidates section");

        rp.goToAddCandidateForm();
        logger.info("Opened Add Candidate form");

        rp.fillCandidateDetails("John2", "K", "Doe", "john1.doe@testmail.com", "9876543260");
        logger.info("Filled candidate details");

        rp.uploadResume(System.getProperty("user.dir") + "/src/test/resources/testdata/resume.pdf");
        logger.info("Uploaded resume");


        rp.saveCandidate();
        logger.info("Clicked Save");

        Assert.assertTrue(rp.isCandidateAdded(), "❌ Candidate was NOT added!");
        logger.info("✅ Candidate added successfully!");
    }
}
