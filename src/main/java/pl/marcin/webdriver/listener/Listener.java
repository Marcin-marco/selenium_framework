package pl.marcin.webdriver.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import static pl.marcin.webdriver.logger.LogType.TEST_FAILED;
import static pl.marcin.webdriver.logger.LogType.TEST_SKIPPED;
import static pl.marcin.webdriver.logger.LogType.TEST_SUCCESS;
import static pl.marcin.webdriver.logger.Logger.addTestHeader;
import static pl.marcin.webdriver.logger.Logger.clearLogTable;
import static pl.marcin.webdriver.logger.Logger.log;
import static pl.marcin.webdriver.logger.Logger.printLogs;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        addTestHeader(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        double timeSpent = (double) (result.getEndMillis() - result.getStartMillis()) / 1000;
        log(TEST_SUCCESS, "Test " + result.getName() + " ended successfully! Time lasted: " + timeSpent + " seconds");
        printLogs();
        clearLogTable();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        double timeSpent = (double) (result.getEndMillis() - result.getStartMillis()) / 1000;
        log(TEST_FAILED, "Test " + result.getName() + " was failed! Time lasted: " + timeSpent + " seconds");
        printLogs();
        clearLogTable();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        double timeSpent = (double) (result.getEndMillis() - result.getStartMillis()) / 1000;
        log(TEST_SKIPPED, "Test " + result.getName() + " was skipped! Time lasted: " + timeSpent + " seconds");
        printLogs();
        clearLogTable();
    }
}
