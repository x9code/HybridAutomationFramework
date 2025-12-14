package com.orangehrm.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        String excelPath = System.getProperty("user.dir")
                + "/src/test/resources/testdata/LoginData.xlsx";

        return ExcelUtility.getSheetData(excelPath, "LoginData");
    }
}
