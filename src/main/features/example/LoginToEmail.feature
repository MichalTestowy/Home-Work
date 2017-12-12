Feature: I want to log in to gmail

  Background:
    Given I have opened main page

  Scenario: User after successful login is redirected to gmail homepage
    When I provide correct user login
    And  correct password
    Then I am logged in

  Scenario:  User is informed about wrong credentials
    When I provide incorrect login
    Then I can see error message


