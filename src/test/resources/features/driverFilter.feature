@INTA-1160
Feature: Driver Filter
  @INTA-1156 @INTA-1155
  Scenario: User can select "Driver" filter under 'Fleet-Vehicles' module
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "Driver"
    Then the "Driver" filter should be selected

  @INTA-1157 @INTA-1155
    Scenario: User should see the methods under the "Driver" filter
      Given the user click on the filter button
      When the user click on manage filter button
      When the user click on "Driver"
      Then the "Driver" filter should be selected
      And the user click on "contains" button
      Then the user should see the following options
      |Contains           |
      |Does Not Contain   |
      |Is Equal To        |
      |Starts With        |
      |Ends With          |
      |Is Any Of          |
      |Is Not Any Of      |
      |Is Empty           |
      |Is Not Empty       |

  @INTA-1158 @INTA-1155
  Scenario Outline: User should use the methods under the "Driver" filter and get the result in accordance with the method
    Given the user click on the filter button
    When the user click on manage filter button
    When the user click on "Driver"
    Then the "Driver" filter should be selected
    And the user click on "contains" button
    When the user select "<methods>"
    And the user enters "<keyword>" into inputBox
    And the user click onto the Update button
    Then the result should be in accordance with the "<methods>" and "<keyword>"
    Examples:
      | methods          | keyword              |
      | Contains         | Mrs.                 |
      | Does Not Contain | Mrs.                 |
      | Starts With      | Mrs.                 |
      | Ends With        | PhD                  |
      | Is Equal To      | Mrs. Donovan Schulist|
      | Is Equal To      | Mrş. Donövan Sçhülist|

  @INTA-1159 @INTA-1155
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
      | methods          | keyword              |
      | Contains         | /987+#5£@%           |
      | Does Not Contain | /987+#5£@%           |
      | Is Equal To      | Mrs& Donovan_Schulist|
      | Starts With      | Mrs*                 |
      | Ends With        | @PhD                 |

