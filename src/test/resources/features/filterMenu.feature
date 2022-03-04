Feature: Filter Menu

  @AC1
  Scenario: "Manage Filter" button should be hidden by default.
    Then verify Manage Filter button is hidden


    @AC2
    Scenario: When a user clicks on the filter icon, the "Manage Filter" button should be visible
      When the user click on the filter button
      Then verify Manage Filter button is displayed

