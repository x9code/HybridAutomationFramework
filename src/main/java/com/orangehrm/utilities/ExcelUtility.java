package com.orangehrm.utilities;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public class ExcelUtility {

    public static Object[][] getSheetData(String path, String sheetName) {

        Object[][] data = null;

        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);

            int rows = sheet.getLastRowNum();
            int cols = sheet.getRow(0).getLastCellNum();

            data = new Object[rows][cols];

            for (int i = 1; i <= rows; i++) {
                for (int j = 0; j < cols; j++) {

                    Cell cell = sheet.getRow(i).getCell(j);

                    if (cell == null) {
                        data[i - 1][j] = "";
                    } else {
                        data[i - 1][j] = cell.toString().trim();
                    }
                }
            }

            wb.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
