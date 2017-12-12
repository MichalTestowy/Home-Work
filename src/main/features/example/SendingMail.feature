Feature: I want to check if I'm able to send E-mails form gmail

  Background: Provided that the user is logged in
    Given Im loggded in

  Scenario: User should be able to send
    Given I create a new e-mail message
    When I click send
    Then The message is visible in sent folder


  Scenario: User should be able to send attachments
    Given I create a new e-mail message
    When I choose a file to be attached
    Then The File attached is visible in message

  Scenario: User should be able to send empty messages
    Given I create a new e-mail message without any text
    When I accept the alert
    Then The message is visible in sent folder


    #Responses to Write ​​additional ​​test​​ scenarios ​​for ​​features ​​described​​ in ​​point​​ 1.
  Scenario: User should be able to differentiate between read and unread message
    Given I have an unread message in the inbox
    When I open the message
    And I open the inbox again
    Then the message is marked as read

  Scenario: User should be able save the message in drafts
      Given I create new mesage
      When I close the Compose window before sending it
      Then The messeage should be saved in drafts