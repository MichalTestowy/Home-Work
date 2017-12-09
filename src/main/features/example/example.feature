Feature: Wikipedia I want to open main page and search for hello world

  Scenario: Search for hello world
    Given I have opened main page
    When I provide corect user login
    And  correct pasword
    Then I am loged in

