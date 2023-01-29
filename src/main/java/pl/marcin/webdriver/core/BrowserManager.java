package pl.marcin.webdriver.core;

import pl.marcin.webdriver.configuration.Configuration;
import pl.marcin.webdriver.core.browsers.ChromeBrowser;
import pl.marcin.webdriver.core.browsers.FirefoxBrowser;
import pl.marcin.webdriver.core.drivers.browserdriver.BrowserDriver;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public abstract class BrowserManager {
    private static final Map<String, Class<? extends BrowserAbstract>> browsers = createBrowsersMap();

    private static Map<String, Class<? extends BrowserAbstract>> createBrowsersMap() {
        Map<String, Class<? extends BrowserAbstract>> map = new HashMap<>();

        map.put("CHROME", ChromeBrowser.class);
        map.put("FIREFOX", FirefoxBrowser.class);

        return map;
    }

    public static BrowserDriver getBrowserInstance() {
        String browser = Configuration.BROWSER.get();
        try {
            return browsers.get(browser.toUpperCase()).getDeclaredConstructor().newInstance().getInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
