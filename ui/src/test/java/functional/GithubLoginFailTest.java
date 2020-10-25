package functional;

import base.GodTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GithubLoginFailTest extends GodTest {

    @Test
    public void assertLoginFails() {
        loginAgent.login("fake-user","password");
        Assertions.assertEquals("Incorrect username or password.", loginAgent.getErrorMessage());
    }

}
