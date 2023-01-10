@Regression
  Feature: Logged user could add different products to Wishlist

    Scenario: Logged user could add different products to Wishlist

      Given user login to the app7
      When  user add first product to wishlist
      And   user add second product to wishlist
      Then  user can add products to wishlist