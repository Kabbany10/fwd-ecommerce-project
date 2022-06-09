@smoke
Feature: User should be able to filter with color

  Scenario: user filter products with color
    Given user navigates to account homepage
    When user selects shoes in apparel
    And  user clicks red color
    Then items with red color appears