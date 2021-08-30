package data;

import Entities.User;

import org.testng.annotations.DataProvider;
import utils.UserData;


public class DataDrivenProvider {
    @DataProvider(name = "DataForPost")
    public User[] dataForPost() {
        return  UserData.getInstance("data/data.xlsx","Sheet1").getData();
    }

    @DataProvider(name = "DataForDelete")
    public Object[][] dataForDelete() {
        return new Object[][]{
                {8}, {9}, {10}
        };
    }
}
