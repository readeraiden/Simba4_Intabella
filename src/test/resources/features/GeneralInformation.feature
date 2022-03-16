
Feature: General Information Table
  Scenario: User can see General Information Page
    When the user clicks "1" from "Driver"
    Then the user can see the General Information page

    Scenario:  User can see the "General Information" page clicking on the "Eye (View)" icon
      When the user clicks at the end row three points
      And  user clicks eye icon
      Then the user can see the General Information page

      Scenario: User should see "Edit", "Delete" and "Add Event" buttons on the "General Information" page
        When the user clicks at the end row three points
        And  user clicks eye icon
        Then Edit, Delete and Add Event buttons will be displayed

  Scenario Outline: Vehicle information displayed on the "General Information" page and "Fleet-Vehicle" page should be the same
    Then check and store all information of <rowNumber> .row
    When the user clicks "1" from "Driver"
    Then verify the all information are all same for both pages
    Examples:
      | rowNumber |
      | 1         |

