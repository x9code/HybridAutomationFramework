package com.orangehrm.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    private static final Logger logger = LogManager.getLogger(ScreenshotUtil.class);

    public static String takeScreenshot(WebDriver driver, String testName) {

        if (driver == null) {
            logger.error("Driver is NULL! Cannot take screenshot for: " + testName);
            return null;
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String folder = "./screenshots/";
        File f = new File(folder);
        if (!f.exists()) f.mkdirs();

        String path = folder + testName + "_" + timestamp + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(path);

        try {
            FileHandler.copy(src, dest);
            logger.info("Screenshot saved successfully: " + path);
        } catch (IOException e) {
            logger.error("Failed to save screenshot: " + e.getMessage());
        }

        return path;
    }
}
