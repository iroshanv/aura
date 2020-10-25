package apachehttpclienttests;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpDelete;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DeleteGitRepo extends HttpClientBaseTest {

    @Test
    public void deleteGitRepo() throws IOException {
        HttpDelete httpDeleteRequest = new HttpDelete(BASE_ENDPOINT + "repos/iroshanv/delete-madi") ;
        httpDeleteRequest.setHeader(HttpHeaders.AUTHORIZATION, "token " + "random-token-number");
        httpResponse = httpClient.execute(httpDeleteRequest);

        int statusCode = httpResponse.getStatusLine().getStatusCode();

        Assertions.assertEquals(204, statusCode);
    }

}
