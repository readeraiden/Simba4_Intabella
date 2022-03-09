@INTA-972
Feature: Users should be able to logout

  @INTA-1195
  Scenario:User can log out by using log out button and can not go to the homepage button again by clicking step back button
    Given user can log out by using log out button
    When user can not go to home page again by clicking the step back button

  @INTA-1196
  Scenario: The user must be logged out if the user close the tab
    Given user close the tab
     When verify that user is logged out

  @INTA-1197
    Scenario:The user must be logged out if the user is away from keyboard for 3 minutes
      Given user is away the from  keyboard for three minutes
      When  user must be logged out
