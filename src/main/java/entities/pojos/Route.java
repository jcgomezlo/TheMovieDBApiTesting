package entities.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Route {
    @JsonProperty("authentication")
    private AuthenticationRoute authentication;

    @JsonProperty("lists")
    private ListRoute list;

    @JsonProperty("movies")
    private MovieRoute movie;

}


