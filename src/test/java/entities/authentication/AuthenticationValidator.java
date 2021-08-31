package entities.authentication;

import org.apache.log4j.Logger;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class AuthenticationValidator {
    private static Logger LOGGER = Logger.getLogger(AuthenticationValidator.class);

    public static String validateRequestToken(){
        LOGGER.info("Get Request Token");
         return AuthenticationAPI
                 .getRequestToken()
                 .assertThat()
                 .statusCode(200)
                 .and()
                 .body("success",equalTo(true))
                 .and()
                 .body("request_token",notNullValue())
                 .extract()
                 .path("request_token");
    }

    public static void validateCredentialAuthentication(String userName, String password,String requestToken,boolean isValid){

        LOGGER.info("Authenticate credentials " + requestToken );

        if(isValid){
            AuthenticationAPI
                    .authenticateCredentials(userName,password,requestToken)
                    .assertThat()
                    .statusCode(200)
                    .and()
                    .body("success",equalTo(true));
        } else {
            AuthenticationAPI
                    .authenticateCredentials(userName,password,requestToken)
                    .assertThat()
                    .statusCode(401)
                    .and()
                    .body("success",equalTo(false))
                    .and()
                    .body("status_message",equalTo("Invalid username and/or password: You did not provide a valid login."));

        }
    }

    public static String validateNewSession(String requestToken){
        LOGGER.info("Get session ID " );
        return AuthenticationAPI
                .getSessionId(requestToken)
                .assertThat()
                .statusCode(200)
                .and()
                .body("success",equalTo(true))
                .and()
                .body("session_id",notNullValue())
                .extract()
                .path("session_id");
    }
}
