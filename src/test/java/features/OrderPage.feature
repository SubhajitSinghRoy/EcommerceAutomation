
@tag
Feature: Order Page Validation
	Validate whether user is able to successfully place an order
	
	Scenario: Validate user is able to successfully place an order
	
	Given I navigate to the login page
	And I give correct "testingsubhajit220@gmail.com" and "Aug@1234"
	 And I am able to select item "zara coat 3" from cart
	 And validate the item "zara coat 3" is visible in Cart Page
	 And user navigates to the checkout page
	 When user places the order with all the details
	 Then user is able to see his order placed in the order page
	 