
Feature: Add Event Functionality - Store Manager
	@INTA-1165 @INTA-1163
	Scenario: US005-AC1-Verify that Store Manager can access "General Information" page by clicking on any vehicle/row
		Given User clicks on any vehicle	

	@INTA-1166 @INTA-1163
	Scenario: US005-AC2-Verify that Store Manager can click the "Add Event" button
		Given User clicks on any vehicle
		Then User clicks on Add Event button	

	@INTA-1167 @INTA-1163
	Scenario: US005-AC3-Verify that "Add Event" page is popped up after clicking on the "Add event" button
		Given User clicks on any vehicle
		When User clicks on Add Event button
		Then the Add Event page should pop up	

	@INTA-1168 @INTA-1163
	Scenario: US005-AC4-Verify that Compulsory fields are shown
		Given User clicks on any vehicle
		    When User clicks on Add Event button
		    Then  Compulsory fields should be as below
		      | Title                  |
		      | Owner                  |
		      | Organizer display name |
		      | Organizer email        |
		      | Start                  |
		      | End                    |	

	@INTA-1169 @INTA-1163
	Scenario: US005-AC5-Verify that "This value should not be blank." message is displayed after clicking on the save button If any compulsory field is not filled
		Given User clicks on any vehicle
		    When User clicks on Add Event button
		    And If any compulsory field is not filled
		    When User clicks on the save button
		    Then "This value should not be blank." message should be displayed