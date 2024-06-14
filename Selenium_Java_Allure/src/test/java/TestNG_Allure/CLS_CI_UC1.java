package TestNG_Allure;
import Utility.CustomRetryAnalyzer;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utility.BaseDriver;
import java.util.ArrayList;
import java.util.List;
import static Utility.ByLocator.*;
import static Utility.StringData.*;

public class CLS_CI_UC1 extends BaseDriver {

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 1, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To create/save a new charge item with \"Registration\" charge type value\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_01_01() throws InterruptedException {

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

        waitUntilVisibilityOfElementLocated(createBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(chargeItemName).sendKeys(chargeitemvalue1);
        find(chargeTypeId).click();
        find(registrationCTId).click();
        find(chargeItemDesc).sendKeys(chargeitemdescription1);
        find(baseCurrencyId).click();
        find(sgdBCId).click();
        find(gstApplicableTrue).click();
        find(chargeAmount).sendKeys(frstamount);
        find(glNumberId).click();
        find(glNumberIdValue1).click();
        find(refundableId).click();
        find(tagToRegistrationTrue).click();

        // Find the elements to highlight
        List<WebElement> elements = List.of(
                find(chargeItemName),
                find(highlightChargeType),
                find(chargeItemDesc),
                find(highlightBaseCurrency),
                find(highlightGSTApplicableYes),
                find(chargeAmount),
                find(highlightGLNumber),
                find(highlightRefundable),
                find(highlightTagToRegistrationYes)
        );

        // Highlight the elements
        highlightElements(driver, elements);
        waitTime(500);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlights(driver,elements);

//        find(saveBtn).click();


//        Need to remove these lines in actual testing
        find(xBtn).click();
        find(modalOkBtn).click();
//        Need to remove these lines in actual testing

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);


        //    Assertion

        find(searchCI).sendKeys(searchitemvalue2);
        action.sendKeys(Keys.ENTER).perform();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);


        // Find all rows in the table
        List<WebElement> searchRows = finds(itemRow);
        List<String> cType = new ArrayList<String>();


        int searchRegistrationCount = 0;
        for (WebElement searchRow : searchRows) {
            // Find the status column cell
            String searchTypeCell = searchRow.findElement(searchCItemTypeList).getText();
            String searchChargeitem = searchRow.findElement(searchCItemNameList).getText();
            WebElement highlightSearchChargeItem = searchRow.findElement(searchCItemNameList);
            WebElement highlightStatusChargeItem = searchRow.findElement(searchCItemStatusList);

            if (searchChargeitem.equalsIgnoreCase(searchitemvalue2) && searchTypeCell.equalsIgnoreCase(registrationvalue)) {
                cType.add(searchTypeCell);
                searchRegistrationCount++;


                // Find the elements to highlight
                List<WebElement> highlightedItems = List.of(
                        highlightSearchChargeItem,
                        highlightStatusChargeItem
                );

                // Highlight the elements
                highlightElements(driver, highlightedItems);

                // Take a screenshot
                Screenshot();

                // Remove highlight
                removeHighlights(driver,highlightedItems);

                if (searchRegistrationCount == 1) {
                    break;
                }
            }

        }

        Assert.assertEquals(searchRegistrationCount, 1);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 2, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To create/save a new charge item with \"Admin\" charge type value\n")
    public void UC_LH_CLS_CI_01_01_02() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(createBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(chargeItemName).sendKeys(chargeitemvalue2);
        find(chargeTypeId).click();
        find(adminCTId).click();
        find(chargeItemDesc).sendKeys(chargeitemdescription1);
        find(baseCurrencyId).click();
        find(usdBCId).click();
        find(gstApplicableFalse).click();
        find(chargeAmount).sendKeys(secndamount);
        find(glNumberId).click();
        find(glNumberIdValue2).click();
        find(tagToRegistrationFalse).click();
        find(profitCentreId).click();
        find(profitCentreIdValue1).click();

        // Find the elements to highlight
        List<WebElement> elements = List.of(
                find(chargeItemName),
                find(highlightChargeType),
                find(chargeItemDesc),
                find(highlightBaseCurrency),
                find(highlightGSTApplicableNo),
                find(chargeAmount),
                find(highlightGLNumber),
                find(highlightTagToRegistrationNo),
                find(highlightProfitCentre)
        );

        // Highlight the elements
        highlightElements(driver, elements);
        waitTime(500);

        // Take a screenshot
        Screenshot();

//        find(saveBtn).click();

//    Need to remove these lines in actual testing
        find(xBtn).click();
        find(modalOkBtn).click();

//     Need to remove these lines in actual testing

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        find(searchCI).sendKeys(searchitemvalue2);
        action.sendKeys(Keys.ENTER).perform();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Find all rows in the table
        List<WebElement> searchRows = finds(itemRow);
        List<String> cType = new ArrayList<String>();


        int searchAdminCount = 0;
        for (WebElement searchRow : searchRows) {
            // Find the status column cell
            String searchTypeCell = searchRow.findElement(searchCItemTypeList).getText();
            String searchChargeitem = searchRow.findElement(searchCItemNameList).getText();
            WebElement highlightSearchChargeItem = searchRow.findElement(searchCItemNameList);
            WebElement highlightStatusChargeItem = searchRow.findElement(searchCItemStatusList);

            if (searchChargeitem.equalsIgnoreCase(searchitemvalue2) && searchTypeCell.equalsIgnoreCase(registrationvalue)) {
                cType.add(searchTypeCell);
                searchAdminCount++;

                // Find the elements to highlight
                List<WebElement> highlightedItems = List.of(
                        highlightSearchChargeItem,
                        highlightStatusChargeItem
                );

                // Highlight the elements
                highlightElements(driver, highlightedItems);

                // Take a screenshot
                Screenshot();

                // Remove highlight
                removeHighlights(driver,highlightedItems);

                if (searchAdminCount == 1) {
                    break;
                }
            }

        }

        Assert.assertEquals(searchAdminCount, 1);

    }


    @Test(groups = {"smokeTest", "regressionTest"}, priority = 3, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To create/save a new charge item with \"Duplicate Invoice\" charge type value\n")
    public void UC_LH_CLS_CI_01_01_03() throws InterruptedException {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilVisibilityOfElementLocated(createBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(chargeItemName).sendKeys(chargeitemvalue3);
        find(chargeTypeId).click();
        find(duplicateInvoiceId).click();
        find(chargeItemDesc).sendKeys(chargeitemdescription1);
        find(glNumberId).click();
        find(glNumberIdValue3).click();
        find(tagToRegistrationFalse).click();
        find(profitCentreId).click();
        find(profitCentreIdValue2).click();

        // Find the elements to highlight
        List<WebElement> elements = List.of(
                find(chargeItemName),
                find(highlightChargeType),
                find(chargeItemDesc),
                find(highlightGLNumber),
                find(highlightTagToRegistrationNo),
                find(highlightProfitCentre)
        );

        // Highlight the elements
        highlightElements(driver, elements);
        waitTime(500);

        // Take a screenshot
        Screenshot();

//        find(saveBtn).click();

//    Need to remove these lines in actual testing
        find(xBtn).click();
        find(modalOkBtn).click();

//     Need to remove these lines in actual testing

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        find(searchCI).sendKeys(searchitemvalue2);
        action.sendKeys(Keys.ENTER).perform();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Find all rows in the table
        List<WebElement> searchRows = finds(itemRow);
        List<String> cType = new ArrayList<String>();


        int searchDICount = 0;
        for (WebElement searchRow : searchRows) {
            // Find the status column cell
            String searchTypeCell = searchRow.findElement(searchCItemTypeList).getText();
            String searchChargeitem = searchRow.findElement(searchCItemNameList).getText();
            WebElement highlightSearchChargeItem = searchRow.findElement(searchCItemNameList);
            WebElement highlightStatusChargeItem = searchRow.findElement(searchCItemStatusList);

            if (searchChargeitem.equalsIgnoreCase(searchitemvalue2) && searchTypeCell.equalsIgnoreCase(registrationvalue)) {
                cType.add(searchTypeCell);
                searchDICount++;

                // Find the elements to highlight
                List<WebElement> highlightedItems = List.of(
                        highlightSearchChargeItem,
                        highlightStatusChargeItem
                );

                // Highlight the elements
                highlightElements(driver, highlightedItems);

                // Take a screenshot
                Screenshot();

                // Remove highlight
                removeHighlights(driver,highlightedItems);

                if (searchDICount == 1) {
                    break;
                }
            }

        }

        Assert.assertEquals(searchDICount, 1);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 4, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To create/save a new charge item with \"General\" charge type value\n")
    public void UC_LH_CLS_CI_01_01_04() throws InterruptedException {


        // Launch website

        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilVisibilityOfElementLocated(createBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(chargeItemName).sendKeys(chargeitemvalue4);
        find(chargeTypeId).click();
        find(generalId).click();
        find(chargeItemDesc).sendKeys(chargeitemdescription1);
        find(glNumberId).click();
        find(glNumberIdValue4).click();

        // Find the elements to highlight
        List<WebElement> elements = List.of(
                find(chargeItemName),
                find(highlightChargeType),
                find(chargeItemDesc),
                find(highlightGLNumber)
        );

        // Highlight the elements
        highlightElements(driver, elements);
        waitTime(500);

        // Take a screenshot
        Screenshot();


//        find(saveBtn).click();

//    Need to remove these lines in actual testing
        find(xBtn).click();
        find(modalOkBtn).click();

//     Need to remove these lines in actual testing

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        find(searchCI).sendKeys(searchitemvalue2);
        action.sendKeys(Keys.ENTER).perform();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        // Find all rows in the table
        List<WebElement> searchRows = finds(itemRow);
        List<String> cType = new ArrayList<String>();


        int searchGeneralCount = 0;
        for (WebElement searchRow : searchRows) {
            // Find the status column cell
            String searchTypeCell = searchRow.findElement(searchCItemTypeList).getText();
            String searchChargeitem = searchRow.findElement(searchCItemNameList).getText();
            WebElement highlightSearchChargeItem = searchRow.findElement(searchCItemNameList);
            WebElement highlightStatusChargeItem = searchRow.findElement(searchCItemStatusList);

            if (searchChargeitem.equalsIgnoreCase(searchitemvalue2) && searchTypeCell.equalsIgnoreCase(registrationvalue)) {
                cType.add(searchTypeCell);
                searchGeneralCount++;

                // Find the elements to highlight
                List<WebElement> highlightedItems = List.of(
                        highlightSearchChargeItem,
                        highlightStatusChargeItem
                );

                // Highlight the elements
                highlightElements(driver, highlightedItems);

                // Take a screenshot
                Screenshot();

                // Remove highlight
                removeHighlights(driver,highlightedItems);

                if (searchGeneralCount == 1) {
                    break;
                }
            }

        }
        Assert.assertEquals(searchGeneralCount, 1);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 5, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To create/save a new charge item with existing name\n")
    public void UC_LH_CLS_CI_01_01_05() {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(createBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(chargeItemName).sendKeys(existingchargeitemvalue1);
        find(chargeItemName);
        action.sendKeys(Keys.TAB).perform();

//        find(saveBtn).click();

        //    Assertion

        WebElement error_message = find(errorMessage1);
        String expected_error = expectederrorvalue1;

        // Highlight the elements
        highlightElement(driver, error_message);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,error_message);

        Assert.assertEquals(error_message.getText(), expected_error);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 6, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To create/save a new charge item with blank charge item name")
    public void UC_LH_CLS_CI_01_01_06_1() {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(createBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(chargeTypeId).click();
        find(adminCTId).click();
        find(chargeItemDesc).sendKeys(chargeitemdescription1);
        find(glNumberId).click();
        find(glNumberIdValue1).click();
        find(saveBtn).click();

//    Assertion

        WebElement error_message = find(mandatoryErrorMessage1);
        String expected_error = mandatoryerrorvalue1;

        // Highlight the elements
        highlightElement(driver, error_message);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,error_message);

        Assert.assertEquals(error_message.getText(), expected_error);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 7, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To create/save a new charge item without charge type")
    public void UC_LH_CLS_CI_01_01_06_2() {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(createBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(chargeItemName).sendKeys(chargeitemvalue6);
        find(chargeItemDesc).sendKeys(chargeitemdescription1);
        find(glNumberId).click();
        find(glNumberIdValue2).click();
        find(saveBtn).click();

//    Assertion

        WebElement error_message = find(mandatoryErrorMessage1);
        String expected_error = mandatoryerrorvalue2;

        // Highlight the elements
        highlightElement(driver, error_message);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,error_message);

        Assert.assertEquals(error_message.getText(), expected_error);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 8, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To create/save a new charge item with blank charge description")
    public void UC_LH_CLS_CI_01_01_06_3() {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(createBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(chargeItemName).sendKeys(chargeitemvalue6);
        find(chargeTypeId).click();
        find(duplicateInvoiceId).click();
        find(glNumberId).click();
        find(glNumberIdValue3).click();
        find(saveBtn).click();

//    Assertion

        WebElement error_message = find(mandatoryErrorMessage1);
        String expected_error = mandatoryerrorvalue1;

        // Highlight the elements
        highlightElement(driver, error_message);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,error_message);

        Assert.assertEquals(error_message.getText(), expected_error);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 9, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To create/save a new charge item without GL Number")
    public void UC_LH_CLS_CI_01_01_06_4() {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(createBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(chargeItemName).sendKeys(chargeitemvalue6);
        find(chargeTypeId).click();
        find(generalId).click();
        find(chargeItemDesc).sendKeys(chargeitemdescription1);
        find(saveBtn).click();

//    Assertion

        WebElement error_message = find(mandatoryErrorMessage1);
        String expected_error = mandatoryerrorvalue2;

        // Highlight the elements
        highlightElement(driver, error_message);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,error_message);

        Assert.assertEquals(error_message.getText(), expected_error);

    }

    @Test(groups = {"regressionTest"}, priority = 10, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To validate cancellation message using cancel button\n")
    public void UC_LH_CLS_CI_01_01_07_1() throws InterruptedException {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(createBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(chargeItemName).sendKeys(chargeitemvalue7);
        find(chargeTypeId).click();
        find(generalId).click();
        find(chargeItemDesc).sendKeys(chargeitemdescription1);
        find(glNumberId).click();
        WebElement glNumberValue = find(glNumberIdValue4);
        jse.executeScript("arguments[0].scrollIntoView(true);", glNumberValue);
        find(cancelBtn).click();

//    Assertion

        WebElement confirm_message = find(modalConfirmContent);
        String expected_message = expectederrorvalue2;

        // Highlight the elements
        highlightElement(driver, confirm_message);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,confirm_message);

        Assert.assertEquals(confirm_message.getText(), expected_message);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 11, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To cancel an ongoing creation of a charge item using cancel button\n")
    public void UC_LH_CLS_CI_01_01_07_2() throws InterruptedException {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(createBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(chargeItemName).sendKeys(chargeitemvalue7);
        find(chargeTypeId).click();
        find(generalId).click();
        find(chargeItemDesc).sendKeys(chargeitemdescription1);
        find(glNumberId).click();
        find(glNumberIdValue4).click();
        find(cancelBtn).click();
        find(modalOkBtn).click();

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

    @Test(groups = {"regressionTest"}, priority = 12, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To validate cancellation message using x button\n")
    public void UC_LH_CLS_CI_01_01_08_1() throws InterruptedException {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(createBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(chargeItemName).sendKeys(chargeitemvalue8);
        find(chargeTypeId).click();
        find(generalId).click();
        find(chargeItemDesc).sendKeys(chargeitemdescription1);
        find(glNumberId).click();
        find(glNumberIdValue4).click();
        find(xBtn).click();

//    Assertion

        WebElement confirm_message = find(modalConfirmContent);
        String expected_message = expectederrorvalue2;

        // Highlight the elements
        highlightElement(driver, confirm_message);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,confirm_message);

        Assert.assertEquals(confirm_message.getText(), expected_message);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 13, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To cancel an ongoing creation of a charge item using x button\n")
    public void UC_LH_CLS_CI_01_01_08_2() throws InterruptedException {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(createBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(chargeItemName).sendKeys(chargeitemvalue8);
        find(chargeTypeId).click();
        find(generalId).click();
        find(chargeItemDesc).sendKeys(chargeitemdescription1);
        find(glNumberId).click();
        find(glNumberIdValue4).click();
        find(xBtn).click();
        find(modalOkBtn).click();

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

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 14, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To disregard an ongoing cancel creation of a charge item using cancel button\n")
    public void UC_LH_CLS_CI_01_01_09() throws InterruptedException {

        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(createBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(chargeItemName).sendKeys(chargeitemvalue8);
        find(chargeTypeId).click();
        find(generalId).click();
        find(chargeItemDesc).sendKeys(chargeitemdescription1);
        find(glNumberId).click();
        find(glNumberIdValue4).click();
        find(cancelBtn).click();
        find(modalCancelBtn).click();


        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = createChargeItemUrl;


        // Find the elements to highlight
        WebElement createPage = find(createLayout);

        // Highlight the elements
        highlightElement(driver, createPage);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,createPage);

        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 15, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To cancel a newly launch unmodified form using cancel button\n")
    public void UC_LH_CLS_CI_01_01_10() throws InterruptedException {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(createBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(cancelBtn).click();

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

    @Test(groups = {"regressionTest"}, priority = 16, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To cancel a newly launch unmodified form using x button\n")
    public void UC_LH_CLS_CI_01_01_11() throws InterruptedException {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(createBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(xBtn).click();

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


    @Test(groups = {"regressionTest"}, priority = 17, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To cancel a newly launch unmodified form using Esc button in keyboard\n")
    public void UC_LH_CLS_CI_01_01_12() throws InterruptedException {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        WebElement create_btn = waitUntilElementToBeClickable(createBtn);
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        WebElement chargeName = find(chargeItemName);
        action.click(chargeName).sendKeys(Keys.ESCAPE).perform();

        //    Assertion
        Thread.sleep(1000);
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

    @Test(groups = {"regressionTest"}, priority = 18, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To verify maximum input of 200 characters in \"Description\" field\n")
    public void UC_LH_CLS_CI_01_01_13() throws InterruptedException {


        // Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(createBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        find(chargeItemName).sendKeys(chargeitemvalue13);
        find(chargeTypeId).click();
        find(generalId).click();
        find(chargeItemDesc).sendKeys(chargeitemdescription2);

        //    Assertion

        WebElement max_length = find(maxTextArea);
        String expected_length = expectedlength1;

        // Highlight the elements
        highlightElement(driver, max_length);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,max_length);

        Assert.assertEquals(max_length.getText(), expected_length);
    }

    @Test(groups = {"regressionTest"}, priority = 19, retryAnalyzer = CustomRetryAnalyzer.class)
    @Tag("New")
    @Description("To verify drawer title")
    public void UC_LH_CLS_CI_01_01_14() throws InterruptedException {

// Launch website
        openUrl(chargeItemUrl);
        implicitWait(1);

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        waitUntilElementToBeClickable(createBtn).click();

        // Waiting for loader
        waitLoader(spinLoader);
        waitLoader(backDrop);

        //    Assertion

        WebElement drawerTitle = waitUntilPresenceOfElementLocated(createDrawerTitle);
        String expected_title = createdrawertitlevalue;

        // Highlight the elements
        highlightElement(driver, drawerTitle);

        // Take a screenshot
        Screenshot();

        // Remove highlight
        removeHighlight(driver,drawerTitle);

        Assert.assertEquals(drawerTitle.getText(), expected_title);

    }

}
