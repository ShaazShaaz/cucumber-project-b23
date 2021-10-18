Feature: Side bar tabs should be visible
  @go_home
  Scenario: User should see side bar tabs as expected
    Given we are at web order login page
    When we provide valid credentials
    Then we should see all order page
    Then side bar tabs should be as below

      | View all orders   |
      | View all products |
      | Order             |