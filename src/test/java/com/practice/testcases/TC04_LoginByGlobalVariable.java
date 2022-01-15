package com.practice.testcases;

import com.practice.base.TestBase;
import com.practice.pageobject.LogInPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC04_LoginByGlobalVariable extends TestBase {
    @BeforeMethod
    public void launchBrowser() {
        initialize_driver();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Login functionality")
    @Epic("Automation Practice")
    @Feature("Verify that you are able to Login")
    @Story("Verify that when you search for a particular keyword, the results returned contain the information pertaining the searched keyword")
    @Step("Access the url, click on the search button, enter keyword to be searched then click the search icon")
    @Test()
    @DisplayName("Login")
    public void loginByGlobalVariable() {
        LogInPage logInPage = new LogInPage();
        logInPage.logUserIn();
        driver.close();
    }
}

