package apachehttpclienttests.statuscodes;

import apachehttpclienttests.HttpClientBaseTest;
import org.apache.http.client.methods.HttpGet;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GitHub200Test extends HttpClientBaseTest {

    @Test
    public void verifyGitHubBaseUrlApiReturns200() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT);
        httpResponse = httpClient.execute(httpGet);
        int responseCode = httpResponse.getStatusLine().getStatusCode();

        assertEquals(200, responseCode);
    }

    @Test
    public void verifyGitHubRateLimitApiReturns200() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "rate_limit");
        httpResponse = httpClient.execute(httpGet);
        int responseCode = httpResponse.getStatusLine().getStatusCode();

        assertEquals(200, responseCode);
    }

    @Test
    public void verifyGitHubUsersApiReturns200() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "users");
        httpResponse = httpClient.execute(httpGet);
        int responseCode = httpResponse.getStatusLine().getStatusCode();

        assertEquals(200, responseCode);
    }

}
