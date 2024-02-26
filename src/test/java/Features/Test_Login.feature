Feature: Login page

  Scenario Outline: Registered user is able to login with valid credentials
    Given User is on the login page
    And User inserts valid username "<username>"
    And User inserts valid password "<password>"
    When User clicks on submit button
    Then User is logged in



    Examples:
      |   username    | password    |
      |   student     | Password123 |