package pl.marcin.webdriver.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By signupBtn = By.xpath("//a[@href='/login']");
    private final By logoutBtn = By.xpath("//a[@href='/logout']");

    public LoginPage goToSignupSection() {
        clickElement(signupBtn);

        return new LoginPage();
    }

    public HomePage logoutFromAccount() {
        clickElement(logoutBtn);

        return this;
    }

    public boolean isLogoutButtonDisplayed() {
        return isElementVisible(logoutBtn);
    }
}
