package testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pl.marcin.webdriver.configuration.EnvironmentsManager;
import pl.marcin.webdriver.core.drivers.browserdriver.BrowserDriver;
import pl.marcin.webdriver.core.drivers.driverprovider.DriverProvider;
import pl.marcin.webdriver.pages.BasePage;

public class BaseTest extends BasePage {
    protected BrowserDriver driver;

    @BeforeClass
    public void warmUp() {
        driver = DriverProvider.getInstance();
        openHomePage();
    }

    private void openHomePage() {
        String url = EnvironmentsManager.getUrlForEnvironment();
        driver.navigate().to(url);
    }

    @AfterClass
    public void tearDown() {
        DriverProvider.disposeDriver();
    }
}
