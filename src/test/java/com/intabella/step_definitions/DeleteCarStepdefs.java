package com.intabella.step_definitions;

import com.intabella.pages.GeneralInformationPage;
import com.intabella.pages.VehiclesPage;
import com.intabella.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeleteCarStepdefs {
    String totalRecords="";
    @When("the user hovering over the three dots at the end of each row")
    public void the_user_hovering_over_the_three_dots_at_the_end_of_each_row() throws InterruptedException {

        BrowserUtils.hover(new VehiclesPage().threeDot);
        BrowserUtils.waitFor(3);
        BrowserUtils.clickWithJS(new VehiclesPage().threeDot);

    }


    @Then("the user can see the delete button")
    public void the_user_can_see_the_delete_button() {
        Assert.assertTrue( new VehiclesPage().deleteButton.get(new VehiclesPage().deleteButton.size()-1).isDisplayed());

    }

    @When("the user clicks on the delete button")
    public void the_user_clicks_on_the_delete_button() {
        new VehiclesPage().deleteButton.get(new VehiclesPage().deleteButton.size()-1).click();
    }


    @Then("the Delete Confirmation pop up should be displayed")
    public void the_Delete_Confirmation_pop_up_should_be_displayed() {
        Assert.assertTrue(new VehiclesPage().popUp.isDisplayed());
    }

    @When("the user confirms delete")
    public void the_user_confirms_delete() {
        new VehiclesPage().yesDeleteButton.click();
    }


    @Then("item deleted message should be displayed")
    public void item_deleted_message_should_be_displayed() {
        Assert.assertTrue(new VehiclesPage().itemDeleted.isDisplayed());
    }

    @When("Store Manager clicks on any vehicle row")
    public void store_Manager_clicks_on_any_vehicle_row() {
        totalRecords=new VehiclesPage().totalRecords.getText();
        new VehiclesPage().location.click();

    }


    @When("store manager goes to the General Information page")
    public void store_manager_goes_to_the_General_Information_page() {

        BrowserUtils.waitForPageToLoad(10);
        String expectedPageSubtitle="General Information";
        String actualPageSubtitle=  new GeneralInformationPage().generalInfo.getText();
        Assert.assertEquals(actualPageSubtitle,expectedPageSubtitle);

    }
    @When("store manager deletes any vehicle by clicking on the Delete button")
    public void store_manager_deletes_any_vehicle_by_clicking_on_the_Delete_button() {
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.clickWithJS(new GeneralInformationPage().deleteButton);
        BrowserUtils.clickWithJS(new GeneralInformationPage().yesDeleteButton);

    }
    @Then("the Car deleted message should be displayed.")
    public void the_Car_deleted_message_should_be_displayed() {
       Assert.assertTrue(new GeneralInformationPage().carDeleted.isDisplayed());

    }
    @Then("the car should be removed from the vehicle page")
    public void the_car_should_be_removed_from_the_vehicle_page() {
        String actualTotalRecords=new VehiclesPage().totalRecords.getText();
        Assert.assertNotEquals(actualTotalRecords,totalRecords);

    }


}
