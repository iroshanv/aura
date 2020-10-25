package apachehttpclienttests.body.jackson;

import apachehttpclienttests.HttpClientBaseTest;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.User;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.ResponseUtility;

import java.io.IOException;

public class GitHubUserBodyUsingJacksonTest extends HttpClientBaseTest {

    @Test
    public void verifyUserLogin() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "users/iroshanv");
        httpResponse = httpClient.execute(httpGet);

        User user = ResponseUtility.unmarshall(httpResponse, User.class);

        Assertions.assertEquals("iroshanv", user.getLogin());
    }

    @Test
    public void verifyUserID() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "users/iroshanv");
        httpResponse = httpClient.execute(httpGet);
        User user = ResponseUtility.unmarshall(httpResponse, User.class);

        Assertions.assertEquals(25766335, user.getId());
    }

}
