package entities.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieRoute {
    @JsonProperty("getDetails")
    private String getDetails;

    @JsonProperty("base")
    private String base;

    @JsonProperty("rateMovie")
    private String rateMovie;

    public String getGetDetails() {
        return getDetails;
    }

    public void setGetDetails(String getDetails) {
        this.getDetails = getDetails;
    }

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
