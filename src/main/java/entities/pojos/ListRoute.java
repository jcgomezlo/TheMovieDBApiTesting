package entities.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListRoute {

    @JsonProperty("addMovie")
    private String addMovie;

    @JsonProperty("clearList")
    private String clearList;

    @JsonProperty("base")
    private String base;

    public String getAddMovie() {
        return addMovie;
    }

    public void setAddMovie(String addMovie) {
        this.addMovie = addMovie;
    }

    public String getClearList() {
        return clearList;
    }

    public void setClearList(String clearList) {
        this.clearList = clearList;
    }


    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}


