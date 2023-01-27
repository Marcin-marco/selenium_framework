package webdriver.configuration;

public class Configuration {
    public static ThreadLocal<String> BROWSER = ThreadLocal.withInitial(() -> System.getProperty("browser", "chrome"));
}
