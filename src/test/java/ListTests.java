import authentication.AuthenticationUtils;
import io.restassured.response.ValidatableResponse;
import lists.ListAPI;
import lists.ListUtils;
import lists.ListsDataProvider;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.PathConstructor;


import static entities.Validator.*;
import static lists.ListUtils.*;

public class ListTests extends ListsDataProvider {
    private static PathConstructor path = new PathConstructor();
    private static Logger LOGGER = Logger.getLogger(ListTests.class);

    @BeforeClass
    public void setup(){
        LOGGER.info("setup for cases");
        AuthenticationUtils.setSessionId(AuthenticationUtils.USER_ENV, AuthenticationUtils.PASSWORD_ENV);
        LOGGER.info("Session ID: " + AuthenticationUtils.getSessionId());
    }

    @Test(dataProvider = "ListValid")
    public void createList(String name, String description, String language){
        LOGGER.info("Creating List ...");

        ValidatableResponse res = ListAPI.postList(name,description,language);
        statusCodeEquals(res, HttpStatus.SC_CREATED);
        attributeOfBodyNotNull(res,LIST_ID_PAYLOAD);
        attributeOfBodyEquals(res,STATUS_MESSAGE_PAYLOAD,STATUS_MESSAGE_CREATED);
    }

    @Test(dataProvider = "ListDetails")
    public void getDetailsOfList(String id,String createdBy){
        LOGGER.info("Get Details of List Test Started...");

        ValidatableResponse res = ListAPI.getListDetails(id);
        statusCodeEquals(res, HttpStatus.SC_OK);
        attributeOfBodyEquals(res,"created_by", createdBy);
        sizeOfArrayOfBodyEquals(res,"items",0);
    }

    @Test(dataProvider = "ListValid")
    public void addMovieToList(String name, String description, String language){
        LOGGER.info("Add Movie to List Test Started ....");

        int id = ListUtils.getListId(name, description, language);
        LOGGER.info("List Created successfully");

        ValidatableResponse responseMovieAdded = ListAPI.postMovieToList(id,"18");
        statusCodeEquals(responseMovieAdded, HttpStatus.SC_CREATED);
        attributeOfBodyEquals(responseMovieAdded,STATUS_MESSAGE_PAYLOAD,STATUS_MESSAGE_ADDED);
        LOGGER.info("Movie Added successfully");

        ListUtils.validateListHasThisItems(id,1);
        LOGGER.info("Movie Showing in details ...");
    }

    @Test(dataProvider = "ListValid")
    public void clearList(String name, String description, String language){
        LOGGER.info("Clear List Test Started ....");

        int id = ListUtils.addMovieToList(name,description,language,"18");
        LOGGER.info("List Created and Movie Added ...");
        LOGGER.info("ID = " + id);

        ListUtils.validateListHasThisItems(id,1);

        ValidatableResponse responseClearList = ListAPI.postClearList(id);
        statusCodeEquals(responseClearList,HttpStatus.SC_CREATED);

        ListUtils.validateListHasThisItems(id,0);
    }




}
