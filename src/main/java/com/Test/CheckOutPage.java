package com.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    WebDriver driver;

    @FindBy(xpath="//a[text()='Place Order ']")
    WebElement orderBtn;

    CheckOutPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
