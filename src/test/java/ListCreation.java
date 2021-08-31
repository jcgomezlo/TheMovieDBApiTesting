import entities.Session;
import entities.lists.ListsDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import utils.PathConstructor;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ListCreation extends ListsDataProvider {
    private static PathConstructor path = new PathConstructor();
    private static Logger LOGGER = Logger.getLogger(ListCreation.class);

    @Test(dataProvider = "ListValid")
    public void createListValid(String name, String description, String language){
        LOGGER.info("Creating List ...");

        JSONObject request = new JSONObject();
        request.put("name",name);
        request.put("description",description);
        request.put("language",language);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post(path.getListEndPoint(Session.getSession()))
                .then()
                .statusCode(201);
        LOGGER.info(System.getenv("USER1_MOVIEDB"));
    }

    @Test(dataProvider = "ListValid")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify the list creation status code is 200")
    public void addMovieToList(String name, String description, String language){
        LOGGER.info("Creating List ...");

        JSONObject request = new JSONObject();
        request.put("name",name);
        request.put("description",description);
        request.put("language",language);

        int id = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post(path.getListEndPoint(Session.getSession()))
                .then()
                .extract()
                .path("list_id");

        request = new JSONObject();
        request.put("media_id",18);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post(path.getAddMovieToListEndPoint(Session.getSession(), String.valueOf(id)))
                .then()
                .statusCode(201)
                .body("status_message", equalTo("The item/record was updated successfully."));
    }




}