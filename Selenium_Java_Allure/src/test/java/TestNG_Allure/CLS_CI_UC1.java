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
    public void UC_LH_CLS_CI_01_01_01() {

        // Launch website
        driver.get(billingurlpage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.xpath(billconfiglocator)).click();
        driver.findElement(By.xpath(chargeitempage)).click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        jse.executeScript("arguments[0].click()", create_btn);
//        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

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

//        driver.findElement(By.xpath(savebtn)).click();


//        Need to remove these lines in actual testing
        driver.findElement(By.xpath(xbtn)).click();
        driver.findElement(By.xpath(modalokbtn)).click();
//        Need to remove these lines in actual testing

//    Assertion
        driver.findElement(By.xpath(searchci)).sendKeys(searchitemvalue2);
        action.sendKeys(Keys.ENTER).perform();

        WebElement item = driver.findElement(By.xpath(searchcitem));

        String expected_value = expectedvalue1;
        Assert.assertEquals(item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 2)
    @Description("To create/save a new charge item with \"Admin\" charge type value\n")
    public void UC_LH_CLS_CI_01_01_02() {

        // Launch website
        driver.get(chargeitemurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

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
        driver.findElement(By.xpath(profitcentreidvalue1)).click();

//        driver.findElement(By.xpath(savebtn)).click();

//    Need to remove these lines in actual testing
        driver.findElement(By.xpath(xbtn)).click();
        driver.findElement(By.xpath(modalokbtn)).click();

//     Need to remove these lines in actual testing

//    Assertion
        driver.findElement(By.xpath(searchci)).sendKeys(searchitemvalue2);
        action.sendKeys(Keys.ENTER).perform();

        WebElement item = driver.findElement(By.xpath(searchcitem));

        String expected_value = expectedvalue1;
        Assert.assertEquals(item.getText(), expected_value);


    }


    @Test(groups = {"smokeTest", "regressionTest"}, priority = 3)
    @Description("To create/save a new charge item with \"Duplicate Invoice\" charge type value\n")
    public void UC_LH_CLS_CI_01_01_03() {


        // Launch website
        driver.get(chargeitemurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue3);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(duplicateinvoiceid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberidvalue3)).click();
        driver.findElement(By.xpath(tagtoregistrationfalse)).click();
        driver.findElement(By.id(profitcentreid)).click();
        driver.findElement(By.xpath(profitcentreidvalue2)).click();

//        driver.findElement(By.xpath(savebtn)).click();

//    Need to remove these lines in actual testing
        driver.findElement(By.xpath(xbtn)).click();
        driver.findElement(By.xpath(modalokbtn)).click();

//     Need to remove these lines in actual testing

//    Assertion
        driver.findElement(By.xpath(searchci)).sendKeys(searchitemvalue2);
        action.sendKeys(Keys.ENTER).perform();

        WebElement item = driver.findElement(By.xpath(searchcitem));

        String expected_value = expectedvalue1;
        Assert.assertEquals(item.getText(), expected_value);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 4)
    @Description("To create/save a new charge item with \"General\" charge type value\n")
    public void UC_LH_CLS_CI_01_01_04() {


        // Launch website

        driver.get(chargeitemurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue4);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(generalid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberidvalue4)).click();


//        driver.findElement(By.xpath(savebtn)).click();

//    Need to remove these lines in actual testing
        driver.findElement(By.xpath(xbtn)).click();
        driver.findElement(By.xpath(modalokbtn)).click();

//     Need to remove these lines in actual testing

//    Assertion
        driver.findElement(By.xpath(searchci)).sendKeys(searchitemvalue2);
        action.sendKeys(Keys.ENTER).perform();

        WebElement item = driver.findElement(By.xpath(searchcitem));

        String expected_value = expectedvalue1;
        Assert.assertEquals(item.getText(), expected_value);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 5)
    @Description("To create/save a new charge item with existing name\n")
    public void UC_LH_CLS_CI_01_01_05() {


        // Launch website
        driver.get(chargeitemurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        driver.findElement(By.id(chargeitemname)).sendKeys(existingchargeitemvalue1);
        driver.findElement(By.id(chargeitemname));
        action.sendKeys(Keys.TAB).perform();

//        driver.findElement(By.xpath(savebtn)).click();

//    Assertion

        WebElement error_message = driver.findElement(By.xpath(errormessage1));
        String expected_error = expectederrorvalue1;
        Assert.assertEquals(error_message.getText(), expected_error);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 6)
    @Description("To create/save a new charge item with blank charge item name")
    public void UC_LH_CLS_CI_01_01_06_1() {


        // Launch website
        driver.get(chargeitemurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

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

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 7)
    @Description("To create/save a new charge item without charge type")
    public void UC_LH_CLS_CI_01_01_06_2() {


        // Launch website
        driver.get(chargeitemurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

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

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 8)
    @Description("To create/save a new charge item with blank charge description")
    public void UC_LH_CLS_CI_01_01_06_3() {


        // Launch website
        driver.get(chargeitemurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

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

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 9)
    @Description("To create/save a new charge item without GL Number")
    public void UC_LH_CLS_CI_01_01_06_4() {


        // Launch website
        driver.get(chargeitemurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
//        jse.executeScript("arguments[0].click()", create_btn);
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

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

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 10)
    @Description("To validate cancellation message using cancel button\n")
    public void UC_LH_CLS_CI_01_01_07_1() throws InterruptedException {


        // Launch website
        driver.get(chargeitemurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue7);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(generalid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberidvalue4)).click();
        driver.findElement(By.xpath(cancelbtn)).click();

//    Assertion

        WebElement confirm_message = driver.findElement(By.xpath(modalconfirmcontent));
        String expected_message = expectederrorvalue2;
        Assert.assertEquals(confirm_message.getText(), expected_message);


    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 11)
    @Description("To cancel an ongoing creation of a charge item using cancel button\n")
    public void UC_LH_CLS_CI_01_01_07_2() throws InterruptedException {


        // Launch website
        driver.get(chargeitemurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue7);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(generalid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberidvalue4)).click();
        driver.findElement(By.xpath(cancelbtn)).click();
        driver.findElement(By.xpath(modalokbtn)).click();

//    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeitemurl;
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 12)
    @Description("To validate cancellation message using x button\n")
    public void UC_LH_CLS_CI_01_01_08_1() throws InterruptedException {


        // Launch website
        driver.get(chargeitemurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue8);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(generalid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberidvalue4)).click();
        driver.findElement(By.xpath(xbtn)).click();

//    Assertion

        WebElement confirm_message = driver.findElement(By.xpath(modalconfirmcontent));
        String expected_message = expectederrorvalue2;
        Assert.assertEquals(confirm_message.getText(), expected_message);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 13)
    @Description("To cancel an ongoing creation of a charge item using x button\n")
    public void UC_LH_CLS_CI_01_01_08_2() throws InterruptedException {


        // Launch website
        driver.get(chargeitemurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue8);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(generalid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberidvalue4)).click();
        driver.findElement(By.xpath(xbtn)).click();
        driver.findElement(By.xpath(modalokbtn)).click();

//    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeitemurl;
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 14)
    @Description("To disregard an ongoing cancel creation of a charge item using cancel button\n")
    public void UC_LH_CLS_CI_01_01_09() throws InterruptedException {


        // Launch website
        driver.get(chargeitemurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue9);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(generalid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription1);
        driver.findElement(By.id(glnumberid)).click();
        driver.findElement(By.xpath(glnumberidvalue4)).click();
        driver.findElement(By.xpath(cancelbtn)).click();
        driver.findElement(By.xpath(modalcancelbtn)).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = createchargeitemurl;
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 15)
    @Description("To cancel a newly launch unmodified form using cancel button\n")
    public void UC_LH_CLS_CI_01_01_10() throws InterruptedException {


        // Launch website
        driver.get(chargeitemurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        driver.findElement(By.xpath(cancelbtn)).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeitemurl;
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 16)
    @Description("To cancel a newly launch unmodified form using x button\n")
    public void UC_LH_CLS_CI_01_01_11() throws InterruptedException {


        // Launch website
        driver.get(chargeitemurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        driver.findElement(By.xpath(xbtn)).click();

        //    Assertion

        String get_url = driver.getCurrentUrl();
        String expected_url = chargeitemurl;
        Assert.assertEquals(get_url, expected_url);

    }


    @Test(groups = {"smokeTest", "regressionTest"}, priority = 17)
    @Description("To cancel a newly launch unmodified form using Esc button in keyboard\n")
    public void UC_LH_CLS_CI_01_01_12() throws InterruptedException {


        // Launch website
        driver.get(chargeitemurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        jse.executeScript("arguments[0].click()", create_btn);

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement chargename = driver.findElement(By.id(chargeitemname));
        action.click(chargename).sendKeys(Keys.ESCAPE).perform();

        //    Assertion
        Thread.sleep(1000);
        String get_url = driver.getCurrentUrl();
        String expected_url = chargeitemurl;
        Assert.assertEquals(get_url, expected_url);

    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 18)
    @Description("To verify maximum input of 200 characters in \"Description\" field\n")
    public void UC_LH_CLS_CI_01_01_13() throws InterruptedException {


        // Launch website
        driver.get(chargeitemurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        driver.findElement(By.id(chargeitemname)).sendKeys(chargeitemvalue13);
        driver.findElement(By.id(chargetypeid)).click();
        driver.findElement(By.xpath(generalid)).click();
        driver.findElement(By.id(chargeitemdesc)).sendKeys(chargeitemdescription2);

        //    Assertion

        WebElement max_length = driver.findElement(By.xpath(maxtextarea));

        String expected_length = expectedlength1;
        Assert.assertEquals(max_length.getText(), expected_length);
    }

    @Test(groups = {"smokeTest", "regressionTest"}, priority = 19)
    @Description("To verify drawer title")
    public void UC_LH_CLS_CI_01_01_14() throws InterruptedException {


        // Launch website
        driver.get(chargeitemurl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        WebElement create_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(createbtn)));
        create_btn.click();

        // Waiting for loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(spinloader)));

        //    Assertion

        WebElement drawer_title = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(createdrawertitle)));

        String expected_title = createdrawertitlevalue;
        Assert.assertEquals(drawer_title.getText(), expected_title);

    }

}
