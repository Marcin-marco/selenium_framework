package webdriver.core;

import org.openqa.selenium.remote.DesiredCapabilities;
import webdriver.core.drivers.BrowserDriver;

public abstract class BrowserAbstract {
    protected DesiredCapabilities capabilities = new DesiredCapabilities();

    public abstract void setOptions();

    public abstract BrowserDriver create();

    public BrowserDriver getInstance() {
        setOptions();
        BrowserDriver webdriver = create();

        return webdriver;
    }

}
