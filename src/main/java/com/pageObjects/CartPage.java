package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    WebDriver driver;

   @FindBy(xpath="//*[text()='Checkout']")
   WebElement checkoutBtn;

    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyItemPresentInCart(List<String> itemnames){
        for (int j = 0; j < itemnames.size(); j++) {
            if (!driver.findElement(By.xpath("//*[text()='" +
                    itemnames.get(j) +
                    "']")).isDisplayed() == true)
                throw new RuntimeException("item Not visible in the cart");


        }

    }

    public void clickCheckoutButton() throws InterruptedException {

       // Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("arguments[0].scrollIntoView();",  this.checkoutBtn );
           js.executeScript("arguments[0].click();", this.checkoutBtn);

    }
}
