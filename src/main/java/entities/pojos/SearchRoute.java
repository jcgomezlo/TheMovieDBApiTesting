package entities.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchRoute {

    @JsonProperty("movie")
    private String movie;

    @JsonProperty("base")
    private String base;

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
