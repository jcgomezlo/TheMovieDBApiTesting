package entities.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieRoute {

    @JsonProperty("base")
    private String base;

    @JsonProperty("rateMovie")
    private String rateMovie;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getRateMovie() {
        return rateMovie;
    }

    public void setRateMovie(String rateMovie) {
        this.rateMovie = rateMovie;
    }
}
