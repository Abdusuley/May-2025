Feature: Register an account for me
  As a User
  I want to be able to create my account
  So that I can purchase items on the lambdatest website

  Background:
    Given I am on the Lambdatest home page "https://ecommerce-playground.lambdatest.io/"

  @smokeTest1
  Scenario: Register Page is displayed when Register link is clicked on
    When I click on MyAccount Menu
    And I click on Continue under the New Customer
    Then the Register Account page should be displayed