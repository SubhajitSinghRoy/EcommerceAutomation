package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "(//button[@class='btn btn-custom'])[3]")
    WebElement cartBtn;

    public void selectItemfromCart(List<String> itemnames) {

        for (int i = 0; i < itemnames.size(); i++) {

            WebElement itemForCart = driver.findElement(By.xpath("(//b[contains(text(),'"
                    + itemnames.get(i) + "')]//parent::h5//following-sibling::button)[2]"));

            itemForCart.click();
            WebDriverWait wait = new WebDriverWait(driver, 5);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));

            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));


        }
    }

    public void clickCartButton(){
        this.cartBtn.click();
    }
}