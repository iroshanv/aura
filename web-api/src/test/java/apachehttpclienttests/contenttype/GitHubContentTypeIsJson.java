package apachehttpclienttests.contenttype;

import apachehttpclienttests.HttpClientBaseTest;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GitHubContentTypeIsJson extends HttpClientBaseTest {

    @Test
    public void verifyGitHubContentTypeIsJson() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT);
        httpResponse = httpClient.execute(httpGet);
        Header headerContent = httpResponse.getEntity().getContentType();

        assertEquals("application/json; charset=utf-8", headerContent.getValue());

        ContentType  contentType = ContentType.getOrDefault(httpResponse.getEntity());
        assertEquals("application/json", contentType.getMimeType());
    }

}
