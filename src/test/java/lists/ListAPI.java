package lists;

import authentication.AuthenticationAPI;
import authentication.AuthenticationUtils;
import com.google.gson.Gson;
import entities.Session;
import entities.pojos.List;
import entities.pojos.UserAuthentication;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import utils.PathConstructor;

import static io.restassured.RestAssured.given;

public class ListAPI {
    private static PathConstructor path = new PathConstructor();
    private static Gson gson = new Gson();


    public static ValidatableResponse postList(String name, String description, String language) {
        List list = new List(name,description,language);
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(gson.toJson(list))
                .when()
                .post(path.getListEndPoint(AuthenticationUtils.getSessionId()))
                .then();
    }



}
