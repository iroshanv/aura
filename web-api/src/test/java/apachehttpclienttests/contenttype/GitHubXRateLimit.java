package apachehttpclienttests.contenttype;

import apachehttpclienttests.HttpClientBaseTest;
import org.apache.http.client.methods.HttpGet;
import org.junit.jupiter.api.Test;
import tools.ResponseUtility;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GitHubXRateLimit extends HttpClientBaseTest {

    @Test
    public void verifyXRateLimit() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT);
        httpResponse = httpClient.execute(httpGet);
        String headerContent = ResponseUtility.getHeader(httpResponse, "X-RateLimit-Limit");

        assertEquals("60", headerContent);
    }
}
