package httpclienttests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GitHubPostRepoTest {

    public static String BASE_URL = "https://api.github.com/";

    @Test
    public void assertGitHubPostApiReturns401() throws IOException, InterruptedException {
        //arrange
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL + "user/repos"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .setHeader("credentials", "web-token-password")
                .build();

        //act
        HttpResponse<Void> response = httpClient.send(get, HttpResponse.BodyHandlers.discarding());
        int responseCode = response.statusCode();

        //assert
        Assertions.assertEquals(401, responseCode);
    }
}
