package authentication;

public class AuthenticationUtils {

    public static final String ERROR_CREDENTIALS = "Invalid username and/or password: You did not provide a valid login.";
    public static final String SUCCESS_PAYLOAD = "success";
    public static final String SESSION_BODY_PAYLOAD = "session_id";
    public static final String REQUEST_TOKEN_PAYLOAD = "request_token";
    private static String SessionId;


    public static String getRequestToken(){
        return AuthenticationAPI.getRequestToken().extract().path(REQUEST_TOKEN_PAYLOAD);
    }

    public static void setSessionId(String userName, String password){
        String requestToken = getRequestToken();
        AuthenticationAPI.authenticateCredentials(userName,password,requestToken);
        SessionId = AuthenticationAPI.getSessionId(requestToken).extract().path(SESSION_BODY_PAYLOAD);
    }

    public static String getSessionId(){
        return SessionId;
    }

}
