package com.CucumberTests.stepDefinition;

import com.TestComponents.BaseTest;
import com.pageObjects.CartPage;
import com.pageObjects.HomePage;
import com.pageObjects.LoginPage;
import com.pageObjects.OrderPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

@RunWith(Cucumber.class)
public class MyStepDefinition extends BaseTest {

    public WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage;

    public CartPage cartPage;

    public OrderPage orderPage;

    @Given("I navigate to the login page")
    public void i_navigate_to_the_login_page() throws IOException {
        driver = initializeDriver();
        loginPage = launchApp(driver);

    }



    @Then("validate the item {string} is visible in Cart Page")
    public void validate_the_item_is_visible_in_cart_page(String string) {

    }

    @When("I give correct {string} and {string}")
    public void i_give_correct_and(String user, String pass) {
        homePage = loginPage.loginToApp(user, pass);
    }


    @Then("I am able to select item {string} from cart")
    public void i_am_able_to_select_item_from_cart(String item) {
        homePage.selectItemfromCart(item);
    }








    @After
    public void cleanup() {
        System.out.println("close the browser now");
        quitApplication();
    }

}
