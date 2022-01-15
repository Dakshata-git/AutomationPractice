package com.practice.pageobject;

import com.practice.base.TestBase;
import com.practice.model.ItemToPurchase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class CartPage extends TestBase {

    @FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line']")
    WebElement productImage;

    @FindBy(xpath = "//*[@title='Add to cart']")
    WebElement addtoCart;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement proceedToCheckout;

    @FindBy(xpath = "//input[@name='quantity_1_1_0_631393']")
    WebElement addQuantity;

    @FindBy(xpath = "//td[@data-title='Unit price']")
    WebElement unitPrice;

    @FindBy(xpath = "//*[@id=\"total_price_container\"]")
    WebElement totalPrice;

    @FindBy(name = "search_query")
    WebElement searchingField;

    @FindBy(name = "submit_search")
    WebElement searchButton;


    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    public void AddIntoCart() throws InterruptedException, AWTException {

        // Setting values for Item Name , Price and Quantity
        ItemToPurchase item= new ItemToPurchase();
        item.setItemName("Faded Short Sleeve T-shirts");
        ItemToPurchase item1= new ItemToPurchase();
        item1.setItemPrice(16.51);
        item1.setItemQuantity(4);
        searchingField.sendKeys(item.getItemName());
        searchButton.click();

        //Scroll to the product list
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        Actions actions = new Actions(driver);

        //Hover on the product
        actions.moveToElement(productImage).build().perform();
        Thread.sleep(1000);

        //click on Add to cart
        addtoCart.click();
        proceedToCheckout.click();
        addQuantity.clear();

        //Enter the item quantity
        addQuantity.sendKeys(String.valueOf(item1.getItemQuantity()));
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        String string = totalPrice.getText();
        String a1 = string.replace("$", "");
        double totalPriceOnUI = Double.parseDouble(a1);
        Assert.assertEquals(totalPriceOnUI,calculateTotalAmount(item1.getItemPrice() ,item1.getItemQuantity()));
    }

    // This is method to calculate total amount
    public double calculateTotalAmount(double unitprice , int qty){

        double shippingCharges = 2.00;
        double calculatedPrice = unitprice * qty + shippingCharges ;
        return calculatedPrice;
    }

}
