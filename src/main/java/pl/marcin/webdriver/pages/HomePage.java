package pl.marcin.webdriver.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final By signupBtn = By.xpath("//a[@href='/login']");

    public HomePage goToSignupSection() {
        clickElement(signupBtn);

        return this;
    }
}
