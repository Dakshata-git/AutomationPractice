package com.practice.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class TestDataProvider {

    public static Object[][] getDataFromSheet(String sheetName) {

        Workbook book = null;
        try {
            book = WorkbookFactory.create(getTestDataFile());
        } catch (Exception e) {
        }
        Sheet sheet = book.getSheet(sheetName);
        return getTestDataFromExcelFile(sheet);
    }

    // this method reads excel file and return the file path
    private static FileInputStream getTestDataFile() throws IOException {
        return new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Data/Testdata.xlsx");
    }

    private static Object[][] getTestDataFromExcelFile(Sheet sheet) {
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for (int i = 0; i < sheet.getLastRowNum(); i++) {

            System.out.println("Last row no is : " + sheet.getLastRowNum());
            System.out.println("Last Cell number" +sheet.getRow(0).getLastCellNum());

            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                System.out.println("Row no and cell : " +sheet.getRow(i + 1).getCell(k));
                System.out.println(data[i][k]);
            }
        }
        return data;
    }
}
