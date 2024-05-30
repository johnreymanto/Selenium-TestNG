package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


import java.time.Duration;

public class BaseDriver {

    public WebDriver driver;
    public Actions action;
    public JavascriptExecutor jse;
    public WebDriverWait wait;

    @BeforeTest @BeforeClass
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

}
