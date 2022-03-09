Feature: Delete a Car

  Scenario: Delete Button displayed
    When the user hovering over the three dots at the end of each row
    Then the user can see the delete button

    Scenario: Delete Confirmation pop up
      When the user hovering over the three dots at the end of each row
      And the user clicks on the delete button
      Then the Delete Confirmation pop up should be displayed

    Scenario: Item Deleted message
      When the user hovering over the three dots at the end of each row
      And the user clicks on the delete button
      And the user confirms delete
      Then item deleted message should be displayed

  Scenario: Car deleted message
    When Store Manager clicks on any vehicle row
    And store manager goes to the General Information page
    And store manager deletes any vehicle by clicking on the Delete button
    Then the Car deleted message should be displayed.
  @wips
    Scenario: Deleted car remove
      When Store Manager clicks on any vehicle row
      And store manager goes to the General Information page
      And store manager deletes any vehicle by clicking on the Delete button
      Then the car should be removed from the vehicle page