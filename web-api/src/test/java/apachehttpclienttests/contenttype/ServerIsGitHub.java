package apachehttpclienttests.contenttype;

import apachehttpclienttests.HttpClientBaseTest;
import org.apache.http.client.methods.HttpGet;
import org.junit.jupiter.api.Test;
import tools.ResponseUtility;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServerIsGitHub extends HttpClientBaseTest {

    @Test
    public void verifyServerHeader() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT);
        httpResponse = httpClient.execute(httpGet);
        String headerContent = ResponseUtility.getHeader(httpResponse, "server");

        assertEquals("GitHub.com", headerContent);

    }
}
