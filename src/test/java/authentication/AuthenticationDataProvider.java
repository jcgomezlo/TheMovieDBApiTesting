package authentication;

import org.testng.annotations.DataProvider;
import utils.DataDeliver;


public class AuthenticationDataProvider {

    @DataProvider(name = "ValidCredentials")
    public Object[][] ValidCredentials() {
        return new Object[][]{
                {AuthenticationUtils.USER_ENV, AuthenticationUtils.PASSWORD_ENV}
        };
    }

    @DataProvider(name = "InvalidCredentials")
    public Object[][] InvalidCredentials() {
        return DataDeliver.getInstance("data/data.xlsx").getData("InvalidCredentials");
    }
}
