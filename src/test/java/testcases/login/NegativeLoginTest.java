package testcases.login;

import org.testng.Assert;
import org.testng.annotations.Test;
import testcases.BaseTest;

public class NegativeLoginTest extends BaseTest {
    private static final String WRONG_EMAIL = "email@email.com";
    private static final String WRONG_PASSWORD = "password";

    @Test
    public void shouldNotLoginToAccount() {
        homePage
                .logoutFromAccount()
                .goToSignupSection()
                .loginToAccount(WRONG_EMAIL, WRONG_PASSWORD);
        Assert.assertTrue(loginPage.isWrongCredentialsAlertDisplayed());
    }
}
