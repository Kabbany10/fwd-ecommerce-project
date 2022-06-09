@smoke
Feature: User should be able to choose a product to add to wishlist

  Scenario: user adds product to wishlist
    Given user login on the website
    When user chooses a product to add
    And  user adds product to wishlist
    Then item added to wishlist successfully