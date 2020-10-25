package restassuredtests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class GitHubHeaders {

    public static String BASE_URL = "https://api.github.com/";

    @Test
    public void assertHeaders() {
        RestAssured.get(BASE_URL)
                .then()
                .assertThat()
                .header("content-type", "application/json; charset=utf-8")
                .header("X-Ratelimit-limit", "60");
    }
}
