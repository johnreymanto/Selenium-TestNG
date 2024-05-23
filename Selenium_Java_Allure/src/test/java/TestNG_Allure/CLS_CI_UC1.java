package TestNG_Allure;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriver;
import java.time.Duration;


public class CLS_CI_UC1 extends BaseDriver {

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 1)
    @Description("To create/save a new charge item with \"Registration\" charge type value\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_01_01() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//a[@href='/billing/billing-configuration']")).click();
        driver.findElement(By.xpath("//a[@href='/billing/billing-configuration/charge-items']")).click();
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
        WebElement charge_name = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='charge-item-create_name']")));
        charge_name.sendKeys("UCCITest#01");
        WebElement charge_type = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='charge-item-create_chargeTypeId']")));
        charge_type.click();
        driver.findElement(By.xpath("//div[@title='Registration']")).click();
        driver.findElement(By.id("charge-item-create_description")).sendKeys("For testing");
        driver.findElement(By.id("charge-item-create_baseCurrencyId")).click();
        driver.findElement(By.xpath("//div[@title='SGD']")).click();
        driver.findElement(By.xpath("//div[@id='charge-item-create_gstApplicable']//input[@class='ant-radio-input' and @value='true']")).click();
        driver.findElement(By.id("charge-item-create_amount")).sendKeys("500");
        driver.findElement(By.id("charge-item-create_glNumberId")).click();
        driver.findElement(By.xpath("//div[@title='001']")).click();
        driver.findElement(By.id("charge-item-create_refundable")).click();
        driver.findElement(By.xpath("//div[@id='charge-item-create_tagToRegistration']//input[@class='ant-radio-input' and @value='true']")).click();

//        wait.until(EC.visibility_of_element_located((By.XPATH, "//div[@id='charge-item-create_tagToRegistration']//label[@class='ant-radio-wrapper ant-radio-wrapper-in-form-itemcss-lg6yg']//span[@class='ant-radio ant-wave-target']//input[@class='ant-radio-input']"))).click()
//        driver.find_element(By.XPATH, "//button[@class='ant-btn css-lg6yg ant-btn-primary']//span[contains(text(), 'Save')]").click()

//        Need to remove these lines in actual testing
        driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'confirm-modal-ok-btn')]")).click();
//        Need to remove these lines in actual testing

//    Assertion
        driver.findElement(By.xpath("//input[@placeholder='Search by charge item']")).sendKeys("UC_CI_Test#02");
        action.sendKeys(Keys.ENTER).perform();

        WebElement item = driver.findElement(By.xpath("//td[@class='ant-table-cell ant-table-cell-ellipsis'][1]"));

        String expected_value = "UC_CI_Test#02";
        Assert.assertEquals(item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 2)
    @Description("To create/save a new charge item with \"Admin\" charge type value\n")
    public void UC_LH_CLS_CI_01_01_02() throws InterruptedException {

        //        ActionChains
        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
//        driver.findElement(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")).click();
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
//        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
        create_btn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        WebElement charge_name = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("charge-item-create_name")));
        charge_name.sendKeys("UCCITest#02");
        WebElement charge_type = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='charge-item-create_chargeTypeId']")));
        charge_type.click();
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

//  ActionChains
        Actions action = new Actions(driver);

//  JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
        WebElement charge_name = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='charge-item-create_name']")));
        charge_name.sendKeys("UCCITest#03");
        WebElement charge_type = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='charge-item-create_chargeTypeId']")));
        charge_type.click();
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

//  ActionChains
        Actions action = new Actions(driver);

//  JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
        WebElement charge_name = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='charge-item-create_name']")));
        charge_name.sendKeys("UC_CITest#04");
        WebElement charge_type = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='charge-item-create_chargeTypeId']")));
        charge_type.click();
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

//  ActionChains
        Actions action = new Actions(driver);

//  JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
        WebElement charge_name = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='charge-item-create_name']")));
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

//  ActionChains
        Actions action = new Actions(driver);

//  JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
//        WebElement charge_type = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='ant-select-selector'])[1]")));
//        charge_type.click();
        driver.findElement(By.xpath("//input[@id='charge-item-create_chargeTypeId']")).click();
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

//  ActionChains
        Actions action = new Actions(driver);

//  JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
        WebElement charge_name = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='charge-item-create_name']")));
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

//  ActionChains
        Actions action = new Actions(driver);

//  JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement charge_name = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='charge-item-create_name']")));
        charge_name.sendKeys("UCCITest#06");
        Thread.sleep(500);
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

//  ActionChains
        Actions action = new Actions(driver);

//  JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement charge_name = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='charge-item-create_name']")));
        charge_name.sendKeys("UCCITest#06");
        Thread.sleep(500);
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

//  ActionChains
        Actions action = new Actions(driver);

//  JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
        WebElement charge_name = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='charge-item-create_name']")));
        charge_name.sendKeys("UCCITest#07");
        WebElement charge_type = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='charge-item-create_chargeTypeId']")));
        charge_type.click();
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

//  ActionChains
        Actions action = new Actions(driver);

//  JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
        WebElement charge_name = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='charge-item-create_name']")));
        charge_name.sendKeys("UCCITest#07");
//        driver.findElement(By.xpath("//input[@id='charge-item-create_chargeTypeId']")).click();
        WebElement charge_type = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='charge-item-create_chargeTypeId']")));
        charge_type.click();
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

//  ActionChains
        Actions action = new Actions(driver);

//  JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
        WebElement charge_name = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='charge-item-create_name']")));
        charge_name.sendKeys("UCCITest#08");
        WebElement charge_type = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='charge-item-create_chargeTypeId']")));
        charge_type.click();
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

//  ActionChains
        Actions action = new Actions(driver);

//  JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
        WebElement charge_name = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='charge-item-create_name']")));
        charge_name.sendKeys("UCCITest#08");
        WebElement charge_type = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='charge-item-create_chargeTypeId']")));
        charge_type.click();
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

//  ActionChains
        Actions action = new Actions(driver);

//  JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
        WebElement charge_name = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='charge-item-create_name']")));
        charge_name.sendKeys("UCCITest#09");
//        WebElement charge_type = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='charge-item-create_chargeTypeId']")));
//        charge_type.click();
        driver.findElement(By.xpath("//input[@id='charge-item-create_chargeTypeId']")).click();
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

//  ActionChains
        Actions action = new Actions(driver);

//  JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
        WebElement cancel_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-default')]//span[contains(text(), 'Cancel')]")));
        cancel_btn.click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items";
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 16)
    @Description("To cancel a newly launch unmodified form using x button\n")
    public void UC_LH_CLS_CI_01_01_11() throws InterruptedException {

//  ActionChains
        Actions action = new Actions(driver);

//  JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
        WebElement x_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Close']")));
        x_btn.click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items";
        Assert.assertEquals(get_url, expected_url);

    }


    @Test(groups = {"smokeTest", "regressionTest"}, priority = 17)
    @Description("To cancel a newly launch unmodified form using x button\n")
    public void UC_LH_CLS_CI_01_01_12() throws InterruptedException {

//  ActionChains
        Actions action = new Actions(driver);

//  JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
        Thread.sleep(2000);
        WebElement escape_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='charge-item-create_name']")));
        action.click().sendKeys(Keys.ESCAPE).perform();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items";
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 18)
    @Description("To verify maximum input of 200 characters in \"Description\" field\n")
    public void UC_LH_CLS_CI_01_01_13() throws InterruptedException {

//  ActionChains
        Actions action = new Actions(driver);

//  JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
        WebElement charge_name = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='charge-item-create_name']")));
        charge_name.sendKeys("UCCITest#12");
        WebElement charge_type = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='charge-item-create_chargeTypeId']")));
        charge_type.click();
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

//  ActionChains
        Actions action = new Actions(driver);

//  JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement create_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Create')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", create_btn);
        Thread.sleep(2000);
        //    Assertion

        WebElement drawer_title = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Create charge item']")));

        String expected_title = "Create charge item";
        Assert.assertEquals(drawer_title.getText(), expected_title);

        System.out.println(expected_title);

    }
}
