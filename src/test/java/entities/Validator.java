package entities;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

public class Validator {
    @Step("Validate Status Code")
    public static void statusCodeEquals(ValidatableResponse res, int code){
        res.assertThat().statusCode(code);
    }

    @Step("Validate Payload Value")
    public static void attributeOfBodyEquals(ValidatableResponse res, String attributeName, Object expected){
        res.assertThat().body(attributeName,equalTo(expected));
    }

    @Step("Validate Not Null Payload Value")
    public static void attributeOfBodyNotNull(ValidatableResponse res, String attributeName){
        res.assertThat().body(attributeName,notNullValue());
    }

    @Step("Size of Array in Payload")
    public static void sizeOfArrayOfBodyEquals(ValidatableResponse res, String attributeName, int size){
        res.assertThat().body(attributeName + ".size()",is(size));
    }

}
