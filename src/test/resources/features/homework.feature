@ui
Feature: Doing homework
  As a student
  I want to be able to finish my homework
  So that I can learn some stuff

  Scenario: User should see product table as expected
    Given we are at web order login page
    And we provide valid credentials
    When we select "View all products" tab from sidebar
    Then we should see table with below content
    # for the sake of simplicity below table is modified to match exactly to actual table
      | Product name    | Price | Discount |
      | MyMoney     | $100  | 8%       |
      | FamilyAlbum | $80   | 15%      |
      | ScreenSaver | $20   | 10%      |