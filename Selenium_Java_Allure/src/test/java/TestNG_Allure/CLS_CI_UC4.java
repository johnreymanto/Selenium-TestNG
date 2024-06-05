package TestNG_Allure;
import Utility.BaseDriver;
import Utility.CustomRetryAnalyzer;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static Utility.StringData.*;
import static Utility.StringLocator.*;


public class CLS_CI_UC4 extends BaseDriver {

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 1, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To activate the status of the existing charge item with reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_01() {

        // Launch website
        driver.get(billingUrlPage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(billconfigpage)).click();
        driver.findElement(By.xpath(chargeitempage)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        String firstCIValue = driver.findElement(By.xpath(searchcitem)).getText();
        driver.findElement(By.xpath(firstcicheckbox)).click();
        driver.findElement(By.xpath(activatebtn)).click();
        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);
        driver.findElement(By.xpath(okbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        driver.findElement(By.xpath(searchci)).sendKeys(firstCIValue);
        action.sendKeys(Keys.ENTER).perform();

        WebElement chargeTypeValue = driver.findElement(By.xpath(searchcitem10));
        String expected_value = activevalue;
        Assert.assertEquals(chargeTypeValue.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 2, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To deactivate the status of the existing charge item with reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_02() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        String firstCIValue = driver.findElement(By.xpath(searchcitem)).getText();
        driver.findElement(By.xpath(firstcicheckbox)).click();
        driver.findElement(By.xpath(deactivatebtn)).click();
        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);
        driver.findElement(By.xpath(okbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        driver.findElement(By.xpath(searchci)).sendKeys(firstCIValue);
        action.sendKeys(Keys.ENTER).perform();

        WebElement chargeTypeValue = driver.findElement(By.xpath(searchcitem10));
        String expected_value = inactivevalue;
        Assert.assertEquals(chargeTypeValue.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 3)
    @Description("To activate multiple charge items with same status and reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_03() throws InterruptedException {

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/gl-numbers");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(".//td[contains(@class, 'ant-table-cell')][4]"));

            if (statusCell.getText().equalsIgnoreCase("active")) {
                activeCount++;

                if (activeCount == 3) {
                    break;
                }

                WebElement checkbox = row.findElement(By.xpath(perCheckbox));
                checkbox.click();
            }
        }
//        // Locate the table rows containing the checkboxes
//        List<WebElement> rows = driver.findElements(By.xpath("//tr[contains(@class, 'ant-table-row')]"));
//        int activeCount = 0;
//
//        for (WebElement row : rows) {
//            // Extract the status value from the last column
//            WebElement statusColumn = row.findElement(By.xpath("//td[@class='ant-table-cell'][3]"));
//            String status = statusColumn.getText().trim();
//
//            // Check if the status is "active"
//            if (status.equalsIgnoreCase("active")) {
//                // Locate the checkbox element within the row
//                WebElement checkbox = row.findElement(By.xpath(CICheckbox));
//
//                // Verify checkbox selection state
//                if (!checkbox.isSelected()) {
//                    checkbox.click(); // Select the checkbox
//                    activeCount++; // Increment active checkbox count
//                }
//
//                // Stop processing if we've found 2 active checkboxes
//                if (activeCount == 2) {
//                    break;
//                }
//            }
//        }

//
//        // Iterate through each row
//        for (WebElement row : rows) {
//            // Find the status column in each row
//            WebElement statusElement = row.findElement(By.xpath(searchcitem10));
//
//            if (statusElement.getText().equalsIgnoreCase("Active")) {
//                // If status is "active", find the checkbox in the same row and tick it
//                WebElement checkbox = row.findElement(By.xpath(cicheckbox));
//                checkbox.click();
//            }
//        }

//        String firstCIValue = driver.findElement(By.xpath(firstsearchcitem)).getText();
//        String secondCIValue = driver.findElement(By.xpath(secondsearchcitem)).getText();
//        driver.findElement(By.xpath(firstcicheckbox)).click();
//        driver.findElement(By.xpath(secondcicheckbox)).click();


//        driver.findElement(By.xpath(activatebtn)).click();
//        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);
//        driver.findElement(By.xpath(okbtn)).click();
//
//        // Waiting for loader
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion 1

        // Create a list to store variable values
//        List<Object> cStatus = new ArrayList<Object>();
//
//        driver.findElement(By.xpath(searchci)).sendKeys(firstCIValue);
//        action.sendKeys(Keys.ENTER).perform();
//        String chargeStatusValue1 = driver.findElement(By.xpath(searchcitem10)).getText();
//
//        // Add variable values to the list
//        cStatus.add(chargeStatusValue1);
//
//        //    Assertion 2
//        Thread.sleep(1000);
//        WebElement searchValue = driver.findElement(By.xpath(searchci));
//        action.click(searchValue).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(secondCIValue).sendKeys(Keys.ENTER).perform();
//        String chargeStatusValue2 = driver.findElement(By.xpath(searchcitem10)).getText();
//
//        // Add variable values to the list
//        cStatus.add(chargeStatusValue2);
//
//        int activeItemStatus = 0;
//        for (Object status : cStatus) {
//            if (status.equals("Active")) {
//                activeItemStatus++;
//            }
//        }
//
//        Assert.assertEquals(activeItemStatus, cStatus.size());

    }

}