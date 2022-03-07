package com.intabella.step_definitions;

import com.intabella.pages.VehiclesPage;
import com.intabella.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class LasOdometerStepDefs {
    VehiclesPage vehiclesPage=new VehiclesPage();

    @And("the user click on between button")
    public void theUserClickOnBetweenButton() {
        vehiclesPage.lastOdometerBetween.click();

    }

    @Then("Last Odometer filter should provide the {string}")
    public void lastOdometerFilterShouldProvideThe(String methods) {

        List<String> actualmethods = BrowserUtils.getElementsText(vehiclesPage.methodOptions);
        Assert.assertEquals("the list doesn't contain "+methods+" option","["+methods+"]",actualmethods.toString());
    }

    @And("the user click on Last Odometer All button")
    public void theUserClickOnLastOdometerAllButton() {
        vehiclesPage.lastOdometerAllbtn.click();
    }

    @And("the user click on {string} method")
    public void theUserClickOnMethod(String method) {
        vehiclesPage.filterTypeLocators(method).click();
        BrowserUtils.waitFor(2);
    }

    @Then("the results should be between the specified values")
    public void theResultsShouldBeBetweenTheSpecifiedValues() {
        String start ="1000";
        String end = "3000";
        vehiclesPage.filterStart.click();
        BrowserUtils.waitFor(2);
        vehiclesPage.filterStart.sendKeys(start);
        vehiclesPage.filterEnd.click();
        vehiclesPage.filterEnd.sendKeys(end);
      //  List<String> actualmethods = BrowserUtils.get;
        vehiclesPage.updateBtn.click();

    }
}
