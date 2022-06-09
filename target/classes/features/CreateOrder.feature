@smoke
Feature: User should be able create an order successfully

  Scenario: user creates an order
    Given any user is logged in on the website
    When user adds a product to cart
    And  user creates an order
    Then order is created successfully