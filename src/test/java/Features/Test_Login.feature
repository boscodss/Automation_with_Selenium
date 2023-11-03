Feature: search function

  Background:
    Given Open the Test Login Page


  Scenario Outline: valid username and password
    Given User enters Username as "<username>"
    And User enters Password as "<password>"
    And User clicks on Submit button
    Then message is shown "<message>"


  Scenario Outline : valid username and password
    Given User enters Username as "<username>"
    And User enters Password as "<password>"
    And User clicks on Submit button
    Then message is shown "<message>"

    Examples:

      | username | password    | message                   |
      | student  | Password123 | Logged In Successfully    |
      | student1 | Password123 | Your password is invalid! |