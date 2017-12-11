Feature:I want to check if I'm able to send E-mails form gmail
  Background: Provided that the user is logged in
    Scenario: I want to go to the compose view and send an email message to myself to check if I will receive it
      Given I create a new e-mail message
      When I cleck send
      Then The message is visible in sent forlder