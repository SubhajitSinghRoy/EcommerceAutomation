package com.pageTests;

import com.pageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SubmitOrderTests {


    WebDriver driver;

    @Test
    public void orderTest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        LoginPage loginPage = new LoginPage(driver);

        loginPage.launchApp();
        loginPage.loginToApp("testingsubhajit220@gmail.com", "Aug@1234");


        List<String> itemnames = new ArrayList<>();
        itemnames.add("adidas original");
        itemnames.add("zara coat 3");
        itemnames.add("iphone 13 pro");

        HomePage homePage = new HomePage(driver);
        homePage.selectItemfromCart(itemnames);
        homePage.clickCartButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.verifyItemPresentInCart(itemnames);
        cartPage.clickCheckoutButton();

        CheckOutPage checkOutPage = new CheckOutPage(driver);

        checkOutPage.fillCountryName("India");
        checkOutPage.orderItems();

        SuccessPage successPage = new SuccessPage(driver);
        Assert.assertTrue(successPage.returnSuccessMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."),
                "The expected and the actual message do not match");

        driver.quit();

    }
}
