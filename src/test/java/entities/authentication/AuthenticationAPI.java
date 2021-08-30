package entities.authentication;

import com.google.gson.Gson;
import entities.pojos.UserAuthentication;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import utils.PathConstructor;


import static io.restassured.RestAssured.given;

public class AuthenticationAPI {

    private static PathConstructor path = new PathConstructor();
    private static Logger LOGGER = Logger.getLogger(AuthenticationAPI.class);
    private static Gson gson = new Gson();

    @Step("Get request token")
    public static Response getRequestToken(){
        return given().get(path.getRequestTokenEndPoint())
                .then()
                .extract()
                .response();
    }


    @Step("Authenticate credentials")
    public static Response authenticateCredentials(String userName, String password, String requestToken) {
        UserAuthentication user = new UserAuthentication(userName,password,requestToken);
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(gson.toJson(user))
                .when()
                .post(path.getSessionWithLoginEndPoint())
                .then()
                .extract()
                .response();
    }

    @Step("Get Session Id")
    public static Response getSessionId(String requestToken){
        JSONObject request = new JSONObject();
        request.put("request_token",requestToken);

        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post(path.getNewSessionEndPoint())
                .then()
                .extract()
                .response();
    }



}
