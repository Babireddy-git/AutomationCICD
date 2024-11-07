
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

Background: 
Given I landed on Ecommerce Page 

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> from the cart
    And Checkout <productName> and submit the order
    Then "THANK YOU FOR THE ORDER." message is displayed on the ConfirmationPage

    Examples: 
      | name  				 | password | productName |
      |Reddy3@gmail.com| Sai@1234 | ZARA COAT 3 |
    
      
 
