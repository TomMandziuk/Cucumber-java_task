Feature: Another feature

  Scenario: Another feature
    Given User is on Home page
    When User click on Login button
    When User login with "cucumberfortestemail@mailinator.com" and "q1w2e3r4t"
    Then User can see Login message