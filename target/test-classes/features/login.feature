Feature: Login Functionality

  Scenario: Valid user should login successfully
    Given user is on Parabank Login page
    When user enters correct username and password
    And clicks Login
    Then user should land on Account Overview page

  Scenario: Invalid username/password should display error
    Given user is on Parabank Login page
    When user enters invalid credentials
    Then appropriate error message should show

  Scenario: Login without entering credentials
    Given user is on Parabank Login page
    When user clicks Login without entering credentials
    Then proper validation error should appear
