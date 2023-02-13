package testcases;

import dataproviders.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProviderClass = LoginDataProvider.class, dataProvider = "loginData")
    public void shouldLoginToAccount(String email, String password) {
        homePage
                .goToSignupSection()
                .loginToAccount(email, password);
        Assert.assertTrue(homePage.isLogoutButtonDisplayed());
    }
}
