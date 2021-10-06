Feature: Check categories

  Scenario: Check categories
    Given User is on Home page
    Then User sees 'Books' contains subcategories
    |Fiction|Non-Fiction|
    Then User sees 'Fiction' contains subcategories
    |Computers in Literature|
    Then User sees 'Non-Fiction' contains subcategories
    |Essential programming|Hacking|