package pl.marcin.webdriver.core.drivers.browserdriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import pl.marcin.webdriver.configuration.Configuration;
import pl.marcin.webdriver.utils.TimeUtil;

import java.io.File;
import java.io.IOException;

import static pl.marcin.webdriver.logger.LogType.ERROR;
import static pl.marcin.webdriver.logger.LogType.INFO;
import static pl.marcin.webdriver.logger.Logger.log;

public class BrowserDriver extends EventFiringWebDriver {
    private final WebDriver driver;

    public BrowserDriver(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void takeScreenshot(String testName) {
        String fileDirectoryPath = Configuration.USER_DIRECTORY + "/screenshots";
        String screenshotName = TimeUtil.getCurrentTime().replace(":", ".") + "_" + testName;

        try {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(fileDirectoryPath + "/" + screenshotName + ".png"));
            log(INFO, "Screenshot was saved: " + screenshotName + " in screenshots folder!");
        } catch (IOException e) {
            log(ERROR, "Error occurred when trying save screenshot!");
            e.printStackTrace();
        }
    }
}
