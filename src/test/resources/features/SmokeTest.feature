@INTA-1232
Feature: Default

#Add Smoke Test 2
	@INTA-1165 @INTA-1163
	Scenario: US005-AC1-Verify that Store Manager can access "General Information" page by clicking on any vehicle/row
		Given User clicks on any vehicle	



	@INTA-1147 @INTA-1146
	Scenario: US09-AC01-TC01(Fethullah)"Manage Filter" button should be hidden by default.
		Then verify Manage Filter button is hidden	


	@INTA-1223
	Scenario: USAC1- Users can see the delete button by hovering over the three dots at the end of each row
		When the user hovering over the three dots at the end of each row
		    Then the user can see the delete button