package pl.marcin.webdriver.core;

import pl.marcin.webdriver.core.drivers.browserdriver.BrowserDriver;

public abstract class BrowserAbstract {

    public abstract void setOptions();

    public abstract BrowserDriver create();

    public BrowserDriver getInstance() {
        setOptions();
        BrowserDriver webdriver = create();

        return webdriver;
    }

}
