@smoke
Feature: User should be able to reset his password

  Scenario: user resets his password
    Given user navigate to login page
    When user clicks forget password
    And  user enters valid email
    And user clicks recover
    Then user recovers password successfully