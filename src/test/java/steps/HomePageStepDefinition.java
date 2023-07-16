package steps;

import io.cucumber.java.en.Then;
import support.Base;

public class HomePageStepDefinition extends Base{
	
	
	
	@Then("I am able to select item {string} from cart")
	public void i_am_able_to_select_item_from_cart(String item) {
		homePage.selectItemfromCart(item);
		cartPage=homePage.clickCartButton();
	}
}
