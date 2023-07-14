package com.AbstractComponents;

import com.pageObjects.CartPage;
import com.pageObjects.LoginPage;
import com.pageObjects.OrderPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class AbstractComponent {

    WebDriver driver;

    public static String CORRECT_NO_PRODUCT_MSG="No Products in Your Cart !";
    public static String INCORRECT_NO_PRODUCT_MSG="No Products in Your Cart !?";

    @FindBy(xpath = "(//button[@class='btn btn-custom'])[3]")
    WebElement cartBtn;

    @FindBy(xpath="//*[contains(text(),'ORDERS')]")
    WebElement orderBtn;

    @FindBy(xpath = "//*[contains(text(),'Sign Out')]")
    WebElement logOutBtn;

    public AbstractComponent(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }


    // this method is kept in AbstractComponent as it is common for many pages

    public CartPage clickCartButton() {
        this.cartBtn.click();
        return new CartPage(driver);
    }

    public OrderPage clickOrderBtn()
    {
    javaScriptExecutorClick(this.orderBtn);
        return new OrderPage(driver);
    }

    public void hardWait(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void waitForElementToAppear(By byLocator){
        WebDriverWait wait=  new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));

    }

    public void waitForElementToDisappear(By byLocator){

        WebDriverWait wait = new WebDriverWait(driver,5);
           wait.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
    }

    public void waitForWebElementToAppear(WebElement webElement){

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void javaScriptExecutorClick(WebElement element){

        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
        js.executeScript("arguments[0].click();", element);
    }

    public LoginPage logOutBtnClick() throws InterruptedException {
        javaScriptExecutorClick(this.logOutBtn);
        hardWait(3000);
        return new LoginPage(driver);
    }


}
