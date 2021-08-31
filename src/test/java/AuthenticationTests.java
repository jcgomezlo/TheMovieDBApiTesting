import entities.authentication.AuthenticationValidator;
import entities.authentication.AuthenticationDataProvider;
import org.apache.log4j.Logger;

import org.testng.annotations.Test;
import utils.PathConstructor;


public class AuthenticationTests extends AuthenticationDataProvider {

    private static PathConstructor path = new PathConstructor();
    private static Logger LOGGER = Logger.getLogger(AuthenticationTests.class);

   @Test(dataProvider = "ValidCredentials")
    public void loginSuccessful(String userName, String password){
       LOGGER.info("loginSuccessful Test");
       String requestToken = AuthenticationValidator.validateRequestToken();
       AuthenticationValidator.validateCredentialAuthentication(userName, password, requestToken, true);
       AuthenticationValidator.validateNewSession(requestToken);
    }

    @Test(dataProvider = "InvalidCredentials")
    public void loginInvalid(String userName, String password){
        LOGGER.info("loginInvalid Test");
        String requestToken = AuthenticationValidator.validateRequestToken();
        AuthenticationValidator.validateCredentialAuthentication(userName, password, requestToken, false);
    }
}
