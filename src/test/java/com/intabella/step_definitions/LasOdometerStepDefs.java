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
}
