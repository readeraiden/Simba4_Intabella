@nezihe
Feature: Vehicle Table Arrangements

  @US004_AC1
  Scenario: "View Per Page" button should be "25" by default.
    Then verify Manage Filter button is "25" by default.


  @US004_AC2
  Scenario: "View Per Page" button includes values
    Given the user click on the view per page button
    Then the user click on view per page button  values should be "10", "25","50","100"


  @US004_AC3.1
  Scenario: The user arrange number of rows by clicking the options from dropdown menu one after another with the same open browser
    When the user click "10" from drop down menu
    Then verify that the user able to see only "10" rows from table
    When the user click "25" from drop down menu
    Then verify that the user able to see only "25" rows from table
    When the user click "50" from drop down menu
    Then verify that the user able to see only "50" rows from table
    When the user click "100" from drop down menu
    Then verify that the user able to see only "100" rows from table


  @US004_AC3.2
  Scenario Outline: The user arrange number of rows by clicking the options from dropdown menu with the different browsers
    Given the user click on the view per page button
    Then the user click "<options>" from drop down menu
    And verify that the user able to see only "<options>" rows from the table
    Examples:
      | options |
      | 10      |
    #  | 25      |
      | 50      |
      | 100     |


  @US004_AC4
  Scenario Outline: Sort a column in ascending or descending order
    When the user click "<columName>" column  from table
    Then the column is sorted by "ascending" order
    When the user click "<columName>" column  from table
    Then the column is sorted by "descending" order

    Examples:
      | columName           |
      | LicensePlate        |
      | Tags                |
      | Driver              |
      | Location            |
      | ChassisNumber       |
      | ModelYear           |
      | LastOdometer        |
      | ImmatriculationDate |
      | FirstContractDate   |
      | CatalogValue        |
      | SeatsNumber         |
      | DoorsNumber         |
      | Color               |
      | Transmission        |
      | FuelType            |
      | CO2Emissions        |
      | Horsepower          |
      | HorsepowerTaxation  |
      | Power               |


  @US004_AC5
  Scenario: Remove all sortings and filter by using "Reset" button
    Given the user click on "ModelYear" colum from table
    When the user click on reset button
    Then verify that the list is not sorted by "ModelYear"


