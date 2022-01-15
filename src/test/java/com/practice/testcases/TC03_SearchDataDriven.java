package com.practice.testcases;

import com.practice.base.TestBase;
import com.practice.pageobject.SearchPage;
import com.practice.util.TestDataProvider;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC03_SearchDataDriven extends TestBase {
    String sheetName = "SearchKeyword";

    @BeforeMethod
    public void launchBrowser() {
        initialize_driver();
    }

    @DataProvider
    public Object[][] getData() {
        TestDataProvider dataProvider = new TestDataProvider();
        Object data[][] = dataProvider.getDataFromSheet(sheetName);
        return data;
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Search functionality")
    @Epic("Automation Practice")
    @Feature("Verify that you are able to search")
    @Story("Verify a data driven approach for search")
    @Step("Access the url, click on the search button, read data from excel and enter keyword to be searched then click the search icon")
    @DisplayName("Searching for a particular keyword by data driven")
    @Test(dataProvider = "getData")
    public void searchingDataDriven_test(String keyword) throws InterruptedException {
        SearchPage searchFunctionality = new SearchPage();
        searchFunctionality.Multisearch(keyword);
        driver.close();
    }
}