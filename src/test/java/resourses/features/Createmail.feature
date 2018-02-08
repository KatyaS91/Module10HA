Feature: Create mail test
  Background: User is Logged in
    Given user navigates to home page
    When user submits login form
    Then mail home page is displayed

  Scenario: user create mail
    When user fill mail form
    Then created mail is displayed on draft page

  Scenario: user send mail
    When user fill mail form
    And user send draft
    Then mail is disappeared from the mail box