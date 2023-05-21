package com.pageTests;

import com.TestComponents.BaseTest;
import com.pageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorValidationTests extends BaseTest {

    @Test
    public void loginError(){
    HomePage homePage = loginPage.loginToApp("testingsubhajit220@gmail.com", "Aug@12345");
        Assert.assertTrue(loginPage.errorMessage().equalsIgnoreCase("Incorrect email or password."),
                "Error Message do not match" );

}}
