Feature: Account Service Functions

  Scenario: User should open a new account successfully
    Given user is logged in
    When user navigates to Open New Account
    And selects account type and submits
    Then new account is created and shown to user

  Scenario: Accounts Overview displays correct information
    Given user is logged in
    When user goes to Accounts Overview
    Then the list of user accounts should be displayed

  Scenario: User should logout successfully
    Given user is logged in
    When user clicks logout
    Then user should be redirected to login page
