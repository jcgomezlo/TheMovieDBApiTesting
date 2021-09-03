package movies;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static entities.Utils.STATUS_MESSAGE_PAYLOAD;
import static entities.Validator.*;
import static org.hamcrest.CoreMatchers.hasItems;

public class MovieUtils {

    public static final String ORIGINAL_TITLE_PAYLOAD = "original_title";
    public static final String GENRES_NAME_PAYLOAD = "genres.name";

    @Step("Validate Title")
    public static void assertTitleOfMovie(ValidatableResponse res, String title){
        attributeOfBodyEquals(res,ORIGINAL_TITLE_PAYLOAD,title);
    }

    @Step("Validate Genre")
    public static void assertGenreOfMovie(ValidatableResponse res, String title){
        res.body(GENRES_NAME_PAYLOAD,hasItems(title));
    }




}
