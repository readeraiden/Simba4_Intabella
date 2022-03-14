Feature: Add Event 2
  @INTA-1213 @INTA-1212
  Scenario: Color checkboxes
    Given User clicks on any vehicle
    When User clicks on Add Event button
    Then User can mark the event with any color
  @INTA-1214 @INTA-1212
  Scenario: All-day event
    Given User clicks on any vehicle
    When User clicks on Add Event button
    Then User can mark the event as an all-day event
  @INTA-1215 @INTA-1212
  Scenario: Repeat Menu
    Given User clicks on any vehicle
    When User clicks on Add Event button
    Then Repeat down menu should include below options

      | Daily   |
      | Weekly  |
      | Monthly |
      | Yearly  |
  @INTA-1216 @INTA-1212
  Scenario: Ends Menu
    Given User clicks on any vehicle
    When User clicks on Add Event button
    Then Ending options should be clickable
  @INTA-1217 @INTA-1212
  Scenario: Event visibility on the general information page
    Given User clicks on any vehicle
    When User clicks on Add Event button
    And User add an event
    Then User should see the event on general information page