package apachehttpclienttests;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class GitHubPostCreateRepo extends HttpClientBaseTest {

    @Test
    public void createRepoWithBasicAuth() throws IOException {
        HttpPost httpPostRequest = new HttpPost(BASE_ENDPOINT + "user/repos");

        String auth = "email-id:password";
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
        String authHeader = "Basic " + new String(encodedAuth);
        httpPostRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

        String json = "{\"name\":\"delete-madi\"}";
        httpPostRequest.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        httpResponse = httpClient.execute(httpPostRequest);

        int statusCode = httpResponse.getStatusLine().getStatusCode();

        Assertions.assertEquals(201, statusCode);
    }


    @Test
    public void createRepoWithTokenAuth() throws IOException {
        HttpPost httpPostRequest = new HttpPost(BASE_ENDPOINT + "user/repos");
        httpPostRequest.setHeader(HttpHeaders.AUTHORIZATION, "token " + "random token numbers");

        String json = "{\"name\":\"delete-madi\"}";
        httpPostRequest.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

        httpResponse = httpClient.execute(httpPostRequest);

        int statusCode = httpResponse.getStatusLine().getStatusCode();

        Assertions.assertEquals(201, statusCode);
    }

}
