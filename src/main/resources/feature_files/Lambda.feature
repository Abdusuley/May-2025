Feature: Register an account
  As a User
  I want to be able to create an account
  So that I can purchase items on the lambdatest website

  Background:
    Given I am on the Lambdatest home page "https://ecommerce-playground.lambdatest.io/"

  @smokeTest1
  Scenario: Register Page is displayed when Register link is clicked on
    When I click on MyAccount Menu
    And I click on Continue under the New Customer
    Then the Register Account page should be displayed

  @smokeTest
  Scenario: Register an account
    When I click on Register link from the MyAccount Menu
    And I click on Continue under the New Customer
    When I enter First Name as "Lateef", Last Name as "Abdul", email as "abdul.salih@outlook.com", telephone as "07484848585" and password as "123456"
    And I click on the privacy policy
    And I click on Continue button on the register account page
    Then "Your Account Has Been Created!" is displayed


  @smokeTest12
  Scenario Outline: Register an account
    When I click on Register link from the MyAccount Menu
    And I click on Continue under the New Customer
    When I enter  "<firstName>",  "<lastName>", "<email>", "<telephone>" and  "<password>"
    And I click on the privacy policy
    And I click on Continue button on the register account page
    Then "Your Account Has Been Created!" is displayed
    Examples:
      | firstName | lastName | email              | telephone   | password   |
      | Joseph    | Abdul    | abdul@gmail.com    | 078956346   | 109987456  |
      | Winner    | Bender   | bender@gmail.com   | 09874563    | 398765409  |
      | Don       | Bradley  | bradleyl@gmail.com | 062367845   | 2902824764 |
      | Stella    | Brown    | brown@gmail.com    | 04023459876 | 2038564635 |

  @smokeTest123
      Scenario: Register an account using data table
        When I click on Register link from the MyAccount Menu
        And I click on Continue under the New Customer
        And I enter details as follows
          | firstName | Abdul          |
          | lastName  | Ade            |
          | email     | remi@yahoo.com |
          | telephone | 32450989876    |
          | password  | Peter123409    |

  @TesttorunNext233
  Scenario: Register page is displayed when you click on Register link via hovering on My Account menu
    When I hover on My account menu
    Then  I click on Register

  @TesttorunNext5567
  Scenario Outline: Register accounts using scenario outline and examples - using PageObject model
    When I click on my account link
    And I click on Continue on the login page
    And enter "<firstName>", "<lastName>", "<email>", "<telephone>" and "<password>" using page object
    And I click on the privacy policy using page object
    And I click on Continue button on the register account page using page object
    Then "Your Account Has Been Created!" is displayed
    Examples:
      | firstName | lastName | email        | telephone | password |
      | Cole      | Abdul    | abdul@tt.com | 078484848 | 123456   |




