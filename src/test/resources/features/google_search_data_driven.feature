@ui @go_home
Feature: Google Search Data Driven
  As a user, I should be able to search by keyboard
  and get my result

  # modify this to make it data driven scenario that searches for multiple keywords
  Scenario Outline: User search by keyboard "<keyword>"
    Given user is at home page
    When user search for "<keyword>"
    Then the title should start with "<keyword>"
    Examples:
      | keyword                         |
      | cybertruck                      |
      | selenium                        |
      | steve jobs                      |
      | sdet jobs                       |
      | how to make 100k by being SDET |
