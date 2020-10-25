package apachehttpclienttests.statuscodes;

import apachehttpclienttests.HttpClientBaseTest;
import org.apache.http.client.methods.HttpGet;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GitHub401Test extends HttpClientBaseTest {

    @Test
    public void verifyGitHubUnauthorizedUserReturns401() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "user");
        httpResponse = httpClient.execute(httpGet);
        int responseCode = httpResponse.getStatusLine().getStatusCode();

        assertEquals(401, responseCode);
    }

    @Test
    public void verifyGitHubUnauthorizedUserNotificationsReturns401() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "notifications");
        httpResponse = httpClient.execute(httpGet);
        int responseCode = httpResponse.getStatusLine().getStatusCode();

        assertEquals(401, responseCode);
    }

    @Test
    public void verifyGitHubUnauthorizedUserFollowersReturns401() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "user/followers");
        httpResponse = httpClient.execute(httpGet);
        int responseCode = httpResponse.getStatusLine().getStatusCode();

        assertEquals(401, responseCode);
    }

}
