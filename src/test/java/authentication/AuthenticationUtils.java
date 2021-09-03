package authentication;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static entities.Validator.attributeOfBodyEquals;
import static entities.Validator.attributeOfBodyNotNull;

public class AuthenticationUtils {

    public static final String ERROR_CREDENTIALS = "Invalid username and/or password: You did not provide a valid login.";
    public static final String SUCCESS_PAYLOAD = "success";
    public static final String SESSION_BODY_PAYLOAD = "session_id";
    public static final String REQUEST_TOKEN_PAYLOAD = "request_token";
    public static final String USER_ENV = System.getenv("USER1_MOVIEDB");
    public static final String PASSWORD_ENV = System.getenv("PASS1_MOVIEDB");
    private static String sessionId;


    public static String getRequestToken(){
        return AuthenticationAPI.getRequestToken().extract().path(REQUEST_TOKEN_PAYLOAD);
    }

    public static String getRequestToken(ValidatableResponse res){
        return res.extract().path(REQUEST_TOKEN_PAYLOAD);
    }

    @Step("Request Token Not Null")
    public static String assertRequestTokenNotNull(ValidatableResponse res){
        attributeOfBodyNotNull(res,REQUEST_TOKEN_PAYLOAD);
        return res.extract().path(REQUEST_TOKEN_PAYLOAD);
    }

    @Step("Validate Success Payload")
    public static void assertSuccessPayload(ValidatableResponse res, boolean success){
        attributeOfBodyEquals(res,SUCCESS_PAYLOAD,success);
    }

    @Step("Validate Session ID Not null")
    public static String assertSessionIdNotNull(ValidatableResponse res){
        attributeOfBodyNotNull(res,SESSION_BODY_PAYLOAD);
        return res.extract().path(SESSION_BODY_PAYLOAD);
    }

    private static String setSessionId(String userName, String password){
        String requestToken = getRequestToken();
        AuthenticationAPI.authenticateCredentials(userName,password,requestToken);
        return AuthenticationAPI.getSessionId(requestToken).extract().path(SESSION_BODY_PAYLOAD);
    }

    public static String getSessionId(){
        if(sessionId == null){
            sessionId = setSessionId("jcgomezlo","lapizlapiz");
        }
         return sessionId;
    }


}
