import Entities.User;
import data.DataDrivenProvider;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class DataDriven extends DataDrivenProvider {

    @Test(dataProvider = "DataForDelete")
    public void test_delete(int userId){
        baseURI = "http://localhost:3000";
        System.out.println(userId);
        when().delete("/users/"+userId).then().statusCode(200);
    }

//    @Test(dataProvider = "DataForPost")
//    public void test_02(String firstName, String lastName, int subjectId) {
//        baseURI = "http://localhost:3000";
//        JSONObject request = new JSONObject();
//        request.put("firstName", firstName);
//        request.put("lastName", lastName);
//        request.put("subjectId", subjectId);
//
//        given().
//                contentType(ContentType.JSON).
//                accept(ContentType.JSON).
//                body(request.toJSONString()).
//                when().
//                post("/users").
//                then().
//                statusCode(201).
//                log().
//                all();
//
//    }

    @Test(dataProvider = "DataForPost")
    public void test_02(User user) {
        baseURI = "http://localhost:3000";
        JSONObject request = new JSONObject();
        System.out.println(user.getFirstName());
        request.put("firstName", user.getFirstName());
        request.put("lastName", user.getLastName());
        request.put("subjectId", user.getSubjectId());

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().
                all();

    }
}
