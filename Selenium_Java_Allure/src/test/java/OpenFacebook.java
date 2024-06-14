import Utility.BaseDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenFacebook extends BaseDriver {

//    @Parameters({"username", "password"})
//    @Test
//    public void loginTest(String username, String password) {
//
//        openUrl("https://www.facebook.com");
//        driver.findElement(By.id("email")).sendKeys(username);
//        driver.findElement(By.id("pass")).sendKeys(password);
//
//        System.out.println("Username: " + username + ", Password: " + password);
//    }

    @Parameters({"username", "password"})
    @Test
    public void loginTest(String username, String password) {
        openUrl("https://www.facebook.com");
        enterUsername(username);
        enterPassword(password);
    }

    @Step("Open URL: {url}")
    public void openUrl(String url) {
        driver.get(url);
    }

    @Step("Enter Username: {username}")
    public void enterUsername(String username) {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.clear();
        emailField.sendKeys(username);
    }

    @Step("Enter Password")
    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

}