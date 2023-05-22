package com.pageTests;

import com.TestComponents.BaseTest;
import com.pageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SubmitOrderTests extends BaseTest {

    public List<String> itemnames=null;
    //public WebDriver driver;

    public SubmitOrderTests() throws IOException {
    }

    @DataProvider
    public Object[][] getData(){

        return new Object[][]
            {       {"testingsubhajit220@gmail.com","Aug@1234"},
                    {"sagasow460@favilu.com","Aug@4312"}
            };

        };


    @Test(groups = {"SmokeTest"}, dataProvider = "getData" )
    public void orderTest(String user, String pass) throws InterruptedException, IOException {

        itemnames= new ArrayList<>();
        itemnames.add("adidas original");
        itemnames.add("zara coat 3");
        itemnames.add("iphone 13 pro");


        HomePage homePage = loginPage.loginToApp(user, pass);
        homePage.selectItemfromCart(itemnames);

        CartPage cartPage = homePage.clickCartButton();
        cartPage.verifyItemPresentInCart(itemnames);

        CheckOutPage checkOutPage = cartPage.clickCheckoutButton();
        checkOutPage.fillCountryName("India");

        Collections.sort(itemnames);


        SuccessPage successPage = checkOutPage.orderItems();
        Assert.assertTrue(successPage.returnSuccessMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."),
                "The expected and the actual message do not match");


        Assert.assertTrue(successPage.itemListSuccessPage().equals(itemnames),"ItemList do not match " +
                "expected was \n" +itemnames+ " whereas actual is \n"+successPage.itemListSuccessPage());

        successPage.logOutBtnClick();
    }

    @Test(dependsOnMethods = {"orderTest"})
    public void itemsPresentOnSuccessPage() throws InterruptedException {

       // HomePage homePage = loginPage.loginToApp("testingsubhajit220@gmail.com", "Aug@1234");
      //  OrderPage orderPage = homePage.clickOrderBtn();
        //Assert.assertTrue(orderPage.validateOrders( itemnames),"the items ordered are not correctly reflected");

    }
}
