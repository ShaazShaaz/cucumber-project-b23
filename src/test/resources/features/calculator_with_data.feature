@calculator @non_ui
Feature: Calculator feature
  As a user I should be able
  to use the calculator,
  de that I can do
  arithmetic operations.

#  Scenario: Add two numbers example 1
#    Given calculator app is open
#    When I add 2 with 2
#    Then I should get result 4 displayed
#
#  Scenario: Add two numbers example 2
#    Given calculator app is open
#    When I add 3 with 2
#    Then I should get result 5 displayed
#
#  Scenario: Add two numbers example 3
#    Given calculator app is open
#    When I add 21 with 20
#    Then I should get result 41 displayed

  # in order to execute same implementations but with different data, use DDT/ Data Driven Testing
  @wip2
  Scenario Outline: Add 2 numbers multiple example
    Given calculator app is open
    When I add <num1> with <num2>
    Then I should get result <expectedResult> displayed
    Examples:
      | num1 | num2 | expectedResult |
      | 3    | 4    | 7              |
      | 4    | 7    | 11             |
      | 6    | 11   | 17             |
      | 3    | 5    | 8              |
      | 4    | 71   | 75             |
      | 60   | 11   | 77             |