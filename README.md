# 🧪 Hybrid Automation Framework – Selenium | TestNG | Maven | POM  
A complete end-to-end automation framework for OrangeHRM — designed using **Selenium WebDriver, TestNG, Page Object Model, Log4j2, Maven**, and **Hybrid Framework principles**.

---

## 🚀 Tech Stack

![Java](https://img.shields.io/badge/Java-17+-red)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-brightgreen)
![TestNG](https://img.shields.io/badge/TestNG-Framework-blue)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-orange)
![POM](https://img.shields.io/badge/Design-POM-yellow)
![Log4j2](https://img.shields.io/badge/Logging-Log4j2-lightgrey)
![Automation](https://img.shields.io/badge/Automation-Hybrid%20Framework-purple)

---

<!--# 📸 Demo GIF (Add your recording here)
> *(Optional — add a run GIF)*  -->

## 🚀 Tech Stack

| Technology | Purpose |
|------------|---------|
| **Java 17+** | Core programming language |
| **Selenium WebDriver** | Browser automation |
| **TestNG** | Test execution & assertions |
| **Maven** | Dependency & build management |
| **Page Object Model (POM)** | Design pattern |
| **WebDriverManager** | Auto driver management |
| **Log4j2** | Logging framework |
| **Custom Listeners** | Test event handling |
| **Retry Analyzer** | Failed test retry mechanism |

---

## 📂 Project Structure

```
HybridAutomationFramework
│
├── src
│   ├── main/java
│   │   ├── com.orangehrm.base          # Base classes
│   │   ├── com.orangehrm.config        # Configuration handlers
│   │   ├── com.orangehrm.pages         # Page Object classes
│   │   └── com.orangehrm.utilities     # Utility classes
│   │
│   ├── test/java
│   │   ├── com.orangehrm.tests         # Test cases
│   │   └── com.orangehrm.listeners     # TestNG listeners
│   │
│   └── resources
│       ├── config.properties           # Application config
│       └── log4j2.xml                  # Logging config
│
├── logs/                               # Execution logs
├── screenshots/                        # Failure screenshots
├── pom.xml                             # Maven dependencies
├── testng.xml                          # TestNG suite configuration
└── README.md                           # Project documentation
```

---

## 🌟 Framework Features

### ✅ Hybrid Test Automation
Combines **Page Object Model + Utilities + Data-driven** design for maximum flexibility and maintainability.

### ✅ Page Object Model (POM)
Separate class for each module:
- Login Page
- Dashboard Page
- PIM (Employee Management)
- Leave Module
- Admin Module

### ✅ Log4j2 Logging
Detailed execution logs stored in `/logs` directory with timestamp and log levels.

### ✅ Screenshot on Failure
Automatically captured via custom TestNG listener and saved to `/screenshots`.

### ✅ WebDriver Factory
Single configurable driver manager supporting multiple browsers (Chrome, Firefox, Edge).

### ✅ Retry Failed Tests
Implemented using `RetryAnalyzer` + `RetryListener` to handle flaky tests.

### ✅ TestNG Suite Execution
Run multiple tests via `testng.xml` with parallel execution support.

---

## ⚙️ Setup & Installation

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/x9code/HybridAutomationFramework.git
cd HybridAutomationFramework
```

### 2️⃣ Install Dependencies
```bash
mvn clean install
```

### 3️⃣ Configure Application Properties
Update `src/main/resources/config.properties`:

```properties
browser=chrome
url=https://opensource-demo.orangehrmlive.com
username=Admin
password=admin123
implicitWait=10
explicitWait=20
```

### 4️⃣ Run the Test Suite

**Option 1: Via Maven**
```bash
mvn test
```

**Option 2: Via TestNG XML**
Right-click `testng.xml` → **Run as TestNG Suite**

---

## 🧪 Automated Test Modules

### 🔹 Login Test
- Valid login validation
- Dashboard verification
- Invalid credentials handling

### 🔹 PIM Module – Add Employee
- Navigate to PIM
- Fill employee details (First Name, Middle Name, Last Name)
- Save employee
- Validate success message

### 🔹 Admin Module
- Search user by username
- Validate user appears in results table
- Verify user role and status

### 🔹 Leave Module
- Apply for leave
- Navigate to My Leave
- Search applied leave
- Validate leave status in results

---

## 📸 Screenshots & Logs

### Screenshots on Failure
Failed test screenshots are automatically saved in:
```
/screenshots/TestName_timestamp.png
```

### Log4j2 Execution Logs
Detailed execution logs with INFO, DEBUG, ERROR levels:
```
/logs/execution.log
```

---

## 📑 Sample Test – Add Employee

```java
package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.PIMPage;

public class AddEmployeeTest extends BaseTest {
    
    @Test(priority = 1)
    public void verifyAddEmployee() {
        // Login
        LoginPage login = new LoginPage(driver);
        login.login(prop.getProperty("username"), 
                   prop.getProperty("password"));
        
        // Verify Dashboard
        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.isDashboardDisplayed(), 
                         "Dashboard not displayed!");
        
        // Navigate to PIM and Add Employee
        PIMPage pim = new PIMPage(driver);
        pim.goToPIM();
        pim.addEmployee("Deepak", "Kumar", "Rana");
        
        // Validate Employee Added
        Assert.assertTrue(pim.isEmployeeAdded(), 
                         "Employee not added successfully!");
    }
}
```

---

## 📄 TestNG Suite XML

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="OrangeHRM Test Suite" parallel="tests" thread-count="2">
    
    <listeners>
        <listener class-name="com.orangehrm.listeners.TestListener"/>
        <listener class-name="com.orangehrm.listeners.RetryListener"/>
    </listeners>
    
    <test name="Login Tests">
        <classes>
            <class name="com.orangehrm.tests.LoginTest"/>
        </classes>
    </test>
    
    <test name="PIM Tests">
        <classes>
            <class name="com.orangehrm.tests.AddEmployeeTest"/>
        </classes>
    </test>
    
    <test name="Leave Tests">
        <classes>
            <class name="com.orangehrm.tests.LeaveManagementTest"/>
        </classes>
    </test>
    
</suite>
```

---

## 🛠️ Maven Dependencies

```xml
<dependencies>
    <!-- Selenium -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.15.0</version>
    </dependency>
    
    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.8.0</version>
    </dependency>
    
    <!-- WebDriverManager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.6.2</version>
    </dependency>
    
    <!-- Log4j2 -->
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
        <version>2.21.1</version>
    </dependency>
</dependencies>
```

---

## 🎯 Key Features Explained

### 🔄 Retry Analyzer
Automatically retries failed tests up to a configurable limit:

```java
public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 2;
    
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
```

### 📷 Screenshot Listener
Captures screenshots on test failure:

```java
@Override
public void onTestFailure(ITestResult result) {
    WebDriver driver = ((BaseTest) result.getInstance()).driver;
    String screenshotPath = captureScreenshot(driver, result.getName());
    logger.error("Test Failed: " + result.getName());
    logger.error("Screenshot: " + screenshotPath);
}
```

---

## 🧑‍💻 Author

**Deepak Kumar Rana**  
Automation Tester | Java | Selenium | TestNG

[![GitHub](https://img.shields.io/badge/GitHub-x9code-black?logo=github)](https://github.com/x9code)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Connect-blue?logo=linkedin)](https://linkedin.com/in/your-profile)

---

## ⭐ Support

If this project helped you, please:
- ⭐ **Star this repository**
- 🍴 **Fork it** for your own projects
- 📢 **Share** with the community
- 💬 **Contribute** via pull requests

---

## 📝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

<!--## 📜 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

--->

## 🔗 Resources

- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/documentation-main.html)
- [Maven Repository](https://mvnrepository.com/)
- [OrangeHRM Demo Site](https://opensource-demo.orangehrmlive.com/)

---

<div align="center">
  
### 🌟 Made with ❤️ by [x9code](https://github.com/x9code)

**Happy Testing! 🚀**

</div>
```bash
git clone https://github.com/x9code/HybridAutomationFramework.git
