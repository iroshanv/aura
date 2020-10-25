package com.aura.base;

import com.aura.DriverFactory;
import org.openqa.selenium.WebDriver;

public class GodAgent {

    private WebDriver driver;

    public WebDriver getDriver() {
        driver = DriverFactory.getChromeDriver();
        return driver;
    }

}
