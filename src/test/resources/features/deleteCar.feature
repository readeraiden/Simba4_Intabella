Feature: Delete a Car
@INTA-1223
  Scenario: Delete Button displayed
    When the user hovering over the three dots at the end of each row
    Then the user can see the delete button
  @INTA-1224
    Scenario: Delete Confirmation pop up
      When the user hovering over the three dots at the end of each row
      And the user clicks on the delete button
      Then the Delete Confirmation pop up should be displayed
  @INTA-1225
    Scenario: Item Deleted message
      When the user hovering over the three dots at the end of each row
      And the user clicks on the delete button
      And the user confirms delete
      Then item deleted message should be displayed
  @INTA-1226
  Scenario: Car deleted message
    When Store Manager clicks on any vehicle row
    And store manager goes to the General Information page
    And store manager deletes any vehicle by clicking on the Delete button
    Then the Car deleted message should be displayed.
  @INTA-1227
    Scenario: Deleted car remove
      When Store Manager clicks on any vehicle row
      And store manager goes to the General Information page
      And store manager deletes any vehicle by clicking on the Delete button
      Then the car should be removed from the vehicle page