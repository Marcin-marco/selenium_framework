package testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pl.marcin.webdriver.configuration.EnvironmentsManager;
import pl.marcin.webdriver.core.drivers.browserdriver.BrowserDriver;
import pl.marcin.webdriver.core.drivers.driverprovider.DriverProvider;
import pl.marcin.webdriver.pages.BasePage;
import pl.marcin.webdriver.pages.HomePage;
import pl.marcin.webdriver.pages.LoginPage;

public class BaseTest extends BasePage {
    protected BrowserDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;

    @BeforeClass
    public void warmUp() {
        driver = DriverProvider.getInstance();
        homePage = new HomePage();
        loginPage = new LoginPage();
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
