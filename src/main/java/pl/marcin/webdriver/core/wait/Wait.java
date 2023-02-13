package pl.marcin.webdriver.core.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    private WebDriverWait wait;
    private WebDriver driver;

    public Wait(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(500));
    }

    public WebElement forElementClickable(WebElement element) {
        try {
            return wait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            System.err.println("Time out while waiting for element to be clickable!");
            throw e;
        }
    }

    public WebElement forElementClickable(By by) {
        try {
            return wait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.elementToBeClickable(by));
        } catch (TimeoutException e) {
            System.err.println("Time out while waiting for element to be clickable!");
            throw e;
        }
    }

}
