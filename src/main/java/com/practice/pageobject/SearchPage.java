package com.practice.pageobject;

import com.practice.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends TestBase {

    @FindBy(name = "search_query")
    WebElement searchingField;

    @FindBy(name = "submit_search")
    WebElement searchButton;

    @FindBy(xpath = "//div[@class='product-container']")
    List<WebElement> resultSet;

    public SearchPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean singlesearch() {
        searchingField.sendKeys("Dress");
        searchButton.click();
        for (WebElement element : resultSet) {
            List<WebElement> productlist = element.findElements(By.xpath("//a[@class='product-name']"));
            if (productlist.get(0).getText().contains("Dress")) {
                System.out.println("Congradulations !!! Your Result is Matching");
                return true;
            }
        }
        System.out.println("Bad Luck !!! Your Result is  NOT Matching");
        return false;
    }

    public boolean Multisearch(String keyword) throws InterruptedException {
        searchingField.sendKeys(keyword);
        searchButton.click();

        for (WebElement element : resultSet) {
            List<WebElement> productlist = element.findElements(By.xpath("//a[@class='product-name']"));

            if (productlist.size() > 0) {
                for (WebElement element1 : productlist) {
                    if (element1.getText().contains(keyword)) {
                        System.out.println("Congradulations !!! Your Result is Matching");
                        return true;
                    }
                }
            }
            System.out.println("Bad Luck !!! Your Result is  NOT Matching");
        }
        return false;
    }

    public void searchByStringValue() throws InterruptedException {
        String[] strArray = {"Faded Short Sleeve T-shirts", "Summer Dress", "T-shirts"};
        //iterating all elements in the array
        boolean found = false;
        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
            searchingField.clear();
            searchingField.sendKeys(strArray[i]);
            searchButton.click();
            for (WebElement element : resultSet) {
                List<WebElement> productlist = element.findElements(By.xpath("//a[@class='product-name']"));
                if (productlist.size() > 0) {
                    for (WebElement element1 : productlist) {
                        if (element1.getText().contains(strArray[i])) {
                            found = true;
                            break;
                        }
                    }
                }
            }
            if(found)
                System.out.println("Congradulations !!! Your Result is Matching");
            else
                System.out.println("Bad Luck !!! Your Result is  NOT Matching");
        }
    }
}


