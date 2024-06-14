package Utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class DataManager {
    // Path to the Excel file
    private static final String EXCEL_FILE_PATH = "D:\\IntelliJ\\Selenium_Java_Allure\\src\\test\\resources\\data.xlsx";

    // Method to get the data value based on the given data name
    public static String getDataValue(String dataName) {
        // Try-with-resources to ensure FileInputStream and Workbook are closed automatically
        try (FileInputStream fs = new FileInputStream(EXCEL_FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fs)) {

            // Get the first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet

            // Iterate through each row in the sheet
            for (Row row : sheet) {
                // Get the cell in the first column (name column)
                Cell nameCell = row.getCell(0);
                // Get the cell in the second column (value column)
                Cell valueCell = row.getCell(1);

                // Check if nameCell is not null and its type is STRING
                if (nameCell != null && nameCell.getCellType() == CellType.STRING
                        && nameCell.getStringCellValue().equals(dataName)) {
                    // If valueCell is not null, handle its different types
                    if (valueCell != null) {
                        switch (valueCell.getCellType()) {
                            case STRING:
                                // If cell type is STRING, return the string value
                                return valueCell.getStringCellValue();
                            case NUMERIC:
                                // If cell type is NUMERIC, check if it is a date formatted cell
                                if (DateUtil.isCellDateFormatted(valueCell)) {
                                    // Return the date value as a string
                                    return valueCell.getDateCellValue().toString();
                                } else {
                                    // Convert numeric value to string
                                    return String.valueOf(valueCell.getNumericCellValue());
                                }
                            case BOOLEAN:
                                // If cell type is BOOLEAN, return the boolean value as a string
                                return Boolean.toString(valueCell.getBooleanCellValue());
                            case FORMULA:
                                // If cell type is FORMULA, handle the cached formula result type
                                switch (valueCell.getCachedFormulaResultType()) {
                                    case STRING:
                                        // Return the string result of the formula
                                        return valueCell.getStringCellValue();
                                    case NUMERIC:
                                        // Convert numeric result of the formula to string
                                        return String.valueOf(valueCell.getNumericCellValue());
                                    default:
                                        // Return a message for unsupported formula result type
                                        return "Unsupported formula result type";
                                }
                            default:
                                // Return a message for unsupported cell types
                                return "Unsupported cell type";
                        }
                    }
                }
            }
        } catch (IOException e) {
            // Print the stack trace if an exception occurs
            e.printStackTrace();
        }
        // Return null if the data name is not found
        return null;
    }
}
