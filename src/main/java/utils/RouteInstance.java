package utils;

import entities.pojos.Route;
import utils.reader.JSONReader;

public class RouteInstance {
    private static Route route;

    public static Route getInstance(){
        if(route == null){
            JSONReader<Route> routeJSONReader = new JSONReader<>(Route.class);
            route = routeJSONReader.readJson("data/paths/paths.json");
//            route.setApiKey(System.getenv("API_KEY_MOVIEDB"));
            route.setApiKey("?api_key=70e5d92b560911960f954e6433e8daa1");
        }
        return route;
    }
}
