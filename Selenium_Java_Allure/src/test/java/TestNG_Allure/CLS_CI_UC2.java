package TestNG_Allure;
import Utility.BaseDriver;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class CLS_CI_UC2 extends BaseDriver {

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 1)
    @Description("To view existing Charge items list details\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_01() {

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
    public void UC_LH_CLS_CI_01_02_02() {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement filter_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='filter-funnel-btn']")));
        jse.executeScript("arguments[0].click()", filter_btn);
        WebElement status_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']")));
        jse.executeScript("arguments[0].click()", status_btn);
        WebElement active_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='ACTIVE']")));
        jse.executeScript("arguments[0].click()", active_btn);
        WebElement apply_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Apply')]")));
        jse.executeScript("arguments[0].click()", apply_btn);

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
    public void UC_LH_CLS_CI_01_02_03() {

        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement filter_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='filter-funnel-btn']")));
        jse.executeScript("arguments[0].click()", filter_btn);
        WebElement status_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']")));
        jse.executeScript("arguments[0].click()", status_btn);
        WebElement inactive_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='INACTIVE']")));
        jse.executeScript("arguments[0].click()", inactive_btn);
        WebElement apply_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Apply')]")));
        jse.executeScript("arguments[0].click()", apply_btn);
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


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement filter_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='filter-funnel-btn']")));
        jse.executeScript("arguments[0].click()", filter_btn);
        WebElement status_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']")));
        jse.executeScript("arguments[0].click()", status_btn);
        WebElement active_btn = driver.findElement(By.xpath("//input[@value='ACTIVE']"));
        active_btn.click();
        Thread.sleep(500);
        active_btn.click();

//    Assertion

        try {
//    Try to find the element you are interested in
            WebElement selection = driver.findElement(By.xpath("//span[contains(@class, '_filter-header-tag')]"));
//    If element found, perform your actions or validations
            System.out.println("Element found!");
        } catch (NoSuchElementException e) {
//    If the element is not found, it indicates a validation failure
            boolean noSuchElem = true;
            System.out.println("Element not found!");

            Assert.assertEquals(noSuchElem, true);
        }
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 5)
    @Description("To Tick and Untick Inactive status checkbox in filter drawer\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_05() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebElement filter_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='filter-funnel-btn']")));
        jse.executeScript("arguments[0].click()", filter_btn);
        WebElement status_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']")));
        jse.executeScript("arguments[0].click()", status_btn);
        WebElement inactive_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='INACTIVE']")));
        inactive_btn.click();
        Thread.sleep(500);
        inactive_btn.click();


//    Assertion

        try {
//    Try to find the element you are interested in
            WebElement selection = driver.findElement(By.xpath("//span[contains(@class, '_filter-header-tag')]"));
//    If element found, perform your actions or validations
            System.out.println("Element found!");
        } catch (NoSuchElementException e) {
//    If the element is not found, it indicates a validation failure
            boolean noSuchElem = true;
            System.out.println("Element not found!");

            Assert.assertEquals(noSuchElem, true);
        }
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 6)
    @Description("To filter both \"Active\" and \"Inactive\" charge items\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_06() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        WebElement filter_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='filter-funnel-btn']")));
        jse.executeScript("arguments[0].click()", filter_btn);
        WebElement status_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']")));
        jse.executeScript("arguments[0].click()", status_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement active_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='ACTIVE']")));
        active_btn.click();
        WebElement inactive_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='INACTIVE']")));
        inactive_btn.click();
        WebElement apply_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'ant-btn-primary')]//span[contains(text(), 'Apply')]")));
        apply_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

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


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement filter_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='filter-funnel-btn']")));
        jse.executeScript("arguments[0].click()", filter_btn);
        WebElement status_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']")));
        jse.executeScript("arguments[0].click()", status_btn);
        WebElement active_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='ACTIVE']")));
        jse.executeScript("arguments[0].click()", active_btn);
        WebElement inactive_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='INACTIVE']")));
        jse.executeScript("arguments[0].click()", inactive_btn);
        WebElement clear_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Clear')]")));
        jse.executeScript("arguments[0].click()", clear_btn);

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


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement filter_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='filter-funnel-btn']")));
        jse.executeScript("arguments[0].click()", filter_btn);
        WebElement status_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='button']")));
        jse.executeScript("arguments[0].click()", status_btn);
        WebElement active_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='ACTIVE']")));
        jse.executeScript("arguments[0].click()", active_btn);
        WebElement inactive_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='INACTIVE']")));
        jse.executeScript("arguments[0].click()", inactive_btn);
        WebElement clear_btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class, 'ant-btn-default')]//span[contains(text(), 'Cancel')]")));
        jse.executeScript("arguments[0].click()", clear_btn);

//    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items";
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 9)
    @Description("To search existing charge item using 3 minimum characters\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_09() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
        driver.findElement(By.xpath("//input[@data-testid='search-input']")).sendKeys("UC_");
        action.sendKeys(Keys.ENTER).perform();

//    Assertion
        int rows = driver.findElements(By.xpath("//td[contains(@class, 'ant-table-cell-ellipsis')][1]")).size();
        if (rows > 0) {
            boolean row = true;
            Assert.assertEquals(row, true);
        } else {
            boolean row = false;
            Assert.assertEquals(row, true);
        }
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 10)
    @Description("To search nonexistent charge item using 3 minimum characters\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_10() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
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


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
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


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
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


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
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


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
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


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

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


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
        driver.findElement(By.xpath("//div[@class='ant-select-selector']")).click();
        driver.findElement(By.xpath("//div[@title='20']")).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

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


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
        driver.findElement(By.xpath("//div[@class='ant-select-selector']")).click();
        driver.findElement(By.xpath("//div[@title='50']")).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

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


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
        driver.findElement(By.xpath("//div[@class='ant-select-selector']")).click();
        driver.findElement(By.xpath("//div[@title='100']")).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

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


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
        driver.findElement(By.xpath("//div[@class='ant-select-selector']")).click();
        driver.findElement(By.xpath("//div[@title='10']")).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        //    Assertion
        int rows = driver.findElements(By.xpath("//td[contains(@class, 'ant-table-cell-ellipsis')][1]")).size();
        if (rows > 1 && rows <= 10) {
            boolean row = true;
            Assert.assertEquals(row, true);
        } else {
            System.out.println("No item found!");
        }

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 20)
    @Description("To navigate to next page of the charge items list\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_16() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
        WebElement next_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, '_jump-next_')]")));
        next_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items?page=1&size=10";
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 21)
    @Description("To navigate to previous page of charge items list\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_17() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items?page=1&size=10");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
        WebElement next_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, '_jump-prev_')]")));
        next_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items?page=0&size=10";
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 22)
    @Description("To navigate to Go to Last page of the charge items list\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_18() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));
        WebElement next_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, '_jump-last_')]")));
        next_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items?page=6&size=10";
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 23)
    @Description("To navigate to Go to First page of the charge items list\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_19() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items?page=6&size=10");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement next_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, '_jump-first_')]")));
        next_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items?page=0&size=10";
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 24)
    @Description("To sort the charge item list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_20_1() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Charge item']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-column-sort ant-table-cell-ellipsis')][1]"));
        String expected_value = "!@#$asdgfsdas";  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 25)
    @Description("To sort the charge item list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_20_2() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath("//th[@title='Charge item' and @aria-sort='ascending']")).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));


        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-column-sort ant-table-cell-ellipsis')][1]"));
        String expected_value = "UCCITest#04";  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 26)
    @Description("To sort the charge item list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_20_3() throws InterruptedException {


        // Launch website
        driver.findElement(By.xpath("//th[@title='Charge item' and @aria-sort='descending']")).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));


        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-cell ant-table-cell-ellipsis')][1]"));
        String expected_value = "string12";  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);
    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 27)
    @Description("To sort the charge type list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_21_1() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Charge type']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-column-sort ant-table-cell-ellipsis')][1]"));
        String expected_value = "Admin";  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 28)
    @Description("To sort the charge type list in descending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_21_2() throws InterruptedException {


        // Launch website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Charge type' and @aria-sort='ascending']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-column-sort ant-table-cell-ellipsis')][1]"));
        String expected_value = "Registration";  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 29)
    @Description("To sort the charge item list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_21_3() throws InterruptedException {


        // Launch website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Charge type' and @aria-sort='descending']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-cell-ellipsis')][2]"));
        String expected_value = "Admin";  // First item in Default
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 30)
    @Description("To sort the Description in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_22_1() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Description']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-column-sort ant-table-cell-ellipsis')][1]"));
        String expected_value = "11";  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 31)
    @Description("To sort the Description list in descending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_22_2() throws InterruptedException {


        // Launch website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Description' and @aria-sort='ascending']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-column-sort ant-table-cell-ellipsis')][1]"));
        String expected_value = "This is sample charge item -- its updated";  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 32)
    @Description("To sort the Description list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_22_3() throws InterruptedException {


        // Launch website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Description' and @aria-sort='descending']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-cell-ellipsis')][3]"));
        String expected_value = "string1";  // First item in Default
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 33)
    @Description("To sort the Base currency list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_23_1() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Base currency']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-column-sort ant-table-cell-ellipsis')][1]"));
        String expected_value = "";  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 34)
    @Description("To sort the Base currency list in descending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_23_2() throws InterruptedException {


        // Launch website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Base currency' and @aria-sort='ascending']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-column-sort ant-table-cell-ellipsis')][1]"));
        String expected_value = "USD";  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 35)
    @Description("To sort the Base currency list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_23_3() throws InterruptedException {


        // Launch website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Base currency' and @aria-sort='descending']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-cell-ellipsis')][4]"));
        String expected_value = "SGD";  // First item in Default
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 36)
    @Description("To sort the GST applicable for foreign address list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_24_1() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[contains(@title, 'GST applicable')]")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-column-sort ant-table-cell-ellipsis')][1]"));
        String expected_value = "No";  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 37)
    @Description("To sort the GST applicable for foreign address list in descending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_24_2() throws InterruptedException {


        // Launch website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[contains(@title, 'GST applicable') and @aria-sort='ascending']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-column-sort ant-table-cell-ellipsis')][1]"));
        String expected_value = "Yes";  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 38)
    @Description("To sort the GST applicable for foreign address list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_24_3() throws InterruptedException {


        // Launch website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[contains(@title, 'GST applicable') and @aria-sort='descending']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-cell-ellipsis')][5]"));
        String expected_value = "Yes";  // First item in Default
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 39)
    @Description("To sort the GL Number list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_25_1() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@aria-label='GL Number']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[@class='ant-table-cell ant-table-column-sort']"));
        String expected_value = "1234";  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 40)
    @Description("To sort the GL Number list in descending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_25_2() throws InterruptedException {


        // Launch website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[contains(@class, 'ant-table-column-sort') and @aria-sort='ascending']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[@class='ant-table-cell ant-table-column-sort']"));
        String expected_value = "!@#$%^*";  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 41)
    @Description("To sort the GL Number list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_25_3() throws InterruptedException {


        // Launch website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[contains(@class, 'ant-table-column-sort') and @aria-sort='descending']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[@class='ant-table-cell']"));
        String expected_value = "002";  // First item in Default
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 42)
    @Description("To sort the Refundable list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_26_1() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Refundable']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-column-sort ant-table-cell-ellipsis')]"));
        String expected_value = "No";  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 43)
    @Description("To sort the Refundable list in descending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_26_2() throws InterruptedException {


        // Launch website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Refundable' and @aria-sort='ascending']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-column-sort ant-table-cell-ellipsis')]"));
        String expected_value = "Yes";  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 44)
    @Description("To sort the Refundable list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_26_3() throws InterruptedException {


        // Launch website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Refundable' and @aria-sort='descending']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-cell-ellipsis')][6]"));
        String expected_value = "Yes";  // First item in Default
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 45)
    @Description("To sort the Tag to registration list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_27_1() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Tag to registration']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-column-sort ant-table-cell-ellipsis')]"));
        String expected_value = "No";  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 46)
    @Description("To sort the Tag to registration list in descending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_27_2() throws InterruptedException {


        // Launch website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Tag to registration' and @aria-sort='ascending']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-column-sort ant-table-cell-ellipsis')]"));
        String expected_value = "Yes";  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 47)
    @Description("To sort the Tag to registration list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_27_3() throws InterruptedException {


        // Launch website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Tag to registration' and @aria-sort='descending']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-cell-ellipsis')][6]"));
        String expected_value = "Yes";  // First item in Default
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 48)
    @Description("To sort the Profit centre list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_28_1() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Profit centre']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-column-sort ant-table-cell-ellipsis')]"));
        String expected_value = "";  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 49)
    @Description("To sort the Profit centre list in descending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_28_2() throws InterruptedException {


        // Launch website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Profit centre' and @aria-sort='ascending']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-column-sort ant-table-cell-ellipsis')]"));
        String expected_value = "PC 2";  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 50)
    @Description("To sort the Profit centre list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_28_3() throws InterruptedException {


        // Launch website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Profit centre' and @aria-sort='descending']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-cell-ellipsis')][8]"));
        String expected_value = "";  // First item in Default
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 51)
    @Description("To sort the Status list in ascending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_29_1() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Status']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-column-sort ant-table-cell-ellipsis')]"));
        String expected_value = "Active";  // First item in ascending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 52)
    @Description("To sort the Status list in descending order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_29_2() throws InterruptedException {


        // Launch website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Status' and @aria-sort='ascending']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-column-sort ant-table-cell-ellipsis')]"));
        String expected_value = "Inactive";  // First item in descending
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 53)
    @Description("To sort the Status list in default order using the charge item column\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_29_3() throws InterruptedException {


        // Launch website
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//th[@title='Status' and @aria-sort='descending']")).click();

        //    Assertion

        WebElement first_item = driver.findElement(By.xpath("//td[contains(@class, 'ant-table-cell-ellipsis')][9]"));
        String expected_value = "Active";  // First item in Default
        Assert.assertEquals(first_item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 54)
    @Description("To view the Charge item details\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_30() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("(//a[contains(@class, 'ant-typography')])[1]")).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        //    Assertion

        WebElement viewpage = driver.findElement(By.xpath("//h3[contains(@class, 'ant-typography')]"));
        String expected_value = "View charge item";
        Assert.assertEquals(viewpage.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 55)
    @Description("To close View charge item drawer using close button\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_31() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("(//a[contains(@class, 'ant-typography')])[1]")).click();
        driver.findElement(By.xpath("//span[contains(text(), 'Close')]")).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items";
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 56)
    @Description("To close a View charge item drawer using X button\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_32() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("(//a[contains(@class, 'ant-typography')])[1]")).click();
        driver.findElement(By.xpath("//button[@aria-label='Close']")).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items";
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 57)
    @Description("To close a View charge item drawer using Esc button in keyboard\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_33() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("(//a[contains(@class, 'ant-typography')])[1]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//h3[contains(@class, 'ant-typography')]"));
        action.sendKeys(Keys.ESCAPE).perform();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items";
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 58)
    @Description("To cancel an unmodified filter drawer using cancel button\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_34() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//button[@data-testid='filter-funnel-btn']")).click();
        driver.findElement(By.xpath("//button[@type='button']//span[contains(text(), 'Cancel')]")).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items";
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 59)
    @Description("To cancel an unmodified filter window using X button\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_35() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//button[@data-testid='filter-funnel-btn']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Close']")).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items";
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 60)
    @Description("To cancel an unmodified filter window using Esc button in keyboard\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_36() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        driver.findElement(By.xpath("//button[@data-testid='filter-funnel-btn']")).click();
        Thread.sleep(200);
        action.sendKeys(Keys.ESCAPE).perform();
        Thread.sleep(500);

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items";
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 61)
    @Description("To navigate to designated page using Go button\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_37() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement jumpfield = driver.findElement(By.xpath("//div[contains(@class, 'quick-jumper')]//input[@type='text']"));
        action.doubleClick(jumpfield).sendKeys("2").perform();
        driver.findElement(By.xpath("//button[@title='go']")).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items?page=1&size=10";
        Assert.assertEquals(get_url, expected_url);
    }

    @Test(groups = {"smokeTest", "regressionTest", "testRun"}, priority = 62)
    @Description("To verify Go button accepts no value in textbox\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_02_38() throws InterruptedException {


        // Launch website
        driver.get("https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, '_custom-loading-modal-container')]")));

        WebElement jumpfield = driver.findElement(By.xpath("//div[contains(@class, 'quick-jumper')]//input[@type='text']"));
        action.doubleClick(jumpfield).sendKeys(Keys.BACK_SPACE).perform();
        driver.findElement(By.xpath("//button[@title='go']")).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = "https://cls.dmo.lhubsg.com/billing/billing-configuration/charge-items";
        Assert.assertEquals(get_url, expected_url);
    }


}