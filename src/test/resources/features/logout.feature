Feature: Users should be able to logout
  @AC1-2
  Scenario:User can log out by using log out button
    Given user can log out by using log out button
    When user can not go to home page again by clicking the step back button
  @AC3
  Scenario: The user must be logged out if the user close the tab
    Given user close the tab
     When verify that user is logged out
  @AC4
    Scenario:The user must be logged out if the user is away from keyboard for 3 minutes
      Given user is away the from  keyboard for three minutes
#      When verify that user is logged out
