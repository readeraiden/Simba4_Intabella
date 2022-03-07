package com.intabella.step_definitions;

import com.intabella.pages.VehiclesPage;
import com.intabella.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class ChassisNumberStepDefs {
    VehiclesPage vehiclesPage=new VehiclesPage();

    @When("the user click on Chassis Number All button")
    public void the_user_click_on_Chassis_Number_All_button() {
        vehiclesPage.chassisNumberAllbutton.click();
    }

    @Then("Chassis Number filter should provide the {string}")
    public void chassisNumberFilterShouldProvideThe(String methods) {

        BrowserUtils.waitFor(3);
        List<String> actualmethods = BrowserUtils.getElementsText(vehiclesPage.methodOptionsChassis);
        Assert.assertEquals("the list doesn't contain "+methods+" option","["+methods+"]",actualmethods.toString());
    }
}
