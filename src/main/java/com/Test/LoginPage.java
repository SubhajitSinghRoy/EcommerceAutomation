package com.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driverReference;


    // substitute for driver.findElement()
    LoginPage(WebDriver driver) {
        this.driverReference = driver;
        PageFactory.initElements(driverReference,this);
    }

    @FindBy(id="userEmail")
    public WebElement userName;



    @FindBy(id="userPassword")
    public WebElement password;

    @FindBy(id="login")
    public WebElement loginBtn;
}
