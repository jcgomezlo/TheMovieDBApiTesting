package search;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static entities.Validator.*;

public class SearchUtils {

    public static final String RESULTS_PAYLOAD = "results";

    @Step("Validate number of results")
    public static void assertNumberOfResultsGreaterThan(ValidatableResponse res, int number){
        sizeOfArrayOfBodyGreater(res,RESULTS_PAYLOAD,0);
    }

}
