package com.intabella.step_definitions;

import com.intabella.pages.VehiclesPage;
import com.intabella.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class LasOdometerStepDefs {

    @Then("the user should be select {string}")
    public void the_user_should_be_select(String option) {
        List<String> actualOptions = BrowserUtils.getElementsText(new VehiclesPage().filterOptions);
        String odometerOption = actualOptions.get(6);
        Assert.assertEquals("the list doesn't contain \"Last Odometer\" option",odometerOption,option);

       VehiclesPage vehiclesPage=new VehiclesPage();
       vehiclesPage.lastOdometer.click();

    }


}
