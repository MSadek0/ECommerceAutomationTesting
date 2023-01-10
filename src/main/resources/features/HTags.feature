@Regression
  Feature: Logged user could select different tags

    Scenario: Logged user could select different tags

      Given user login to the app5
      When  user click on a category and select a tag of tags list
      And   user click on another tag
      Then  user can select different tags