Feature: Fund Transfer Between Accounts

  Scenario: Transfer funds successfully between two valid accounts
    Given user is logged in
    When user goes to Transfer Funds
      And enters valid From Account, To Account and Amount
    Then transfer should be successful

  Scenario: Transfer fails when insufficient balance
    Given user is logged in
    When user enters amount greater than account balance
    Then error “Insufficient funds” should appear

  Scenario: Transfer fails with invalid account data
    Given user is logged in
    When user enters invalid account numbers
    Then proper invalid account error message should show
