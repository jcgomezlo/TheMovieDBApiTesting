package movies;

import org.testng.annotations.DataProvider;
import utils.DataDeliver;

public class MoviesProvider {

    @DataProvider(name = "Movies")
    public Object[][] movies() {
        return DataDeliver.getInstance("data/data.xlsx").getData("Movies");
    }

    @DataProvider(name = "MovieDetails")
    public Object[][] movieDetails() {
        return DataDeliver.getInstance("data/data.xlsx").getData("MovieDetails");
    }

    @DataProvider(name = "MovieRate")
    public Object[][] movieRate() {
        return DataDeliver.getInstance("data/data.xlsx").getData("MovieRate");
    }
}
