package steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckOutPage;
import pages.SuccessPage;

import java.io.IOException;

import org.testng.Assert;

public class LoginPageSteps extends Base {

	static ExtentReports extentReports;
	static ExtentSparkReporter extentSparkReporter;
	static ExtentTest extentTest;

	@BeforeAll
	public static void before_or_after_all() {
		String path = System.getProperty("user.dir") + "\\target\\extentReports.html";
		extentSparkReporter = new ExtentSparkReporter(path);
		extentSparkReporter.config().setDocumentTitle("Document Name");
		extentSparkReporter.config().setReportName("Report Name");

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);

	}

	@Before
	public void extentReportUse(io.cucumber.java.Scenario scenario) {

		extentTest = extentReports.createTest(scenario.getName());
	}

	@AfterStep
	public void extentReportStep(io.cucumber.java.Scenario scenario) throws NoSuchFieldException, SecurityException {

		if (scenario.isFailed() == false) {

			extentTest.log(Status.PASS, Scenario.getGherkinName());
		}

	}

	@After
	public void cleanup() {
		System.out.println("close the browser now");
		quitApplication();
		extentReports.flush();
	}

	@Given("I navigate to the login page")
	public void i_navigate_to_the_login_page() throws IOException {
		driver = initializeDriver();
		loginPage = launchApp(driver);
		
	}

	@Then("validate the item {string} is visible in Cart Page")
	public void validate_the_item_is_visible_in_cart_page(String itemName) {

		Assert.assertTrue(cartPage.verifyItemPresentInCart(itemName), "Item present in Cart do not match");
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

	@When("user navigates to the checkout page")
	public void user_navigates_to_the_checkout_page() throws InterruptedException {

		checkOutPage = cartPage.clickCheckoutButton();
	}

	@When("user places the order with all the details")
	public void when_user_places_the_order_with_all_the_details() throws InterruptedException {

		checkOutPage.fillCountryName("india");
		successPage = checkOutPage.orderItems();

	}

	@Then("user is able to see his order placed in the order page")
	public void user_is_able_to_see_his_order_placed_in_the_order_page() {

		Assert.assertTrue(successPage.returnSuccessMessage().equals("THANKYOU FOR THE ORDER."),
				"success Message do not match" + "expected is THANKYOU FOR THE ORDER. whereas result is "
						+ successPage.returnSuccessMessage());
	}
}
