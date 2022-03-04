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



