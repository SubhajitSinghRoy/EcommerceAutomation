package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driverReference;



    public LoginPage(WebDriver driver) {
        this.driverReference = driver;

        // substitute for driver.findElement()
        PageFactory.initElements(driverReference,this);
    }

    @FindBy(id="userEmail")
    public WebElement userName;

    @FindBy(id="userPassword")
    public WebElement password;

    @FindBy(id="login")
    public WebElement loginBtn;

    public void launchApp(){
        this.driverReference.get("https://rahulshettyacademy.com/client");

    }

    public void loginToApp(String user, String pass){
        this.userName.sendKeys(user);
        this.password.sendKeys(pass);
        loginBtn.click();
    }
}
