@Regression
  Feature: Logged User could switch between currencies US-Euro

    Scenario: Logged User could switch between currencies US-Euro
      Given user login to the app2
      When  user select currency to euro
      Then  user can change the currency to euro