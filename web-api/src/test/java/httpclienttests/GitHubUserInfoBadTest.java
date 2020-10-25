package httpclienttests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubUserInfoBadTest {
    public static String BASE_URL = "https://api.github.com/";

    @Test
    public void assertGitHubUserInfo() throws IOException, InterruptedException {
        //arrange
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL + "users/iroshanv"))
                .setHeader("user-agent", "jav 11 bot")
                .build();

        //act
        HttpResponse<String> response = httpClient.send(get, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        //assert
        Assertions.assertTrue(body.contains("\"login\":\"iroshanv\"")); //quick dirty way
    }
}
