package pl.marcin.webdriver.listener;

import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import pl.marcin.webdriver.core.drivers.browserdriver.BrowserDriver;
import pl.marcin.webdriver.core.drivers.driverprovider.DriverProvider;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static pl.marcin.webdriver.logger.LogType.TEST_FAILED;
import static pl.marcin.webdriver.logger.LogType.TEST_SKIPPED;
import static pl.marcin.webdriver.logger.LogType.TEST_SUCCESS;
import static pl.marcin.webdriver.logger.Logger.addTestHeader;
import static pl.marcin.webdriver.logger.Logger.clearLogTable;
import static pl.marcin.webdriver.logger.Logger.log;
import static pl.marcin.webdriver.logger.Logger.printLogs;

public class Listener implements ITestListener, IAnnotationTransformer {

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
        BrowserDriver browserDriver = DriverProvider.getInstance();
        browserDriver.takeScreenshot(result.getName());
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

    @Override
    public void transform(ITestAnnotation annotation,
                          Class testClass,
                          Constructor testConstructor,
                          Method testMethod) {
        annotation.setRetryAnalyzer(RetryFailedTest.class);
    }
}
