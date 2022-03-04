Feature: Filter Menu

  @AC1
  Scenario: "Manage Filter" button should be hidden by default.
    Then verify Manage Filter button is hidden

  @AC1(-)
  Scenario: "Manage Filter" button should be hidden by default(negative).
    Given the user click on the filter button
    When the user log out and log in again
    Then verify Manage Filter button is hidden


  @AC2
  Scenario: When a user clicks on the filter icon, the "Manage Filter" button should be visible
    When the user click on the filter button
    Then verify Manage Filter button is displayed


  @AC3
  Scenario Outline:User can apply filters by clicking on the filter name, from the 'Manage Filters' menu.
    Given the user click on the filter button
    And the user click on manage filter button
    When the user click on "<option>"
    Then the "<option>" should be selected
    Examples:
      | option                   |
      | LicensePlate             |
      | Tags                     |
      | Driver                   |
      | Location                 |
      | ChassisNumber            |
      | ModelYear                |
      | LastOdometer             |
      | ImmatriculationDate      |
      | FirstContractDate        |
      | Catalog Value(VAT Incl.) |
      | SeatsNumber              |
      | DoorsNumber              |
      | Color                    |
      | Transmission             |
      | FuelType                 |
      | CO2Emissions             |
      | Horsepower               |
      | HorsepowerTaxation       |
      | Power(KW)                |

  @AC4
  Scenario Outline:User can see the corresponding filter option after typing the filter name on the filter input box, from the 'Manage Filters' menu.
    Given the user click on the filter button
    And the user click on manage filter button
    When the user types "<wordsToSearch>" on the filter input box
    Then verify  "<wordsToSearch>" filter option is displayed
    Examples:
      | wordsToSearch |
      | Tags          |
      | Location      |
      | Color         |
      | Horsepower    |
      | Transmission  |

 @AC5
 Scenario: User can apply multiple filters at the same time by selecting filter name check boxes.
   Given the user click on the filter button
   And the user click on manage filter button
   When the user click on "Tags" ,"Location" , "Driver"
   Then Verify that "Tags", "Location" and "Driver" options are selected








