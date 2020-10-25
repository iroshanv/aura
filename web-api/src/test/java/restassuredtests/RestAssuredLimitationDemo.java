package restassuredtests;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.JsonBodyHandler;
import entities.FailedAuthentication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestAssuredLimitationDemo {

    public static String BASE_URL = "https://api.github.com/";

    // to-do
    @Test
    public void assertPostFailsWithRest() {

        RestAssured.post(BASE_URL + "user/repos")
                .then()
                .statusCode(401)
                .assertThat()
                // fails - incorrect usage
                .body(Matchers.contains("Requires authentication"));

        // "message":"Requires authentication","documentation_url":"https://developer.github.com/v3/repos/#create"
    }


    @Test
    public void assertPostFailsWithHttpClient() throws IOException, InterruptedException {
        //arrange
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL + "user/repos"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        //act
        HttpResponse<FailedAuthentication> response = httpClient.send(get, JsonBodyHandler.jsonBodyHandler(FailedAuthentication.class));
        String message = response.body().getMessage();

        //assert
        Assertions.assertEquals("Requires authentication", message);
    }


}
