#Author:danny.sorto@navyFederal.org
Feature: Add Employee

  Background: 
    Given I logged in into OrangeHrm
    And I click on PIM link
    And I click on  Add Employee link

  @smoke @addEmployee
  Scenario Outline: Add Employee
    When I give details "<firstName>" and "<middleName>" and "<lastName>" and "<location>"
    And I click on save button

    Examples: 
      | firstName | middleName | lastName | location     |
      | John      | Snow       | White    | HQ           |
      | Jane      | Rain       | Yellow   | West Office  |
      | Arya      | Sunny      | Blue     | North Office |

 #Scenario: Add Employee and Create Login Details
    #When I provide firstname,midlename, lastname and location
    #And I click on create login details
    #And I provide all mandatory fields
    #And I click on save button
    #Then I see employee is added successfully
    
    
  
  Scenario: Add Employee Lables Verification
    Then I see the following labels
      | First Name  |
      | Middle Name |
      | Last Name   |
      | Location    |
