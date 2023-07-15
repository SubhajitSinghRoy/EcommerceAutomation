@tag
Feature: Submit Order Validation
  I want to use this feature to submit order and validate

  # Background: I launch the browser
  @tagl
  Scenario Outline: Successful Order Submission
    Given I navigate to the login page
    When I give correct "<user>" and "<password>"
    And I am able to select item "zara coat 3" from cart
    Then validate the item "" is visible in Cart Page

    Examples: 
      | user                         | password |
      | testingsubhajit220@gmail.com | Aug@1234 |
      
   @tag2
  Scenario Outline: UnSuccessful Order Submission
    Given I navigate to the login page
    When I give incorrect "<user>" and "<password>"
    Then validate that the error message displayed

    Examples: 
      | user                         | password |
      | testing1subhajit220@gmail.com | Aug@1234 |
