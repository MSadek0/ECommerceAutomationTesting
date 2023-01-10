@Regression
  Feature: Logged user could add different products to Shopping cart

    Scenario: Logged user could add different products to Shopping cart

      Given  user login to the app6
      When  user add first product to shopping cart
      And   user add second product to shopping cart
      Then  user can add products to shopping cart