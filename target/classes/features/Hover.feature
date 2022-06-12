@smoke
Feature: User should be able to hover on categories

  Background: user go to homepage
    Then user go to homepage

  Scenario: user hovers on categories
    When user hovers on computers
    And user clicks on desktop
    Then user is directed desktops page