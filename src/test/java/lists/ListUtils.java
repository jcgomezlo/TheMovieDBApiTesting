package lists;

import io.qameta.allure.Step;

import static entities.Utils.*;
import static entities.Validator.*;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.Assert;

public class ListUtils {

    public static final String STATUS_MESSAGE_CREATED = "The item/record was created successfully.";
    public static final String STATUS_MESSAGE_ADDED = "The item/record was updated successfully.";
    public static final String STATUS_MESSAGE_NOT_FOUND = "The resource you requested could not be found.";
    public static final String LIST_ID_PAYLOAD = "list_id";

    @Step("Create List")
    public static int getListId( String name, String description, String language){
        ValidatableResponse res = ListAPI
                .postList( name,description,language);

        attributeOfBodyNotNull(res,LIST_ID_PAYLOAD);
        return res.extract().path(LIST_ID_PAYLOAD);
    }

    @Step("Validate List Doesnt Exist ")
    public static void assertListDoesntExist(int id){
        ValidatableResponse responseListDetails = ListAPI.getListDetails(String.valueOf(id));

        statusCodeEquals(responseListDetails,HttpStatus.SC_NOT_FOUND);
        attributeOfBodyEquals(responseListDetails,STATUS_MESSAGE_PAYLOAD,STATUS_MESSAGE_NOT_FOUND);

    }

    @Step("Add Movie To List")
    public static int addMovieToList(String name, String description, String language, String movieId){
        int id = getListId(name, description, language);
        ValidatableResponse responseMovieAdded = ListAPI.postMovieToList( id,movieId);
        statusCodeEquals(responseMovieAdded, HttpStatus.SC_CREATED);
        return id;
    }

    @Step("Validate Items of List is x Size")
    public static void validateListHasThisItems(int id,int size){
        ValidatableResponse responseListDetails = ListAPI.getListDetails(String.valueOf(id));
        sizeOfArrayOfBodyEquals(responseListDetails,"items",size);
    }

}
