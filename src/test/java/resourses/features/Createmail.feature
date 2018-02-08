Feature: Create mail test
  Background: User is Logged in
    Given user navigates to home page
    When user submits login form

  Scenario: user create mail
    And user fill mail form
    Then created mail is displayed on draft page

  Scenario: user send mail
    And user fill mail form
    And user send draft
    Then mail is disappeared from the mail box