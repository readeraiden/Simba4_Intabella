@INTA-969 @INTA1181
Feature: Location Filter

  @INTA1181   @INTA-1182
  Scenario: User can select "Location" filter under 'Fleet-Vehicles' module
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "Location"
    Then the "Location" filter should be selected

  @INTA1181   @INTA-1183
  Scenario: User should see the methods under the "Location" filter
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "Location"
    Then the "Location" filter should be selected
    And the user click on "contains" button
    Then the user should see the following options
      | Contains         |
      | Does Not Contain |
      | Is Equal To      |
      | Starts With      |
      | Ends With        |
      | Is Any Of        |
      | Is Not Any Of    |
      | Is Empty         |
      | Is Not Empty     |

  @INTA1181   @INTA-1184
  Scenario Outline: User should use the methods under the "Location" filter and get the result in accordance with the method
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "Location"
    Then the "Location" filter should be selected
    And the user click on "contains" button
    When the user select "<methods>"
    And the user enters "<keyword>" into inputBox
    And the user click onto the Update button
    Then the result should be in accordance with the "<methods>" and "<keyword>" result
    Examples:
      | methods          | keyword  |
      | Contains         | EAST     |
      | Does Not Contain | EAST     |
      | Starts With      | EAST     |
      | Ends With        | BURY     |
      | Is Equal To      | Istanbul |
      | Is Equal To      | İstanbul |

  @INTA1181   @INTA-1185
  Scenario Outline: User should NOT use the methods under the "Driver" filter with non-alphabetical characters
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "Driver"
    Then the "Driver" filter should be selected
    And the user click on "contains" button
    When the user select "<methods>"
    And the user enters "<keyword>" into inputBox
    Then the methods should not accept NonAlphabetical keyword
    Examples:
      | methods          | keyword    |
      | Contains         | /987+#5£@% |
      | Does Not Contain | /987+#5£@% |
      | Is Equal To      | >Istanbul^ |
      | Starts With      | Ist*       |
      | Ends With        | @bury      |