@smoke
Feature: User should be able to login on the website

  Scenario: user logins on the website
    Given user navigates to login page
    When user enters valid username and password
    And  user clicks login button
    Then user logins successfully