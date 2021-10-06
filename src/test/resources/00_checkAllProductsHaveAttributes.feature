Feature: Check all products have attributes

  Scenario: Check all products have attributes
    Given User is on Home page
    Then User see 20 products
    Then User see each product have picture, price, availability and Add to basket button
    Then User see each price is higher than 10.00