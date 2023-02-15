package pl.marcin.webdriver.pages;

import org.openqa.selenium.By;

import static pl.marcin.webdriver.logger.LogType.INFO;
import static pl.marcin.webdriver.logger.Logger.log;

public class HomePage extends BasePage {
    private final By signupBtn = By.xpath("//a[@href='/login']");
    private final By logoutBtn = By.xpath("//a[@href='/logout']");

    public LoginPage goToSignupSection() {
        clickElement(signupBtn);
        log(INFO, "I'm clicking on 'signup/login' button.");

        return new LoginPage();
    }

    public HomePage logoutFromAccount() {
        clickElement(logoutBtn);
        log(INFO, "I'm clicking on 'logout' button.");

        return this;
    }

    public boolean isLogoutButtonDisplayed() {
        return isElementVisible(logoutBtn);
    }
}
