package Utility;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

public class ScreenshotListener implements ITestListener {

    private WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        // Retrieve the WebDriver instance from BaseDriver
        this.driver = BaseDriver.driver;
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        captureAndAttachScreenshot(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        captureAndAttachScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // No action needed
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // No action needed
    }

    @Override
    public void onStart(ITestContext context) {
        // No action needed
    }

    @Override
    public void onFinish(ITestContext context) {
        // No action needed
    }

    private void captureAndAttachScreenshot(ITestResult result) {
        if (driver instanceof TakesScreenshot) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            if (screenshotBytes != null) {
                String methodName = result.getMethod().getMethodName();
                Allure.addAttachment("Screenshot_" + methodName, new ByteArrayInputStream(screenshotBytes));
            }
        }
    }
}
