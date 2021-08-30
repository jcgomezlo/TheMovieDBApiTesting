package entities.authentication;

import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;

public class Authentication {
    private static Logger LOGGER = Logger.getLogger(Authentication.class);

    private static String validateRequestToken(){
        LOGGER.info("Get Request Token");
        Response resToken = AuthenticationAPI.getRequestToken();
        Assert.assertEquals(resToken.getStatusCode(),200);
        Assert.assertTrue(resToken.body().path("success"));
        String requestToken = resToken.body().path("request_token");
        Assert.assertNotNull(requestToken);
        return requestToken;
    }

    private static void validateCredentialAuthentication(String userName, String password,String requestToken,boolean isValid){

        LOGGER.info("Authenticate credentials " + requestToken );
        Response resAuthCredentials = AuthenticationAPI.authenticateCredentials(userName,password,requestToken);
        if(isValid){
            Assert.assertEquals(resAuthCredentials.getStatusCode(),200);
            Assert.assertTrue(resAuthCredentials.body().path("success"));
        } else {
            Assert.assertEquals(resAuthCredentials.getStatusCode(),401);
            Assert.assertFalse(resAuthCredentials.body().path("success"));
            Assert.assertEquals(resAuthCredentials.body().path("status_message"),"Invalid username and/or password: You did not provide a valid login.");
        }
    }

    private static String validateNewSession(String requestToken){
        LOGGER.info("Get session ID " );
        Response resSessionId = AuthenticationAPI.getSessionId(requestToken);
        Assert.assertEquals(resSessionId.getStatusCode(),200);
        Assert.assertTrue(resSessionId.body().path("success"));
        String sessionId = resSessionId.body().path("session_id");
        Assert.assertNotNull(sessionId);

        return sessionId;
    }

    public static String loginWithValidCredentials(String userName, String password){
        String requestToken = validateRequestToken();
        validateCredentialAuthentication(userName, password, requestToken, true);
        String sessionId = validateNewSession(requestToken);
        return sessionId;
    }

    public static void loginWithInvalidCredentials(String userName, String password){

        String requestToken = validateRequestToken();
        validateCredentialAuthentication(userName, password, requestToken, false);

    }


}
