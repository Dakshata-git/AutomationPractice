package com.practice.pageobject;

import com.practice.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends TestBase {

    @FindBy(xpath = "//*[contains(text(),'Sign in')]")
    WebElement signInLink;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "passwd")
    WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    WebElement signInButton;

    static String username = "dakshata.3012@gmail.com";
    static String password = "Pass@123";


    public LogInPage() {
        PageFactory.initElements(driver, this);
    }

    public void logUserIn(){
        signInLink.click();
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        signInButton.click();
    }
}
