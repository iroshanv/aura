package apachehttpclienttests;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

public class HttpClientBaseTest {

    protected final static String BASE_ENDPOINT = "https://api.github.com/";
    protected CloseableHttpClient httpClient; // HttpClient.class
    protected CloseableHttpResponse httpResponse; // HttpResponse.class

    @BeforeEach
    public void startUp() {
        httpClient = HttpClientBuilder.create().build();
    }

    @AfterEach
    public void tearDown() throws IOException {
        httpClient.close();
        httpResponse.close();
    }
}
