package utils;

import entities.pojos.Route;
import utils.reader.JSONReader;

public class PathConstructor {
    private Route path;

    public static void main(String[] args){
        PathConstructor pathConstructor = new PathConstructor();
        System.out.println(pathConstructor.getRequestTokenEndPoint());
    }

    public PathConstructor(){
        path = RouteInstance.getInstance();
    }

    public String construct(String text){
        return path.getBase()  + text +  path.getApiKey();
    }

    public String construct(String text, String sessionId){
        return path.getBase()  + text +  path.getApiKey() + "&session_id=" + sessionId;
    }

    public String getRequestTokenEndPoint(){
        return construct(path.getAuthentication().getBase() + path.getAuthentication().getCreateRequestToken());
    }
    public String getSessionWithLoginEndPoint(){
        return construct(path.getAuthentication().getBase() + path.getAuthentication().getCreateSessionWithLogin());
    }
    public String getNewSessionEndPoint(){
        return construct(path.getAuthentication().getBase() +path.getAuthentication().getCreateSession());
    }
    public String getListEndPoint(String sessionId){
        return construct(path.getList().getBase(), sessionId);
    }

    public String getAddMovieToListEndPoint(String sessionId, String listId){
        return construct(path.getList().getBase() + "/" + listId + path.getList().getAddMovie() , sessionId);
    }

    public String getSearchEndPoint(String movie){
        return construct("path.getSearchPath()") + "&query="+movie;
    }
}
