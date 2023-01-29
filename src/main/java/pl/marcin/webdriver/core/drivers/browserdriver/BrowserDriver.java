package pl.marcin.webdriver.core.drivers.browserdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BrowserDriver extends EventFiringWebDriver {
    private final WebDriver driver;

    public BrowserDriver(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
