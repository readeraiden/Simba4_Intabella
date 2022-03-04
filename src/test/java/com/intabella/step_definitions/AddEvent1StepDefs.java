package com.intabella.step_definitions;

import com.intabella.pages.CreateCarPage;
import com.intabella.pages.VehiclesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEvent1StepDefs {
    CreateCarPage createCarPage=new CreateCarPage();


    @Given("User clicks on any vehicle")
    public void userClicksOnAnyVehicle() {
        createCarPage.row2.click();
    }

    @When("User clicks on {string} button")
    public void user_clicks_on_button(String string) {

    }

    @Then("the {string} page should pop up")
    public void the_page_should_pop_up(String string) {

    }

    @Then("Compulsory fields should be seen as below")
    public void compulsory_fields_should_be_seen_as_below(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

    }

    @When("User clicks on the save button")
    public void user_clicks_on_the_save_button() {

    }

    @When("If any compulsory field is not filled")
    public void if_any_compulsory_field_is_not_filled() {


    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String string) {


    }


}