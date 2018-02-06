Feature: Mail basic test
Scenario Outline: Mail login
  Given user navigates to home page
  When enters login "<login>" and password "<password>" submits login form
  Then mail home page is displayed
  Examples:
  |login| password|
  |berezhkov.agm@gmail.com| berezhkovMm8|