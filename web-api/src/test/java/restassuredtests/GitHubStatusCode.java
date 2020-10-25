package restassuredtests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class GitHubStatusCode {

    public static String BASE_URL = "https://api.github.com/";

    @Test
    public void getStatusCodeIs200() {
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(200);
    }

}
