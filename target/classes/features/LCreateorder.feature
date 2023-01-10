@Regression
  Feature: Create successful Order

    Scenario: user can Create successful Order
      Given user login to the app9
      When  user add product to purchase
      And   navigate to shopping cart
      And   user checkout and place the order
      Then  user can Create successful Order