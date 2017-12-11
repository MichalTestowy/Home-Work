Feature: I want to log in to gmail

  Scenario: Log in with correct user name and password
    Given I have opened main page
    When I provide correct user login
    And  correct pasword
    Then I am loged in

  Scenario: Try to log in with inccorect user name
    Given I have opened main page
    When I provide incorrect login
    Then I can see error message


  Scenario: Provided Im loged inn to my inbox I'm sending e-mail

