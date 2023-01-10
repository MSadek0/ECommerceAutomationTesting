@Regression
Feature: user should be able to register to the app

  Scenario: User could register with valid data

    Given user navigate to the app and click on register
    When  user fill the form with valid data
    And   user submit the register form
    Then  user can register successfully

