import io.restassured.response.ValidatableResponse;
import movies.MoviesProvider;
import org.apache.log4j.Logger;

import org.testng.annotations.Test;
import search.SearchAPI;
import search.SearchUtils;
import utils.PathConstructor;

import static entities.Validator.*;

public class Search extends MoviesProvider {

    private static PathConstructor path = new PathConstructor();
    private static Logger LOGGER = Logger.getLogger(Search.class);

    @Test(dataProvider = "Movies")
    public void search(String movie){

        LOGGER.info("Starting search of " + movie);
        ValidatableResponse response = SearchAPI.getSearchMovie(movie);
        assertStatusCodeOK(response);
        SearchUtils.assertNumberOfResultsGreaterThan(response,0);
    }


}
