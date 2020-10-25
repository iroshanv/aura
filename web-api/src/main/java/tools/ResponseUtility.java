package tools;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.User;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ResponseUtility {

    /**
     * get header method value
     * note: built for apache Httpclient
     * @param httpResponse
     * @param headerName
     * @return header
     */
    public static String getHeader(HttpResponse httpResponse , String headerName) {

        List<Header> httpHeaders = Arrays.asList(httpResponse.getAllHeaders());
        Header matchedHeader  = httpHeaders.stream()
                .filter( header -> headerName.equalsIgnoreCase(header.getName()))
                .findFirst()
                .orElseThrow( () -> new RuntimeException( headerName + " header not found"));

        return matchedHeader.getValue();
    }

    /**
     * check if header is present
     * note: works for apache HttpClient
     * @param httpResponse
     * @param headerName
     * @return true/false
     */
    public static boolean isHeaderPresent(HttpResponse httpResponse, String headerName) {
        List<Header> httpHeaders = Arrays.asList(httpResponse.getAllHeaders());
        return httpHeaders.stream()
                .anyMatch( header -> header.getName().equalsIgnoreCase(headerName));
    }

    /**
     * unmarshall done using jackson
     * @param httpResponse
     * @param userClass
     * @return
     * @throws IOException
     */
    public static <T> T unmarshall(CloseableHttpResponse httpResponse, Class<T> userClass) throws IOException {
        final String jsonBody = EntityUtils.toString(httpResponse.getEntity());
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(jsonBody, userClass);
    }
}
