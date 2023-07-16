package com.stepDefinition;

import com.TestComponents.BaseTest;
import io.cucumber.java.en.Then;

public class HomePageStepDefinition extends BaseTest{
	
	
	
	@Then("I am able to select item {string} from cart")
	public void i_am_able_to_select_item_from_cart(String item) {
		homePage.selectItemfromCart(item);
	}
}
