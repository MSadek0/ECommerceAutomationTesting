@Regression
Feature: user should be able to Login to the app


  Scenario: User could login with valid email and password
    Given user Navigate to the app and click login
    When  user enter email and password
    And   user click login button
    Then  user login successfully
    And   user logout and close browser




