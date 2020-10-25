package base;

import com.aura.DriverFactory;
import com.aura.agents.GitHubLoginAgent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class GodTest {

    private static String ENV_URL = "https://github.com/login";
    protected GitHubLoginAgent loginAgent;
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.getChromeDriver();
        driver.get(ENV_URL);
        loginAgent = new GitHubLoginAgent();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();   //  driver.quit() is used to exit the browser, end the session, tabs, pop-ups
//        driver.close();  //  closes only the window that is in focus
    }

}
