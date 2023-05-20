package com.Test;

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

public class StandAloneTests {

    WebDriver driver;

    @Test
    public void fromLogintoCart() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client");

        LoginPage loginPage= new LoginPage(driver);
        loginPage.userName.sendKeys("testingsubhajit220@gmail.com");
        loginPage.password.sendKeys("Aug@1234");

          // Move to Home Page from Login Page

        loginPage.loginBtn.click();

        String itemname = "zara coat 3";

        List<String> itemnames = new ArrayList<>();
        itemnames.add("adidas original");
        itemnames.add("zara coat 3");
        itemnames.add("iphone 13 pro");


        for (int i = 0; i < itemnames.size(); i++) {

            WebElement itemForCart = driver.findElement(By.xpath("(//b[contains(text(),'"
                    + itemnames.get(i) + "')]//parent::h5//following-sibling::button)[2]"));

            itemForCart.click();
            WebDriverWait wait = new WebDriverWait(driver, 5);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));

            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));

            //Thread.sleep(5000);


        }
        HomePage homePage = new HomePage(driver);
      // Move to Cart Page from Home Page
        homePage.cartBtn.click();



        Thread.sleep(5000);

        for (int j = 0; j < itemnames.size(); j++) {
            if (!driver.findElement(By.xpath("//*[text()='" +
                    itemnames.get(j) +
                    "']")).isDisplayed() == true)
                throw new RuntimeException("item Not visible in the cart");


        }

        // Move to Checkout Page from Cart Page

        CartPage cartPage = new CartPage(driver);


        WebDriverWait wait = new WebDriverWait(driver,20);



        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",  cartPage.checkoutBtn );
        js.executeScript("arguments[0].click();", cartPage.checkoutBtn);





        Actions actions = new Actions(driver);


        //fill country name

        Thread.sleep(2000);
        actions.sendKeys(driver.findElement(By.xpath("//input[@placeholder]")),
                "india").build().perform();

        Thread.sleep(3000);

        actions.click(driver.findElement(By.xpath("//button//span[(text()=' India')]"))).build().perform();

        // click on Place Order

        CheckOutPage checkOutPage = new CheckOutPage(driver);


        actions.click(
                checkOutPage.orderBtn).build().perform();


        // validate Success Message

        SuccessPage successPage = new SuccessPage(driver);

        String actualMessage= successPage.successMessage.getText();
        String expectedMessage="THANKYOU FOR THE ORDER.";

        Assert.assertTrue(expectedMessage.equalsIgnoreCase(actualMessage),
                "The expected is "+expectedMessage+" whereas the actual message is "+actualMessage );

        driver.quit();

    }
}