package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.security.Provider;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class BaseDriver {

    public static WebDriver driver;
    public Actions action;
    public static JavascriptExecutor jse;
    public WebDriverWait wait;

    @BeforeClass(groups = {"smokeTest", "regressionTest", "testRun"})
    public void RunBaseDriver() {

// declaration and instantiation of objects/variables
//    System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
//        WebDriverManager.chromedriver().setup();

//  Initialize the WebDriver with the existing Chrome instanced
        ChromeOptions options = new ChromeOptions();

//  Specify the debugging address for the already opened Chrome browser

        options.setExperimentalOption("debuggerAddress", "localhost:9999");
        this.driver = new ChromeDriver(options);

//  JavascriptExecutor
        jse = (JavascriptExecutor) driver;

//        ActionChains

        action = new Actions(driver);

//  WebdriverWait

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    public static boolean isSortedAscending(Integer col) {

        boolean isSort = false;
        ArrayList<String> strList = new ArrayList<>();

        //Get Data in a col and save into arraylist
        int rowCount = driver.findElements(By.xpath("//table[@style='width: 100%; min-width: 100%; table-layout: fixed;']//tr")).size();
        for (int i = 1; i < rowCount; i++) {

            if (i < 11) {
                String val = driver.findElement(By.xpath("//table[@style='width: 100%; min-width: 100%; table-layout: fixed;']//tr[" + (i + 1) + "]//td[" + col.toString() + "]")).getText();
                strList.add(val.trim().toLowerCase());
            }
        }
        //clone arraylist
        ArrayList list2 = (ArrayList) strList.clone();

        // Sort clone arraylist to ascending
        list2.sort(null);
        //Collections.sort(strList2, Collections.reverseOrder());

        //check if 2 arraylist is equal
        return strList.equals(list2);

    }

    public static boolean isSortedDescending(Integer col) {

        boolean isSort = false;
        ArrayList<String> strList = new ArrayList<>();

        //Get Data in a col and save into arraylist
        int rowCount = driver.findElements(By.xpath("//table[@style='width: 100%; min-width: 100%; table-layout: fixed;']//tr")).size();
        for (int i = 1; i < rowCount; i++) {

            if (i < 11) {
                String val = driver.findElement(By.xpath("//table[@style='width: 100%; min-width: 100%; table-layout: fixed;']//tr[" + (i + 1) + "]//td[" + col.toString() + "]")).getText();
                strList.add(val.trim().toLowerCase());
            }
        }
        //clone arraylist
        ArrayList list2 = (ArrayList) strList.clone();

        // Sort clone arraylist to descending
        Collections.sort(list2, Collections.reverseOrder());

        //check if 2 arraylist is equal
        return strList.equals(list2);

    }

    public ArrayList<String> isSortedDefault(Integer col, ArrayList<String> strList) {


        //Get Data in a col and save into arraylist
        int rowCount = driver.findElements(By.xpath("//table[@style='width: 100%; min-width: 100%; table-layout: fixed;']//tr")).size();
        for (int i = 1; i < rowCount; i++) {

            if (i < 11) {
                String val = driver.findElement(By.xpath("//table[@style='width: 100%; min-width: 100%; table-layout: fixed;']//tr[" + (i + 1) + "]//td[" + col.toString() + "]")).getText();
                strList.add(val.trim().toLowerCase());
            }
        }
        return strList;
    }

    public static String searchSalesLocation(String sl_Name) throws InterruptedException {
        Thread.sleep(2000);
        //Type Into Search bar
        driver.findElement(By.xpath("//input[@class='ant-input css-18oat15']")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.xpath("//input[@class='ant-input css-18oat15']")).sendKeys(Keys.DELETE);

        //Type Into Search bar
        driver.findElement(By.xpath("//input[@class='ant-input css-18oat15']")).sendKeys("", sl_Name);

        //Send Enter Keys
        driver.findElement(By.xpath("//input[@class='ant-input css-18oat15']")).sendKeys(Keys.ENTER);

        //Wait visibility of Go Button
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='go']")));

        //Get Sales Location Status
        String sl_Status = driver.findElement(By.xpath("//table[@style='width: 100%; min-width: 100%; table-layout: fixed;']//tr[2]//td[5]")).getText();

        return sl_Status.toLowerCase();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    // For Screenshot
    public static void Screenshot() {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
    }

    public static void ScreenshotWithUrl() {
        try {
            String currentUrl = driver.getCurrentUrl(); // Get the current URL
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
            Allure.addAttachment("URL", currentUrl); // Add the URL as an attachment
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void highlightElement(WebDriver driver, WebElement element) {
        jse.executeScript("arguments[0].style.setProperty('border', '3px solid red', 'important');", element);
    }

    public static void highlightElements(WebDriver driver, List<WebElement> elements) {
        for (WebElement element : elements) {
            jse.executeScript("arguments[0].style.setProperty('border', '3px solid red', 'important');", element);
        }
    }

    public static void removeHighlight(WebDriver driver, WebElement element) {
        jse.executeScript("arguments[0].style.setProperty('border', '', 'important');", element);
    }

    public static void removeHighlights(WebDriver driver, List<WebElement> elements) {
        for (WebElement element : elements) {
            jse.executeScript("arguments[0].style.setProperty('border', '', 'important');", element);
        }
    }

    /**
     * For instantiation of Get command
     * For instantiation of FindElements command
     */

    // By id
    public void openUrl(String url) {
        driver.get(url);
    }

    // By Locator
    public WebElement find(By locator) {
        return driver.findElement(locator);

    }

    public List<WebElement> finds(By locator) {
        return driver.findElements(locator);
    }

    /**
     * For instantiation of wait command
     */
    // Implicit wait
    public void implicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    // Wait loader (Locator)
    public void waitLoader(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated((locator)));
    }

    // Wait until visibility of Element located (Locator)
    public WebElement waitUntilVisibilityOfElementLocated(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated((locator)));
    }

    // Wait until element to be clickable (Locator)
    public WebElement waitUntilElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable((locator)));
    }

    // Wait until presence of element located (Locator)
    public WebElement waitUntilPresenceOfElementLocated(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated((locator)));
    }
    // Wait until presence of element located (Locator)
    public boolean waitUntilVisibilityAndElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOfElementLocated(locator),
                ExpectedConditions.elementToBeClickable(locator)));
    }
    // Thread Sleep
    public void waitTime(int milliseconds) throws InterruptedException {
        Thread.sleep(milliseconds);
    }

    /**
     * For instantiation of click command
     */

    // Method to click an element using any locator
    public void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    // Method to enter text in an element using any locator
    public void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    public Object scrollIntoView(WebElement locator) {
        return jse.executeScript("arguments[0].scrollIntoView(true);", locator);
    }
}

