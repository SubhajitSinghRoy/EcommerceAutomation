@tag
Feature: Login Page Validation
  I want to use this feature to validate login functionality using various credentials

 
  @tagl
  Scenario Outline: Successful Order Submission
    Given I navigate to the login page
    When I give correct "<user>" and "<password>"
    And I am able to select item "zara coat 3" from cart
    Then validate the item "zara coat 3" is visible in Cart Page

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
