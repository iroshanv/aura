package apachehttpclienttests.body.jsonobject;

import apachehttpclienttests.HttpClientBaseTest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GitHubUserBodyUsingJsonObjectTest extends HttpClientBaseTest {

    @Test
    public void verifyUserLogin() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "users/iroshanv");
        httpResponse = httpClient.execute(httpGet);
        String jsonBody = EntityUtils.toString(httpResponse.getEntity());
        JSONObject jsonObject = new JSONObject(jsonBody);
        String userLogin = (String)getValueFor(jsonObject, "login");

        Assertions.assertEquals("iroshanv", userLogin);
    }

    @Test
    public void verifyUserID() throws IOException {
        HttpGet httpGet = new HttpGet(BASE_ENDPOINT + "users/iroshanv");
        httpResponse = httpClient.execute(httpGet);
        String jsonBody = EntityUtils.toString(httpResponse.getEntity());
        JSONObject jsonObject = new JSONObject(jsonBody);
        Integer userId = (Integer)getValueFor(jsonObject, "id");

        Assertions.assertEquals(25766335, userId);
    }

    private Object getValueFor(JSONObject jsonObject, String login) {
        return jsonObject.get(login);
    }

}
