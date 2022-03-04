package com.intabella.step_definitions;

import com.intabella.pages.VehiclesPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FilterMenuStepDefs {

    VehiclesPage vehiclesPage = new VehiclesPage();

    @Given("the user click on the filter button")
    public void theUserClickOnTheFilterButton() {
        BrowserUtils.waitForPageToLoad(10);
        vehiclesPage.filterIconClick();
        BrowserUtils.waitFor(2);
       // Driver.get().findElement(By.cssSelector("i.fa-filter.hide-text")).click();
    }

    @When("the user click on manage filter button")
    public void the_user_click_on_manage_filter_button() {
        BrowserUtils.waitFor(3);
        vehiclesPage.manageFilters.click();

    }

    @Then("verify Manage Filter button is hidden")
    public void verifyManageFilterButtonIsHidden() {

        Assert.assertFalse(new VehiclesPage().manageFilters.isDisplayed());
    }

    @Then("verify Manage Filter button is displayed")
    public void verifyManageFilterButtonIsDisplayed() {
        Assert.assertTrue(new VehiclesPage().manageFilters.isDisplayed());
    }
}

