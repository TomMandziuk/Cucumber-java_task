Feature: Check categories

  Scenario: Check categories
    Given User is on Home page
    Then User sees 'Books' contains categories
    |Fiction|Non-Fiction|
