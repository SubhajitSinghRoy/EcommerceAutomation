package com.pageObjects;

import com.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponent {

    WebDriver driverReference;



    public LoginPage(WebDriver driver) {
        super(driver); // send driver object to the parent class -> AbstractComponent
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

    @FindBy(xpath = "//div[@role='alert']")
    WebElement loginErrorAlert;



    public HomePage loginToApp(String user, String pass){
        this.userName.sendKeys(user);
        this.password.sendKeys(pass);
        loginBtn.click();

        return new HomePage(driverReference);
    }

    public String errorMessage()
    {
        waitForWebElementToAppear(loginErrorAlert);
        return loginErrorAlert.getText();
    }
}
