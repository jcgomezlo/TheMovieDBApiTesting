package search;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import utils.PathConstructor;

import static io.restassured.RestAssured.given;

public class SearchAPI {

    private static PathConstructor path = new PathConstructor();

    public static ValidatableResponse getSearchMovie(String query) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(path.getSearchEndPoint(query))
                .then();
    }
}
