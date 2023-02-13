package testcases;

import dataproviders.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private static final String WRONG_EMAIL = "email@email.com";
    private static final String WRONG_PASSWORD = "password";

    @Test(dataProviderClass = LoginDataProvider.class, dataProvider = "loginData")
    public void shouldLoginToAccount(String email, String password) {
        homePage
                .goToSignupSection()
                .loginToAccount(email, password);
        Assert.assertTrue(homePage.isLogoutButtonDisplayed());
    }

    @Test
    public void shouldNotLoginToAccount() {
        homePage
                .logoutFromAccount()
                .goToSignupSection()
                .loginToAccount(WRONG_EMAIL, WRONG_PASSWORD);
        Assert.assertTrue(loginPage.isWrongCredentialsAlertDisplayed());
    }
}
