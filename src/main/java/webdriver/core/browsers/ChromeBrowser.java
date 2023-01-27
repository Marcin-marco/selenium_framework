package webdriver.core.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import webdriver.core.BrowserAbstract;
import webdriver.core.drivers.BrowserDriver;

public class ChromeBrowser extends BrowserAbstract {
    private final ChromeOptions chromeOptions = new ChromeOptions();

    @Override
    public void setOptions() {
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-notifications");
    }

    @Override
    public BrowserDriver create() {
        WebDriverManager.chromedriver().setup();

        return new BrowserDriver(new ChromeDriver(chromeOptions));
    }
}
