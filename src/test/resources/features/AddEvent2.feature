Feature: Add Event 2

  Scenario: Color checkboxes
    Given User clicks on any vehicle
    When User clicks on Add Event button
    Then User can mark the event with any color

  Scenario: All-day event
    Given User clicks on any vehicle
    When User clicks on Add Event button
    Then User can mark the event as an all-day event
  @todo
  Scenario: Repeat Menu
    Given User clicks on any vehicle
    When User clicks on Add Event button
    Then Repeat down menu should include below options

      | Daily   |
      | Weekly  |
      | Monthly |
      | Yearly  |

  Scenario: Ends Menu
    Given User clicks on any vehicle
    When User clicks on Add Event button
    Then Ending options should be clickable