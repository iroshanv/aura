package apachehttpclienttests;

import org.apache.http.client.methods.HttpOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tools.ResponseUtility;

import java.io.IOException;

public class OptionsAllowed204 extends HttpClientBaseTest {

    @Test
    public void optionsReturnsCorrectMethodList() throws IOException {
        String header = "Access-Control-Allow-Methods";
        String exReply = "GET, POST, PATCH, PUT, DELETE";

        HttpOptions httpOptions = new HttpOptions(BASE_ENDPOINT);
        httpResponse = httpClient.execute(httpOptions);

        Assertions.assertEquals(exReply, ResponseUtility.getHeader(httpResponse, header));

    }

}
