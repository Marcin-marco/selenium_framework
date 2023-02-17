package pl.marcin.webdriver.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static pl.marcin.webdriver.logger.LogType.INFO;
import static pl.marcin.webdriver.logger.Logger.log;

public class HomePage extends BasePage {
    private final By signupBtn = By.xpath("//a[@href='/login']");
    private final By logoutBtn = By.xpath("//a[@href='/logout']");

    @Step("Go to login to account.")
    public LoginPage goToSignupSection() {
        clickElement(signupBtn);
        log(INFO, "I'm clicking on 'signup/login' button.");

        return new LoginPage();
    }

    @Step("Logout from account.")
    public HomePage logoutFromAccount() {
        clickElement(logoutBtn);
        log(INFO, "I'm clicking on 'logout' button.");

        return this;
    }

    public boolean isLogoutButtonDisplayed() {
        return isElementVisible(logoutBtn);
    }
}
