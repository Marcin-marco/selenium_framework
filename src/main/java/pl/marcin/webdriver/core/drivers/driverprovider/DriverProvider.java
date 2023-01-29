package pl.marcin.webdriver.core.drivers.driverprovider;

import pl.marcin.webdriver.core.BrowserManager;
import pl.marcin.webdriver.core.drivers.browserdriver.BrowserDriver;

public abstract class DriverProvider {
    private static final ThreadLocal<BrowserDriver> driver = new ThreadLocal<>();

    private DriverProvider() {
    }

    private static void createNewInstance() {
        driver.set(BrowserManager.getBrowserInstance());
    }

    public static BrowserDriver getInstance() {
        if (driver.get() == null) {
            createNewInstance();
        }
        return driver.get();
    }

    public static void disposeDriver() {
        if (driver.get() != null) {
            try {
                driver.get().quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
            driver.remove();
        }
    }
}
