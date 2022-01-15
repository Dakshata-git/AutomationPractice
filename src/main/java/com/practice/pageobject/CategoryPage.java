package com.practice.pageobject;

import com.practice.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CategoryPage extends TestBase {

    // This method will select category and subcategory
    public void selectCatSubCat(String category , String subcategory) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='block_top_menu']//a[@title='"+category+"']"))).build().perform();
        driver.findElement(By.xpath("//*[@id='block_top_menu']//a[@title='"+subcategory+"']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        String pageName = driver.findElement(By.xpath("//span[@class='cat-name'][contains(text(),'"+subcategory+"')]")).getText();
        Assert.assertEquals(pageName.replaceAll("\\s", "").toLowerCase(),subcategory.replaceAll("\\s", "").toLowerCase());
    }
}
