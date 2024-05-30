package TestNG_Allure;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import Utility.BaseDriver;
import java.time.Duration;
import static Utility.StringData.*;
import static Utility.StringLocator.*;


public class CLS_CI_UC1 extends BaseDriver {

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 1)
    @Description("To create/save a new charge item with \"Registration\" charge type value\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_01_01() throws InterruptedException {


        // Launch website
        driver.get(billingurlpage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath(billconfiglocator)).click();
        driver.findElement(By.xpath(chargeitempage)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement charge_name = driver.findElement(By.id(chargeitemname));
        charge_name.sendKeys(frstchargeitemvalue);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(registrationctid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription);
        driver.findElement(By.id(basecurrencyid)).click();
        driver.findElement(By.xpath(sgdbcid)).click();
        driver.findElement(By.xpath(gstapplicable)).click();
        driver.findElement(By.id(chargeamount)).sendKeys(frstamount);
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberid1)).click();
        driver.findElement(By.id(refundableid)).click();
        driver.findElement(By.xpath(tagtoregistration)).click();

//        driver.findElement(By.xpath(savebtn)).click();


//        Need to remove these lines in actual testing
        driver.findElement(By.xpath(xbtn)).click();
        driver.findElement(By.xpath(modalokbtn)).click();
//        Need to remove these lines in actual testing

//    Assertion
        driver.findElement(By.xpath(searchci)).sendKeys(chargeitemvalue2);
        action.sendKeys(Keys.ENTER).perform();

        WebElement item = driver.findElement(By.xpath(searchcitem));

        String expected_value = expectedvalue1;
        Assert.assertEquals(item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 2)
    @Description("To create/save a new charge item with \"Admin\" charge type value\n")
    public void UC_LH_CLS_CI_01_01_02() throws InterruptedException {

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement charge_name = driver.findElement(By.id("charge-item-create_name"));
        charge_name.sendKeys("UCCITest#02");
        driver.findElement(By.id("charge-item-create_chargeTypeId")).click();
        driver.findElement(By.xpath("//div[@title='Admin']")).click();
        driver.findElement(By.id("charge-item-create_description")).sendKeys("For testing");
        driver.findElement(By.id("charge-item-create_baseCurrencyId")).click();
        driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][contains(text(),'USD')]")).click();
        driver.findElement(By.xpath("//div[@id='charge-item-create_gstApplicable']//input[@class='ant-radio-input' and @value='false']")).click();
        driver.findElement(By.id("charge-item-create_amount")).sendKeys("600.50");
        driver.findElement(By.id("charge-item-create_glNumberId")).click();
        driver.findElement(By.xpath("//div[@title='002']")).click();
        driver.findElement(By.xpath("//div[@id='charge-item-create_tagToRegistration']//input[@class='ant-radio-input' and @value='false']")).click();
        driver.findElement(By.id("charge-item-create_profitCentreId")).click();
        driver.findElement(By.xpath("//div[@title='PC 1']")).click();

//        driver.find_element(By.XPATH, "//button[@class='ant-btn css-lg6yg ant-btn-primary']//span[contains(text(), 'Save')]").click()

//    Need to remove these lines in actual testing
        driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'confirm-modal-ok-btn')]")).click();

//     Need to remove these lines in actual testing

//    Assertion
        driver.findElement(By.xpath("//input[@placeholder='Search by charge item']")).sendKeys("UC_CI_Test#02");
        action.sendKeys(Keys.ENTER).perform();

        WebElement item = driver.findElement(By.xpath("//td[@class='ant-table-cell ant-table-cell-ellipsis'][1]"));

        String expected_value = "UC_CI_Test#02";
        Assert.assertEquals(item.getText(), expected_value);


    }


    @Test(groups = {"smokeTest", "regressionTest"}, priority = 3)
    @Description("To create/save a new charge item with \"Duplicate Invoice\" charge type value\n")
    public void UC_LH_CLS_CI_01_01_03() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement charge_name = driver.findElement(By.id("charge-item-create_name"));
        charge_name.sendKeys("UCCITest#03");
        driver.findElement(By.id("charge-item-create_chargeTypeId")).click();
        driver.findElement(By.xpath("//div[@title='Duplicate Invoice']")).click();
        driver.findElement(By.id("charge-item-create_description")).sendKeys("For testing");
        driver.findElement(By.id("charge-item-create_glNumberId")).click();
        driver.findElement(By.xpath("//div[@title='005']")).click();
        driver.findElement(By.xpath("//div[@id='charge-item-create_tagToRegistration']//input[@class='ant-radio-input' and @value='false']")).click();
        driver.findElement(By.id("charge-item-create_profitCentreId")).click();
        driver.findElement(By.xpath("//div[@title='PC 2']")).click();
//        driver.findElement(By.xpath("//button[@class='ant-btn css-lg6yg ant-btn-primary']//span[contains(text(), 'Save')]")).click();

//    Need to remove these lines in actual testing
        driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'confirm-modal-ok-btn')]")).click();

//    Need to remove these lines in actual testing

//    Assertion
        driver.findElement(By.xpath("//input[@placeholder='Search by charge item']")).sendKeys("UC_CI_Test#02");
        action.sendKeys(Keys.ENTER).perform();

        WebElement item = driver.findElement(By.xpath("//td[@class='ant-table-cell ant-table-cell-ellipsis'][1]"));

        String expected_value = "UC_CI_Test#02";
        Assert.assertEquals(item.getText(), expected_value);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 4)
    @Description("To create/save a new charge item with \"General\" charge type value\n")
    public void UC_LH_CLS_CI_01_01_04() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement charge_name = driver.findElement(By.id("charge-item-create_name"));
        charge_name.sendKeys("UC_CITest#04");
        driver.findElement(By.id("charge-item-create_chargeTypeId")).click();
        driver.findElement(By.xpath("//div[@title='General']")).click();
        driver.findElement(By.id("charge-item-create_description")).sendKeys("For testing");
        driver.findElement(By.id("charge-item-create_glNumberId")).click();
        driver.findElement(By.xpath("//div[@title='006']")).click();
//        driver.findElement(By.xpath("//button[@class='ant-btn css-lg6yg ant-btn-primary']//span[contains(text(), 'Save')]")).click();

//    Need to remove these lines in actual testing
        driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'confirm-modal-ok-btn')]")).click();
//    Need to remove these lines in actual testing

//    Assertion
        driver.findElement(By.xpath("//input[@placeholder='Search by charge item']")).sendKeys("UC_CI_Test#02");
        action.sendKeys(Keys.ENTER).perform();

        WebElement item = driver.findElement(By.xpath("//td[@class='ant-table-cell ant-table-cell-ellipsis'][1]"));

        String expected_value = "UC_CI_Test#02";
        Assert.assertEquals(item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 5)
    @Description("To create/save a new charge item with existing name\n")
    public void UC_LH_CLS_CI_01_01_05() {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement charge_name = driver.findElement(By.id("charge-item-create_name"));
        charge_name.sendKeys("UC_CI_Test#01");
        driver.findElement(By.id("charge-item-create_name"));
        action.sendKeys(Keys.TAB).perform();

//        driver.findElement(By.xpath("//button[@class='ant-btn css-lg6yg ant-btn-primary']//span[contains(text(), 'Save')]")).click();

//    Assertion

        WebElement error_message = driver.findElement(By.xpath("//div[@id='charge-item-create_name_help']//div[@class='ant-form-item-explain-error']"));
        String expected_error = "There is an existing charge item with the same name.";
        Assert.assertEquals(error_message.getText(), expected_error);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 6)
    @Description("To create/save a new charge item with blank charge item name")
    public void UC_LH_CLS_CI_01_01_06_1() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.id("charge-item-create_chargeTypeId")).click();
        driver.findElement(By.xpath("//div[@title='Admin']")).click();
        driver.findElement(By.id("charge-item-create_description")).sendKeys("For testing");
        driver.findElement(By.id("charge-item-create_glNumberId")).click();
        driver.findElement(By.xpath("//div[@title='001']")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Save')]")).click();

//    Assertion

        WebElement error_message = driver.findElement(By.xpath("//div[@class='ant-form-item-explain-error']"));
        String expected_error = "Enter a value to proceed.";
        Assert.assertEquals(error_message.getText(), expected_error);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 7)
    @Description("To create/save a new charge item without charge type")
    public void UC_LH_CLS_CI_01_01_06_2() {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement charge_name = driver.findElement(By.id("charge-item-create_name"));
        charge_name.sendKeys("UCCITest#06");
        driver.findElement(By.id("charge-item-create_description")).sendKeys("For testing");
        driver.findElement(By.id("charge-item-create_glNumberId")).click();
        driver.findElement(By.xpath("//div[@title='002']")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Save')]")).click();

//    Assertion

        WebElement error_message = driver.findElement(By.xpath("//div[@class='ant-form-item-explain-error']"));
        String expected_error = "Select a value to proceed.";
        Assert.assertEquals(error_message.getText(), expected_error);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 8)
    @Description("To create/save a new charge item with blank charge description")
    public void UC_LH_CLS_CI_01_01_06_3() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement charge_name = driver.findElement(By.id("charge-item-create_name"));
        charge_name.sendKeys("UCCITest#06");
        driver.findElement(By.id("charge-item-create_chargeTypeId")).click();
        driver.findElement(By.xpath("//div[@title='Duplicate Invoice']")).click();
        driver.findElement(By.id("charge-item-create_glNumberId")).click();
        driver.findElement(By.xpath("//div[@title='005']")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Save')]")).click();

//    Assertion

        WebElement error_message = driver.findElement(By.xpath("//div[@class='ant-form-item-explain-error']"));
        String expected_error = "Enter a value to proceed.";
        Assert.assertEquals(error_message.getText(), expected_error);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 9)
    @Description("To create/save a new charge item without GL Number")
    public void UC_LH_CLS_CI_01_01_06_4() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement charge_name = driver.findElement(By.id("charge-item-create_name"));
        charge_name.sendKeys("UCCITest#06");
        driver.findElement(By.id("charge-item-create_chargeTypeId")).click();
        driver.findElement(By.xpath("//div[@title='General']")).click();
        driver.findElement(By.id("charge-item-create_description")).sendKeys("For testing");
        driver.findElement(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Save')]")).click();

//    Assertion

        WebElement error_message = driver.findElement(By.xpath("//div[@class='ant-form-item-explain-error']"));
        String expected_error = "Select a value to proceed.";
        Assert.assertEquals(error_message.getText(), expected_error);

        WebElement create_item = driver.findElement(By.xpath("//input[@id='charge-item-create_name']"));

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 10)
    @Description("To validate cancellation message using cancel button\n")
    public void UC_LH_CLS_CI_01_01_07_1() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement charge_name = driver.findElement(By.id("charge-item-create_name"));
        charge_name.sendKeys("UCCITest#07");
        driver.findElement(By.id("charge-item-create_chargeTypeId")).click();
        driver.findElement(By.xpath("//div[@title='General']")).click();
        driver.findElement(By.id("charge-item-create_description")).sendKeys("For testing");
        driver.findElement(By.id("charge-item-create_glNumberId")).click();
        driver.findElement(By.xpath("//div[@title='006']")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'ant-btn-default')]//span[contains(text(), 'Cancel')]")).click();

//    Assertion

        WebElement confirm_message = driver.findElement(By.xpath("//div[@class='ant-modal-confirm-content']"));
        String expected_message = "You are about to cancel your entry and your configurations will not be saved. Are you sure you want to proceed?";
        Assert.assertEquals(confirm_message.getText(), expected_message);


    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 11)
    @Description("To cancel an ongoing creation of a charge item using cancel button\n")
    public void UC_LH_CLS_CI_01_01_07_2() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement charge_name = driver.findElement(By.id("charge-item-create_name"));
        charge_name.sendKeys("UCCITest#07");
        driver.findElement(By.id("charge-item-create_chargeTypeId")).click();
        driver.findElement(By.xpath("//div[@title='General']")).click();
        driver.findElement(By.id("charge-item-create_description")).sendKeys("For testing");
        driver.findElement(By.id("charge-item-create_glNumberId")).click();
        driver.findElement(By.xpath("//div[@title='006']")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'ant-btn-default')]//span[contains(text(), 'Cancel')]")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'confirm-modal-ok-btn')]")).click();

//    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items";
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 12)
    @Description("To validate cancellation message using x button\n")
    public void UC_LH_CLS_CI_01_01_08_1() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement charge_name = driver.findElement(By.id("charge-item-create_name"));
        charge_name.sendKeys("UCCITest#08");
        driver.findElement(By.id("charge-item-create_chargeTypeId")).click();
        driver.findElement(By.xpath("//div[@title='General']")).click();
        driver.findElement(By.id("charge-item-create_description")).sendKeys("For testing");
        driver.findElement(By.id("charge-item-create_glNumberId")).click();
        driver.findElement(By.xpath("//div[@title='006']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Close']")).click();

//    Assertion

        WebElement confirm_message = driver.findElement(By.xpath("//div[@class='ant-modal-confirm-content']"));
        String expected_message = "You are about to cancel your entry and your configurations will not be saved. Are you sure you want to proceed?";
        Assert.assertEquals(confirm_message.getText(), expected_message);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 13)
    @Description("To cancel an ongoing creation of a charge item using x button\n")
    public void UC_LH_CLS_CI_01_01_08_2() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement charge_name = driver.findElement(By.id("charge-item-create_name"));
        charge_name.sendKeys("UCCITest#08");
        driver.findElement(By.id("charge-item-create_chargeTypeId")).click();
        driver.findElement(By.xpath("//div[@title='General']")).click();
        driver.findElement(By.id("charge-item-create_description")).sendKeys("For testing");
        driver.findElement(By.id("charge-item-create_glNumberId")).click();
        driver.findElement(By.xpath("//div[@title='006']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'confirm-modal-ok-btn')]")).click();

//    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items";
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 14)
    @Description("To disregard an ongoing cancel creation of a charge item using cancel button\n")
    public void UC_LH_CLS_CI_01_01_09() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement charge_name = driver.findElement(By.id("charge-item-create_name"));
        charge_name.sendKeys("UCCITest#09");
        driver.findElement(By.id("charge-item-create_chargeTypeId")).click();
        driver.findElement(By.xpath("//div[@title='General']")).click();
        driver.findElement(By.id("charge-item-create_description")).sendKeys("For testing");
        driver.findElement(By.id("charge-item-create_glNumberId")).click();
        driver.findElement(By.xpath("//div[@title='006']")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'ant-btn-default')]//span[contains(text(), 'Cancel')]")).click();
        driver.findElement(By.xpath("(//button[contains(@class, 'ant-btn-default')]//span[contains(text(), 'Cancel')])[2]")).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items/create";
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 15)
    @Description("To cancel a newly launch unmodified form using cancel button\n")
    public void UC_LH_CLS_CI_01_01_10() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement cancel_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'ant-btn-default')]//span[contains(text(), 'Cancel')]")));
        cancel_btn.click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items";
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 16)
    @Description("To cancel a newly launch unmodified form using x button\n")
    public void UC_LH_CLS_CI_01_01_11() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement x_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@aria-label='Close']")));
        x_btn.click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items";
        Assert.assertEquals(get_url, expected_url);

    }


    @Test(groups = {"smokeTest", "regressionTest"}, priority = 17)
    @Description("To cancel a newly launch unmodified form using x button\n")
    public void UC_LH_CLS_CI_01_01_12() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.id("charge-item-create_name"));
        Thread.sleep(200);
        action.click().sendKeys(Keys.ESCAPE).perform();
        Thread.sleep(500);

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items";
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 18)
    @Description("To verify maximum input of 200 characters in \"Description\" field\n")
    public void UC_LH_CLS_CI_01_01_13() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement charge_name = driver.findElement(By.id("charge-item-create_name"));
        charge_name.sendKeys("UCCITest#13");
        driver.findElement(By.id("charge-item-create_chargeTypeId")).click();
        driver.findElement(By.xpath("//div[@title='General']")).click();
        driver.findElement(By.id("charge-item-create_description")).sendKeys("FortestingFortestingFortestingFortestingFortestingFortestingFortestingFortestingFortestingFortestingFortestingFortestingFortestingFortestingFortestingFortestingFortestingFortestingFortestingFortestingF");

        //    Assertion

        WebElement max_length = driver.findElement(By.xpath("//span[@class='ant-input-suffix']//span[contains(text(), '200/200')]"));

        String expected_length = "200/200";
        Assert.assertEquals(max_length.getText(), expected_length);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 19)
    @Description("To verify drawer title")
    public void UC_LH_CLS_CI_01_01_14() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        //    Assertion

        WebElement drawer_title = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(), 'Create charge')]")));

        String expected_title = "Create charge item";
        Assert.assertEquals(drawer_title.getText(), expected_title);

    }



}
