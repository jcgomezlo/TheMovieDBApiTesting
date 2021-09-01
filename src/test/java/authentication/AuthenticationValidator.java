package authentication;

import entities.Validator;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

import static org.hamcrest.Matchers.notNullValue;

public class AuthenticationValidator extends Validator {

    private static Logger LOGGER = Logger.getLogger(AuthenticationValidator.class);
    private static final String ERROR_CREDENTIALS = "Invalid username and/or password: You did not provide a valid login.";
    private static final String SUCCESS_BODY = "success";
    private static final String SESSION_BODY = "session_id";
    private static final String REQUEST_TOKEN_BODY = "request_token";

    @Step("Validate Request Token")
    public static String validateRequestToken(){
        LOGGER.info("Get Request Token");
        ValidatableResponse res = AuthenticationAPI.getRequestToken();
        statusCodeEquals(res, HttpStatus.SC_OK);
        attributeOfBodyNotNull(res,REQUEST_TOKEN_BODY);
        return res.extract().path(REQUEST_TOKEN_BODY);
    }

    @Step("Validate Credentials")
    public static void validateCredentialAuthentication(String userName, String password,String requestToken,boolean isValid){
        LOGGER.info("Authenticate credentials " + requestToken );
        ValidatableResponse res = AuthenticationAPI.authenticateCredentials(userName,password,requestToken);
        attributeOfBodyEquals(res,SUCCESS_BODY,isValid);
        if(isValid){
            statusCodeEquals(res,HttpStatus.SC_OK);
        } else {
            statusCodeEquals(res,HttpStatus.SC_UNAUTHORIZED);
            attributeOfBodyEquals(res,"status_message",ERROR_CREDENTIALS);
        }
    }

    @Step("Validate Session Id")
    public static String validateNewSession(String requestToken){
        LOGGER.info("Get session ID " );
        ValidatableResponse res = AuthenticationAPI.getSessionId(requestToken);
        statusCodeEquals(res, HttpStatus.SC_OK);
        attributeOfBodyEquals(res,SUCCESS_BODY,true);
        attributeOfBodyNotNull(res,SESSION_BODY);
        return res.extract().path(SESSION_BODY);
    }
}
