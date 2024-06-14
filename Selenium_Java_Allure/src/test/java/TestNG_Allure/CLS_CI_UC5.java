package TestNG_Allure;
import Utility.CustomRetryAnalyzer;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utility.BaseDriver;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import static Utility.ByLocator.*;
import static Utility.ByLocator.billConfigPage;
import static Utility.ByLocator.chargeItemPage;
import static Utility.ByLocator.itemRow;
import static Utility.ByLocator.notificationMessage1;
import static Utility.StringData.*;


public class CLS_CI_UC5 extends BaseDriver {

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 1, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To view activity log entries and their details\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_01() throws InterruptedException {

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

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        //    Assertion

        List<WebElement> searchRows = finds(itemRow);
        List<WebElement> transactionCodes = new ArrayList<WebElement>();

        int counter = 0;
        for (WebElement row : searchRows) {
            WebElement transactionCode = row.findElement(firstColItemList);
            transactionCodes.add(transactionCode);
            counter++;

        }
        WebElement item = find(chargeTotalItem);
        scrollIntoView(item);

        // Highlight the elements
        highlightElement(driver, item);
        highlightElements(driver, transactionCodes);

        // Take a screenshot
        ScreenshotWithUrl();

        // Remove highlight
        removeHighlights(driver, transactionCodes);
        removeHighlight(driver, item);

        Assert.assertEquals(counter, searchRows.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 2, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Transaction code search type\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_02() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
        find(activityLogTransactionCode).click();
        find(searchText).sendKeys(searchTransactionValue1);
        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        List<WebElement> transactionCodes = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);

        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement transactionCode = row.findElement(firstColItemList);
            transactionCodes.add(transactionCode);
            if ((transactionCode.getText().toLowerCase().contains(searchTransactionValue1.toLowerCase()))) {
                Counter++;
            }

        }

        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        // Highlight the elements
        highlightElements(driver, transactionCodes);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, transactionCodes);

        Assert.assertEquals(Counter, activityLogRows.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 3, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Transaction ID search type\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_03() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
        find(activityLogTransactionId).click();
        find(searchText).sendKeys(searchTransactionValue2);
        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        List<WebElement> transactionIds = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);

        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement transactionId = row.findElement(secondColItemList);
            transactionIds.add(transactionId);
            if ((transactionId.getText().contains(searchTransactionValue2))) {
                Counter++;
            }

        }

        WebElement item = find(chargeTotalItem);
        scrollIntoView(item);

//        WebElement tableName = find(activityLogTable);
//        scrollIntoView(tableName);

        // Highlight the elements
        highlightElements(driver, transactionIds);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, transactionIds);

        Assert.assertEquals(Counter, activityLogRows.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 4, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Change ID search type\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_04() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
        find(activityLogChangeId).click();
        find(searchText).sendKeys(searchTransactionValue3);
        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        List<WebElement> changeIds = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);

        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement changeId = row.findElement(thirdColItemList);
            changeIds.add(changeId);
            if ((changeId.getText().contains(searchTransactionValue3))) {
                Counter++;
            }

        }

        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        // Highlight the elements
        highlightElements(driver, changeIds);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, changeIds);

        Assert.assertEquals(Counter, activityLogRows.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 5, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Section impacted search type\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_05() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
        find(activityLogSectionImpacted).click();
        find(searchText).sendKeys(searchTransactionValue4);
        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        List<WebElement> secImpactedItems = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);

        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement secImpactedItem = row.findElement(fifthColItemList);
            secImpactedItems.add(secImpactedItem);
            if ((secImpactedItem.getText().toLowerCase().contains(searchTransactionValue4.toLowerCase()))) {
                Counter++;
            }

        }

        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        // Highlight the elements
        highlightElements(driver, secImpactedItems);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, secImpactedItems);

        Assert.assertEquals(Counter, activityLogRows.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 6, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Field impacted search type\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_06() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
        find(activityLogFieldImpacted).click();
        find(searchText).sendKeys(searchTransactionValue5);
        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        List<WebElement> fieldImpactedItems = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);

        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement fieldImpactedItem = row.findElement(sixthColItemList);
            fieldImpactedItems.add(fieldImpactedItem);
            if ((fieldImpactedItem.getText().toLowerCase().contains(searchTransactionValue5.toLowerCase()))) {
                Counter++;
            }

        }

        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        // Highlight the elements
        highlightElements(driver, fieldImpactedItems);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, fieldImpactedItems);

        Assert.assertEquals(Counter, activityLogRows.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 7, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Old Value search type\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_07() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
        find(activityLogOldValue).click();
        find(searchText).sendKeys(searchTransactionValue6);
        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        List<WebElement> oldValueItems = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);

        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement OldValueItem = row.findElement(seventhColItemList);
            oldValueItems.add(OldValueItem);
            if ((OldValueItem.getText().toLowerCase().contains(searchTransactionValue6.toLowerCase()))) {
                Counter++;
            }

        }

        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        // Highlight the elements
        highlightElements(driver, oldValueItems);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, oldValueItems);

        Assert.assertEquals(Counter, activityLogRows.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 8, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using New Value search type\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_08() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
        find(activityLogNewValue).click();
        find(searchText).sendKeys(searchTransactionValue7);
        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        List<WebElement> newValueItems = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);

        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement newValueItem = row.findElement(eighthColItemList);
            newValueItems.add(newValueItem);
            if ((newValueItem.getText().toLowerCase().contains(searchTransactionValue7.toLowerCase()))) {
                Counter++;
            }

        }

        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        // Highlight the elements
        highlightElements(driver, newValueItems);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, newValueItems);

        Assert.assertEquals(Counter, activityLogRows.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 9, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Reason search type\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_09() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
        WebElement reasonCol = find(activityLogReason);
        scrollIntoView(reasonCol);
        reasonCol.click();
        find(searchText).sendKeys(searchTransactionValue8);
        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        List<WebElement> reasonItems = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);

        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement reasonItem = row.findElement(ninthColItemList);
            reasonItems.add(reasonItem);
            if ((reasonItem.getText().toLowerCase().contains(searchTransactionValue8.toLowerCase()))) {
                Counter++;
            }

        }

        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        // Highlight the elements
        highlightElements(driver, reasonItems);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, reasonItems);

        Assert.assertEquals(Counter, activityLogRows.size());

    }


    @Test(groups = {"smokeTest", "regressionTest"}, priority = 10, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Department search type\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_10() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
        WebElement departmentCol = find(activityLogDepartment);
        scrollIntoView(departmentCol);
        departmentCol.click();
        find(searchText).sendKeys(searchTransactionValue9);
        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        List<WebElement> departmentItems = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);

        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement departmentItem = row.findElement(fourteenthColItemList);
            departmentItems.add(departmentItem);
            if ((departmentItem.getText().toLowerCase().contains(searchTransactionValue9.toLowerCase()))) {
                Counter++;
            }

        }

        WebElement tableColNameDeparment = find(activityLogDeptColTitle);
        scrollIntoView(tableColNameDeparment);

        Thread.sleep(500);

        // Highlight the elements
        highlightElements(driver, departmentItems);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, departmentItems);

        Assert.assertEquals(Counter, activityLogRows.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 11, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using nonexistent search type value\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_11() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
        find(activityLogTransactionCode);
        find(searchText).sendKeys(searchTransactionValue10);
        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        WebElement error_msg = find(noItemError);
        String expectedError = expectederrorvalue4;

        // Find the elements to highlight
        List<WebElement> elements = List.of(
                error_msg,
                find(searchText)
        );

        // Highlight the elements
        highlightElements(driver, elements);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, elements);


        Assert.assertEquals(error_msg.getText(), expectedError);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 12, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Date range\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_12() throws InterruptedException, ParseException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchDateRange).click();
        find(dateRangeStartPick).click();
        find(dateRangeTodayPick).click();
        find(okBtn).click();
        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        WebElement dateRangePreview = find(activityLogDateRangePreview);
        String[] dateRangeSelected = dateRangePreview.getText().split(" - ");

        Date startDate = dateFormat.parse(dateRangeSelected[0]);
        Date endDate = dateFormat.parse(dateRangeSelected[1]);


        System.out.println(startDate);
        System.out.println(endDate);

        // Highlight the elements
        highlightElement(driver, dateRangePreview);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, dateRangePreview);

        List<WebElement> modifiedOnItems = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);

        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement modifiedOnItem = row.findElement(twelfthColItemList);
            Date date = dateFormat.parse(modifiedOnItem.getText());
            if (((date.compareTo(startDate) >= 0) && (date.compareTo(endDate) <= 0))) {
                Counter++;
                modifiedOnItems.add(modifiedOnItem);
            }

        }

        WebElement navigateModifiedOnCol = find(activityLogModifiedOnTitle);
        scrollIntoView(navigateModifiedOnCol);

        // Highlight the elements
        highlightElements(driver, modifiedOnItems);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, modifiedOnItems);

        Assert.assertEquals(Counter, activityLogRows.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 13, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using modifier Name \n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_13() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchModifiedBy).click();
        WebElement searchModifierName = find(searchModifiedBy);
        action.moveToElement(searchModifierName).sendKeys(searchTransactionValue11).perform();
        find(searchModifiedByValue1).click();
        action.sendKeys(Keys.ESCAPE).perform();

        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        WebElement modifierNameValue = find(activityLogModifiedByDName1);
        String tableColNameModifier = find(activityLogModifiedByDName).getText();
        List<WebElement> modifierNames = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);

        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement name = row.findElement(searchALPerModifiedByList);
            modifierNames.add(name);
            if ((name.getText().equalsIgnoreCase(modifierNameValue.getText()))) {
                Counter++;
            }

        }

        WebElement navigateModifieBynCol = find(activityLogModifiedByTitle);
        scrollIntoView(navigateModifieBynCol);

        // Highlight the elements
        highlightElements(driver, modifierNames);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, modifierNames);

        Assert.assertEquals(Counter, activityLogRows.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 14, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using modifier Name with nonexistent account\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_14() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchModifiedBy).click();
        WebElement searchModifierName = find(searchModifiedBy);
        action.moveToElement(searchModifierName).sendKeys(searchTransactionValue12).perform();
        action.sendKeys(Keys.ENTER).perform();


        //    Assertion

        WebElement error_message = find(modifiedByError);
        String expected_error = expectedErrorValue7;

        // Highlight the elements
        highlightElement(driver, error_message);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, error_message);

        Assert.assertEquals(error_message.getText(), expected_error);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 15, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Create Action\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_15_1() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(activityLogAction).click();
        find(activityLogActionCreate).click();

        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        WebElement actionValue = find(activityLogActionCreateSelected);

        List<WebElement> actions = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);

        int Counter = 0;
        for (WebElement action : activityLogRows) {
            WebElement actionType = action.findElement(fourthColItemList);
            actions.add(actionType);

            if ((actionType.getText().equalsIgnoreCase(actionValue.getText()))) {
                Counter++;

            }

        }
        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        // Highlight the elements
        highlightElement(driver, actionValue);

        // Highlight the elements
        highlightElements(driver, actions);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, actions);
        removeHighlight(driver, actionValue);

        Assert.assertEquals(Counter, activityLogRows.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 16, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Edit Action\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_15_2() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(activityLogAction).click();
        find(activityLogActionEdit).click();

        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        WebElement actionValue = find(activityLogActionEditSelected);

        List<WebElement> actions = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);

        int Counter = 0;
        for (WebElement action : activityLogRows) {
            WebElement actionType = action.findElement(fourthColItemList);
            actions.add(actionType);

            if ((actionType.getText().equalsIgnoreCase(actionValue.getText()))) {
                Counter++;

            }

        }
        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        // Highlight the elements
        highlightElement(driver, actionValue);

        // Highlight the elements
        highlightElements(driver, actions);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, actions);
        removeHighlight(driver, actionValue);

        Assert.assertEquals(Counter, activityLogRows.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 17, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Activate Action\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_15_3() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(activityLogAction).click();
        find(activityLogActionActivate).click();

        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        WebElement actionValue = find(activityLogActionActivateSelected);

        List<WebElement> actions = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);

        int Counter = 0;
        for (WebElement action : activityLogRows) {
            WebElement actionType = action.findElement(fourthColItemList);
            actions.add(actionType);

            if ((actionType.getText().equalsIgnoreCase(actionValue.getText()))) {
                Counter++;

            }

        }
        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        // Highlight the elements
        highlightElement(driver, actionValue);

        // Highlight the elements
        highlightElements(driver, actions);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, actions);
        removeHighlight(driver, actionValue);

        Assert.assertEquals(Counter, activityLogRows.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 18, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Deactivate Action\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_15_4() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(activityLogAction).click();
        find(activityLogActionDeactivate).click();

        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        WebElement actionValue = find(activityLogActionDeactivateSelected);

        List<WebElement> actions = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);

        int Counter = 0;
        for (WebElement action : activityLogRows) {
            WebElement actionType = action.findElement(fourthColItemList);
            actions.add(actionType);

            if ((actionType.getText().equalsIgnoreCase(actionValue.getText()))) {
                Counter++;

            }

        }
        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        // Highlight the elements
        highlightElement(driver, actionValue);

        // Highlight the elements
        highlightElements(driver, actions);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, actions);
        removeHighlight(driver, actionValue);

        Assert.assertEquals(Counter, activityLogRows.size());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 19, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Transaction code,Date range,modifier Name and Action\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_16() throws InterruptedException, ParseException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
        find(activityLogTransactionCode).click();
        find(searchText).sendKeys(searchTransactionValue1);
        find(searchDateRange).click();
        find(dateRangeStartPick).click();
        find(dateRangeTodayPick).click();
        find(okBtn).click();
        find(searchModifiedBy).click();
        WebElement searchModifierName = find(searchModifiedBy);
        action.moveToElement(searchModifierName).sendKeys(searchTransactionValue13).perform();
        find(searchModifiedByValue2).click();
        action.sendKeys(Keys.ESCAPE).perform();
        find(activityLogAction).click();
        find(activityLogActionCreate).click();

        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateRangePreview = find(activityLogDateRangePreview).getText();
        String[] dateRangeSelected = dateRangePreview.split(" - ");

        Date startDate = dateFormat.parse(dateRangeSelected[0]);
        Date endDate = dateFormat.parse(dateRangeSelected[1]);

        WebElement modifierNameValue = find(activityLogModifiedByDName1);
        WebElement seTypeValue = find(searchTypeValue);
        String searchTypeTextValue = find(searchText).getAttribute("value");
        WebElement actionValue = find(activityLogActionCreateSelected);

        List<WebElement> searchTypes = new ArrayList<WebElement>();
        List<WebElement> datesList = new ArrayList<WebElement>();
        List<WebElement> modifierNames = new ArrayList<WebElement>();
        List<WebElement> actionList = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);
        List<WebElement> noItemErrorMessage = finds(noItemError);
        int noItemErrorMessageCount = noItemErrorMessage.size();


        String errorMessage = "";
        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement searchType = row.findElement(firstColItemList);
            searchTypes.add(searchType);
            WebElement actionType = row.findElement(fourthColItemList);
            actionList.add(actionType);
            WebElement dates = row.findElement(twelfthColItemList);
            datesList.add(dates);
            WebElement modifierName = row.findElement(thirteenthColItemList);
            modifierNames.add(modifierName);

            Date date = dateFormat.parse(dates.getText());
            if ((searchType.getText().toLowerCase().contains(searchTypeTextValue.toLowerCase()))
                    && ((actionType.getText().equalsIgnoreCase(actionValue.getText())))
                    && ((date.compareTo(startDate) >= 0) && (date.compareTo(endDate) <= 0))
                    && (modifierName.getText().equalsIgnoreCase(modifierNameValue.getText()))
            ) {
                Counter++;
            }
        }

        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        if (Counter == 0 && noItemErrorMessageCount == 0) {
            boolean noItems = false;
            // Highlight the elements
            highlightElements(driver, actionList);
            highlightElements(driver, searchTypes);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, actionList);
            removeHighlights(driver, searchTypes);

            waitTime(500);
            WebElement departmentCol = find(activityLogDepartmentColFiltered);
            scrollIntoView(departmentCol);

            // Highlight the elements
            highlightElements(driver, datesList);
            highlightElements(driver, modifierNames);
            // Take a screenshot

            Screenshot();

            // Remove highlight
            removeHighlights(driver, datesList);
            removeHighlights(driver, modifierNames);
            errorMessage = "No matching item(s) found for " + "\n" + seTypeValue.getText() + ": " + searchTypeTextValue + "\nModified On: " + dateRangePreview + "\nModifier Name: " + modifierNameValue.getText() + "\nAction: " + actionValue.getText() + "\n";
            Assert.assertTrue(noItems, errorMessage);

        } else if (Counter == 0 && noItemErrorMessageCount == 1) {
            boolean noItems = false;
            highlightElements(driver, noItemErrorMessage);
            errorMessage = "No matching item(s) found for " + "\n" + seTypeValue.getText() + ": " + searchTypeTextValue + "\nModified On: " + dateRangePreview + "\nModifier Name: " + modifierNameValue.getText() + "\nAction: " + actionValue.getText() + "\n";
            Screenshot();
            removeHighlights(driver, noItemErrorMessage);
            Assert.assertTrue(noItems, errorMessage);
        } else {

            // Highlight the elements
            highlightElements(driver, actionList);
            highlightElements(driver, searchTypes);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, actionList);
            removeHighlights(driver, searchTypes);

            waitTime(500);
            WebElement departmentCol = find(activityLogDepartmentColFiltered);
            scrollIntoView(departmentCol);

            // Highlight the elements
            highlightElements(driver, datesList);
            highlightElements(driver, modifierNames);
            // Take a screenshot

            Screenshot();

            // Remove highlight
            removeHighlights(driver, datesList);
            removeHighlights(driver, modifierNames);

            Assert.assertEquals(Counter, activityLogRows.size());

        }

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 20, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Transaction ID, Date range,modifier Name and Action\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_17() throws InterruptedException, ParseException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
        find(activityLogTransactionId).click();
        find(searchText).sendKeys(searchTransactionValue14);
        find(searchDateRange).click();
        find(dateRangeStartPick).click();
        find(dateRangeTodayPick).click();
        find(okBtn).click();
        find(searchModifiedBy).click();
        WebElement searchModifierName = find(searchModifiedBy);
        action.moveToElement(searchModifierName).sendKeys(searchTransactionValue13).perform();
        find(searchModifiedByValue2).click();
        action.sendKeys(Keys.ESCAPE).perform();
        find(activityLogAction).click();
        find(activityLogActionEdit).click();
        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateRangePreview = find(activityLogDateRangePreview).getText();
        String[] dateRangeSelected = dateRangePreview.split(" - ");

        Date startDate = dateFormat.parse(dateRangeSelected[0]);
        Date endDate = dateFormat.parse(dateRangeSelected[1]);


        WebElement modifierNameValue = find(activityLogModifiedByDName1);
        WebElement seTypeValue = find(searchTypeValue);
        String searchTypeTextValue = find(searchText).getAttribute("value");
        WebElement actionValue = find(activityLogActionEditSelected);

        List<WebElement> searchTypes = new ArrayList<WebElement>();
        List<WebElement> datesList = new ArrayList<WebElement>();
        List<WebElement> modifierNames = new ArrayList<WebElement>();
        List<WebElement> actionList = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);
        List<WebElement> noItemErrorMessage = finds(noItemError);
        int noItemErrorMessageCount = noItemErrorMessage.size();


        String errorMessage = "";
        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement searchType = row.findElement(secondColItemList);
            searchTypes.add(searchType);
            WebElement actionType = row.findElement(fourthColItemList);
            actionList.add(actionType);
            WebElement dates = row.findElement(twelfthColItemList);
            datesList.add(dates);
            WebElement modifierName = row.findElement(thirteenthColItemList);
            modifierNames.add(modifierName);

            Date date = dateFormat.parse(dates.getText());
            if ((searchType.getText().toLowerCase().contains(searchTypeTextValue.toLowerCase()))
                    && ((actionType.getText().equalsIgnoreCase(actionValue.getText())))
                    && ((date.compareTo(startDate) >= 0) && (date.compareTo(endDate) <= 0))
                    && (modifierName.getText().equalsIgnoreCase(modifierNameValue.getText()))
            ) {
                Counter++;
            }
        }

        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        if (Counter == 0 && noItemErrorMessageCount == 0) {
            boolean noItems = false;
            // Highlight the elements
            highlightElements(driver, actionList);
            highlightElements(driver, searchTypes);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, actionList);
            removeHighlights(driver, searchTypes);

            waitTime(500);
            WebElement departmentCol = find(activityLogDepartmentColFiltered);
            scrollIntoView(departmentCol);

            // Highlight the elements
            highlightElements(driver, datesList);
            highlightElements(driver, modifierNames);
            // Take a screenshot

            Screenshot();

            // Remove highlight
            removeHighlights(driver, datesList);
            removeHighlights(driver, modifierNames);
            errorMessage = "No matching item(s) found for " + "\n" + seTypeValue.getText() + ": " + searchTypeTextValue + "\nModified On: " + dateRangePreview + "\nModifier Name: " + modifierNameValue.getText() + "\nAction: " + actionValue.getText() + "\n";
            Assert.assertTrue(noItems, errorMessage);

        } else if (Counter == 0 && noItemErrorMessageCount == 1) {
            boolean noItems = false;
            highlightElements(driver, noItemErrorMessage);
            errorMessage = "No matching item(s) found for " + "\n" + seTypeValue.getText() + ": " + searchTypeTextValue + "\nModified On: " + dateRangePreview + "\nModifier Name: " + modifierNameValue.getText() + "\nAction: " + actionValue.getText() + "\n";
            Screenshot();
            removeHighlights(driver, noItemErrorMessage);
            Assert.assertTrue(noItems, errorMessage);
        } else {

            // Highlight the elements
            highlightElements(driver, actionList);
            highlightElements(driver, searchTypes);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, actionList);
            removeHighlights(driver, searchTypes);

            waitTime(500);
            WebElement departmentCol = find(activityLogDepartmentColFiltered);
            scrollIntoView(departmentCol);

            // Highlight the elements
            highlightElements(driver, datesList);
            highlightElements(driver, modifierNames);
            // Take a screenshot

            Screenshot();

            // Remove highlight
            removeHighlights(driver, datesList);
            removeHighlights(driver, modifierNames);

            Assert.assertEquals(Counter, activityLogRows.size());

        }

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 21, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Change ID, Date range,modifier Name and Action\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_18() throws InterruptedException, ParseException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
        find(activityLogChangeId).click();
        find(searchText).sendKeys(searchTransactionValue14);
        find(searchDateRange).click();
        find(dateRangeStartPick).click();
        find(dateRangeTodayPick).click();
        find(okBtn).click();
        find(searchModifiedBy).click();
        WebElement searchModifierName = find(searchModifiedBy);
        action.moveToElement(searchModifierName).sendKeys(searchTransactionValue13).perform();
        find(searchModifiedByValue2).click();
        action.sendKeys(Keys.ESCAPE).perform();
        find(activityLogAction).click();
        find(activityLogActionActivate).click();


        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateRangePreview = find(activityLogDateRangePreview).getText();
        String[] dateRangeSelected = dateRangePreview.split(" - ");

        Date startDate = dateFormat.parse(dateRangeSelected[0]);
        Date endDate = dateFormat.parse(dateRangeSelected[1]);


        WebElement modifierNameValue = find(activityLogModifiedByDName1);
        WebElement seTypeValue = find(searchTypeValue);
        String searchTypeTextValue = find(searchText).getAttribute("value");
        WebElement actionValue = find(activityLogActionActivateSelected);

        List<WebElement> searchTypes = new ArrayList<WebElement>();
        List<WebElement> datesList = new ArrayList<WebElement>();
        List<WebElement> modifierNames = new ArrayList<WebElement>();
        List<WebElement> actionList = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);
        List<WebElement> noItemErrorMessage = finds(noItemError);
        int noItemErrorMessageCount = noItemErrorMessage.size();


        String errorMessage = "";
        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement searchType = row.findElement(thirdColItemList);
            searchTypes.add(searchType);
            WebElement actionType = row.findElement(fourthColItemList);
            actionList.add(actionType);
            WebElement dates = row.findElement(twelfthColItemList);
            datesList.add(dates);
            WebElement modifierName = row.findElement(thirteenthColItemList);
            modifierNames.add(modifierName);

            Date date = dateFormat.parse(dates.getText());
            if ((searchType.getText().toLowerCase().contains(searchTypeTextValue.toLowerCase()))
                    && ((actionType.getText().equalsIgnoreCase(actionValue.getText())))
                    && ((date.compareTo(startDate) >= 0) && (date.compareTo(endDate) <= 0))
                    && (modifierName.getText().equalsIgnoreCase(modifierNameValue.getText()))
            ) {
                Counter++;
            }
        }

        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        if (Counter == 0 && noItemErrorMessageCount == 0) {
            boolean noItems = false;
            // Highlight the elements
            highlightElements(driver, actionList);
            highlightElements(driver, searchTypes);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, actionList);
            removeHighlights(driver, searchTypes);

            waitTime(500);
            WebElement departmentCol = find(activityLogDepartmentColFiltered);
            scrollIntoView(departmentCol);

            // Highlight the elements
            highlightElements(driver, datesList);
            highlightElements(driver, modifierNames);
            // Take a screenshot

            Screenshot();

            // Remove highlight
            removeHighlights(driver, datesList);
            removeHighlights(driver, modifierNames);
            errorMessage = "No matching item(s) found for " + "\n" + seTypeValue.getText() + ": " + searchTypeTextValue + "\nModified On: " + dateRangePreview + "\nModifier Name: " + modifierNameValue.getText() + "\nAction: " + actionValue.getText() + "\n";
            Assert.assertTrue(noItems, errorMessage);

        } else if (Counter == 0 && noItemErrorMessageCount == 1) {
            boolean noItems = false;
            highlightElements(driver, noItemErrorMessage);
            errorMessage = "No matching item(s) found for " + "\n" + seTypeValue.getText() + ": " + searchTypeTextValue + "\nModified On: " + dateRangePreview + "\nModifier Name: " + modifierNameValue.getText() + "\nAction: " + actionValue.getText() + "\n";
            Screenshot();
            removeHighlights(driver, noItemErrorMessage);
            Assert.assertTrue(noItems, errorMessage);
        } else {

            // Highlight the elements
            highlightElements(driver, actionList);
            highlightElements(driver, searchTypes);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, actionList);
            removeHighlights(driver, searchTypes);

            waitTime(500);
            WebElement departmentCol = find(activityLogDepartmentColFiltered);
            scrollIntoView(departmentCol);

            // Highlight the elements
            highlightElements(driver, datesList);
            highlightElements(driver, modifierNames);
            // Take a screenshot

            Screenshot();

            // Remove highlight
            removeHighlights(driver, datesList);
            removeHighlights(driver, modifierNames);

            Assert.assertEquals(Counter, activityLogRows.size());

        }

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 22, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Section impacted, Date range,modifier Name and Action \n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_19() throws InterruptedException, ParseException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
        find(activityLogSectionImpacted).click();
        find(searchText).sendKeys(searchTransactionValue5);
        find(searchDateRange).click();
        find(dateRangeStartPick).click();
        find(dateRangeTodayPick).click();
        find(okBtn).click();
        find(searchModifiedBy).click();
        WebElement searchModifierName = find(searchModifiedBy);
        action.moveToElement(searchModifierName).sendKeys(searchTransactionValue13).perform();
        find(searchModifiedByValue2).click();
        action.sendKeys(Keys.ESCAPE).perform();
        find(activityLogAction).click();
        find(activityLogActionDeactivate).click();


        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateRangePreview = find(activityLogDateRangePreview).getText();
        String[] dateRangeSelected = dateRangePreview.split(" - ");

        Date startDate = dateFormat.parse(dateRangeSelected[0]);
        Date endDate = dateFormat.parse(dateRangeSelected[1]);


        WebElement modifierNameValue = find(activityLogModifiedByDName1);
        WebElement seTypeValue = find(searchTypeValue);
        String searchTypeTextValue = find(searchText).getAttribute("value");
        WebElement actionValue = find(activityLogActionDeactivateSelected);

        List<WebElement> searchTypes = new ArrayList<WebElement>();
        List<WebElement> datesList = new ArrayList<WebElement>();
        List<WebElement> modifierNames = new ArrayList<WebElement>();
        List<WebElement> actionList = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);
        List<WebElement> noItemErrorMessage = finds(noItemError);
        int noItemErrorMessageCount = noItemErrorMessage.size();


        String errorMessage = "";
        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement searchType = row.findElement(fifthColItemList);
            searchTypes.add(searchType);
            WebElement actionType = row.findElement(fourthColItemList);
            actionList.add(actionType);
            WebElement dates = row.findElement(twelfthColItemList);
            datesList.add(dates);
            WebElement modifierName = row.findElement(thirteenthColItemList);
            modifierNames.add(modifierName);

            Date date = dateFormat.parse(dates.getText());
            if ((searchType.getText().toLowerCase().contains(searchTypeTextValue.toLowerCase()))
                    && ((actionType.getText().equalsIgnoreCase(actionValue.getText())))
                    && ((date.compareTo(startDate) >= 0) && (date.compareTo(endDate) <= 0))
                    && (modifierName.getText().equalsIgnoreCase(modifierNameValue.getText()))
            ) {
                Counter++;
            }
        }

        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        if (Counter == 0 && noItemErrorMessageCount == 0) {
            boolean noItems = false;
            // Highlight the elements
            highlightElements(driver, actionList);
            highlightElements(driver, searchTypes);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, actionList);
            removeHighlights(driver, searchTypes);

            waitTime(500);
            WebElement departmentCol = find(activityLogDepartmentColFiltered);
            scrollIntoView(departmentCol);

            // Highlight the elements
            highlightElements(driver, datesList);
            highlightElements(driver, modifierNames);
            // Take a screenshot

            Screenshot();

            // Remove highlight
            removeHighlights(driver, datesList);
            removeHighlights(driver, modifierNames);
            errorMessage = "No matching item(s) found for " + "\n" + seTypeValue.getText() + ": " + searchTypeTextValue + "\nModified On: " + dateRangePreview + "\nModifier Name: " + modifierNameValue.getText() + "\nAction: " + actionValue.getText() + "\n";
            Assert.assertTrue(noItems, errorMessage);

        } else if (Counter == 0 && noItemErrorMessageCount == 1) {
            boolean noItems = false;
            highlightElements(driver, noItemErrorMessage);
            errorMessage = "No matching item(s) found for " + "\n" + seTypeValue.getText() + ": " + searchTypeTextValue + "\nModified On: " + dateRangePreview + "\nModifier Name: " + modifierNameValue.getText() + "\nAction: " + actionValue.getText() + "\n";
            Screenshot();
            removeHighlights(driver, noItemErrorMessage);
            Assert.assertTrue(noItems, errorMessage);
        } else {

            // Highlight the elements
            highlightElements(driver, actionList);
            highlightElements(driver, searchTypes);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, actionList);
            removeHighlights(driver, searchTypes);

            waitTime(500);
            WebElement departmentCol = find(activityLogDepartmentColFiltered);
            scrollIntoView(departmentCol);

            // Highlight the elements
            highlightElements(driver, datesList);
            highlightElements(driver, modifierNames);
            // Take a screenshot

            Screenshot();

            // Remove highlight
            removeHighlights(driver, datesList);
            removeHighlights(driver, modifierNames);

            Assert.assertEquals(Counter, activityLogRows.size());

        }

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 23, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Field impacted, Date range,modifier Name and Action\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_20() throws InterruptedException, ParseException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
        find(activityLogFieldImpacted).click();
        find(searchText).sendKeys(searchTransactionValue5);
        find(searchDateRange).click();
        find(dateRangeStartPick).click();
        find(dateRangeTodayPick).click();
        find(okBtn).click();
        find(searchModifiedBy).click();
        WebElement searchModifierName = find(searchModifiedBy);
        action.moveToElement(searchModifierName).sendKeys(searchTransactionValue13).perform();
        find(searchModifiedByValue2).click();
        action.sendKeys(Keys.ESCAPE).perform();
        find(activityLogAction).click();
        find(activityLogActionCreate).click();


        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateRangePreview = find(activityLogDateRangePreview).getText();
        String[] dateRangeSelected = dateRangePreview.split(" - ");

        Date startDate = dateFormat.parse(dateRangeSelected[0]);
        Date endDate = dateFormat.parse(dateRangeSelected[1]);


        WebElement modifierNameValue = find(activityLogModifiedByDName1);
        WebElement seTypeValue = find(searchTypeValue);
        String searchTypeTextValue = find(searchText).getAttribute("value");
        WebElement actionValue = find(activityLogActionCreateSelected);

        List<WebElement> searchTypes = new ArrayList<WebElement>();
        List<WebElement> datesList = new ArrayList<WebElement>();
        List<WebElement> modifierNames = new ArrayList<WebElement>();
        List<WebElement> actionList = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);
        List<WebElement> noItemErrorMessage = finds(noItemError);
        int noItemErrorMessageCount = noItemErrorMessage.size();


        String errorMessage = "";
        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement searchType = row.findElement(sixthColItemList);
            searchTypes.add(searchType);
            WebElement actionType = row.findElement(fourthColItemList);
            actionList.add(actionType);
            WebElement dates = row.findElement(twelfthColItemList);
            datesList.add(dates);
            WebElement modifierName = row.findElement(thirteenthColItemList);
            modifierNames.add(modifierName);

            Date date = dateFormat.parse(dates.getText());
            if ((searchType.getText().toLowerCase().contains(searchTypeTextValue.toLowerCase()))
                    && ((actionType.getText().equalsIgnoreCase(actionValue.getText())))
                    && ((date.compareTo(startDate) >= 0) && (date.compareTo(endDate) <= 0))
                    && (modifierName.getText().equalsIgnoreCase(modifierNameValue.getText()))
            ) {
                Counter++;
            }
        }

        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        if (Counter == 0 && noItemErrorMessageCount == 0) {
            boolean noItems = false;
            // Highlight the elements
            highlightElements(driver, actionList);
            highlightElements(driver, searchTypes);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, actionList);
            removeHighlights(driver, searchTypes);

            waitTime(500);
            WebElement departmentCol = find(activityLogDepartmentColFiltered);
            scrollIntoView(departmentCol);

            // Highlight the elements
            highlightElements(driver, datesList);
            highlightElements(driver, modifierNames);
            // Take a screenshot

            Screenshot();

            // Remove highlight
            removeHighlights(driver, datesList);
            removeHighlights(driver, modifierNames);
            errorMessage = "No matching item(s) found for " + "\n" + seTypeValue.getText() + ": " + searchTypeTextValue + "\nModified On: " + dateRangePreview + "\nModifier Name: " + modifierNameValue.getText() + "\nAction: " + actionValue.getText() + "\n";
            Assert.assertTrue(noItems, errorMessage);

        } else if (Counter == 0 && noItemErrorMessageCount == 1) {
            boolean noItems = false;
            highlightElements(driver, noItemErrorMessage);
            errorMessage = "No matching item(s) found for " + "\n" + seTypeValue.getText() + ": " + searchTypeTextValue + "\nModified On: " + dateRangePreview + "\nModifier Name: " + modifierNameValue.getText() + "\nAction: " + actionValue.getText() + "\n";
            Screenshot();
            removeHighlights(driver, noItemErrorMessage);
            Assert.assertTrue(noItems, errorMessage);
        } else {

            // Highlight the elements
            highlightElements(driver, actionList);
            highlightElements(driver, searchTypes);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, actionList);
            removeHighlights(driver, searchTypes);

            waitTime(500);
            WebElement departmentCol = find(activityLogDepartmentColFiltered);
            scrollIntoView(departmentCol);

            // Highlight the elements
            highlightElements(driver, datesList);
            highlightElements(driver, modifierNames);
            // Take a screenshot

            Screenshot();

            // Remove highlight
            removeHighlights(driver, datesList);
            removeHighlights(driver, modifierNames);

            Assert.assertEquals(Counter, activityLogRows.size());

        }

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 24, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Old Value, Date range,modifier Name and Action\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_21() throws InterruptedException, ParseException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
        find(activityLogOldValue).click();
        find(searchText).sendKeys(searchTransactionValue7);
        find(searchDateRange).click();
        find(dateRangeStartPick).click();
        find(dateRangeTodayPick).click();
        find(okBtn).click();
        find(searchModifiedBy).click();
        WebElement searchModifierName = find(searchModifiedBy);
        action.moveToElement(searchModifierName).sendKeys(searchTransactionValue13).perform();
        find(searchModifiedByValue2).click();
        action.sendKeys(Keys.ESCAPE).perform();
        find(activityLogAction).click();
        find(activityLogActionActivate).click();
        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateRangePreview = find(activityLogDateRangePreview).getText();
        String[] dateRangeSelected = dateRangePreview.split(" - ");

        Date startDate = dateFormat.parse(dateRangeSelected[0]);
        Date endDate = dateFormat.parse(dateRangeSelected[1]);


        WebElement modifierNameValue = find(activityLogModifiedByDName1);
        WebElement seTypeValue = find(searchTypeValue);
        String searchTypeTextValue = find(searchText).getAttribute("value");
        WebElement actionValue = find(activityLogActionActivateSelected);

        List<WebElement> searchTypes = new ArrayList<WebElement>();
        List<WebElement> datesList = new ArrayList<WebElement>();
        List<WebElement> modifierNames = new ArrayList<WebElement>();
        List<WebElement> actionList = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);
        List<WebElement> noItemErrorMessage = finds(noItemError);
        int noItemErrorMessageCount = noItemErrorMessage.size();


        String errorMessage = "";
        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement searchType = row.findElement(seventhColItemList);
            searchTypes.add(searchType);
            WebElement actionType = row.findElement(fourthColItemList);
            actionList.add(actionType);
            WebElement dates = row.findElement(twelfthColItemList);
            datesList.add(dates);
            WebElement modifierName = row.findElement(thirteenthColItemList);
            modifierNames.add(modifierName);

            Date date = dateFormat.parse(dates.getText());
            if ((searchType.getText().toLowerCase().contains(searchTypeTextValue.toLowerCase()))
                    && ((actionType.getText().equalsIgnoreCase(actionValue.getText())))
                    && ((date.compareTo(startDate) >= 0) && (date.compareTo(endDate) <= 0))
                    && (modifierName.getText().equalsIgnoreCase(modifierNameValue.getText()))
            ) {
                Counter++;
            }
        }

        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        if (Counter == 0 && noItemErrorMessageCount == 0) {
            boolean noItems = false;
            // Highlight the elements
            highlightElements(driver, actionList);
            highlightElements(driver, searchTypes);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, actionList);
            removeHighlights(driver, searchTypes);

            waitTime(500);
            WebElement departmentCol = find(activityLogDepartmentColFiltered);
            scrollIntoView(departmentCol);

            // Highlight the elements
            highlightElements(driver, datesList);
            highlightElements(driver, modifierNames);
            // Take a screenshot

            Screenshot();

            // Remove highlight
            removeHighlights(driver, datesList);
            removeHighlights(driver, modifierNames);
            errorMessage = "No matching item(s) found for " + "\n" + seTypeValue.getText() + ": " + searchTypeTextValue + "\nModified On: " + dateRangePreview + "\nModifier Name: " + modifierNameValue.getText() + "\nAction: " + actionValue.getText() + "\n";
            Assert.assertTrue(noItems, errorMessage);

        } else if (Counter == 0 && noItemErrorMessageCount == 1) {
            boolean noItems = false;
            highlightElements(driver, noItemErrorMessage);
            errorMessage = "No matching item(s) found for " + "\n" + seTypeValue.getText() + ": " + searchTypeTextValue + "\nModified On: " + dateRangePreview + "\nModifier Name: " + modifierNameValue.getText() + "\nAction: " + actionValue.getText() + "\n";
            Screenshot();
            removeHighlights(driver, noItemErrorMessage);
            Assert.assertTrue(noItems, errorMessage);
        } else {

            // Highlight the elements
            highlightElements(driver, actionList);
            highlightElements(driver, searchTypes);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, actionList);
            removeHighlights(driver, searchTypes);

            waitTime(500);
            WebElement departmentCol = find(activityLogDepartmentColFiltered);
            scrollIntoView(departmentCol);

            // Highlight the elements
            highlightElements(driver, datesList);
            highlightElements(driver, modifierNames);
            // Take a screenshot

            Screenshot();

            // Remove highlight
            removeHighlights(driver, datesList);
            removeHighlights(driver, modifierNames);

            Assert.assertEquals(Counter, activityLogRows.size());

        }

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 25, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using New Value, Date range,modifier Name and Action \n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_22() throws InterruptedException, ParseException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
        find(activityLogNewValue).click();
        find(searchText).sendKeys(searchTransactionValue6);
        find(searchDateRange).click();
        find(dateRangeStartPick).click();
        find(dateRangeTodayPick).click();
        find(okBtn).click();
        find(searchModifiedBy).click();
        WebElement searchModifierName = find(searchModifiedBy);
        action.moveToElement(searchModifierName).sendKeys(searchTransactionValue13).perform();
        find(searchModifiedByValue2).click();
        action.sendKeys(Keys.ESCAPE).perform();
        find(activityLogAction).click();
        find(activityLogActionDeactivate).click();


        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateRangePreview = find(activityLogDateRangePreview).getText();
        String[] dateRangeSelected = dateRangePreview.split(" - ");

        Date startDate = dateFormat.parse(dateRangeSelected[0]);
        Date endDate = dateFormat.parse(dateRangeSelected[1]);


        WebElement modifierNameValue = find(activityLogModifiedByDName1);
        WebElement seTypeValue = find(searchTypeValue);
        String searchTypeTextValue = find(searchText).getAttribute("value");
        WebElement actionValue = find(activityLogActionDeactivateSelected);

        List<WebElement> searchTypes = new ArrayList<WebElement>();
        List<WebElement> datesList = new ArrayList<WebElement>();
        List<WebElement> modifierNames = new ArrayList<WebElement>();
        List<WebElement> actionList = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);
        List<WebElement> noItemErrorMessage = finds(noItemError);
        int noItemErrorMessageCount = noItemErrorMessage.size();


        String errorMessage = "";
        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement searchType = row.findElement(eighthColItemList);
            searchTypes.add(searchType);
            WebElement actionType = row.findElement(fourthColItemList);
            actionList.add(actionType);
            WebElement dates = row.findElement(twelfthColItemList);
            datesList.add(dates);
            WebElement modifierName = row.findElement(thirteenthColItemList);
            modifierNames.add(modifierName);

            Date date = dateFormat.parse(dates.getText());
            if ((searchType.getText().toLowerCase().contains(searchTypeTextValue.toLowerCase()))
                    && ((actionType.getText().equalsIgnoreCase(actionValue.getText())))
                    && ((date.compareTo(startDate) >= 0) && (date.compareTo(endDate) <= 0))
                    && (modifierName.getText().equalsIgnoreCase(modifierNameValue.getText()))
            ) {
                Counter++;
            }
        }

        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        if (Counter == 0 && noItemErrorMessageCount == 0) {
            boolean noItems = false;
            // Highlight the elements
            highlightElements(driver, actionList);
            highlightElements(driver, searchTypes);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, actionList);
            removeHighlights(driver, searchTypes);

            waitTime(500);
            WebElement departmentCol = find(activityLogDepartmentColFiltered);
            scrollIntoView(departmentCol);

            // Highlight the elements
            highlightElements(driver, datesList);
            highlightElements(driver, modifierNames);
            // Take a screenshot

            Screenshot();

            // Remove highlight
            removeHighlights(driver, datesList);
            removeHighlights(driver, modifierNames);
            errorMessage = "No matching item(s) found for " + "\n" + seTypeValue.getText() + ": " + searchTypeTextValue + "\nModified On: " + dateRangePreview + "\nModifier Name: " + modifierNameValue.getText() + "\nAction: " + actionValue.getText() + "\n";
            Assert.assertTrue(noItems, errorMessage);

        } else if (Counter == 0 && noItemErrorMessageCount == 1) {
            boolean noItems = false;
            highlightElements(driver, noItemErrorMessage);
            errorMessage = "No matching item(s) found for " + "\n" + seTypeValue.getText() + ": " + searchTypeTextValue + "\nModified On: " + dateRangePreview + "\nModifier Name: " + modifierNameValue.getText() + "\nAction: " + actionValue.getText() + "\n";
            Screenshot();
            removeHighlights(driver, noItemErrorMessage);
            Assert.assertTrue(noItems, errorMessage);
        } else {

            // Highlight the elements
            highlightElements(driver, actionList);
            highlightElements(driver, searchTypes);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, actionList);
            removeHighlights(driver, searchTypes);

            waitTime(500);
            WebElement departmentCol = find(activityLogDepartmentColFiltered);
            scrollIntoView(departmentCol);

            // Highlight the elements
            highlightElements(driver, datesList);
            highlightElements(driver, modifierNames);
            // Take a screenshot

            Screenshot();

            // Remove highlight
            removeHighlights(driver, datesList);
            removeHighlights(driver, modifierNames);

            Assert.assertEquals(Counter, activityLogRows.size());

        }
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 26, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Reason, Date range,modifier Name and Action\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_23() throws InterruptedException, ParseException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
//        find(activityLogReason).click();
        WebElement reasonCol = find(activityLogReason);
        scrollIntoView(reasonCol);
        reasonCol.click();
        find(searchText).sendKeys(searchTransactionValue15);
        find(searchDateRange).click();
        find(dateRangeStartPick).click();
        find(dateRangeTodayPick).click();
        find(okBtn).click();
        find(searchModifiedBy).click();
        WebElement searchModifierName = find(searchModifiedBy);
        action.moveToElement(searchModifierName).sendKeys(searchTransactionValue13).perform();
        find(searchModifiedByValue2).click();
        action.sendKeys(Keys.ESCAPE).perform();
        find(activityLogAction).click();
        find(activityLogActionDeactivate).click();


        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateRangePreview = find(activityLogDateRangePreview).getText();
        String[] dateRangeSelected = dateRangePreview.split(" - ");

        Date startDate = dateFormat.parse(dateRangeSelected[0]);
        Date endDate = dateFormat.parse(dateRangeSelected[1]);


        WebElement modifierNameValue = find(activityLogModifiedByDName1);
        WebElement seTypeValue = find(searchTypeValue);
        String searchTypeTextValue = find(searchText).getAttribute("value");
        WebElement actionValue = find(activityLogActionDeactivateSelected);

        List<WebElement> searchTypes = new ArrayList<WebElement>();
        List<WebElement> datesList = new ArrayList<WebElement>();
        List<WebElement> modifierNames = new ArrayList<WebElement>();
        List<WebElement> actionList = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);
        List<WebElement> noItemErrorMessage = finds(noItemError);
        int noItemErrorMessageCount = noItemErrorMessage.size();

        String errorMessage = "";
        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement searchType = row.findElement(ninthColItemList);
            searchTypes.add(searchType);
            WebElement actionType = row.findElement(fourthColItemList);
            actionList.add(actionType);
            WebElement dates = row.findElement(twelfthColItemList);
            datesList.add(dates);
            WebElement modifierName = row.findElement(thirteenthColItemList);
            modifierNames.add(modifierName);

            Date date = dateFormat.parse(dates.getText());
            if ((searchType.getText().toLowerCase().contains(searchTypeTextValue.toLowerCase()))
                    && ((actionType.getText().equalsIgnoreCase(actionValue.getText())))
                    && ((date.compareTo(startDate) >= 0) && (date.compareTo(endDate) <= 0))
                    && (modifierName.getText().equalsIgnoreCase(modifierNameValue.getText()))
            ) {
                Counter++;
            }
        }

        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        if (Counter == 0 && noItemErrorMessageCount == 0) {
            boolean noItems = false;
            // Highlight the elements
            highlightElements(driver, actionList);
            highlightElements(driver, searchTypes);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, actionList);
            removeHighlights(driver, searchTypes);

            waitTime(500);
            WebElement departmentCol = find(activityLogDepartmentColFiltered);
            scrollIntoView(departmentCol);

            // Highlight the elements
            highlightElements(driver, datesList);
            highlightElements(driver, modifierNames);
            // Take a screenshot

            Screenshot();

            // Remove highlight
            removeHighlights(driver, datesList);
            removeHighlights(driver, modifierNames);
            errorMessage = "No matching item(s) found for " + "\n" + seTypeValue.getText() + ": " + searchTypeTextValue + "\nModified On: " + dateRangePreview + "\nModifier Name: " + modifierNameValue.getText() + "\nAction: " + actionValue.getText() + "\n";
            Assert.assertTrue(noItems, errorMessage);

        } else if (Counter == 0 && noItemErrorMessageCount == 1) {
            boolean noItems = false;
            highlightElements(driver, noItemErrorMessage);
            errorMessage = "No matching item(s) found for " + "\n" + seTypeValue.getText() + ": " + searchTypeTextValue + "\nModified On: " + dateRangePreview + "\nModifier Name: " + modifierNameValue.getText() + "\nAction: " + actionValue.getText() + "\n";
            Screenshot();
            removeHighlights(driver, noItemErrorMessage);
            Assert.assertTrue(noItems, errorMessage);
        } else {

            // Highlight the elements
            highlightElements(driver, actionList);
            highlightElements(driver, searchTypes);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, actionList);
            removeHighlights(driver, searchTypes);

            waitTime(500);
            WebElement departmentCol = find(activityLogDepartmentColFiltered);
            scrollIntoView(departmentCol);

            // Highlight the elements
            highlightElements(driver, datesList);
            highlightElements(driver, modifierNames);
            // Take a screenshot

            Screenshot();

            // Remove highlight
            removeHighlights(driver, datesList);
            removeHighlights(driver, modifierNames);

            Assert.assertEquals(Counter, activityLogRows.size());

        }
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 27, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To filter activity logs using Department, Date range,modifier Name and Action\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_24() throws InterruptedException, ParseException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
//        find(activityLogReason).click();
        WebElement reasonCol = find(activityLogDepartment);
        scrollIntoView(reasonCol);
        reasonCol.click();
        find(searchText).sendKeys(searchTransactionValue16);
        find(searchDateRange).click();
        find(dateRangeStartPick).click();
        find(dateRangeTodayPick).click();
        find(okBtn).click();
        find(searchModifiedBy).click();
        WebElement searchModifierName = find(searchModifiedBy);
        action.moveToElement(searchModifierName).sendKeys(searchTransactionValue13).perform();
        find(searchModifiedByValue2).click();
        action.sendKeys(Keys.ESCAPE).perform();
        find(activityLogAction).click();
        find(activityLogActionDeactivate).click();


        find(searchBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateRangePreview = find(activityLogDateRangePreview).getText();
        String[] dateRangeSelected = dateRangePreview.split(" - ");

        Date startDate = dateFormat.parse(dateRangeSelected[0]);
        Date endDate = dateFormat.parse(dateRangeSelected[1]);


        WebElement modifierNameValue = find(activityLogModifiedByDName1);
        WebElement seTypeValue = find(searchTypeValue);
        String searchTypeTextValue = find(searchText).getAttribute("value");
        WebElement actionValue = find(activityLogActionDeactivateSelected);

        List<WebElement> searchTypes = new ArrayList<WebElement>();
        List<WebElement> datesList = new ArrayList<WebElement>();
        List<WebElement> modifierNames = new ArrayList<WebElement>();
        List<WebElement> actionList = new ArrayList<WebElement>();
        List<WebElement> activityLogRows = finds(itemRow);
        List<WebElement> noItemErrorMessage = finds(noItemError);
        int noItemErrorMessageCount = noItemErrorMessage.size();

        String errorMessage = "";
        int Counter = 0;
        for (WebElement row : activityLogRows) {
            WebElement searchType = row.findElement(fourteenthColItemList);
            searchTypes.add(searchType);
            WebElement actionType = row.findElement(fourthColItemList);
            actionList.add(actionType);
            WebElement dates = row.findElement(twelfthColItemList);
            datesList.add(dates);
            WebElement modifierName = row.findElement(thirteenthColItemList);
            modifierNames.add(modifierName);

            Date date = dateFormat.parse(dates.getText());
            if ((searchType.getText().toLowerCase().contains(searchTypeTextValue.toLowerCase()))
                    && ((actionType.getText().equalsIgnoreCase(actionValue.getText())))
                    && ((date.compareTo(startDate) >= 0) && (date.compareTo(endDate) <= 0))
                    && (modifierName.getText().equalsIgnoreCase(modifierNameValue.getText()))
            ) {
                Counter++;
            }
        }

        WebElement tableName = find(activityLogTable);
        scrollIntoView(tableName);

        if (Counter == 0 && noItemErrorMessageCount == 0) {
            boolean noItems = false;
            // Highlight the elements
            highlightElements(driver, actionList);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, actionList);

            waitTime(500);
            WebElement departmentCol = find(activityLogDepartmentColFiltered);
            scrollIntoView(departmentCol);

            // Highlight the elements
            highlightElements(driver, datesList);
            highlightElements(driver, modifierNames);
            highlightElements(driver, searchTypes);
            // Take a screenshot

            Screenshot();

            // Remove highlight
            removeHighlights(driver, datesList);
            removeHighlights(driver, modifierNames);
            removeHighlights(driver, searchTypes);
            errorMessage = "No matching item(s) found for " + "\n" + seTypeValue.getText() + ": " + searchTypeTextValue + "\nModified On: " + dateRangePreview + "\nModifier Name: " + modifierNameValue.getText() + "\nAction: " + actionValue.getText() + "\n";
            Assert.assertTrue(noItems, errorMessage);

        } else if (Counter == 0 && noItemErrorMessageCount == 1) {
            boolean noItems = false;
            highlightElements(driver, noItemErrorMessage);
            errorMessage = "No matching item(s) found for " + "\n" + seTypeValue.getText() + ": " + searchTypeTextValue + "\nModified On: " + dateRangePreview + "\nModifier Name: " + modifierNameValue.getText() + "\nAction: " + actionValue.getText() + "\n";
            Screenshot();
            removeHighlights(driver, noItemErrorMessage);
            Assert.assertTrue(noItems, errorMessage);
        } else {

            // Highlight the elements
            highlightElements(driver, actionList);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, actionList);

            waitTime(500);
            WebElement departmentCol = find(activityLogDepartmentColFiltered);
            scrollIntoView(departmentCol);

            // Highlight the elements
            highlightElements(driver, datesList);
            highlightElements(driver, modifierNames);
            highlightElements(driver, searchTypes);
            // Take a screenshot

            Screenshot();

            // Remove highlight
            removeHighlights(driver, datesList);
            removeHighlights(driver, modifierNames);
            removeHighlights(driver, searchTypes);
            Assert.assertEquals(Counter, activityLogRows.size());

        }
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 28, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To export activity logs result to csv file")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_25() throws InterruptedException, ParseException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(exportBtn).click();

        // Assertion

//    Assertion

        WebElement exportMessage = find(notificationMessage1);
        String expectedMessage = toastExportMessage;

        WebElement exportMessage2 = find(toastMessageNotificationBox);
        // Highlight the elements
        highlightElement(driver, exportMessage2);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, exportMessage2);

        Assert.assertEquals(exportMessage.getText(), expectedMessage);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 29, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To clear all active filters on search criteria\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_26() throws InterruptedException, ParseException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(searchType).click();
        find(activityLogTransactionCode).click();
        find(searchText).sendKeys(searchTransactionValue1);
        find(searchDateRange).click();
        find(dateRangeStartPick).click();
        find(dateRangeTodayPick).click();
        find(okBtn).click();
        find(searchModifiedBy).click();
        WebElement searchModifierName = find(searchModifiedBy);
        action.moveToElement(searchModifierName).sendKeys(searchTransactionValue13).perform();
        find(searchModifiedByValue2).click();
        action.sendKeys(Keys.ESCAPE).perform();
        find(activityLogAction).click();
        find(activityLogActionCreate).click();

        List<WebElement> searchCriteriaList = new ArrayList<WebElement>();

        find(activityLogClearBtn).click();

        WebElement seTypeValue1 = find(activityLogSearchTypeDefaultValue);
        searchCriteriaList.add(seTypeValue1);
        WebElement searchTypeTextValue1 = find(searchText);
        searchCriteriaList.add(searchTypeTextValue1);
        WebElement dateRangeValue1 = find(activityLogDateRangeDefaultValue);
        searchCriteriaList.add(dateRangeValue1);
        WebElement modifierNameValue1 = find(activityLogModifiedByDefaultValue);
        searchCriteriaList.add(modifierNameValue1);
        WebElement actionValue1 = find(activityLogActionDefaultValue);
        searchCriteriaList.add(actionValue1);

        // Assertion

        boolean itemCleared = false;
        for (WebElement search : searchCriteriaList) {

            if (search.getText().toLowerCase().contains("select") || search.getText().toLowerCase().contains("search") || search.getText().isEmpty()) {
                itemCleared = true;
            } else {
                itemCleared = false;
            }
        }

        // Highlight the elements
        highlightElements(driver, searchCriteriaList);
        waitTime(500);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, searchCriteriaList);

        Assert.assertTrue(itemCleared);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 30, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To view address book details\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_27() throws InterruptedException, ParseException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(addressBookBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Assertion

        WebElement addressbookTitle = find(addressBookTitle);
        String expectedTitle = addressBookTitleValue;

        WebElement modal = find(addressBookModal);
        // Highlight the elements
        highlightElement(driver, modal);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, modal);

        Assert.assertEquals(addressbookTitle.getText().toLowerCase(), expectedTitle.toLowerCase());
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 31, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To add an account in the address book selection using add button icon\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_28() {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(addressBookBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        List<WebElement> rows = finds(modalALItemRow);
        List<String> names = new ArrayList<String>();


        int Count = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement name = row.findElement(addressBookNameList);
            WebElement plusButton = row.findElement(addressBookPlusBtnList);

            if (name.getText().toLowerCase().contains(searchTransactionValue13)) {
                action.moveToElement(plusButton).doubleClick().perform();

                // Highlight the elements
                highlightElement(driver, plusButton);

                // Take a screenshot
                Screenshot();

                // Remove highlight
                removeHighlight(driver, plusButton);

                names.add(name.getText().toLowerCase());
                Count++;

                if (Count == 1) {
                    break;
                }
            }

        }

        find(addressBookAddButton).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);


        // Assertion
        WebElement modifierName = find(activityLogModifiedByDName1);

        // Highlight the elements
        highlightElement(driver, modifierName);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, modifierName);

        Assert.assertEquals(names.getFirst(), modifierName.getText().toLowerCase());

    }


    @Test(groups = {"smokeTest", "regressionTest"}, priority = 32, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To search an account in address book using 3 minimum characters\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_29() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(addressBookBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, mainPage);

        find(searchCI).sendKeys(searchTransactionValue17);
        action.sendKeys(Keys.ENTER).perform();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        String searchTypeTextValue = find(searchCI).getAttribute("value");

        List<WebElement> rows = finds(modalALItemRow);
        List<WebElement> names = new ArrayList<WebElement>();
        List<WebElement> noItemErrorMessage = finds(noItemError);

        String errorMessage = "";
        int Counter = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement name = row.findElement(addressBookNameList);

            if (name.getText().toLowerCase().contains(searchTypeTextValue.toLowerCase())) {
                names.add(name);
                Counter++;

            }

        }

        if (Counter == 0) {
            boolean noItems = false;
            // Highlight the elements
            highlightElements(driver, noItemErrorMessage);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, noItemErrorMessage);

            errorMessage = "No matching item(s) found for " + searchTypeTextValue + "\n";
            Assert.assertTrue(noItems, errorMessage);
        } else {

            // Highlight the elements
            highlightElements(driver, names);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, names);
            Assert.assertEquals(Counter, rows.size());

        }
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 33, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To search an account in address book using 2 characters\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_30_1() {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(addressBookBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, mainPage);

        find(searchCI).sendKeys(searchTransactionValue18);
        action.sendKeys(Keys.ENTER).perform();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Assertion

        WebElement searchTypeTextValue = find(searchCI);
        WebElement minimumErrorMessage = find(min3CharError);
        String expectedError = expectedErrorValue5;

        // Highlight the elements
        highlightElement(driver, minimumErrorMessage);
        highlightElement(driver, searchTypeTextValue);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, minimumErrorMessage);
        removeHighlight(driver, searchTypeTextValue);

        Assert.assertEquals(minimumErrorMessage.getText(),expectedError);


    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 34, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To search an account in address book using 1 characters\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_30_2() {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(addressBookBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, mainPage);

        find(searchCI).sendKeys(searchTransactionValue19);
        action.sendKeys(Keys.ENTER).perform();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Assertion

        WebElement searchTypeTextValue = find(searchCI);
        WebElement minimumErrorMessage = find(min3CharError);
        String expectedError = expectedErrorValue5;

        // Highlight the elements
        highlightElement(driver, minimumErrorMessage);
        highlightElement(driver, searchTypeTextValue);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, minimumErrorMessage);
        removeHighlight(driver, searchTypeTextValue);

        Assert.assertEquals(minimumErrorMessage.getText(),expectedError);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 35, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To search a nonexistent account in address book\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_31() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(addressBookBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, mainPage);

        find(searchCI).sendKeys(searchTransactionValue20);
        action.sendKeys(Keys.ENTER).perform();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        String searchTypeTextValue = find(searchCI).getAttribute("value");

        List<WebElement> rows = finds(modalALItemRow);
        List<WebElement> names = new ArrayList<WebElement>();
        List<WebElement> noItemErrorMessage = finds(noItemError);

        String errorMessage = "";
        int Counter = 0;
        for (WebElement row : rows) {
            // Find the status column cell
            WebElement name = row.findElement(addressBookNameList);

            if (name.getText().toLowerCase().contains(searchTypeTextValue.toLowerCase())) {
                names.add(name);
                Counter++;

            }

        }
        boolean noItems = false;
        if (Counter == 0) {

            String expectedError = expectedErrorValue8;
            // Highlight the elements
            highlightElements(driver, noItemErrorMessage);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, noItemErrorMessage);

            Assert.assertEquals(noItemErrorMessage.getFirst().getText(),expectedError);
        } else {
            noItems = true;
            // Highlight the elements
            highlightElements(driver, names);

            // Take a screenshot
            Screenshot();

            // Remove highlight
            removeHighlights(driver, names);
            errorMessage = "Item(s) found for " + searchTypeTextValue + "\n";
            Assert.assertFalse(noItems,errorMessage);

        }
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 36, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To sort address book to ascending by column name \"Name\"\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_32_1() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(addressBookBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, mainPage);

        find(addressBookSortNameCol).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Assertion

        // First item in column name in ascending
        WebElement firstName = find(addressBookFirstNameCol);

        List<WebElement> rows = finds(modalALItemRow);
        List<String> names = new ArrayList<String>();
        List<WebElement> names1 = new ArrayList<WebElement>();

        for (WebElement row : rows) {
            // Find the status column cell
            WebElement name = row.findElement(addressBookNameList);
            names.add(name.getText().toLowerCase());
            names1.add(name);

        }
        Collections.sort(names);

        // Highlight the elements
        highlightElements(driver, names1);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, names1);

        Assert.assertEquals(names.getFirst().toLowerCase(),firstName.getText().toLowerCase());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 37, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To sort address book to descending by column name \"Name\"\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_32_2() throws InterruptedException {

        // Find the elements to highlight
        WebElement mainPage = find(mainLayout);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, mainPage);

        find(addressBookSortNameCol).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Assertion

        // First item in column name in ascending
        WebElement firstName = find(addressBookFirstNameCol);

        List<WebElement> rows = finds(modalALItemRow);
        List<String> names = new ArrayList<String>();
        List<WebElement> names1 = new ArrayList<WebElement>();

        for (WebElement row : rows) {
            // Find the status column cell
            WebElement name = row.findElement(addressBookNameList);
            names.add(name.getText().toLowerCase());
            names1.add(name);

        }
        names.sort(Collections.reverseOrder());

        // Highlight the elements
        highlightElements(driver, names1);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, names1);
        Assert.assertEquals(names.getFirst().toLowerCase(),firstName.getText().toLowerCase());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 38, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To sort address book to default by column name \"Name\"\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_32_3() {

        // Find the elements to highlight
        WebElement mainPage = find(mainLayout);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, mainPage);

        find(addressBookSortNameCol).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Assertion

        // First item in column name in ascending
        WebElement firstName = find(addressBookFirstNameCol);

        List<WebElement> rows = finds(modalALItemRow);
        List<String> names = new ArrayList<String>();
        List<WebElement> names1 = new ArrayList<WebElement>();

        for (WebElement row : rows) {
            // Find the status column cell
            WebElement name = row.findElement(addressBookNameList);
            names.add(name.getText().toLowerCase());
            names1.add(name);

        }

        // Highlight the elements
        highlightElements(driver, names1);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, names1);
        Assert.assertEquals(names.getFirst().toLowerCase(),firstName.getText().toLowerCase());

    }


    @Test(groups = {"smokeTest", "regressionTest"}, priority = 39, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To sort address book to ascending by column name \"Department\"\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_33_1() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(addressBookBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, mainPage);

        find(addressBookSortDepartmentCol).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Assertion

        // First item in column name in ascending
        WebElement firstName = find(addressBookFirstDepartmentCol);

        List<WebElement> rows = finds(modalALItemRow);
        List<String> names = new ArrayList<String>();
        List<WebElement> names1 = new ArrayList<WebElement>();

        for (WebElement row : rows) {
            // Find the status column cell
            WebElement name = row.findElement(addressBookDepartmentList);
            names.add(name.getText().toLowerCase());
            names1.add(name);

        }
        Collections.sort(names);

        // Highlight the elements
        highlightElements(driver, names1);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, names1);

        Assert.assertEquals(names.getFirst().toLowerCase(),firstName.getText().toLowerCase());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 40, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To sort address book to descending by column name \"Name\"\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_33_2() throws InterruptedException {

        // Find the elements to highlight
        WebElement mainPage = find(mainLayout);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, mainPage);

        find(addressBookSortDepartmentColDesc).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Assertion

        // First item in column name in ascending
        WebElement firstName = find(addressBookFirstDepartmentCol);

        List<WebElement> rows = finds(modalALItemRow);
        List<String> names = new ArrayList<String>();
        List<WebElement> names1 = new ArrayList<WebElement>();

        for (WebElement row : rows) {
            // Find the status column cell
            WebElement name = row.findElement(addressBookDepartmentList);
            names.add(name.getText().toLowerCase());
            names1.add(name);

        }
        names.sort(Collections.reverseOrder());

        // Highlight the elements
        highlightElements(driver, names1);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, names1);
        Assert.assertEquals(names.getFirst().toLowerCase(),firstName.getText().toLowerCase());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 41, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To sort address book to default by column name \"Name\"\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_33_3() {

        // Find the elements to highlight
        WebElement mainPage = find(mainLayout);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, mainPage);

        find(addressBookSortDepartmentColDefault).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Assertion

        // First item in column name in ascending
        WebElement firstName = find(addressBookFirstDepartmentCol);

        List<WebElement> rows = finds(modalALItemRow);
        List<String> names = new ArrayList<String>();
        List<WebElement> names1 = new ArrayList<WebElement>();

        for (WebElement row : rows) {
            // Find the status column cell
            WebElement name = row.findElement(addressBookDepartmentList);
            names.add(name.getText().toLowerCase());
            names1.add(name);

        }

        // Highlight the elements
        highlightElements(driver, names1);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver, names1);
        Assert.assertEquals(names.getFirst().toLowerCase(),firstName.getText().toLowerCase());

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 42, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To verify the total number of account in the address book list\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_05_34() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(activityLogBtn).click();

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
        removeHighlight(driver, mainPage);

        find(addressBookBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Highlight the elements
        highlightElement(driver, mainPage);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver, mainPage);

        // Assertion

        WebElement totalItem = find(addressBookTotalAccount);

        System.out.println(totalItem.getText());

//        WebElement pageRowCount = find(addressBookShowRowValue);
//        WebElement pageOfValue = find(addressBookPageOfValue);
//        String[] totalItemSelected = pageOfValue.getText().split(" ");
//        WebElement totalItemCount = find(addressBookTotalAccount);
//        String[] totalItemSelected1 = totalItemCount.getText().split(" ");
//
//        System.out.println(totalItemSelected[1]);
//        System.out.println(pageRowCount.getText());
//        System.out.println(pageOfValue.getText());
//
//
//        // Highlight the elements
//        highlightElement(driver, totalItemCount);
//
//        // Take a screenshot
//        Screenshot();
//
//        // Remove highlight
//        removeHighlight(driver, totalItemCount);
//
//        Assert.assertEquals(names.getFirst().toLowerCase(),firstName.getText().toLowerCase());

    }

}