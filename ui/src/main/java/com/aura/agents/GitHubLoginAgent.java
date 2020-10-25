package com.aura.agents;

import com.aura.base.GodAgent;
import com.aura.wirings.GitHubLogin;

public class GitHubLoginAgent extends GodAgent {

    public GitHubLoginAgent enterUserName(final String userName) {
        getDriver().findElement(GitHubLogin.USER_NAME).sendKeys(userName);
        return this;
    }

    public GitHubLoginAgent enterPassword(final String password) {
        getDriver().findElement(GitHubLogin.PASSWORD).sendKeys(password);
        return this;
    }

    public GitHubLoginAgent clickSignIn() {
        getDriver().findElement(GitHubLogin.SIGN_IN).click();
        return this;
    }

    public GitHubLoginAgent login(final String userName, final String password) {
        enterUserName(userName);
        enterPassword(password);
        clickSignIn();
        return this;
    }

    public String getErrorMessage() {
        return getDriver().findElement(GitHubLogin.ERROR_MESSAGE).getText().trim();
    }

}
