package testcases.login;

import dataproviders.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import testcases.BaseTest;

public class PositiveLoginTest extends BaseTest {

    @Test(dataProviderClass = LoginDataProvider.class, dataProvider = "loginData")
    public void shouldLoginToAccount(String email, String password) {
        homePage
                .goToSignupSection()
                .loginToAccount(email, password);
        Assert.assertTrue(homePage.isLogoutButtonDisplayed());
    }
}