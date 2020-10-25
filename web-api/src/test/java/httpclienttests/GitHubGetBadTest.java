package httpclienttests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class GitHubGetBadTest {

    public static String BASE_URL = "https://api.github.com/";

    @Test
    public void assertGitHubApiReturns200() throws IOException, InterruptedException {
        //arrange
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .GET()
                .setHeader("User-Agent", "Java 11 Http bot")
                .build();

        //act
        HttpResponse<Void> response = httpClient.send(get, HttpResponse.BodyHandlers.discarding());
        int responseCode = response.statusCode();

        //assert
        Assertions.assertEquals(200, responseCode);
    }

    @Test
    public void assertContentTypeIsJson() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .setHeader("User-Agent", "java 11 http bot")
                .build();

        HttpResponse<Void> response = httpClient.send(get, HttpResponse.BodyHandlers.discarding());
        String contentType = response.headers().firstValue("content-type").get();

        Assertions.assertEquals("application/json; charset=utf-8", contentType);
    }


    @Test
    public void assertXRateLimitIsPresent(String header, String value) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .setHeader("User-Agent", "java 11 http bot")
                .build();

        HttpResponse<Void> response = httpClient.send(get, HttpResponse.BodyHandlers.discarding());
        String xRateLimit = response.headers().firstValue("X-Ratelimit-limit").get();
        Assertions.assertEquals(60, xRateLimit);
    }


}
