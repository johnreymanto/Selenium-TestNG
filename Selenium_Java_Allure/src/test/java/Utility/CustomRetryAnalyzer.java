package Utility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class CustomRetryAnalyzer implements IRetryAnalyzer {
    public int maxRetryCount = 3; // Set the maximum retry count

    @Override
    public boolean retry(ITestResult result) {
        return result.getStatus() == ITestResult.FAILURE && maxRetryCount-- > 0;
    }
}
