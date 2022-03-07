Feature: Chassis Number Filter


  Scenario: User can select "Chassis Number" filter under 'Fleet-Vehicles' module
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "ChassisNumber"
    Then the "ChassisNumber" should be selected

  @wip
  Scenario Outline:Chassis number filter should provide the "<methods>"
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "ChassisNumber"
    And the user click on Chassis Number All button
    And the user click on between button
    Then Chassis Number filter should provide the "<methods>"
    Examples:
      | methods                                                                                                                            |
      | Between, Not Between, Equals, Not Equals, More Than, Less Than, Equals Or More Than, Equals Or Less Than, Is Empty, Is Not Empty |


