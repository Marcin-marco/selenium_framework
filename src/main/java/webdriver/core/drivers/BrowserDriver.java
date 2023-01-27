package webdriver.core.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class BrowserDriver extends EventFiringDecorator {
    private final WebDriver driver;

    public BrowserDriver(WebDriver driver) {
        this.driver = driver;
    }
}
