@Regression
  Feature: Logged user could add different products to compare list

    Scenario: Logged user could add different products to compare list

      Given user login to the app8
      When  user add first product to compare list
      And   user add second product to compare list
      Then  user can add products to compare list