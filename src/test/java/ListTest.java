import entities.Validator;
import io.restassured.response.ValidatableResponse;
import lists.ListAPI;
import lists.ListUtils;
import lists.ListsDataProvider;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

import org.testng.annotations.Test;
import utils.PathConstructor;

import static entities.Utils.*;
import static entities.Validator.*;
import static lists.ListUtils.*;

public class ListTest extends ListsDataProvider {
    private static PathConstructor path = new PathConstructor();
    private static Logger LOGGER = Logger.getLogger(ListTest.class);


    @Test(dataProvider = "ListValid")
    public void createList(String name, String description, String language){
        LOGGER.info("Creating List ...");

        ValidatableResponse res = ListAPI.postList(name,description,language);
        Validator.assertStatusCodeCreated(res);
        ListUtils.assertListIdNotNull(res);
        ListUtils.assertStatusMessageValue(res, STATUS_MESSAGE_CREATED);
    }

    @Test(dataProvider = "ListDetails")
    public void getDetailsOfList(String id,String createdBy){
        LOGGER.info("Get Details of List Test Started...");

        ValidatableResponse res = ListAPI.getListDetails(id);
        Validator.assertStatusCodeOK(res);
        attributeOfBodyEquals(res,"created_by", createdBy);
        sizeOfArrayOfBodyEquals(res,"items",0);
    }

    @Test(dataProvider = "ListValid")
    public void addMovieToList(String name, String description, String language){
        LOGGER.info("Add Movie to List Test Started ....");

        int id = ListUtils.getListId(name, description, language);
        LOGGER.info("List Created successfully");

        ValidatableResponse responseMovieAdded = ListAPI.postMovieToList(id,"18");
        Validator.assertStatusCodeCreated(responseMovieAdded);
        ListUtils.assertStatusMessageValue(responseMovieAdded, STATUS_MESSAGE_ADDED);
        LOGGER.info("Movie Added successfully");

        ListUtils.validateListHasThisItems(id,1);
        LOGGER.info("Movie Showing in details ...");
    }

    @Test(dataProvider = "ListsToClear")
    public void clearList(String name, String description, String language){
        LOGGER.info("Clear List Test Started ....");

        int id = ListUtils.addMovieToList( name,description,language,"18");
        LOGGER.info("List Created and Movie Added ...");
        LOGGER.info("ID = " + id);

        ListUtils.validateListHasThisItems(id,1);

        ValidatableResponse responseClearList = ListAPI.postClearList(id);
        Validator.assertStatusCodeCreated(responseClearList);

        ListUtils.validateListHasThisItems(id,0);
    }

    @Test(dataProvider = "ListsToDelete")
    public void deleteList(String name, String description, String language){
        LOGGER.info("Delete List Test Started ....");

        int id = ListUtils.getListId( name, description, language);
        LOGGER.info("List Created  ...");
        LOGGER.info("ID = " + id);

        ListAPI.deleteList(id);
        ListUtils.assertListDoesntExist(id);
    }




}
