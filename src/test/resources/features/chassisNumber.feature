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
    And the user click on All button
    And the user click on between button
    Then Chassis Number filter should provide the "<methods>"
    Examples:
      | methods                                                                                                                            |
      | Between, Not Between, Equals, Not Equals, More Than, Less Than, Equals Or More Than, Equals Or Less Than, Is Empty, Is Not Empty |

  Scenario Outline:When the user selects the "<method>" with numeric values,the results should be between the specified values
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "ChassisNumber"
    And the user click on All button
    And the user click on between button
    When the user select "<method>"
    And the user enters "<value1>" and "<value2>"
    Then the results should be between the "<value1>" and "<value2>" in "Chassis Number"

    Examples:
      | method | value1 | value2|
      |between|    6000 |180000 |
      |between|    16600 |29000 |

    Scenario Outline: When the user selects the "Equals" method with numeric values, the results should match the specified value exactly
      Given the user click on the filter button
      When the user click on manage filter button
      When the user click on "ChassisNumber"
      And the user click on All button
      And the user click on between button
      When the user select "<method>"
      And the user enters "<value>"
      Then the results should be the specified "<value>" in "Chassis Number"

      Examples:
        | method | value |
        |equals|   64600  |
        |equals|   834414|

  Scenario Outline:When the user selects the "More than" method with numeric values, the results should be more than the specified value
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "ChassisNumber"
    And the user click on All button
    And the user click on between button
    When the user select "<method>"
    And the user enters "<value>"
    Then the results should be more than the specified "<value>" in "Chassis Number"

    Examples:
      | method | value |
      |more than|   999999  |

    Scenario Outline: When the user selects the "Less than" method with numeric values, the results should be less than the specified value
      Given the user click on the filter button
      When the user click on manage filter button
      When the user click on "ChassisNumber"
      And the user click on All button
      And the user click on between button
      When the user select "<method>"
      And the user enters "<value>"
      Then the results should be less than the specified "<value>" in "Chassis Number"

      Examples:
        | method | value    |
        |less than|   13000 |

  Scenario: When the user selects the "Is Empty" method, only empty values should be displayed.
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "ChassisNumber"
    And the user click on All button
    And the user click on between button
    When the user select "is empty"
    And the user updates
    Then the results should be only empty value in "Chassis Number"

