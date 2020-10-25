package httpclienttests;

import entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.JsonBodyHandler;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubUserInfoGoodTest {

    public static String BASE_URL = "https://api.github.com/";

    @Test
    public void assertGitHubPostUserInfo() throws IOException, InterruptedException {
        //arrange
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL + "users/iroshanv"))
                .setHeader("user-agent", "jav 11 bot")
                .build();

        //act
        HttpResponse<User> response = httpClient.send(get, JsonBodyHandler.jsonBodyHandler(User.class));
        String loginID = response.body().getLogin();

        //assert
        Assertions.assertEquals("iroshanv", loginID);
    }
}
