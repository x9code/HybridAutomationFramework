package com.orangehrm.tests;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.RecruitmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCandidateTest extends BaseClass {

    @Test
    public void verifyCandidateSearch() {

        logger.info("===== Test Started: Search Candidate =====");

        // 1️⃣ Login
        LoginPage login = new LoginPage(driver);
        login.login(prop.getProperty("username"), prop.getProperty("password"));
        logger.info("Logged in successfully");

        // 2️⃣ Navigate to Candidates Page
        RecruitmentPage recruitment = new RecruitmentPage(driver);
        recruitment.goToCandidates();
        logger.info("Navigated to Recruitment → Candidates");

        // 3️⃣ Search Candidate
        String candidateName = "John Doe";   // you can change this anytime
        recruitment.searchCandidate(candidateName);
        logger.info("Candidate search performed for: " + candidateName);

        // 4️⃣ Validate Results
        Assert.assertTrue(
                recruitment.isCandidateDisplayed(),
                "❌ Candidate not found in search results!"
        );

        logger.info("✔ Candidate search test passed!");
        logger.info("===== Test Finished: Search Candidate =====");
    }
}
