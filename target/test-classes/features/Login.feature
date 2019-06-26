#Author:danny.sorto@navyFederal.org
Feature: Login

  Background: 
    Given I see OrangeHrm logo

  @smoke @login @Test
  Scenario: Valid Login
    When I enter valid usernameand password
    And I clicked Login button
    Then I successfully logged in

  @regessison @login
  Scenario: Invalid Login
    When I enter Invalid usernameand password
    And I clicked Login button
    Then I see error messagen is displayed
    
    
  Scenario: Error message Validation
    When I enter invalid username and password I see errorMessage
      | UserName | Password   | ErrorMessage        |
      | Admin    | Admin123   | Invalid Credentials |
      | Admin1   | Syntax123! | Invalid Credentials |
      | Admin2   | Syntax123! | Invalid Credentials |
