package entities;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static org.hamcrest.Matchers.*;

public class Validator {



    public static void assertStatusCodeOK(ValidatableResponse res){
        statusCodeEquals(res, HttpStatus.SC_OK);
    }

    public static void assertStatusCodeCreated(ValidatableResponse res){
        statusCodeEquals(res, HttpStatus.SC_CREATED);
    }

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
