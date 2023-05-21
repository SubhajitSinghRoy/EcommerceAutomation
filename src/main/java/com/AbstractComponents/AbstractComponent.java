package com.AbstractComponents;

import com.pageObjects.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AbstractComponent {

    WebDriver webDriverReference;

    @FindBy(xpath = "(//button[@class='btn btn-custom'])[3]")
    WebElement cartBtn;

    public AbstractComponent(WebDriver driver) {
        this.webDriverReference=driver;
        PageFactory.initElements(webDriverReference,this);

    }


    // this method is kept in AbstractComponent as it is common for many pages

    public CartPage clickCartButton() {
        this.cartBtn.click();
        return new CartPage(webDriverReference);
    }

    public void hardWait(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void waitForElementToAppear(By byLocator){
        WebDriverWait wait=  new WebDriverWait(webDriverReference,5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));

    }

    public void waitForElementToDisappear(By byLocator){

        WebDriverWait wait = new WebDriverWait(webDriverReference,5000);
           wait.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
    }

    public void javaScriptExecutorClick(WebElement element){

        JavascriptExecutor js =(JavascriptExecutor) webDriverReference;
        js.executeScript("arguments[0].scrollIntoView();",element);
        js.executeScript("arguments[0].click();", element);
    }
}
