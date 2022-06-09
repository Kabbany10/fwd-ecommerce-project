@smoke
Feature: User should be able to switch currency

  Scenario: user switches currency on the website
    Given user is on website's homepage
    When user changes currency from dollar to euro
    Then currency is changed successfully