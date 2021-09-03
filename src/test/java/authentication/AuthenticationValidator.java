package authentication;


import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

import static entities.Validator.*;
import static authentication.AuthenticationUtils.*;
import static org.hamcrest.Matchers.notNullValue;

public class AuthenticationValidator {

    private static Logger LOGGER = Logger.getLogger(AuthenticationValidator.class);




    @Step("Validate Credentials")
    public static void validateCredentialAuthentication(String userName, String password,String requestToken,boolean isValid){
        LOGGER.info("Authenticate credentials " + requestToken );
        ValidatableResponse res = AuthenticationAPI.authenticateCredentials(userName,password,requestToken);
        attributeOfBodyEquals(res,SUCCESS_PAYLOAD,isValid);

        if(isValid){
            statusCodeEquals(res,HttpStatus.SC_OK);
            return;
        }

        statusCodeEquals(res,HttpStatus.SC_UNAUTHORIZED);
        attributeOfBodyEquals(res,"status_message",ERROR_CREDENTIALS);

    }

    @Step("Validate Session Id")
    public static String validateNewSession(String requestToken){
        LOGGER.info("Get session ID " );
        ValidatableResponse res = AuthenticationAPI.getSessionId(requestToken);
        statusCodeEquals(res, HttpStatus.SC_OK);
        attributeOfBodyEquals(res,SUCCESS_PAYLOAD,true);
        attributeOfBodyNotNull(res,SESSION_BODY_PAYLOAD);
        return res.extract().path(SESSION_BODY_PAYLOAD);
    }
}
