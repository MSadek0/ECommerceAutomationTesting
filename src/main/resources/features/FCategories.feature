@Regression
  Feature: Logged user could select different Categories

    Scenario: user can select category page then select sub-category page
      Given user login to the app3
      When user click on a category
      And  user click on subcategory
      Then user can navigates categories on app

