package pages;

import support.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CartPage extends CommonUtils {

	WebDriver driver;

	@FindBy(xpath = "//*[text()='Checkout']")
	WebElement checkoutBtn;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	List<WebElement> removeProductIcon;

	@FindBy(xpath = "//div[@class='ng-star-inserted']//h1")
	WebElement noProductMsg;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyItemPresentInCart(List<String> itemnames) {
		for (int j = 0; j < itemnames.size(); j++) {
			if (!driver.findElement(By.xpath("//*[text()='" + itemnames.get(j) + "']")).isDisplayed() == true)
				throw new RuntimeException("item Not visible in the cart");

		}

	}

	public boolean verifyItemPresentInCart(String itemname) {

		if (driver.findElement(By.xpath("//h3[(text()='" + itemname + "')]")).isDisplayed() == true)
			return true;

		else
			return false;

	}

	public CheckOutPage clickCheckoutButton() throws InterruptedException {

		javaScriptExecutorClick(this.checkoutBtn);
		
		CheckOutPage checkOutPage= new CheckOutPage(driver);
		ThreadLocal<CheckOutPage> threadLocalcheckOutPage = new ThreadLocal<>();
		threadLocalcheckOutPage.set(checkOutPage);
		return threadLocalcheckOutPage.get();

	}

	public void removeAllProductsFromCart() throws InterruptedException {

		int j = removeProductIcon.size();
		while (j > 0) {
			hardWait(4000);
			removeProductIcon.get(0).click();
			j--;
		}

	}
	
	 

	public void noProductMsgValidationCorrect() {

		Assert.assertTrue(noProductMsg.getText().equalsIgnoreCase(Constant.CORRECT_NO_PRODUCT_MSG), "No Match");
	}

	public void noProductMsgValidationIncorrect() {
		Assert.assertTrue(noProductMsg.getText().equalsIgnoreCase(Constant.INCORRECT_NO_PRODUCT_MSG), "No Match");
	}
}
