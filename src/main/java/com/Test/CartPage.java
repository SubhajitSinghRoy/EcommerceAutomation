package com.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

   @FindBy(xpath="//*[text()='Checkout']")
   WebElement checkoutBtn;

    CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
