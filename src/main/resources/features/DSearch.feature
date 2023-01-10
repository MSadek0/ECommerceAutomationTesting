@Regression
  Feature: Logged User could search for any product


    Scenario: Logged User could search for any product
      Given user login to the app1
      When user enter a keyword in the search box
      And  user click on search button
      Then user can find a product after search
