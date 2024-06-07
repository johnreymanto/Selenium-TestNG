package TestNG_Allure;
import Utility.CustomRetryAnalyzer;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utility.BaseDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static Utility.StringData.*;
import static Utility.StringLocator.*;


public class CLS_CI_UC1 extends BaseDriver {

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 1)
    @Description("To create/save a new charge item with \"Registration\" charge type value\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_01_01() throws InterruptedException {

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

        // Take a screenshot
        Screenshot();

        WebElement create_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue1);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(registrationctid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.id(basecurrencyid)).click();
        driver.findElement(By.xpath(sgdbcid)).click();
        driver.findElement(By.xpath(gstApplicabletrue)).click();
        driver.findElement(By.id(chargeamount)).sendKeys(frstamount);
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberidvalue1)).click();
        driver.findElement(By.id(refundableid)).click();
        driver.findElement(By.xpath(tagtoregistrationtrue)).click();

        // Find the elements to highlight
        List<WebElement> elements = List.of(
                driver.findElement(By.id(chargeitemname)),
                driver.findElement(By.xpath("(//div[@class='ant-select-selector'])[2]")),
                driver.findElement(By.id(chargeitemdesc)),
                driver.findElement(By.xpath("(//div[@class='ant-select-selector'])[3]")),
                driver.findElement(By.xpath("//div[@id='charge-item-create_gstApplicable']//span[contains(text(),'Yes')]")),
                driver.findElement(By.id(chargeamount)),
                driver.findElement(By.xpath("(//div[@class='ant-select-selector'])[4]")),
                driver.findElement(By.xpath("//div[contains(@class, 'ant-form-item-control-input-content')]//span[@class='ant-checkbox-inner']")),
                driver.findElement(By.xpath("//div[@id='charge-item-create_tagToRegistration']//span[contains(text(),'Yes')]"))
        );

        // Highlight the elements
        highlightElements(driver, elements);
        Thread.sleep(500);

        // Take a screenshot
        Screenshot();


//        driver.findElement(By.xpath(savebtn)).click();


//        Need to remove these lines in actual testing
        driver.findElement(By.xpath(xbtn)).click();
        driver.findElement(By.xpath(modalOkBtn)).click();
//        Need to remove these lines in actual testing


        //    Assertion

        driver.findElement(By.xpath(searchci)).sendKeys(searchitemvalue2);
        action.sendKeys(Keys.ENTER).perform();

        // Find all rows in the table
        List<WebElement> searchRows = driver.findElements(By.xpath(itemRow));
        List<String> cType = new ArrayList<String>();


        int searchRegistrationCount = 0;
        for (WebElement searchRow : searchRows) {
            // Find the status column cell
            String searchTypeCell = searchRow.findElement(By.xpath(searchCItemTypeList)).getText();
            String searchChargeitem = searchRow.findElement(By.xpath(searchCItemNameList)).getText();

            if (searchChargeitem.equalsIgnoreCase(searchitemvalue2) && searchTypeCell.equalsIgnoreCase(registrationvalue)) {
                cType.add(searchTypeCell);
                searchRegistrationCount++;

                if (searchRegistrationCount == 1) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        Assert.assertEquals(searchRegistrationCount, 1);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 2, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To create/save a new charge item with \"Admin\" charge type value\n")
    public void UC_LH_CLS_CI_01_01_02() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        // Take a screenshot
        Screenshot();

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue2);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(adminctid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.id(basecurrencyid)).click();
        driver.findElement(By.xpath(usdbcid)).click();
        driver.findElement(By.xpath(gstapplicablefalse)).click();
        driver.findElement(By.id(chargeamount)).sendKeys(secndamount);
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberidvalue2)).click();
        driver.findElement(By.xpath(tagtoregistrationfalse)).click();
        driver.findElement(By.id(profitcentreid)).click();
        driver.findElement(By.xpath(profitCentreIdValue1)).click();

        // Take a screenshot
        Screenshot();

//        driver.findElement(By.xpath(savebtn)).click();

//    Need to remove these lines in actual testing
        driver.findElement(By.xpath(xbtn)).click();
        driver.findElement(By.xpath(modalOkBtn)).click();

//     Need to remove these lines in actual testing

        //    Assertion

        driver.findElement(By.xpath(searchci)).sendKeys(searchitemvalue2);
        action.sendKeys(Keys.ENTER).perform();

        // Find all rows in the table
        List<WebElement> searchRows = driver.findElements(By.xpath(itemRow));
        List<String> cType = new ArrayList<String>();


        int searchAdminCount = 0;
        for (WebElement searchRow : searchRows) {
            // Find the status column cell
            String searchTypeCell = searchRow.findElement(By.xpath(searchCItemTypeList)).getText();
            String searchChargeitem = searchRow.findElement(By.xpath(searchCItemNameList)).getText();

            if (searchChargeitem.equalsIgnoreCase(searchitemvalue2) && searchTypeCell.equalsIgnoreCase(registrationvalue)) {
                cType.add(searchTypeCell);
                searchAdminCount++;

                if (searchAdminCount == 1) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        Assert.assertEquals(searchAdminCount, 1);



    }


    @Test(groups = {"smokeTest", "regressionTest"}, priority = 3, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To create/save a new charge item with \"Duplicate Invoice\" charge type value\n")
    public void UC_LH_CLS_CI_01_01_03() {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement create_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue3);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(duplicateinvoiceid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberidvalue3)).click();
        driver.findElement(By.xpath(tagtoregistrationfalse)).click();
        driver.findElement(By.id(profitcentreid)).click();
        driver.findElement(By.xpath(profitCentreIdValue2)).click();

//        driver.findElement(By.xpath(savebtn)).click();

//    Need to remove these lines in actual testing
        driver.findElement(By.xpath(xbtn)).click();
        driver.findElement(By.xpath(modalOkBtn)).click();

//     Need to remove these lines in actual testing

        //    Assertion

        driver.findElement(By.xpath(searchci)).sendKeys(searchitemvalue2);
        action.sendKeys(Keys.ENTER).perform();

        // Find all rows in the table
        List<WebElement> searchRows = driver.findElements(By.xpath(itemRow));
        List<String> cType = new ArrayList<String>();


        int searchDICount = 0;
        for (WebElement searchRow : searchRows) {
            // Find the status column cell
            String searchTypeCell = searchRow.findElement(By.xpath(searchCItemTypeList)).getText();
            String searchChargeitem = searchRow.findElement(By.xpath(searchCItemNameList)).getText();

            if (searchChargeitem.equalsIgnoreCase(searchitemvalue2) && searchTypeCell.equalsIgnoreCase(registrationvalue)) {
                cType.add(searchTypeCell);
                searchDICount++;

                if (searchDICount == 1) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        Assert.assertEquals(searchDICount, 1);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 4, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To create/save a new charge item with \"General\" charge type value\n")
    public void UC_LH_CLS_CI_01_01_04() {


        // Launch website

        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement create_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue4);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(generalid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberidvalue4)).click();


//        driver.findElement(By.xpath(savebtn)).click();

//    Need to remove these lines in actual testing
        driver.findElement(By.xpath(xbtn)).click();
        driver.findElement(By.xpath(modalOkBtn)).click();

//     Need to remove these lines in actual testing

        //    Assertion

        driver.findElement(By.xpath(searchci)).sendKeys(searchitemvalue2);
        action.sendKeys(Keys.ENTER).perform();

        // Find all rows in the table
        List<WebElement> searchRows = driver.findElements(By.xpath(itemRow));
        List<String> cType = new ArrayList<String>();


        int searchGeneralCount = 0;
        for (WebElement searchRow : searchRows) {
            // Find the status column cell
            String searchTypeCell = searchRow.findElement(By.xpath(searchCItemTypeList)).getText();
            String searchChargeitem = searchRow.findElement(By.xpath(searchCItemNameList)).getText();

            if (searchChargeitem.equalsIgnoreCase(searchitemvalue2) && searchTypeCell.equalsIgnoreCase(registrationvalue)) {
                cType.add(searchTypeCell);
                searchGeneralCount++;

                if (searchGeneralCount == 1) {
                    break;
                }
            }

        }

        // Take a screenshot
        Screenshot();

        Assert.assertEquals(searchGeneralCount, 1);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 5, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To create/save a new charge item with existing name\n")
    public void UC_LH_CLS_CI_01_01_05() {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.id(chargeitemname)).sendKeys(existingchargeitemvalue1);
        driver.findElement(By.id(chargeitemname));
        action.sendKeys(Keys.TAB).perform();

//        driver.findElement(By.xpath(savebtn)).click();

//    Assertion

        WebElement error_message = driver.findElement(By.xpath(errormessage1));
        String expected_error = expectederrorvalue1;
        Assert.assertEquals(error_message.getText(), expected_error);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 6, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To create/save a new charge item with blank charge item name")
    public void UC_LH_CLS_CI_01_01_06_1() {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(adminctid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberidvalue1)).click();
        driver.findElement(By.xpath(savebtn)).click();

//    Assertion

        WebElement error_message = driver.findElement(By.xpath(mandatoryerrormessage1));
        String expected_error = mandatoryerrorvalue1;
        Assert.assertEquals(error_message.getText(), expected_error);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 7, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To create/save a new charge item without charge type")
    public void UC_LH_CLS_CI_01_01_06_2() {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue6);
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberidvalue2)).click();
        driver.findElement(By.xpath(savebtn)).click();

//    Assertion

        WebElement error_message = driver.findElement(By.xpath(mandatoryerrormessage1));
        String expected_error = mandatoryerrorvalue2;
        Assert.assertEquals(error_message.getText(), expected_error);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 8, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To create/save a new charge item with blank charge description")
    public void UC_LH_CLS_CI_01_01_06_3() {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue6);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(duplicateinvoiceid)).click();
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberidvalue3)).click();
        driver.findElement(By.xpath(savebtn)).click();

//    Assertion

        WebElement error_message = driver.findElement(By.xpath(mandatoryerrormessage1));
        String expected_error = mandatoryerrorvalue1;
        Assert.assertEquals(error_message.getText(), expected_error);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 9, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To create/save a new charge item without GL Number")
    public void UC_LH_CLS_CI_01_01_06_4() {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
//        jse.executeScript("arguments[0].click()", create_btn);
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue6);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(generalid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.xpath(savebtn)).click();

//    Assertion

        WebElement error_message = driver.findElement(By.xpath(mandatoryerrormessage1));
        String expected_error = mandatoryerrorvalue2;
        Assert.assertEquals(error_message.getText(), expected_error);

    }

    @Test(groups = {"regressionTest"}, priority = 10, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To validate cancellation message using cancel button\n")
    public void UC_LH_CLS_CI_01_01_07_1() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue7);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(generalid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.id(glnumberid)).click();
        WebElement glNumberValue = driver.findElement(By.xpath(glnumberidvalue4));
        jse.executeScript("arguments[0].scrollIntoView(true);", glNumberValue);
        driver.findElement(By.xpath(cancelBtn)).click();

//    Assertion

        WebElement confirm_message = driver.findElement(By.xpath(modalConfirmContent));
        String expected_message = expectederrorvalue2;
        Assert.assertEquals(confirm_message.getText(), expected_message);


    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 11, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel an ongoing creation of a charge item using cancel button\n")
    public void UC_LH_CLS_CI_01_01_07_2() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue7);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(generalid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberidvalue4)).click();
        driver.findElement(By.xpath(cancelBtn)).click();
        driver.findElement(By.xpath(modalOkBtn)).click();

//    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"regressionTest"}, priority = 12, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To validate cancellation message using x button\n")
    public void UC_LH_CLS_CI_01_01_08_1() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue8);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(generalid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberidvalue4)).click();
        driver.findElement(By.xpath(xbtn)).click();

//    Assertion

        WebElement confirm_message = driver.findElement(By.xpath(modalConfirmContent));
        String expected_message = expectederrorvalue2;
        Assert.assertEquals(confirm_message.getText(), expected_message);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 13, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel an ongoing creation of a charge item using x button\n")
    public void UC_LH_CLS_CI_01_01_08_2() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue8);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(generalid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberidvalue4)).click();
        driver.findElement(By.xpath(xbtn)).click();
        driver.findElement(By.xpath(modalOkBtn)).click();

//    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 14, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To disregard an ongoing cancel creation of a charge item using cancel button\n")
    public void UC_LH_CLS_CI_01_01_09() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue9);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(generalid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberidvalue4)).click();
        driver.findElement(By.xpath(cancelBtn)).click();
        driver.findElement(By.xpath(modalcancelbtn)).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = createChargeItemUrl;
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 15, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel a newly launch unmodified form using cancel button\n")
    public void UC_LH_CLS_CI_01_01_10() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(cancelBtn)).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);


    }

    @Test(groups = {"regressionTest"}, priority = 16, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel a newly launch unmodified form using x button\n")
    public void UC_LH_CLS_CI_01_01_11() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(xbtn)).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);

    }


    @Test(groups = {"regressionTest"}, priority = 17, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel a newly launch unmodified form using Esc button in keyboard\n")
    public void UC_LH_CLS_CI_01_01_12() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement chargename = driver.findElement(By.id(chargeitemname));
        action.click(chargename).sendKeys(Keys.ESCAPE).perform();

        //    Assertion
        Thread.sleep(1000);
        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"regressionTest"}, priority = 18, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify maximum input of 200 characters in \"Description\" field\n")
    public void UC_LH_CLS_CI_01_01_13() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue13);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(generalid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription2);

        //    Assertion

        WebElement max_length = driver.findElement(By.xpath(maxtextarea));

        String expected_length = expectedlength1;
        Assert.assertEquals(max_length.getText(), expected_length);
    }

    @Test(groups = {"regressionTest"}, priority = 19, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify drawer title")
    public void UC_LH_CLS_CI_01_01_14() throws InterruptedException {


        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        WebElement drawer_title = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(createdrawertitle)));

        String expected_title = createdrawertitlevalue;
        Assert.assertEquals(drawer_title.getText(), expected_title);

    }

}
