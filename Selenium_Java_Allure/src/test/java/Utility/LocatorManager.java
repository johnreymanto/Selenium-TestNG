package Utility;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class LocatorManager {
    private static final String EXCEL_FILE_PATH = "D:\\IntelliJ\\Selenium_Java_Allure\\src\\test\\resources\\locators.xlsx";


    public static LocatorInfo getLocatorInfo(String locatorName) {
        try {
            FileInputStream fs = new FileInputStream(EXCEL_FILE_PATH);
            Workbook workbook = new XSSFWorkbook(fs);
            Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet

            for (Row row : sheet) {
                Cell nameCell = row.getCell(0);
                Cell typeCell = row.getCell(1);
                Cell valueCell = row.getCell(2);

                if (nameCell.getStringCellValue().equals(locatorName)) {
                    String locatorType = typeCell.getStringCellValue();
                    String locatorValue = valueCell.getStringCellValue();
                    return new LocatorInfo(locatorType, locatorValue);
                }
            }

            workbook.close();
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Handle appropriately if locator is not found
    }

    public static class LocatorInfo {
        private final String locatorType;
        private final String locatorValue;

        public LocatorInfo(String locatorType, String locatorValue) {
            this.locatorType = locatorType;
            this.locatorValue = locatorValue;
        }

        public String getLocatorType() {
            return locatorType;
        }

        public String getLocatorValue() {
            return locatorValue;
        }
    }
}