package com.practice.testcases;

import com.practice.base.TestBase;
import com.practice.pageobject.CartPage;
import com.practice.pageobject.CategoryPage;
import com.practice.pageobject.LogInPage;
import com.practice.pageobject.SearchPage;
import com.practice.util.TestDataProvider;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;

public class TC05_AddToCart extends TestBase {
    String sheetName = "AddToCart";

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
    @Description("Add to Cart functionality")
    @Epic("Automation Practice")
    @Feature("Verify displayed total matches calculated total from Add to cart")
    @Story("Verify displayed total matches calculated total in Add to Cart")
    @Step("Access the url, click on the search product and add to cart then calculate total amount")
    @DisplayName("Add to Cart")
    @Test()
    public void addToCart_test() throws InterruptedException, AWTException {
        CartPage cartPage = new CartPage();
        LogInPage logInPage = new LogInPage();
        logInPage.logUserIn();
        cartPage.AddIntoCart();
        driver.close();
    }
}
