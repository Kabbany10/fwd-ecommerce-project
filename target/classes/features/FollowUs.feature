@smoke
Feature: User should use follow us on different links

  Scenario: user clicks facebook
    When user clicks facebook
    Then user is directed to a new tab with facebook website

  Scenario: user clicks on twitter
    When user clicks twitter
    Then user is directed to a new tab with twitter website

  Scenario: user clicks on rss
    When user clicks on rss
    Then user is directed to a new tab with rss website

  Scenario: user clicks on youtube
    When user clicks on youtube
    Then user is directed to a new tab with youtube website