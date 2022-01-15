package com.practice.testcases;

import com.practice.pageobject.SearchPage;
import com.practice.base.TestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC01_SearchAndVerifyFirstResult extends TestBase {

    @BeforeMethod
    public void launchBrowser() {
        initialize_driver();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Search functionality")
    @Epic("Automation Practice")
    @Feature("Verify that you are able to search")
    @Story("perform a search and verify the first result matches your search criteria.")
    @Step("Access the url, click on the search button, enter keyword to be searched then click the search icon")
    @Test()
    @DisplayName("Searching for a particular keyword")
    public void searchingFunctionality() {
        SearchPage searchFunctionality = new SearchPage();
        searchFunctionality.singlesearch();
        driver.close();
    }
}
