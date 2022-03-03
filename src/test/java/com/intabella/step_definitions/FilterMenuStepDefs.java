package com.intabella.step_definitions;

import com.intabella.pages.VehiclesPage;
import com.intabella.utilities.BrowserUtils;
import com.intabella.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class FilterMenuStepDefs {

    VehiclesPage vehiclesPage = new VehiclesPage();

    @Given("the user click on the filter button")
    public void theUserClickOnTheFilterButton() {
        BrowserUtils.waitForPageToLoad(5);
        vehiclesPage.filterIconClick();
       // Driver.get().findElement(By.cssSelector("i.fa-filter.hide-text")).click();
    }

    @When("the user click on manage filter button")
    public void the_user_click_on_manage_filter_button() {
        BrowserUtils.waitFor(3);
        vehiclesPage.manageFilters.click();

    }
}
