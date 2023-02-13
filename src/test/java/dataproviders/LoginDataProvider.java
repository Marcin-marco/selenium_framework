package dataproviders;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] getCredentials() {
        return new Object[][]{{"NPylvzup@niepodam.pl", "Testowe345"}
        };
    }
}
