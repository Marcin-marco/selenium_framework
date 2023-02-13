package pl.marcin.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.marcin.webdriver.core.drivers.browserdriver.BrowserDriver;
import pl.marcin.webdriver.core.drivers.driverprovider.DriverProvider;
import pl.marcin.webdriver.core.wait.Wait;

public class BasePage {
    protected Wait wait;
    protected BrowserDriver driver = DriverProvider.getInstance();

    public BasePage() {
        this.wait = new Wait(driver);
    }

    public void clickElement(By by) {
        wait.forElementClickable(driver.findElement(by)).click();
    }

    public void sendKeysToElement(By element, String value) {
        WebElement input = wait.forElementClickable(element);
        input.sendKeys(value);
        input.clear();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
