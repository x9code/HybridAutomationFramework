package com.orangehrm.base;

import com.orangehrm.utilities.ConfigReader;
import com.orangehrm.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public Properties prop;

    @BeforeMethod
    public void setUp() {

        prop = ConfigReader.initProperties();

        String browser = prop.getProperty("browser");
        driver = WebDriverFactory.createDriver(browser);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


