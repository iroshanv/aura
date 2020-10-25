package apachehttpclienttests.body.jackson;

import apachehttpclienttests.HttpClientBaseTest;
import entities.NoEndPoint;
import org.apache.http.client.methods.HttpGet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.ResponseUtility;

import java.io.IOException;

public class GitHubNoEndPoint extends HttpClientBaseTest {

    @Test
    public void verifyUserLogin() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "noendpoint");
        httpResponse = httpClient.execute(httpGet);

        NoEndPoint noEndPoint = ResponseUtility.unmarshall(httpResponse, NoEndPoint.class);

        Assertions.assertEquals("Not Found", noEndPoint.getMessage());

    }

}
