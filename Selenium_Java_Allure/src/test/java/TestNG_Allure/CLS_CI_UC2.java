package TestNG_Allure;
import Utility.BaseDriver;
import Utility.CustomRetryAnalyzer;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static Utility.ByLocator.*;
import static Utility.ByLocator.billConfigPage;
import static Utility.ByLocator.cancelBtn;
import static Utility.ByLocator.chargeItemPage;
import static Utility.ByLocator.itemRow;
import static Utility.ByLocator.searchCItemNameList;
import static Utility.StringData.*;
import static Utility.StringData.ciUrlPage1;
import static Utility.StringData.ciUrlPage1_10;
import static Utility.StringData.ciUrlPage2_10;
import static Utility.StringData.ciUrlPage7_10;
import static Utility.StringLocator.*;


public class CLS_CI_UC2 extends BaseDriver {

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 1, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To view existing Charge items list details\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_01() {

        // Launch website
        openUrl(billingUrlPage);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(billConfigPage).click();
        find(chargeItemPage).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Find the elements to highlight
        WebElement mainPage = find(mainLayout);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,mainPage);

//    Assertion

        List<WebElement> searchRows = finds(itemRow);
        List<WebElement> chargeItemNames = new ArrayList<WebElement>();

        int counter = 0;
        for (WebElement row : searchRows) {
            WebElement chargeName = row.findElement(searchCItemNameList);
            chargeItemNames.add(chargeName);
            counter++;

        }
        WebElement item = find(chargeTotalItem);

        // Highlight the elements
        highlightElement(driver, item);
        highlightElements(driver, chargeItemNames);

        // Take a screenshot
        ScreenshotWithUrl();

        // Remove highlight
        removeHighlights(driver, chargeItemNames);
        removeHighlight(driver,item);

        Assert.assertEquals(counter, searchRows.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 2, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To filter all \"Active\" charge items\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_02() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(funnelBtn).click();
        waitUntilElementToBeClickable(colExpStatusBtn).click();
        find(statusFilterActive).click();

        // Find the elements to highlight
        WebElement selectActive = find(filterActive);

        // Highlight the elements
        highlightElement(driver, selectActive);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,selectActive);

        waitUntilElementToBeClickable(filterApplyBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

//    Assertion

        int rowCount = finds(itemRow).size();
        List<WebElement> cStatus = finds(chargeItemColStatusValue);

        int activeItemStatus = 0;
        for (WebElement status : cStatus) {
            if (status.getText().equals("Active")) {
                activeItemStatus++;

            }

        }

        // Highlight the elements
        highlightElements(driver, cStatus);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver,cStatus);

        Assert.assertEquals(activeItemStatus, rowCount);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 3, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To filter all \"Inactive\" charge items\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_03() {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(funnelBtn).click();
        waitUntilElementToBeClickable(colExpStatusBtn).click();
        find(statusFilterInactive).click();


        // Find the elements to highlight
        WebElement selectInactive = find(statusFilterInactive);

        // Highlight the elements
        highlightElement(driver, selectInactive);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,selectInactive);

        waitUntilElementToBeClickable(filterApplyBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);


//    Assertion

        int rowCount = finds(itemRow).size();
        List<WebElement> cStatus = finds(chargeItemColStatusValue);

        int activeItemStatus = 0;
        for (WebElement status : cStatus) {
            if (status.getText().equals("Inactive")) {
                activeItemStatus++;
            }

        }

        // Highlight the elements
        highlightElements(driver, cStatus);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver,cStatus);

        Assert.assertEquals(activeItemStatus, rowCount);

    }

    @Test(groups = {"regressionTest"}, priority = 4, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To Tick and Untick Active status checkbox in filter drawer\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_04() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(funnelBtn).click();
        waitUntilElementToBeClickable(colExpStatusBtn).click();
        find(statusFilterActive).click();

        // Find the elements to highlight
        WebElement activeFilter = find(filterActive);

        // Highlight the elements
        highlightElement(driver, activeFilter);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,activeFilter);

        Thread.sleep(500);
        find(statusFilterActive).click();


        // Highlight the elements
        highlightElement(driver, activeFilter);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,activeFilter);

//    Assertion

        try {
//    Try to find the element you are interested in
            find(selectedTag);
//    If element found, perform your actions or validations
            boolean noSuchElem = false;
            Assert.assertTrue(noSuchElem);

        } catch (NoSuchElementException e) {
//    If the element is not found, it indicates a validation failure
            boolean noSuchElem = true;

            Assert.assertTrue(noSuchElem);
        }

    }

    @Test(groups = {"regressionTest"}, priority = 5, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To Tick and Untick Inactive status checkbox in filter drawer\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_05() throws InterruptedException {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(funnelBtn).click();
        waitUntilElementToBeClickable(colExpStatusBtn).click();
        find(statusFilterInactive).click();

        // Find the elements to highlight
        WebElement inactiveFilter = find(filterInactive);

        // Highlight the elements
        highlightElement(driver, inactiveFilter);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,inactiveFilter);

        Thread.sleep(500);
        find(statusFilterInactive).click();


        // Highlight the elements
        highlightElement(driver, inactiveFilter);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,inactiveFilter);


//    Assertion

        try {
//    Try to find the element you are interested in
            find(selectedTag);
//    If element found, perform your actions or validations
            boolean noSuchElem = false;
            Assert.assertTrue(noSuchElem);

        } catch (NoSuchElementException e) {
//    If the element is not found, it indicates a validation failure
            boolean noSuchElem = true;

            Assert.assertTrue(noSuchElem);
        }
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 6, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To filter both \"Active\" and \"Inactive\" charge items\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_06() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(funnelBtn).click();
        waitUntilElementToBeClickable(colExpStatusBtn).click();
        find(statusFilterActive).click();
        find(statusFilterInactive).click();

        // Find the elements to highlight
        List<WebElement> elements = List.of(
                find(filterActive),
                find(filterInactive)
        );

        // Highlight the elements
        highlightElements(driver, elements);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver,elements);

        waitUntilElementToBeClickable(filterApplyBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

//    Assertion

        int rowCount = finds(itemRow).size();
        List<WebElement> cStatus = finds(chargeItemColStatusValue);

        int ItemStatus = 0;
        for (WebElement status : cStatus) {
            if (status.getText().equals("Active") || (status.getText().equals("Inactive"))) {
                ItemStatus++;

            }

        }

        // Highlight the elements
        highlightElements(driver, cStatus);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver,cStatus);

        Assert.assertEquals(ItemStatus, rowCount);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 7, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To clear all active filters for charge items\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_07() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(funnelBtn).click();
        waitUntilElementToBeClickable(colExpStatusBtn).click();
        find(statusFilterActive).click();
        find(statusFilterInactive).click();

        // Find the elements to highlight
        List<WebElement> elements = List.of(
                find(filterActive),
                find(filterInactive)
        );

        // Highlight the elements
        highlightElements(driver, elements);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver,elements);

        waitTime(500);

        waitUntilVisibilityOfElementLocated(statusFilterClearBtn).click();

        // Highlight the elements
        highlightElements(driver, elements);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver,elements);

//    Assertion

        try {
//    Try to find the element you are interested in
            find(selectedTag);
//    If element found, perform your actions or validations
            boolean noSuchElem = false;
            Assert.assertTrue(noSuchElem);

        } catch (NoSuchElementException e) {
//    If the element is not found, it indicates a validation failure
            boolean noSuchElem = true;

            Assert.assertTrue(noSuchElem);
        }

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 8, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To disregard selected filter/s on charge items\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_08() throws InterruptedException {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(funnelBtn).click();
        waitUntilElementToBeClickable(colExpStatusBtn).click();
        find(statusFilterActive).click();
        find(statusFilterInactive).click();

        // Find the elements to highlight
        List<WebElement> elements = List.of(
                find(filterActive),
                find(filterInactive)
        );

        // Highlight the elements
        highlightElements(driver, elements);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver,elements);

        waitTime(500);

        waitUntilPresenceOfElementLocated(cancelBtn).click();

        waitTime(500);

//    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;

        // Find the elements to highlight
        WebElement mainPage = find(mainLayout);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,mainPage);

        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 9, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To search existing charge item using 3 minimum characters\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_09() throws InterruptedException {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        driver.findElement(searchCI).sendKeys(mincharvalue1);
        action.sendKeys(Keys.ENTER).perform();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

//    Assertion
        int items = finds(searchCItem).size();
        if (items > 0) {
            boolean row = true;
            Assert.assertTrue(row);
        } else {
            boolean row = false;
            Assert.assertTrue(row);
        }

        WebElement tblLayout = find(tableLayout);

        // Highlight the elements
        highlightElement(driver, tblLayout);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,tblLayout);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 10, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To search nonexistent charge item using 3 minimum characters\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_10() throws InterruptedException {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(searchCI).sendKeys(mincharvalue2);
        action.sendKeys(Keys.ENTER).perform();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

//    Assertion

        WebElement error_msg = find(noItemError);
        String expectedError = expectederrorvalue4;

        // Find the elements to highlight
        List<WebElement> elements = List.of(
                error_msg,
                find(searchBar)
        );

        // Highlight the elements
        highlightElements(driver, elements);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver,elements);


        Assert.assertEquals(error_msg.getText(), expectedError);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 11, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To search using 1 character\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_11_1() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(searchCI).sendKeys(belowmincharvalue1);
        action.sendKeys(Keys.ENTER).perform();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);


//    Assertion

        WebElement error_msg = find(min3CharError);
        String expectedError = expectedErrorValue5;

        // Find the elements to highlight
        List<WebElement> elements = List.of(
                error_msg,
                find(searchBar)
        );

        // Highlight the elements
        highlightElements(driver, elements);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver,elements);

        Assert.assertEquals(error_msg.getText(), expectedError);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 12, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To search using 2 characters\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_11_2() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(searchCI).sendKeys(belowmincharvalue2);
        action.sendKeys(Keys.ENTER).perform();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

//    Assertion

        WebElement error_msg = find(min3CharError);
        String expectedError = expectedErrorValue5;

        // Find the elements to highlight
        List<WebElement> elements = List.of(
                error_msg,
                find(searchBar)
        );

        // Highlight the elements
        highlightElements(driver, elements);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver,elements);

        Assert.assertEquals(error_msg.getText(), expectedError);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 13, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify special characters accepted in search box\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_12() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(searchCI).sendKeys(mincharspecvalue1);
        action.sendKeys(Keys.ENTER).perform();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

//    Assertion
        int rows = finds(searchCItem).size();
        if (rows > 0) {
            boolean row = true;
            Assert.assertTrue(row);
        } else {
            boolean row = false;
            Assert.assertTrue(row);
        }

        WebElement tblLayout = find(tableLayout);

        // Highlight the elements
        highlightElement(driver, tblLayout);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,tblLayout);

    }

    @Test(groups = {"regressionTest"}, priority = 14, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To search without any value\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_13() throws InterruptedException {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(searchCI).sendKeys(" ");
        action.sendKeys(Keys.ENTER).perform();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

//    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = ciUrlPage1;

        WebElement tblLayout = find(tableLayout);

        // Highlight the elements
        highlightElement(driver, tblLayout);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,tblLayout);

        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 15, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify the total number of items in the list\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_14() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(showRowsDropdown).click();
        find(showRows100).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Find the elements to highlight
        WebElement mainPage = find(mainLayout);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot with Url
        ScreenshotWithUrl();

        // Remove highlight
        removeHighlight(driver,mainPage);

//    Assertion

        int rowCount = finds(itemRow).size();

        WebElement item = find(chargeTotalItem);
        String[] to_item = item.getText().split(" ");
        int intValue = Integer.parseInt(to_item[1]);

        Assert.assertEquals(intValue, rowCount);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 16, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify that charge items list only displays 20 number of records on a single page.\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_15_1() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(showRowsDropdown).click();
        find(showRows20).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Find the elements to highlight
        WebElement mainPage = find(mainLayout);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot with Url
        ScreenshotWithUrl();

        // Remove highlight
        removeHighlight(driver,mainPage);


        //    Assertion
        int rows = finds(searchCItem).size();
        if (rows > 10 && rows <= 20) {
            boolean row = true;
            Assert.assertTrue(row);
        } else {
            boolean row = false;
            Assert.assertTrue(row);
        }

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 17, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify that charge items list only displays 50 number of records on a single page.\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_15_2() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(showRowsDropdown).click();
        find(showRows50).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Find the elements to highlight
        WebElement mainPage = find(mainLayout);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot with Url
        ScreenshotWithUrl();

        // Remove highlight
        removeHighlight(driver,mainPage);

        //    Assertion
        int rows = finds(searchCItem).size();
        if (rows > 20 && rows <= 50) {
            boolean row = true;
            Assert.assertTrue(row);
        } else {
            boolean row = false;
            Assert.assertTrue(row);
        }

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 18, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify that charge items list only displays 100 number of records on a single page.\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_15_3() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(showRowsDropdown).click();
        find(showRows100).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Find the elements to highlight
        WebElement mainPage = find(mainLayout);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot with Url
        ScreenshotWithUrl();

        // Remove highlight
        removeHighlight(driver,mainPage);

        //    Assertion
        int rows = finds(searchCItem).size();
        if (rows > 50 && rows <= 100) {
            boolean row = true;
            Assert.assertTrue(row);
        } else {
            boolean row = false;
            Assert.assertTrue(row);
        }

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 19, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify that charge items list only displays 10 number of records on a single page.\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_15_4() throws InterruptedException {

        // Launch website
        openUrl(ciUrlPage1_20);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        WebElement showListRow = find(showRowsDropdown);
        jse.executeScript("arguments[0].scrollIntoView(true);", showListRow);
        find(showRowsDropdown).click();
        find(showRows10).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Find the elements to highlight
        WebElement mainPage = find(mainLayout);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot with Url
        ScreenshotWithUrl();

        // Remove highlight
        removeHighlight(driver,mainPage);

        //    Assertion
        int rows = driver.findElements(By.xpath(searchcitem)).size();
        if (rows > 1 && rows <= 10) {
            boolean row = true;
            Assert.assertTrue(row);
        } else {
            boolean row = false;
            Assert.assertTrue(row);
        }

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 20, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To navigate to next page of the charge items list\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_16() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement next_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nextpagebtn)));
        next_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = ciUrlPage2_10;
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 21, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To navigate to previous page of charge items list\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_17() throws InterruptedException {


        // Launch website
        driver.get(ciUrlPage2_10);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement next_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prevpagebtn)));
        next_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = ciUrlPage1_10;
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 22, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To navigate to Go to Last page of the charge items list\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_18() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement next_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lastpagebtn)));
        next_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = ciUrlPage7_10;
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 23, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To navigate to Go to First page of the charge items list\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_19() throws InterruptedException {


        // Launch website
        driver.get(ciUrlPage7_10);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement next_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstpagebtn)));
        next_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = ciUrlPage1_10;
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 24, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the charge item list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_20_1() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(cisortasc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem));
        String expected_value = cisortascvalue; // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 25, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the charge item list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_20_2() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(cisortdesc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));


        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem));
        String expected_value = cisortdescvalue;  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 26, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the charge item list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_20_3() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(cisortdefault)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));


        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem));
        String expected_value = cisortdefaultvalue;  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 27, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the charge type list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_21_1() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(ctsortasc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem1));
        String expected_value = ctsortascvalue;  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 28, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the charge type list in descending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_21_2() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(ctsortdesc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem1));
        String expected_value = ctsortdescvalue;  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 29, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the charge type list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_21_3() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(ctsortdefault)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem1));
        String expected_value = ctSortDefaultValue;  // First item in Default
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 30, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the Description in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_22_1() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(descriptionsortasc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem2));
        String expected_value = descriptionsortascvalue;  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 31, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the Description list in descending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_22_2() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(descriptionsortdesc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem2));
        String expected_value = descriptionsortdescvalue;  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 32, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the Description list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_22_3() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(descriptionsortdefault)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem2));
        String expected_value = descriptionsortdefaultvalue;  // First item in Default
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 33, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the Base currency list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_23_1() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(bssortasc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem3));
        String expected_value = "";  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 34, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the Base currency list in descending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_23_2() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(bssortdesc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem3));
        String expected_value = bssortdescvalue;  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 35, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the Base currency list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_23_3() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(bssortdefault)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem3));
        String expected_value = bssortdefaultvalue;  // First item in Default
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 36, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the GST applicable for foreign address list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_24_1() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(gstsortasc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem4));
        String expected_value = gstsortascavalue;  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 37, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the GST applicable for foreign address list in descending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_24_2() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(gstsortdesc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem4));
        String expected_value = gstsortdescvalue;  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 38, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the GST applicable for foreign address list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_24_3() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(gstsortdefault)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem4));
        String expected_value = gstsortdescvalue;  // First item in Default
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 39, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the GL Number list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_25_1() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(glsortasc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem5));
        String expected_value = glsortascvalue;  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 40, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the GL Number list in descending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_25_2() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(glsortdesc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem5));
        String expected_value = glsortdescvalue;  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 41, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the GL Number list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_25_3() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(glsortdefault)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem6));
        String expected_value = glsortdefaultvalue;  // First item in Default
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 42, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the Refundable list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_26_1() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(resortasc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem7));
        String expected_value = resortascvalue;  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 43, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the Refundable list in descending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_26_2() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(resortdesc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem7));
        String expected_value = resortdescvalue;  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 44, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the Refundable list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_26_3() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(resortdefault)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem7));
        String expected_value = resortdefaultvalue;  // First item in Default
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 45, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the Tag to registration list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_27_1() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(tagregsortasc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem8));
        String expected_value = tagregsortascvalue;  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 46, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the Tag to registration list in descending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_27_2() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(tagregsortdesc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem8));
        String expected_value = tagregsortdescvalue;  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 47, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the Tag to registration list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_27_3() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(tagregsortdefault)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem8));
        String expected_value = tagregsortdefaultvalue;  // First item in Default
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 48, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the Profit centre list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_28_1() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(profcentsortasc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem9));
        String expected_value = "";  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 49, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the Profit centre list in descending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_28_2() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(profcentsortdesc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem9));
        String expected_value = profcentsortdescvalue;  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 50, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the Profit centre list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_28_3() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(profcentsortdefault)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem9));
        String expected_value = "";  // First item in Default
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 51, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the Status list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_29_1() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(statussortasc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem10));
        String expected_value = statussortascvalue;  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 52, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the Status list in descending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_29_2() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(statussortdesc)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem10));
        String expected_value = statussortdescvalue;  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 53, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To sort the Status list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_29_3() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath(statussortdefault)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath(searchcitem10));
        String expected_value = statussortdefaultvalue;  // First item in Default
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 54, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To view the Charge item details\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_30() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(viewfirstchargeitem)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion
        Thread.sleep(1000);
        WebElement viewpage = driver.findElement(By.xpath(viewcititle));
        String expected_value = viewcititlevalue;
        Assert.assertEquals(viewpage.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 55, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To close View charge item drawer using close button\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_31() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(viewfirstchargeitem)).click();
        driver.findElement(By.xpath(closebtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"regressionTest"}, priority = 56, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To close a View charge item drawer using X button\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_32() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(viewfirstchargeitem)).click();
        driver.findElement(By.xpath(xbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"regressionTest"}, priority = 57, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To close a View charge item drawer using Esc button in keyboard\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_33() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(viewfirstchargeitem)).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(viewcititle));
        action.sendKeys(Keys.ESCAPE).perform();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 58, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel an unmodified filter drawer using cancel button\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_34() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(funnelbtn)).click();
        find(cancelBtn).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"regressionTest"}, priority = 59, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel an unmodified filter window using X button\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_35() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(funnelbtn)).click();
        driver.findElement(By.xpath(xbtn)).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"regressionTest"}, priority = 60, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel an unmodified filter window using Esc button in keyboard\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_36() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(funnelbtn)).click();
        Thread.sleep(200);
        action.sendKeys(Keys.ESCAPE).perform();
        Thread.sleep(500);

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 61, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To navigate to designated page using Go button\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_37() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement jumpfield = driver.findElement(By.xpath(quickjumperfield));
        action.doubleClick(jumpfield).sendKeys(quickjumperfieldvalue1).perform();
        driver.findElement(By.xpath(gobtn)).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = ciUrlPage2_10;
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"regressionTest"}, priority = 62, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify Go button accepts no value in textbox\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_38() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement jumpfield = driver.findElement(By.xpath(quickjumperfield));
        action.doubleClick(jumpfield).sendKeys(Keys.BACK_SPACE).perform();
        driver.findElement(By.xpath(gobtn)).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"regressionTest"}, priority = 63, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify Go button accepts the page number more than the page number in charge item list\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_39() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement jumpfield = driver.findElement(By.xpath(quickjumperfield));
        action.doubleClick(jumpfield).sendKeys(quickjumperfieldvalue2).perform();
        driver.findElement(By.xpath(gobtn)).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = ciUrlPage1_10;
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 64, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To navigate to designated page using Page number button\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_40() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(pagenumber2)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = ciUrlPage2_10;
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"regressionTest"}, priority = 65, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify \"Go to First page button is unclikable when the charge item list is in the first page\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_41_1() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        boolean isClickable = driver.findElement(By.xpath(disfirstpagebtn)).isEnabled();
        Assert.assertEquals(isClickable, false);

    }

    @Test(groups = {"regressionTest"}, priority = 66, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify \"Go to Previous page button is unclikable when the charge item list is in the first page\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_41_2() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        boolean isClickable = driver.findElement(By.xpath(disprevpagebtn)).isEnabled();
        Assert.assertEquals(isClickable, false);

    }

    @Test(groups = {"regressionTest"}, priority = 67, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify \"Go to Last page\" button is unclikable when the charge item list is in the last page\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_42_1() throws InterruptedException {


        // Launch website
        driver.get(ciUrlPage7_10);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        boolean isClickable = driver.findElement(By.xpath(disLastPageBtn)).isEnabled();
        Assert.assertEquals(isClickable, false);

    }

    @Test(groups = {"regressionTest"}, priority = 68, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify \"Go to Next page\" button is unclikable when the charge item list is in the last page\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_42_2() throws InterruptedException {


        // Launch website
        driver.get(ciUrlPage7_10);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        boolean isClickable = driver.findElement(By.xpath(disnextpagebtn)).isEnabled();
        Assert.assertEquals(isClickable, false);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 69, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify \"Billing configuration\" breadcrumbs location is working when in charge items page\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_43() {

        // Launch website
        driver.get(billingUrlPage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(billingConfigPage)).click();
        driver.findElement(By.xpath(chargeitempage)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(billingConfigPage)).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = billingConfigUrl;
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 70, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify \"Billing\" breadcrumbs location is working when in charge items page\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_44() {

        // Launch website
        driver.get(billingUrlPage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(billingConfigPage)).click();
        driver.findElement(By.xpath(chargeitempage)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        waitUntilElementToBeClickable(billPage).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = billingUrlPage;
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"regressionTest"}, priority = 71, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify Search box hover\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_45() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement searchBar = driver.findElement(By.xpath(searchci));
        action.moveToElement(searchBar).perform();

        //    Assertion

        String toolTip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchtooltip1))).getText();

        String expected_value = expectedtooltipvalue1;
        Assert.assertEquals(toolTip,expected_value);

    }

    @Test(groups = {"regressionTest"}, priority = 72, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify Select all check box is working\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_46() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(selectallcheckbox1)).click();

        //    Assertion

        int rowCount = finds(itemRow).size();
        WebElement item = driver.findElement(By.xpath(selecteditemcount));
        String[] to_item = item.getText().split(" ");

        // Convert the first string to_item to an integer
        int extractedNumber = Integer.parseInt(to_item[0]);
        Assert.assertEquals(extractedNumber, rowCount);

    }

}