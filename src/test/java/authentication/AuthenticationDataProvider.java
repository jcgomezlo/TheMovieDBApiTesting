package authentication;

import org.testng.annotations.DataProvider;
import utils.DataDeliver;


public class AuthenticationDataProvider {

    @DataProvider(name = "ValidCredentials")
    public Object[][] ValidCredentials() {
        return new Object[][]{
                {System.getenv("USER1_MOVIEDB"), System.getenv("PASS1_MOVIEDB")}
        };

    }

    @DataProvider(name = "InvalidCredentials")
    public Object[][] InvalidCredentials() {
        return DataDeliver.getInstance("data/data.xlsx").getData("InvalidCredentials");
    }
}
