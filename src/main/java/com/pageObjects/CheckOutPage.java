package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    WebDriver driver;

    @FindBy(xpath = "//a[text()='Place Order ']")
    WebElement orderBtn;

    @FindBy(xpath = "//input[@placeholder]")
    WebElement selectCountryTxtBox;


    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillCountryName(String name) throws InterruptedException {

        Actions actions = new Actions(this.driver);

        Thread.sleep(5000);
        actions.click(this.selectCountryTxtBox);
        actions.sendKeys(this.selectCountryTxtBox, "india").build().perform();
        actions.click(driver.findElement(By.xpath("//button//span[(text()=' " +
                name +
                "')]"))).build().perform();
    }

    public void orderItems(){

        this.orderBtn.click();
    }
}
