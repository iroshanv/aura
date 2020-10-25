package apachehttpclienttests.body.jackson;

import apachehttpclienttests.HttpClientBaseTest;
import entities.RateLimit;
import org.apache.http.client.methods.HttpGet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.ResponseUtility;

import java.io.IOException;

public class GitHubNestedJsonTest extends HttpClientBaseTest {

    @Test
    public void verifySearchLimit() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "rate_limit");
        httpResponse = httpClient.execute(httpGet);

        RateLimit rateLimit = ResponseUtility.unmarshall(httpResponse, RateLimit.class);

        Assertions.assertEquals(60, rateLimit.getCoreLimit());
        Assertions.assertEquals(10, rateLimit.getSearchLimit());

    }


}
