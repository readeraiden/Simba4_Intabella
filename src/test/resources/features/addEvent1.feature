Feature: Add Event Function 1
  @wip
  Scenario: Add Event Functionality for Store Manager
    Given User clicks on any vehicle
    When User clicks on "Add Event" button
    Then the "Add Event" page should pop up
    And Compulsory fields should be seen as below
      | Title                  |
      | Owner                  |
      | Organizer display name |
      | Organizer email        |
      | Start Date             |
      | End Date               |
    When User clicks on the save button
    And If any compulsory field is not filled
    Then "This value should not be blank." message should be displayed