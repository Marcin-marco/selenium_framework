package pl.marcin.webdriver.configuration;

public class Configuration {
    public static ThreadLocal<String> BROWSER = ThreadLocal.withInitial(() -> System.getProperty("browser", "chrome"));
    public static final String ENVIRONMENT = System.getProperty("environment", "tst");
    public static final String USER_DIRECTORY = System.getProperty("user.dir");
}
