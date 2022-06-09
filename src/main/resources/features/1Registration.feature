@smoke
Feature: User should be able to register on the website

  Scenario: User register with valid data
    Given user navigates to registration page
    When user enters valid registration data
    And user clicks register button
    Then user is registered successfully