import data.DataDrivenProvider;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class example {

    @Test
    public void asdasd() {
        baseURI = "http://localhost:3000";
        Map<String,Object> map = new HashMap<>();
        map.put("firstName", "aasd");
        map.put("lastName", "asd");
        map.put("subjectId", "asd");
        JSONObject request = new JSONObject(map);


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
