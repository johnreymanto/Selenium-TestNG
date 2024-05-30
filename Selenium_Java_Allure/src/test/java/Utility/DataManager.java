package Utility;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class DataManager {
    private static final String EXCEL_FILE_PATH = "D:\\IntelliJ\\Selenium_Java_Allure\\src\\test\\resources\\data.xlsx";

    public static String getDataValue(String dataName) {
        try {
            FileInputStream fs = new FileInputStream(EXCEL_FILE_PATH);
            Workbook workbook = new XSSFWorkbook(fs);
            Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet

            for (Row row : sheet) {
                Cell nameCell = row.getCell(0);
                Cell valueCell = row.getCell(1);

                if (nameCell.getStringCellValue().equals(dataName)) {
                    return valueCell.getStringCellValue();
                }
            }

            workbook.close();
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // Handle appropriately if locator is not found
    }

}