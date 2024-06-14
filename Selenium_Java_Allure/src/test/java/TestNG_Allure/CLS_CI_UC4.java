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

import static Utility.ByLocator.mainLayout;
import static Utility.ByLocator.modalBody;
import static Utility.StringData.*;
import static Utility.StringData.chargeItemUrl;
import static Utility.StringLocator.*;



public class CLS_CI_UC4 extends BaseDriver {

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 1, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To activate the status of the existing charge item with reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_01() {

        // Launch website
        driver.get(billingUrlPage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(billingConfigPage)).click();
        driver.findElement(By.xpath(chargeItemPage)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("inactive")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 1) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();

        driver.findElement(By.xpath(activateBtn)).click();
        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(okbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        // Create a list to store variable values
        List<String> cStatus = new ArrayList<String>();
//
        driver.findElement(By.xpath(searchci)).sendKeys(item1);
        action.sendKeys(Keys.ENTER).perform();
        String chargeStatusValue1 = driver.findElement(By.xpath(searchCItemStatusList)).getText();
        // Add variable values to the list
        cStatus.add(chargeStatusValue1);

        // Take a screenshot
        Screenshot();

        int activeItemStatus = 0;
        for (String status : cStatus) {
            if (status.equals("Active")) {
                activeItemStatus++;
            }
        }

        Assert.assertEquals(activeItemStatus, cStatus.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 2, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To deactivate the status of the existing charge item with reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_02() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("active")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 1) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();

        driver.findElement(By.xpath(deactivateBtn)).click();
        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(okbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        // Create a list to store variable values
        List<String> cStatus = new ArrayList<String>();
//
        driver.findElement(By.xpath(searchci)).sendKeys(item1);
        action.sendKeys(Keys.ENTER).perform();
        String chargeStatusValue1 = driver.findElement(By.xpath(searchCItemStatusList)).getText();
        // Add variable values to the list
        cStatus.add(chargeStatusValue1);

        // Take a screenshot
        Screenshot();

        int activeItemStatus = 0;
        for (String status : cStatus) {
            if (status.equals("Inactive")) {
                activeItemStatus++;
            }
        }

        Assert.assertEquals(activeItemStatus, cStatus.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 3, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To activate multiple charge items with same status and reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_03() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("inactive")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 2) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();
        String item2 = chargeItems.get(1).getText();

        driver.findElement(By.xpath(activateBtn)).click();
        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(okbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion 1

        // Create a list to store variable values
        List<String> cStatus = new ArrayList<String>();
//
        driver.findElement(By.xpath(searchci)).sendKeys(item1);
        action.sendKeys(Keys.ENTER).perform();
        String chargeStatusValue1 = driver.findElement(By.xpath(searchCItemStatusList)).getText();
        // Add variable values to the list
        cStatus.add(chargeStatusValue1);

        // Take a screenshot
        Screenshot();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

//        //    Assertion 2
        Thread.sleep(500);
        WebElement searchValue = driver.findElement(By.xpath(searchci));
        action.click(searchValue).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(item2).sendKeys(Keys.ENTER).perform();
        String chargeStatusValue2 = driver.findElement(By.xpath(searchCItemStatusList)).getText();
        // Add variable values to the list
        cStatus.add(chargeStatusValue2);

        // Take a screenshot
        Screenshot();

        int activeItemStatus = 0;
        for (String status : cStatus) {
            if (status.equals("Active")) {
                activeItemStatus++;
            }
        }

        Assert.assertEquals(activeItemStatus, cStatus.size());
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 4, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To activate multiple charge items with different status and with a reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_04() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
//        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        int inactiveCount = 0;

        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
//            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            // Check for inactive status
            if (statusCell.getText().equalsIgnoreCase("inactive") && inactiveCount == 0) {
                checkbox.click();
//                chargeItems.add(chargeitem);
                inactiveCount++;
            }

            // Check for active status
            if (statusCell.getText().equalsIgnoreCase("active") && activeCount == 0) {
                checkbox.click();
//                chargeItems.add(chargeitem);
                activeCount++;
            }

            // Break the loop
            if (activeCount == 1 && inactiveCount == 1) {
                break;
            }

        }

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(activateBtn)).click();


        // Find all rows in the table
        List<WebElement> modalRows = driver.findElements(By.xpath(modalItemRow));
        List<String> modalChargeItems = new ArrayList<String>();

        int modalActiveCount = 0;
        for (WebElement modalRow : modalRows) {
            // Find the status column cell
            WebElement modalStatusCell = modalRow.findElement(By.xpath(modalSearchCItemStatusList));
            String modalChargeItem = modalRow.findElement(By.xpath(modalSearchCItemNameList)).getText();

            if (modalStatusCell.getText().equalsIgnoreCase("inactive")) {
                modalChargeItems.add(modalChargeItem);
                modalActiveCount++;

            }
            if (modalActiveCount == modalRows.size()) {
                break;
            }

        }

        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(okbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));


        //    Assertion

        // Create a list to store variable values
        List<String> cStatus = new ArrayList<String>();

        driver.findElement(By.xpath(searchci)).sendKeys(modalChargeItems.get(0));
        action.sendKeys(Keys.ENTER).perform();
        String chargeStatusValue1 = driver.findElement(By.xpath(searchCItemStatusList)).getText();
        // Add variable values to the list
        cStatus.add(chargeStatusValue1);

        // Take a screenshot
        Screenshot();

        int activeItemStatus = 0;
        for (String status : cStatus) {
            if (status.equals("Active")) {
                activeItemStatus++;
            }
        }

        Assert.assertEquals(activeItemStatus, cStatus.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 5, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To deactivate multiple charge items with same status and reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_05() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int inactiveCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("active")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                inactiveCount++;

                if (inactiveCount == 2) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();
        String item2 = chargeItems.get(1).getText();

        driver.findElement(By.xpath(deactivateBtn)).click();
        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(okbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion 1

        // Create a list to store variable values
        List<String> cStatus = new ArrayList<String>();
//
        driver.findElement(By.xpath(searchci)).sendKeys(item1);
        action.sendKeys(Keys.ENTER).perform();
        String chargeStatusValue1 = driver.findElement(By.xpath(searchCItemStatusList)).getText();
        // Add variable values to the list
        cStatus.add(chargeStatusValue1);

        // Take a screenshot
        Screenshot();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

//        //    Assertion 2
        Thread.sleep(500);
        WebElement searchValue = driver.findElement(By.xpath(searchci));
        action.click(searchValue).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(item2).sendKeys(Keys.ENTER).perform();
        String chargeStatusValue2 = driver.findElement(By.xpath(searchCItemStatusList)).getText();
        // Add variable values to the list
        cStatus.add(chargeStatusValue2);

        // Take a screenshot
        Screenshot();

        int inactiveItemStatus = 0;
        for (String status : cStatus) {
            if (status.equals("Inactive")) {
                inactiveItemStatus++;
            }
        }

        Assert.assertEquals(inactiveItemStatus, cStatus.size());
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 6, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To deactivate multiple charge items with different status and with a reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_06() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));

        int activeCount = 0;
        int inactiveCount = 0;

        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));

            // Check for inactive status
            if (statusCell.getText().equalsIgnoreCase("inactive") && inactiveCount == 0) {
                checkbox.click();
                inactiveCount++;
            }

            // Check for active status
            if (statusCell.getText().equalsIgnoreCase("active") && activeCount == 0) {
                checkbox.click();
                activeCount++;
            }

            // Break the loop
            if (activeCount == 1 && inactiveCount == 1) {
                break;
            }

        }

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(deactivateBtn)).click();


        // Find all rows in the table
        List<WebElement> modalRows = driver.findElements(By.xpath(modalItemRow));
        List<String> modalChargeItems = new ArrayList<String>();

        int modalActiveCount = 0;
        for (WebElement modalRow : modalRows) {
            // Find the status column cell
            WebElement modalStatusCell = modalRow.findElement(By.xpath(modalSearchCItemStatusList));
            String modalChargeItem = modalRow.findElement(By.xpath(modalSearchCItemNameList)).getText();

            if (modalStatusCell.getText().equalsIgnoreCase("active")) {
                modalChargeItems.add(modalChargeItem);
                modalActiveCount++;

            }
            if (modalActiveCount == modalRows.size()) {
                break;
            }

        }

        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(okbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(searchci)).sendKeys(modalChargeItems.get(0));
        action.sendKeys(Keys.ENTER).perform();

        //    Assertion

        // Find all rows in the table
        List<WebElement> searchRows = driver.findElements(By.xpath(itemRow));
        List<String> cStatus = new ArrayList<String>();


        int searchInactiveCount = 0;
        for (WebElement searchRow : searchRows) {
            // Find the status column cell
            String searchStatusCell = searchRow.findElement(By.xpath(searchCItemStatusList)).getText();
            String searchChargeitem = searchRow.findElement(By.xpath(searchCItemNameList)).getText();

            if (searchChargeitem.equals(modalChargeItems.get(0)) && searchStatusCell.equalsIgnoreCase("inactive")) {
                cStatus.add(searchStatusCell);
                searchInactiveCount++;

                if (searchInactiveCount == 1) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        Assert.assertEquals(searchInactiveCount, modalRows.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 7, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel the activation of a charge item with unmodified reason field\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_07() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("inactive")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 1) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();

        driver.findElement(By.xpath(activateBtn)).click();

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(cancelBtn)).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);

        // Take a screenshot
        Screenshot();
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 8, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel the deactivation of a charge item with unmodified reason field\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_08() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("active")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 1) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();

        driver.findElement(By.xpath(deactivateBtn)).click();

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(cancelBtn)).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);

        // Take a screenshot
        Screenshot();
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 9, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel the activation of multiple charge items with unmodified reason field\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_09() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("inactive")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 2) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();
        String item2 = chargeItems.get(1).getText();

        driver.findElement(By.xpath(activateBtn)).click();

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(cancelBtn)).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);

        // Take a screenshot
        Screenshot();
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 10, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel the deactivation of multiple charge items with unmodified reason field\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_10() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("active")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 2) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();
        String item2 = chargeItems.get(1).getText();

        driver.findElement(By.xpath(deactivateBtn)).click();

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(cancelBtn)).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);

        // Take a screenshot
        Screenshot();
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 11, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To validate cancellation message of activation of a  item with reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_11_1() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("inactive")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 1) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();

        driver.findElement(By.xpath(activateBtn)).click();
        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(cancelBtn)).click();

        //    Assertion

        String confirm_message = driver.findElement(By.xpath(modalConfirmContent)).getText();
        String expected_message = expectedErrorValue6;

        // Normalize the actual and expected text by removing extra spaces and newlines
        String normalizedModalText = confirm_message.replaceAll("\\s+", " ").replaceAll("\\r?\\n", " ").trim();

//        Assert.assertEquals(confirm_message, expected_message);
        Assert.assertEquals(normalizedModalText, expected_message, "Modal content does not match the expected value.");

        // Take a screenshot
        Screenshot();
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 12, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel the activation of a charge item with reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_11_2() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("inactive")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 1) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();

        driver.findElement(By.xpath(activateBtn)).click();
        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(cancelBtn)).click();

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(modalOkBtn)).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);

        // Take a screenshot
        Screenshot();
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 13, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To validate cancellation message of deactivation of a charge item with reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_12_1() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("active")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 1) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();

        driver.findElement(By.xpath(deactivateBtn)).click();
        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(cancelBtn)).click();

        //    Assertion

        String confirm_message = driver.findElement(By.xpath(modalConfirmContent)).getText();
        String expected_message = expectedErrorValue6;

        // Normalize the actual and expected text by removing extra spaces and newlines
        String normalizedModalText = confirm_message.replaceAll("\\s+", " ").replaceAll("\\r?\\n", " ").trim();

//        Assert.assertEquals(confirm_message, expected_message);
        Assert.assertEquals(normalizedModalText, expected_message, "Modal content does not match the expected value.");

        // Take a screenshot
        Screenshot();
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 14, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel the deactivation of a charge item with reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_12_2() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("active")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 1) {
                    break;
                }
            }

        }

        // Find the elements to highlight
        WebElement mainPage = find(mainLayout);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, mainPage);

        driver.findElement(By.xpath(deactivateBtn)).click();
        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);

        driver.findElement(By.xpath(cancelBtn)).click();

        // Find the elements to highlight
        WebElement modalContainer = find(modalBody);

        // Highlight the elements
        highlightElement(driver, modalContainer);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, modalContainer);

//        driver.findElement(By.xpath(modalOkBtn)).click();

        //    Assertion

        List<WebElement> modal = finds(modalBody);

        boolean visibilityOfModal = true;
        if (modal.isEmpty()) {
            visibilityOfModal = false;
            Assert.assertFalse(visibilityOfModal);
        }

        else {
            Assert.assertFalse(visibilityOfModal, "You should be redirected back to the module page");
        }

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, mainPage);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 15, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To validate cancellation message of activation of multiple charge item with reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_13_1() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("inactive")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 2) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();
        String item2 = chargeItems.get(1).getText();

        driver.findElement(By.xpath(activateBtn)).click();
        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(cancelBtn)).click();


        //    Assertion

        String confirm_message = driver.findElement(By.xpath(modalConfirmContent)).getText();
        String expected_message = expectedErrorValue6;

        // Normalize the actual and expected text by removing extra spaces and newlines
        String normalizedModalText = confirm_message.replaceAll("\\s+", " ").replaceAll("\\r?\\n", " ").trim();

//        Assert.assertEquals(confirm_message, expected_message);
        Assert.assertEquals(normalizedModalText, expected_message, "Modal content does not match the expected value.");

        // Take a screenshot
        Screenshot();

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 16, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel the activation of multiple charge items with reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_13_2() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("inactive")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 2) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();
        String item2 = chargeItems.get(1).getText();

        driver.findElement(By.xpath(activateBtn)).click();
        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(cancelBtn)).click();

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(modalOkBtn)).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);

        // Take a screenshot
        Screenshot();
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 17, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To validate cancellation message of deactivation of multiple charge item with reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_14_1() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("active")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 2) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();
        String item2 = chargeItems.get(1).getText();

        driver.findElement(By.xpath(deactivateBtn)).click();
        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(cancelBtn)).click();


        //    Assertion

        String confirm_message = driver.findElement(By.xpath(modalConfirmContent)).getText();
        String expected_message = expectedErrorValue6;

        // Normalize the actual and expected text by removing extra spaces and newlines
        String normalizedModalText = confirm_message.replaceAll("\\s+", " ").replaceAll("\\r?\\n", " ").trim();

//        Assert.assertEquals(confirm_message, expected_message);
        Assert.assertEquals(normalizedModalText, expected_message, "Modal content does not match the expected value.");

        // Take a screenshot
        Screenshot();

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 18, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel the deactivation of multiple charge items with reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_14_2() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("active")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 2) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();
        String item2 = chargeItems.get(1).getText();

        driver.findElement(By.xpath(deactivateBtn)).click();
        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(cancelBtn)).click();

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(modalOkBtn)).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);

        // Take a screenshot
        Screenshot();
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 19, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To activate the status of the existing charge item without reason \n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_15() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("inactive")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 1) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();

        driver.findElement(By.xpath(activateBtn)).click();

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(okbtn)).click();

        //    Assertion

        String confirm_message = driver.findElement(By.xpath(modalReasonErrorMessage1)).getText();
        String expected_message = modalMandatoryErrorValue1;

//        Assert.assertEquals(confirm_message, expected_message);
        Assert.assertEquals(confirm_message, expected_message, "Modal error message does not match the expected value.");

        // Take a screenshot
        Screenshot();

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 20, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To deactivate the status of the existing charge item without reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_16() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("active")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 1) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();

        driver.findElement(By.xpath(deactivateBtn)).click();

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(okbtn)).click();

        //    Assertion

        String confirm_message = driver.findElement(By.xpath(modalReasonErrorMessage1)).getText();
        String expected_message = modalMandatoryErrorValue2;

//        Assert.assertEquals(confirm_message, expected_message);
        Assert.assertEquals(confirm_message, expected_message, "Modal error message does not match the expected value.");

        // Take a screenshot
        Screenshot();

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 21, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To activate multiple charge items with same status and without reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_17() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("inactive")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 2) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();


        driver.findElement(By.xpath(activateBtn)).click();

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(okbtn)).click();

        //    Assertion

        String confirm_message = driver.findElement(By.xpath(modalReasonErrorMessage1)).getText();
        String expected_message = modalMandatoryErrorValue1;

        Assert.assertEquals(confirm_message, expected_message, "Modal error message does not match the expected value.");

        // Take a screenshot
        Screenshot();

    }


    @Test(groups = {"smokeTest", "regressionTest"}, priority = 22, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To deactivate multiple charge items with same status and without reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_18() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("active")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 2) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();


        driver.findElement(By.xpath(deactivateBtn)).click();

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(okbtn)).click();

        //    Assertion

        String confirm_message = driver.findElement(By.xpath(modalReasonErrorMessage1)).getText();
        String expected_message = modalMandatoryErrorValue2;

        Assert.assertEquals(confirm_message, expected_message, "Modal error message does not match the expected value.");

        // Take a screenshot
        Screenshot();

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 23, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To activate multiple charge items with different status and without a reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_19() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
//        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        int inactiveCount = 0;

        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
//            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            // Check for inactive status
            if (statusCell.getText().equalsIgnoreCase("inactive") && inactiveCount == 0) {
                checkbox.click();
//                chargeItems.add(chargeitem);
                inactiveCount++;
            }

            // Check for active status
            if (statusCell.getText().equalsIgnoreCase("active") && activeCount == 0) {
                checkbox.click();
//                chargeItems.add(chargeitem);
                activeCount++;
            }

            // Break the loop
            if (activeCount == 1 && inactiveCount == 1) {
                break;
            }

        }

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(activateBtn)).click();


        // Find all rows in the table
        List<WebElement> modalRows = driver.findElements(By.xpath(modalItemRow));
        List<String> modalChargeItems = new ArrayList<String>();

        int modalActiveCount = 0;
        for (WebElement modalRow : modalRows) {
            // Find the status column cell
            WebElement modalStatusCell = modalRow.findElement(By.xpath(modalSearchCItemStatusList));
            String modalChargeItem = modalRow.findElement(By.xpath(modalSearchCItemNameList)).getText();

            if (modalStatusCell.getText().equalsIgnoreCase("inactive")) {
                modalChargeItems.add(modalChargeItem);
                modalActiveCount++;

            }
            if (modalActiveCount == modalRows.size()) {
                break;
            }

        }


        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(okbtn)).click();

        //    Assertion

        String confirm_message = driver.findElement(By.xpath(modalReasonErrorMessage1)).getText();
        String expected_message = modalMandatoryErrorValue1;

        Assert.assertEquals(confirm_message, expected_message, "Modal error message does not match the expected value.");

        // Take a screenshot
        Screenshot();

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 24, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To deactivate multiple charge items with different status and without a reason\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_20() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
//        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        int inactiveCount = 0;

        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
//            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            // Check for inactive status
            if (statusCell.getText().equalsIgnoreCase("inactive") && inactiveCount == 0) {
                checkbox.click();
//                chargeItems.add(chargeitem);
                inactiveCount++;
            }

            // Check for active status
            if (statusCell.getText().equalsIgnoreCase("active") && activeCount == 0) {
                checkbox.click();
//                chargeItems.add(chargeitem);
                activeCount++;
            }

            // Break the loop
            if (activeCount == 1 && inactiveCount == 1) {
                break;
            }

        }

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(deactivateBtn)).click();


        // Find all rows in the table
        List<WebElement> modalRows = driver.findElements(By.xpath(modalItemRow));
        List<String> modalChargeItems = new ArrayList<String>();

        int modalActiveCount = 0;
        for (WebElement modalRow : modalRows) {
            // Find the status column cell
            WebElement modalStatusCell = modalRow.findElement(By.xpath(modalSearchCItemStatusList));
            String modalChargeItem = modalRow.findElement(By.xpath(modalSearchCItemNameList)).getText();

            if (modalStatusCell.getText().equalsIgnoreCase("active")) {
                modalChargeItems.add(modalChargeItem);
                modalActiveCount++;

            }
            if (modalActiveCount == modalRows.size()) {
                break;
            }

        }


        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(okbtn)).click();

        //    Assertion

        String confirm_message = driver.findElement(By.xpath(modalReasonErrorMessage1)).getText();
        String expected_message = modalMandatoryErrorValue2;

        Assert.assertEquals(confirm_message, expected_message, "Modal error message does not match the expected value.");

        // Take a screenshot
        Screenshot();

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 25, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To check the toast message after successful charge item activation")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_21() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("inactive")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 1) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();

        driver.findElement(By.xpath(activateBtn)).click();
        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(okbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        String toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(notificationMessage1))).getText();
        String expectedMessage = "Charge items \"" + item1 + "\" activated.";
        Assert.assertEquals(toastMessage, expectedMessage);

        // Take a screenshot
        Screenshot();

    }


    @Test(groups = {"smokeTest", "regressionTest"}, priority = 26, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To check the toast message after successful charge item deactivation")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_22() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("active")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 1) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        String item1 = chargeItems.get(0).getText();

        driver.findElement(By.xpath(deactivateBtn)).click();
        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(okbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        String toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(notificationMessage1))).getText();
        String expectedMessage = "Charge items \"" + item1 + "\" deactivated.";
        Assert.assertEquals(toastMessage, expectedMessage);

        // Take a screenshot
        Screenshot();

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 27, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To check the toast message after successful charge items activation")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_23() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("inactive")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 2) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(activateBtn)).click();
        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(okbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        String toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(notificationMessage1))).getText();
        String expectedMessage = toastMessageMultiple1;
        Assert.assertEquals(toastMessage, expectedMessage);

        // Take a screenshot
        Screenshot();

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 28, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To check the toast message after successful charge items deactivation")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_04_24() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath(itemRow));
        List<WebElement> chargeItems = new ArrayList<WebElement>();

        int activeCount = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement statusCell = row.findElement(By.xpath(searchCItemStatusList));
            WebElement checkbox = row.findElement(By.xpath(perCheckbox));
            WebElement chargeitem = row.findElement(By.xpath(searchCItemNameList));

            if (statusCell.getText().equalsIgnoreCase("active")) {
                checkbox.click();
                chargeItems.add(chargeitem);
                activeCount++;

                if (activeCount == 2) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(deactivateBtn)).click();
        driver.findElement(By.id(reasonid)).sendKeys(reasonvalue1);

        // Take a screenshot
        Screenshot();

        driver.findElement(By.xpath(okbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        String toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(notificationMessage1))).getText();
        String expectedMessage = toastMessageMultiple2;
        Assert.assertEquals(toastMessage, expectedMessage);

        // Take a screenshot
        Screenshot();

    }
}