package apachehttpclienttests.statuscodes;

import apachehttpclienttests.HttpClientBaseTest;
import org.apache.http.client.methods.HttpGet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GitHub404Test extends HttpClientBaseTest {


    @Test
    public void verifyGitHubNonExistingURlReturns404() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "non_existing_url");
        httpResponse = httpClient.execute(httpGet);
        int responseCode = httpResponse.getStatusLine().getStatusCode();

        Assertions.assertEquals(404, responseCode);
    }
}
