package pl.marcin.webdriver.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By emailInput = By.cssSelector("input[data-qa='login-email']");
    private final By passwordInput = By.cssSelector("input[data-qa='login-password']");
    private final By submitBtn = By.cssSelector("input[data-qa='login-button']");

    public LoginPage loginToAccount(String email, String password) {
        typeEmail(email)
                .typePassword(password)
                .clickLoginButton();

        return this;
    }

    private LoginPage typeEmail(String email) {
        sendKeysToElement(emailInput, email);

        return this;
    }

    private LoginPage typePassword(String password) {
        sendKeysToElement(passwordInput, password);

        return this;
    }

    private LoginPage clickLoginButton() {
        clickElement(submitBtn);

        return this;
    }
}
