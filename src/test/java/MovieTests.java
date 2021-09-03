import authentication.AuthenticationUtils;
import entities.Validator;
import io.restassured.response.ValidatableResponse;
import lists.ListAPI;
import lists.ListUtils;
import lists.ListsDataProvider;
import movies.MovieAPI;
import movies.MovieUtils;
import movies.MoviesProvider;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.PathConstructor;

public class MovieTests extends MoviesProvider {
    private static Logger LOGGER = Logger.getLogger(MovieTests.class);

    @Test(dataProvider = "MovieDetails")
    public void getDetailsOfMovie(String id, String title, String genre){
        ValidatableResponse response = MovieAPI.getListDetails(id);
        MovieUtils.assertTitleOfMovie(response,title);
        MovieUtils.assertGenreOfMovie(response,genre);
        Validator.assertStatusCodeOK(response);
    }

    @Test(dataProvider = "MovieRate")
    public void rateMovie(String id, String rate){
        ValidatableResponse response = MovieAPI.postRateMovie(id, rate);
        Validator.assertStatusCodeCreated(response);
    }
}
