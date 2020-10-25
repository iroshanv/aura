package restassuredtests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class GitHubUserInfo {

    public static String BASE_URL = "https://api.github.com/users/iroshanv";

    @Test
    public void assertUserLoginId() {
        RestAssured.get(BASE_URL)
                .then()
                .assertThat()
                .body("login", equalTo("iroshanv"))
                .body("type", equalTo("User"));
    }
}
