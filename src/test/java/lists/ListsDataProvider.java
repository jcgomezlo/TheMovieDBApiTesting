package lists;

import org.testng.annotations.DataProvider;
import utils.DataDeliver;

public class ListsDataProvider  {
    @DataProvider(name = "ListValid")
    public Object[][] ListValid() {
        return DataDeliver.getInstance("data/data.xlsx").getData("Lists");
    }

    @DataProvider(name = "ListsToDelete")
    public Object[][] ListsToDelete() {
        return DataDeliver.getInstance("data/data.xlsx").getData("ListsDelete");
    }

    @DataProvider(name = "ListsToClear")
    public Object[][] ListsToClear() {
        return DataDeliver.getInstance("data/data.xlsx").getData("ListsClear");
    }

    @DataProvider(name = "ListDetails")
    public Object[][] ListDetails() {
        return DataDeliver.getInstance("data/data.xlsx").getData("ListDetails");
    }

    @DataProvider(name = "ListAddMovie")
    public Object[][] ListAddMovie() {
        return DataDeliver.getInstance("data/data.xlsx").getData("ListsAddMovie");
    }
}
