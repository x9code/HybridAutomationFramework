package com.orangehrm.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        JavaUtility j = new JavaUtility();
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport"+j.currentTime()+".html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setDocumentTitle("Automation Test Report");
            spark.config().setReportName("OrangeHRM Test Execution");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Framework", "Hybrid Automation");
            extent.setSystemInfo("Tester", "Deepak");
        }
        return extent;
    }
}
