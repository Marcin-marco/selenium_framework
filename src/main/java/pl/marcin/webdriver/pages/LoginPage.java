package pl.marcin.webdriver.pages;

import org.openqa.selenium.By;

import static pl.marcin.webdriver.logger.LogType.INFO;
import static pl.marcin.webdriver.logger.Logger.log;

public class LoginPage extends BasePage {
    private final By emailInput = By.cssSelector("input[data-qa='login-email']");
    private final By passwordInput = By.cssSelector("input[data-qa='login-password']");
    private final By submitBtn = By.cssSelector("button[data-qa='login-button']");
    private final By alert = By.xpath("//p[contains(text(), 'Your email or password is incorrect!')]");

    public LoginPage loginToAccount(String email, String password) {
        typeEmail(email)
                .typePassword(password)
                .clickLoginButton();

        return this;
    }

    private LoginPage typeEmail(String email) {
        sendKeysToElement(emailInput, email);
        log(INFO, "I'm filling field 'email' with a string: " + email);

        return this;
    }

    private LoginPage typePassword(String password) {
        sendKeysToElement(passwordInput, password);
        log(INFO, "I'm filling field 'password' with a string: " + password);

        return this;
    }

    private LoginPage clickLoginButton() {
        clickElement(submitBtn);
        log(INFO, "I'm clicking on 'login' button.");

        return this;
    }

    public boolean isWrongCredentialsAlertDisplayed() {
        return isElementVisible(alert);
    }
}
