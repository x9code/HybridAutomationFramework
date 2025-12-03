package com.orangehrm.base;

import com.orangehrm.utilities.ConfigReader;
import com.orangehrm.utilities.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public Properties prop;
    public Logger logger;

    @BeforeMethod
    public void setUp() {

        logger = LogManager.getLogger(getClass());
        logger.info("=========== Test Started ===========");

        prop = ConfigReader.initProperties();
        logger.info("Loaded config.properties");

        String browser = prop.getProperty("browser");
        logger.info("Launching browser: " + browser);

        driver = WebDriverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = prop.getProperty("url");
        driver.get(url);
        logger.info("Navigated to URL: " + url);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            logger.info("Closing the browser");
            driver.quit();
        }
        logger.info("=========== Test Finished ===========");
    }
}
