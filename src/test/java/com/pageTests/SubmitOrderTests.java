package com.pageTests;

import com.TestComponents.BaseTest;
import com.pageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SubmitOrderTests extends BaseTest {

    //public WebDriver driver;

    public SubmitOrderTests() throws IOException {
    }


    @Test
    public void orderTest() throws InterruptedException, IOException {

        List<String> itemnames = new ArrayList<>();
        itemnames.add("adidas original");
        itemnames.add("zara coat 3");
        itemnames.add("iphone 13 pro");

        HomePage homePage = loginPage.loginToApp("testingsubhajit220@gmail.com", "Aug@1234");
        homePage.selectItemfromCart(itemnames);

        CartPage cartPage = homePage.clickCartButton();
        cartPage.verifyItemPresentInCart(itemnames);

        CheckOutPage checkOutPage = cartPage.clickCheckoutButton();
        checkOutPage.fillCountryName("India");

        SuccessPage successPage = checkOutPage.orderItems();
        Assert.assertTrue(successPage.returnSuccessMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."),
                "The expected and the actual message do not match");


    }
}
