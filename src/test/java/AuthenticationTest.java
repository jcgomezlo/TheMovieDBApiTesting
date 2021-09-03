import authentication.AuthenticationValidator;
import authentication.AuthenticationDataProvider;
import org.apache.log4j.Logger;

import org.testng.annotations.Test;


public class AuthenticationTest extends AuthenticationDataProvider {

    private static Logger LOGGER = Logger.getLogger(AuthenticationTest.class);

   @Test(dataProvider = "ValidCredentials")
    public void loginSuccessful(String userName, String password){
       LOGGER.info("Valid Credentials Login ....");
       String requestToken = AuthenticationValidator.validateRequestToken();
       AuthenticationValidator.validateCredentialAuthentication(userName, password, requestToken, true);
       AuthenticationValidator.validateNewSession(requestToken);
    }

    @Test(dataProvider = "InvalidCredentials")
    public void loginInvalid(String userName, String password){
        LOGGER.info("Invalid Credentials Login ....");
        String requestToken = AuthenticationValidator.validateRequestToken();
        AuthenticationValidator.validateCredentialAuthentication(userName, password, requestToken, false);
    }
}
