package com.practice.testcases;

import com.practice.base.TestBase;
import com.practice.pageobject.CartPage;
import com.practice.pageobject.CategoryPage;
import com.practice.util.TestDataProvider;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC06_CategorySubCategory extends TestBase {

    @BeforeMethod
    public void launchBrowser() {
        initialize_driver();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Category and SubCategory functionality")
    @Epic("Automation Practice")
    @Feature("Verify that you are able to select Category and Subcategory")
    @Story("Verify that correct page has loaded after selecting Category and Subcategory.")
    @Step("Access the url, click Category and Subcategory")
    @DisplayName("Searching for a Category and Subcategory")
    @Test()
    public void searchingFunctionality_test() {
        CategoryPage categoryPage = new CategoryPage();
        categoryPage.selectCatSubCat("Women","Blouses");
        driver.close();
    }
}
