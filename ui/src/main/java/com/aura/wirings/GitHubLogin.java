package com.aura.wirings;

import org.openqa.selenium.By;

public class GitHubLogin {

    public static By USER_NAME = By.cssSelector("#login_field");
    public static By PASSWORD = By.cssSelector("#password");
    public static By SIGN_IN = By.cssSelector("input[type='submit']");
    public static By ERROR_MESSAGE = By.cssSelector(".flash-error");

}
