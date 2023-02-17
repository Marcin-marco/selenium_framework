package pl.marcin.webdriver.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer {
    private int retryCounter = 0;
    private static final int MAX_RETRIES = 2;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCounter < MAX_RETRIES) {
            retryCounter++;
            return true;
        }
        return false;
    }
}
