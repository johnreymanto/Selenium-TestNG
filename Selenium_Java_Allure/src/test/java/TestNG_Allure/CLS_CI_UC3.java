package TestNG_Allure;
import Utility.BaseDriver;
import Utility.CustomRetryAnalyzer;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static Utility.StringData.*;
import static Utility.StringData.chargeItemUrl;
import static Utility.StringData.editChargeItemUrl;
import static Utility.StringLocator.*;



public class CLS_CI_UC3 extends BaseDriver {

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 1, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To update existing charge item's charge type value to \"Admin\"\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_03_01() throws InterruptedException {

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

        String firstCIValue = driver.findElement(By.xpath(searchcitem)).getText();
        driver.findElement(By.xpath(firstcicheckbox)).click();
        driver.findElement(By.xpath(editbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement chargeType = driver.findElement(By.id(chargetypeid));
        action.moveToElement(chargeType).click().perform();
        driver.findElement(By.xpath(adminctid)).click();
        driver.findElement(By.xpath(savebtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        driver.findElement(By.xpath(searchci)).sendKeys(firstCIValue);
        action.sendKeys(Keys.ENTER).perform();

        WebElement chargeTypeValue = driver.findElement(By.xpath(searchcitem1));
        String expected_value = adminvalue;
        Assert.assertEquals(chargeTypeValue.getText(),expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 2, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To update existing charge item's charge type value to \"Registration\"\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_03_02() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        String firstCIValue = driver.findElement(By.xpath(searchcitem)).getText();
        driver.findElement(By.xpath(firstcicheckbox)).click();
        driver.findElement(By.xpath(editbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement chargeType = driver.findElement(By.id(chargetypeid));
        action.moveToElement(chargeType).click().perform();
        driver.findElement(By.xpath(registrationctid)).click();
        driver.findElement(By.xpath(savebtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        driver.findElement(By.xpath(searchci)).sendKeys(firstCIValue);
        action.sendKeys(Keys.ENTER).perform();

        WebElement chargeTypeValue = driver.findElement(By.xpath(searchcitem1));
        String expected_value = registrationvalue;
        Assert.assertEquals(chargeTypeValue.getText(),expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 3, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To update existing charge item's charge type value to \"General\"\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_03_03() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        String firstCIValue = driver.findElement(By.xpath(searchcitem)).getText();
        driver.findElement(By.xpath(firstcicheckbox)).click();
        driver.findElement(By.xpath(editbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement chargeType = driver.findElement(By.id(chargetypeid));
        action.moveToElement(chargeType).click().perform();
        driver.findElement(By.xpath(generalid)).click();
        driver.findElement(By.xpath(savebtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        driver.findElement(By.xpath(searchci)).sendKeys(firstCIValue);
        action.sendKeys(Keys.ENTER).perform();

        WebElement chargeTypeValue = driver.findElement(By.xpath(searchcitem1));
        String expected_value = generalvalue;
        Assert.assertEquals(chargeTypeValue.getText(),expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 4, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To update existing charge item's charge type value to \"Duplicate Invoice\"\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_03_04() throws InterruptedException {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        String firstCIValue = driver.findElement(By.xpath(searchcitem)).getText();
        driver.findElement(By.xpath(firstcicheckbox)).click();
        driver.findElement(By.xpath(editbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement chargeType = driver.findElement(By.id(chargetypeid));
        action.moveToElement(chargeType).click().perform();
        driver.findElement(By.xpath(duplicateinvoiceid)).click();
        driver.findElement(By.xpath(savebtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        //    Assertion

        driver.findElement(By.xpath(searchci)).sendKeys(firstCIValue);
        action.sendKeys(Keys.ENTER).perform();

        WebElement chargeTypeValue = driver.findElement(By.xpath(searchcitem1));
        String expected_value = duplicateinvoicevalue;
        Assert.assertEquals(chargeTypeValue.getText(),expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 5, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To update an existing charge item with blank charge item name")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_03_05_1() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(firstcicheckbox)).click();
        driver.findElement(By.xpath(editbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement chargeName = driver.findElement(By.id(chargeitemname));
        action.click(chargeName).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();

//    Assertion

        WebElement error_message = driver.findElement(By.xpath(mandatoryerrormessage1));
        String expected_error = mandatoryerrorvalue1;
        Assert.assertEquals(error_message.getText(), expected_error);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 6, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To update an existing charge item without charge description")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_03_05_2() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(firstcicheckbox)).click();
        driver.findElement(By.xpath(editbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement chargeName = driver.findElement(By.id(chargeitemdesc));
        action.click(chargeName).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).perform();

//    Assertion

        WebElement error_message = driver.findElement(By.xpath(mandatoryerrormessage1));
        String expected_error = mandatoryerrorvalue1;
        Assert.assertEquals(error_message.getText(), expected_error);

    }

    @Test(groups = {"regressionTest"}, priority = 7, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To validate cancellation message using cancel button\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_03_06_1() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(firstcicheckbox)).click();
        driver.findElement(By.xpath(editbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement chargeName = driver.findElement(By.id(chargeitemname));
        action.click(chargeName).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(adminvalue).perform();

        driver.findElement(By.xpath(cancelBtn)).click();

//    Assertion

        WebElement confirm_message = driver.findElement(By.xpath(modalConfirmContent));
        String expected_message = expectederrorvalue2;
        Assert.assertEquals(confirm_message.getText(), expected_message);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 8, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel an ongoing modication of a charge item using cancel button\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_03_06_2() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(firstcicheckbox)).click();
        driver.findElement(By.xpath(editbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement chargeName = driver.findElement(By.id(chargeitemname));
        action.click(chargeName).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(adminvalue).perform();

        driver.findElement(By.xpath(cancelBtn)).click();
        driver.findElement(By.xpath(modalOkBtn)).click();

//    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"regressionTest"}, priority = 9, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To validate cancellation message using x button\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_03_07_1() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(firstcicheckbox)).click();
        driver.findElement(By.xpath(editbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement chargeName = driver.findElement(By.id(chargeitemname));
        action.click(chargeName).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(adminvalue).perform();

        driver.findElement(By.xpath(xbtn)).click();

//    Assertion

        WebElement confirm_message = driver.findElement(By.xpath(modalConfirmContent));
        String expected_message = expectederrorvalue2;
        Assert.assertEquals(confirm_message.getText(), expected_message);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 10, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel an ongoing modication of a charge item using x button\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_03_07_2() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(firstcicheckbox)).click();
        driver.findElement(By.xpath(editbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement chargeName = driver.findElement(By.id(chargeitemname));
        action.click(chargeName).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(adminvalue).perform();

        driver.findElement(By.xpath(xbtn)).click();
        driver.findElement(By.xpath(modalOkBtn)).click();

//    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeItemUrl;
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 11, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To disregard an ongoing cancellation modication of a charge item.\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_03_08() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(secondcicheckbox)).click();
        driver.findElement(By.xpath(editbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        WebElement chargeName = driver.findElement(By.id(chargeitemname));
        action.click(chargeName).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(adminvalue).perform();

        driver.findElement(By.xpath(cancelBtn)).click();
        driver.findElement(By.xpath(modalcancelbtn)).click();

//    Assertion

        String get_url = driver.getCurrentUrl();

        // Define the regular expression pattern
        String regex = editChargeItemUrl;
        Pattern pattern = Pattern.compile(regex);

        // Match the pattern against the current URL
        Matcher matcher = pattern.matcher(get_url);

        // Assert that the URL matches the pattern
        Assert.assertTrue(matcher.matches(), "URL does not match the required pattern: " + get_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 12, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To cancel an update on an unmodified form\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_03_09() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(firstcicheckbox)).click();
        driver.findElement(By.xpath(editbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(cancelBtn)).click();

//    Assertion

        String get_url = driver.getCurrentUrl();
        String expectedUrl = chargeItemUrl;
        Pattern pattern = Pattern.compile(expectedUrl);

        // Match the pattern against the current URL
        Matcher matcher = pattern.matcher(get_url);

        // Assert that the URL matches the pattern
        Assert.assertTrue(matcher.matches(), "URL does not match the required pattern: " + get_url);

    }

    @Test(groups = {"regressionTest"}, priority = 13, retryAnalyzer = CustomRetryAnalyzer.class)
    @Description("To verify \"Save\" button is greyed out on the unmodified form\n")
    @Severity(SeverityLevel.NORMAL)
    public void UC_LH_CLS_CI_01_03_10() {

        // Launch website
        driver.get(chargeItemUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

        driver.findElement(By.xpath(firstcicheckbox)).click();
        driver.findElement(By.xpath(editbtn)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(backdrop)));

//    Assertion

        boolean isClickable = driver.findElement(By.xpath(dissavebtn)).isEnabled();
        Assert.assertEquals(isClickable, false);

    }

}