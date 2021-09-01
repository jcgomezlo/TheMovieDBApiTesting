package lists;

import entities.Validator;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

public class ListValidator {

    private static final String STATUS_MESSAGE_CREATED = "The item/record was created successfully.";
    private static final String STATUS_MESSAGE_PAYLOAD = "status_message";
    private static final String LIST_ID_PAYLOAD = "status_message";

    public static void validateListCreation(String name, String description, String language){
        ValidatableResponse res = ListAPI.postList(name,description,language);
        Validator.statusCodeEquals(res, HttpStatus.SC_CREATED);
        Validator.attributeOfBodyNotNull(res,LIST_ID_PAYLOAD);
        Validator.attributeOfBodyEquals(res,STATUS_MESSAGE_PAYLOAD,STATUS_MESSAGE_CREATED);
    }

}
