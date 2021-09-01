package entities.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListRoute {
    @JsonProperty("getDetails")
    private String getDetails;

    @JsonProperty("createList")
    private String createList;

    @JsonProperty("addMovie")
    private String addMovie;

    @JsonProperty("clearList")
    private String clearList;

    @JsonProperty("deleteList")
    private String deleteList;

    @JsonProperty("base")
    private String base;

    public String getGetDetails() {
        return getDetails;
    }

    public void setGetDetails(String getDetails) {
        this.getDetails = getDetails;
    }

    public String getCreateList() {
        return createList;
    }

    public void setCreateList(String createList) {
        this.createList = createList;
    }

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

    public String getDeleteList() {
        return deleteList;
    }

    public void setDeleteList(String deleteList) {
        this.deleteList = deleteList;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }
}


