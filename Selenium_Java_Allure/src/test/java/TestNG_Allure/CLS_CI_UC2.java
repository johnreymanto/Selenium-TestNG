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


public class CLS_CI_UC2 extends BaseDriver {

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 1)
    @Description("To view existing Charge items list details\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_01() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//a[@href='/billing/billing-configuration']")).click();
        driver.findElement(By.xpath("//a[@href='/billing/billing-configuration/charge-items']")).click();

//    Assertion
        WebElement item = driver.findElement(By.xpath("//div[contains(text(), 'Total')]"));
        String[] to_item = item.getText().split(" ");
        String expected_value = "69";
        Assert.assertEquals(to_item[1], expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 2)
    @Description("To filter all \"Active\" charge items\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_02() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement filter_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='filter-funnel-btn']")));
        javaScriptExecutor.executeScript("arguments[0].click()", filter_btn);
        WebElement status_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']")));
        javaScriptExecutor.executeScript("arguments[0].click()", status_btn);
        WebElement active_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='ACTIVE']")));
        javaScriptExecutor.executeScript("arguments[0].click()", active_btn);
        WebElement apply_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Apply')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", apply_btn);
//    Assertion
        int colCount = driver.findElements(By.xpath("//th[contains(@class, 'ant-table-column-has-sorters')]")).size();
        boolean chargeItemStatus = false;
        for (int i = 0; i < colCount; i++) {
            String val = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-cell-ellipsis')][9]")).getText();
            if (val.equals("Active")) {
                chargeItemStatus = true;

            } else {
                chargeItemStatus = false;
                break;
            }
        }

        //Assertion
        boolean expected_value = true;
        Assert.assertEquals(chargeItemStatus, expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 3)
    @Description("To filter all \"Inactive\" charge items\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_03() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement filter_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='filter-funnel-btn']")));
        javaScriptExecutor.executeScript("arguments[0].click()", filter_btn);
        WebElement status_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']")));
        javaScriptExecutor.executeScript("arguments[0].click()", status_btn);
        WebElement inactive_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='INACTIVE']")));
        javaScriptExecutor.executeScript("arguments[0].click()", inactive_btn);
        WebElement apply_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Apply')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", apply_btn);
//    Assertion
        int colCount = driver.findElements(By.xpath("//th[contains(@class, 'ant-table-column-has-sorters')]")).size();
        boolean chargeItemStatus = false;
        for (int i = 0; i < colCount; i++) {
            String val = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-cell-ellipsis')][9]")).getText();
            if (val.equals("Inactive")) {
                chargeItemStatus = true;

            } else {
                chargeItemStatus = false;
                break;
            }
        }

        //Assertion
        boolean expected_value = true;
        Assert.assertEquals(chargeItemStatus, expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 4)
    @Description("To Tick and Untick Active status checkbox in filter drawer\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_04() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement filter_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='filter-funnel-btn']")));
        javaScriptExecutor.executeScript("arguments[0].click()", filter_btn);
        WebElement status_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']")));
        javaScriptExecutor.executeScript("arguments[0].click()", status_btn);
        WebElement active_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='ACTIVE']")));
        javaScriptExecutor.executeScript("arguments[0].click()", active_btn);


//    Assertion

        try {
//    Try to find the element you are interested in
            WebElement selection = driver.findElement(By.xpath("//span[contains(@class, '_filter-header-tag')]"));
//    If element found, perform your actions or validations
            System.out.println("Element found!");
        } catch (NoSuchElementException e) {
//    If the element is not found, it indicates a validation failure
            boolean noSuchElem = true;

            Assert.assertEquals(noSuchElem, true);
        }
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 5)
    @Description("To Tick and Untick Inactive status checkbox in filter drawer\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_05() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement filter_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='filter-funnel-btn']")));
        javaScriptExecutor.executeScript("arguments[0].click()", filter_btn);
        WebElement status_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']")));
        javaScriptExecutor.executeScript("arguments[0].click()", status_btn);
        WebElement inactive_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='INACTIVE']")));
        javaScriptExecutor.executeScript("arguments[0].click()", inactive_btn);


//    Assertion

        try {
//    Try to find the element you are interested in
            WebElement selection = driver.findElement(By.xpath("//span[contains(@class, '_filter-header-tag')]"));
//    If element found, perform your actions or validations
            System.out.println("Element found!");
        } catch (NoSuchElementException e) {
//    If the element is not found, it indicates a validation failure
            boolean noSuchElem = true;

            Assert.assertEquals(noSuchElem, true);
        }
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 6)
    @Description("To filter both \"Active\" and \"Inactive\" charge items\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_06() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement filter_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='filter-funnel-btn']")));
        javaScriptExecutor.executeScript("arguments[0].click()", filter_btn);
        WebElement status_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']")));
        javaScriptExecutor.executeScript("arguments[0].click()", status_btn);
        Thread.sleep(2000);
        WebElement active_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='ACTIVE']")));
        active_btn.click();
        WebElement inactive_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='INACTIVE']")));
        inactive_btn.click();
        WebElement apply_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Apply')]")));
        apply_btn.click();
//    Assertion
        WebElement item = driver.findElement(By.xpath("//div[contains(text(), 'Total')]"));
        String[] to_item = item.getText().split(" ");
        String expected_value = "69";
        Assert.assertEquals(to_item[1], expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 7)
    @Description("To clear all active filters for charge items\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_07() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement filter_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='filter-funnel-btn']")));
        javaScriptExecutor.executeScript("arguments[0].click()", filter_btn);
        WebElement status_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']")));
        javaScriptExecutor.executeScript("arguments[0].click()", status_btn);
        WebElement active_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='ACTIVE']")));
        javaScriptExecutor.executeScript("arguments[0].click()", active_btn);
        WebElement inactive_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='INACTIVE']")));
        javaScriptExecutor.executeScript("arguments[0].click()", inactive_btn);
        WebElement clear_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Clear')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", clear_btn);

//    Assertion

        try {
//    Try to find the element you are interested in
            WebElement selection = driver.findElement(By.xpath("//span[contains(@class, '_filter-header-tag')]"));
//    If element found, perform your actions or validations
            System.out.println("Element found!");
        } catch (NoSuchElementException e) {
//    If the element is not found, it indicates a validation failure
            boolean noSuchElem = true;

            Assert.assertEquals(noSuchElem, true);
        }

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 8)
    @Description("To disregard selected filter/s on charge items\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_08() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement filter_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='filter-funnel-btn']")));
        javaScriptExecutor.executeScript("arguments[0].click()", filter_btn);
        WebElement status_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']")));
        javaScriptExecutor.executeScript("arguments[0].click()", status_btn);
        WebElement active_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='ACTIVE']")));
        javaScriptExecutor.executeScript("arguments[0].click()", active_btn);
        WebElement inactive_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='INACTIVE']")));
        javaScriptExecutor.executeScript("arguments[0].click()", inactive_btn);
        WebElement clear_btn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'ant-btn-default')]//span[contains(text(), 'Cancel')]")));
        javaScriptExecutor.executeScript("arguments[0].click()", clear_btn);

//    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items";
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 9)
    @Description("To search existing charge item using 3 minimum characters\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_09() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
        driver.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys("UC_");
        action.sendKeys(Keys.ENTER).perform();

//    Assertion
        int rows = driver.findElements(By.xpath("//td[contains(@class, 'ant-table-cell-ellipsis')][1]")).size();
        if (rows > 0) {
            boolean row = true;
            Assert.assertEquals(row, true);
        } else {
            System.out.println("No item found!");
        }
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 10)
    @Description("To search nonexistent charge item using 3 minimum characters\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_10() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
        driver.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys("UC2");
        action.sendKeys(Keys.ENTER).perform();

//    Assertion

        WebElement error_msg = driver.findElement(By.xpath("//div[contains(text(), 'No items')]"));
        String expectedError = "No items to show in this view.";
        Assert.assertEquals(error_msg.getText(), expectedError);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 11)
    @Description("To search using 1 character\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_11_1() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
        driver.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys("U");
        action.sendKeys(Keys.ENTER).perform();

//    Assertion

        WebElement error_msg = driver.findElement(By.xpath("//div[contains(text(), 'minimum of 3 alphanumeric characters')]"));
        String expectedError = "A minimum of 3 alphanumeric characters are required in order to perform search.";
        Assert.assertEquals(error_msg.getText(), expectedError);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 12)
    @Description("To search using 2 characters\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_11_2() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
        driver.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys("UC");
        action.sendKeys(Keys.ENTER).perform();

//    Assertion

        WebElement error_msg = driver.findElement(By.xpath("//div[contains(text(), 'minimum of 3 alphanumeric characters')]"));
        String expectedError = "A minimum of 3 alphanumeric characters are required in order to perform search.";
        Assert.assertEquals(error_msg.getText(), expectedError);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 13)
    @Description("To verify special characters accepted in search box\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_12() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
        driver.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys("#01");
        action.sendKeys(Keys.ENTER).perform();

//    Assertion
        int rows = driver.findElements(By.xpath("//td[contains(@class, 'ant-table-cell-ellipsis')][1]")).size();
        if (rows > 0) {
            boolean row = true;
            Assert.assertEquals(row, true);
        } else {
            System.out.println("No item found!");
        }

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 14)
    @Description("To search without any value\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_13() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
        driver.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys(" ");
        action.sendKeys(Keys.ENTER).perform();

//    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items?page=0";
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 15)
    @Description("To verify the total number of items in the list\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_14() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

//    Assertion

        WebElement item = driver.findElement(By.xpath("//div[contains(text(), 'Total')]"));
        String[] to_item = item.getText().split(" ");
        String expected_value = "69";
        Assert.assertEquals(to_item[1], expected_value);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 16)
    @Description("To verify that charge items list only displays 20 number of records on a single page.\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_15_1() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
        driver.findElement(By.xpath("//div[@class='ant-select-selector']")).click();
        driver.findElement(By.xpath("//div[@title='20']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        //    Assertion
        int rows = driver.findElements(By.xpath("//td[contains(@class, 'ant-table-cell-ellipsis')][1]")).size();
        if (rows > 10 && rows <= 20) {
            boolean row = true;
            Assert.assertEquals(row, true);
        } else {
            System.out.println("No item found!");
        }

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 17)
    @Description("To verify that charge items list only displays 50 number of records on a single page.\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_15_2() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
        driver.findElement(By.xpath("//div[@class='ant-select-selector']")).click();
        driver.findElement(By.xpath("//div[@title='50']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        //    Assertion
        int rows = driver.findElements(By.xpath("//td[contains(@class, 'ant-table-cell-ellipsis')][1]")).size();
        if (rows > 20 && rows <= 50) {
            boolean row = true;
            Assert.assertEquals(row, true);
        } else {
            System.out.println("No item found!");
        }

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 18)
    @Description("To verify that charge items list only displays 100 number of records on a single page.\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_15_3() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
        driver.findElement(By.xpath("//div[@class='ant-select-selector']")).click();
        driver.findElement(By.xpath("//div[@title='100']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        //    Assertion
        int rows = driver.findElements(By.xpath("//td[contains(@class, 'ant-table-cell-ellipsis')][1]")).size();
        if (rows > 50 && rows <= 100) {
            boolean row = true;
            Assert.assertEquals(row, true);
        } else {
            System.out.println("No item found!");
        }

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 19)
    @Description("To verify that charge items list only displays 10 number of records on a single page.\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_15_4() throws InterruptedException {

//        ActionChains

        Actions action = new Actions(driver);

//        JavascriptExecutor
        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
        driver.findElement(By.xpath("//div[@class='ant-select-selector']")).click();
        driver.findElement(By.xpath("//div[@title='10']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        //    Assertion
        int rows = driver.findElements(By.xpath("//td[contains(@class, 'ant-table-cell-ellipsis')][1]")).size();
        if (rows > 1 && rows <= 10) {
            boolean row = true;
            Assert.assertEquals(row, true);
        } else {
            System.out.println("No item found!");
        }

    }

}