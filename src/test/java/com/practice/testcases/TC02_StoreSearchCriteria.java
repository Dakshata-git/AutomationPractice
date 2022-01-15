package com.practice.testcases;

import com.practice.base.TestBase;
import com.practice.pageobject.SearchPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC02_StoreSearchCriteria extends TestBase {
    @BeforeMethod
    public void launchBrowser() {
        initialize_driver();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Search functionality")
    @Epic("Automation Practice")
    @Feature("Verify that you are able to search")
    @Story("Manipulate the string and store each search criteria in an array and use loop to perform the search and verify.")
    @Step("Access the url, Stored Search Criteria , click on the search button, enter keyword to be searched then click the search icon")
    @Test()
    @DisplayName("Searching for a particular keyword stored in search criteria")
    public void searchingByStoredData() throws InterruptedException {
        SearchPage searchFunctionality = new SearchPage();
        searchFunctionality.searchByStringValue();
        driver.close();
    }
}
