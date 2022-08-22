Feature: To validate forgot password feature

  Background: 
    Given User is in facebook login page

  Scenario Outline: To validate searching the account using mobile number when user forgots password
    When User click forgot password link
    And User searches the account using invalid mobile number "<mobilenumber>"
    Then user is displayed with error message

    Examples: 
      | mobilenumber |
      |    978630986 |
