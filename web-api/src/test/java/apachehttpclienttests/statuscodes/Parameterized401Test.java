package apachehttpclienttests.statuscodes;

import apachehttpclienttests.HttpClientBaseTest;
import org.apache.http.client.methods.HttpGet;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Parameterized401Test extends HttpClientBaseTest {

    @ParameterizedTest
    @CsvSource({
            "user","notifications","user/followers"
    })
    public void verifyGitHubUnauthorizedUserReturns401(String endPoint) throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + endPoint);
        httpResponse = httpClient.execute(httpGet);
        int responseCode = httpResponse.getStatusLine().getStatusCode();

        assertEquals(401, responseCode);
    }
}
