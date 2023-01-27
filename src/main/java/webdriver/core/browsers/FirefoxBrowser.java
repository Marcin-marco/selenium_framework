package webdriver.core.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import webdriver.core.BrowserAbstract;
import webdriver.core.drivers.BrowserDriver;

public class FirefoxBrowser extends BrowserAbstract {
    private final FirefoxOptions firefoxOptions = new FirefoxOptions();

    @Override
    public void setOptions() {
        firefoxOptions.addArguments("--window-size=1920,1080");
    }

    @Override
    public BrowserDriver create() {
        WebDriverManager.firefoxdriver().setup();

        return new BrowserDriver(new FirefoxDriver(firefoxOptions));
    }
}
