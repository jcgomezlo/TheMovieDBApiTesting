package movies;

import authentication.AuthenticationUtils;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.json.simple.JSONObject;
import utils.PathConstructor;

import static io.restassured.RestAssured.given;

public class MovieAPI {
    private static PathConstructor path = new PathConstructor();

    public static ValidatableResponse getMovieDetails(String id) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(path.getMovieDetails(id))
                .then();
    }

    public static ValidatableResponse postRateMovie(String id, String rate) {
        JSONObject request = new JSONObject();
        request.put("value",rate);
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post(path.postMovieRate(AuthenticationUtils.getSessionId(), id))
                .then();
    }
}
