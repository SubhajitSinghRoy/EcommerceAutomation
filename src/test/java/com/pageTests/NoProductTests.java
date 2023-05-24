package com.pageTests;

import com.TestComponents.BaseTest;
import com.pageObjects.CartPage;
import com.pageObjects.CheckOutPage;
import com.pageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class NoProductTests extends BaseTest {

    @Test
    public void validateNoProductMessage() throws InterruptedException {
        List<String> itemnames = new ArrayList<>();
        itemnames.add("adidas original");
        itemnames.add("zara coat 3");
        itemnames.add("iphone 13 pro");

        HomePage homePage = loginPage.loginToApp("testingsubhajit220@gmail.com", "Aug@1234");
        homePage.selectItemfromCart(itemnames);

        CartPage cartPage = homePage.clickCartButton();
        cartPage.verifyItemPresentInCart(itemnames);


       cartPage.removeAllProductsFromCart();
        cartPage.noProductMsgValidationCorrect();

    }

    @Test(groups = {"SmokeTest"})
    public void failTovalidateNoProductMessage() throws InterruptedException {
        List<String> itemnames = new ArrayList<>();
        itemnames.add("adidas original");
        itemnames.add("zara coat 3");
        itemnames.add("iphone 13 pro");

        HomePage homePage = loginPage.loginToApp("testingsubhajit220@gmail.com", "Aug@1234");
        homePage.selectItemfromCart(itemnames);

        CartPage cartPage = homePage.clickCartButton();
        cartPage.verifyItemPresentInCart(itemnames);


        cartPage.removeAllProductsFromCart();
        cartPage.noProductMsgValidationIncorrect();

    }
}
