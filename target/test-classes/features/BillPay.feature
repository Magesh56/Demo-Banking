Feature: Bill Pay Functionality

  Scenario: User pays bill with valid details
    Given user is logged in
    When user navigates to Bill Pay
    And enters valid payee and account information
    Then bill payment should complete

  Scenario: Bill Payment error with missing mandatory fields
    Given user is logged in
    When user leaves required fields blank on Bill Pay page
    Then application should show field validation messages

  Scenario: Bill Payment error with invalid payment amount
    Given user is logged in
    When user enters invalid amount 
    Then appropriate error message displayed
