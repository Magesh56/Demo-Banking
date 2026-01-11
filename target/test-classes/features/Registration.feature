Feature: User Registration on ParaBank

  Scenario: Successful new user registration
    Given user is on Parabank Registration page
    When user enters valid details
    And clicks on Register button
    Then user account should be created successfully

  Scenario: Registration fails with missing mandatory fields
    Given user is on Parabank Registration page
    When user leaves mandatory fields blank
    And clicks on Register button
    Then error message should be displayed

  Scenario: Registration with mismatching passwords
    Given user is on Parabank Registration page
    When user enters mismatching password and confirm password
    And clicks on Register button
    Then a password mismatch error should display
