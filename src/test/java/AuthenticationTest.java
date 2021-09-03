import authentication.AuthenticationAPI;
import authentication.AuthenticationUtils;
import authentication.AuthenticationValidator;
import authentication.AuthenticationDataProvider;
import entities.Validator;
import io.restassured.response.ValidatableResponse;
import org.apache.log4j.Logger;

import org.testng.annotations.Test;


public class AuthenticationTest extends AuthenticationDataProvider {

    private static Logger LOGGER = Logger.getLogger(AuthenticationTest.class);

   @Test(dataProvider = "ValidCredentials")
    public void loginSuccessful(String userName, String password){
       LOGGER.info("Valid Credentials Login ....");

       LOGGER.info("Get Request Token");
       ValidatableResponse responseToken = AuthenticationAPI.getRequestToken();
       Validator.assertStatusCodeOK(responseToken);
       String requestToken = AuthenticationUtils.assertRequestTokenNotNull(responseToken);

       LOGGER.info("Authenticate credentials " + requestToken );
       ValidatableResponse responseCredentials = AuthenticationAPI.authenticateCredentials(userName,password,requestToken);
       AuthenticationUtils.assertSuccessPayload(responseCredentials,true);
       Validator.assertStatusCodeOK(responseCredentials);

       LOGGER.info("Get session ID " );
       ValidatableResponse res = AuthenticationAPI.getSessionId(requestToken);
       Validator.assertStatusCodeOK(res);
       AuthenticationUtils.assertSuccessPayload(res,true);
       String sessionId = AuthenticationUtils.assertSessionIdNotNull(res);
       LOGGER.info("SESSION ID: " + sessionId);
    }

    @Test(dataProvider = "InvalidCredentials")
    public void loginInvalid(String userName, String password){
        LOGGER.info("Invalid Credentials Login ....");

        LOGGER.info("Get Request Token");
        ValidatableResponse responseToken = AuthenticationAPI.getRequestToken();
        Validator.assertStatusCodeOK(responseToken);
        String requestToken = AuthenticationUtils.assertRequestTokenNotNull(responseToken);

        LOGGER.info("Authenticate credentials " + requestToken );
        ValidatableResponse responseCredentials = AuthenticationAPI.authenticateCredentials(userName,password,requestToken);
        AuthenticationUtils.assertSuccessPayload(responseCredentials,false);
        Validator.assertStatusCodeUnauthorized(responseCredentials);
    }
}
