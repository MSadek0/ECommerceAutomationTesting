@Regression
Feature: User could reset his/her password successfully

  Scenario: User could reset password successfully

    Given user Navigate to the app and click login to reset password
    When  user click on forgot password
    And   user enter email
    And   user click recover
    Then  user recover successfully
