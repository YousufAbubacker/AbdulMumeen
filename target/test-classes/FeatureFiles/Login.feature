Feature: To validate Login Functionality in Hazeltons Application

  Scenario: To validate login using valid username and password
    Given User is in Hazelton login page
    When User enter valid username and valid password
    And User click Login Button
    Then User should be in valid credentials page
Scenario: To close the browser
When close the Hazelton Application browser