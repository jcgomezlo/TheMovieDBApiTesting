import entities.authentication.Authentication;
import entities.authentication.AuthenticationDataProvider;
import org.apache.log4j.Logger;

import org.testng.annotations.Test;
import utils.PathConstructor;

import static io.restassured.RestAssured.given;

public class AuthenticationTests extends AuthenticationDataProvider {

    private static PathConstructor path = new PathConstructor();
    private static Logger LOGGER = Logger.getLogger(AuthenticationTests.class);

   @Test(dataProvider = "ValidCredentials")
    public void loginSuccessful(String userName, String password){
       LOGGER.info("loginSuccessful Test");
        Authentication.loginWithValidCredentials(userName,password);
    }

    @Test(dataProvider = "InvalidCredentials")
    public void loginInvalid(String username, String password){
        LOGGER.info("loginInvalid Test");
        Authentication.loginWithInvalidCredentials(username,password);
    }
}
