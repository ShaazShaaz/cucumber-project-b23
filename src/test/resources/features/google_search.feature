@ui
Feature: Google Search
  As a user, I should be able to search by keyboard
  and get my result

  Background:
    Given user is at home page

 @wip
  Scenario: User search by keyboard
    When user search for "selenium"
    Then we should see result page
    And the title should start with "selenium"

  @wip
  Scenario: User search by keyboard
    When user search for "java"
    And the title should start with "java"