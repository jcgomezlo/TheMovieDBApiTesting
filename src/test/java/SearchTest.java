import io.restassured.response.ValidatableResponse;
import movies.MoviesProvider;
import org.apache.log4j.Logger;

import org.testng.annotations.Test;
import search.SearchAPI;
import search.SearchUtils;

import static entities.Validator.*;

public class SearchTest extends MoviesProvider {

    private static Logger LOGGER = Logger.getLogger(SearchTest.class);

    @Test(dataProvider = "Movies")
    public void search(String movie){

        LOGGER.info("Starting search of " + movie);
        ValidatableResponse response = SearchAPI.getSearchMovie(movie);
        assertStatusCodeOK(response);
        SearchUtils.assertNumberOfResultsGreaterThan(response,0);
    }


}
