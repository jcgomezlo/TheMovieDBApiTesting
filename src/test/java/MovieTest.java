import entities.Validator;
import io.restassured.response.ValidatableResponse;
import movies.MovieAPI;
import movies.MovieUtils;
import movies.MoviesProvider;
import org.apache.log4j.Logger;

import org.testng.annotations.Test;

public class MovieTest extends MoviesProvider {
    private static Logger LOGGER = Logger.getLogger(MovieTest.class);

    @Test(dataProvider = "MovieDetails")
    public void getDetailsOfMovie(String id, String title, String genre){
        ValidatableResponse response = MovieAPI.getMovieDetails(id);
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
