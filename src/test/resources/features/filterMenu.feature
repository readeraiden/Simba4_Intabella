Feature: Filter Menu

  @AC1
  Scenario: "Manage Filter" button should be hidden by default.
    Then verify Manage Filter button is hidden

    @AC1(-)
      Scenario: "Manage Filter" button should be hidden by default(negative).
      Given the user click on the filter button
      When the user log out and log in again
      Then verify Manage Filter button is hidden


    @AC2
    Scenario: When a user clicks on the filter icon, the "Manage Filter" button should be visible
      When the user click on the filter button
      Then verify Manage Filter button is displayed



