Feature: Last Odometer Filter


  Scenario: User can select "Last Odometer" filter under 'Fleet-Vehicles' module
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "LastOdometer"
    Then the "LastOdometer" should be selected

  @wip
  Scenario Outline:Last Odometer filter should provide the "<methods>"
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "LastOdometer"
    And the user click on Last Odometer All button
    And the user click on between button
    Then Last Odometer filter should provide the "<methods>"
    Examples:
      | methods                                                                                                                            |
      | Between, Not Between, Equals, Not Equals, More Than, Less Than, Equals Or More Than, Equals Or Less Than, Is Empty, Is Not Empty |