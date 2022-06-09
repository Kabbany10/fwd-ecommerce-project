@smoke
Feature: User should be able to search for a product

  Scenario: User searches for a product
    Given user is logged in
    When user search for a product
    Then user is navigated to the product