@INTA-967 @last_odometer
Feature: Last Odometer Filter

  @INTA-1172
  Scenario: User can select "Last Odometer" filter under 'Fleet-Vehicles' module
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "LastOdometer"
    Then the "LastOdometer" should be selected

  @INTA-1173
  Scenario Outline:Last Odometer filter should provide the "<methods>"
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "LastOdometer"
    And the user click on Last Odometer All button
    And the user click on between button
    Then Last Odometer filter should provide the "<methods>"
    Examples:
      | methods                                                                                                                          |
      | Between, Not Between, Equals, Not Equals, More Than, Less Than, Equals Or More Than, Equals Or Less Than, Is Empty, Is Not Empty |

  @INTA-1174
  Scenario Outline: the user selects the "Between" method with numeric values, the results should be between the specified values
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "LastOdometer"
    And the user click on Last Odometer All button
    And the user click on between button
    And the user click on "between" method
    And the user submit "<start>" and "<end>" values
    Then  the results should be between the specified "<start>" and "<end>" values

    Examples:
      | start | end    |
      | 1000  | 200000 |

  @INTA-1175
  Scenario Outline:  methods shouldn't accept non-numeric "<start>" and "<end>" values
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "LastOdometer"
    And the user click on Last Odometer All button
    And the user click on between button
    And the user click on "between" method
    And the user submit "<start>" and "<end>" values
    Then the methods shouldn't accept non-numeric values

    Examples:
      | start | end   |
      | 1000  | 5000* |
      | 1000@ | 5000* |
      | 1000@ | 5000  |

  @INTA-1176
  Scenario Outline: the user selects the "Equals" method with numeric values, the results should match the specified value
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "LastOdometer"
    And the user click on Last Odometer All button
    And the user click on between button
    And the user click on "equals" method
    And the user submit "<value>" values
    Then  the results should be the specified "<value>" exactly

    Examples:
      | value |
      | 1000  |

  @INTA-1177
  Scenario Outline: the user selects the "More than" method with numeric values, the results should be more than the specified value
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "LastOdometer"
    And the user click on Last Odometer All button
    And the user click on between button
    And the user click on "more than" method
    And the user submit "<value>" values
    Then  the results should be more than the specified "<value>"

    Examples:
      | value |
      | 58000 |

  @INTA-1178
  Scenario Outline: the user selects the "Less than" method with numeric values, the results should be more than the specified value
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "LastOdometer"
    And the user click on Last Odometer All button
    And the user click on between button
    And the user click on "less than" method
    And the user submit "<value>" values
    Then  the results should be less than the specified "<value>"

    Examples:
      | value |
      | 5000  |