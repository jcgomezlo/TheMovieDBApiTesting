package lists;

import authentication.AuthenticationUtils;
import com.google.gson.Gson;
import entities.pojos.List;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import utils.PathConstructor;

import static io.restassured.RestAssured.given;

public class ListAPI {
    private static PathConstructor path = new PathConstructor();
    private static Gson gson = new Gson();


    public static ValidatableResponse postList( String name, String description, String language) {
        List list = new List(name,description,language);
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(gson.toJson(list))
                .when()
                .post(path.getListEndPoint(AuthenticationUtils.getSessionId()))
                .then();
    }

    public static ValidatableResponse getListDetails(String id) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(path.getDetailsOfList(id))
                .then();
    }

    public static ValidatableResponse postMovieToList( int listId, String movieId) {
        JSONObject request = new JSONObject();
        request.put("media_id",movieId);
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post(path.getAddMovieToListEndPoint(AuthenticationUtils.getSessionId(), String.valueOf(listId)))
                .then();
    }

    public static ValidatableResponse postClearList(int listId) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post(path.getClearListListEndPoint(AuthenticationUtils.getSessionId(), String.valueOf(listId)))
                .then();
    }

    public static ValidatableResponse deleteList(int listId) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .delete(path.getDeleteListEndPoint( AuthenticationUtils.getSessionId(), String.valueOf(listId)))
                .then();
    }



}
