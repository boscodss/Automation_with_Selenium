Feature: search function

  Background:
    Given Open site
    And Do login

  Scenario Outline: direct search article
    Given Enter search term "<searchterm>"
    When Do search
    Then Single result is shown for "<searchterm>"



    Examples:

      | searchterm |
      | microsoft  |
      | visa       |
      | FIS        |
      | mastercard |