package com.intabella.step_definitions;

import com.intabella.pages.VehiclesPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.tr.Ve;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

public class DeleteCarStepdefs {
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

}
