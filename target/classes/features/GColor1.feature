@Regression
Feature: Logged user could filter with color

  Scenario: Logged user could filter product search with color
    Given user login to the app4
    When  user select a category with multiple colors
    And   user select filter with color
    Then  user can filter products with color