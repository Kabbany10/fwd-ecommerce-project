@smoke
Feature: User should be able to add a product to compare list

  Scenario: user adds product to compare list
    Given user is logged in on the website
    When user chooses a product to add to compare list
    And  user adds product to compare list
    Then item added to compare list successfully