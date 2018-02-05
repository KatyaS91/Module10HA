Feature: Mail logoff test
  Scenario: Mail logoff
    Given user navigates to home page
    When user submits login form
    And user singn off
    Then mail start page is displayed