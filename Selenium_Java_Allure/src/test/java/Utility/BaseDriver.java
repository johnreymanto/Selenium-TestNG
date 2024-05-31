package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;


public class BaseDriver {

    public static WebDriver driver;
    public Actions action;
    public JavascriptExecutor jse;
    public WebDriverWait wait;

    @BeforeClass
    public void RunBaseDriver() {

// declaration and instantiation of objects/variables
// System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
////    WebDriver driver=new ChromeDriver();

//  Initialize the WebDriver with the existing Chrome instance

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

}
