package httpclienttests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class GitHubGetGoodTest {

    public static String BASE_URL = "https://api.github.com/";

    static HttpClient httpClient = HttpClient.newBuilder().build();
    static HttpResponse<Void> httpResponse;


    @BeforeAll
    static public void setUp() throws IOException, InterruptedException {
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .GET()
                .setHeader("User-Agent", "Java 11 http bot")
                .build();

        httpResponse = httpClient.send(get, HttpResponse.BodyHandlers.discarding());
    }

    @ParameterizedTest
    @CsvSource({
            "X-Ratelimit-limit, 60",
            "content-type, application/json; charset=utf-8",
            "server, GitHub.com",
            "x-frame-options, deny",
    })
    public void assertHeaders(String header, String value) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .setHeader("User-Agent", "java 11 http bot")
                .build();

        HttpResponse<Void> response = httpClient.send(get, HttpResponse.BodyHandlers.discarding());
        String xRateLimit = response.headers().firstValue(header).get();
        Assertions.assertEquals(value, xRateLimit);
    }

}

