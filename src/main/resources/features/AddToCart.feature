@smoke
Feature: User should be able to choose a product to add to cart

  Scenario: user adds product to cart
    Given user logins on the website
    When user chooses a product
    And  user adds product to cart
    Then item added to cart successfully