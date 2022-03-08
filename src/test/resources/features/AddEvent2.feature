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
  Scenario Outline: Repeat Menu
    Given User clicks on any vehicle
    When User clicks on Add Event button
    Then Repeat down menu options include "<options>"

    Examples:
      |options|
    | Daily      |
    |Weekly      |
    |Monthly|
    |Yearly|