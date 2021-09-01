package entities.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Route {

    private String ApiKey;

    @JsonProperty("base")
    private String base;

    @JsonProperty("authentication")
    private AuthenticationRoute authentication;

    @JsonProperty("lists")
    private ListRoute list;

    @JsonProperty("movies")
    private MovieRoute movie;

    public AuthenticationRoute getAuthentication() {
        return authentication;
    }

    public void setAuthentication(AuthenticationRoute authentication) {
        this.authentication = authentication;
    }

    public ListRoute getList() {
        return list;
    }

    public void setList(ListRoute list) {
        this.list = list;
    }

    public MovieRoute getMovie() {
        return movie;
    }

    public void setMovie(MovieRoute movie) {
        this.movie = movie;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getApiKey() {
        return ApiKey;
    }

    public void setApiKey(String apiKey) {
        ApiKey = apiKey;
    }
}


