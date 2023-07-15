package com.CucumberTests.stepDefinition;

import com.TestComponents.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import java.io.IOException;

@RunWith(Cucumber.class)
public class LoginStepDefinition extends BaseTest {



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

	@When("I give incorrect {string} and {string}")
	public void i_give_incorrect_and(String user, String pass) {
		loginPage.loginError(user, pass);

	}

	@Then("validate that the error message displayed")
	public void validate_that_the_error_message_displayed() {

	}

	@After
	public void cleanup() {
		System.out.println("close the browser now");
		quitApplication();
	}

}
